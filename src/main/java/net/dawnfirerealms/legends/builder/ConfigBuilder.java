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
package net.dawnfirerealms.legends.builder;

import net.dawnfirerealms.legends.library.armor.Armor;
import net.dawnfirerealms.legends.library.race.Race;
import net.dawnfirerealms.legends.library.skill.Skill;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 * @author B2OJustin
 */
public class ConfigBuilder {
    public static <T> T load(YamlConfiguration config, Class<T> clazz) {
        // Race
        if(Race.class.equals(clazz)) {
            RaceBuilder raceBuilder = new RaceBuilder();
            return (T) raceBuilder.load(config);
        }

        // Armor
        else if(Armor.class.equals(clazz)) {
            return null;
        }

        // Skill
        else if(Skill.class.equals(clazz)) {
            return null;
        }

        return null;
    }
}
