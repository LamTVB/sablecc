/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.errormessage;

import java.util.*;

public class MUnknownMacro extends Macro{
    
    private String field_Name;
    
    private String field_Line;
    
    private String field_Char;
    
    private final List<Macro> list_Versions;
    
    private DSeparator VersionsSeparator;
    
    private DBeforeFirst VersionsBeforeFirst;
    
    private DAfterLast VersionsAfterLast;
    
    private DNone VersionsNone;
    
    private final InternalValue VersionsValue;
    
    
    private final Context VersionsContext = new Context();
    
    
    public MUnknownMacro(String pName, String pLine, String pChar){
    
            this.setPName(pName);
            this.setPLine(pLine);
            this.setPChar(pChar);
        this.list_Versions = new ArrayList<>();
    
        this.VersionsValue = new InternalValue(this.list_Versions, this.VersionsContext);
    }
    
    
    private void setPName( String pName ){
        if(pName == null){
            throw ObjectMacroException.parameterNull("Name");
        }
    
        this.field_Name = pName;
    }
    
    private void setPLine( String pLine ){
        if(pLine == null){
            throw ObjectMacroException.parameterNull("Line");
        }
    
        this.field_Line = pLine;
    }
    
    private void setPChar( String pChar ){
        if(pChar == null){
            throw ObjectMacroException.parameterNull("Char");
        }
    
        this.field_Char = pChar;
    }
    
    public void addVersions(MPlainText macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("Versions");
        }
                if(this.build_state != null){
                    throw ObjectMacroException.cannotModify("PlainText");
                }
    
        this.list_Versions.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }
    
    
    private String buildName(){
    
        return this.field_Name;
    }
    
    private String buildLine(){
    
        return this.field_Line;
    }
    
    private String buildChar(){
    
        return this.field_Char;
    }
    
    private String buildVersions(){
        StringBuilder sb = new StringBuilder();
        Context local_context = VersionsContext;
        List<Macro> macros = this.list_Versions;
    
        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;
    
        if(this.VersionsNone != null){
            sb.append(this.VersionsNone.apply(i, "", nb_macros));
        }
    
        for(Macro macro : macros){
            expansion = macro.build(local_context);
    
            if(this.VersionsBeforeFirst != null){
                expansion = this.VersionsBeforeFirst.apply(i, expansion, nb_macros);
            }
    
            if(this.VersionsAfterLast != null){
                expansion = this.VersionsAfterLast.apply(i, expansion, nb_macros);
            }
    
            if(this.VersionsSeparator != null){
                expansion = this.VersionsSeparator.apply(i, expansion, nb_macros);
            }
    
            sb.append(expansion);
            i++;
        }
    
        return sb.toString();
    }
    
    
    private String getName(){
    
        return this.field_Name;
    }
    
    private String getLine(){
    
        return this.field_Line;
    }
    
    private String getChar(){
    
        return this.field_Char;
    }
    
    private InternalValue getVersions(){
        return this.VersionsValue;
    }
    
    private void initVersionsInternals(Context context){
        for(Macro macro : this.list_Versions){
            macro.apply(new InternalsInitializer("Versions"){
                @Override
                void setPlainText(MPlainText mPlainText){
                
                    
                    
                }
            });
        }
    }
    
    
    private void initVersionsDirectives(){
        StringBuilder sb0 = new StringBuilder();
        sb0.append(".");
        this.VersionsNone = new DNone(sb0.toString());
        this.VersionsValue.setNone(this.VersionsNone);StringBuilder sb1 = new StringBuilder();
        sb1.append("in version: ");
        this.VersionsBeforeFirst = new DBeforeFirst(sb1.toString());
        this.VersionsValue.setBeforeFirst(this.VersionsBeforeFirst);StringBuilder sb2 = new StringBuilder();
        sb2.append(".");
        this.VersionsAfterLast = new DAfterLast(sb2.toString());
        this.VersionsValue.setAfterLast(this.VersionsAfterLast);StringBuilder sb3 = new StringBuilder();
        sb3.append(", ");
        this.VersionsSeparator = new DSeparator(sb3.toString());
        this.VersionsValue.setSeparator(this.VersionsSeparator);
    }
    
    @Override
     void apply(
             InternalsInitializer internalsInitializer){
    
         internalsInitializer.setUnknownMacro(this);
     }
    
    
    @Override
    public String build(){
    
        BuildState buildState = this.build_state;
    
        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("UnknownMacro");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_state = buildState;
        List<String> indentations = new LinkedList<>();
        StringBuilder sbIndentation = new StringBuilder();
    
        initVersionsDirectives();
        
        initVersionsInternals(null);
    
        StringBuilder sb0 = new StringBuilder();
    
        MSemanticErrorHead minsert_1 = new MSemanticErrorHead();
        
        
        sb0.append(minsert_1.build(null));
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("Line: ");
        sb0.append(buildLine());
        sb0.append(LINE_SEPARATOR);
        sb0.append("Char: ");
        sb0.append(buildChar());
        sb0.append(LINE_SEPARATOR);
        sb0.append("Macro \"");
        sb0.append(buildName());
        sb0.append("\" does not exist ");
        sb0.append(buildVersions());
    
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