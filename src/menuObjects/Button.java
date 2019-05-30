package menuObjects;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    public Button(){
        this.setBorder(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        g.setColor(Color.CYAN);
//        g.fillRoundRect(400,400,200,200,60,60);
        g.drawImage(resources.ImageLoader.getImage("OK"),0,0,null);

    }
}
