/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.scala.macro;

import java.util.LinkedList;
import java.util.List;

public class MText {

    private final String pName;

    private final MText mText = this;

    private final List<Object> ePackageDeclaration = new LinkedList<>();

    private final List<Object> eParamClass_AncestorParamClass
            = new LinkedList<>();

    private final List<Object> eSelfRefText = new LinkedList<>();

    private final List<Object> eParamRef = new LinkedList<>();

    private final List<
            Object> eStringPart_EolPart_ParamInsertPart_TextInsertPart
                    = new LinkedList<>();

    public MText(
            String pName) {

        if (pName == null) {
            throw new NullPointerException();
        }
        this.pName = pName;
    }

    public MPackageDeclaration newPackageDeclaration(
            String pPackageName) {

        MPackageDeclaration lPackageDeclaration
                = new MPackageDeclaration(pPackageName);
        this.ePackageDeclaration.add(lPackageDeclaration);
        return lPackageDeclaration;
    }

    public MParamClass newParamClass(
            String pName) {

        MParamClass lParamClass = new MParamClass(pName);
        this.eParamClass_AncestorParamClass.add(lParamClass);
        return lParamClass;
    }

    public MAncestorParamClass newAncestorParamClass(
            String pName) {

        MAncestorParamClass lAncestorParamClass
                = new MAncestorParamClass(pName);
        this.eParamClass_AncestorParamClass.add(lAncestorParamClass);
        return lAncestorParamClass;
    }

    public MSelfRefText newSelfRefText() {

        MSelfRefText lSelfRefText = new MSelfRefText(this.mText);
        this.eSelfRefText.add(lSelfRefText);
        return lSelfRefText;
    }

    public MParamRef newParamRef(
            String pName,
            String pContext) {

        MParamRef lParamRef = new MParamRef(pName, pContext);
        this.eParamRef.add(lParamRef);
        return lParamRef;
    }

    public MStringPart newStringPart(
            String pString) {

        MStringPart lStringPart = new MStringPart(pString);
        this.eStringPart_EolPart_ParamInsertPart_TextInsertPart
                .add(lStringPart);
        return lStringPart;
    }

    public MEolPart newEolPart() {

        MEolPart lEolPart = new MEolPart();
        this.eStringPart_EolPart_ParamInsertPart_TextInsertPart.add(lEolPart);
        return lEolPart;
    }

    public MParamInsertPart newParamInsertPart(
            String pName) {

        MParamInsertPart lParamInsertPart = new MParamInsertPart(pName);
        this.eStringPart_EolPart_ParamInsertPart_TextInsertPart
                .add(lParamInsertPart);
        return lParamInsertPart;
    }

    public MTextInsertPart newTextInsertPart() {

        MTextInsertPart lTextInsertPart = new MTextInsertPart();
        this.eStringPart_EolPart_ParamInsertPart_TextInsertPart
                .add(lTextInsertPart);
        return lTextInsertPart;
    }

    String pName() {

        return this.pName;
    }

    private String rName() {

        return this.mText.pName();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(new MHeader().toString());
        if (this.ePackageDeclaration.size() > 0) {
            sb.append(System.getProperty("line.separator"));
        }
        for (Object oPackageDeclaration : this.ePackageDeclaration) {
            sb.append(oPackageDeclaration.toString());
        }
        sb.append(System.getProperty("line.separator"));
        sb.append("class M");
        sb.append(rName());
        sb.append(" (");
        {
            boolean first = true;
            for (Object oParamClass_AncestorParamClass : this.eParamClass_AncestorParamClass) {
                if (first) {
                    first = false;
                }
                else {
                    sb.append(", ");
                }
                sb.append(oParamClass_AncestorParamClass.toString());
            }
        }
        sb.append(") {");
        sb.append(System.getProperty("line.separator"));
        if (this.eSelfRefText.size() > 0) {
            sb.append(System.getProperty("line.separator"));
        }
        for (Object oSelfRefText : this.eSelfRefText) {
            sb.append(oSelfRefText.toString());
        }
        sb.append(System.getProperty("line.separator"));
        if (this.eParamRef.size() > 0) {
            sb.append(System.getProperty("line.separator"));
        }
        {
            boolean first = true;
            for (Object oParamRef : this.eParamRef) {
                if (first) {
                    first = false;
                }
                else {
                    sb.append(System.getProperty("line.separator"));
                }
                sb.append(oParamRef.toString());
            }
        }
        sb.append(System.getProperty("line.separator"));
        sb.append("  override def toString = {");
        sb.append(System.getProperty("line.separator"));
        sb.append("    var sb = new StringBuilder()");
        sb.append(System.getProperty("line.separator"));
        {
            boolean first = true;
            for (Object oStringPart_EolPart_ParamInsertPart_TextInsertPart : this.eStringPart_EolPart_ParamInsertPart_TextInsertPart) {
                if (first) {
                    first = false;
                }
                else {
                    sb.append(System.getProperty("line.separator"));
                }
                sb.append(oStringPart_EolPart_ParamInsertPart_TextInsertPart
                        .toString());
            }
        }
        sb.append("    sb toString");
        sb.append(System.getProperty("line.separator"));
        sb.append("  }");
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        sb.append("}");
        sb.append(System.getProperty("line.separator"));
        return sb.toString();
    }

}
