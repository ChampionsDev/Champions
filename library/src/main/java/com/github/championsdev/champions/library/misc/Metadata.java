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

import java.util.HashMap;
import java.util.Map;

/**
 * @author B2OJustin
 */
public class Metadata {
    private Map<String, Object> metaMap = new HashMap<>();

    public Map<String, Object> getMetadataMap() {
        return metaMap;
    }

    public String getString(String mapKey) {
        Object object = metaMap.get(mapKey);
        if(object instanceof String) return (String) object;
        else return null;
    }

    public Integer getInteger(String mapKey) {
        Object object = metaMap.get(mapKey);
        if(object instanceof Integer) return (Integer) object;
        else return null;
    }

    public Boolean getBoolean(String mapKey) {
        Object object = metaMap.get(mapKey);
        if(object instanceof Boolean) return (Boolean) object;
        else return null;
    }

    public Double getDouble(String mapKey) {
        Object object = metaMap.get(mapKey);
        if(object instanceof Double) return (Double) object;
        else return null;
    }

    public <T> T getObject(String mapKey, T objectType) {
        Object object = metaMap.get(mapKey);
        return (T) object;
    }

    public Object getObject(String mapKey) {
        return metaMap.get(mapKey);
    }

    public Object put(String mapKey, Object object) {
        return metaMap.put(mapKey, object);
    }

}
