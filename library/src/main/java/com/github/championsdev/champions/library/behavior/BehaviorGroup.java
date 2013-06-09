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

package com.github.championsdev.champions.library.behavior;

import com.github.championsdev.champions.library.event.cplayer.*;
import com.github.championsdev.champions.library.event.skill.SkillUseEvent;
import com.github.championsdev.champions.library.event.weapon.WeaponClickEvent;
import com.github.championsdev.champions.library.event.weapon.WeaponHitEvent;

import java.util.ArrayList;

/**
 * Represents a group of behaviors.
 * Behavior methods called on this object will
 * be called on each behavior attached to the group
 * @author B2OJustin
 */
public class BehaviorGroup extends Behavior {
    public ArrayList<Behavior> behaviors = new ArrayList<>();

    /**
     * Attaches a new behavior to this object.
     * @param behavior Behavior to attach
     * @return
     */
    public BehaviorGroup attach(Behavior behavior) {
        behaviors.add(behavior);
        return this;
    }

    /**
     * Attaches the {@code behavior} to this object at the given priority
     * If the priority is higher than the number of behaviors attached to this object
     * then the priority is set at the highest possible value.
     * @param behavior Behavior to attach
     * @param priority Priority for the newly attached behavior.
     * @return
     */
    public BehaviorGroup attach(Behavior behavior, int priority) {
        if(priority > behaviors.size()) behaviors.add(behavior);
        else behaviors.add(priority, behavior);
        return this;
    }

    /**
     * Detaches the {@code behavior} from this object.
     * @param behavior Behavior to detach
     * @return
     */
    public BehaviorGroup detach(Behavior behavior) {
        behaviors.remove(behavior);
        return this;
    }

    /**
     * Convenience method for swapping one behavior with another.
     * {@code oldBehavior} is detached and {@code newBehavior} will be attached.
     * This method maintains behavior priorities.
     * @param oldBehavior
     * @param newBehavior
     * @return
     */
    public BehaviorGroup swap(Behavior oldBehavior, Behavior newBehavior) {
        int index = behaviors.indexOf(oldBehavior);
        if(index == -1) behaviors.add(newBehavior);
        else behaviors.add(index, newBehavior);
        return this;
    }

    @Override
    public void onQuit(CPlayerQuitEvent event) {
        for(Behavior behavior : behaviors) behavior.onQuit(event);
    }

    @Override
    public void onDeath(CPlayerDeathEvent event) {
        for(Behavior behavior : behaviors) behavior.onDeath(event);
    }

    @Override
    public void onPlayerKill(CPlayerKillEvent event) {
        for(Behavior behavior : behaviors) behavior.onPlayerKill(event);
    }

    @Override
    public void onMobKill(CPlayerMobKillEvent event) {
        for(Behavior behavior : behaviors) behavior.onMobKill(event);
    }

    @Override
    public void onJoin(CPlayerJoinEvent event) {
        for(Behavior behavior : behaviors) behavior.onJoin(event);
    }

    @Override
    public void onWeaponChange(CPlayerWeaponChangeEvent event) {
        for(Behavior behavior : behaviors) behavior.onWeaponChange(event);
    }

    @Override
    public void onLevelUp(CPlayerLevelUpEvent event) {
        for(Behavior behavior : behaviors) behavior.onLevelUp(event);
    }

    @Override
    public void onExpGain(CPlayerExpGainEvent event) {
        for(Behavior behavior : behaviors) behavior.onExpGain(event);
    }

    @Override
    public void onSkillUse(SkillUseEvent event) {
        for(Behavior behavior : behaviors) behavior.onSkillUse(event);
    }

    @Override
    public void onClick(WeaponClickEvent event) {
        for(Behavior behavior : behaviors) behavior.onClick(event);
    }

    @Override
    public void onHit(WeaponHitEvent event) {
        for(Behavior behavior : behaviors) behavior.onHit(event);
    }

}
