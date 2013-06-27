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

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;

import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author YoshiGenius
 */
public final class ModuleDescriptor {
    private static final Yaml yaml = new Yaml(new SafeConstructor());
    private String[] platforms = new String[]{};
    private String name = null;
    private String main = null;
    private String version = null;
    private String description = null;
    private List<String> authors = null;
    private String website = null;

    public ModuleDescriptor(final InputStream stream) {
        loadMap(asMap(yaml.load(stream)));
    }

    public ModuleDescriptor(final Reader reader) {
        loadMap(asMap(yaml.load(reader)));
    }

    public ModuleDescriptor(final String pluginName, final String pluginVersion, final String mainClass, final String[] supportedPlatforms) {
        name = pluginName;
        version = pluginVersion;
        main = mainClass;
        platforms = supportedPlatforms;
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

    public void save(Writer writer) {
        yaml.dump(saveMap(), writer);
    }

    private void loadMap(Map<?, ?> map) {
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

    private Map<String, Object> saveMap() {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("name", name);
        map.put("main", main);
        map.put("version", version);

        if (website != null) {
            map.put("website", website);
        }
        if (description != null) {
            map.put("description", description);
        }

        if (authors.size() == 1) {
            map.put("author", authors.get(0));
        } else if (authors.size() > 1) {
            map.put("authors", authors);
        }

        return map;
    }

    private Map<?,?> asMap(Object object) {
        if (object instanceof Map) {
            return (Map<?,?>) object;
        }
        return null;
    }

    public String[] getPlatforms() {
        return this.platforms;
    }
}
