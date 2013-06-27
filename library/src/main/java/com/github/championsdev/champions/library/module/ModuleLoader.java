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

import com.github.championsdev.champions.library.util.PlatformUtil;
import com.github.championsdev.champions.library.util.ResourceUtil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Logger;

/**
 * @author YoshiGenius
 */
public class ModuleLoader {

    private static Module[] modules = new Module[]{};
    private static File cfgDir = new File("cfg");
    private static File moduleDir = new File("champions/modules");
    private static boolean loaded = false;

    public static Module[] loadModules(Logger log, File directory, File cfgDir) {
        return loadModules(log, directory, cfgDir, false);
    }

    public static Module[] loadModules(Logger log, File directory, File configDir, boolean overwrite) {
        if (log == null) {
            Logger.getLogger(ModuleLoader.class.getName()).severe("null logger passed for module loading");
            return modules;
        }
        if (directory == null || configDir == null) {
            log.severe("[Champions] null module or config directory passed for module loading");
            return modules;
        }
        directory.mkdir();
        if (moduleDir == null) {
            moduleDir = directory;
        }
        configDir.mkdir();
        if (cfgDir == null) {
            cfgDir = configDir;
        }
        if (loaded && !overwrite) {
            return modules;
        }
        if (!(directory != null && directory.exists() && directory.isDirectory())) {
            return modules;
        }
        Module[] modules = new Module[]{};
        for (File file : moduleDir.listFiles()) {
            if (ResourceUtil.isJarFile(file)) {
                try {
                    JarFile jarFile = new JarFile(file);
                    JarEntry entry = jarFile.getJarEntry("module.yml");
                    if (entry == null) {
                        log.severe("module.yml not found in plugin file: " + file.getName());
                    } else {
                        InputStream is = jarFile.getInputStream(entry);
                        ModuleDescriptor desc = new ModuleDescriptor(is);
                        Module result = null;
                        if (isCompatible(desc.getPlatforms())) {
                            try {
                                URL[] urls = new URL[1];
                                urls[0] = file.toURI().toURL();

                                Class<?> jarClass = Class.forName(desc.getMain());
                                Class<? extends Module> module = jarClass.asSubclass(Module.class);

                                Constructor<? extends Module> constructor = module.getConstructor();

                                result = constructor.newInstance();

                                Logger moduleLogger = Logger.getLogger(desc.getName());
                                moduleLogger.setParent(log);
                                result.initialize(desc, file, new File(cfgDir, desc.getName() + ".cfg"), ClassLoader.getSystemClassLoader(), moduleLogger);
                            } catch (InvocationTargetException ex) {
                            } catch (Throwable ex) {
                            }
                        }
                        if (result != null) {
                            modules[modules.length] = result;
                        }
                    }
                } catch (IOException e) {}
            }
        }
        for (Module module : modules) {
            module.onEnable();
        }
        loaded = true;
        return modules;
    }

    public static File getCfgDir() {
        return cfgDir;
    }

    private static boolean isCompatible(String[] platforms) {
        for (String platform : platforms) {
            if (PlatformUtil.getCurrentPlatform().getName().toLowerCase().equalsIgnoreCase(platform)) {
                return true;
            }
        }
        return false;
    }

}
