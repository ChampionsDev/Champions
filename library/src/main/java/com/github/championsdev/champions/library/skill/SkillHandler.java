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

package com.github.championsdev.champions.library.skill;

import com.github.championsdev.champions.library.BasicHandler;
import com.github.championsdev.champions.library.database.DataManager;

import java.util.logging.Logger;

/**
 * @author YoshiGenius
 */

public class SkillHandler extends BasicHandler<Skill> {
    private static final Logger logger = Logger.getLogger(SkillHandler.class.getName());
    private static SkillHandler instance = new SkillHandler();

    public static SkillHandler getInstance() {
        return instance;
    }

    private SkillHandler(){
    }

    public Skill load(String id) {
        Skill skill = super.get(id);
        if(skill == null) {
            skill = DataManager.getDataSource().loadSkill(id);
            if(skill != null) {
                super.register(id, skill);
                logger.info("Loaded skill '" + id + "' from database.");
            }
            else logger.warning("Could not load skill '" + id + "'");
        }
        return skill;
    }
}