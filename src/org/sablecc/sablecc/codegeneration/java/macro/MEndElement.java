/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.sablecc.codegeneration.java.macro;

public class MEndElement {

    private final String pElementName;

    private final MEndElement mEndElement = this;

    MEndElement(
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

        return this.mEndElement.pElementName();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("  private final End e");
        sb.append(rElementName());
        sb.append(";");
        sb.append(System.getProperty("line.separator"));
        sb.append("  public End get");
        sb.append(rElementName());
        sb.append("() {");
        sb.append(System.getProperty("line.separator"));
        sb.append("    return this.e");
        sb.append(rElementName());
        sb.append(";");
        sb.append(System.getProperty("line.separator"));
        sb.append("  }");
        sb.append(System.getProperty("line.separator"));
        return sb.toString();
    }

}
