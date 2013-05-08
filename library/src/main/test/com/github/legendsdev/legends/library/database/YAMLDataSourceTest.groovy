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


/**
 * @author B2OJustin
 */
class YAMLDataSourceTest extends GroovyTestCase {
    YAMLDataSource yamlDataSource;

    void setUp() {
        yamlDataSource = new YAMLDataSource("src/main/resources/");
    }

    void testLoadLPlayer() {
    }

    void testLoadRace() {
        Race testRace = new Race();
        ArrayList<String> testRaceDescription = new ArrayList<>();
        testRaceDescription.add("Test Race");
        testRace.setName("Test");
        testRace.setDescription(testRaceDescription);
        testRace.getWeaponRestrictions().setDefault(false);
        testRace.getWeaponRestrictions().setAllowed("WOOD_AXE", true);
        testRace.getWeaponRestrictions().setAllowed("IRON_AXE", true);
        testRace.getWeaponRestrictions().setAllowed("DIAMOND_AXE", true);
        testRace.getWeaponInfo("IRON_AXE").addDamage(10);

        Race race = yamlDataSource.loadRace("Test");
        assertEquals(testRace.getName(), race.getName());
        assertEquals(testRace.getDescription(), race.getDescription());
        assertEquals(testRace.getWeaponRestrictions().isAllowed("WOOD_AXE"), true);
        assertEquals(testRace.getWeaponRestrictions().isAllowed("IRON_AXE"), true);
        assertEquals(testRace.getWeaponRestrictions().isAllowed("DIAMOND_AXE"), true);
    }

    void testLoadLClass() {
    }
}
