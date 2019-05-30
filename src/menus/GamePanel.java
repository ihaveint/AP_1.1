package menus;

import Listener.GameKeyListener;
import Listener.GameMouseListener;
import Listener.GameMouseMotionListener;
import gameObjects.Missile;
import gameObjects.SpaceShip;
import gameObjects.shoot;
import resources.ImageLoader;
import resources.Location;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends FullSizePanel {
    public static ArrayList<shoot> shoots = new ArrayList<shoot>();
    public static ArrayList<Missile> missiles = new ArrayList<>();
    public static Location mouseLocation = new Location(700,700);
    public int spaceShipWidth , spaceShipHeight;
    public int shootWidth , shootHeight;
    SpaceShip spaceShip = new SpaceShip();

    public static GamePanel ourInstance = new GamePanel();

    public static GamePanel getInstance() {
        return ourInstance;
    }

    public GamePanel(){

        spaceShipWidth = ImageLoader.getImage("SpaceShip").getWidth(null);
        spaceShipHeight = ImageLoader.getImage("SpaceShip").getHeight(null);
        shootWidth = ImageLoader.getImage("RedBullet").getWidth(null);
        shootHeight = ImageLoader.getImage("RedBullet").getHeight(null);
        this.addMouseMotionListener(GameMouseMotionListener.getInstance());
        this.addKeyListener(GameKeyListener.getInstance());
        this.addMouseListener(GameMouseListener.getInstance());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(ImageLoader.getImage("BackGround"),0,0,null);

        System.out.println(shoots.size());

        for (shoot tir : shoots){
            tir.draw(g);
//            g.drawImage(ImageLoader.getImage("RedBullet"),tir.x-shootWidth/2,tir.y-shootHeight/2,null);
            tir.update();
        }

        int missileWidth , missileHeight;
        missileWidth = ImageLoader.getImage("missile").getWidth(null);
        missileHeight = ImageLoader.getImage("missile").getHeight(null);

        for (Missile missile : missiles){
            g.drawImage(ImageLoader.getImage("missile"),missile.x-missileWidth/2,missile.y - missileHeight/2 , null);
            missile.update();
        }
        spaceShip.draw(g);
//        g.drawImage(ImageLoader.getImage("SpaceShip"),mouseLocation.x - spaceShipWidth/2,mouseLocation.y - spaceShipHeight/2,null);

//        g.drawImage(ImageLoader.getImage("Mouse"),mouseLocation.x,mouseLocation.y,null);

    }
}
