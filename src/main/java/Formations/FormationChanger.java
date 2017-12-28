package Formations;

import Holders.Creatures.Creature;
import Position.PositionInterface;

import java.util.List;

public interface FormationChanger {
    static void changFormation(PositionInterface startPos, List<?extends Creature> toBeArrangeCreatures)
    {
        throw new UnsupportedOperationException("Can't come here");
    }
}
