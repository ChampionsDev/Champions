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

import java.util.ArrayList;
import net.dawnfirerealms.legends.library.armor.ArmorRestrictions;
import net.dawnfirerealms.legends.library.armor.ArmorUser;
import net.dawnfirerealms.legends.library.exp.Exp;
import net.dawnfirerealms.legends.library.exp.ExpUser;
import net.dawnfirerealms.legends.library.exp.Level;
import net.dawnfirerealms.legends.library.lclass.LClass;
import net.dawnfirerealms.legends.library.race.Race;
import net.dawnfirerealms.legends.library.skill.Skill;
import net.dawnfirerealms.legends.library.skill.SkillRestrictions;
import net.dawnfirerealms.legends.library.skill.SkillUser;
import net.dawnfirerealms.legends.library.weapon.Weapon;
import net.dawnfirerealms.legends.library.weapon.WeaponRestrictions;
import net.dawnfirerealms.legends.library.weapon.WeaponUser;
import org.bukkit.entity.Player;

/**
 * @author B2OJustin
 */
public class LPlayer implements WeaponUser, ArmorUser, SkillUser, ExpUser {
    private final Race race;
    private final Player player;
    private final LClass lclass;

    public LPlayer(Player player, Race race, LClass lclass) {
        this.player = player;
        this.race = race;
        this.lclass = lclass;
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
    public Exp getMaxExpPerLevel() {
        return null;
    }

    @Override
    public Level getMaxLevels() {
        return null;
    }
}
