package cn.xmh.formations;

import cn.xmh.holders.creatures.Creature;
import cn.xmh.position.PositionInterface;

import java.util.List;

public interface FormationChanger {
    static void changFormation(PositionInterface startPos, List<?extends Creature> toBeArrangeCreatures)
    {
        throw new UnsupportedOperationException("Can't come here");
    }
}
