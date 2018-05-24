package org.sablecc.objectmacro.structure;

import org.sablecc.exception.InternalException;
import org.sablecc.objectmacro.exception.CompilerException;
import org.sablecc.objectmacro.syntax3.node.*;

import java.util.*;

public class MacroVersion {

    private TIdentifier name;

    private final Map<String, MacroInfo> macros = new LinkedHashMap<>();

    public MacroVersion(
            TIdentifier name){

        if(name == null){
            throw new InternalException("name may not be null");
        }
        this.name = name;
    }

    public TIdentifier getName() {
        return name;
    }

    public void newMacro(
            MacroInfo macroInfo){

        if(macroInfo == null){
            throw new InternalException("macroInfo may not be null");
        }

        MacroInfo firstDeclaration = this.macros.get(macroInfo.getName());
        if(firstDeclaration != null){
            throw CompilerException.duplicateDeclaration(
                    macroInfo.getNameDeclaration(), firstDeclaration.getNameDeclaration(), this);
        }

        this.macros.put(macroInfo.getName(), macroInfo);
        macroInfo.addVersion(this);
    }

    MacroInfo getMacro(
            TIdentifier macro_name){

        if(macro_name == null){
            throw new InternalException("macro_name may not be null");
        }

        MacroInfo found = this.macros.get(macro_name.getText());
        if(found == null){
            throw CompilerException.unknownMacro(macro_name);
        }

        return found;
    }

    public MacroInfo getMacroOrNull(
            TIdentifier macro_name){

        return this.macros.get(macro_name.getText());
    }

    public Collection<MacroInfo> getMacros() {

        return macros.values();
    }
}
