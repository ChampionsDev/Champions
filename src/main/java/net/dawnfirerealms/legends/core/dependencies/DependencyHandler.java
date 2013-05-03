package net.dawnfirerealms.legends.core.dependencies;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
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