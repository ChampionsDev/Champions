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

package com.github.legendsdev.legends.bukkit.core;

import com.github.legendsdev.legends.bukkit.core.listeners.LegendsListener;
import com.github.legendsdev.legends.bukkit.core.utils.ConfigHandler;
import com.github.legendsdev.legends.bukkit.core.utils.DependencyHandler;
import com.github.legendsdev.legends.library.event.EventManager;
import com.github.legendsdev.legends.library.listener.BaseListener;
import org.bukkit.plugin.java.JavaPlugin;
import se.ranzdo.bukkit.methodcommand.CommandHandler;

/**
 * @author B2OJustin
 */
public class LegendsCore extends JavaPlugin {
	private static LegendsCore instance;
	
	private CommandHandler commandHandler;
	private ConfigHandler configHandler;

    public static LegendsCore getInstance() {
        return instance;
    }
	
	@Override
	public void onEnable() {
            LegendsCore.instance = this;
            commandHandler = new CommandHandler(this);
            configHandler = new ConfigHandler(getDataFolder());
            DependencyHandler.resolve();

            getServer().getPluginManager().registerEvents(new LegendsListener(), this);
            EventManager.registerEvents(new BaseListener());
	}
	
	@Override
	public void onDisable() {
		configHandler.cleanup();
	}

	public CommandHandler getCommandHandler() {
		return commandHandler;
	}

	public ConfigHandler getConfigHandler() {
		return configHandler;
	}
}
