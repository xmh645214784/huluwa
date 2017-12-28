package BattleGround;

import Holders.Creatures.Creature;
import Holders.Holder;
import Position.PositionInterface;
import Position.TwoDimePositionSet;
import Settings.Settings;

import java.util.ArrayList;
import java.util.List;

abstract public class BattleGround {
    static protected List<PositionInterface> positionInterfaces= TwoDimePositionSet.getPositionInterfaces();
    static protected List<Creature> creatures=new ArrayList<Creature>();


    static public List<PositionInterface> getPositionInterfaces() {
        return positionInterfaces;
    }
    static public List<Creature> getCreatures() {
        return creatures;
    }

    public void addCreatures(Creature ... creatures) {
        for(Creature each:creatures)
            this.creatures.add(each);
    }

    public boolean deleteCreature(Creature target) {
        return creatures.remove(target);
    }

    public Holder getHolderInPosition (PositionInterface pos){
        return pos.getHolder();
    }

    protected abstract void initPositions();

    //the battle processing
    protected abstract void battle();

}
