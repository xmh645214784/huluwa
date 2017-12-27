package View;

import Position.PositionInterface;
import java.util.*;
import java.awt.*;
import java.util.List;

public interface View {
    void show(Graphics graphics, List<PositionInterface> positionInterfaces);
}
