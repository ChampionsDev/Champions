/*
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
 */

package com.github.championsdev.champions.library.module;

import com.github.championsdev.champions.library.util.ResourceUtil;
import com.github.championsdev.champions.library.util.PlatformUtil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author YoshiGenius
 */
public class ModuleLoader {

    private static Module[] modules = new Module[]{};

    public static Module[] loadModules(File directory) {
        return loadModules(directory, false);
    }

    public static Module[] loadModules(File directory, boolean overwrite) {
        if (!overwrite) {
            return modules;
        }
        if (!(directory != null && directory.exists() && directory.isDirectory())) {
            return modules;
        }
        Module[] modules = new Module[]{};
        for (File file : directory.listFiles()) {
            if (ResourceUtil.isJarFile(file)) {
                try {
                    JarFile jarFile = new JarFile(file);
                    JarEntry entry = jarFile.getJarEntry("module.yml");
                    InputStream is = jarFile.getInputStream(entry);
                    ModuleDescriptionFile desc = new ModuleDescriptionFile(is);
                    Module result = null;
                    if (isCompatible(desc.getPlatforms())) {
                        try {
                            URL[] urls = new URL[1];
                            urls[0] = file.toURI().toURL();

                            Class<?> jarClass = Class.forName(desc.getMain());
                            Class<? extends Module> plugin = jarClass.asSubclass(Module.class);

                            Constructor<? extends Module> constructor = plugin.getConstructor();

                            result = constructor.newInstance();

                            result.initialize(desc, file);
                    } catch (InvocationTargetException ex) {
                    } catch (Throwable ex) {
                    }
                    }
                    if (result != null) {
                        modules[modules.length] = result;
                    }
                } catch (IOException e) {}
            }
        }
        for (Module module : modules) {
            module.onEnable();
        }
        return modules;
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
