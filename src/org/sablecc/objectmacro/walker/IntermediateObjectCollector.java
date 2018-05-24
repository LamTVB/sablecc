package org.sablecc.objectmacro.walker;

import org.sablecc.objectmacro.structure.GlobalIndex;
import org.sablecc.objectmacro.structure.MacroInfo;
import org.sablecc.objectmacro.structure.MacroVersion;
import org.sablecc.objectmacro.structure.Param;
import org.sablecc.objectmacro.syntax3.analysis.DepthFirstAdapter;
import org.sablecc.objectmacro.syntax3.node.AMacro;
import org.sablecc.objectmacro.syntax3.node.AParam;
import org.sablecc.objectmacro.syntax3.node.TIdentifier;

import java.util.Iterator;

public class IntermediateObjectCollector
        extends DepthFirstAdapter{

    private final GlobalIndex globalIndex;

    private MacroInfo currentMacroInfo;

    public IntermediateObjectCollector(
            GlobalIndex globalIndex){

        this.globalIndex = globalIndex;
    }

    @Override
    public void caseAMacro(
            AMacro node) {

        if(node.getVersions().size() > 0
                && !this.globalIndex.isAllVersionned(node.getName().getText())){

            Iterator<TIdentifier> iterator = node.getVersions().iterator();
            TIdentifier version_identifier = iterator.next();
            MacroVersion version = this.globalIndex.getVersion(version_identifier);
            this.currentMacroInfo = this.globalIndex.getMacro(node.getName(), version);
            this.globalIndex.addIntermediateMacro(this.currentMacroInfo);

            super.caseAMacro(node);
        }
    }

    @Override
    public void caseAParam(
            AParam node) {

        Param param = this.currentMacroInfo.getParam(node.getName());

        for(MacroVersion version : this.globalIndex.getAllVersions()){
            MacroInfo versionned_macro = version.getMacroOrNull(this.currentMacroInfo
                    .getNameDeclaration());

            if(this.currentMacroInfo != versionned_macro){
                versionned_macro.containsParam(param);
            }
        }
    }
}
