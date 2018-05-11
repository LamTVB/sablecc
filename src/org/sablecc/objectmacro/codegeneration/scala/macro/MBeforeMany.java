/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.scala.macro;

import java.util.LinkedList;
import java.util.List;

public class MBeforeMany {

    private final MExpandInsertPart mExpandInsertPart;

    private final List<Object> eInlineText_ParamInsert_TextInsert
            = new LinkedList<>();

    MBeforeMany(
            MExpandInsertPart mExpandInsertPart) {

        if (mExpandInsertPart == null) {
            throw new NullPointerException();
        }
        this.mExpandInsertPart = mExpandInsertPart;
    }

    public MInlineText newInlineText() {

        MInlineText lInlineText = new MInlineText();
        this.eInlineText_ParamInsert_TextInsert.add(lInlineText);
        return lInlineText;
    }

    public MParamInsert newParamInsert(
            String pName) {

        MParamInsert lParamInsert = new MParamInsert(pName);
        this.eInlineText_ParamInsert_TextInsert.add(lParamInsert);
        return lParamInsert;
    }

    public MTextInsert newTextInsert(
            String pName) {

        MTextInsert lTextInsert = new MTextInsert(pName);
        this.eInlineText_ParamInsert_TextInsert.add(lTextInsert);
        return lTextInsert;
    }

    private String rName() {

        return this.mExpandInsertPart.pName();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("    if(e");
        sb.append(rName());
        sb.append(".size > 1) {");
        sb.append(System.getProperty("line.separator"));
        sb.append("      sb.append(");
        for (Object oInlineText_ParamInsert_TextInsert : this.eInlineText_ParamInsert_TextInsert) {
            sb.append(oInlineText_ParamInsert_TextInsert.toString());
        }
        sb.append(")");
        sb.append(System.getProperty("line.separator"));
        sb.append("    }");
        sb.append(System.getProperty("line.separator"));
        return sb.toString();
    }

}
