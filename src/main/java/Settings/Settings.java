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

    private int NRX;
    private int NRY;

    public int getDISTANCE_OF_ENCOUNTER() {
        return DISTANCE_OF_ENCOUNTER;
    }

    private int DISTANCE_OF_ENCOUNTER;

    public int getNR_LOLOS() {
        return NR_LOLOS;
    }

    private int NR_LOLOS;

    private Settings() {
        try {
            properties.load(new BufferedInputStream(new FileInputStream("configure.txt")));
        } catch (IOException e) {
            System.err.println("Can't find configure file.");
            e.printStackTrace();
        }
        NRX = Integer.parseInt(properties.getProperty("NRX"));
        if (NRX < 10 || NRX > 100) {
            System.err.println("Configure file error :NRX");
            System.exit(-1);
        }
        NRY = Integer.parseInt(properties.getProperty("NRY"));
        if (NRY < 10 || NRY > 100) {
            System.err.println("Configure file error :NRY");
            System.exit(-1);
        }
        NR_LOLOS=Integer.parseInt(properties.getProperty("NR_LOLOS"));
        if(NR_LOLOS<0||NR_LOLOS>10) {
            System.err.println("Configure file error :NR_LOLOS");
            System.exit(-1);
        }

        DISTANCE_OF_ENCOUNTER=Integer.parseInt(properties.getProperty("DISTANCE_OF_ENCOUNTER"));

    }

    public int getNRX() {
        return NRX;
    }

    public int getNRY() {
        return NRY;
    }
}
