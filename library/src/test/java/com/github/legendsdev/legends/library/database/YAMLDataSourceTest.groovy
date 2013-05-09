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

import com.github.legendsdev.legends.library.race.Race
import com.github.legendsdev.legends.library.weapon.Weapon
import com.github.legendsdev.legends.library.weapon.WeaponHandler


/**
 * @author B2OJustin
 */
class YAMLDataSourceTest extends GroovyTestCase {
    YAMLDataSource yamlDataSource;
    WeaponHandler weaponHandler;

    void setUp() {
        yamlDataSource = new YAMLDataSource("core/src/main/resources/");
        weaponHandler = WeaponHandler.getInstance();
    }

    void testLoadLPlayer() {
    }

    void testLoadRace() {
        Race race = yamlDataSource.loadRace("Test");
        assertEquals("Test", race.getName());

        // Register weapons
        weaponHandler.register("WOOD_AXE", new Weapon());
        weaponHandler.register("IRON_AXE", new Weapon());
        weaponHandler.register("DIAMOND_AXE", new Weapon());

        assertTrue(race.getDescription().contains("Test Race"));
        assertTrue(race.getWeaponRestrictions().isAllowed(weaponHandler.get("WOOD_AXE")));
        assertTrue(race.getWeaponRestrictions().isAllowed(weaponHandler.get("IRON_AXE")));
        assertTrue(race.getWeaponRestrictions().isAllowed(weaponHandler.get("DIAMOND_AXE")));

        assertEquals(race.getWeaponInfo(weaponHandler.get("IRON_AXE")).getBonusDamage(), 10)
    }

    void testLoadLClass() {
    }
}
