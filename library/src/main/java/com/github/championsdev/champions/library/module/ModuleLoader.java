package com.github.championsdev.champions.library.module;

import com.github.championsdev.champions.library.database.DataManager;
import com.github.championsdev.champions.library.util.FileUtil;
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
 *         Date: 23/05/13
 *         Time: 6:56 PM
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
            if (FileUtil.isJarFile(file)) {
                try {
                    JarFile jarFile = new JarFile(file);
                    JarEntry entry = jarFile.getJarEntry("module.yml");
                    InputStream is = jarFile.getInputStream(entry);
                    ModuleDescriptionFile desc = new ModuleDescriptionFile(is);
                    Module result = null;
                    if (hasRightPlatform(desc.getPlatforms())) {
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

    private static boolean hasRightPlatform(String[] platforms) {
        for (String platform : platforms) {
            if (PlatformUtil.getCurrentPlatform().getName().toLowerCase().equalsIgnoreCase(platform)) {
                return true;
            }
        }
        return false;
    }

}
