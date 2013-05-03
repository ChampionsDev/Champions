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

package net.dawnfirerealms.legends.core.dependencies;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author YoshiGenius
 */
public class DependencyHandler {

    public static void resolve() {
        
    }
    
    public static boolean downloadFile(URL from, File to, boolean overwrite) throws FileNotFoundException, MalformedURLException, IOException {
        if (to.exists() && !overwrite) {
            return false;
        }
        if (to.exists() && overwrite) {
            to.delete();
        }
        BufferedInputStream in = null;
    	FileOutputStream fout = null;
        if (!to.exists()) {
            to.createNewFile();
        }
    	try {
    		in = new BufferedInputStream(from.openStream());
    		fout = new FileOutputStream(to);

    		byte data[] = new byte[1024];
    		int count;
    		while ((count = in.read(data, 0, 1024)) != -1) {
    			fout.write(data, 0, count);
    		}
    	} finally {
    		if (in != null) {
                    in.close();
                }
    		if (fout != null) {
                    fout.close();
                }
    	}
        return true;
    }

}