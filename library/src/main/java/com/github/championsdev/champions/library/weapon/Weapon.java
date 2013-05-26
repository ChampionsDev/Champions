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

import com.github.championsdev.champions.library.BasicCategory;
import com.github.championsdev.champions.library.behavior.BehaviorGroup;
import com.github.championsdev.champions.library.behavior.Behavioral;
import com.github.championsdev.champions.library.misc.Informative;
import com.github.championsdev.champions.library.restriction.Restrictable;

import java.util.ArrayList;

/**
 * @author B2OJustin
 */
public class Weapon implements Informative<Weapon, WeaponAttributes>, Behavioral<Weapon>,Restrictable {
    private String name = "";
    private BasicCategory<WeaponAttributes> category = new BasicCategory<>();

    private ArrayList<String> description = new ArrayList<>();

    private WeaponAttributes weaponMeta = new WeaponAttributes();
    private BehaviorGroup behaviorGroup = new BehaviorGroup();

    public Weapon() {
    }

    public Weapon(String name, ArrayList<String> description) {
        this();
        this.name = name;
        this.description = description;
    }

    public BasicCategory<WeaponAttributes> getCategory() {
        return category;
    }

    public Weapon setCategory(BasicCategory<WeaponAttributes> category) {
        this.category = category;
        return this;
    }

    @Override
    public WeaponAttributes getAttributes() {
        return weaponMeta;
    }

    @Override
    public Weapon setAttributes(WeaponAttributes weaponAttributes) {
        this.weaponMeta = weaponAttributes;
        return this;
    }

    @Override
    public Weapon setDescription(ArrayList<String> description) {
        this.description = description;
        return this;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Weapon setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public ArrayList<String> getDescription() {
        return description;
    }

    @Override
    public BehaviorGroup getBehavior() {
        return behaviorGroup;
    }

    @Override
    public Weapon setBehavior(BehaviorGroup behavior) {
        behaviorGroup = behavior;
        return this;
    }
}
