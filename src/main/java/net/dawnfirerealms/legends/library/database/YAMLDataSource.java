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
package net.dawnfirerealms.legends.library.database;

import net.dawnfirerealms.legends.core.LPlayer;
import net.dawnfirerealms.legends.library.database.helper.YAMLHelper;
import net.dawnfirerealms.legends.library.lclass.LClass;
import net.dawnfirerealms.legends.library.race.Race;
import net.dawnfirerealms.legends.library.skill.SkillManager;

import java.io.FileNotFoundException;
import java.util.logging.Logger;

/**
 * Thread safe class for accessing YAML database.
 *
 * @author B2OJustin
 */
public class YAMLDataSource implements DataSource {
    private static final Logger logger = Logger.getLogger(YAMLDataSource.class.getName());
    private String configPath = "";
    private final String RACE_PATH = "races/";
    private final String SKILL_PATH = "skills/";
    private final String PLAYER_PATH = "players/";
    private final String CLASS_PATH = "classes/";

    @Override
    public String getName() {
        return "YAML";
    }

    public YAMLDataSource(String configPath) {
        this.configPath = configPath;
    }

    @Override
    public Logger getLogger() {
        return YAMLDataSource.logger;
    }

    @Override
    public synchronized LPlayer loadLPlayer(String name) {
        return null; //TODO loadLPlayer method stub
    }

    @Override
    @SuppressWarnings({"LoggerStringConcat", "unchecked"})
    public synchronized Race loadRace(String name) {
        String filePath = configPath + RACE_PATH + name.replace(" ", "_") + ".yml";
        Race race = new Race();
        try {
            YAMLHelper yml = new YAMLHelper(filePath);

            for(String mainKey : yml.getKeys("")) {
                switch(mainKey) {
                    case "name":
                        race.setName(yml.getString("name"));
                        break;
                    case "description":
                        race.setDescription(yml.getStringList("description"));
                        break;

                    // Weapons
                    case "Weapons":
                        for(String wepKey : yml.getKeys("Weapons")) {
                            switch(wepKey) {
                                case "default":
                                    if(yml.getString("Weapons.default").equals("allow")) {
                                        race.getWeaponRestrictions().setDefault(true);
                                    }
                                    else race.getWeaponRestrictions().setDefault(false);
                                    break;
                                case "permitted-weapon":
                                    for(String wepPermKey : yml.getKeys("Weapons.permitted-weapon")) {
                                        race.getWeaponRestrictions().setAllowed(wepPermKey, true);
                                        for(String wepInfo : yml.getKeys(String.format("Weapons.permitted-weapon.%s", wepPermKey))) {
                                            switch(wepInfo) {
                                                case "bonus-damage":
                                                    int bonusDamage = yml.getInt(String.format("Weapons.permitted-weapon.%s.bonus-damage", wepPermKey));
                                                    //race.getWeaponInfo(wepPermKey).addDamage(bonusDamage);
                                                    break;
                                            }
                                        }
                                    }
                                    break;
                            }
                        }
                        break;
                }
            }

        } catch (FileNotFoundException e) {
            logger.warning("Could not find file for race '" + name + "' at " + filePath);
            e.printStackTrace();
        } catch (ClassCastException e) {
            logger.warning("You seem to have an error in your yaml. Could not load race '" + name + "'");
            e.printStackTrace();
        }

        return race;
    }

    @Override
    public synchronized LClass loadLClass(String name) {
        return null; //TODO loadLClass method stub
    }
}
