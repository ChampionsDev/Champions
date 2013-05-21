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

import com.github.championsdev.champions.library.event.weapon.WeaponClickEvent;
import com.github.championsdev.champions.library.event.weapon.WeaponEvent;
import com.github.championsdev.champions.library.event.weapon.WeaponHitEvent;

import java.util.ArrayList;

/**
 * @author B2OJustin
 */
public class WeaponBehaviorGroup implements WeaponBehavior, BehaviorGroup<WeaponBehaviorGroup, WeaponBehavior> {
    public ArrayList<WeaponBehavior> behaviorList = new ArrayList<>();

    @Override
    public WeaponBehaviorGroup attach(WeaponBehavior behavior) {
        behaviorList.add(behavior);
        return this;
    }

    @Override
    public WeaponBehaviorGroup attach(WeaponBehavior behavior, int priority) {
        if(priority > behaviorList.size()) priority = behaviorList.size();
        behaviorList.add(priority, behavior);
        return this;
    }

    @Override
    public WeaponBehaviorGroup detach(WeaponBehavior behavior) {
        behaviorList.remove(behavior);
        return this;
    }

    @Override
    public ArrayList<WeaponBehavior> getBehaviors() {
        return behaviorList;
    }

    @Override
    public void onClick(WeaponClickEvent event) {
        for(WeaponBehavior behavior : behaviorList) behavior.onClick(event);
    }

    @Override
    public void onHit(WeaponHitEvent event) {
        for(WeaponBehavior behavior : behaviorList) behavior.onHit(event);
    }

    @Override
    public void onSelect(WeaponEvent event) {
        for(WeaponBehavior behavior : behaviorList) behavior.onSelect(event);
    }
}
