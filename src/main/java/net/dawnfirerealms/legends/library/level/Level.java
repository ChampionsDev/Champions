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

/**
 * @author YoshiGenius
 */
public class Level extends Number {
    
    private int level;

    public Level(int level) {
        this.level = level;
    }
    
    @Override
    public int intValue() {
        return level;
    }

    @Override
    public long longValue() {
        return level;
    }

    @Override
    public float floatValue() {
        return level;
    }

    @Override
    public double doubleValue() {
        return level;
    }
}