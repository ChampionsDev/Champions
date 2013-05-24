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
package com.github.championsdev.champions.library.weapon;

import com.github.championsdev.champions.library.behavior.BehaviorGroup;
import com.github.championsdev.champions.library.behavior.Behavioral;
import com.github.championsdev.champions.library.misc.Identifiable;
import com.github.championsdev.champions.library.misc.Informative;

import java.util.ArrayList;

/**
 * @author B2OJustin
 */
public class WeaponType implements Informative<WeaponType, WeaponAttributes>, Identifiable<WeaponType>, Behavioral<WeaponType> {
    private WeaponAttributes weaponMeta = new WeaponAttributes();
    private ArrayList<String> description = new ArrayList<>();
    private BehaviorGroup weaponBehaviorGroup = new BehaviorGroup();
    private String name = "";
    private String id = "";

    @Override
    public String getId() {
        return id;
    }

    @Override
    public WeaponType setId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public ArrayList<String> getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public WeaponType setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public WeaponType setDescription(ArrayList<String> description) {
        this.description = description;
        return this;
    }

    @Override
    public WeaponAttributes getDefaultInfo() {
        return weaponMeta;
    }

    @Override
    public WeaponType setDefaultInfo(WeaponAttributes info) {
        this.weaponMeta = info;
        return this;
    }

    @Override
    public BehaviorGroup getBehavior() {
        return weaponBehaviorGroup;
    }

    @Override
    public WeaponType setBehavior(BehaviorGroup weaponBehavior) {
        this.weaponBehaviorGroup = weaponBehavior;
        return this;
    }
}
