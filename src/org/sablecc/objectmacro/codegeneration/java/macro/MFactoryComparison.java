/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

import java.util.*;

public class MFactoryComparison extends Macro{
    
    private Map<Context, String> field_VarName = new LinkedHashMap<>();
    
    
    
    
    public MFactoryComparison(){
    
    
    }
    
    
        void setVarName(
                Context context,
                String value) {
    
            if(value == null){
                throw new RuntimeException("value cannot be null here");
            }
    
            this.field_VarName.put(context, value);
        }
    
    
    private String buildVarName(Context context){
    
        return this.field_VarName.get(context);
    }
    
    
    private String getVarName(Context context){
    
        return this.field_VarName.get(context);
    }
    
    
    
    
    
    @Override
     void apply(
             InternalsInitializer internalsInitializer){
    
         internalsInitializer.setFactoryComparison(this);
     }
    
    
    @Override
    public String build(Context context){
    
        BuildState buildState = this.build_states.get(context);
    
        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("FactoryComparison");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_states.put(context, buildState);
        List<String> indentations = new LinkedList<>();
        StringBuilder sbIndentation = new StringBuilder();
    
        
    
    
    
        StringBuilder sb0 = new StringBuilder();
    
        sb0.append("if(this.getMacros() != ");
        sb0.append(buildVarName(context));
        sb0.append(".getMacros())");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    throw ObjectMacroException.diffMacros();");
        sb0.append(LINE_SEPARATOR);
        sb0.append("}");
    
        buildState.setExpansion(sb0.toString());
        return sb0.toString();
    }
    private String applyIndent(
                            String macro,
                            String indent){

            StringBuilder sb = new StringBuilder();
            String[] lines = macro.split( "\n");

            if(lines.length > 1){
                for(int i = 0; i < lines.length; i++){
                    String line = lines[i];
                    sb.append(indent).append(line);

                    if(i < lines.length - 1){
                        sb.append(LINE_SEPARATOR);
                    }
                }
            }
            else{
                sb.append(indent).append(macro);
            }

            return sb.toString();
    }
}