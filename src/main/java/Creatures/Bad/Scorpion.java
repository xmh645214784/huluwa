package Creatures.Bad;

import Position.PositionInterface;
import Settings.Settings;

public class Scorpion extends Monster {
    private static Scorpion ourInstance ;

    public static Scorpion getInstance(PositionInterface positionInterface) {
        if(ourInstance==null)
            ourInstance=new Scorpion(positionInterface);
        return ourInstance;
    }

    private Scorpion(PositionInterface positionInterface) {
        super("蝎",positionInterface,Settings.ScorpionImage);
    }


    @Override
    public void run(){
        ;
    }
}
