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
package net.dawnfirerealms.legends.library.skill;

import net.dawnfirerealms.legends.library.BasicUser;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author B2OJustin
 */
public interface SkillUser<T extends SkillUser> extends BasicUser {
    public ArrayList<Skill> getSkills();
    public T addSkill(Skill skill);
    public T removeSkill(Skill skill);
    public HashMap<Skill, SkillInfo> getSkillInfoMap();
    public SkillInfo getSkillInfo(Skill skill);
    public T setSkillInfo(Skill skill, SkillInfo info);
}
