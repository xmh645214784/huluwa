package BattleGround;

import Formations.FormationArrow;
import Formations.FormationHeyi;
import Holders.Creatures.Bad.Lolo;
import Holders.Creatures.Bad.Scorpion;
import Holders.Creatures.Bad.Snake;
import Holders.Creatures.Creature;
import Holders.Creatures.CreatureFactory;
import Holders.Creatures.Good.Huluwa;
import Holders.Mountain;
import Position.PositionInterface;
import Position.TwoDimePosition;
import Position.TwoDimePositionSet;
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

        addCreatures(creatureFactory.createCreature(Snake.class,null));
        addCreatures(creatureFactory.createCreature(Scorpion.class,null));
        for(int i=0;i<Settings.getInstance().getNR_LOLOS();i++)
            addCreatures(creatureFactory.createCreature(Lolo.class,null));

        FormationHeyi.changFormation(
                TwoDimePositionSet.getPositionInterface(10,5), monsters
        );

    }
    protected void battle() {
        for(Creature creature:creatures)
        {
            new Thread(creature).start();
        }
    }


}
