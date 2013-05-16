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
package com.github.legendsdev.legends.library.database

import com.github.legendsdev.legends.library.Configuration
import com.github.legendsdev.legends.library.race.Race
import com.github.legendsdev.legends.library.restriction.RestrictionHandler
import com.github.legendsdev.legends.library.weapon.Weapon
import com.github.legendsdev.legends.library.weapon.WeaponHandler


/**
 * @author B2OJustin
 */
class YAMLDataSourceTest extends GroovyTestCase {
    YAMLDataSource yamlDataSource;
    WeaponHandler weaponHandler;

    void setUp() {
        yamlDataSource = new YAMLDataSource("../core-bukkit/src/main/resources/resources/");
        weaponHandler = WeaponHandler.getInstance();
    }

    void testLoadLPlayer() {
    }

    void testLoadRace() {
        RestrictionHandler restrictionHandler = RestrictionHandler.getInstance();
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
        assertEquals(5, race.getDefaultInfo().getHealthPerLevel());
        assertEquals(2, race.getDefaultInfo().getManaPerLevel());
        assertEquals(12, race.getDefaultInfo().getBonusHealth());
        assertEquals(23, race.getDefaultInfo().getBonusMana());
        assertEquals(race.getWeaponInfo(weaponHandler.get("IRON_AXE")).getBonusWeaponDamage(), 10)
    }

    void testLoadConfiguration() {
        Configuration config = Configuration.getInstance();
        yamlDataSource.loadConfiguration(config, "config.yml");
        assertEquals(config.getYamlConfigPath(), "Legends/");
    }

    void testLoadLClass() {
    }
}
