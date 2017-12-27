package Creatures;

import Position.PositionInterface;

public interface CreatureFactoryInterface {
    public abstract <T extends Creature> T createCreature(Class<T> tClass, PositionInterface positionInterface);
}
