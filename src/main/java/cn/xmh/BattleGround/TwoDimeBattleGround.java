package cn.xmh.BattleGround;

import cn.xmh.Formations.FormationArrow;
import cn.xmh.Holders.Creatures.Bad.Lolo;
import cn.xmh.Holders.Creatures.Bad.Monster;
import cn.xmh.Holders.Creatures.Bad.Scorpion;
import cn.xmh.Holders.Creatures.Bad.Snake;
import cn.xmh.Holders.Creatures.Creature;
import cn.xmh.Holders.Creatures.CreatureFactory;
import cn.xmh.Holders.Creatures.Good.Good;
import cn.xmh.Holders.Creatures.Good.Huluwa;
import cn.xmh.Position.TwoDimePositionSet;
import cn.xmh.Settings.*;

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

        addCreatures(creatureFactory.createCreature(Snake.class, null));
        addCreatures(creatureFactory.createCreature(Scorpion.class, null));
        for (int i = 0; i < Settings.getInstance().getNR_LOLOS(); i++)
            addCreatures(creatureFactory.createCreature(Lolo.class, null));

        FormationArrow.changFormation(
                TwoDimePositionSet.getPositionInterface(5, 2), monsters
        );

    }

    protected void battle() {
        for (Creature creature : creatures) {
            creature.setThread(new Thread(creature));
            creature.getThread().start();
        }
    }

    @Override
    public synchronized void collisionDetection() {
        for (int i = 0; i < creatures.size(); i++)
            for (int j = i + 1; j < creatures.size(); j++) {
                if (creatures.get(i).getPosition().isNear(creatures.get(j).getPosition())) {
                    if (creatures.get(i) instanceof Good && creatures.get(j) instanceof Good) {
                        continue;
                    } else if (creatures.get(i) instanceof Monster && creatures.get(j) instanceof Monster) {
                        continue;
                    } else {//Battle
                        Creature monster = creatures.get(i) instanceof Monster ? creatures.get(i) : creatures.get(j);
                        monster.Die();
                    }
                }
            }
    }

}
