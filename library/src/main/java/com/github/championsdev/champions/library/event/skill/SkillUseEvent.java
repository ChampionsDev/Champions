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
package com.github.championsdev.champions.library.event.skill;

import com.github.championsdev.champions.library.CEntity;
import com.github.championsdev.champions.library.event.Cancellable;
import com.github.championsdev.champions.library.skill.Skill;

/**
 * @author B2OJustin
 */
public class SkillUseEvent extends SkillEvent implements Cancellable {
    protected CEntity source;
    protected CEntity target;

    public SkillUseEvent(Skill skill, CEntity source, CEntity target) {
        super(skill);
        this.source = source;
        this.target = target;
    }

    public CEntity getSource() {
        return source;
    }

    public CEntity getTarget() {
        return target;
    }

    private boolean isCancelled = false;

    @Override
    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }
}
