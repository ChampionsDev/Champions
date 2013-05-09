/*
This file is part of Legends.

    Legends is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Legends is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Legends.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.github.legendsdev.legends.library.weapon;

import com.github.legendsdev.legends.library.event.EventManager;
import com.github.legendsdev.legends.library.event.weapon.WeaponClickEvent;
import com.github.legendsdev.legends.library.event.weapon.WeaponHitEvent;
import com.github.legendsdev.legends.library.level.LevelRestricted;
import com.github.legendsdev.legends.library.level.LevelRestrictions;
import com.github.legendsdev.legends.library.misc.Describable;

import java.util.ArrayList;

import static com.github.legendsdev.legends.library.event.weapon.WeaponClickEvent.ClickType;

/**
 * @author B2OJustin
 */
public class Weapon implements LevelRestricted, Describable<Weapon>, WeaponBehaviour {
    private String name = "";
    private ArrayList<String> description = new ArrayList<>();
    private LevelRestrictions levelRestrictions = new LevelRestrictions();

    public Weapon() {
    }

    public Weapon(String name, ArrayList<String> description) {
        this.name = name;
        this.description = description;
    }
    
    public Weapon(String name, ArrayList<String> description, WeaponBehaviour behaviour) {
        
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
    public ArrayList<String> getDescription() {
        return description;
    }

    @Override
    public LevelRestrictions getLevelRestrictions() {
        return levelRestrictions;
    }


    // Callback methods
    @Override
    public void onLeftClick() {
        EventManager.callEvent(new WeaponClickEvent(this, ClickType.LEFT_CLICK));
    }

    @Override
    public void onRightClick() {
        EventManager.callEvent(new WeaponClickEvent(this, ClickType.RIGHT_CLICK));
    }

    @Override
    public void onHit() {
        EventManager.callEvent(new WeaponHitEvent(this));
    }
}
