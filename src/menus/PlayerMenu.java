package menus;

import Listener.GameKeyListener;
import Listener.GameMouseMotionListener;
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
        setCursor(null);
        Button button1 = new Button();
        button1.setVisible(true);
        button1.setLocation(400,400);

        button1.setSize(resources.ImageLoader.getImage("OK").getWidth(null),resources.ImageLoader.getImage("OK").getHeight(null));
        button1.addActionListener(e -> {

            GameFrame.getInstance().setCurrentPanel("GamePanel");

            FullSizeFrame.hashMap.get("GamePanel").requestFocusInWindow();
//            FullSizeFrame.hashMap.get("GamePanel").addKeyListener(GameKeyListener.getInstance());
            GameFrame.getInstance().requestFocus();
//            GameFrame.getInstance().revalidate();


        });
        this.addMouseMotionListener(GameMouseMotionListener.getInstance());
        this.add(button1);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        g.drawImage(ImageLoader.getImage("BackGround"),0,0,null);
        g.drawImage(ImageLoader.getImage("LogoName"),Toolkit.getDefaultToolkit().getScreenSize().width/2 - ImageLoader.getImage("LogoName").getWidth(null)/2,0,null);
        g.drawImage(ImageLoader.getImage("Mouse"),GamePanel.mouseLocation.x-ImageLoader.getImage("Mouse").getWidth(null)/2,GamePanel.mouseLocation.y-ImageLoader.getImage("Mouse").getHeight(null)/2,null);

    }
}
