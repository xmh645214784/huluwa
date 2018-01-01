package cn.xmh.holders.creatures;

import cn.xmh.holders.creatures.bad.Lolo;
import cn.xmh.holders.creatures.bad.Scorpion;
import cn.xmh.holders.creatures.bad.Snake;
import cn.xmh.holders.creatures.good.Grandpa;
import cn.xmh.holders.creatures.good.Huluwa;
import cn.xmh.position.PositionInterface;

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