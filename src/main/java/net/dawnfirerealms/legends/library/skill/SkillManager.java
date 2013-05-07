/*
    This file is part of Legends

    Legends is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Legends is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Legends  If not, see <http://www.gnu.org/licenses/>.
*/

package net.dawnfirerealms.legends.library.skill;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author YoshiGenius
 */
public class SkillManager {
    private static List<Skill> skills = Lists.newArrayList();
    
    private SkillManager(){};
    
    public static List<Skill> getSkills() {
        return SkillManager.skills;
    }
    
    public static Skill getSkill(String name) {
        if (!skillExists(name)) {
            return null;
        }
        for (Skill s : skills) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }
    
    public static boolean skillExists(String name) {
        if (name == null) {
            return false;
        }
        for (Skill s : skills) {
            if (s.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean skillExists(Skill skill) {
        return skillExists(skill.getName());
    }
    
    public static boolean addSkill(Skill skill) {
        if (skill == null || skillExists(skill)) {
            return false;
        } else {
            return SkillManager.skills.add(skill);
        }
    }
    
    public static boolean deleteSkill(Skill skill) {
        if (skill == null || !skillExists(skill)) {
            return false;
        } else {
            return SkillManager.skills.remove(skill);
        }
    }
    
    public static boolean deleteSkill(String skill) {
        return deleteSkill(getSkill(skill));
    }

}