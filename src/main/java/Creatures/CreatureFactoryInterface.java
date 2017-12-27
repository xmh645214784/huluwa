package Creatures;

public interface CreatureFactoryInterface {
    public abstract <T extends Creature> T createCreature(Class<T> tClass);
}
