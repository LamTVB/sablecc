/* This file is part of SableCC ( http://sablecc.org ).
 *
 * See the NOTICE file distributed with this work for copyright information.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.sablecc.objectmacro.codegeneration.java;

import java.io.File;
import java.util.*;

import org.sablecc.exception.InternalException;
import org.sablecc.objectmacro.codegeneration.IntermediateRepresentation;
import org.sablecc.objectmacro.codegeneration.java.macro.*;
import org.sablecc.objectmacro.codegeneration.java.structure.SMacro;
import org.sablecc.objectmacro.intermediate.macro.MDirective;
import org.sablecc.objectmacro.intermediate.macro.MParam;
import org.sablecc.objectmacro.intermediate.macro.MParamInsert;
import org.sablecc.objectmacro.intermediate.syntax3.analysis.DepthFirstAdapter;
import org.sablecc.objectmacro.intermediate.syntax3.node.*;

public class CodeGenerationWalker
        extends
        DepthFirstAdapter {

    private final IntermediateRepresentation ir;

    private final File packageDirectory;

    /**
     * List of macros in the file
     */
    private final Map<String, SMacro> macros;

    /**
     * Object Macro with name and list of internals and parameters
     */
    private SMacro currentMacro;

    /**
     * Current parameter name
     */
    private String currentParamName;

    /**
     * Macro representing the super class Macro
     */
    private MSuperMacro superMacro;

    /**
     * Macro representing an internal initializer super class
     */
    private MInternalsInitializer mInternalsInitializer;

    /**
     * Macro representing the class macro
     */
    private MMacro currentMacroToBuild;

    /**
     * Macro representing the constructor of a macro
     */
    private MConstructor currentConstructor;

    /**
     * Macro representing the method builder
     */
    private MMacroBuilder currentMacroBuilder;

    /**
     * Macro representing the apply internal initializer inside the method init
     * internals
     */
    private MApplyInternalsInitializer currentApplyInitializer;

    /**
     * Index of the current builder to avoid creating 2 StringBuilder of the
     * same name
     */
    private Integer indexBuilder = 0;

    /**
     * Index of the current builder to avoid creating 2 macro objects for
     * inserts of the same name
     */
    private Integer indexInsert = 0;

    /**
     * Created StringBuilders in the children of a AParameter node or AInternal
     * node This list is reset in the internal or parameter node's out
     */
    private Set<Integer> createdBuilders = new LinkedHashSet<>();

    /**
     * Created macro objects for inserts in the children of a AParameter node or
     * AInternal node This list is reset in the internal or parameter node's out
     */
    private List<Integer> createdInserts = new ArrayList<>();

    /**
     * Name of the current macro which is referenced
     */
    private String currentMacroRefName;

    /**
     * Name of the current context
     */
    private String currentContextName;

    /**
     * Names of all contexts created for the current Macro
     */
    private Set<String> contextNames = new HashSet<>();

    /**
     * Macro representing a parameter's builder
     */
    private MParamMacroRefBuilder currentParamMacroRefBuilder;

    /**
     * Boolean to test whether the macro has or does not have internals
     */
    private boolean currentMacroHasInternals;

    /**
     * Macro representing the package to use in other Macro
     */
    private MPackageDeclaration currentPackageDeclaration;

    private MMacroFactory macroFactory;

    private MSwitchVersion currentSwitchVersion;

    private MMacroCreatorMethod currentMacroCreatorMethod;

    private final Set<TString> versions = new HashSet<>();

    private List<Integer> currentlyUsed = new LinkedList<>();

    private Set<String> createdFactoryMethods = new HashSet<>();

    private boolean currentMacroIsAllVersionned = false;

    private boolean currentMacroIsAbstract = false;

    private List<Macro> tempMacros = null;

    CodeGenerationWalker(
            IntermediateRepresentation ir,
            File packageDirectory,
            Map<String, SMacro> macros) {

        this.ir = ir;
        this.packageDirectory = packageDirectory;
        this.macros = macros;
    }

    private Macro evalMacro(
            Node node){

        this.tempMacros = new LinkedList<>();
        node.apply(this);
        return this.tempMacros.get(0);
    }

    private List<Macro> evalMacros(
            Node node){

        this.tempMacros = new LinkedList<>();
        node.apply(this);
        List<Macro> result_macros = this.tempMacros;
        this.tempMacros = null;
        return result_macros;
    }

    @Override
    public void inAIntermediateRepresentation(
            AIntermediateRepresentation node) {

        this.superMacro = new MSuperMacro();
        this.mInternalsInitializer = new MInternalsInitializer();
        this.macroFactory = new MMacroFactory();
        MVersionEnumeration mVersionEnumeration = new MVersionEnumeration();

        if (!this.ir.getDestinationPackage().equals("")) {
            String destinationPackage = this.ir.getDestinationPackage();
            this.currentPackageDeclaration = new MPackageDeclaration(
                    destinationPackage);
            this.superMacro
                    .addPackageDeclaration(this.currentPackageDeclaration);
            this.mInternalsInitializer
                    .addPackageDeclaration(this.currentPackageDeclaration);
            this.macroFactory
                    .addPackageDeclaration(this.currentPackageDeclaration);

            mVersionEnumeration.addPackageDeclaration(this.currentPackageDeclaration);
        }
        boolean first = true;

        for(TString version : node.getVersions()){
            String version_name = GenerationUtils.string(version).toUpperCase();
            if(first){
                this.macroFactory.addDefaultVersion(new MVersion(version_name));
                first = false;
            }

            mVersionEnumeration.addVersions(new MPlainText(version_name));
            versions.add(version);
        }

        GenerationUtils.writeFile(this.packageDirectory,
                "VERSIONS.java",
                mVersionEnumeration.build());
    }

    @Override
    public void outAIntermediateRepresentation(
            AIntermediateRepresentation node) {

        GenerationUtils.writeFile(this.packageDirectory, "Macro.java",
                this.superMacro.build());
        GenerationUtils.writeFile(this.packageDirectory,
                "InternalsInitializer.java",
                this.mInternalsInitializer.build());

        GenerationUtils.writeFile(this.packageDirectory,
                "Macros.java",
                this.macroFactory.build());
    }

    @Override
    public void caseAMacro(
            AMacro node) {

        this.currentMacroIsAbstract = node.getIsAbstract() != null;
        this.currentMacroIsAllVersionned = node.getIsAllVersionned() != null;

        if(this.currentMacroIsAbstract){
            inAMacro(node);

            for(PParam parameter : node.getParams()){
                parameter.apply(this);
            }

            outAMacro(node);
        }
        else {
            super.caseAMacro(node);
        }
    }

    @Override
    public void inAMacro(
            AMacro node) {

        String macro_name = GenerationUtils.buildNameCamelCase(node.getNames());
        if (!this.macros.containsKey(macro_name)) {
            throw new InternalException(macro_name + " does not exist");
        }

        String parent_name = null;
        if(node.getParent() != null){
            parent_name = GenerationUtils.buildNameCamelCase(node.getParent());
        }

        this.currentMacro = this.macros.get(macro_name);
        this.currentMacroToBuild = this.currentMacro.getMacro();
        this.contextNames = new HashSet<>();

        if (this.currentMacroToBuild == null) {
            throw new InternalException(
                    "currentMacroToBuild cannot be null here");
        }

        if (this.currentPackageDeclaration != null) {
            this.currentMacroToBuild
                    .addPackageDeclaration(this.currentPackageDeclaration);
        }

        if(!this.createdFactoryMethods.contains(macro_name)
                && !this.createdFactoryMethods.contains(parent_name)){

            String method_class_name;
            if(this.currentMacroIsAbstract
                    || this.currentMacroIsAllVersionned){

                method_class_name = macro_name;
            }
            else {
                method_class_name = parent_name;
            }

            this.createdFactoryMethods.add(method_class_name);
            this.currentMacroCreatorMethod = new MMacroCreatorMethod(method_class_name);
            this.macroFactory.addNewMacroMethods(this.currentMacroCreatorMethod);

            if(!this.currentMacroIsAllVersionned){
                this.currentSwitchVersion = new MSwitchVersion();
                this.currentMacroCreatorMethod.addVersionFactory(this.currentSwitchVersion);
            }
        }

        if(!this.currentMacroIsAllVersionned){
            for(TString version : node.getVersions()){
                String version_name = GenerationUtils.string(version).toUpperCase();
                this.currentSwitchVersion.addVersionCases(new MMacroCaseInit(version_name, macro_name));
            }
        }

        this.currentConstructor = new MConstructor();
        this.currentMacroToBuild.addConstructor(this.currentConstructor);

        if(this.currentMacroIsAbstract){
            this.currentMacroToBuild.addAbstract(new MAbstract());
        }
        else {
            this.currentMacroBuilder = new MMacroBuilder(macro_name);
            this.currentMacroToBuild.addMacroBuilder(this.currentMacroBuilder);
            this.currentMacroToBuild.addInitMacrosMethod(new MSetMacrosMethod());
            this.currentConstructor.addFieldInitializers(new MSetMacrosCall());

            this.mInternalsInitializer
                    .addParentInternalSetters(new MParentInternalsSetter(macro_name));
            this.currentMacroToBuild.addRedefinedApplyInitializer(
                    new MRedefinedApplyInitializer());
        }

        if(!this.currentMacroIsAbstract
                && !this.currentMacroIsAllVersionned){
            this.currentConstructor.addSuper(new MSuperCall());
        }

        this.currentMacroHasInternals = node.getInternals().size() > 0;

        if (this.currentMacroHasInternals) {
            // method build is package protected so a context parameter to build
            // the current macro
            this.currentMacroBuilder.addContextParam(new MContextParam());
            this.currentMacroBuilder
                    .addContextBuildState(new MContextBuildState());
            this.currentMacroBuilder.addNewBuildState(new MNewBuildState());
        }
        else {
            if(!this.currentMacroIsAbstract){
                this.currentMacroToBuild
                        .addEmptyBuilderWithContext(new MEmptyBuilderWithContext());
            }
        }
    }

    @Override
    public void outAMacro(
            AMacro node) {

        if(!this.currentMacroIsAbstract){
            this.currentConstructor.addParameters(new MMacrosParam());
        }

        String macroName = GenerationUtils.buildNameCamelCase(node.getNames());
        GenerationUtils.writeFile(this.packageDirectory,
                "M" + macroName + ".java", this.currentMacroToBuild.build());

        this.contextNames = null;
        this.currentMacroToBuild = null;
        this.currentMacroBuilder = null;
        this.currentConstructor = null;
        this.currentMacro = null;
        this.currentMacroHasInternals = false;
        this.indexBuilder = 0;
        this.currentlyUsed = new LinkedList<>();
    }

    @Override
    public void caseAInternal(
            AInternal node) {

        String paramName = GenerationUtils.buildNameCamelCase(node.getNames());

        if (node.getType() instanceof AStringType) {
            this.currentMacroToBuild
                    .addFields(new MInternalStringField(paramName));
            this.currentMacroToBuild
                    .addSetters(new MInternalStringSetter(paramName));

            MParamStringRefBuilder mParamStringRefBuilder = new MParamStringRefBuilder(
                    paramName);
            this.currentMacroToBuild.addBuilders(mParamStringRefBuilder);
            mParamStringRefBuilder.addContextParam(new MContextParam());
            mParamStringRefBuilder.addGetInternalTail(new MGetInternalTail());

            MParamStringRef mParamStringRef = new MParamStringRef(paramName);
            this.currentMacroToBuild.addGetters(mParamStringRef);
            mParamStringRef.addContextParam(new MContextParam());
            mParamStringRef.addGetInternalTail(new MGetInternalTail());
        }
        else if (node.getType() instanceof AMacroRefsType) {
            this.currentMacroToBuild
                    .addFields(new MInternalMacroField(paramName));

            this.currentMacroToBuild
                    .addBuilders(new MInternalMacroRefBuilder(paramName));
            this.currentMacroToBuild
                    .addGetters(new MInternalMacroRef(paramName));

            this.indexBuilder = 0;
            this.currentMacroToBuild
                    .addSetters(new MInternalMacroSetter(paramName));
        }
        else {
            throw new InternalException("case unhandled");
        }
        node.getType().apply(this);
        outAInternal(node);
    }

    @Override
    public void outAInternal(
            AInternal node) {

        this.currentContextName = null;
        this.currentApplyInitializer = null;
        this.indexBuilder = 0;
        this.indexInsert = 0;
        this.currentParamMacroRefBuilder = null;
        this.createdBuilders = new LinkedHashSet<>();
        this.createdInserts = new ArrayList<>();
        this.currentlyUsed = new LinkedList<>();
    }

    @Override
    public void caseAParam(
            AParam node) {

        String param_name = this.currentParamName = GenerationUtils
                .buildNameCamelCase(node.getNames());

        MStringParam mStringParam = new MStringParam(param_name);
        MParamArg mParamArg = new MParamArg(param_name);

        if (node.getType() instanceof AStringType) {

            if(this.currentMacroIsAbstract
                    || this.currentMacroIsAllVersionned){

                this.currentMacroToBuild
                        .addFields(new MParamStringField(param_name));
                this.currentMacroToBuild
                        .addBuilders(new MParamStringRefBuilder(param_name));
                this.currentMacroToBuild.addGetters(new MParamStringRef(param_name));
                this.currentMacroCreatorMethod.addParameters(mStringParam);
                this.currentMacroCreatorMethod.addArgs(mParamArg);
            }

            if(!this.currentMacroIsAbstract){
                MParamStringSetter mParamStringSetter = new MParamStringSetter(
                        param_name);
                mParamStringSetter.addParamArg(mParamArg);
                mParamStringSetter.addStringParam(mStringParam);

                this.currentMacroToBuild.addSetters(mParamStringSetter);

                MSetParam mSetParam = new MSetParam(param_name);
                mSetParam.addSetParam(mParamArg);

                this.currentConstructor.addFieldInitializers(mSetParam);
                this.currentConstructor.addParameters(mStringParam);
            }
        }
        else if (node.getType() instanceof AMacroRefsType) {

            this.currentParamMacroRefBuilder = new MParamMacroRefBuilder(
                    param_name);

            if(this.currentMacroIsAbstract
                    || this.currentMacroIsAllVersionned){

                this.currentMacroToBuild.addFields(new MParamMacroField(param_name));

                this.currentMacroToBuild.addGetters(new MParamMacroRef(param_name));

                this.currentConstructor
                        .addFieldInitializers(new MInitMacroParam(param_name));
                this.currentConstructor.addInternalValuesInitializers(
                        new MInitInternalValue(param_name));

                this.currentContextName = param_name
                        .concat(GenerationUtils.CONTEXT_STRING);
            }

            if(!this.currentMacroIsAbstract) {

                this.currentMacroToBuild
                        .addBuilders(this.currentParamMacroRefBuilder);
                this.currentParamMacroRefBuilder.addContextName(new MPlainText(
                        param_name.concat(GenerationUtils.CONTEXT_STRING)));

                this.currentMacroToBuild.addFields(new MDirectiveFields(param_name));
                MInitDirectives mInitDirectives = new MInitDirectives(param_name);
                this.currentMacroToBuild
                        .addInitDirectives(mInitDirectives);

                for (PDirective directive : node.getDirectives()) {
                    Macro result_macro = evalMacro(directive);

                    if(result_macro instanceof MNewDirective){
                        mInitDirectives.addNewDirectives((MNewDirective) result_macro);
                    }
                    else {
                        throw new InternalException("case unhandled");
                    }
                }

                this.indexBuilder = 0;

                MInitInternalsCall mInitInternalsCall = new MInitInternalsCall(
                        param_name);

                this.currentMacroBuilder.addInternalsCalls(mInitInternalsCall);
                this.currentMacroBuilder
                        .addDirectivesCalls(new MInitDirectiveCall(param_name));

                this.currentContextName = param_name
                        .concat(GenerationUtils.CONTEXT_STRING);

                if (!this.contextNames.contains(this.currentContextName)) {
                    this.contextNames.add(this.currentContextName);
                }

                this.currentApplyInitializer = new MApplyInternalsInitializer();

                MInitInternalsMethod mInitInternalsMethod = new MInitInternalsMethod(
                        param_name);
                mInitInternalsMethod
                        .addApplyInternalsInitializer(
                                this.currentApplyInitializer);
                this.currentMacroToBuild
                        .addInitInternalsMethods(mInitInternalsMethod);


                if (this.currentMacroHasInternals) {
                    mInitInternalsCall.addContextArg(new MContextArg());
                }
            }
        }
        else {
            throw new InternalException("case unhandled");
        }

        node.getType().apply(this);
        outAParam(node);
    }

    @Override
    public void outAParam(
            AParam node) {

        this.currentParamName = null;
        this.currentContextName = null;
        this.currentApplyInitializer = null;
        this.indexBuilder = 0;
        this.indexInsert = 0;
        this.createdBuilders = new LinkedHashSet<>();
        this.createdInserts = new ArrayList<>();
        this.currentlyUsed = new LinkedList<>();
        this.currentParamMacroRefBuilder = null;
    }

    @Override
    public void caseADirective(
            ADirective node) {

        String directive_name = GenerationUtils
                .buildNameCamelCase(node.getNames());

        do{
            this.indexBuilder++;
        }
        while(this.createdBuilders.contains(this.indexBuilder));

        this.currentlyUsed.add(this.indexBuilder);
        this.createdBuilders.add(this.indexBuilder);
        MNewDirective mNewDirective = new MNewDirective(directive_name,
                this.indexBuilder.toString());

        this.tempMacros.add(mNewDirective);
        List<Macro> temp = this.tempMacros;

        for(PTextPart text_part : node.getParts()){
            Macro macro_found = evalMacro(text_part);

            if (macro_found instanceof MEolPart) {
                mNewDirective.addTextParts((MEolPart) macro_found);
            }
            else if (macro_found instanceof MStringPart) {
                mNewDirective.addTextParts((MStringPart) macro_found);
            }
            else if (macro_found instanceof MParamInsertPart) {
                mNewDirective.addTextParts((MParamInsertPart) macro_found);
            }
            else if (macro_found instanceof MInsertMacroPart) {
                mNewDirective.addTextParts((MInsertMacroPart) macro_found);
            }
            else {
                throw new InternalException("case unhandled");
            }
        }

        this.tempMacros = temp;
    }

    @Override
    public void caseAMacroRef(
            AMacroRef node) {

        String macro_ref_name = this.currentMacroRefName = GenerationUtils
                .buildNameCamelCase(node.getNames());
        SMacro referenced_macro = this.macros.get(macro_ref_name);

        if(this.currentContextName == null){
            super.caseAMacroRef(node);
        }
        else{
            Set<String> referenced_macros = new HashSet<>();

            if(this.currentMacroIsAllVersionned){
                if(referenced_macro.getChildren().size() == 0){
                    referenced_macros.add(macro_ref_name);
                }
            }
            else if(!this.currentMacroIsAbstract) {
                for(String version : this.currentMacro.getApplied_versions()){
                    String macro_name = referenced_macro.getChildByVersion(version);

                    if(macro_name != null){
                        referenced_macros.add(macro_name);
                    }
                }
            }

            for(String child : referenced_macros){
                this.currentMacroRefName = child;
                MRedefinedInternalsSetter mRedefinedInternalsSetter = new MRedefinedInternalsSetter(
                        child);
                this.currentApplyInitializer.addRedefinedInternalsSetter(
                        mRedefinedInternalsSetter);

                if(node.getArgs() != null){
                    for(PValue value : node.getArgs()){
                        List<Macro> macros_found = evalMacros(value);

                        for(Macro macro : macros_found){
                            if(macro instanceof MEolPart){
                                mRedefinedInternalsSetter.addTextParts((MEolPart) macro);
                            }
                            else if(macro instanceof MInsertMacroPart){
                                mRedefinedInternalsSetter.addTextParts((MInsertMacroPart) macro);
                            }
                            else if(macro instanceof MInitStringBuilder){
                                mRedefinedInternalsSetter.addTextParts((MInitStringBuilder) macro);
                            }
                            else if(macro instanceof MStringPart){
                                mRedefinedInternalsSetter.addTextParts((MStringPart) macro);
                            }
                            else if(macro instanceof MParamInsertPart){
                                mRedefinedInternalsSetter.addTextParts((MParamInsertPart) macro);
                            }
                            else if(macro instanceof MSetInternal) {
                                mRedefinedInternalsSetter.addSetInternals((MSetInternal) macro);
                            }
                            else{
                                throw new InternalException("case unhandled");
                            }
                        }
                    }
                }
            }

            if(this.currentMacroIsAbstract
                    || this.currentMacroIsAllVersionned){

                MSingleAdd mSingleAdd = new MSingleAdd(macro_ref_name,
                        this.currentParamName);
                this.currentMacroToBuild.addSetters(mSingleAdd);
                if (!this.currentMacroHasInternals) {
                    mSingleAdd.addIsBuilt(new MIsBuilt());
                }
            }

        }
    }

    @Override
    public void outAMacroRef(
            AMacroRef node) {

        this.currentMacroRefName = null;
    }

    @Override
    public void caseAStringValue(
            AStringValue node) {

        String context_name = String.valueOf(this.currentContextName);

        do{
            this.indexBuilder++;
        }
        while(this.createdBuilders.contains(this.indexBuilder));

        this.currentlyUsed.add(this.indexBuilder);
        this.createdBuilders.add(this.indexBuilder);
        this.tempMacros.add(new MInitStringBuilder(this.indexBuilder.toString()));

        for (PTextPart part : node.getParts()) {
            part.apply(this);
        }

        this.indexBuilder = this.currentlyUsed.remove(this.currentlyUsed.size() - 1);

        MSetInternal mSetInternal = new MSetInternal(
                GenerationUtils.buildNameCamelCase(node.getParamName()),
                context_name);
        this.tempMacros.add(mSetInternal);
        mSetInternal.addSetParams(new MStringBuilderBuild(this.indexBuilder.toString()));
    }

    @Override
    public void caseAStringTextPart(
            AStringTextPart node) {

        this.tempMacros.add(new MStringPart(
                GenerationUtils.escapedString(node.getString()),
                String.valueOf(this.indexBuilder)));

    }

    @Override
    public void caseAVarTextPart(
            AVarTextPart node) {

        String index_builder = String.valueOf(this.indexBuilder);
        String param_name = GenerationUtils.buildNameCamelCase(node.getNames());

        this.tempMacros.add(new MParamInsertPart(param_name, index_builder));

    }

    @Override
    public void caseAEolTextPart(
            AEolTextPart node) {

        String index_builder = String.valueOf(this.indexBuilder);

        this.tempMacros.add(new MEolPart(index_builder));
    }

    @Override
    public void caseAInsertTextPart(
            AInsertTextPart node) {

        AMacroRef macroRef = (AMacroRef) node.getMacroRef();
        String macro_name = GenerationUtils
                .buildNameCamelCase(macroRef.getNames());

        String index_builder = String.valueOf(this.indexBuilder);

        // Avoid declaring insert of the same name
        while (this.createdInserts
                .contains(this.indexInsert)) {
            this.indexInsert++;
        }

        do{
            this.indexBuilder++;
        }
        while(this.createdBuilders.contains(this.indexBuilder));

        String index_insert = String.valueOf(this.indexInsert);
        this.createdBuilders.add(this.indexBuilder);
        this.currentlyUsed.add(this.indexBuilder);
        MInsertMacroPart mInsertMacroPart = new MInsertMacroPart(macro_name, index_builder, GenerationUtils.INSERT_VAR_NAME.concat(index_insert));

        this.tempMacros.add(mInsertMacroPart);
        this.createdInserts.add(this.indexInsert);

        String tempContext = this.currentContextName;
        String tempMacroName = this.currentMacroRefName;
        Integer tempIndexInsert = this.indexInsert;
        this.currentContextName = null;
        List<Macro> temp = this.tempMacros;

        List<Macro> macros_found = evalMacros(node.getMacroRef());

        for(Macro macro : macros_found) {
            if(macro instanceof MEolPart) {
                mInsertMacroPart.addMacroBodyParts((MEolPart) macro);
            }
            else if(macro instanceof MInsertMacroPart) {
                mInsertMacroPart.addMacroBodyParts((MInsertMacroPart) macro);
            }
            else if(macro instanceof MInitStringBuilder) {
                mInsertMacroPart.addMacroBodyParts((MInitStringBuilder) macro);
            }
            else if(macro instanceof MStringPart) {
                mInsertMacroPart.addMacroBodyParts((MStringPart) macro);
            }
            else if(macro instanceof MParamInsertPart) {
                mInsertMacroPart.addMacroBodyParts((MParamInsertPart) macro);
            }
            else if(macro instanceof MSetInternal) {
                mInsertMacroPart.addSetInternals((MSetInternal) macro);
            }
            else{
                throw new InternalException("case unhandled");
            }
        }

        this.tempMacros = temp;
        this.indexBuilder = this.currentlyUsed.remove(this.currentlyUsed.size() - 1);
        this.indexInsert = tempIndexInsert;
        this.currentContextName = tempContext;
        this.currentMacroRefName = tempMacroName;
    }

    @Override
    public void outAVarValue(
            AVarValue node) {

        String var_name = GenerationUtils.buildNameCamelCase(node.getNames());
        String context_name = String.valueOf(this.currentContextName);

        MSetInternal mSetInternal = new MSetInternal(
                GenerationUtils.buildNameCamelCase(node.getParamName()),
                context_name);
        MParamRef paramRef = new MParamRef(var_name);
        mSetInternal.addSetParams(paramRef);

        if (this.currentMacro.getInternalsName().contains(var_name)) {
            paramRef.addGetParams(new MPlainText(
                    GenerationUtils.CONTEXT_STRING.toLowerCase()));
        }

        this.tempMacros.add(mSetInternal);
    }

    @Override
    public void caseAIndentMacroPart(
            AIndentMacroPart node) {

        // Avoid declaring builder of the same name
        do{
            this.indexBuilder++;
        }
        while(this.createdBuilders.contains(this.indexBuilder));

        String index_builder = String.valueOf(this.indexBuilder);
        MInitStringBuilder mInitStringBuilder = new MInitStringBuilder(index_builder);
        this.createdBuilders.add(this.indexBuilder);
        this.currentlyUsed.add(this.indexBuilder);
        this.currentMacroBuilder.addMacroBodyParts(mInitStringBuilder);

        this.indexBuilder++;
        index_builder = String.valueOf(this.indexBuilder);
        MAddIndent mAddIndent = new MAddIndent(index_builder);
        this.currentMacroBuilder.addMacroBodyParts(mAddIndent);
        this.currentlyUsed.add(this.indexBuilder);
        this.createdBuilders.add(this.indexBuilder);

        // To avoid modification on indexes
        Integer tempIndexInsert = this.indexInsert;

        for (PTextPart part : node.getTextPart()) {
            Macro macro_found = evalMacro(part);
            if(macro_found instanceof MInitStringBuilder){
                mAddIndent.addIndentParts((MInitStringBuilder) macro_found);
            }
            else if(macro_found instanceof MStringPart) {
                mAddIndent.addIndentParts((MStringPart) macro_found);
            }
            else if(macro_found instanceof MParamInsertPart) {
                mAddIndent.addIndentParts((MParamInsertPart) macro_found);
            }
            else if(macro_found instanceof MEolPart) {
                mAddIndent.addIndentParts((MEolPart) macro_found);
            }
            else if(macro_found instanceof MInsertMacroPart) {
                mAddIndent.addIndentParts((MInsertMacroPart) macro_found);
            }
            else {
                throw new InternalException("case unhandled");
            }
        }

        this.indexBuilder = this.currentlyUsed.remove(this.currentlyUsed.size() - 1);
        this.indexInsert = tempIndexInsert;
    }

    @Override
    public void caseAEndIndentMacroPart(
            AEndIndentMacroPart node) {

        String index_indent = String.valueOf(this.indexBuilder);
        this.indexBuilder = this.currentlyUsed
                .remove(this.currentlyUsed.size() - 1);
        this.currentMacroBuilder.addMacroBodyParts(new MIndentPart(
                String.valueOf(this.indexBuilder), index_indent));
    }

    @Override
    public void caseAStringMacroPart(
            AStringMacroPart node) {

        this.currentMacroBuilder.addMacroBodyParts(
                new MStringPart(GenerationUtils.escapedString(node.getString()),
                        String.valueOf(this.indexBuilder)));
    }

    @Override
    public void caseAEolMacroPart(
            AEolMacroPart node) {

        this.currentMacroBuilder.addMacroBodyParts(
                new MEolPart(String.valueOf(this.indexBuilder)));
    }

    @Override
    public void caseAInsertMacroPart(
            AInsertMacroPart node) {

        AMacroRef macroRef = (AMacroRef) node.getMacroRef();
        String macro_name = GenerationUtils
                .buildNameCamelCase(macroRef.getNames());
        this.indexInsert++;

        MInsertMacroPart mInsertMacroPart = new MInsertMacroPart(macro_name,
                String.valueOf(this.indexBuilder),
                String.valueOf(this.indexInsert));
        this.currentMacroBuilder.addMacroBodyParts(mInsertMacroPart);

        this.createdInserts.add(this.indexInsert);
        Integer tempIndexBuilder = this.indexBuilder;
        Integer tempIndexInsert = this.indexInsert;

        List<Macro> macros_found = evalMacros(node.getMacroRef());

        for(Macro macro : macros_found){
            if(macro instanceof MEolPart){
                mInsertMacroPart.addMacroBodyParts((MEolPart) macro);
            }
            else if(macro instanceof MInsertMacroPart){
                mInsertMacroPart.addMacroBodyParts((MInsertMacroPart) macro);
            }
            else if(macro instanceof MInitStringBuilder){
                mInsertMacroPart.addMacroBodyParts((MInitStringBuilder) macro);
            }
            else if(macro instanceof MStringPart){
                mInsertMacroPart.addMacroBodyParts((MStringPart) macro);
            }
            else if(macro instanceof MParamInsertPart){
                mInsertMacroPart.addMacroBodyParts((MParamInsertPart) macro);
            }
            else if(macro instanceof MSetInternal) {
                mInsertMacroPart.addSetInternals((MSetInternal) macro);
            }
            else{
                throw new InternalException("case unhandled");
            }
        }

        this.indexInsert = tempIndexInsert;
        this.indexBuilder = tempIndexBuilder;
    }

    @Override
    public void outAVarMacroPart(
            AVarMacroPart node) {

        String param_name = GenerationUtils.buildNameCamelCase(node.getNames());
        MParamInsertPart mParamInsertPart = new MParamInsertPart(param_name,
                String.valueOf(this.indexBuilder));
        this.currentMacroBuilder.addMacroBodyParts(mParamInsertPart);

        if (this.currentMacro.getInternalsName().contains(param_name)) {
            mParamInsertPart.addContextArg(new MContextArg());
        }
    }
}
