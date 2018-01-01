package cn.xmh.formations;

import cn.xmh.holders.creatures.Creature;
import cn.xmh.position.PositionInterface;
import cn.xmh.position.TwoDimePositionSet;

import java.util.List;

public class FormationHeyi implements FormationChanger {
    static public void changFormation(PositionInterface startPos,List<?extends Creature> toBeArrangeCreatures) {
        int i=startPos.getValue()[0],j=startPos.getValue()[1];
        int count=0;
        for (Creature each:toBeArrangeCreatures)
        {
            each.setPosition(
                    TwoDimePositionSet.getPositionInterface(i,j));
            j++;
            if(count< toBeArrangeCreatures.size()/2)
                i--;
            else
                i++;
            count++;
        }
    }
}
