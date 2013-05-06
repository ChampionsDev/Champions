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

package net.dawnfirerealms.legends.library.skill;

import net.dawnfirerealms.legends.library.level.LevelRestrictions;
import net.dawnfirerealms.legends.library.restriction.IDRestrictable;
import net.dawnfirerealms.legends.library.restriction.LevelRestricted;

/**
 * @author B2OJustin
 */
public class Skill implements IDRestrictable, LevelRestricted {
    public String name;
    private LevelRestrictions levelRestrictions;
    private int mana;
    private String description;

    public Skill(String name, String description, int mana) {
        this.name = name;
        this.mana = mana;
        this.description = description;
        levelRestrictions = new LevelRestrictions();
    }

    public int getManaCost() {
        return this.mana;
    }
    
    public Skill setManaCost(int mana) {
        this.mana = mana;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Skill getDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String getId() {
        return this.name;
    }

    @Override
    public LevelRestrictions getLevelRestrictions() {
        return this.levelRestrictions;
    }
}
