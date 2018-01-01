package cn.xmh.holders.creatures.bad;/*
* @author Minhui Xie
* @date 24,10,2017
* @time 19:20
*/

import cn.xmh.position.PositionInterface;
import cn.xmh.settings.ImagesSet;
import cn.xmh.settings.Settings;

public class Lolo extends Monster  {
    public Lolo(PositionInterface positionInterface)   {
        super("喽",positionInterface, ImagesSet.LoloImage);
        hp= Settings.getInstance().getHP_OF_LOLO();
        damage=Settings.getInstance().getDMG_OF_LOLO();
    }

}
