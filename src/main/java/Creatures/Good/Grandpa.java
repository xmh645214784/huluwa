package Creatures.Good;

import Position.PositionInterface;
import Settings.Settings;

public class Grandpa extends Good {
    private static Grandpa mInstance;

    public static Grandpa getInstance(PositionInterface positionInterface) {
        if(mInstance ==null)
            mInstance =new Grandpa(positionInterface);
        return mInstance;
    }

    private Grandpa(PositionInterface positionInterface) {
        super("爷",positionInterface,Settings.GrandpaImage);
    }

    @Override
    public void report(){
        System.out.println(mName +"@"+this.position.toString());
    }


    @Override
    public void run() {
        System.out.println("爷爷加入战场：我来了，葫芦娃们，我们上！");
    }
}
