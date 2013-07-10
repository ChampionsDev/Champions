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

import com.github.championsdev.champions.library.event.EventListener;
import com.github.championsdev.champions.library.event.EventManager;
import com.github.championsdev.champions.library.exceptions.InvalidDescriptorException;
import com.github.championsdev.champions.library.misc.Descriptor;
import com.github.championsdev.champions.library.util.PlatformUtil;
import com.github.championsdev.champions.library.util.ResourceUtil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Logger;

/**
 * @author YoshiGenius
 */
public class ModuleLoader {
    private final static Logger logger = Logger.getLogger(ModuleLoader.class.getName());

    private static final ArrayList<Module> modules = new ArrayList<>();
    private static File moduleDir = new File("modules");
    private static HashMap<Module, Boolean> statuses = new HashMap<>();

    public static Logger getLogger() {
        return logger;
    }

    public static Module[] loadModules() {
        Descriptor descriptor;
        for (File file : moduleDir.listFiles()) {
            if (!ResourceUtil.isJarFile(file)) continue;
            try (JarFile jarFile = new JarFile(file)) {
                JarEntry entry = jarFile.getJarEntry("module.yml");
                if (entry == null) {
                    logger.severe(String.format("Could not load module. %s is missing a module.yml file.", jarFile.getName()));
                    continue;
                }
                InputStream inputStream = jarFile.getInputStream(entry);
                descriptor = new Descriptor(inputStream);
            } catch(IOException | InvalidDescriptorException e) {
                e.printStackTrace();
                continue;
            }

            Module module;
            try {
                //TODO
                if (isCompatible(descriptor.getPlatforms())) {
                    Class<?> jarClass = Class.forName(descriptor.getMain());
                    Class<? extends Module> moduleClass = jarClass.asSubclass(Module.class);
                    Constructor<? extends Module> constructor = moduleClass.getConstructor();

                    module = constructor.newInstance();
                    if(module != null) {
                        module.init(descriptor);
                        modules.add(module);
                    }
                }
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                    IllegalAccessException  e) {
                logger.warning("Failed to initialize module '" + descriptor.getName() + "'");
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                logger.warning(String.format("Could not find main class '%s' for module '%s'", descriptor.getMain(), descriptor.getName()));
                e.printStackTrace();
            }
        }
        for (Module module : modules) {
            enableModule(module);
        }
        return modules.toArray(new Module[modules.size()]);
    }

    public static void enableModule(Module module) {
        if (module == null) return;
        if (isEnabled(module)) return;
        try {
            module.onEnable();
        } catch (Exception e) {
            disableModule(module);
            e.printStackTrace();
            return;
        }
        statuses.put(module, true);
    }

    public static void disableModule(Module module) {
        if (module == null) return;
        if (!isEnabled(module)) return;
        for (EventListener listener : EventManager.getRegisteredEvents(module)) {
            EventManager.unregisterEvents(listener);
        }
        statuses.put(module, false);
    }

    public static boolean isEnabled(Module module) {
        if (module == null) return false;
        return statuses.get(module);
    }

    public static boolean isCompatible(Module module) {
        if (module == null) return false;
        return isCompatible(module.getSupportedPlatforms());
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
