package Creatures;

import Position.PositionInterface;

public class Grandpa extends Creature {
    private static Grandpa mInstance;

    public static Grandpa getInstance(PositionInterface positionInterface) {
        if(mInstance ==null)
            mInstance =new Grandpa(positionInterface);
        return mInstance;
    }

    private Grandpa(PositionInterface positionInterface) {
        super("爷",positionInterface);
    }

    @Override
    public void report(){
        System.out.println(name+"@"+this.position.toString());
    }


    @Override
    public void act() {
        System.out.println("爷爷加入战场：我来了，葫芦娃们，我们上！");
    }
}
