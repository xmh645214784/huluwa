package BattleGround;

import Holders.Creatures.Creature;
import Holders.Creatures.CreatureFactory;
import Holders.Creatures.Good.Huluwa;
import Holders.Mountain;
import Position.PositionInterface;
import Position.TwoDimePosition;
import Settings.*;

public class TwoDimeBattleGround extends BattleGround {
    private static TwoDimeBattleGround ourInstance = new TwoDimeBattleGround();

    public static TwoDimeBattleGround getInstance() {
        return ourInstance;
    }

    private TwoDimeBattleGround() {
        initCreature();
        battle();
    }


    private void initCreature() {
        CreatureFactory creatureFactory = new CreatureFactory();
        for (int i = 0; i < 7; i++)
            addCreatures(creatureFactory.createCreature(Huluwa.class, positionInterfaces.get(i * Settings.getInstance().getNRX())));
    }
    protected void battle() {
        for(Creature creature:creatures)
        {
            new Thread(creature).start();
        }
    }


}
