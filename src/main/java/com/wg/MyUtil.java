package com.wg;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.nio.file.Path;
import java.util.*;

/**
    Miscellaneous helpful functions
 */
public class MyUtil {

    public static UUID urlToUUID(String url) {
        return UUID.nameUUIDFromBytes(url.getBytes());
    }

    /**
         List all the files within a directory.
     */
    public static List<String> GetDirectoryListing(String path) {
        File f = new File(path);
        if(f.list() == null) {System.out.println(path);}
        return Arrays.asList(f.list());

    }

    /**
        Create a directory.
        @param dirname path for directory.
     */
    public static File CreateDirectory(String dirname) {
        File f = new File(dirname);
        f.mkdir();
        return f;
    }


    /**
     *
     * @param path absolute path to a file directory
     */
    public static Boolean CheckIfFileExists(Path path) {
        ArrayList<String> list = new ArrayList<String>(MyUtil.GetDirectoryListing(path.getParent().toString()));
        return list.contains(path.getFileName().toString());
    }

    public static void log(String s) {
        System.out.println(s);
    }

    /**
     Read webpage URLs from a file
     */
    public static String[] getLinks(String filePath) {
        String[] links = new String[]{};
        java.io.File infile = new java.io.File(filePath);
        return links;

    }

    /**
     Create a FirefoxDriver with options enabled.
     */
    public static FirefoxDriver CreateFFDriver() {
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        firefoxBinary.addCommandLineOptions("--load-images=no");
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("permissions.default.image", 2);
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        firefoxOptions.setProfile(firefoxProfile);

        return new FirefoxDriver(firefoxOptions);
    }
}

