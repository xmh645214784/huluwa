package cn.xmh.Holders.Creatures.Bad;

import cn.xmh.Position.PositionInterface;
import cn.xmh.Settings.ImagesSet;

public class Scorpion extends Monster {
    private static Scorpion ourInstance ;

    public static Scorpion getInstance(PositionInterface positionInterface) {
        if(ourInstance==null)
            ourInstance=new Scorpion(positionInterface);
        return ourInstance;
    }

    private Scorpion(PositionInterface positionInterface) {
        super("蝎",positionInterface, ImagesSet.ScorpionImage);
    }


    @Override
    public void run(){
    }
}
