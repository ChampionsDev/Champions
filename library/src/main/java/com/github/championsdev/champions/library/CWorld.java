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

package com.github.championsdev.champions.library;

import com.github.championsdev.champions.library.cplayer.CPlayer;

/**
 * @author YoshiGenius
 */
public abstract class CWorld {

    public abstract CBlock getBlockAt(CLocation location);
    public CBlock getBlockAt(int x, int y, int z) {
        return getBlockAt(new CLocation(this, x, y, z));
    }
    public abstract String getName();
    public abstract CPlayer[] getPlayers();
    public CPlayer getPlayerNearest(CLocation location) {
        if (!location.getWorld().getName().equals(getName())) {
            return null;
        }
        for (CPlayer p : getPlayers()) {
            if (p.getPosition().equals(location)) {
                return p;
            }
        }
        CPlayer closest = getPlayers()[0];
        double distance = closest.getPosition().distance(location);
        for (CPlayer p : getPlayers()) {
            double pDist = p.getPosition().distance(location);
            if (pDist <= distance) {
                distance = pDist;
                closest = p;
            }
        }
        return closest;
    }

}
