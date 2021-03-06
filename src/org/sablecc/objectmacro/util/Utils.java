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

package org.sablecc.objectmacro.util;

import java.util.*;

import org.sablecc.exception.*;
import org.sablecc.objectmacro.structure.*;
import org.sablecc.objectmacro.syntax3.node.*;

public class Utils {

    public static String NAME_SEPARATOR = "_";

    public static String getVarName(
            TVariable var) {

        String text = var.getText();
        int length = text.length();
        return text.substring(1, length - 1);
    }

    public static String toCamelCase(
            TIdentifier identifier) {

        String text = identifier.getText();
        return Utils.toCamelCase(text);
    }

    public static String toCamelCase(
            TVariable var) {

        String text = Utils.getVarName(var);
        return Utils.toCamelCase(text);
    }

    public static String toCamelCase(
            String text) {

        StringBuilder sb = new StringBuilder();
        boolean upcase = true;
        for (char c : text.toCharArray()) {
            if (upcase) {
                upcase = false;
                sb.append((char) (c + ('A' - 'a')));
            }
            else if (c == '_') {
                upcase = true;
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String[] splitName(
            TIdentifier identifier) {

        return identifier.getText().split(Utils.NAME_SEPARATOR);
    }

    public static boolean containsVersion(
            List<TIdentifier> versions,
            MacroVersion version) {

        if (versions == null) {
            throw new InternalException("versions may not be null");
        }

        if (version == null) {
            throw new InternalException("version may not be null");
        }

        for (TIdentifier l_version : versions) {
            if (l_version.getText().equals(version.getName().getText())) {
                return true;
            }
        }

        return false;
    }

}
