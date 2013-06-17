/*
 * ****************************************************************************
 *     This file is part of Champions.
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
 * ****************************************************************************
 */

package com.github.championsdev.champions.library.module;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author YoshiGenius
 */
public class ModuleConfig {

    private Map<String, String> paths = new HashMap<>();

    public Set<String> getKeys() {
        return paths.keySet();
    }

    public static ModuleConfig loadConfiguration(File cfgFile) {
        ModuleConfig config = new ModuleConfig();
        config.load(cfgFile);
        return config;
    }

    public void load(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String nextLine = scanner.next();
                if (nextLine.contains("=")) {
                    String[] data = nextLine.split("=", 1);
                    String path = data[0];
                    String setTo = data[1];
                    paths.put(path, setTo);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String get(String path) {
        if (!paths.containsKey(path)) {
            return null;
        }
        return paths.get(path);
    }

    public boolean getBoolean(String path) {
        String s = get(path);
        if (s.equalsIgnoreCase("true") || s.equalsIgnoreCase("t") || s.equalsIgnoreCase("yes") || s.equalsIgnoreCase("y")) {
            return true;
        } else if (s.equalsIgnoreCase("false") || s.equalsIgnoreCase("f") || s.equalsIgnoreCase("no") || s.equalsIgnoreCase("n")) {
            return false;
        } else {
            return Boolean.getBoolean(path);
        }
    }

    public int getInt(String path) {
        try {
            return Integer.parseInt(get(path));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public double getDouble(String path) {
        try {
            return Double.parseDouble(get(path));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public float getFloat(String path) {
        try {
            return Float.parseFloat(get(path));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public long getLong(String path) {
        try {
            return Long.parseLong(get(path));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public short getShort(String path) {
        try {
            return Short.parseShort(get(path));
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
