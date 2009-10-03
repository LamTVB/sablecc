/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.c.macro;

public class MTextInsertString {

    private final String pName;

    private final MTextInsertString mTextInsertString = this;

    MTextInsertString(
            String pName) {

        if (pName == null) {
            throw new NullPointerException();
        }
        this.pName = pName;
    }

    String pName() {

        return this.pName;
    }

    private String rName() {

        return this.mTextInsertString.pName();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("M");
        sb.append(rName());
        sb.append("_toString(t");
        sb.append(rName());
        sb.append(")");
        return sb.toString();
    }

}