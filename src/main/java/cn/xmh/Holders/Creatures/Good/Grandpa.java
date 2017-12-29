package cn.xmh.Holders.Creatures.Good;

import cn.xmh.Position.PositionInterface;
import cn.xmh.Settings.ImagesSet;
import cn.xmh.Settings.Settings;

public class Grandpa extends Good {
    private static Grandpa mInstance;

    public static Grandpa getInstance(PositionInterface positionInterface) {
        if(mInstance ==null)
            mInstance =new Grandpa(positionInterface);
        return mInstance;
    }

    private Grandpa(PositionInterface positionInterface) {
        super("爷",positionInterface, ImagesSet.GrandpaImage);
        hp= Settings.getInstance().getHP_OF_GRANDPA();
        damage=Settings.getInstance().getDMG_OF_GRANDPA();
    }

    @Override
    public void report(){
        System.out.println(mName +"@"+this.position.toString());
    }

}
