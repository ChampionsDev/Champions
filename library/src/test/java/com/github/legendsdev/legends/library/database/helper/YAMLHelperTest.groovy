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
package com.github.legendsdev.legends.library.database.helper

/**
 * @author B2OJustin
 */
class YAMLHelperTest extends GroovyTestCase {
    YAMLHelper yamlHelper;

    void setUp() {
        yamlHelper = new YAMLHelper("core/src/main/resources/races/Test.yml");
    }

    void testGetObject() {
        String name = (String) yamlHelper.getObject("name");
        assertEquals(name, "Test");
    }

    void testGetKeys() {
        ArrayList<String> keyList = yamlHelper.getKeys("Weapons");
        System.out.println(keyList);
        assertTrue(keyList.contains("default"));
        assertTrue(keyList.contains("permitted-weapon"));

        keyList = yamlHelper.getKeys("");
        System.out.println(keyList);
        assertTrue(keyList.contains("name"));
        assertTrue(keyList.contains("description"));
    }

    void testGetString() {
        assertEquals("Test", yamlHelper.getString("name"));
    }
}
