package View;

import Position.PositionInterface;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel implements View {
    public Board() {
    }

    public void show(PositionInterface[] positionInterfaces) {

    }

    @Override
    public void paint (Graphics g){
        super.paint(g);
        show();
    }

}
