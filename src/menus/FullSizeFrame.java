package menus;

import resources.GlobalHashMap;
import resources.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class FullSizeFrame extends JFrame{
    static JPanel currentPanel;

    public FullSizeFrame() {
        this.setLayout(null);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    public static  void setCurrentPanel(String name){
        if (currentPanel != null)
            currentPanel.setVisible(false);
        currentPanel = GlobalHashMap.getInstance().panelHashMap.get(name);

        currentPanel.setVisible(true);
        currentPanel.requestFocus();


    }
}
