/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.sablecc.codegeneration.java.macro;

public class MNormalChildApply {

    private final String pElementName;

    private final MNormalChildApply mNormalChildApply = this;

    MNormalChildApply(
            String pElementName) {

        if (pElementName == null) {
            throw new NullPointerException();
        }
        this.pElementName = pElementName;
    }

    String pElementName() {

        return this.pElementName;
    }

    private String rElementName() {

        return this.mNormalChildApply.pElementName();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("    this.e");
        sb.append(rElementName());
        sb.append(".apply(walker);");
        sb.append(System.getProperty("line.separator"));
        return sb.toString();
    }

}
