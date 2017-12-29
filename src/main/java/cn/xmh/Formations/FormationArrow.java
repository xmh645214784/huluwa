package cn.xmh.Formations;

import cn.xmh.Holders.Creatures.Creature;
import cn.xmh.Position.PositionInterface;
import cn.xmh.Position.TwoDimePositionSet;

import java.util.List;

public class FormationArrow implements FormationChanger {


    /**
     * @param startPos Formation start position.
     * @param toBeArrangeCreatures Creatures that need be arranged.
     */
    static public void changFormation(PositionInterface startPos, List<? extends Creature> toBeArrangeCreatures) {
        int count = 0;
        int i = startPos.getValue()[0];
        int j = startPos.getValue()[1];
        int originI=startPos.getValue()[0];
        
        for (Creature each : toBeArrangeCreatures) {
            each.setPosition(TwoDimePositionSet.getPositionInterface(i, j));
            count++;
            if (count == 1) {
                i--;
                j++;
            } else if (count == toBeArrangeCreatures.size() - 1) {
                i=originI;
                j++;
            } else {
                i++;
            }
        }
    }
}
