package cn.xmh.Holders;

import cn.xmh.Position.PositionInterface;
import cn.xmh.Settings.ImagesSet;

public class Mountain extends  Holder {
    public Mountain(PositionInterface position) {
        //TODO alter this image to mountain image
        super(ImagesSet.GroundImage, position);
    }
}
