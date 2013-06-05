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
package com.github.championsdev.champions.library.level.exp.sources;

/**
 * @author B2OJustin
 */
public class MobKillExpSource extends ExpSource {
    private String mobName;

    public MobKillExpSource(String mobName) {
        super(ExpSourceType.MOB_KILL);
        this.mobName = mobName;
    }

    public String getMobName() {
        return mobName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MobKillExpSource that = (MobKillExpSource) o;

        if (mobName != null ? !mobName.equals(that.mobName) : that.mobName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (mobName != null ? mobName.hashCode() : 0);
        return result;
    }
}
