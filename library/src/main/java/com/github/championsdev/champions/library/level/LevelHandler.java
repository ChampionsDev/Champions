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
package com.github.championsdev.champions.library.level;

import com.github.championsdev.champions.library.level.exp.Exp;

import java.util.logging.Logger;

/**
 * @author B2OJustin
 */
public class LevelHandler {
    private static LevelHandler instance = new LevelHandler();
    private static Logger logger = Logger.getLogger(LevelHandler.class.getName());

    public static LevelHandler getInstance() {
        return instance;
    }

    private LevelHandler() {
    }

    public static Logger getLogger() {
        return logger;
    }

    // TODO
    public boolean shouldLevelUp(Level level) {
        if(level.getExp() >= 20) return true;
        else return false;
    }
}
