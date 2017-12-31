package cn.xmh.BattleGround;

import cn.xmh.Formations.FormationArrow;
import cn.xmh.Holders.Creatures.Bad.Lolo;
import cn.xmh.Holders.Creatures.Bad.Scorpion;
import cn.xmh.Holders.Creatures.Bad.Snake;
import cn.xmh.Holders.Creatures.Creature;
import cn.xmh.Holders.Creatures.CreatureFactory;
import cn.xmh.Holders.Creatures.Good.Huluwa;
import cn.xmh.Position.TwoDimePositionSet;
import cn.xmh.Settings.Settings;

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
        for (int i = 0; i < goods.size(); i++)
            for (int j = 0; j < monsters.size(); j++) {
                if (goods.get(i).getPosition().isNear(monsters.get(j).getPosition())) {
                    goods.get(i).setHp(goods.get(i).getHp() - monsters.get(j).getDamage());
                    monsters.get(j).setHp(monsters.get(j).getHp() - goods.get(i).getDamage());
                }
            }
        for (int i = 0; i < goods.size(); i++)
            goods.get(i).checkIfDie();
        for (int i = 0; i < monsters.size(); i++)
            monsters.get(i).checkIfDie();
    }
}
