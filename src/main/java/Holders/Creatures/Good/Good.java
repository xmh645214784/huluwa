package Holders.Creatures.Good;

import Holders.Creatures.Creature;
import Position.PositionInterface;

import java.awt.*;

public abstract class Good extends Creature {
    Good(String name, PositionInterface position,Image image) {
        super(name, position,image);
    }
}
