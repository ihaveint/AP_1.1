package menus;

import menuObjects.Button;
import resources.ImageLoader;

import java.awt.*;

public class PlayerMenu extends FullSizePanel{
    private static PlayerMenu ourInstance = new PlayerMenu();

    public static PlayerMenu getInstance() {
        return ourInstance;
    }

    private PlayerMenu() {
        super();
        Button button1 = new Button();
        button1.setVisible(true);
        button1.setLocation(400,400);

        button1.setSize(resources.ImageLoader.getImage("OK").getWidth(null),resources.ImageLoader.getImage("OK").getHeight(null));

        this.add(button1);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(ImageLoader.getImage("BackGround"),0,0,null);
        g.drawImage(ImageLoader.getImage("LogoName"),Toolkit.getDefaultToolkit().getScreenSize().width/2 - ImageLoader.getImage("LogoName").getWidth(null)/2,0,null);

    }
}
