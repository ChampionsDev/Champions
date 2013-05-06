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
package net.dawnfirerealms.legends.library.level;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * @author B2OJustin
 */
public class LevelHandler {
    private static LevelHandler instance = new LevelHandler();
    private static Logger logger = Logger.getLogger(LevelHandler.class.getName());

    private static HashMap<Integer, Double> expRequired = new HashMap<>();
    private static String curveFormula = "";

    private static ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("JavaScript");

    public LevelHandler getInstance() {
        return instance;
    }

    private LevelHandler() {
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void setCurve(String curveFormula) {
        LevelHandler.curveFormula = curveFormula;
        expRequired.clear();
    }

    public static Level getLevel(double totalExp) {
        return new Level(0); // TODO method stub
    }

    private static double getExp(int level) {
        double expReq = 0;
        if(expRequired.containsKey(level)) expReq = expRequired.get(level);
        else try {
            for(int i = 0; i < level; i++) {
                if(!expRequired.containsKey(level)) {
                    scriptEngine.put("L", level);
                    scriptEngine.put("E", expReq);
                    expReq = (double) scriptEngine.eval(curveFormula);
                    expRequired.put(level, expReq);
                }
                else {
                    expReq = expRequired.get(level);
                }
            }
        } catch (Exception e) {
            logger.warning("Experience curve could not be calculated.");
            e.printStackTrace();
        }
        return expReq;
    }
}
