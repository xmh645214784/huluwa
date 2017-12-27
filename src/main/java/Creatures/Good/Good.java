package Creatures.Good;

import Creatures.Creature;
import Position.PositionInterface;

import javax.swing.*;
import java.awt.*;

public abstract class Good extends Creature {
    Good(String name, PositionInterface position,Image image) {
        super(name, position,image);
    }
}
