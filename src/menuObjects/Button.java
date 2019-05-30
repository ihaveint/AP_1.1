package menuObjects;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    public Button(){
//        this.setBorder(null);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawRoundRect(400,400,200,200,40,40);

    }
}
