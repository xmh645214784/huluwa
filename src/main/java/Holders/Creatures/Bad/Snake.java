package Holders.Creatures.Bad;

import BattleGround.BattleGround;
import Position.PositionInterface;
import Settings.ImagesSet;

public class Snake extends Monster {
    private static Snake ourInstance ;

    public static Snake getInstance(PositionInterface positionInterface) {
        if(ourInstance==null)
            ourInstance=new Snake(positionInterface);
        return ourInstance;
    }

    private Snake(PositionInterface positionInterface) {
        super("蛇",positionInterface, ImagesSet.SnakeImage);
    }

    @Override
    public String toString() {
        return mName;
    }

    @Override
    public void run() {
    }
}
