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
package com.github.legendsdev.legends.library.database;

import com.github.legendsdev.legends.library.BasicInfo;
import com.github.legendsdev.legends.library.LPlayer;
import com.github.legendsdev.legends.library.armor.*;
import com.github.legendsdev.legends.library.database.helper.YAMLHelper;
import com.github.legendsdev.legends.library.lclass.*;
import com.github.legendsdev.legends.library.level.LevelRestricted;
import com.github.legendsdev.legends.library.race.Race;
import com.github.legendsdev.legends.library.weapon.*;

import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Thread safe class for accessing YAML database.
 *
 * @author B2OJustin
 */
@SuppressWarnings("unchecked")
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
    @SuppressWarnings("unchecked")
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

                    case "Weapons":
                        race.setWeaponRestrictions(loadWeaponRestrictions(race, "Weapons", yml));
                    break;

                    case "Armor":
                        race.setArmorRestrictions(loadArmorRestrictions(race, "Armor", yml));
                    break;

                    case "Class":
                        race.setLClassRestrictions(loadLClassRestrictions(race, "Class", yml));
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

    protected <T extends BasicInfo> T loadBasicInfo(T basicInfo, LinkedHashMap<String, Object> infoMap) throws ClassCastException {
        if(infoMap == null) return null;
        for(Map.Entry<String, Object> entry : infoMap.entrySet()) {
            switch(entry.getKey().toLowerCase()) {
                case "bonus-defense":
                    int bonusDefense = (int) entry.getValue();
                    basicInfo.addBonusDefense(bonusDefense);
                break;
                case "bonus-damage":
                    int bonusDamage = (int) entry.getValue();
                    basicInfo.addBonusWeaponDamage(bonusDamage);
                break;
                case "bonus-stamina":
                    int bonusStamina = (int) entry.getValue();
                    basicInfo.addBonusStamina(bonusStamina);
                break;
                case "bonus-health":
                    int bonusHealth = (int) entry.getValue();
                    basicInfo.addBonusHealth(bonusHealth);
                break;
                case "bonus-mana":
                    int bonusMana = (int) entry.getValue();
                    basicInfo.addBonusMana(bonusMana);
                break;
                case "required-level":
                    if(basicInfo instanceof LevelRestricted) {
                        int requiredLevel = (int) entry.getValue();
                        ((LevelRestricted)basicInfo).getLevelRestrictions().setMinLevel(requiredLevel);
                    }
                break;
                case "maximum-level":
                    if(basicInfo instanceof  LevelRestricted) {
                        int maximumLevel = (int) entry.getValue();
                        ((LevelRestricted)basicInfo).getLevelRestrictions().setMaxLevel(maximumLevel);
                    }
                break;
            }
        }
        return basicInfo;
    }

    protected WeaponRestrictions loadWeaponRestrictions(WeaponRestricted restricted, String path, YAMLHelper yml) {
        for(String wepKey : yml.getKeys("Weapons")) {
            switch(wepKey) {
                case "default":
                    if(yml.getString("Weapons.default").equals("allow")) {
                        restricted.getWeaponRestrictions().setDefault(true);
                    }
                    else restricted.getWeaponRestrictions().setDefault(false);
                    break;
                case "permitted-weapon":
                    for(String wepID : yml.getKeys("Weapons.permitted-weapon")) {
                        Weapon weapon = WeaponHandler.getInstance().get(wepID);
                        if(weapon != null) {
                            restricted.getWeaponRestrictions().setAllowed(weapon, true);
                            if(restricted instanceof WeaponUser) {
                                LinkedHashMap<String, Object> infoMap = yml.getObject(LinkedHashMap.class, String.format("Weapons.permitted-weapon.%s", wepID));
                                loadBasicInfo(((WeaponUser)restricted).getWeaponInfo(weapon), infoMap);
                            }
                        }
                    }
                    break;
                case "restricted-weapon":
                    for(String wepID : yml.getStringList("Weapons.restricted-weapon")) {
                        Weapon weapon = WeaponHandler.getInstance().get(wepID);
                        restricted.getWeaponRestrictions().setAllowed(weapon, false);
                    }
            }
        }
        return restricted.getWeaponRestrictions();
    }

    protected ArmorRestrictions loadArmorRestrictions(ArmorRestricted restricted, String path, YAMLHelper yml) {
        for(String armorKey : yml.getKeys("Armor")) {
            switch(armorKey) {
                case "default":
                    if(yml.getString("Armor.default").equals("allow")) {
                        restricted.getArmorRestrictions().setDefault(true);
                    }
                    else restricted.getArmorRestrictions().setDefault(false);
                    break;
                case "permitted-armor":
                    for(String armorID : yml.getKeys("Armor.permitted-armor")) {
                        Armor armor = ArmorHandler.getInstance().get(armorID);
                        if(armor != null) {
                            restricted.getArmorRestrictions().setAllowed(armor, true);
                            if(restricted instanceof ArmorUser) {
                                LinkedHashMap<String, Object> infoMap = yml.getObject(LinkedHashMap.class, String.format("Armor.permitted-armor.%s", armorID));
                                loadBasicInfo(((ArmorUser)restricted).getArmorInfo(armor), infoMap);
                            }
                        }
                    }
                    break;
                case "restricted-armor":
                    for(String armorID : yml.getStringList("Armor.restricted-armor")) {
                        Armor armor = ArmorHandler.getInstance().get(armorID);
                        restricted.getArmorRestrictions().setAllowed(armor, false);
                    }
            }
        }
        return restricted.getArmorRestrictions();
    }

    protected LClassRestrictions loadLClassRestrictions(LClassRestricted restricted, String path, YAMLHelper yml) {
        for(String classKey : yml.getKeys("Class")) {
            switch(classKey) {
                case "default":
                    if(yml.getString("Class.default").equals("allow")) {
                        restricted.getLClassRestrictions().setDefault(true);
                    }
                    else restricted.getLClassRestrictions().setDefault(false);
                    break;
                case "permitted-class":
                    for(String classID : yml.getKeys("Class.permitted-class")) {
                        LClass lClass = LClassHandler.getInstance().get(classID);
                        if(lClass != null) {
                            restricted.getLClassRestrictions().setAllowed(lClass, true);
                            if(restricted instanceof LClassUser) {
                                LinkedHashMap<String, Object> infoMap = yml.getObject(LinkedHashMap.class, String.format("Class.permitted-class.%s", classID));
                                loadBasicInfo(((LClassUser)restricted).getLClassInfo(lClass), infoMap);
                            }
                        }
                    }
                    break;
                case "restricted-class":
                    for(String classID : yml.getKeys("Class.restricted-class")) {
                        LClass lClass = LClassHandler.getInstance().get(classID);
                        if(lClass != null) {
                            restricted.getLClassRestrictions().setAllowed(lClass, false);
                        }
                    }
            }
        }
        return restricted.getLClassRestrictions();
    }


    @Override
    public synchronized LClass loadLClass(String name) {
        return null; //TODO loadLClass method stub
    }
}
