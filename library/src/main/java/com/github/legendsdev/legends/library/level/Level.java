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

package com.github.legendsdev.legends.library.level;

/**
 * @author YoshiGenius
 */
public class Level extends Exp implements Comparable<Level> {
    private int level;

    public Level(int level) {
        this.level = level;
    }
    
    public int getLevel() {
        return this.level;
    }

    public Level setLevel(int level) {
        this.exp = 0;
        this.level = level;
        return this;
    }

    public Level setLevel(Level level) {
        this.level = level.level;
        this.exp = level.exp;
        return this;
    }

    public Level addLevel(int level) {
        this.level += level;
        return this;
    }

    public Level addLevel(Level level) {
        this.level += level.level;
        this.exp += level.exp;
        return this;
    }

    public Level removeLevel(int level) {
        this.exp = 0;
        this.level -= level;
        return this;
    }

    public Level removeLevel(Level level) {
        this.level -= level.level;
        this.exp -= level.exp;
        return this;
    }
    
    public static Level max(Level lvl1, Level lvl2) {
        return new Level(Math.max(lvl1.level, lvl2.level));
    }
    
    public static Level min(Level lvl1, Level lvl2) {
        return new Level(Math.min(lvl1.level, lvl2.level));
    }
    
    public static boolean areEqual(Level lvl1, Level lvl2) {
        return (lvl1.level == lvl2.level);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Level level1 = (Level) o;

        return level == level1.level;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + level;
        return result;
    }

    @Override
    public int compareTo(Level o) {
        if(this.level < o.level) return -1;
        if(this.level > o.level) return 1;
        else {
            if(this.exp < o.exp) return -1;
            if(this.exp > o.exp) return 1;
        }
        return 0;
    }

    public boolean isGreaterThan(Level level) {
        return compareTo(level) == 1;
    }

    public boolean isLessThan(Level level) {
        return compareTo(level) == -1;
    }
}