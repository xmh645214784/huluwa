package Creatures.Bad;

import Position.PositionInterface;
import Settings.Settings;

public class Snake extends Monster {
    private static Snake ourInstance ;

    public static Snake getInstance(PositionInterface positionInterface) {
        if(ourInstance==null)
            ourInstance=new Snake(positionInterface);
        return ourInstance;
    }

    private Snake(PositionInterface positionInterface) {
        super("蛇",positionInterface,Settings.SnakeImage);
    }

    @Override
    public String toString() {
        return mName;
    }

    @Override
    public void run() {
        System.out.println("蛇精加入战场：如意如意,随我心意！");
    }
}
