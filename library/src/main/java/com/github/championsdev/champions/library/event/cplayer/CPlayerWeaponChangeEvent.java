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
package com.github.championsdev.champions.library.event.cplayer;

import com.github.championsdev.champions.library.cplayer.CPlayer;
import com.github.championsdev.champions.library.event.Cancellable;
import com.github.championsdev.champions.library.weapon.Weapon;

/**
 * @author B2OJustin
 */
public class CPlayerWeaponChangeEvent extends CPlayerEvent implements Cancellable {
    private Weapon weapon;
    private boolean isCancelled = false;

    public CPlayerWeaponChangeEvent(CPlayer player, Weapon weapon) {
        super(player);
        this.weapon = weapon;
    }

    public Weapon getNewWeapon() {
        return weapon;
    }

    @Override
    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }
}
