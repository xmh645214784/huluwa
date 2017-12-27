package Settings;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Settings {
    private static Settings ourInstance;

    static {
        ourInstance = new Settings();
    }

    public static Settings getInstance() {
        return ourInstance;
    }

    private Properties properties = new Properties();

    private int NRX, NRY;

    private Settings() {
        try {
            properties.load(new BufferedInputStream(new FileInputStream("configure.txt")));
        } catch (IOException e) {
            System.err.println("Can't find configure file.");
            e.printStackTrace();
        }
        NRX = Integer.parseInt(properties.getProperty("NRX"));
        if (NRX < 2 || NRX > 100) {
            System.err.println("Configure file error :NRX");
            System.exit(-1);
        }
        NRY = Integer.parseInt(properties.getProperty("NRY"));
        if (NRY < 7 || NRY > 100) {
            System.err.println("Configure file error :NRY");
            System.exit(-1);
        }
    }

    public int getNRX() {
        return NRX;
    }

    public int getNRY() {
        return NRY;
    }
}
