package cn.xmh.holders.creatures;

import cn.xmh.battleGround.BattleGround;
import cn.xmh.battleGround.TwoDimeBattleGround;
import cn.xmh.holders.creatures.bad.Monster;
import cn.xmh.holders.creatures.good.Good;
import cn.xmh.holders.Holder;
import cn.xmh.position.PositionInterface;
import cn.xmh.position.TwoDimePositionSet;
import cn.xmh.view.MainView;

import java.awt.*;

abstract public class Creature extends Holder implements Runnable {

    protected int hp = 0;

    protected int damage = 0;

    private Thread thread;

    protected String mName;


    public String getmName() {
        return mName;
    }

    protected Creature(String name, PositionInterface position, Image image) {
        super(image, position);
    }


    public void report() {
        System.out.println(this.toString() + "@" + this.position.toString());
    }


    public void setPosition(PositionInterface position) {
        if (this.position != null)
            this.position.setHolder(null);// set the original position null
        this.position = position;
        position.setHolder(this);
    }


    @Override
    public String toString() {
        return mName;
    }

    abstract public void run();

    public void Die() {
        hp = 0;
        this.getPosition().setHolder(null);
        MainView.getmInstance().addStringInTextBox(this.getClass().getSimpleName()+" died in "+this.getPosition());
        BattleGround.getCreatures().remove(this);
        if (this instanceof Good) {
            synchronized (BattleGround.getGoods()) {
                BattleGround.getGoods().remove(this);
                if (BattleGround.getGoods().size() == 0) {
                    BattleGround.gameIsEnd = true;
                    MainView.getmInstance().addStringInTextBox("Game ending");
                }
            }

        } else if (this instanceof Monster) {
            synchronized (BattleGround.getMonsters()) {
                BattleGround.getMonsters().remove(this);
                if (BattleGround.getMonsters().size() == 0) {
                    BattleGround.gameIsEnd = true;
                    MainView.getmInstance().addStringInTextBox("Game ending");
                }
            }
        } else
            assert false;
        this.getThread().stop();
    }


    public synchronized boolean moveoffset(int offsetx, int offsety) {
        PositionInterface oldPostion = this.getPosition();
        int[] nowPos = oldPostion.getValue();

        nowPos[0] += offsetx;
        nowPos[1] += offsety;
        PositionInterface newpos = TwoDimePositionSet.getPositionInterface(nowPos[0], nowPos[1]);
        if (newpos != null && newpos.getHolder() == null) {
            this.setPosition(newpos);
            TwoDimeBattleGround.getInstance().collisionDetection();
            //TODO save
            return true;
        }
        return false;

    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public Thread getThread() {

        return thread;
    }

    public int getDamage() {
        return damage;
    }

    public void checkIfDie(){
        if(hp<=0)
            Die();
    }

}