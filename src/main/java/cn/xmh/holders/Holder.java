package cn.xmh.holders;

import cn.xmh.position.PositionInterface;

import java.awt.*;

public class Holder{
    public Image getImage() {
        return image;
    }

    protected Image image;
    protected PositionInterface position;

    public Holder(Image image, PositionInterface position) {
        this.image = image;
        this.position = position;
        if(position!=null)
            position.setHolder(this);
    }

    public PositionInterface getPosition() {
        return this.position;
    }

}
