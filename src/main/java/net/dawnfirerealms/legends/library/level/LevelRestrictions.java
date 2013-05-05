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

package net.dawnfirerealms.legends.library.level;

import net.dawnfirerealms.legends.library.restriction.LevelRestrictor;

/**
 * @author B2OJustin
 */
public class LevelRestrictions implements LevelRestrictor {
    private Level minLevel;
    private Level maxLevel;

    public LevelRestrictions() {
        this(new Level(0), new Level(0));
    }

    public LevelRestrictions(Level minLevel, Level maxLevel) {
        this.maxLevel = maxLevel;
        this.minLevel = minLevel;
    }

    @Override
    public Level getMinLevel() {
        return minLevel;
    }

    @Override
    public Level getMaxLevel() {
        return maxLevel;
    }

    @Override
    public LevelRestrictions setMinLevel(Level minLevel) {
        this.minLevel = minLevel;
        return this;
    }

    @Override
    public LevelRestrictions setMaxLevel(Level maxLevel) {
        this.maxLevel = maxLevel;
        return this;
    }

    public boolean isAllowed(Level level) {
        return true; // TODO method stub
    }
}
