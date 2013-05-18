/*
This file is part of Champions.

    Champions is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Champions is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Champions.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.github.championsdev.champions.library.level;

/**
 * @author B2OJustin
 */
public class LevelRestrictions {
    private Level minLevel;
    private Level maxLevel;

    public LevelRestrictions() {
        this(new Level(0), new Level(0));
    }

    public LevelRestrictions(Level minLevel, Level maxLevel) {
        this.maxLevel = maxLevel;
        this.minLevel = minLevel;
    }

    public Level getMinLevel() {
        return minLevel;
    }

    public Level getMaxLevel() {
        return maxLevel;
    }

    public LevelRestrictions setMinLevel(Level minLevel) {
        this.minLevel = minLevel;
        return this;
    }

    public LevelRestrictions setMinLevel(int minLevel) {
        this.minLevel = new Level(minLevel);
        return this;
    }

    public LevelRestrictions setMaxLevel(Level maxLevel) {
        this.maxLevel = maxLevel;
        return this;
    }

    public LevelRestrictions setMaxLevel(int maxLevel) {
        this.maxLevel = new Level(maxLevel);
        return this;
    }

    public boolean isAllowed(Level level) {
        return (level.getLevel() >= getMinLevel().getLevel() && level.getLevel() <= getMaxLevel().getLevel());
    }
}
