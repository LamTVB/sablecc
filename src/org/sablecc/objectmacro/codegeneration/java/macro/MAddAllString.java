/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

import java.util.*;

public  class MAddAllString extends Macro{
    
    String field_ParamName;
    
    MAddAllString(String pParamName, Macros macros){
        
        
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
    
        internalsInitializer.setAddAllString(this);
    }
    
    
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
    
        sb0.append("public void addAll");
        sb0.append(buildParamName());
        sb0.append("(");
        sb0.append(LINE_SEPARATOR);
        sb0.append("                List<String> strings)");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    if(macros == null)");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        throw ObjectMacroException.parameterNull(\"");
        sb0.append(buildParamName());
        sb0.append("\");");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    }");
        sb0.append(LINE_SEPARATOR);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("    ");
        indentations.add(sb2.toString());
        MIsBuilt m1 = this.getMacros().newIsBuilt();
        
        
        sb1.append(m1.build(null));
        sb0.append(applyIndent(sb1.toString(), indentations.remove(indentations.size() - 1)));
        sb0.append(LINE_SEPARATOR);
        sb0.append("    for(String string : strings) ");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        if(string == null) ");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            throw ObjectMacroException.parameterNull(\"");
        sb0.append(buildParamName());
        sb0.append("\");");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        }");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("        this.list_");
        sb0.append(buildParamName());
        sb0.append(".add(string);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    }");
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