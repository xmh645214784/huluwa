package Creatures;/*
* @author Minhui Xie
* @date 24,10,2017
* @time 18:25
*/

import Position.PositionInterface;

public abstract class Monster extends Creature {
    Monster(String name, PositionInterface position)
    {
        super(name,position);
    }
}
