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

package com.github.championsdev.champions.bukkit.core;

import com.github.championsdev.champions.bukkit.core.utils.DependencyHandler;
import com.github.championsdev.champions.library.effects.EffectHandler;
import com.github.championsdev.champions.library.server.ServerHandler;
import com.github.championsdev.champions.library.sounds.SoundHandler;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * @author B2OJustin
 */
public class ChampionsCore extends JavaPlugin {
    private static Logger logger = Logger.getLogger(ChampionsCore.class.getName());
    private static ChampionsCore instance;

    public static ChampionsCore getInstance() {
        return instance;
    }

	@Override
	public void onEnable() {
        ChampionsCore.instance = this;

        DependencyHandler.resolve();

        ServerHandler.setServerBridge(new BukkitChampionsServer(this));
        EffectHandler.addEffectPlayer(new BukkitEffectPlayer());
        SoundHandler.addSoundPlayer(new BukkitSoundPlayer());

        logger.info("Champions successfully enabled!");
	}

}
