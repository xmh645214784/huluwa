package cn.xmh.settings;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Settings {
    private static Settings ourInstance;

    static {
        ourInstance = new Settings();
    }

    private int NRX;
    private int NRY;
    private int DISTANCE_OF_ENCOUNTER;
    private int NR_LOLOS;

    private int DMG_OF_HULUWA;
    private int HP_OF_HULUWA;
    private int DMG_OF_GRANDPA;
    private int HP_OF_GRANDPA;
    private int DMG_OF_SNAKE;
    private int HP_OF_SNAKE;
    private int DMG_OF_SCORPION;
    private int HP_OF_SCORPION;
    private int DMG_OF_LOLO;



    private int HP_OF_LOLO;

    public static Settings getInstance() {
        return ourInstance;
    }

    private Properties properties = new Properties();


    private Settings() {
        try {
            properties.load(new BufferedInputStream(new FileInputStream(this.getClass().getClassLoader().getResource("configure.properties").getFile())));
        } catch (IOException e) {
            System.err.println("Can't find configure file.");
            e.printStackTrace();
        }
        NRX = Integer.parseInt(properties.getProperty("NRX"));
        if (NRX < 10 || NRX > 30) {
            System.err.println("Configure file error :NRX");
            System.exit(-1);
        }
        NRY = Integer.parseInt(properties.getProperty("NRY"));
        if (NRY < 10 || NRY > 30) {
            System.err.println("Configure file error :NRY");
            System.exit(-1);
        }
        NR_LOLOS = Integer.parseInt(properties.getProperty("NR_LOLOS"));
        if (NR_LOLOS < 0 || NR_LOLOS > 10) {
            System.err.println("Configure file error :NR_LOLOS");
            System.exit(-1);
        }
        DISTANCE_OF_ENCOUNTER = Integer.parseInt(properties.getProperty("DISTANCE_OF_ENCOUNTER"));
        if (DISTANCE_OF_ENCOUNTER < 0 || DISTANCE_OF_ENCOUNTER > 2) {
            System.err.println("Configure file error :DISTANCE_OF_ENCOUNTER");
            System.exit(-1);
        }
        DMG_OF_HULUWA = Integer.parseInt(properties.getProperty("DMG_OF_HULUWA"));
        if (DMG_OF_HULUWA < 0 || DMG_OF_HULUWA > 100) {
            System.err.println("Configure file error :DMG_OF_HULUWA");
            System.exit(-1);
        }
        HP_OF_HULUWA = Integer.parseInt(properties.getProperty("HP_OF_HULUWA"));
        if (HP_OF_HULUWA < 1 || HP_OF_HULUWA>100) {
            System.err.println("Configure file error :HP_OF_HULUWA");
            System.exit(-1);
        }
        DMG_OF_GRANDPA = Integer.parseInt(properties.getProperty("DMG_OF_GRANDPA"));
        if (DMG_OF_GRANDPA < 0 || DMG_OF_GRANDPA > 100) {
            System.err.println("Configure file error :DMG_OF_GRANDPA");
            System.exit(-1);
        }
        HP_OF_GRANDPA = Integer.parseInt(properties.getProperty("HP_OF_GRANDPA"));
        if (HP_OF_GRANDPA < 1 || HP_OF_GRANDPA>100) {
            System.err.println("Configure file error :HP_OF_GRANDPA");
            System.exit(-1);
        }
        DMG_OF_SNAKE = Integer.parseInt(properties.getProperty("DMG_OF_SNAKE"));
        if (DMG_OF_SNAKE < 0 || DMG_OF_SNAKE > 100) {
            System.err.println("Configure file error :DMG_OF_SNAKE");
            System.exit(-1);
        }
        HP_OF_SNAKE = Integer.parseInt(properties.getProperty("HP_OF_SNAKE"));
        if (HP_OF_SNAKE < 1 || HP_OF_SNAKE>100) {
            System.err.println("Configure file error :HP_OF_SNAKE");
            System.exit(-1);
        }
        DMG_OF_SCORPION = Integer.parseInt(properties.getProperty("DMG_OF_SCORPION"));
        if (DMG_OF_SCORPION < 0 || DMG_OF_SCORPION > 100) {
            System.err.println("Configure file error :DMG_OF_SCORPION");
            System.exit(-1);
        }
        HP_OF_SCORPION = Integer.parseInt(properties.getProperty("HP_OF_SCORPION"));
        if (HP_OF_SCORPION < 1 || HP_OF_SCORPION>100) {
            System.err.println("Configure file error :HP_OF_SCORPION");
            System.exit(-1);
        }
        DMG_OF_LOLO = Integer.parseInt(properties.getProperty("DMG_OF_LOLO"));
        if (DMG_OF_LOLO < 0 || DMG_OF_LOLO > 100) {
            System.err.println("Configure file error :DMG_OF_LOLO");
            System.exit(-1);
        }
        HP_OF_LOLO = Integer.parseInt(properties.getProperty("HP_OF_LOLO"));
        if (HP_OF_LOLO < 1 || HP_OF_LOLO>100) {
            System.err.println("Configure file error :HP_OF_LOLO");
            System.exit(-1);
        }
    }

    public int getNRX() {
        return NRX;
    }

    public int getNRY() {
        return NRY;
    }

    public int getDISTANCE_OF_ENCOUNTER() {
        return DISTANCE_OF_ENCOUNTER;
    }

    public int getNR_LOLOS() {
        return NR_LOLOS;
    }

    public int getDMG_OF_HULUWA() {
        return DMG_OF_HULUWA;
    }

    public int getHP_OF_HULUWA() {
        return HP_OF_HULUWA;
    }

    public int getDMG_OF_GRANDPA() {
        return DMG_OF_GRANDPA;
    }

    public int getHP_OF_GRANDPA() {
        return HP_OF_GRANDPA;
    }

    public int getDMG_OF_SNAKE() {
        return DMG_OF_SNAKE;
    }

    public int getHP_OF_SNAKE() {
        return HP_OF_SNAKE;
    }

    public int getDMG_OF_SCORPION() {
        return DMG_OF_SCORPION;
    }

    public int getHP_OF_SCORPION() {
        return HP_OF_SCORPION;
    }

    public int getDMG_OF_LOLO() {
        return DMG_OF_LOLO;
    }
    public int getHP_OF_LOLO() {
        return HP_OF_LOLO;
    }
}
