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
package com.github.championsdev.champions.library;

import com.github.championsdev.champions.library.behavior.BehaviorGroup;
import com.github.championsdev.champions.library.misc.Attributes;
import com.github.championsdev.champions.library.misc.Identifiable;
import com.github.championsdev.champions.library.misc.Informative;
import com.github.championsdev.champions.library.restriction.Restrictable;

import java.util.ArrayList;

/**
 * @author B2OJustin
 */
@SuppressWarnings("unchecked")
public class BasicCategory<AttributeType extends Attributes> implements
        Informative<BasicCategory, AttributeType>, Identifiable<BasicCategory>, Restrictable {
    private AttributeType attributes;

    private ArrayList<String> description = new ArrayList<>();
    private BehaviorGroup behaviorGroup = new BehaviorGroup();
    private String name = "";
    private String id = "";

    @Override
    public String getId() {
        return id;
    }

    @Override
    public BasicCategory setId(String id) {
        this.id = id;
        return (BasicCategory)this;
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
    public BasicCategory setName(String name) {
        this.name = name;
        return (BasicCategory)this;
    }

    @Override
    public BasicCategory setDescription(ArrayList<String> description) {
        this.description = description;
        return (BasicCategory)this;
    }

    @Override
    public AttributeType getAttributes() {
        return attributes;
    }

    @Override
    public BasicCategory setAttributes(AttributeType attributes) {
        this.attributes = attributes;
        return (BasicCategory)this;
    }

    public BehaviorGroup getBehavior() {
        return behaviorGroup;
    }

    public BasicCategory setBehavior(BehaviorGroup behavior) {
        this.behaviorGroup = behavior;
        return (BasicCategory) this;
    }
}
