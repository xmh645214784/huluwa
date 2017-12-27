package Creatures;

public class CreatureFactory implements CreatureFactoryInterface {
    public <T extends Creature> T createCreature(Class<T> tClass) {
        try
        {
           T res;
           
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
