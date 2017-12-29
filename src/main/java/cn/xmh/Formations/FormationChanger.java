package cn.xmh.Formations;

import cn.xmh.Holders.Creatures.Creature;
import cn.xmh.Position.PositionInterface;

import java.util.List;

public interface FormationChanger {
    static void changFormation(PositionInterface startPos, List<?extends Creature> toBeArrangeCreatures)
    {
        throw new UnsupportedOperationException("Can't come here");
    }
}
