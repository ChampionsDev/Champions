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
package com.github.championsdev.champions.library.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author B2OJustin
 */
public class FileClassLoader {

    public static Class<?> load(Class<?> clazz, String filePath, String className) {
        File file = new File(filePath);
        try {
            URL url = file.toURI().toURL(); // file:/c:/myclasses/
            URLClassLoader cl = new URLClassLoader(new URL[]{url});
            Class<?> returnMe = cl.loadClass(clazz.getPackage() + "." + className);
            cl.close();
            return returnMe;
        } catch (ClassNotFoundException | IOException ignored) {}
        return null;
    }

}
