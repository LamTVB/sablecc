/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MApplyInternalsInitializer extends
        Macro {

    private String field_ParamName;

    private final List<Macro> list_RedefinedInternalsSetter;

    private DSeparator RedefinedInternalsSetterSeparator;

    private DBeforeFirst RedefinedInternalsSetterBeforeFirst;

    private DAfterLast RedefinedInternalsSetterAfterLast;

    private DNone RedefinedInternalsSetterNone;

    private final InternalValue RedefinedInternalsSetterValue;

    private final Context RedefinedInternalsSetterContext = new Context();

    public MApplyInternalsInitializer(
            String pParamName) {

        setPParamName(pParamName);

        this.list_RedefinedInternalsSetter = new ArrayList<>();

        this.RedefinedInternalsSetterValue
                = new InternalValue(this.list_RedefinedInternalsSetter,
                        this.RedefinedInternalsSetterContext);

    }

    private void setPParamName(
            String pParamName) {

        if (pParamName == null) {

            throw ObjectMacroException.parameterNull("ParamName");

        }

        this.field_ParamName = pParamName;

    }

    public void addRedefinedInternalsSetter(
            MRedefinedInternalsSetter macro) {

        if (macro == null) {

            throw ObjectMacroException
                    .parameterNull("RedefinedInternalsSetter");

        }

        if (this.build_state != null) {

            throw ObjectMacroException.cannotModify("RedefinedInternalsSetter");

        }

        this.list_RedefinedInternalsSetter.add(macro);

        this.children.add(macro);

        Macro.cycleDetector.detectCycle(this, macro);

    }

    private String buildParamName() {

        return this.field_ParamName;

    }

    private String buildRedefinedInternalsSetter() {

        StringBuilder sb = new StringBuilder();

        Context local_context = this.RedefinedInternalsSetterContext;

        List<Macro> macros = this.list_RedefinedInternalsSetter;

        int i = 0;

        int nb_macros = macros.size();

        String expansion = null;

        if (this.RedefinedInternalsSetterNone != null) {

            sb.append(
                    this.RedefinedInternalsSetterNone.apply(i, "", nb_macros));

        }

        for (Macro macro : macros) {

            expansion = macro.build(local_context);

            if (this.RedefinedInternalsSetterBeforeFirst != null) {

                expansion = this.RedefinedInternalsSetterBeforeFirst.apply(i,
                        expansion, nb_macros);

            }

            if (this.RedefinedInternalsSetterAfterLast != null) {

                expansion = this.RedefinedInternalsSetterAfterLast.apply(i,
                        expansion, nb_macros);

            }

            if (this.RedefinedInternalsSetterSeparator != null) {

                expansion = this.RedefinedInternalsSetterSeparator.apply(i,
                        expansion, nb_macros);

            }

            sb.append(expansion);

            i++;

        }

        return sb.toString();

    }

    private String getParamName() {

        return this.field_ParamName;

    }

    private InternalValue getRedefinedInternalsSetter() {

        return this.RedefinedInternalsSetterValue;

    }

    private void initRedefinedInternalsSetterInternals(
            Context context) {

        for (Macro macro : this.list_RedefinedInternalsSetter) {

            macro.apply(new InternalsInitializer("RedefinedInternalsSetter") {

                @Override

                void setRedefinedInternalsSetter(
                        MRedefinedInternalsSetter mRedefinedInternalsSetter) {

                }

            });

        }

    }

    private void initRedefinedInternalsSetterDirectives() {

    }

    @Override

    void apply(

            InternalsInitializer internalsInitializer) {

        internalsInitializer.setApplyInternalsInitializer(this);

    }

    @Override

    public String build() {

        BuildState buildState = this.build_state;

        if (buildState == null) {

            buildState = new BuildState();

        }

        else if (buildState.getExpansion() == null) {

            throw ObjectMacroException
                    .cyclicReference("ApplyInternalsInitializer");

        }

        else {

            return buildState.getExpansion();

        }

        this.build_state = buildState;

        List<String> indentations = new LinkedList<>();

        StringBuilder sbIndentation = new StringBuilder();

        initRedefinedInternalsSetterDirectives();

        initRedefinedInternalsSetterInternals(null);

        StringBuilder sb0 = new StringBuilder();

        sb0.append("macro.apply(new InternalsInitializer(\"");

        sb0.append(buildParamName());

        sb0.append("\")");

        sb0.append("{");

        sb0.append(Macro.LINE_SEPARATOR);

        StringBuilder sb1 = new StringBuilder();

        sbIndentation = new StringBuilder();

        sbIndentation.append("    ");

        indentations.add(sbIndentation.toString());

        sb1.append(buildRedefinedInternalsSetter());

        sb0.append(applyIndent(sb1.toString(),
                indentations.remove(indentations.size() - 1)));

        sb0.append(Macro.LINE_SEPARATOR);

        sb0.append("});");

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
                    sb.append(Macro.LINE_SEPARATOR);
                }
            }
        }
        else {
            sb.append(indent).append(macro);
        }

        return sb.toString();
    }
}
