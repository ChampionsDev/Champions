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
package com.github.championsdev.champions.library.behavior;

import com.github.championsdev.champions.library.event.cplayer.*;

/**
 * @author B2OJustin
 */
public class BasicCPlayerBehavior extends AbstractBehavior {
    @Override
    public void onQuit(CPlayerQuitEvent event) {
    }

    @Override
    public void onDeath(CPlayerDeathEvent event) {
    }

    @Override
    public void onPlayerKill(CPlayerKillEvent event) {
    }

    @Override
    public void onMobKill(CPlayerMobKillEvent event) {
    }

    @Override
    public void onJoin(CPlayerJoinEvent event) {
    }

    @Override
    public void onWeaponChange(CPlayerWeaponChangeEvent event) {
    }

    @Override
    public void onLevelUp(CPlayerLevelUpEvent event) {
    }

    @Override
    public void onExpGain(CPlayerExpGainEvent event) {
    }
}
