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
package com.github.championsdev.champions.library.behavior;

import com.github.championsdev.champions.library.cplayer.CPlayer;
import com.github.championsdev.champions.library.event.skill.SkillUseEvent;

/**
 * @author B2OJustin
 */
public class SkillBehavior implements Behavior {
    public void onUse(SkillUseEvent event) {
        if(event.getSource() instanceof CPlayer) {
            CPlayer player = (CPlayer) event.getSource();
            player.removeMana(player.getSkillInfo(event.getSkill()).getManaCost());
            player.removeStamina(player.getSkillInfo(event.getSkill()).getStaminaCost());
            player.removeHealth(player.getSkillInfo(event.getSkill()).getHealthCost());
        }
    }
}
