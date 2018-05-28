/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

import java.util.*;

public  class MSuperMacro extends Macro{
    
    final List<Macro> list_PackageDeclaration;
    
    final Context PackageDeclarationContext = new Context();
    
    final InternalValue PackageDeclarationValue;
    
    private DSeparator PackageDeclarationSeparator;
    
    private DBeforeFirst PackageDeclarationBeforeFirst;
    
    private DAfterLast PackageDeclarationAfterLast;
    
    private DNone PackageDeclarationNone;
    
    MSuperMacro(Macros macros){
        
        
        this.setMacros(macros);
        this.list_PackageDeclaration = new LinkedList<>();
        
        this.PackageDeclarationValue = new InternalValue(this.list_PackageDeclaration, this.PackageDeclarationContext);
    }
    
    public void addAllPackageDeclaration(
                    List<Macro> macros){
    
        if(macros == null){
            throw ObjectMacroException.parameterNull("PackageDeclaration");
        }
        if(this.cacheBuilder != null){
            throw ObjectMacroException.cannotModify("SuperMacro");
        }
        
        int i = 0;
        
        for(Macro macro : macros) {
            if(macro == null) {
                throw ObjectMacroException.macroNull(i, "PackageDeclaration");
            }
        
            if(this.getMacros() != macro.getMacros()){
                throw ObjectMacroException.diffMacros();
            }
        
            this.verifyTypePackageDeclaration(macro);
            this.list_PackageDeclaration.add(macro);
            this.children.add(macro);
            Macro.cycleDetector.detectCycle(this, macro);
        
            i++;
        }
    }
    
    
    void verifyTypePackageDeclaration (Macro macro) {
        macro.apply(new InternalsInitializer("PackageDeclaration"){
            @Override
            void setPackageDeclaration(MPackageDeclaration mPackageDeclaration){
            
                
                
            }
        });
    }
    
    public void addPackageDeclaration(MPackageDeclaration macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("PackageDeclaration");
        }
        if(this.cacheBuilder != null){
            throw ObjectMacroException.cannotModify("SuperMacro");
        }
        
        if(this.getMacros() != macro.getMacros()){
            throw ObjectMacroException.diffMacros();
        }
    
        this.list_PackageDeclaration.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }
    
    private String buildPackageDeclaration(){
        StringBuilder sb = new StringBuilder();
        Context local_context = PackageDeclarationContext;
        List<Macro> macros = this.list_PackageDeclaration;
    
        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;
    
        if(this.PackageDeclarationNone != null){
            sb.append(this.PackageDeclarationNone.apply(i, "", nb_macros));
        }
    
        for(Macro macro : macros){
            expansion = macro.build(local_context);
    
            if(this.PackageDeclarationBeforeFirst != null){
                expansion = this.PackageDeclarationBeforeFirst.apply(i, expansion, nb_macros);
            }
    
            if(this.PackageDeclarationAfterLast != null){
                expansion = this.PackageDeclarationAfterLast.apply(i, expansion, nb_macros);
            }
    
            if(this.PackageDeclarationSeparator != null){
                expansion = this.PackageDeclarationSeparator.apply(i, expansion, nb_macros);
            }
    
            sb.append(expansion);
            i++;
        }
    
        return sb.toString();
    }
    
    private InternalValue getPackageDeclaration(){
        return this.PackageDeclarationValue;
    }
    private void initPackageDeclarationInternals(Context context){
        for(Macro macro : this.list_PackageDeclaration){
            macro.apply(new InternalsInitializer("PackageDeclaration"){
                @Override
                void setPackageDeclaration(MPackageDeclaration mPackageDeclaration){
                
                    
                    
                }
            });
        }
    }
    
    private void initPackageDeclarationDirectives(){
        StringBuilder sb1 = new StringBuilder();
        sb1.append(LINE_SEPARATOR);
        this.PackageDeclarationBeforeFirst = new DBeforeFirst(sb1.toString());
        this.PackageDeclarationValue.setBeforeFirst(this.PackageDeclarationBeforeFirst);
    }
    @Override
    void apply(
            InternalsInitializer internalsInitializer){
    
        internalsInitializer.setSuperMacro(this);
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
    
        initPackageDeclarationDirectives();
        
        initPackageDeclarationInternals(null);
    
        StringBuilder sb0 = new StringBuilder();
    
        MHeader m1 = this.getMacros().newHeader();
        
        
        sb0.append(m1.build(null));
        sb0.append(LINE_SEPARATOR);
        sb0.append(buildPackageDeclaration());
        sb0.append(LINE_SEPARATOR);
        MImportJavaUtil m2 = this.getMacros().newImportJavaUtil();
        
        
        sb0.append(m2.build(null));
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("public abstract class Macro ");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    final static String LINE_SEPARATOR = System.getProperty(\"line.separator\");");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    CacheBuilder cacheBuilder = null;");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    final Map<Context, CacheBuilder> cacheBuilders = new LinkedHashMap<>();");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    final LinkedList<Macro> children = new LinkedList<>();");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    static final CycleDetector cycleDetector = new CycleDetector();");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    Macros macros;");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    abstract String build(Context context);");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    void apply(");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            InternalsInitializer internalsInitializer)");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("        throw new RuntimeException(\"apply cannot be called here\");");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    }");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    LinkedList<Macro> getChildren()");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        return this.children;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    }");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    Macros getMacros()");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        return this.macros;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    }");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    String applyIndent(");
        sb0.append(LINE_SEPARATOR);
        sb0.append("                String macro,");
        sb0.append(LINE_SEPARATOR);
        sb0.append("                String indent)");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("        StringBuilder sb = new StringBuilder();");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        String[] lines = macro.split( \"\\\\n\");");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("        if(lines.length > 1)");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            for(int i = 0; i < lines.length; i++)");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("                String line = lines[i];");
        sb0.append(LINE_SEPARATOR);
        sb0.append("                sb.append(indent).append(line);");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("                if(i < lines.length - 1)");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("                    sb.append(LINE_SEPARATOR);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("                }");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            }");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        }");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        else");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            sb.append(indent).append(macro);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        }");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("        return sb.toString();");
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