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

package com.github.championsdev.champions.library.module;

import com.github.championsdev.champions.library.server.ServerBridge;
import com.github.championsdev.champions.library.server.ServerHandler;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author YoshiGenius
 */
public class Module {

    protected File file;
    protected boolean initialized;
    protected ModuleDescriptionFile description;
    protected File cfgFile;
    protected ModuleConfig cfg;
    private ClassLoader classLoader;
    private Logger logger;

    public String getName() {
        return this.getDescription().getName();
    }

    public ModuleDescriptionFile getDescription() {
        return this.description;
    }

    public String[] getSupportedPlatforms() {
        return this.description.getPlatforms();
    }

    public void onEnable() {

    }

    public void onDisable() {

    }

    public File getDataFolder() {
        return this.cfgFile.getParentFile();
    }

    public ServerBridge getServer() {
        return ServerHandler.getServerBridge();
    }

    public void saveDefaultConfig() {
        if (!cfgFile.exists()) {
            try {
                cfgFile.createNewFile();
                JarFile file = new JarFile(this.cfgFile);
                JarEntry entry = file.getJarEntry("config.yml");
                InputStream is = file.getInputStream(entry);

            } catch (Exception e) {}
        }
    }

    public InputStream getResource(String filename) {
        if (filename == null) {
            throw new IllegalArgumentException("Filename cannot be null");
        }

        try {
            URL url = getClassLoader().getResource(filename);

            if (url == null) {
                return null;
            }

            URLConnection connection = url.openConnection();
            connection.setUseCaches(false);
            return connection.getInputStream();
        } catch (IOException ex) {
            return null;
        }
    }

    public ClassLoader getClassLoader() {
        return this.classLoader;
    }

    public void saveResource(String resourcePath, boolean replace) {
        if (resourcePath == null || resourcePath.equals("")) {
            throw new IllegalArgumentException("ResourcePath cannot be null or empty");
        }

        resourcePath = resourcePath.replace('\\', '/');
        InputStream in = getResource(resourcePath);
        if (in == null) {
            throw new IllegalArgumentException("The embedded resource '" + resourcePath + "' cannot be found in " + file);
        }

        File outFile = new File(getDataFolder(), resourcePath);
        int lastIndex = resourcePath.lastIndexOf('/');
        File outDir = new File(getDataFolder(), resourcePath.substring(0, lastIndex >= 0 ? lastIndex : 0));

        if (!outDir.exists()) {
            outDir.mkdirs();
        }

        try {
            if (!outFile.exists() || replace) {
                OutputStream out = new FileOutputStream(outFile);
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                out.close();
                in.close();
            } else {
                getLogger().log(Level.WARNING, "Could not save " + outFile.getName() + " to " + outFile + " because " + outFile.getName() + " already exists.");
            }
        } catch (IOException ex) {
            getLogger().log(Level.SEVERE, "Could not save " + outFile.getName() + " to " + outFile, ex);
        }
    }

    public Logger getLogger() {
        return this.logger;
    }

    protected final void initialize(ModuleDescriptionFile description, File file, File cfgFile, ClassLoader classLoader, Logger logger) {
        if (!initialized) {
            this.initialized = true;
            this.file = file;
            this.description = description;
            this.cfgFile = cfgFile;
            this.cfg = ModuleConfig.loadConfiguration(cfgFile);
            this.classLoader = classLoader;
            this.logger = logger;
        }
    }

}
