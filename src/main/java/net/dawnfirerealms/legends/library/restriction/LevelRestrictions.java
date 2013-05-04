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
package net.dawnfirerealms.legends.library.restriction;

import net.dawnfirerealms.legends.library.restriction.LevelRestrictor;

/**
 * @author B2OJustin
 */
public class LevelRestrictions {
    private int minLevel;
    private int maxLevel;

    public LevelRestrictions() {
        this(0, 0);
    }

    public LevelRestrictions(int minLevel, int maxLevel) {
        this.maxLevel = maxLevel;
        this.minLevel = minLevel;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public boolean isAllowed(int level) {
        if(minLevel == 0 && maxLevel == 0) return true;
        else return(level <= maxLevel && level >= minLevel);
    }
}
