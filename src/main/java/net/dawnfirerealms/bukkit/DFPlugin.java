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
