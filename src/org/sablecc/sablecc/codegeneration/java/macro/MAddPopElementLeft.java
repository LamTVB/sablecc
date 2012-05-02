/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.sablecc.codegeneration.java.macro;

public class MAddPopElementLeft {

    private final String pListName;

    private final String pElementName;

    private final String pElementType;

    private final String pIndex;

    private final MAddPopElementLeft mAddPopElementLeft = this;

    MAddPopElementLeft(
            String pListName,
            String pElementName,
            String pElementType,
            String pIndex) {

        if (pListName == null) {
            throw new NullPointerException();
        }
        this.pListName = pListName;
        if (pElementName == null) {
            throw new NullPointerException();
        }
        this.pElementName = pElementName;
        if (pElementType == null) {
            throw new NullPointerException();
        }
        this.pElementType = pElementType;
        if (pIndex == null) {
            throw new NullPointerException();
        }
        this.pIndex = pIndex;
    }

    String pListName() {

        return this.pListName;
    }

    String pElementName() {

        return this.pElementName;
    }

    String pElementType() {

        return this.pElementType;
    }

    String pIndex() {

        return this.pIndex;
    }

    private String rListName() {

        return this.mAddPopElementLeft.pListName();
    }

    private String rElementType() {

        return this.mAddPopElementLeft.pElementType();
    }

    private String rElementName() {

        return this.mAddPopElementLeft.pElementName();
    }

    private String rIndex() {

        return this.mAddPopElementLeft.pIndex();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("      n");
        sb.append(rListName());
        sb.append(".addLeft((N");
        sb.append(rElementType());
        sb.append(")l");
        sb.append(rElementName());
        sb.append(".getNodes().get(");
        sb.append(rIndex());
        sb.append("));");
        sb.append(System.getProperty("line.separator"));
        return sb.toString();
    }

}