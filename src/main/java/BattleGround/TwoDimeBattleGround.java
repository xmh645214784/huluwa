package BattleGround;

import Holders.Creatures.CreatureFactory;
import Holders.Creatures.Good.Huluwa;
import Holders.Land;
import Position.PositionInterface;
import Position.TwoDimePosition;
import Settings.*;

public class TwoDimeBattleGround extends BattleGround {
    private static TwoDimeBattleGround ourInstance = new TwoDimeBattleGround();

    public static TwoDimeBattleGround getInstance() {
        return ourInstance;
    }

    private TwoDimeBattleGround() {
        initPositions();
        initCreature();
    }


    private void initCreature() {
        CreatureFactory creatureFactory = new CreatureFactory();
        for (int i = 0; i < 7; i++)
            addCreatures(creatureFactory.createCreature(Huluwa.class, positionInterfaces.get(i * Settings.getInstance().getNRX())));
    }

    protected void initPositions() {
        for (int i = 0; i < Settings.getInstance().getNRX(); i++) {
            for (int j = 0; j < Settings.getInstance().getNRY(); j++) {
                PositionInterface positionInterface=new TwoDimePosition(i,j,null);
                Land land=new Land(positionInterface);
                positionInterface.setHolder(land);
                positionInterfaces.add(positionInterface);
            }
        }
    }

    public void battle() {

    }
}
