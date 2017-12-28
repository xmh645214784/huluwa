package Formations;

import Holders.Creatures.Creature;
import Position.PositionInterface;
import Position.TwoDimePositionSet;
import Settings.Settings;

import java.util.Set;

public class FormationHeyi implements FormationChanger {
    static public void changFormation(PositionInterface startPos, Creature... toBeArrangeCreatures) {
        int i=startPos.getValue()[0],j=startPos.getValue()[1];
        for (Creature each:toBeArrangeCreatures)
        {
            each.setPosition(
                    TwoDimePositionSet.getPositionInterface(j,i+3));
            i++;
            if(i<= Settings.getInstance().getNR_LOLOS()/2)
                j--;
            else
                j++;
        }
    }
}
