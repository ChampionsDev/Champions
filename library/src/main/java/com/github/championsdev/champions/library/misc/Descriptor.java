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

package com.github.championsdev.champions.library.misc;

import com.github.championsdev.champions.library.exceptions.InvalidDescriptorException;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author B2OJustin
 */
public class Descriptor {
    private String name;
    private String main;
    private String version;
    private String description;
    private List<String> authors;
    private String website;
    private String[] platforms;

    public Descriptor(final String name, final String version, final String mainClass, final String[] supportedPlatforms) {
        this.name = name;
        this.version = version;
        main = mainClass;
        platforms = supportedPlatforms;
    }

    public Descriptor(InputStream inputStream) throws InvalidDescriptorException {
        Yaml yaml = new Yaml();
        Object object = yaml.load(inputStream);
        if(object == null || !(object instanceof Map)) {
            throw new InvalidDescriptorException("Unable to process descriptor input stream");
        }
        loadMap((Map<String, ?>) object);
    }

    public Descriptor(Map<String, ?> map) throws InvalidDescriptorException {
        loadMap(map);
    }

    private void loadMap(Map<String, ?> map) throws InvalidDescriptorException {
        if (map == null) return;
        try {
            name = map.get("name").toString();

            if (!name.matches("^[A-Za-z0-9 _.-]+$")) {
                return;
            }
        } catch (NullPointerException ex) {
            return;
        } catch (ClassCastException ex) {
            return;
        }

        try {
            version = map.get("version").toString();
        } catch (NullPointerException ex) {
            return;
        } catch (ClassCastException ex) {
            return;
        }

        try {
            main = map.get("main").toString();
            if (main.startsWith("com.github.championsdev.champions.")) {
                return;
            }
        } catch (NullPointerException ex) {
            return;
        } catch (ClassCastException ex) {
            return;
        }
        try {
            Object obj = map.get("platforms");
            if (obj != null && obj instanceof String[]) {
                platforms = (String[]) obj;
            } else {
                return;
            }
        } catch (NullPointerException ex) {
            return;
        }

        if (map.get("website") != null) {
            website = map.get("website").toString();
        }

        if (map.get("description") != null) {
            description = map.get("description").toString();
        }

        if (map.get("authors") != null) {
            ArrayList<String> authorsBuilder = new ArrayList<String>();
            if (map.get("author") != null) {
                authorsBuilder.add(map.get("author").toString());
            }
            try {
                for (Object o : (Iterable<?>) map.get("authors")) {
                    authorsBuilder.add(o.toString());
                }
            } catch (ClassCastException ex) {
                return;
            } catch (NullPointerException ex) {
                return;
            }
            authors = authorsBuilder;
        } else if (map.get("author") != null) {
            ArrayList<String> authorz = new ArrayList<String>();
            authorz.add(map.get("author").toString());
            authors = authorz;
        } else {
            authors = new ArrayList<String>();
        }
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getWebsite() {
        return website;
    }

    public String[] getPlatforms() {
        return platforms;
    }
}
