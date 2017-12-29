package cn.xmh.Formations;

import cn.xmh.Holders.Creatures.Creature;
import cn.xmh.Position.PositionInterface;
import cn.xmh.Position.TwoDimePositionSet;

import java.util.List;

public class FormationHengE implements FormationChanger {
    static public void changFormation(PositionInterface startPos,List<?extends Creature> toBeArrangeCreatures) {
        int i=startPos.getValue()[0];
        int j=startPos.getValue()[1];
        for (Creature each:toBeArrangeCreatures)
        {
            each.setPosition(TwoDimePositionSet.getPositionInterface(j+(i+1)%2,i));
            i++;
        }
    }
}
