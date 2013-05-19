/*
This file is part of Champions.

    Champions is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Champions is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Champions.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.github.championsdev.champions.library.cclass;

import com.github.championsdev.champions.library.BasicUser;

import java.util.HashMap;

/**
 * @author B2OJustin
 */
//TODO implement setters for CClassUser
public interface CClassUser<SelfType extends CClassUser> extends BasicUser {
    public HashMap<CClass, CClassInfo> getLClassInfoMap();
    public CClassInfo getLClassInfo(CClass cClass);
    public SelfType setLClassInfo(CClass cClass, CClassInfo info);
}