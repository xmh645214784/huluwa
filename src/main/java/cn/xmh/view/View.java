package cn.xmh.view;

import cn.xmh.position.PositionInterface;

import java.awt.*;
import java.util.List;

public interface View {
    void show(Graphics graphics, List<PositionInterface> positionInterfaces);
}
