package menus;

import javax.swing.*;
import java.awt.*;

public class FullSizePanel extends Panel {
    public FullSizePanel(){
        super();
        this.setLayout(null);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setVisible(true);
        this.setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
