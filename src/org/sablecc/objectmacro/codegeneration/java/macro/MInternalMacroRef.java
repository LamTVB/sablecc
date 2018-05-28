/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

import java.util.*;

public  class MInternalMacroRef extends Macro{
    
    String field_ParamName;
    
    MInternalMacroRef(String pParamName, Macros macros){
        
        
        this.setMacros(macros);
        this.setPParamName(pParamName);
    }
    
    private void setPParamName( String pParamName ){
        if(pParamName == null){
            throw ObjectMacroException.parameterNull("ParamName");
        }
    
        this.field_ParamName = pParamName;
    }
    
    String buildParamName(){
    
        return this.field_ParamName;
    }
    
    String getParamName(){
    
        return this.field_ParamName;
    }
    
    
    @Override
     void apply(
             InternalsInitializer internalsInitializer){
    
         internalsInitializer.setInternalMacroRef(this);
     }
    
    @Override
    public String build(){
    
        CacheBuilder cache_builder = this.cacheBuilder;
    
        if(cache_builder == null){
            cache_builder = new CacheBuilder();
        }
        else if(cache_builder.getExpansion() == null){
            throw new InternalException("Cycle detection detected lately");
        }
        else{
            return cache_builder.getExpansion();
        }
        this.cacheBuilder = cache_builder;
        List<String> indentations = new LinkedList<>();
        StringBuilder sbIndentation = new StringBuilder();
    
        
    
    
    
        StringBuilder sb0 = new StringBuilder();
    
        sb0.append("private InternalValue get");
        sb0.append(buildParamName());
        sb0.append("(Context context)");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    return this.list_");
        sb0.append(buildParamName());
        sb0.append(".get(context);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("}");
    
        cache_builder.setExpansion(sb0.toString());
        return sb0.toString();
    }
    
    @Override
    String build(Context context) {
     return build();
    }
    
    
    private void setMacros(Macros macros){
        if(macros == null){
            throw new InternalException("macros cannot be null");
        }
    
        this.macros = macros;
    }
}