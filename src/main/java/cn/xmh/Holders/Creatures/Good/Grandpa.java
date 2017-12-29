package cn.xmh.Holders.Creatures.Good;

import cn.xmh.Position.PositionInterface;
import cn.xmh.Settings.ImagesSet;

public class Grandpa extends Good {
    private static Grandpa mInstance;

    public static Grandpa getInstance(PositionInterface positionInterface) {
        if(mInstance ==null)
            mInstance =new Grandpa(positionInterface);
        return mInstance;
    }

    private Grandpa(PositionInterface positionInterface) {
        super("爷",positionInterface, ImagesSet.GrandpaImage);
    }

    @Override
    public void report(){
        System.out.println(mName +"@"+this.position.toString());
    }

}
