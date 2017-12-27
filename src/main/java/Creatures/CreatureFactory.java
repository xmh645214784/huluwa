package Creatures;

import Creatures.Bad.Lolo;
import Creatures.Bad.Scorpion;
import Creatures.Bad.Snake;
import Creatures.Good.Grandpa;
import Creatures.Good.Huluwa;
import Position.PositionInterface;

public class CreatureFactory implements CreatureFactoryInterface {

    public <T extends Creature> T createCreature(Class<T> tClass, PositionInterface positionInterface) {
        if (tClass.equals(Huluwa.class)) {
            return (T) new Huluwa(positionInterface);
        } else if (tClass.equals(Grandpa.class)) {
            return (T) Grandpa.getInstance(positionInterface);
        } else if (tClass.equals(Snake.class)) {
            return (T) Snake.getInstance(positionInterface);
        } else if (tClass.equals(Scorpion.class)) {
            return (T) Scorpion.getInstance(positionInterface);
        } else if (tClass.equals(Lolo.class)) {
            return (T) new Lolo(positionInterface);
        } else {
                throw new RuntimeException("Unknown Creature Type");
        }
    }
}