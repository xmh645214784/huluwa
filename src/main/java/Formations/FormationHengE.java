package Formations;

import Holders.Creatures.Creature;
import Position.PositionInterface;
import Position.TwoDimePositionSet;

public class FormationHengE implements FormationChanger {
    static public void changFormation(PositionInterface startPos, Creature... toBeArrangeCreatures) {
        int i=startPos.getValue()[0];
        int j=startPos.getValue()[1];
        for (Creature each:toBeArrangeCreatures)
        {
            each.setPosition(TwoDimePositionSet.getPositionInterface(j+(i+1)%2,i));
            i++;
        }
    }
}
