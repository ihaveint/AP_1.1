package menus;

import Listener.GameKeyListener;
import Listener.GameMouseListener;
import Listener.GameMouseMotionListener;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    public Panel(){
        this.addMouseMotionListener(GameMouseMotionListener.getInstance());
        this.addKeyListener(GameKeyListener.getInstance());
        this.addMouseListener(GameMouseListener.getInstance());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }
}
