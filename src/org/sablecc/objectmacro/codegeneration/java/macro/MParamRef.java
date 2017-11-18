/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

import java.util.*;

public class MParamRef {

  private final String pName;
  private final MParamRef mParamRef = this;
  private final List<Object> eContextArg_ContextName = new LinkedList<Object>();

  public MParamRef(String pName) {
    if(pName == null) throw new NullPointerException();
    this.pName = pName;
  }

  public MContextArg newContextArg() {
    MContextArg lContextArg = new MContextArg();
    this.eContextArg_ContextName.add(lContextArg);
    return lContextArg;
  }

  public MContextName newContextName(String pContextName) {
    MContextName lContextName = new MContextName(pContextName);
    this.eContextArg_ContextName.add(lContextName);
    return lContextName;
  }

  String pName() {
    return this.pName;
  }

  private String rName() {
    return this.mParamRef.pName();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("get");
    sb.append(rName());
    sb.append("(");
    for(Object oContextArg_ContextName : this.eContextArg_ContextName) {
      sb.append(oContextArg_ContextName.toString());
    }
    sb.append(")");
    return sb.toString();
  }

}