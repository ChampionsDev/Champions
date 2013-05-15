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
import com.github.legendsdev.legends.library.Configuration;
import com.github.legendsdev.legends.library.database.DataManager;
import com.github.legendsdev.legends.library.database.YAMLDataSource;
import com.github.legendsdev.legends.library.race.RaceHandler;
import com.github.legendsdev.legends.library.util.JarUtils;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import se.ranzdo.bukkit.methodcommand.CommandHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Logger;

/**
 * @author B2OJustin
 */
public class LegendsCore extends JavaPlugin {
    private static Logger logger = Logger.getLogger(LegendsCore.class.getName());
    private static LegendsCore instance;

    private static String JAR_RESOURCE_DIRECTORY = "resources/";
    private static String CONFIG_PATH = "Legends/";
    private static String MAIN_CONFIG_FILE = "config.yml";
	
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

        try {
            // Copy default configuration files
            logger.info("Copying default configuration files...");
            int filesCopied = JarUtils.copyDirectoryFromJar(LegendsCore.class, JAR_RESOURCE_DIRECTORY, CONFIG_PATH, false);
            logger.info(String.format("Copied %d files", filesCopied));

            // Load configuration
            YAMLDataSource yamlDataSource = new YAMLDataSource(CONFIG_PATH);
            yamlDataSource.loadConfiguration(Configuration.getInstance(), MAIN_CONFIG_FILE);
        } catch (IOException e) {
            logger.severe("Could not write default configuration files to disk.");
            e.printStackTrace();
        }

        //Initialize data management
        DataManager.init(Configuration.getInstance());

        logger.info("Legends successfully enabled!");
	}
	
	@Override
	public void onDisable() {
		configHandler.cleanup();
	}

	public CommandHandler getCommandHandler() {
		return commandHandler;
	}
}
