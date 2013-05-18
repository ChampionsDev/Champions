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

package com.github.championsdev.champions.bukkit.core;

import com.github.championsdev.champions.bukkit.core.commands.ClassCommandExecutor;
import com.github.championsdev.champions.bukkit.core.listeners.ChampionsListener;
import com.github.championsdev.champions.bukkit.core.utils.DependencyHandler;
import com.github.championsdev.champions.library.Configuration;
import com.github.championsdev.champions.library.database.DataManager;
import com.github.championsdev.champions.library.database.YAMLDataSource;
import com.github.championsdev.champions.library.util.JarUtils;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author B2OJustin
 */
public class ChampionsCore extends JavaPlugin {
    private static Logger logger = Logger.getLogger(ChampionsCore.class.getName());
    private static ChampionsCore instance;

    private static String JAR_RESOURCE_DIRECTORY = "resources/";
    private static String CONFIG_PATH = "Champions/";
    private static String MAIN_CONFIG_FILE = "config.yml";

    public static ChampionsCore getInstance() {
        return instance;
    }
	
	@Override
	public void onEnable() {
        ChampionsCore.instance = this;

        DependencyHandler.resolve();

        getServer().getPluginManager().registerEvents(new ChampionsListener(), this);

        try {
            // Copy default configuration files
            logger.info("Copying default configuration files...");
            int filesCopied = JarUtils.copyDirectoryFromJar(ChampionsCore.class, JAR_RESOURCE_DIRECTORY, CONFIG_PATH, false);
            logger.info(String.format("Copied %d files", filesCopied));

            // Load configuration
            YAMLDataSource yamlDataSource = new YAMLDataSource(CONFIG_PATH);
            yamlDataSource.loadConfiguration(Configuration.getInstance(), MAIN_CONFIG_FILE);
        } catch (IOException e) {
            logger.severe("Could not write default configuration files to disk.");
        }

        //Initialize data management
        DataManager.init(Configuration.getInstance());

        // Register commands
        getCommand("class").setExecutor(new ClassCommandExecutor());

        logger.info("Champions successfully enabled!");
	}
}
