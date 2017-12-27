package BattleGround;

import Creatures.CreatureFactory;
import Creatures.Good.Huluwa;
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
            addCreatures(creatureFactory.createCreature(Huluwa.class, positionInterfaces.get(i * Settings.WIDTH)));
    }

    protected void initPositions() {
        for (int i = 0; i < Settings.WIDTH; i++) {
            for (int j = 0; j < Settings.HEIGHT; j++) {
                positionInterfaces.add(new TwoDimePosition(i, j, null));
            }
        }
    }

    public void battle() {

    }
}
