package BattleGround;

import Creatures.Creature;
import Creatures.CreatureFactory;
import Position.PositionInterface;

import java.util.ArrayList;
import java.util.List;

abstract public class BattleGround {
    protected List<PositionInterface> positionInterfaces=new ArrayList<PositionInterface>();
    protected List<Creature> creatures=new ArrayList<Creature>();

    public List<PositionInterface> getPositionInterfaces() {
        return positionInterfaces;
    }
    public List<Creature> getCreatures() {
        return creatures;
    }

    public void addCreatures(Creature ... creatures) {
        for(Creature each:creatures)
            this.creatures.add(each);
    }

    public boolean deleteCreature(Creature target) {
        return creatures.remove(target);
    }

    public Creature getCreatureInPosition (PositionInterface pos){
        return pos.getHolder();
    }

    protected abstract void initPositions();

    //the battle processing
    public abstract void battle();
}
