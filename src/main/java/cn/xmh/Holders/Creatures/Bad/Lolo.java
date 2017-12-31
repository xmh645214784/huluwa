package cn.xmh.Holders.Creatures.Bad;/*
* @author Minhui Xie
* @date 24,10,2017
* @time 19:20
*/

import cn.xmh.BattleGround.BattleGround;
import cn.xmh.Position.PositionInterface;
import cn.xmh.Settings.ImagesSet;
import cn.xmh.Settings.Settings;

public class Lolo extends Monster  {
    public Lolo(PositionInterface positionInterface)   {
        super("喽",positionInterface, ImagesSet.LoloImage);
        hp= Settings.getInstance().getHP_OF_LOLO();
        damage=Settings.getInstance().getDMG_OF_LOLO();
    }

}
