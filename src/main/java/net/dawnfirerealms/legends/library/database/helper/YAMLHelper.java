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
package net.dawnfirerealms.legends.library.database.helper;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.logging.Logger;

/**
 * Provides a simple API for accessing YAML data.
 * <p>
 * Note: This class is not thread safe!
 *
 * @author B2OJustin
 */
@SuppressWarnings("unchecked")
public class YAMLHelper {
    private static final Logger logger = Logger.getLogger(YAMLHelper.class.getName());
    private LinkedHashMap<String, Object> dataMap;
    private Yaml yaml = new Yaml();

    public YAMLHelper(String filePath) throws FileNotFoundException {
        loadFile(filePath);
    }

    public YAMLHelper(LinkedHashMap dataMap) {
        this.dataMap = dataMap;
    }

    public YAMLHelper loadFile(String filePath) throws FileNotFoundException {
        InputStream fileStream = null;
        fileStream = new FileInputStream(filePath);
        dataMap = ((LinkedHashMap<String, Object>)yaml.load(fileStream));
        return this;
    }

    public Object getDefault(String path) {
        LinkedHashMap<String, Object> currentMap;
        String[] pathArray = path.split("\\.");
        currentMap = dataMap;
        for (int i = 0; i < pathArray.length; i++) {
            if(i == pathArray.length - 1) {
                return currentMap.get(pathArray[i]);
            }
            else currentMap = (LinkedHashMap) currentMap.get(pathArray[i]);
        }
        return currentMap;
    }

    public String getString(String path) {
        String string = (String) getDefault(path);
        return string != null ? string : "";
    }

    public Object get(String path) {
        return getDefault(path);
    }
}

