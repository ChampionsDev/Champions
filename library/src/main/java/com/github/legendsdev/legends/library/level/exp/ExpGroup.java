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
package com.github.legendsdev.legends.library.level.exp;

import com.github.legendsdev.legends.library.level.exp.sources.ExpSource;

import java.util.HashMap;

/**
 * @author B2OJustin
 */
public class ExpGroup {
    private HashMap<ExpSource, Exp> expMap = new HashMap<>();
    private String name;

    public ExpGroup(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ExpGroup add(ExpSource source, Exp exp) {
        expMap.put(source, exp);
        return this;
    }

    public ExpGroup add(ExpSource source, double exp) {
        add(source, new Exp(exp));
        return this;
    }

    public ExpGroup remove(ExpSource source) {
        expMap.remove(source);
        return this;
    }

    public Exp getExp(ExpSource source) {
        Exp exp = expMap.get(source);
        if(exp == null) exp = new Exp(0);
        return exp;
    }
}
