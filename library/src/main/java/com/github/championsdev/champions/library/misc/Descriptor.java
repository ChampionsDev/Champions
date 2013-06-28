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
import com.github.championsdev.champions.library.module.ModuleLoader;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author B2OJustin
 */
public class Descriptor {
    private String name = null;
    private String main = null;
    private String version = null;
    private String description = null;
    private List<String> authors = null;
    private String website = null;
    private String[] platforms = new String[]{};

    public Descriptor(final String pluginName, final String pluginVersion, final String mainClass, final String[] supportedPlatforms) {
        name = pluginName;
        version = pluginVersion;
        main = mainClass;
        platforms = supportedPlatforms;
    }

    public Descriptor(InputStream inputStream) throws InvalidDescriptorException {
        Yaml yaml = new Yaml();
        Object object = yaml.load(inputStream);
        if(object == null || !(object instanceof Map)) {
            throw new InvalidDescriptorException("Unable to process descriptor input stream");
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
