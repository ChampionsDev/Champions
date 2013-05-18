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
package com.github.championsdev.champions.library.cplayer;

import com.github.championsdev.champions.library.BasicHandler;
import com.github.championsdev.champions.library.Configuration;
import com.github.championsdev.champions.library.cclass.CClassHandler;
import com.github.championsdev.champions.library.database.DataManager;
import com.github.championsdev.champions.library.race.RaceHandler;

import java.util.logging.Logger;

/**
 * @author B2OJustin
 */
public class CPlayerHandler extends BasicHandler<CPlayer> {
    private static Logger logger = Logger.getLogger(CPlayerHandler.class.getName());
    private static CPlayerHandler instance = new CPlayerHandler();

    public static CPlayerHandler getInstance() {
        return instance;
    }

    public CPlayer load(String id) {
        CPlayer lPlayer = super.get(id);

        // Attempt load from cache
        if(lPlayer == null) {
            lPlayer = CPlayerCache.getPlayer(id);
            if(lPlayer != null) {
                register(id, lPlayer);
                logger.info("Loaded player '" + id + "' from cache");
            }
        }

        // Attempt load from database
        if(lPlayer == null) {
            lPlayer = DataManager.getDataSource().loadLPlayer(id);
            if(lPlayer != null) {
                register(id, lPlayer);
                logger.info("Loaded player data for '" + id + "' from database");
            }
        }

        // Create new player data
        if(lPlayer == null) {
            Configuration config = Configuration.getInstance();
            lPlayer = new CPlayer(
                    RaceHandler.getInstance().load(config.getDefaultRace()),
                    CClassHandler.getInstance().load(config.getDefaultPrimaryClass()),
                    CClassHandler.getInstance().load(config.getDefaultSecondaryClass()
            ));
            lPlayer.setName(id);
            super.register(id, lPlayer);
            logger.info("Created new player data for '" + id + "'");
            DataManager.getDataSource().saveLPlayer(lPlayer);
        }

        return lPlayer;
    }

    public CPlayerHandler remove(String id, boolean cache) {
        if(cache) {
            CPlayer lPlayer = get(id);
            CPlayerCache.cachePlayer(id, lPlayer);
        }
        super.remove(id);
        return this;
    }
}
