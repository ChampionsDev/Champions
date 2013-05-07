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

package net.dawnfirerealms.legends.library.weapon;

import net.dawnfirerealms.legends.library.level.LevelRestricted;
import net.dawnfirerealms.legends.library.level.LevelRestrictions;
import net.dawnfirerealms.legends.library.misc.Describable;
import net.dawnfirerealms.legends.library.restriction.IDRestrictable;

import java.util.ArrayList;

/**
 * @author B2OJustin
 */
public class Weapon implements IDRestrictable, LevelRestricted, Describable<Weapon> {
    private String name = "";
    private ArrayList<String> description = new ArrayList<>();
    private LevelRestrictions levelRestrictions = new LevelRestrictions();

    public Weapon() {
    }

    public Weapon(String name, ArrayList<String> description) {
        this.name = name;
        this.description = description;
    }

    public Weapon setDescription(ArrayList<String> description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getDescription() {
        return description;
    }

    @Override
    public String getId() {
        return name;
    }

    @Override
    public LevelRestrictions getLevelRestrictions() {
        return levelRestrictions;
    }
}
