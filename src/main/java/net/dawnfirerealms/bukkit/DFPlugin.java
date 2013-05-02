/*
This file is part of DawnFire-Realms.

    DawnFire-Realms is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    DawnFire-Realms is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with DawnFire-Realms.  If not, see <http://www.gnu.org/licenses/>.
*/

package net.dawnfirerealms.bukkit;

import net.dawnfirerealms.bukkit.races.RaceHandler;
import net.dawnfirerealms.bukkit.utils.ConfigHandler;

import org.bukkit.plugin.java.JavaPlugin;

import se.ranzdo.bukkit.methodcommand.CommandHandler;

public class DFPlugin extends JavaPlugin {
	public static DFPlugin instance;
	
	private CommandHandler commandHandler;
	private ConfigHandler configHandler;
	private RaceHandler raceHandler;
	
	@Override
	public void onEnable() {
		commandHandler = new CommandHandler(this);
		configHandler = new ConfigHandler(getDataFolder());
		raceHandler = new RaceHandler();
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
