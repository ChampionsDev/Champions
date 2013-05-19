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

import com.github.championsdev.champions.library.event.weapon.WeaponClickEvent;
import com.github.championsdev.champions.library.event.weapon.WeaponEvent;
import com.github.championsdev.champions.library.event.weapon.WeaponHitEvent;
import com.github.championsdev.champions.library.misc.Informative;

import java.util.ArrayList;

/**
 * @author B2OJustin
 */
public class Weapon implements Informative<Weapon, WeaponInfo>, WeaponBehavior {
    private String name = "";
    private ArrayList<String> description = new ArrayList<>();

    private WeaponInfo weaponInfo = new WeaponInfo();

    public Weapon() {
    }

    public Weapon(String name, ArrayList<String> description) {
        this.name = name;
        this.description = description;
    }
    
    public Weapon(String name, ArrayList<String> description, WeaponBehavior behaviour) {
        
    }

    @Override
    public WeaponInfo getDefaultInfo() {
        return weaponInfo;
    }

    @Override
    public Weapon setDefaultInfo(WeaponInfo weaponInfo) {
        this.weaponInfo = weaponInfo;
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


    // Callback methods
    @Override
    public void onClick(WeaponClickEvent event) {
    }

    @Override
    public void onHit(WeaponHitEvent event) {
    }

    @Override
    public void onSelect(WeaponEvent event) {
    }
}