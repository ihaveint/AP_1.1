package menus;

import resources.ImageLoader;

import java.awt.*;

public class PlayerMenu extends FullSizePanel{
    private static PlayerMenu ourInstance = new PlayerMenu();

    public static PlayerMenu getInstance() {
        return ourInstance;
    }

    private PlayerMenu() {
        super();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(ImageLoader.getImage("BackGround"),0,0,null);
        g.drawImage(ImageLoader.getImage("LogoName"),Toolkit.getDefaultToolkit().getScreenSize().width/2 - ImageLoader.getImage("LogoName").getWidth(null)/2,0,null);

    }
}
