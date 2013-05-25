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

package org.sablecc.sablecc.semantics;

import org.sablecc.exception.*;
import org.sablecc.sablecc.syntax3.node.*;

public class Expression
        implements Declaration {

    private Grammar grammar;

    private Node declaration;

    // Cached values

    private String name;

    private Token location;

    Expression(
            Grammar grammar,
            Node declaration) {

        this.grammar = grammar;
        this.declaration = declaration;
    }

    @Override
    public String getName() {

        if (this.name == null) {
            if (this.declaration instanceof ANamedExpression) {
                this.name = ((ANamedExpression) this.declaration).getName()
                        .getText();
            }
            else {
                throw new InternalException("unhandled case");
            }
        }

        return this.name;
    }

    @Override
    public Token getLocation() {

        if (this.location == null) {
            if (this.declaration instanceof ANamedExpression) {
                this.location = ((ANamedExpression) this.declaration).getName();
            }
            else {
                throw new InternalException("unhandled case");
            }
        }

        return this.location;
    }
}
