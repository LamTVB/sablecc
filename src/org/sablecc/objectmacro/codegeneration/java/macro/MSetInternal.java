/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

import java.util.*;

public class MSetInternal extends Macro{
    
    private String field_ParamName;
    
    private String field_Context;
    
    private final List<Macro> list_SetParams;
    
    private DSeparator SetParamsSeparator;
    
    private DBeforeFirst SetParamsBeforeFirst;
    
    private DAfterLast SetParamsAfterLast;
    
    private DNone SetParamsNone;
    
    private final InternalValue SetParamsValue;
    
    private Map<Context, String> field_VarName = new LinkedHashMap<>();
    
    
    private final Context SetParamsContext = new Context();
    
    
    public MSetInternal(String pParamName, String pContext){
    
            this.setPParamName(pParamName);
            this.setPContext(pContext);
        this.list_SetParams = new ArrayList<>();
    
        this.SetParamsValue = new InternalValue(this.list_SetParams, this.SetParamsContext);
    }
    
    
    private void setPParamName( String pParamName ){
        if(pParamName == null){
            throw ObjectMacroException.parameterNull("ParamName");
        }
    
        this.field_ParamName = pParamName;
    }
    
    private void setPContext( String pContext ){
        if(pContext == null){
            throw ObjectMacroException.parameterNull("Context");
        }
    
        this.field_Context = pContext;
    }
    
    public void addSetParams(MParamRef macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("SetParams");
        }
        
    
        this.list_SetParams.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }
    
    public void addSetParams(MStringBuilderBuild macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("SetParams");
        }
        
    
        this.list_SetParams.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }
    
        void setVarName(
                Context context,
                String value) {
    
            if(value == null){
                throw new RuntimeException("value cannot be null here");
            }
    
            this.field_VarName.put(context, value);
        }
    
    
    private String buildParamName(){
    
        return this.field_ParamName;
    }
    
    private String buildContext(){
    
        return this.field_Context;
    }
    
    private String buildSetParams(){
        StringBuilder sb = new StringBuilder();
        Context local_context = SetParamsContext;
        List<Macro> macros = this.list_SetParams;
    
        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;
    
        if(this.SetParamsNone != null){
            sb.append(this.SetParamsNone.apply(i, "", nb_macros));
        }
    
        for(Macro macro : macros){
            expansion = macro.build(local_context);
    
            if(this.SetParamsBeforeFirst != null){
                expansion = this.SetParamsBeforeFirst.apply(i, expansion, nb_macros);
            }
    
            if(this.SetParamsAfterLast != null){
                expansion = this.SetParamsAfterLast.apply(i, expansion, nb_macros);
            }
    
            if(this.SetParamsSeparator != null){
                expansion = this.SetParamsSeparator.apply(i, expansion, nb_macros);
            }
    
            sb.append(expansion);
            i++;
        }
    
        return sb.toString();
    }
    
    private String buildVarName(Context context){
    
        return this.field_VarName.get(context);
    }
    
    
    private String getParamName(){
    
        return this.field_ParamName;
    }
    
    private String getContext(){
    
        return this.field_Context;
    }
    
    private InternalValue getSetParams(){
        return this.SetParamsValue;
    }
    
    private String getVarName(Context context){
    
        return this.field_VarName.get(context);
    }
    
    private void initSetParamsInternals(Context context){
        for(Macro macro : this.list_SetParams){
            macro.apply(new InternalsInitializer("SetParams"){
                @Override
                void setParamRef(MParamRef mParamRef){
                
                    
                    
                }@Override
                void setStringBuilderBuild(MStringBuilderBuild mStringBuilderBuild){
                
                    
                    
                }
            });
        }
    }
    
    
    private void initSetParamsDirectives(){
        
    }
    
    @Override
     void apply(
             InternalsInitializer internalsInitializer){
    
         internalsInitializer.setSetInternal(this);
     }
    
    
    @Override
    public String build(Context context){
    
        BuildState buildState = this.build_states.get(context);
    
        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("SetInternal");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_states.put(context, buildState);
        List<String> indentations = new LinkedList<>();
        StringBuilder sbIndentation = new StringBuilder();
    
        initSetParamsDirectives();
        
        initSetParamsInternals(context);
    
        StringBuilder sb0 = new StringBuilder();
    
        sb0.append("m");
        sb0.append(buildVarName(context));
        sb0.append(".set");
        sb0.append(buildParamName());
        sb0.append("(");
        sb0.append(buildContext());
        sb0.append(", ");
        sb0.append(buildSetParams());
        sb0.append(");");
    
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