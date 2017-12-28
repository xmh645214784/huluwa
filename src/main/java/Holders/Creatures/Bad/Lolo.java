package Holders.Creatures.Bad;/*
* @author Minhui Xie
* @date 24,10,2017
* @time 19:20
*/

import BattleGround.BattleGround;
import Position.PositionInterface;
import Settings.ImagesSet;

public class Lolo extends Monster  {
    public Lolo(PositionInterface positionInterface)   {
        super("喽",positionInterface, ImagesSet.LoloImage);
    }

    @Override
    public void run(){
        if(BattleGround.gameIsPaused)
            return;
        ;//小人物，哪那么多屁话
    }
}
