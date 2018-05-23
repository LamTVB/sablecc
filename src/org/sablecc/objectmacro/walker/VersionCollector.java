package org.sablecc.objectmacro.walker;

import org.sablecc.objectmacro.structure.GlobalIndex;
import org.sablecc.objectmacro.syntax3.analysis.DepthFirstAdapter;
import org.sablecc.objectmacro.syntax3.node.ASourceFile;
import org.sablecc.objectmacro.syntax3.node.AVersionsDefinition;
import org.sablecc.objectmacro.syntax3.node.TIdentifier;

public class VersionCollector
        extends DepthFirstAdapter {

    private final GlobalIndex globalIndex;

    public VersionCollector(
            GlobalIndex globalIndex){

        this.globalIndex = globalIndex;
    }

    @Override
    public void inASourceFile(
            ASourceFile node) {

        this.globalIndex.setHasVersions(node.getVersionsDefinition() != null);
    }

    @Override
    public void caseAVersionsDefinition(
            AVersionsDefinition node) {

        for(TIdentifier identifier : node.getVersions()){
            this.globalIndex.newVersion(identifier);
        }
    }
}
