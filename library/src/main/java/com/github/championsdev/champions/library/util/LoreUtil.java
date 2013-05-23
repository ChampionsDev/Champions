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
package com.github.championsdev.champions.library.util;

import com.github.championsdev.champions.library.weapon.Weapon;

import java.util.ArrayList;

/**
 * @author B2OJustin
 */
public class LoreUtil {
    public static void addLoreData(Weapon weapon, ArrayList<String> loreData) {
        for (String lore : loreData) {
            String lower = lore.toLowerCase();
            if (lower.contains("damage")) {
                String dmg = lower.replace("damage", "").trim();
                if (dmg.startsWith("+")) {
                    // adds min & max damage
                    try {
                        int added = Integer.parseInt(dmg.replace("+", ""));
                        weapon.getDefaultInfo().addBonusMinWeaponDamage(added).addBonusMaxWeaponDamage(added);
                    } catch (NumberFormatException ex) {}
                } else if (dmg.startsWith("-")) {
                    // subtracts min & max damage
                    try {
                        int added = Integer.parseInt(dmg.replace("-", ""));
                        weapon.getDefaultInfo().addBonusMinWeaponDamage(added).addBonusMaxWeaponDamage(added);
                    } catch (NumberFormatException ex) {}
                } else {
                    // X-Y damage
                    if (dmg.contains("-")) {
                        String[] minAndMax = dmg.split("-");
                        if (minAndMax.length == 2) {
                            String min = minAndMax[0];
                            String max = minAndMax[1];
                        }
                    }
                }
            } else if (lower.contains("skill damage")) {
                String dmg = lower.replace("skill damage", "").trim();
                if (dmg.contains("+")) {
                    try {
                        int added = Integer.parseInt(dmg.replace("+", ""));
                        weapon.getDefaultInfo().addBonusMinSkillDamage(added).addBonusMaxSkillDamage(added);
                    } catch (NumberFormatException ex) {}
                } else {
                    try {
                        int added = Integer.parseInt(dmg.replace("-", ""));
                        weapon.getDefaultInfo().addBonusMinSkillDamage(added).addBonusMaxSkillDamage(added);
                    } catch (NumberFormatException ex) {}
                }
            }
        }
    }
}
