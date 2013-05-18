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
package com.github.championsdev.champions.library.level.exp;

import com.github.championsdev.champions.library.BasicHandler;
import com.github.championsdev.champions.library.database.DataManager;

import java.util.logging.Logger;

/**
 * @author B2OJustin
 */
public class ExpGroupHandler extends BasicHandler<ExpGroup> {
    private static ExpGroupHandler instance = new ExpGroupHandler();
    private static final Logger logger = Logger.getLogger(ExpGroupHandler.class.getName());

    public static ExpGroupHandler getInstance() {
        return instance;
    }

    private ExpGroupHandler() {
    }

    public ExpGroup load(String id) {
        ExpGroup expGroup = super.get(id);
        if(expGroup == null) {
            expGroup = DataManager.getDataSource().loadExpGroup(id);
            if(expGroup != null) {
                super.register(id, expGroup);
                logger.info("Loaded experience group '" + id + "' from database.");
            }
            else logger.warning("Could not load experience group '" + id + "'");
        }
        return expGroup;
    }
}
