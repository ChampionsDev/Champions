package com.github.championsdev.champions.library.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

import edu.emory.mathcs.backport.java.util.Arrays;

/**
 * @author Kezz101
 */
public class FileUtils {
    
    /**
     * Copys a URL to a file, replacing the file if it exists.
     * @param url the url to copy
     * @param file the target location of the file
     * @return the number of bytes copied
     * @throws IOException if an error occurred during copying
     */
    public static long copyURLToFile(URL url, File file) throws IOException {
        createCheck(file);
        return Files.copy(url.openStream(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    
    /**
     * Writes any number of strings to a file
     * @param file the file to write to
     * @param strings the strings to write to the file
     * @throws IOException if an error occurred whilst writing
     */
    @SuppressWarnings("unchecked")
    public static void writeStringToFile(File file, String... strings) throws IOException {
        createCheck(file);
        Files.write(file.toPath(), Arrays.asList(strings), Charset.defaultCharset(), StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    }
    
    private static void createCheck(File file) throws IOException {
        if(!file.exists()) {
            file.mkdirs();
            file.createNewFile();
        }
    }

}
