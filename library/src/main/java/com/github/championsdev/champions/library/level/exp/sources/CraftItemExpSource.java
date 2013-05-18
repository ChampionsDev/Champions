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
package com.github.championsdev.champions.library.level.exp.sources;

/**
 * @author B2OJustin
 */
public class CraftItemExpSource extends ExpSource {
    public String blockName;

    public CraftItemExpSource(String blockName) {
        super(ExpSourceType.CRAFT);
        this.blockName = this.blockName;
    }

    public String getBlockName() {
        return blockName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CraftItemExpSource that = (CraftItemExpSource) o;

        if (blockName != null ? !blockName.equals(that.blockName) : that.blockName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (blockName != null ? blockName.hashCode() : 0);
        return result;
    }
}
