/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MSingleAdd
        extends
        Macro {

    private String field_MacroName;

    private String field_ParamName;

    private final List<Macro> list_IsBuilt;

    private DSeparator IsBuiltSeparator;

    private DBeforeFirst IsBuiltBeforeFirst;

    private DAfterLast IsBuiltAfterLast;

    private DNone IsBuiltNone;

    private final InternalValue IsBuiltValue;

    private final Context IsBuiltContext = new Context();

    public MSingleAdd(
            String pMacroName,
            String pParamName) {

        setPMacroName(pMacroName);

        setPParamName(pParamName);

        this.list_IsBuilt = new ArrayList<>();

        this.IsBuiltValue = new InternalValue(this.list_IsBuilt,
                this.IsBuiltContext);

    }

    private void setPMacroName(
            String pMacroName) {

        if (pMacroName == null) {

            throw ObjectMacroException.parameterNull("MacroName");

        }

        this.field_MacroName = pMacroName;

    }

    private void setPParamName(
            String pParamName) {

        if (pParamName == null) {

            throw ObjectMacroException.parameterNull("ParamName");

        }

        this.field_ParamName = pParamName;

    }

    public void addIsBuilt(
            MIsBuilt macro) {

        if (macro == null) {

            throw ObjectMacroException.parameterNull("IsBuilt");

        }

        if (this.build_state != null) {

            throw ObjectMacroException.cannotModify("IsBuilt");

        }

        this.list_IsBuilt.add(macro);

        this.children.add(macro);

        Macro.cycleDetector.detectCycle(this, macro);

    }

    private String buildMacroName() {

        return this.field_MacroName;

    }

    private String buildParamName() {

        return this.field_ParamName;

    }

    private String buildIsBuilt() {

        StringBuilder sb = new StringBuilder();

        Context local_context = this.IsBuiltContext;

        List<Macro> macros = this.list_IsBuilt;

        int i = 0;

        int nb_macros = macros.size();

        String expansion = null;

        if (this.IsBuiltNone != null) {

            sb.append(this.IsBuiltNone.apply(i, "", nb_macros));

        }

        for (Macro macro : macros) {

            expansion = macro.build(local_context);

            if (this.IsBuiltBeforeFirst != null) {

                expansion = this.IsBuiltBeforeFirst.apply(i, expansion,
                        nb_macros);

            }

            if (this.IsBuiltAfterLast != null) {

                expansion = this.IsBuiltAfterLast.apply(i, expansion,
                        nb_macros);

            }

            if (this.IsBuiltSeparator != null) {

                expansion = this.IsBuiltSeparator.apply(i, expansion,
                        nb_macros);

            }

            sb.append(expansion);

            i++;

        }

        return sb.toString();

    }

    private String getMacroName() {

        return this.field_MacroName;

    }

    private String getParamName() {

        return this.field_ParamName;

    }

    private InternalValue getIsBuilt() {

        return this.IsBuiltValue;

    }

    private void initIsBuiltInternals(
            Context context) {

        for (Macro macro : this.list_IsBuilt) {

            macro.apply(new InternalsInitializer("IsBuilt") {

                @Override

                void setIsBuilt(
                        MIsBuilt mIsBuilt) {

                    mIsBuilt.setMacroName(MSingleAdd.this.IsBuiltContext,
                            getMacroName());

                }

            });

        }

    }

    private void initIsBuiltDirectives() {

    }

    @Override

    void apply(

            InternalsInitializer internalsInitializer) {

        internalsInitializer.setSingleAdd(this);

    }

    @Override

    public String build() {

        BuildState buildState = this.build_state;

        if (buildState == null) {

            buildState = new BuildState();

        }

        else if (buildState.getExpansion() == null) {

            throw ObjectMacroException.cyclicReference("SingleAdd");

        }

        else {

            return buildState.getExpansion();

        }

        this.build_state = buildState;

        List<String> indentations = new LinkedList<>();

        StringBuilder sbIndentation = new StringBuilder();

        initIsBuiltDirectives();

        initIsBuiltInternals(null);

        StringBuilder sb0 = new StringBuilder();

        sb0.append("public void add");

        sb0.append(buildParamName());

        sb0.append("(M");

        sb0.append(buildMacroName());

        sb0.append(" macro)");

        sb0.append("{");

        sb0.append(LINE_SEPARATOR);

        sb0.append("    if(macro == null)");

        sb0.append("{");

        sb0.append(LINE_SEPARATOR);

        sb0.append("        throw ObjectMacroException.parameterNull(\"");

        sb0.append(buildParamName());

        sb0.append("\");");

        sb0.append(LINE_SEPARATOR);

        sb0.append("    }");

        sb0.append(LINE_SEPARATOR);

        StringBuilder sb1 = new StringBuilder();

        sbIndentation = new StringBuilder();

        sbIndentation.append("    ");

        indentations.add(sbIndentation.toString());

        sb1.append(buildIsBuilt());

        sb0.append(applyIndent(sb1.toString(),
                indentations.remove(indentations.size() - 1)));

        sb0.append(LINE_SEPARATOR);

        sb0.append(LINE_SEPARATOR);

        sb0.append("    this.list_");

        sb0.append(buildParamName());

        sb0.append(".add(macro);");

        sb0.append(LINE_SEPARATOR);

        sb0.append("    this.children.add(macro);");

        sb0.append(LINE_SEPARATOR);

        sb0.append("    Macro.cycleDetector.detectCycle(this, macro);");

        sb0.append(LINE_SEPARATOR);

        sb0.append("}");

        buildState.setExpansion(sb0.toString());

        return sb0.toString();

    }

    @Override

    String build(
            Context context) {

        return build();

    }

    private String applyIndent(
            String macro,
            String indent) {

        StringBuilder sb = new StringBuilder();
        String[] lines = macro.split("\n");

        if (lines.length > 1) {
            for (int i = 0; i < lines.length; i++) {
                String line = lines[i];
                sb.append(indent).append(line);

                if (i < lines.length - 1) {
                    sb.append(LINE_SEPARATOR);
                }
            }
        }
        else {
            sb.append(indent).append(macro);
        }

        return sb.toString();
    }
}
