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
import net.dawnfirerealms.legends.library.armor.ArmorHandler;
import net.dawnfirerealms.legends.library.race.Race;
import net.dawnfirerealms.legends.library.restriction.Restrictions;
import net.dawnfirerealms.legends.library.weapon.Weapon;
import net.dawnfirerealms.legends.library.weapon.WeaponHandler;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.List;

/**
 * @author B2OJustin
 */
class RaceBuilder implements BasicBuilder<Race> {
    @Override
    public Race load(YamlConfiguration config) {
        List<String> description = config.getStringList("description");
        Race race = new Race().
            setName(config.getString("name")).
            setDescription(description.toArray(new String[description.size()]));

        // Allowed weapons
        Restrictions<Weapon> weaponRestrictions = race.getWeaponRestrictions();
        for(String name : config.getStringList("permitted-weapon")) {
            // TODO This builder should be rewritten for a sub module that allows for custom weapon classes
            Weapon weapon = new Weapon()
                    .setName(name);
            WeaponHandler.registerWeapon(name, weapon);
            weaponRestrictions.allow(weapon);
        }

        // Allowed armor
        Restrictions<Armor> armorRestrictions = race.getArmorRestrictions();
        for(String name : config.getStringList("permitted-armor")) {
            Armor armor = new Armor()
                    .setName(name);
            ArmorHandler.registerArmor(name, armor);
            armorRestrictions.allow(armor);
        }

        return race;
    }
}
