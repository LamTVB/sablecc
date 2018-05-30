/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

import java.util.*;

public  class MRedefinedInternalsSetter extends Macro{
    
    String field_MacroName;
    
    final List<Macro> list_TextParts;
    
    final Context TextPartsContext = new Context();
    
    final InternalValue TextPartsValue;
    
    private DSeparator TextPartsSeparator;
    
    private DBeforeFirst TextPartsBeforeFirst;
    
    private DAfterLast TextPartsAfterLast;
    
    private DNone TextPartsNone;
    
    final List<Macro> list_SingleStringElements;
    
    final Context SingleStringElementsContext = new Context();
    
    final InternalValue SingleStringElementsValue;
    
    private DSeparator SingleStringElementsSeparator;
    
    private DBeforeFirst SingleStringElementsBeforeFirst;
    
    private DAfterLast SingleStringElementsAfterLast;
    
    private DNone SingleStringElementsNone;
    
    final List<Macro> list_SetInternals;
    
    final Context SetInternalsContext = new Context();
    
    final InternalValue SetInternalsValue;
    
    private DSeparator SetInternalsSeparator;
    
    private DBeforeFirst SetInternalsBeforeFirst;
    
    private DAfterLast SetInternalsAfterLast;
    
    private DNone SetInternalsNone;
    
    MRedefinedInternalsSetter(String pMacroName, Macros macros){
        
        
        this.setMacros(macros);
        this.setPMacroName(pMacroName);
        this.list_TextParts = new LinkedList<>();
        this.list_SingleStringElements = new LinkedList<>();
        this.list_SetInternals = new LinkedList<>();
        
        this.TextPartsValue = new InternalValue(this.list_TextParts, this.TextPartsContext);
        this.SingleStringElementsValue = new InternalValue(this.list_SingleStringElements, this.SingleStringElementsContext);
        this.SetInternalsValue = new InternalValue(this.list_SetInternals, this.SetInternalsContext);
    }
    
    private void setPMacroName( String pMacroName ){
        if(pMacroName == null){
            throw ObjectMacroException.parameterNull("MacroName");
        }
    
        this.field_MacroName = pMacroName;
    }
    
    public void addAllTextParts(
                    List<Macro> macros){
    
        if(macros == null){
            throw ObjectMacroException.parameterNull("TextParts");
        }
        if(this.cacheBuilder != null){
            throw ObjectMacroException.cannotModify("RedefinedInternalsSetter");
        }
        
        int i = 0;
        
        for(Macro macro : macros) {
            if(macro == null) {
                throw ObjectMacroException.macroNull(i, "TextParts");
            }
        
            if(this.getMacros() != macro.getMacros()){
                throw ObjectMacroException.diffMacros();
            }
        
            this.verifyTypeTextParts(macro);
            this.list_TextParts.add(macro);
            this.children.add(macro);
            Macro.cycleDetector.detectCycle(this, macro);
        
            i++;
        }
    }
    
    
    void verifyTypeTextParts (Macro macro) {
        macro.apply(new InternalsInitializer("TextParts"){
            @Override
            void setInitStringBuilder(MInitStringBuilder mInitStringBuilder){
            
                
                
            }
            
            @Override
            void setStringPart(MStringPart mStringPart){
            
                
                
            }
            
            @Override
            void setParamInsertPart(MParamInsertPart mParamInsertPart){
            
                
                
            }
            
            @Override
            void setEolPart(MEolPart mEolPart){
            
                
                
            }
            
            @Override
            void setInsertMacroPart(MInsertMacroPart mInsertMacroPart){
            
                
                
            }
        });
    }
    
    public void addTextParts(MInitStringBuilder macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("TextParts");
        }
        if(this.cacheBuilder != null){
            throw ObjectMacroException.cannotModify("RedefinedInternalsSetter");
        }
        
        if(this.getMacros() != macro.getMacros()){
            throw ObjectMacroException.diffMacros();
        }
    
