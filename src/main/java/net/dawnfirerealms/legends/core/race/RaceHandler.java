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

package net.dawnfirerealms.legends.core.race;

import net.dawnfirerealms.legends.builder.ConfigBuilder;
import net.dawnfirerealms.legends.core.LegendsPlugin;
import net.dawnfirerealms.legends.core.utils.ConfigHandler;
import net.dawnfirerealms.legends.library.race.Race;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.HashMap;

/**
 * @author Ranzdo
 */
public class RaceHandler {
    public static final String CONFIG_PATH = "race/";
    public HashMap<String, Race> raceMap;

    public RaceHandler() {
        reload();
    }

    public void reload() {
        ConfigHandler configHandler = LegendsPlugin.instance.getConfigHandler();
        raceMap = new HashMap<>();

        File folder = new File(CONFIG_PATH);
        for(File file : folder.listFiles()) {
            YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
            Race race = ConfigBuilder.load(config, Race.class);
            addRace(race);
        }
    }

    public Race getRace(String name) {
        return raceMap.get(name);
    }

    public void addRace(Race race) {
        raceMap.put(race.getName(), race);
    }

    public void removeRace(String name) {
        raceMap.remove(name);
    }
}
