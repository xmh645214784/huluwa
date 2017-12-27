package Common;

import Creatures.Creature;
import Position.PositionInterface;

public class BubbleSorter implements Sorter {
    public void sort(PositionInterface...positions) {
        Creature creature;

        for (int i = 0; i < positions.length - 1; i++) {
            for (int j = 0; j < positions.length - 1 - i; j++) {
                if (((Comparable) (positions[j].getHolder())).biggerThan((Comparable) (positions[j + 1].getHolder()))) {
                    creature = positions[j].getHolder();
                    positions[j + 1].getHolder().setPosition(positions[j]);
                    creature.setPosition(positions[j + 1]);
                }
            }
        }
    }
}
