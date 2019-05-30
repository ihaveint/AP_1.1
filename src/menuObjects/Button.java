package menuObjects;

import Listener.GameMouseMotionListener;
import menus.GamePanel;
import resources.ImageLoader;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    public Button(){
        setCursor(null);
        this.setBorder(null);
        this.addMouseMotionListener(GameMouseMotionListener.getInstance());
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        g.setColor(Color.CYAN);
//        g.fillRoundRect(400,400,200,200,60,60);

        float alpha = (float)0.6 ;//draw half transparent
        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(ac);

        g2d.drawImage(resources.ImageLoader.getImage("OK"),0,0,null);
//        g.drawImage(ImageLoader.getImage("Mouse"), GamePanel.mouseLocation.x-ImageLoader.getImage("Mouse").getWidth(null)/2,GamePanel.mouseLocation.y-ImageLoader.getImage("Mouse").getHeight(null)/2,null);

    }
}
