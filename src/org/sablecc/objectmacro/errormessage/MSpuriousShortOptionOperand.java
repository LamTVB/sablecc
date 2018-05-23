/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.errormessage;

import java.util.*;

public class MSpuriousShortOptionOperand extends Macro{
    
    private String field_OptionName;
    
    private String field_OperandText;
    
    
    
    
    public MSpuriousShortOptionOperand(String pOptionName, String pOperandText){
    
            this.setPOptionName(pOptionName);
            this.setPOperandText(pOperandText);
    
    }
    
    
    private void setPOptionName( String pOptionName ){
        if(pOptionName == null){
            throw ObjectMacroException.parameterNull("OptionName");
        }
    
        this.field_OptionName = pOptionName;
    }
    
    private void setPOperandText( String pOperandText ){
        if(pOperandText == null){
            throw ObjectMacroException.parameterNull("OperandText");
        }
    
        this.field_OperandText = pOperandText;
    }
    
    
    private String buildOptionName(){
    
        return this.field_OptionName;
    }
    
    private String buildOperandText(){
    
        return this.field_OperandText;
    }
    
    
    private String getOptionName(){
    
        return this.field_OptionName;
    }
    
    private String getOperandText(){
    
        return this.field_OperandText;
    }
    
    
    
    
    
    @Override
     void apply(
             InternalsInitializer internalsInitializer){
    
         internalsInitializer.setSpuriousShortOptionOperand(this);
     }
    
    
    @Override
    public String build(){
    
        BuildState buildState = this.build_state;
    
        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("SpuriousShortOptionOperand");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_state = buildState;
        List<String> indentations = new LinkedList<>();
        StringBuilder sbIndentation = new StringBuilder();
    
        
    
    
    
        StringBuilder sb0 = new StringBuilder();
    
        MCommandLineErrorHead minsert_1 = new MCommandLineErrorHead();
        
        
        sb0.append(minsert_1.build(null));
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("The following option is rejected:");
        sb0.append(LINE_SEPARATOR);
        sb0.append(" -");
        sb0.append(buildOptionName());
        sb0.append("=");
        sb0.append(buildOperandText());
        sb0.append(LINE_SEPARATOR);
        sb0.append("This option does not accept an operand.");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        MCommandLineErrorTail minsert_2 = new MCommandLineErrorTail();
        
        
        sb0.append(minsert_2.build(null));
    
        buildState.setExpansion(sb0.toString());
        return sb0.toString();
    }
    
    
    @Override
    String build(Context context) {
     return build();
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