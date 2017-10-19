/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.intermediate.macro;

import java.util.*;

public class MParam {

  private final List<Object> eSimpleName = new LinkedList<Object>();
  private final List<Object> eStringType_MacroType = new LinkedList<Object>();
  private final List<Object> eDirective = new LinkedList<Object>();

  public MParam() {
  }

  public MSimpleName newSimpleName(String pName) {
    MSimpleName lSimpleName = new MSimpleName(pName);
    this.eSimpleName.add(lSimpleName);
    return lSimpleName;
  }

  public MStringType newStringType() {
    MStringType lStringType = new MStringType();
    this.eStringType_MacroType.add(lStringType);
    return lStringType;
  }

  public MMacroType newMacroType() {
    MMacroType lMacroType = new MMacroType();
    this.eStringType_MacroType.add(lMacroType);
    return lMacroType;
  }

  public MDirective newDirective() {
    MDirective lDirective = new MDirective();
    this.eDirective.add(lDirective);
    return lDirective;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(" Param {");
    sb.append(System.getProperty("line.separator"));
    sb.append("    Name = ");
    if(this.eSimpleName.size() > 1) {
      sb.append("{ ");
    }
    {
      boolean first = true;
      for(Object oSimpleName : this.eSimpleName) {
        if(first) {
          first = false;
        }
        else {
          sb.append(", ");
        }
        sb.append(oSimpleName.toString());
      }
    }
    if(this.eSimpleName.size() > 1) {
      sb.append(" }");
    }
    for(Object oStringType_MacroType : this.eStringType_MacroType) {
      sb.append(oStringType_MacroType.toString());
    }
    {
      boolean first = true;
      for(Object oDirective : this.eDirective) {
        if(first) {
          first = false;
        }
        else {
          sb.append(", ");
        }
        sb.append(oDirective.toString());
      }
    }
    sb.append(" }");
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }

}
