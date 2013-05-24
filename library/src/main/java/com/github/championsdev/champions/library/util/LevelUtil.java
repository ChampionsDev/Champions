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
package com.github.championsdev.champions.library.util;

import com.github.championsdev.champions.library.Configuration;
import com.github.championsdev.champions.library.level.Level;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * @author B2OJustin
 */
public class LevelUtil {
    private static Logger logger = Logger.getLogger(LevelUtil.class.getName());
    private static HashMap<Integer, Double> reqExpMap = new HashMap<>();
    private static String expCurve = Configuration.getInstance().getExpCurve();
    private static ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");


    private LevelUtil() {
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void setExpCurve(String expCurve) {
        LevelUtil.expCurve = expCurve;
    }

    public static double getRequiredExp(int level) throws ScriptException {
        Double reqExp = reqExpMap.get(level);
        if(reqExp == null) {
            engine.put("L", level);
            reqExp = (Double)engine.eval(expCurve);
            reqExpMap.put(level, reqExp);
            System.out.println("Required exp:" + reqExp);
        }
        return reqExp;
    }

    public static boolean shouldLevelUp(Level level) {
        try {
            double reqExp = getRequiredExp(level.getLevel());
            if(level.getExp() >= reqExp) return true;
        } catch (ScriptException ex) {
            logger.warning("There seems to be an issue with your experience curve.");
            ex.printStackTrace();
        }
        return false;
    }
}
