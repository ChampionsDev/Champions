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

import java.util.ArrayList;

/**
 * @author B2OJustin
 */
public class CPlayerBehaviorGroup implements CPlayerBehavior, BehaviorGroup<CPlayerBehaviorGroup, CPlayerBehavior> {
    private ArrayList<CPlayerBehavior> behaviorList = new ArrayList<>();

    @Override
    public CPlayerBehaviorGroup attach(CPlayerBehavior behavior) {
        behaviorList.add(behavior);
        return this;
    }

    @Override
    public CPlayerBehaviorGroup attach(CPlayerBehavior behavior, int priority) {
        if(priority > behaviorList.size()) priority = behaviorList.size();
        behaviorList.add(priority, behavior);
        return this;
    }

    @Override
    public CPlayerBehaviorGroup detach(CPlayerBehavior behavior) {
        behaviorList.add(behavior);
        return this;
    }

    @Override
    public ArrayList<CPlayerBehavior> getBehaviors() {
        return behaviorList;
    }

    @Override
    public void onQuit(CPlayerQuitEvent event) {
        for(CPlayerBehavior behavior : behaviorList) behavior.onQuit(event);
    }

    @Override
    public void onDeath(CPlayerDeathEvent event) {
        for(CPlayerBehavior behavior : behaviorList) behavior.onDeath(event);
    }

    @Override
    public void onPlayerKill(CPlayerKillEvent event) {
        for(CPlayerBehavior behavior : behaviorList) behavior.onPlayerKill(event);
    }

    @Override
    public void onMobKill(CPlayerMobKillEvent event) {
        for(CPlayerBehavior behavior : behaviorList) behavior.onMobKill(event);
    }

    @Override
    public void onJoin(CPlayerJoinEvent event) {
        for(CPlayerBehavior behavior : behaviorList) behavior.onJoin(event);
    }

    @Override
    public void onWeaponChange(CPlayerWeaponChangeEvent event) {
        for(CPlayerBehavior behavior : behaviorList) behavior.onWeaponChange(event);
    }
}
