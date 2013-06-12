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

package com.github.championsdev.champions.bukkit.core.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import com.google.common.io.Files;
import com.google.common.io.InputSupplier;

/**
 * @author YoshiGenius
 */
public class DependencyHandler {

    public static void resolve() {
        
    }
    
    public static boolean downloadFile(final URL from, File to, boolean overwrite) {
        if (to.exists() && !overwrite)
            return false;
        
        if (to.exists() && overwrite)
            to.delete();
        
        if (!to.exists()) {
            try {
                to.createNewFile();
            } catch (IOException e) {
                return false;
            }
        }
        
    	try {
            Files.copy(new InputSupplier<InputStream>() {

                @Override
                public InputStream getInput() throws IOException {
                    return from.openStream();
                }
                
            }, to);
        } catch (IOException e) {
            return false;
        }
        
        return true;
    }

}