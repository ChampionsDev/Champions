/*
This file is part of Champions.

    Champions is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Champions is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Champions.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.github.championsdev.champions.library.event.cplayer;

import com.github.championsdev.champions.library.cclass.CClass;
import com.github.championsdev.champions.library.cplayer.CPlayer;
import com.github.championsdev.champions.library.event.Cancellable;

/**
 * @author B2OJustin
 */
public class CPlayerLevelUpEvent extends CPlayerEvent implements Cancellable {
    public enum ClassType {
        PRIMARY, SECONDARY
    }
    private ClassType type;
    private CClass cClass;

    public CPlayerLevelUpEvent(CPlayer player, ClassType type, CClass cClass) {
        super(player);
        this.type = type;
        this.cClass = cClass;
    }

    public ClassType getType() {
        return type;
    }

    public CClass getCclass() {
        return cClass;
    }

    private boolean isCancelled = false;

    @Override
    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

}
