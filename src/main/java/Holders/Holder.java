package Holders;

import Position.PositionInterface;

import java.awt.*;

public class Holder {
    public Image getImage() {
        return image;
    }

    protected Image image;
    protected PositionInterface position;

    public Holder(Image image, PositionInterface position) {
        this.image = image;
        this.position = position;
        this.setPosition(position);
    }

    public void setPosition(PositionInterface position) {
        if (this.position != null)
            this.position.setHolder(null);// set the original position null
        this.position = position;
        position.setHolder(this);
    }

    public PositionInterface getPosition() {
        return this.position;
    }

}
