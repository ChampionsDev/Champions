/*
This file is part of Legends.

    Legends is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Legends is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Legends.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.github.championsdev.champions.library.cclass;

import com.github.championsdev.champions.library.BasicHandler;
import com.github.championsdev.champions.library.database.DataManager;

import java.util.logging.Logger;

/**
 * @author B2OJustin
 */
public class CClassHandler extends BasicHandler<CClass> {
    private static Logger logger = Logger.getLogger(CClassHandler.class.getName());
    private static CClassHandler instance = new CClassHandler();

    public static CClassHandler getInstance() {
        return instance;
    }

    public CClass load(String id) {
        CClass cClass = super.get(id);
        if(cClass == null) {
            cClass = DataManager.getDataSource().loadLClass(id);
            if(cClass != null) {
                register(id, cClass);
                logger.info("Loaded class '" + id + "' from database");
            }
            else logger.warning("Could not load class '" + id + "'");
        }
        return cClass;
    }
}
