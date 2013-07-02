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

package com.github.championsdev.champions.library.behavior;

import com.github.championsdev.champions.library.BasicHandler;
import com.github.championsdev.champions.library.misc.Descriptor;
import com.github.championsdev.champions.library.skill.Skill;
import com.github.championsdev.champions.library.util.ResourceUtil;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Logger;

/**
 * Handles registering and retrieving {@link Behavior} instances.
 * @author B2OJustin
 */
public class BehaviorHandler extends BasicHandler<Behavior>{
    private static Logger logger = Logger.getLogger(BehaviorHandler.class.getName());
    private static BehaviorHandler instance = new BehaviorHandler();
    private static final String classPath = "champions/behaviors";
    public static BehaviorHandler getInstance() {
        return instance;
    }

    private BehaviorHandler() {
    }

    public Behavior loadFromJar(String id) {
        Behavior behavior = super.get(id);
        if(behavior != null) return behavior;
        Descriptor descriptor = ResourceUtil.loadDescriptor(new File(id + ".jar"), "behavior.yml");
        if(descriptor == null) return null;

        try {
            URL url = new File(classPath).toURI().toURL();
            ClassLoader classLoader = new URLClassLoader(new URL[]{url});
            Class clazz = classLoader.loadClass(descriptor.getMain());
            behavior = (Behavior) clazz.newInstance();
            register(id, behavior);
            return behavior;
        } catch (ClassNotFoundException e) {
            logger.warning("Could not load class file for behavior " + id);
            e.printStackTrace();
        } catch (MalformedURLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
