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
package net.dawnfirerealms.legends.library;


import net.dawnfirerealms.legends.library.armor.*;
import net.dawnfirerealms.legends.library.lclass.LClass;
import net.dawnfirerealms.legends.library.lclass.LClassRestricted;
import net.dawnfirerealms.legends.library.lclass.LClassRestrictions;
import net.dawnfirerealms.legends.library.lclass.LClassUser;
import net.dawnfirerealms.legends.library.level.Level;
import net.dawnfirerealms.legends.library.level.LevelRestricted;
import net.dawnfirerealms.legends.library.level.LevelRestrictions;
import net.dawnfirerealms.legends.library.level.LevelUser;
import net.dawnfirerealms.legends.library.race.Race;
import net.dawnfirerealms.legends.library.race.RaceRestricted;
import net.dawnfirerealms.legends.library.race.RaceUser;
import net.dawnfirerealms.legends.library.skill.*;
import net.dawnfirerealms.legends.library.weapon.*;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author B2OJustin
 */
public class LPlayer implements
        WeaponUser, ArmorUser, SkillUser, LevelUser, LClassUser, RaceUser,
        WeaponRestricted, ArmorRestricted, SkillRestricted, LevelRestricted, LClassRestricted, RaceRestricted {
    private final Race race;
    private final Player player;
    private final LClass lclass;
    private LevelRestrictions levelRestrictions;
    private HashMap<String, SkillInfo> skillInfo;

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
    public LevelRestrictions getLevelRestrictions() {
        return levelRestrictions;
    }

    @Override
    public HashMap<String, SkillInfo> getSkillInfo() {
        return this.skillInfo;
    }

    @Override
    public SkillInfo getSkillInfo(Skill skill) {
        if (!skillInfo.containsKey(skill.getName())) {
           skillInfo.put(skill.getName(), new SkillInfo());
        }
        return skillInfo.get(skill.getName());
    }

    @Override
    public SkillInfo setSkillInfo(Skill skill, SkillInfo info) {
        return skillInfo.put(skill.getName(), info);
    }

    @Override
    public Level getLevel() {
        return null; //TODO getLevel method stub
    }

    @Override
    public LClassRestrictions getLClassRestrictions() {
        return null; //TODO getLClassRestrictions method stub
    }

    @Override
    public HashMap<String, WeaponInfo> getWeaponInfo() {
        return null; //TODO getWeaponInfo method stub
    }

    @Override
    public WeaponInfo getWeaponInfo(Skill skill) {
        return null; //TODO getWeaponInfo method stub
    }

    @Override
    public SkillInfo setWeaponInfo(Weapon weapon, WeaponInfo info) {
        return null; //TODO setWeaponInfo method stub
    }

    @Override
    public HashMap<String, SkillInfo> getArmorInfo() {
        return null; //TODO getArmorInfo method stub
    }

    @Override
    public ArmorInfo getArmorInfo(Armor armor) {
        return null; //TODO getArmorInfo method stub
    }

    @Override
    public ArmorInfo setArmorInfo(Armor armor, ArmorInfo info) {
        return null; //TODO setArmorInfo method stub
    }
}
