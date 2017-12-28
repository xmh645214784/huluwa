package Holders;

import Position.PositionInterface;
import Settings.ImagesSet;

import java.awt.*;

public class Mountain extends  Holder {
    public Mountain(PositionInterface position) {
        //TODO alter this image to mountain image
        super(ImagesSet.GroundImage, position);
    }
}
