package Holders;

import Position.PositionInterface;
import Settings.ImagesSet;

import java.awt.*;

public class Land extends  Holder {
    public Land(PositionInterface position) {
        super(ImagesSet.GroundImage, position);
    }
}
