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

import net.dawnfirerealms.legends.library.race.Race;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.HashMap;

/**
 * @author B2OJustin
 */
public class ConfigBuilder {
    static {
        // Default builders
        registerBuilder(Race.class, new RaceBuilder());
    }

    private static HashMap<Class, BasicBuilder> builderMap = new HashMap<>();

    public static <T> void registerBuilder(Class<T> clazz, BasicBuilder<T> builder) {
        builderMap.put(clazz, builder);
    }

    @SuppressWarnings("unchecked")
    public static <T> T load(YamlConfiguration config, Class<T> clazz) {
        BasicBuilder<T> builder = builderMap.get(clazz);
        return builder.load(config);
    }
}