        this.list_TextParts.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }
    
    public void addTextParts(MStringPart macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("TextParts");
        }
        if(this.cacheBuilder != null){
            throw ObjectMacroException.cannotModify("RedefinedInternalsSetter");
        }
        
        if(this.getMacros() != macro.getMacros()){
            throw ObjectMacroException.diffMacros();
        }
    
        this.list_TextParts.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }
    
    public void addTextParts(MParamInsertPart macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("TextParts");
        }
        if(this.cacheBuilder != null){
            throw ObjectMacroException.cannotModify("RedefinedInternalsSetter");
        }
        
        if(this.getMacros() != macro.getMacros()){
            throw ObjectMacroException.diffMacros();
        }
    
        this.list_TextParts.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }
    
    public void addTextParts(MEolPart macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("TextParts");
        }
        if(this.cacheBuilder != null){
            throw ObjectMacroException.cannotModify("RedefinedInternalsSetter");
        }
        
        if(this.getMacros() != macro.getMacros()){
            throw ObjectMacroException.diffMacros();
        }
    
        this.list_TextParts.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }
    
    public void addTextParts(MInsertMacroPart macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("TextParts");
        }
        if(this.cacheBuilder != null){
            throw ObjectMacroException.cannotModify("RedefinedInternalsSetter");
        }
        
        if(this.getMacros() != macro.getMacros()){
            throw ObjectMacroException.diffMacros();
        }
    
        this.list_TextParts.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }
    
    public void addAllSingleStringElements(
                    List<Macro> macros){
    
        if(macros == null){
            throw ObjectMacroException.parameterNull("SingleStringElements");
        }
        if(this.cacheBuilder != null){
            throw ObjectMacroException.cannotModify("RedefinedInternalsSetter");
        }
        
        int i = 0;
        
        for(Macro macro : macros) {
            if(macro == null) {
                throw ObjectMacroException.macroNull(i, "SingleStringElements");
            }
        
            if(this.getMacros() != macro.getMacros()){
                throw ObjectMacroException.diffMacros();
            }
        
            this.verifyTypeSingleStringElements(macro);
            this.list_SingleStringElements.add(macro);
            this.children.add(macro);
            Macro.cycleDetector.detectCycle(this, macro);
        
            i++;
        }
    }
    
    
    void verifyTypeSingleStringElements (Macro macro) {
        macro.apply(new InternalsInitializer("SingleStringElements"){
            @Override
            void setNewStringValue(MNewStringValue mNewStringValue){
            
                
                
            }
        });
    }
    
    public void addSingleStringElements(MNewStringValue macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("SingleStringElements");
        }
        if(this.cacheBuilder != null){
            throw ObjectMacroException.cannotModify("RedefinedInternalsSetter");
        }
        
        if(this.getMacros() != macro.getMacros()){
            throw ObjectMacroException.diffMacros();
        }
    
        this.list_SingleStringElements.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }
    
    public void addAllSetInternals(
                    List<Macro> macros){
    
        if(macros == null){
            throw ObjectMacroException.parameterNull("SetInternals");
        }
        if(this.cacheBuilder != null){
            throw ObjectMacroException.cannotModify("RedefinedInternalsSetter");
        }
        
        int i = 0;
        
        for(Macro macro : macros) {
            if(macro == null) {
                throw ObjectMacroException.macroNull(i, "SetInternals");
            }
        
            if(this.getMacros() != macro.getMacros()){
                throw ObjectMacroException.diffMacros();
            }
        
            this.verifyTypeSetInternals(macro);
            this.list_SetInternals.add(macro);
            this.children.add(macro);
            Macro.cycleDetector.detectCycle(this, macro);
        
            i++;
        }
    }
    
    
    void verifyTypeSetInternals (Macro macro) {
        macro.apply(new InternalsInitializer("SetInternals"){
            @Override
            void setSetInternal(MSetInternal mSetInternal){
            
                
                
            }
        });
    }
    
    public void addSetInternals(MSetInternal macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("SetInternals");
        }
        if(this.cacheBuilder != null){
            throw ObjectMacroException.cannotModify("RedefinedInternalsSetter");
        }
        
        if(this.getMacros() != macro.getMacros()){
            throw ObjectMacroException.diffMacros();
        }
    
        this.list_SetInternals.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }
    
    String buildMacroName(){
    
        return this.field_MacroName;
    }
    
    private String buildTextParts(){
        StringBuilder sb = new StringBuilder();
        Context local_context = TextPartsContext;
        List<Macro> macros = this.list_TextParts;
    
        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;
    
        if(this.TextPartsNone != null){
            sb.append(this.TextPartsNone.apply(i, "", nb_macros));
        }
    
        for(Macro macro : macros){
            expansion = macro.build(local_context);
    
            if(this.TextPartsBeforeFirst != null){
                expansion = this.TextPartsBeforeFirst.apply(i, expansion, nb_macros);
            }
    
            if(this.TextPartsAfterLast != null){
                expansion = this.TextPartsAfterLast.apply(i, expansion, nb_macros);
            }
    
            if(this.TextPartsSeparator != null){
                expansion = this.TextPartsSeparator.apply(i, expansion, nb_macros);
            }
    
            sb.append(expansion);
            i++;
        }
    
        return sb.toString();
    }
    
    private String buildSingleStringElements(){
        StringBuilder sb = new StringBuilder();
        Context local_context = SingleStringElementsContext;
        List<Macro> macros = this.list_SingleStringElements;
    
        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;
    
        if(this.SingleStringElementsNone != null){
            sb.append(this.SingleStringElementsNone.apply(i, "", nb_macros));
        }
    
        for(Macro macro : macros){
            expansion = macro.build(local_context);
    
            if(this.SingleStringElementsBeforeFirst != null){
                expansion = this.SingleStringElementsBeforeFirst.apply(i, expansion, nb_macros);
            }
    
            if(this.SingleStringElementsAfterLast != null){
                expansion = this.SingleStringElementsAfterLast.apply(i, expansion, nb_macros);
            }
    
            if(this.SingleStringElementsSeparator != null){
                expansion = this.SingleStringElementsSeparator.apply(i, expansion, nb_macros);
            }
    
            sb.append(expansion);
            i++;
        }
    
        return sb.toString();
    }
    
    private String buildSetInternals(){
        StringBuilder sb = new StringBuilder();
        Context local_context = SetInternalsContext;
        List<Macro> macros = this.list_SetInternals;
    
        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;
    
        if(this.SetInternalsNone != null){
            sb.append(this.SetInternalsNone.apply(i, "", nb_macros));
        }
    
        for(Macro macro : macros){
            expansion = macro.build(local_context);
    
            if(this.SetInternalsBeforeFirst != null){
                expansion = this.SetInternalsBeforeFirst.apply(i, expansion, nb_macros);
            }
    
            if(this.SetInternalsAfterLast != null){
                expansion = this.SetInternalsAfterLast.apply(i, expansion, nb_macros);
            }
    
            if(this.SetInternalsSeparator != null){
                expansion = this.SetInternalsSeparator.apply(i, expansion, nb_macros);
            }
    
            sb.append(expansion);
            i++;
        }
    
        return sb.toString();
    }
    
    String getMacroName(){
    
        return this.field_MacroName;
    }
    
    private InternalValue getTextParts(){
        return this.TextPartsValue;
    }
    
    private InternalValue getSingleStringElements(){
        return this.SingleStringElementsValue;
    }
    
    private InternalValue getSetInternals(){
        return this.SetInternalsValue;
    }
    private void initTextPartsInternals(Context context){
        for(Macro macro : this.list_TextParts){
            macro.apply(new InternalsInitializer("TextParts"){
                @Override
                void setInitStringBuilder(MInitStringBuilder mInitStringBuilder){
                
                    
                    
                }
                
                @Override
                void setStringPart(MStringPart mStringPart){
                
                    
                    
                }
                
                @Override
                void setParamInsertPart(MParamInsertPart mParamInsertPart){
                
                    
                    
                }
                
                @Override
                void setEolPart(MEolPart mEolPart){
                
                    
                    
                }
                
                @Override
                void setInsertMacroPart(MInsertMacroPart mInsertMacroPart){
                
                    
                    
                }
            });
        }
    }
    
    private void initSingleStringElementsInternals(Context context){
        for(Macro macro : this.list_SingleStringElements){
            macro.apply(new InternalsInitializer("SingleStringElements"){
                @Override
                void setNewStringValue(MNewStringValue mNewStringValue){
                
                    
                    
                }
            });
        }
    }
    
    private void initSetInternalsInternals(Context context){
        for(Macro macro : this.list_SetInternals){
            macro.apply(new InternalsInitializer("SetInternals"){
                @Override
                void setSetInternal(MSetInternal mSetInternal){
                
                    
                    mSetInternal.setVarName(SetInternalsContext, getMacroName());
                }
            });
        }
    }
    
    private void initTextPartsDirectives(){
        StringBuilder sb1 = new StringBuilder();
        sb1.append(LINE_SEPARATOR);
        this.TextPartsSeparator = new DSeparator(sb1.toString());
        this.TextPartsValue.setSeparator(this.TextPartsSeparator);
    }
    
    private void initSingleStringElementsDirectives(){
        StringBuilder sb1 = new StringBuilder();
        sb1.append(LINE_SEPARATOR);
        this.SingleStringElementsSeparator = new DSeparator(sb1.toString());
        this.SingleStringElementsValue.setSeparator(this.SingleStringElementsSeparator);
    }
    
    private void initSetInternalsDirectives(){
        StringBuilder sb1 = new StringBuilder();
        sb1.append(LINE_SEPARATOR);
        this.SetInternalsSeparator = new DSeparator(sb1.toString());
        this.SetInternalsValue.setSeparator(this.SetInternalsSeparator);
    }
    @Override
    void apply(
            InternalsInitializer internalsInitializer){
    
        internalsInitializer.setRedefinedInternalsSetter(this);
    }
    
    
    public String build(){
    
        CacheBuilder cache_builder = this.cacheBuilder;
    
        if(cache_builder == null){
            cache_builder = new CacheBuilder();
        }
        else if(cache_builder.getExpansion() == null){
            throw new InternalException("Cycle detection detected lately");
        }
        else{
            return cache_builder.getExpansion();
        }
        this.cacheBuilder = cache_builder;
        List<String> indentations = new LinkedList<>();
        StringBuilder sbIndentation = new StringBuilder();
    
        initTextPartsDirectives();
        initSingleStringElementsDirectives();
        initSetInternalsDirectives();
        
        initTextPartsInternals(null);
        initSingleStringElementsInternals(null);
        initSetInternalsInternals(null);
    
        StringBuilder sb0 = new StringBuilder();
    
        sb0.append("@Override");
        sb0.append(LINE_SEPARATOR);
        sb0.append("void set");
        sb0.append(buildMacroName());
        sb0.append("(M");
        sb0.append(buildMacroName());
        sb0.append(" m");
        sb0.append(buildMacroName());
        sb0.append(")");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("    ");
        indentations.add(sb2.toString());
        sb1.append(buildTextParts());
        sb1.append(LINE_SEPARATOR);
        sb1.append(buildSingleStringElements());
        sb1.append(LINE_SEPARATOR);
        sb1.append(buildSetInternals());
        sb0.append(applyIndent(sb1.toString(), indentations.remove(indentations.size() - 1)));
        sb0.append(LINE_SEPARATOR);
        sb0.append("}");
    
        cache_builder.setExpansion(sb0.toString());
        return sb0.toString();
    }
    
    @Override
    String build(Context context) {
        return build();
    }
    
    
    private void setMacros(Macros macros){
        if(macros == null){
            throw new InternalException("macros cannot be null");
        }
    
        this.macros = macros;
    }
}