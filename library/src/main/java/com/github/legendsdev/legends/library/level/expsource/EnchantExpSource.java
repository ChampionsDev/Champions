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
package com.github.legendsdev.legends.library.level.expsource;

/**
 * @author B2OJustin
 */
public class EnchantExpSource extends ExpSource {

    public String enchantId;

    public EnchantExpSource(String enchantId) {
        super(ExpSourceType.ENCHANT);
        this.enchantId = enchantId;
    }

    public String getEnchantId() {
        return enchantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        EnchantExpSource that = (EnchantExpSource) o;

        if (enchantId != null ? !enchantId.equals(that.enchantId) : that.enchantId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (enchantId != null ? enchantId.hashCode() : 0);
        return result;
    }
}
