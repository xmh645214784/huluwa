package cn.xmh.holders.creatures;

import cn.xmh.position.PositionInterface;

public interface CreatureFactoryInterface {
     <T extends Creature> T createCreature(Class<T> tClass, PositionInterface positionInterface);
}
