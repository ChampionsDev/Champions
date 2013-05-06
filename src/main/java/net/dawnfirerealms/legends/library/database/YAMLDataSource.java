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
package net.dawnfirerealms.legends.library.database;

import net.dawnfirerealms.legends.core.LPlayer;
import net.dawnfirerealms.legends.library.lclass.LClass;
import net.dawnfirerealms.legends.library.race.Race;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Logger;

/**
 * @author B2OJustin
 */
public class YAMLDataSource implements DataSource {
    public static final Logger logger = Logger.getLogger(YAMLDataSource.class.getName());
    private String configPath = "";
    private final String RACE_PATH = "races/";
    private final String SKILL_PATH = "skills/";
    private final String PLAYER_PATH = "players/";
    private final String CLASS_PATH = "classes/";

    private Yaml yaml = new Yaml();

    @Override
    public String getName() {
        return "YAML";
    }

    public YAMLDataSource setPath(String filePath) {
        configPath = filePath;
        return this;
    }
    @Override
    public Logger getLogger() {
        return YAMLDataSource.logger;
    }

    @Override
    public LPlayer loadLPlayer(String name) {
        return null; //TODO loadLPlayer method stub
    }

    @Override
    public Race loadRace(String name) {
        Race race = new Race();
        try {
            InputStream fileStream = new FileInputStream(new File(CONFIG_PATH + RACE_PATH + name + ".yml"));
            race = (Race) yaml.load(fileStream);
        } catch (FileNotFoundException e) {
            logger.warning("Could not find file for race '" + name + "'");
        }


        /*List<String> description = config.getStringList("description");
        Race race = new Race().
                setName(config.getString("name")).
                setDescription(description.toArray(new String[description.size()]));

        // Allowed weapons
        WeaponRestrictions weaponRestrictions = race.getWeaponRestrictions();
        for(String name : config.getStringList("permitted-weapon")) {
            Weapon weapon = WeaponHandler.getInstance().get(name);
            weaponRestrictions.setAllowed(weapon, true);
        }

        // Allowed armor
        ArmorRestrictions armorRestrictions = race.getArmorRestrictions();
        for(String name : config.getStringList("permitted-armor")) {
            Armor armor = ArmorHandler.getInstance().get(name);
            armorRestrictions.setAllowed(armor, true);
        }
        */
        return race;
    }

    @Override
    public LClass loadLClass(String name) {
        return null; //TODO loadLClass method stub
    }
}
