package menus;

import Listener.GameMouseMotionListener;
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
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);



        g.drawImage(ImageLoader.getImage("choose_menu"),0,0,null);
        g.drawImage(ImageLoader.getImage("Mouse"),GamePanel.mouseLocation.x-ImageLoader.getImage("Mouse").getWidth(null)/2,GamePanel.mouseLocation.y-ImageLoader.getImage("Mouse").getHeight(null)/2,null);
    }
}
