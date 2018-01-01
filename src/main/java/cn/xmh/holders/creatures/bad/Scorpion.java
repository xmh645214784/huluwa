package cn.xmh.holders.creatures.bad;

import cn.xmh.position.PositionInterface;
import cn.xmh.settings.ImagesSet;
import cn.xmh.settings.Settings;

public class Scorpion extends Monster {
    private static Scorpion ourInstance ;

    public static Scorpion getInstance(PositionInterface positionInterface) {
        if(ourInstance==null)
            ourInstance=new Scorpion(positionInterface);
        return ourInstance;
    }

    private Scorpion(PositionInterface positionInterface) {
        super("蝎",positionInterface, ImagesSet.ScorpionImage);
        damage=Settings.getInstance().getDMG_OF_SCORPION();
        hp= Settings.getInstance().getHP_OF_SCORPION();
    }

}
