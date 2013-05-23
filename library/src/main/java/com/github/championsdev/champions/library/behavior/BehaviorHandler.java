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

import com.github.championsdev.champions.library.BasicHandler;

/**
 * @author B2OJustin
 */
public class BehaviorHandler extends BasicHandler<Behavior>{
    private static BehaviorHandler instance = new BehaviorHandler();
    private Behavior defaultCPlayerBehavior = new BasicCPlayerBehavior();
    private Behavior defaultSkillBehavior = new BasicSkillBehavior();
    private Behavior defaultWeaponBehavior = new BasicWeaponBehavior();

    public static BehaviorHandler getInstance() {
        return instance;
    }

    private BehaviorHandler() {

    }

    public Behavior getDefaultCPlayerBehavior() {
        return defaultCPlayerBehavior;
    }

    public void setDefaultCPlayerBehavior(Behavior defaultCPlayerBehavior) {
        this.defaultCPlayerBehavior = defaultCPlayerBehavior;
    }

    public Behavior getDefaultSkillBehavior() {
        return defaultSkillBehavior;
    }

    public void setDefaultSkillBehavior(Behavior defaultSkillBehavior) {
        this.defaultSkillBehavior = defaultSkillBehavior;
    }

    public Behavior getDefaultWeaponBehavior() {
        return defaultWeaponBehavior;
    }

    public void setDefaultWeaponBehavior(Behavior defaultWeaponBehavior) {
        this.defaultWeaponBehavior = defaultWeaponBehavior;
    }
}
