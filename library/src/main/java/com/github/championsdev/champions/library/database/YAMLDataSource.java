/*******************************************************************************
 * This file is part of Champions.
 *
 *     Champions is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Champions is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Champions.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package com.github.championsdev.champions.library.database;

import com.github.championsdev.champions.library.BasicAttributes;
import com.github.championsdev.champions.library.BasicCategory;
import com.github.championsdev.champions.library.Configuration;
import com.github.championsdev.champions.library.StatsInfo;
import com.github.championsdev.champions.library.armor.Armor;
import com.github.championsdev.champions.library.armor.ArmorHandler;
import com.github.championsdev.champions.library.armor.ArmorRestricted;
import com.github.championsdev.champions.library.armor.ArmorUser;
import com.github.championsdev.champions.library.cclass.CClass;
import com.github.championsdev.champions.library.cclass.CClassHandler;
import com.github.championsdev.champions.library.cclass.CClassRestricted;
import com.github.championsdev.champions.library.cclass.CClassUser;
import com.github.championsdev.champions.library.cplayer.CPlayer;
import com.github.championsdev.champions.library.database.helper.YAMLHelper;
import com.github.championsdev.champions.library.level.Level;
import com.github.championsdev.champions.library.level.LevelRestricted;
import com.github.championsdev.champions.library.level.exp.ExpGroup;
import com.github.championsdev.champions.library.level.exp.ExpGroupHandler;
import com.github.championsdev.champions.library.level.exp.sources.*;
import com.github.championsdev.champions.library.party.Party;
import com.github.championsdev.champions.library.race.Race;
import com.github.championsdev.champions.library.race.RaceHandler;
import com.github.championsdev.champions.library.restriction.BasicRestrictions;
import com.github.championsdev.champions.library.restriction.RestrictionHandler;
import com.github.championsdev.champions.library.skill.Skill;
import com.github.championsdev.champions.library.skill.SkillHandler;
import com.github.championsdev.champions.library.util.FileClassLoader;
import com.github.championsdev.champions.library.util.FileUtils;
import com.github.championsdev.champions.library.weapon.*;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Thread safe class for accessing YAML database.
 *
 * @author B2OJustin
 */
//TODO Metadata saving
@SuppressWarnings("unchecked")
public class YAMLDataSource implements DataSource {
    private static final Logger logger = Logger.getLogger(YAMLDataSource.class.getName());
    private String configPath;
    private final String RACE_PATH = "races/";
    private final String SKILL_PATH = "skills/";
    private final String PLAYER_PATH = "players/";
    private final String CLASS_PATH = "classes/";
    private final String EXP_PATH = "exp/";
    private final String WEAPON_TYPE_PATH = "weapons/types/";
    private final String WEAPON_PATH = "weapons/";


    @Override
    public String getName() {
        return "YAML";
    }

    public YAMLDataSource(String configPath) {
        this.configPath = configPath;
        if(!configPath.endsWith("/")) configPath = configPath.concat("/");
    }

    @Override
    public Logger getLogger() {
        return YAMLDataSource.logger;
    }

    @Override
    public synchronized CPlayer loadLPlayer(String name) {
        String filePath = configPath + PLAYER_PATH + name.replace(" ", "_") + ".yml";
        CPlayer lPlayer = null;
        try {
            YAMLHelper yamlHelper = new YAMLHelper(filePath);

            lPlayer = new CPlayer(
                    RaceHandler.getInstance().load(yamlHelper.getString("race")),
                    CClassHandler.getInstance().load(yamlHelper.getString("primary-class")),
                    CClassHandler.getInstance().load(yamlHelper.getString("secondary-class"))
            );
            lPlayer.setName(name);
            lPlayer.setDescription(yamlHelper.getStringList("description"));
            lPlayer.getPrimaryClassAttributes().getLevel().setLevel(yamlHelper.getInt("primary-class-level"));
            lPlayer.getPrimaryClassAttributes().getLevel().setExp(yamlHelper.getDouble("primary-class-exp"));
            lPlayer.getSecondaryClassAttributes().getLevel().setLevel(yamlHelper.getInt("secondary-class-level"));
            lPlayer.getSecondaryClassAttributes().getLevel().setExp(yamlHelper.getDouble("secondary-class-exp"));

            for(Map.Entry<String, Integer> entry : yamlHelper.getIntMap("previous-primary-class").entrySet()) {
                lPlayer.addPreviousPrimaryClass(CClassHandler.getInstance().load(entry.getKey()), new Level(entry.getValue()));
            }

            for(Map.Entry<String, Integer> entry : yamlHelper.getIntMap("previous-secondary-class").entrySet()) {
                lPlayer.addPreviousPrimaryClass(CClassHandler.getInstance().load(entry.getKey()), new Level(entry.getValue()));
            }


        } catch (FileNotFoundException ex) {
            logger.warning("Could not find file for player '" + name + "' at " + filePath);
        } catch (ClassCastException ex) {
            logger.warning("You seem to have an error in your yaml. Could not load player '" + name + "'");
        }
        return lPlayer;
    }

