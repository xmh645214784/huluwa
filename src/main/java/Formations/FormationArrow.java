package Formations;

import Holders.Creatures.Creature;
import Position.PositionInterface;
import Position.TwoDimePositionSet;
import Settings.Settings;

public class FormationArrow implements FormationChanger{


    static public void changFormation(PositionInterface startPos, Creature... toBeArrangeCreatures) {
        int count=0;
//        int i=4,j=5;
        int i=startPos.getValue()[0];//4
        int j=startPos.getValue()[1];//5
        for (Creature each:toBeArrangeCreatures)
        {
            each.setPosition(TwoDimePositionSet.getPositionInterface(j,i));
            count++;
            if(count==1)
            {
                i++;
                j--;
            }
            else if(count==Settings.getInstance().getNR_LOLOS()-1)
            {
                i++;
                j=5;
            }
            else
            {
                j++;
            }
        }
    }
}
