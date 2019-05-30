package menus;

import javax.swing.*;
import java.awt.*;

public class FullSizePanel extends Panel {
    public FullSizePanel(){
//        new FullSizePanel(true);

        this.setLayout(null);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setVisible(true);
        this.setFocusable(true);


    }
    /*
    public FullSizePanel(boolean visible){
        this.setLayout(null);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setVisible(visible);
    }*/

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
