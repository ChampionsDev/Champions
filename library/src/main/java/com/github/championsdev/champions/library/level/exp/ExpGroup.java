/*******************************************************************************
 * This file is part of Champions.
 *
 *     Champions is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Champions is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Champions.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package com.github.championsdev.champions.library.level.exp;

import com.github.championsdev.champions.library.level.exp.sources.ExpSource;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpGroup expGroup = (ExpGroup) o;

        if (expMap != null ? !expMap.equals(expGroup.expMap) : expGroup.expMap != null) return false;
        if (name != null ? !name.equals(expGroup.name) : expGroup.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = expMap != null ? expMap.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
