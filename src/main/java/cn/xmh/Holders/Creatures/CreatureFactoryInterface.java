package cn.xmh.Holders.Creatures;

import cn.xmh.Position.PositionInterface;

public interface CreatureFactoryInterface {
     <T extends Creature> T createCreature(Class<T> tClass, PositionInterface positionInterface);
}
