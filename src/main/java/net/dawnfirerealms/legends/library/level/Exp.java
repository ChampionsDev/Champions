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

import net.dawnfirerealms.legends.library.restriction.Restrictable;


/**
 * @author YoshiGenius
 */
public class Exp extends Number implements Restrictable {
    
    private double exp;
    
    public Exp(double exp) {
        this.exp = exp;
    }

    public Exp() {
        this.exp = 0;
    }

    public Exp set(double exp) {
        this.exp = exp;
        return this;
    }

    public Exp add(double exp) {
        this.exp += exp;
        return this;
    }

    @Override
    public int intValue() {
        return Math.round(Math.round(exp));
    }

    @Override
    public long longValue() {
        return Math.round(exp);
    }

    @Override
    public float floatValue() {
        return Math.round(exp);
    }

    @Override
    public double doubleValue() {
        return exp;
    }

}