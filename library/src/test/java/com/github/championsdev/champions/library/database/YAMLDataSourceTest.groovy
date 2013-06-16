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
package com.github.championsdev.champions.library.database

import com.github.championsdev.champions.library.Configuration
import com.github.championsdev.champions.library.cclass.CClass
import com.github.championsdev.champions.library.cclass.CClassHandler
import com.github.championsdev.champions.library.cplayer.CPlayer
import com.github.championsdev.champions.library.cplayer.CPlayerHandler
import com.github.championsdev.champions.library.level.Level
import com.github.championsdev.champions.library.race.Race
import com.github.championsdev.champions.library.race.RaceHandler
import com.github.championsdev.champions.library.restriction.RestrictionHandler
import com.github.championsdev.champions.library.skill.Skill
import com.github.championsdev.champions.library.skill.SkillHandler
import com.github.championsdev.champions.library.weapon.Weapon
import com.github.championsdev.champions.library.weapon.WeaponHandler

/**
 * @author B2OJustin
 */
class YAMLDataSourceTest extends GroovyTestCase {
    YAMLDataSource yamlDataSource;
    WeaponHandler weaponHandler;
    RaceHandler raceHandler;
    CClassHandler lClassHandler;
    RestrictionHandler restrictionHandler;

    void setUp() {
        yamlDataSource = new YAMLDataSource("../core-bukkit/src/main/resources/resources/");
        weaponHandler = WeaponHandler.getInstance();
        yamlDataSource.loadConfiguration(Configuration.getInstance(), "config.yml");
        Configuration.getInstance().setYamlConfigPath("../core-bukkit/src/main/resources/resources/")
        DataManager.init(Configuration.getInstance());
        raceHandler = RaceHandler.getInstance();
        lClassHandler = CClassHandler.getInstance();
        restrictionHandler = RestrictionHandler.getInstance();
    }

    void testLoadLPlayer() {
        CPlayer lPlayer = CPlayerHandler.getInstance().load("TESTPLAYERDATA");
        assertEquals("Default", lPlayer.getPrimaryClass().getName());
        assertEquals(10, lPlayer.getPreviousPrimaryClasses().get(CClassHandler.getInstance().load("Default")).getLevel());
    }

    void testLoadRace() {
        // Register weapons
        weaponHandler.register("WOOD_AXE", new Weapon());
        weaponHandler.register("IRON_AXE", new Weapon());
        weaponHandler.register("DIAMOND_AXE", new Weapon());

        Race race = yamlDataSource.loadRace("Test");
        assertEquals("Test", race.getName());

        assertTrue(race.getDescription().contains("Test Race"));
        assertTrue(restrictionHandler.getWeaponRestrictions(race).isAllowed(weaponHandler.get("WOOD_AXE")));
        assertTrue(restrictionHandler.getWeaponRestrictions(race).isAllowed(weaponHandler.get("IRON_AXE")));
        assertTrue(restrictionHandler.getWeaponRestrictions(race).isAllowed(weaponHandler.get("DIAMOND_AXE")));
        assertEquals(5, race.getAttributes().getHealthPerLevel());
        assertEquals(2, race.getAttributes().getManaPerLevel());
        assertEquals(12, race.getAttributes().getHealth());
        assertEquals(23, race.getAttributes().getMana());
        assertEquals(race.getWeaponAttributes(weaponHandler.get("IRON_AXE")).getWeaponDamage(), 10)
    }

    void testLoadConfiguration() {
        Configuration config = Configuration.getInstance();
        yamlDataSource.loadConfiguration(config, "config.yml");
        assertEquals(config.getYamlConfigPath(), "Champions/");
    }

    void testSaveLPlayer() {
        CPlayer lPlayer = new CPlayer(raceHandler.load("Human"), lClassHandler.load("Default"), lClassHandler.load("Default"));
        lPlayer.setName("TESTPLAYERDATA");
        lPlayer.addPreviousPrimaryClass(lClassHandler.load("Default"), new Level(10));
        DataManager.getDataSource().saveLPlayer(lPlayer);
    }

    void testLoadLClass() {
        CClass lClass = CClassHandler.getInstance().load("Default");
        assertEquals(5, lClass.getAttributes().getHealthPerLevel())
        assertEquals(5, lClass.getAttributes().getManaPerLevel());
    }

    void testLoadSkill() {
        Skill skill = SkillHandler.getInstance().load("Test");
        assertEquals("Test Skill", skill.getName());
        assertEquals("This is a test. This is only a test.", skill.getDescription().get(0));
        assertEquals(1, skill.getAttributes().getDamage());
        assertEquals(2, skill.getAttributes().getCooldownSeconds());
        assertEquals(3, skill.getAttributes().getManaCost());
        assertEquals(4, skill.getAttributes().getHealthCost());
        assertEquals(5, skill.getAttributes().getStaminaCost());
    }
}
