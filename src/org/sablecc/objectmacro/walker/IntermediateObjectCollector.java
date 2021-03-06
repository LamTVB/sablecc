/* This file is part of SableCC ( http://sablecc.org ).
 *
 * See the NOTICE file distributed with this work for copyright information.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.sablecc.objectmacro.walker;

import java.util.*;

import org.sablecc.objectmacro.structure.*;
import org.sablecc.objectmacro.syntax3.analysis.*;
import org.sablecc.objectmacro.syntax3.node.*;

public class IntermediateObjectCollector
        extends DepthFirstAdapter {

    private final GlobalIndex globalIndex;

    private MacroInfo currentMacroInfo;

    public IntermediateObjectCollector(
            GlobalIndex globalIndex) {

        this.globalIndex = globalIndex;
    }

    @Override
    public void caseAMacro(
            AMacro node) {

        if (node.getVersions().size() > 0 && !this.globalIndex
                .isAllVersionned(node.getName().getText())) {

            Iterator<TIdentifier> iterator = node.getVersions().iterator();
            TIdentifier version_identifier = iterator.next();
            MacroVersion version
                    = this.globalIndex.getVersion(version_identifier);
            this.currentMacroInfo
                    = this.globalIndex.getMacro(node.getName(), version);

            while(iterator.hasNext()) {
                version_identifier = iterator.next();
                version = this.globalIndex.getVersion(version_identifier);
                this.currentMacroInfo.addVersion(version);
            }
            this.globalIndex.addIntermediateMacro(this.currentMacroInfo);

            super.caseAMacro(node);
        }
    }
}
