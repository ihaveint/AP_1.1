package menus;

import resources.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class FullSizeFrame extends JFrame{

    static HashMap<String, JPanel> hashMap = new HashMap<>();

//    static FullSizeFrame ourInstance = new FullSizeFrame();

//    public static FullSizeFrame getInstance() {
//        return ourInstance;
//    }

    static JPanel currentPanel;

    public FullSizeFrame() {
        hashMap.put("FullSizePanel",new FullSizePanel());
        hashMap.put("PlayerMenu",PlayerMenu.getInstance());
//        hashMap.put("GamePanel",GamePanel.getInstance());
//        this.getContentPane().add(hashMap.get("GamePanel"));
        this.setLayout(null);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    public static  void setCurrentPanel(String name){
        if (currentPanel != null)
            currentPanel.setVisible(false);
        currentPanel = hashMap.get(name);
//        hashMap.get(name).requestFocusInWindow();
        currentPanel.setVisible(true);


    }
}
