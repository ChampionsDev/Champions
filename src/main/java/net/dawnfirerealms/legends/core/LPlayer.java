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
package net.dawnfirerealms.legends.core;


import net.dawnfirerealms.legends.library.armor.ArmorRestrictions;
import net.dawnfirerealms.legends.library.armor.ArmorUser;
import net.dawnfirerealms.legends.library.lclass.LClass;
import net.dawnfirerealms.legends.library.level.ExpUser;
import net.dawnfirerealms.legends.library.level.Level;
import net.dawnfirerealms.legends.library.level.LevelRestrictions;
import net.dawnfirerealms.legends.library.race.Race;
import net.dawnfirerealms.legends.library.restriction.LevelRestricted;
import net.dawnfirerealms.legends.library.skill.Skill;
import net.dawnfirerealms.legends.library.skill.SkillInfo;
import net.dawnfirerealms.legends.library.skill.SkillManager;
import net.dawnfirerealms.legends.library.skill.SkillRestrictions;
import net.dawnfirerealms.legends.library.skill.SkillUser;
import net.dawnfirerealms.legends.library.weapon.Weapon;
import net.dawnfirerealms.legends.library.weapon.WeaponRestrictions;
import net.dawnfirerealms.legends.library.weapon.WeaponUser;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author B2OJustin
 */
public class LPlayer implements WeaponUser, ArmorUser, SkillUser, ExpUser, LevelRestricted {
    private final Race race;
    private final Player player;
    private final LClass lclass;
    private LevelRestrictions levelRestrictions;
    private HashMap<Skill, SkillInfo> skillInfo;

    public LPlayer(Player player, Race race, LClass lclass) {
        this.player = player;
        this.race = race;
        this.lclass = lclass;
        levelRestrictions = new LevelRestrictions();
        skillInfo = new HashMap<>();
    }

    public Player getPlayer() {
        return this.player;
    }

    public Race getRace() {
        return this.race;
    }
    
    public LClass getLClass() {
        return this.lclass;
    }

    public Weapon getCurrentWeapon() {
        return null;
    }

    @Override
    public ArrayList<Skill> getSkills() {
        return null;
    }

    @Override
    public void addSkill(Skill skill) {
    }

    @Override
    public void removeSkill(Skill skill) {
    }

    @Override
    public SkillRestrictions getSkillRestrictions() {
        return null;
    }

    @Override
    public ArmorRestrictions getArmorRestrictions() {
        return null;
    }

    @Override
    public WeaponRestrictions getWeaponRestrictions() {
        return null;
    }

    @Override
    public Level getMaxLevels() {
        return null;
    }

    @Override
    public LevelRestrictions getLevelRestrictions() {
        return levelRestrictions;
    }

    @Override
    public HashMap<Skill, SkillInfo> getSkillInfoMap() {
        return this.skillInfo;
    }

    @Override
    public SkillInfo getSkillInfo(String name) {
        return getSkillInfo(SkillManager.getSkill(name));
    }

    @Override
    public SkillInfo getSkillInfo(Skill skill) {
        if (!getSkillInfoMap().containsKey(skill)) {
           getSkillInfoMap().put(skill, new SkillInfo());
        }
        return getSkillInfoMap().get(skill);
    }

    @Override
    public SkillInfo setSkillInfo(Skill skill, SkillInfo info) {
        return getSkillInfoMap().put(skill, info);
    }

    @Override
    public SkillInfo setSkillInfo(String name, SkillInfo info) {
        return setSkillInfo(SkillManager.getSkill(name), info);
    }
}
