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

import net.dawnfirerealms.legends.core.dependencies.DependencyHandler;
import net.dawnfirerealms.legends.core.utils.ConfigHandler;
import net.dawnfirerealms.legends.library.race.RaceHandler;
import org.bukkit.plugin.java.JavaPlugin;
import se.ranzdo.bukkit.methodcommand.CommandHandler;

/**
 * @author B2OJustin
 */
public class LegendsPlugin extends JavaPlugin {
	public static LegendsPlugin instance;
	
	private CommandHandler commandHandler;
	private ConfigHandler configHandler;
	private RaceHandler raceHandler;
	
	@Override
	public void onEnable() {
		commandHandler = new CommandHandler(this);
		configHandler = new ConfigHandler(getDataFolder());
		raceHandler = new RaceHandler();
                DependencyHandler.resolve();
	}
	
	@Override
	public void onDisable() {
		instance = null;
		configHandler.cleanup();
	}

	public CommandHandler getCommandHandler() {
		return commandHandler;
	}

	public ConfigHandler getConfigHandler() {
		return configHandler;
	}
	
	public RaceHandler getRaceHandler() {
		return raceHandler;
	}
}
