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

package com.github.championsdev.champions.library.armor;


import com.github.championsdev.champions.library.behavior.BehaviorGroup;
import com.github.championsdev.champions.library.behavior.Behavioral;
import com.github.championsdev.champions.library.misc.Informative;
import com.github.championsdev.champions.library.restriction.Restrictable;

import java.util.ArrayList;

/**
 * Represents a player Armor object.
 *
 * @author B2OJustin
 */
public class Armor implements Informative<Armor, ArmorAttributes>, Behavioral<Armor>,Restrictable {
    private String name = "";
    private ArrayList<String> description = new ArrayList<>();
    private ArmorAttributes armorMeta = new ArmorAttributes();
    private BehaviorGroup behaviorGroup = new BehaviorGroup();

    public Armor() {
    }

    public Armor setName(String name) {
        this.name = name;
        return this;
    }

    public Armor setDescription(ArrayList<String> description) {
        this.description = description;
        return this;
    }

    @Override
    public ArmorAttributes getAttributes() {
        return armorMeta;
    }

    @Override
    public Armor setAttributes(ArmorAttributes attributes) {
        armorMeta = attributes;
        return this;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getDescription() {
        return description;
    }

    @Override
    public BehaviorGroup getBehavior() {
        return behaviorGroup;
    }

    @Override
    public Armor setBehavior(BehaviorGroup behavior) {
        this.behaviorGroup = behavior;
        return this;
    }
}
