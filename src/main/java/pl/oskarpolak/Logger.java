package pl.oskarpolak;

/**
 * Created by OskarPraca on 2017-03-23.
 */
public class Logger {
    private static boolean debugMode = true;

    public static void log(String className, String message) {
        if (debugMode) {
            System.out.println(className + " : " + message);
        }
    }
}
