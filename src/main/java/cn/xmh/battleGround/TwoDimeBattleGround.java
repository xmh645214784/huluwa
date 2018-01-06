package cn.xmh.battleGround;

import cn.xmh.formations.FormationArrow;
import cn.xmh.holders.Mountain;
import cn.xmh.holders.Tree;
import cn.xmh.holders.creatures.bad.Lolo;
import cn.xmh.holders.creatures.bad.Scorpion;
import cn.xmh.holders.creatures.bad.Snake;
import cn.xmh.holders.creatures.Creature;
import cn.xmh.holders.creatures.CreatureFactory;
import cn.xmh.holders.creatures.good.Grandpa;
import cn.xmh.holders.creatures.good.Huluwa;
import cn.xmh.position.PositionInterface;
import cn.xmh.position.TwoDimePositionSet;
import cn.xmh.recorder.ScreenRecorder;
import cn.xmh.settings.Settings;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

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
        addCreatures(creatureFactory.createCreature(Grandpa.class, positionInterfaces.get(7 * Settings.getInstance().getNRX())));
        addCreatures(creatureFactory.createCreature(Snake.class, null));
        addCreatures(creatureFactory.createCreature(Scorpion.class, null));
        for (int i = 0; i < Settings.getInstance().getNR_LOLOS(); i++)
            addCreatures(creatureFactory.createCreature(Lolo.class, null));

        FormationArrow.changFormation(
                TwoDimePositionSet.getPositionInterface(5, 2), monsters
        );

        for (int i = 0; i < 5; i++) {
            Random random=new Random();
            PositionInterface temp=TwoDimePositionSet.getPositionInterface(random.nextInt(Settings.getInstance().getNRX()),random.nextInt(Settings.getInstance().getNRY()));
            if(temp.getHolder()==null)
                new Mountain(temp);
        }
        for (int i = 0; i < 6; i++) {
            Random random=new Random();
            PositionInterface temp=TwoDimePositionSet.getPositionInterface(random.nextInt(Settings.getInstance().getNRX()),random.nextInt(Settings.getInstance().getNRY()));
            if(temp.getHolder()==null)
                new Tree(temp);
        }
    }

    protected void battle() {
        Executor executor= Executors.newFixedThreadPool(20);
        for (Creature creature : creatures) {
            creature.setThread(new Thread(creature));
            executor.execute(creature.getThread());

        }
    }

    public void notifyAllCreatures(){
        for (Creature creature : creatures){
            synchronized (creature) {
                creature.notifyAll();
            }
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
