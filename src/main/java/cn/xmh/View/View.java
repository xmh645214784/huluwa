package cn.xmh.View;

import cn.xmh.Position.PositionInterface;

import java.awt.*;
import java.util.List;

public interface View {
    void show(Graphics graphics, List<PositionInterface> positionInterfaces);
}
