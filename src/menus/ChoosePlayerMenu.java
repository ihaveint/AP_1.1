package menus;

import Listener.GameMouseMotionListener;
import menuObjects.Button;
import resources.GlobalHashMap;
import resources.ImageLoader;
import resources.Location;

import java.awt.*;

public class ChoosePlayerMenu extends FullSizePanel{


    private static ChoosePlayerMenu ourInstance = new ChoosePlayerMenu();

    public static ChoosePlayerMenu getInstance() {
        return ourInstance;
    }

    private ChoosePlayerMenu() {
        super();
        setCursor(null);
        this.addMouseMotionListener(GameMouseMotionListener.getInstance());


        Button ok_button = new Button();
        ok_button.setLocation(400,400);
        ok_button.setSize(resources.ImageLoader.getImage("OK").getWidth(null),resources.ImageLoader.getImage("OK").getHeight(null));
        ok_button.setVisible(true);
        ok_button.repaint();
        ok_button.addActionListener(e -> {

            GameFrame.getInstance().setCurrentPanel("PlayerMenu");
//            GlobalHashMap.getInstance().panelHashMap.get("PlayerMenu").requestFocusInWindow();
            PlayerMenu.getInstance().requestFocus();
        });
        this.add(ok_button);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);



        g.drawImage(ImageLoader.getImage("choose_menu"),0,0,null);
        g.drawImage(ImageLoader.getImage("Mouse"),GamePanel.mouseLocation.x-ImageLoader.getImage("Mouse").getWidth(null)/2,GamePanel.mouseLocation.y-ImageLoader.getImage("Mouse").getHeight(null)/2,null);
    }
}