    @Override
    public void saveLPlayer(CPlayer lPlayer) {
        LinkedHashMap<String, Object> playerMap = new LinkedHashMap<>(20);
        playerMap.put("name", lPlayer.getName());
        playerMap.put("description", lPlayer.getDescription());
        playerMap.put("race", lPlayer.getRace().getId());
        playerMap.put("primary-class", lPlayer.getPrimaryClass().getId());
        playerMap.put("primary-class-level", lPlayer.getPrimaryClassAttributes().getLevel().getLevel());
        playerMap.put("primary-class-exp", lPlayer.getPrimaryClassAttributes().getLevel().getExp());
        playerMap.put("secondary-class", lPlayer.getSecondaryClass().getId());
        playerMap.put("secondary-class-level", lPlayer.getSecondaryClassAttributes().getLevel().getLevel());
        playerMap.put("secondary-class-exp", lPlayer.getSecondaryClassAttributes().getLevel().getExp());

        // Previous primary classes
        LinkedHashMap<String, Integer> previousPrimaryClasses = new LinkedHashMap<>();
        for(Map.Entry<CClass, Level> entry : lPlayer.getPreviousPrimaryClasses().entrySet()) {
            previousPrimaryClasses.put(entry.getKey().getName(), entry.getValue().getLevel());
        }
        playerMap.put("previous-primary-class", previousPrimaryClasses);

        // Previous secondary classes
        LinkedHashMap<String, Integer> previousSecondaryClasses = new LinkedHashMap<>();
        for(Map.Entry<CClass, Level> entry : lPlayer.getPreviousSecondaryClasses().entrySet()) {
            previousPrimaryClasses.put(entry.getKey().getName(), entry.getValue().getLevel());
        }
        playerMap.put("previous-secondary-class", previousSecondaryClasses);

        try {
            File outputFile = new File(configPath + PLAYER_PATH + lPlayer.getName() + ".yml");
            if(!outputFile.exists()) {
                outputFile.getParentFile().mkdirs();
                outputFile.createNewFile();
            }
            Yaml yaml = new Yaml();
            FileUtils.writeStringToFile(outputFile, yaml.dump(playerMap));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public synchronized Race loadRace(String id) {
        String filePath = configPath + RACE_PATH + id.replace(" ", "_") + ".yml";
        try {
            Race race;

            // Load custom race file if exists
            Class raceClass = FileClassLoader.load(Race.class, configPath + RACE_PATH, id);
            if(raceClass != null) {
                race = (Race)raceClass.newInstance();
            } else race = new Race();
            race.setId(id);

            YAMLHelper yml = new YAMLHelper(filePath);
            // TODO weapon type bonuses
            for(String mainKey : yml.getKeys("")) {
                switch(mainKey) {
                    case "name":
                        race.setName(yml.getString(mainKey));
                        break;
                    case "description":
                        race.setDescription(yml.getStringList(mainKey));
                        break;
                    case "Weapons":
                        RestrictionHandler.getInstance().setWeaponRestrictions(race, loadWeaponRestrictions(race, yml));
                        RestrictionHandler.getInstance().setWeaponTypeRestrictions(race, loadWeaponCategoryRestrictions(race, yml));
                        break;
                    case "Armor":
                        RestrictionHandler.getInstance().setArmorRestrictions(race, loadArmorRestrictions(race, yml));
                        break;
                    case "Class":
                        RestrictionHandler.getInstance().setClassRestrictions(race, loadClassRestrictions(race, yml));
                        break;
                    case "Stats":
                        loadStats(race.getAttributes(), yml);
                        break;
                    default:
                        race.getMetadata().put(mainKey, yml.getObject(mainKey));
                        break;
                }
            }

            return race;

        } catch (FileNotFoundException e) {
            logger.warning("Could not find file for race '" + id + "' at " + filePath);
        } catch (ClassCastException e) {
            logger.warning("You seem to have an error in your yaml. Could not load race '" + id + "'");
        } catch(IllegalAccessException | InstantiationException ignored) {}

        return null;
    }

    @Override
    public synchronized CClass loadLClass(String id) {
        String filePath = configPath + CLASS_PATH + id.replace(" ", "_") + ".yml";
        CClass cClass;
        try {
            // Load custom class file if exists
            Class lClassClass = FileClassLoader.load(Race.class, configPath + CLASS_PATH, id);
            if(lClassClass != null) {
                cClass = (CClass)lClassClass.newInstance();
            } else cClass = new CClass();
            cClass.setId(id);

            YAMLHelper yml = new YAMLHelper(filePath);

            // TODO weapon type bonuses
            for(String mainKey : yml.getKeys("")) {
                switch(mainKey) {
                    case "name":
                        cClass.setName(yml.getString(mainKey));
                        break;
                    case "description":
                        cClass.setDescription(yml.getStringList(mainKey));
                        break;
                    case "Weapons":
                        RestrictionHandler.getInstance().setWeaponRestrictions(cClass, loadWeaponRestrictions(cClass, yml));
                        RestrictionHandler.getInstance().setWeaponTypeRestrictions(cClass, loadWeaponCategoryRestrictions(cClass, yml));
                        break;
                    case "Armor":
                        RestrictionHandler.getInstance().setArmorRestrictions(cClass, loadArmorRestrictions(cClass, yml));
                        break;
                    case "Stats":
                        loadStats(cClass.getAttributes(), yml);
                        break;
                    case "Levels":
                        loadLevels(cClass, yml);
                        break;
                    default:
                        cClass.getMetadata().put(mainKey, yml.getObject(mainKey));
                        break;
                }
            }

            return cClass;

        } catch (FileNotFoundException e) {
            logger.warning("Could not find file for class '" + id + "' at " + filePath);
        } catch (ClassCastException e) {
            logger.warning("You seem to have an error in your yaml. Could not load class '" + id + "'");
            e.printStackTrace();
        } catch(IllegalAccessException | InstantiationException ignored) {}

        return null;
    }

    @Override
    public Skill loadSkill(String id) {
        String filePath = configPath + SKILL_PATH + id.replace(" ", "_") + ".yml";
        try {
            Skill skill = new Skill();
            YAMLHelper yml = new YAMLHelper(filePath);
            for(String key : yml.getKeys("")) {
                switch(key.toLowerCase()) {
                    case "name":
                        skill.setName(yml.getString(key));
                        break;
                    case "description":
                        skill.setDescription(yml.getStringList(key));
                        break;
                    case "mana-cost":
                        skill.getAttributes().setManaCost(yml.getInt(key));
                        break;
                    case "health-cost":
                        skill.getAttributes().setHealthCost(yml.getInt(key));
                        break;
                    case "stamina-cost":
                        skill.getAttributes().setStaminaCost(yml.getInt(key));
                        break;
                    case "damage":
                        skill.getAttributes().setDamage(yml.getInt(key));
                        break;
                    case "cooldown":
                        skill.getAttributes().setCooldownSeconds(yml.getInt(key));
                        break;
                    default:
                        skill.getMetadata().put(key, yml.getObject(key));
                        break;
                }
            }
            return skill;
        } catch (FileNotFoundException e) {
            logger.warning("Could not find file for skill '" + id + "' at " + filePath);
        } catch (ClassCastException e) {
            logger.warning("You seem to have an error in your yaml. Could not load skill '" + id + "'");
        }
        return null;
    }

    @Override
    public Weapon loadWeapon(String id) {
        String filePath = configPath + WEAPON_PATH + id.replace(" ", "_") + ".yml";
        try {
            Weapon weapon = new Weapon();
            YAMLHelper yml = new YAMLHelper(filePath);
            loadBasicInfo(weapon.getAttributes(), "", yml);
            for(String key : yml.getKeys("")) {
                switch(key.toLowerCase()) {
                    case "name":
                        weapon.setName(yml.getString("name"));
                        break;
                    default:
                        weapon.getMetadata().put(key, yml.getObject(key));
                        break;
                }
            }
            return weapon;
        } catch (FileNotFoundException e) {
            logger.warning("Could not find file for weapon '" + id + "' at " + filePath);
        } catch (ClassCastException e) {
            logger.warning("You seem to have an error in your yaml. Could not load weapon '" + id + "'");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BasicCategory<WeaponAttributes> loadWeaponCategory(String id) {
        String filePath = configPath + WEAPON_TYPE_PATH + id.replace(" ", "_") + ".yml";
        try {
            BasicCategory<WeaponAttributes> weaponCategory = new BasicCategory<>();
            YAMLHelper yml = new YAMLHelper(filePath);
            loadBasicInfo(weaponCategory.getAttributes(), "", yml);
            for(String key : yml.getKeys("")) {
                switch(key.toLowerCase()) {
                    case "name":
                        weaponCategory.setName(yml.getString(key));
                        break;
                }
            }
            return weaponCategory;
        } catch (FileNotFoundException e) {
            logger.warning("Could not find file for weapon type '" + id + "' at " + filePath);
        } catch (ClassCastException e) {
            logger.warning("You seem to have an error in your yaml. Could not load weapon type '" + id + "'");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Party loadParty(String name) {
        return null;  // TODO
    }

    @Override
    public synchronized ExpGroup loadExpGroup(String id) {
        String filePath = configPath + EXP_PATH + id.replace(" ", "_") + ".yml";
        try {
            ExpGroup expGroup = new ExpGroup(id);
            YAMLHelper yml = new YAMLHelper(filePath);
            for(String typeKey : yml.getKeys("")) {
                switch(ExpSourceType.valueOf(typeKey.toUpperCase())) {
                    case MOB_KILL:
                        for(Map.Entry<String, Double> mobEntry : yml.getDoubleMap(typeKey).entrySet()) {
                            expGroup.add(new MobKillExpSource(mobEntry.getKey()), mobEntry.getValue());
                        }
                        break;
                    case PLAYER_KILL:
                        for(Map.Entry<String, Double> playerEntry : yml.getDoubleMap(typeKey).entrySet()) {
                            expGroup.add(new PlayerKillExpSource(playerEntry.getKey()), playerEntry.getValue());
                        }
                        break;
                    case BLOCK_BREAK:
                        for(Map.Entry<String, Double> blockEntry : yml.getDoubleMap(typeKey).entrySet()) {
                            expGroup.add(new BlockBreakExpSource(blockEntry.getKey()), blockEntry.getValue());
                        }
                        break;
                    case BLOCK_PLACE:
                        for(Map.Entry<String, Double> blockEntry : yml.getDoubleMap(typeKey).entrySet()) {
                            expGroup.add(new BlockPlaceExpSource(blockEntry.getKey()), blockEntry.getValue());
                        }
                        break;
                    case CRAFT:
                        for(Map.Entry<String, Double> blockEntry : yml.getDoubleMap(typeKey).entrySet()) {
                            expGroup.add(new CraftItemExpSource(blockEntry.getKey()), blockEntry.getValue());
                        }
                        break;
                    case ENCHANT:
                        for(Map.Entry<String, Double> blockEntry : yml.getDoubleMap(typeKey).entrySet()) {
                            expGroup.add(new EnchantExpSource(blockEntry.getKey()), blockEntry.getValue());
                        }
                        break;
                    case SKILL:
                        for(Map.Entry<String, Double> skillEntry : yml.getDoubleMap(typeKey).entrySet()) {
                            expGroup.add(new SkillUseExpSource(SkillHandler.getInstance().load(skillEntry.getKey())), skillEntry.getValue());
                        }
                        break;
                }
            }
            return expGroup;
        } catch (FileNotFoundException e) {
            logger.warning("Could not find file for experience source '" + id + "' at " + filePath);
        } catch (ClassCastException e) {
            logger.warning("You seem to have an error in your yaml. Could not load experience source '" + id + "'");
            e.printStackTrace();
        }
        return null;
    }

    public synchronized void loadConfiguration(Configuration config, String file) throws FileNotFoundException {
        YAMLHelper yml = new YAMLHelper(configPath + file);

        // Main configuration
        for(String configKey : yml.getKeys("")) {
            switch(configKey.toLowerCase()) {
                case "database-type":
                    config.setDatabaseType(yml.getString(configKey));
                    break;
                case "default-race":
                    config.setDefaultRace(yml.getString(configKey));
                    break;
                case "default-primary-class":
                    config.setDefaultPrimaryClass(yml.getString(configKey));
                    break;
                case "default-secondary-class":
                    config.setDefaultSecondaryClass(yml.getString(configKey));
                    break;
                case "experience-curve":
                    config.setExpCurve(yml.getString(configKey));
                    break;
            }
        }

        // YAML database configuration
        if(config.getDatabaseType().toUpperCase().equals("YAML")) {
            for(String yamlKey : yml.getKeys("YAML")) {
                switch(yamlKey.toLowerCase()) {
                    case "config-path":
                        config.setYamlConfigPath(yml.getString("YAML.config-path"));
                        break;
                }
            }
        }
    }

    // TODO implement yaml configuration saving
    public synchronized YAMLDataSource saveConfiguration(String file) {
        return this;
    }

    protected <T extends BasicAttributes> T loadBasicInfo(T basicInfo, String path, YAMLHelper yml) throws ClassCastException {
        for(String infoKey : yml.getKeys(path)) {
            switch(infoKey.toLowerCase()) {
                case "bonus-defense":
                    int bonusDefense = yml.getInt(String.format("%s.%s", path, infoKey));
                    basicInfo.addDefense(bonusDefense);
                    break;
                case "bonus-weapon-damage":
                    int bonusDamage = yml.getInt(String.format("%s.%s", path, infoKey));
                    basicInfo.addWeaponDamage(bonusDamage);
                    break;
                case "bonus-minimum-weapon-damage":
                    int bonusMin = yml.getInt(String.format("%s.%s", path, infoKey));
                    basicInfo.addBonusMinWeaponDamage(bonusMin);
                    break;
                case "bonus-maximum-weapon-damage":
                    int bonusMax = yml.getInt(String.format("%s.%s", path, infoKey));
                    basicInfo.addBonusMaxWeaponDamage(bonusMax);
                    break;
                case "bonus-skill-damage":
                    int skillBonusDamage = yml.getInt(String.format("%s.%s", path, infoKey));
                    basicInfo.addSkillDamage(skillBonusDamage);
                    break;
                case "bonus-minimum-skill-damage":
                    int skillBonusMinDamage = yml.getInt(String.format("%s.%s", path, infoKey));
                    basicInfo.addBonusMinSkillDamage(skillBonusMinDamage);
                    break;
                case "bonus-maximum-skill-damage":
                    int skillBonusMaxDamage = yml.getInt(String.format("%s.%s", path, infoKey));
                    basicInfo.addBonusMaxSkillDamage(skillBonusMaxDamage);
                    break;
                case "bonus-stamina":
                    int bonusStamina = yml.getInt(String.format("%s.%s", path, infoKey));
                    basicInfo.addStamina(bonusStamina);
                    break;
                case "bonus-health":
                    int bonusHealth = yml.getInt(String.format("%s.%s", path, infoKey));
                    basicInfo.addHealth(bonusHealth);
                    break;
                case "bonus-mana":
                    int bonusMana = yml.getInt(String.format("%s.%s", path, infoKey));
                    basicInfo.addMana(bonusMana);
                    break;

                // Level restricted
                case "required-level":
                    if(basicInfo instanceof LevelRestricted) {
                        int requiredLevel = yml.getInt(String.format("%s.%s", path, infoKey));
                        RestrictionHandler.getInstance().getLevelRestrictions((LevelRestricted)basicInfo).setMinLevel(requiredLevel);
                    }
                    break;
                case "maximum-level":
                    if(basicInfo instanceof  LevelRestricted) {
                        int maximumLevel = yml.getInt(String.format("%s.%s", path, infoKey));
                        RestrictionHandler.getInstance().getLevelRestrictions((LevelRestricted)basicInfo).setMaxLevel(maximumLevel);
                    }
                    break;
            }
        }
        return basicInfo;
    }

    protected synchronized StatsInfo loadStats(StatsInfo stats, YAMLHelper yml) {
        if(stats == null) return null;
        String path = "Stats";
        for(String statKey : yml.getKeys(path)) {
            switch(statKey.toLowerCase()) {
                case "health-per-level":
                    int healthPerLevel = yml.getInt(String.format("%s.%s", path, statKey));
                    stats.setHealthPerLevel(healthPerLevel);
                    break;
                case "mana-per-level":
                    int manaPerLevel = yml.getInt(String.format("%s.%s", path, statKey));
                    stats.setManaPerLevel(manaPerLevel);
                    break;
                case "stamina-per-level":
                    int staminaPerLevel = yml.getInt(String.format("%s.%s", path, statKey));
                    stats.setStaminaPerLevel(staminaPerLevel);
                    break;
            }
        }
        // Basic bonuses
        if(stats instanceof BasicAttributes) {
            loadBasicInfo((BasicAttributes)stats, "Stats", yml);
        }
        return stats;
    }

    protected synchronized CClass loadLevels(CClass cClass, YAMLHelper yml) {
        if(cClass == null) return null;
        for (String levelKey : yml.getKeys("Levels")) {
            switch(levelKey.toLowerCase()) {
                case "experience-sources":
                    for(String sourceKey : yml.getKeys("Levels.experience-sources")) {
                            float expModifier = 1f;
                            for(String modKey : yml.getKeys(String.format("Levels.experience-sources.%s", sourceKey))) {
                                switch(modKey.toLowerCase()) {
                                    case "modifier":
                                        expModifier = yml.getFloat(String.format("Levels.experience-sources.%s.%s", sourceKey, modKey));
                                        break;
                                 }
                            }
                        cClass.addExpGroup(ExpGroupHandler.getInstance().load(sourceKey), expModifier);
                    }
                    break;
                case "max-level":
                    // Sets mastery level to max level if necessary
                    int maxLevel = yml.getInt("Levels.max-level");
                    cClass.getAttributes().setMaxLevel(new Level(maxLevel));
                    if(cClass.getAttributes().getMasteryLevel().equals(new Level(0))) {
                        cClass.getAttributes().setMasteryLevel(new Level(maxLevel));
                    }
                    break;
                case "mastery-level":
                    cClass.getAttributes().setMasteryLevel(new Level(yml.getInt("Levels.mastery-level")));
                    break;
                case "experience-curve":
                    //TODO experience curve implementation
                    break;
            }


        }
        return cClass;
    }

    protected synchronized BasicRestrictions<Weapon> loadWeaponRestrictions(WeaponRestricted restricted, YAMLHelper yml) {
        BasicRestrictions<Weapon> weaponRestrictions = new BasicRestrictions<>();
        for(String wepKey : yml.getKeys("Weapons")) {
            switch(wepKey.toLowerCase()) {
                case "default":
                    if(yml.getString("Weapons.default").equals("allow")) {
                        weaponRestrictions.setDefault(true);
                    }
                    else weaponRestrictions.setDefault(false);
                    break;
                case "permitted-weapon":
                    for(String wepID : yml.getKeys("Weapons.permitted-weapon")) {
                        Weapon weapon = WeaponHandler.getInstance().load(wepID);
                        weaponRestrictions.setAllowed(weapon, true);
                        if(restricted instanceof WeaponUser) {
                            loadBasicInfo(((WeaponUser)restricted).getWeaponAttributes(weapon), String.format("Weapons.permitted-weapon.%s", wepID), yml);
                        }
                    }
                    break;
                case "restricted-weapon":
                    for(String wepID : yml.getStringList("Weapons.restricted-weapon")) {
                        Weapon weapon = WeaponHandler.getInstance().load(wepID);
                        weaponRestrictions.setAllowed(weapon, false);
                    }
                    break;
            }
        }
        return weaponRestrictions;
    }

    protected synchronized BasicRestrictions<BasicCategory<WeaponAttributes>> loadWeaponCategoryRestrictions(WeaponCategoryRestricted restricted, YAMLHelper yml) {
        BasicRestrictions<BasicCategory<WeaponAttributes>> weaponCategoryRestrictions = new BasicRestrictions<>();
        for(String typeKey : yml.getKeys("Weapons")) {
            switch(typeKey.toLowerCase()) {
                case "permitted-weapon-type":
                    for(String typeID : yml.getKeys("Weapons.permitted-weapon-type")) {
                        BasicCategory<WeaponAttributes> weaponCategory = WeaponCategoryHandler.getInstance().load(typeID);
                        weaponCategoryRestrictions.setAllowed(weaponCategory, true);
                        if(restricted instanceof WeaponUser) {
                            loadBasicInfo(((WeaponUser)restricted).getWeaponCategoryAttributes(weaponCategory), String.format("Weapons.permitted-weapon.%s", typeID), yml);
                        }
                    }
                    break;
                case "restricted-weapon-type":
                    for(String typeID : yml.getStringList("Weapons.restricted-weapon-type")) {
                        BasicCategory<WeaponAttributes> weaponCategory = WeaponCategoryHandler.getInstance().load(typeID);
                        weaponCategoryRestrictions.setAllowed(weaponCategory, false);
                    }
                    break;
            }
        }
        return weaponCategoryRestrictions;
    }

    protected BasicRestrictions<Armor> loadArmorRestrictions(ArmorRestricted restricted, YAMLHelper yml) {
        BasicRestrictions<Armor> restrictions = new BasicRestrictions<>();
        for(String armorKey : yml.getKeys("Armor")) {
            switch(armorKey.toLowerCase()) {
                case "default":
                    if(yml.getString("Armor.default").equals("allow")) {
                        restrictions.setDefault(true);
                    }
                    else restrictions.setDefault(false);
                    break;
                case "permitted-armor":
                    for(String armorID : yml.getKeys("Armor.permitted-armor")) {
                        Armor armor = ArmorHandler.getInstance().get(armorID);
                        if(armor != null) {
                            restrictions.setAllowed(armor, true);
                            if(restricted instanceof ArmorUser) {
                                loadBasicInfo(((ArmorUser)restricted).getArmorAttributes(armor), String.format("Armor.permitted-armor.%s", armorID), yml);
                            }
                        }
                    }
                    break;
                case "restricted-armor":
                    for(String armorID : yml.getStringList("Armor.restricted-armor")) {
                        Armor armor = ArmorHandler.getInstance().get(armorID);
                        restrictions.setAllowed(armor, false);
                    }
            }
        }
        return restrictions;
    }

    protected BasicRestrictions<CClass> loadClassRestrictions(CClassRestricted restricted, YAMLHelper yml) {
        BasicRestrictions<CClass> restrictions = new BasicRestrictions<CClass>();
        for(String classKey : yml.getKeys("Class")) {
            switch(classKey.toLowerCase()) {
                case "default":
                    if(yml.getString("Class.default").equals("allow")) {
                        restrictions.setDefault(true);
                    }
                    else restrictions.setDefault(false);
                    break;
                case "permitted-class":
                    for(String classID : yml.getKeys("Class.permitted-class")) {
                        CClass cClass = CClassHandler.getInstance().get(classID);
                        if(cClass != null) {
                            restrictions.setAllowed(cClass, true);
                            if(restricted instanceof CClassUser) {
                                loadBasicInfo(((CClassUser)restricted).getCClassAttributes(cClass), String.format("Class.permitted-class.%s", classID), yml);
                            }
                        }
                    }
                    break;
                case "restricted-class":
                    for(String classID : yml.getKeys("Class.restricted-class")) {
                        CClass cClass = CClassHandler.getInstance().get(classID);
                        if(cClass != null) {
                            restrictions.setAllowed(cClass, false);
                        }
                    }
            }
        }
        return restrictions;
    }
}
