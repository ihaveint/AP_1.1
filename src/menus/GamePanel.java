package menus;

import Listener.GameKeyListener;
import Listener.GameMouseListener;
import Listener.GameMouseMotionListener;
import gameObjects.*;
import resources.ImageLoader;
import resources.Location;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends FullSizePanel {
    public static boolean paused = false;
    public static ArrayList<shoot> shoots = new ArrayList<shoot>();
    public static ArrayList<Missile> missiles = new ArrayList<>();
    public static Location mouseLocation = new Location(700,700);
    public int spaceShipWidth , spaceShipHeight;
    public int shootWidth , shootHeight;
    SpaceShip spaceShip = new SpaceShip();
    public static SampleBird testBird = new SampleBird(0,100);

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

    public static void pause() {
        paused = true;
    }

    public static void switchState() {
        if (paused) paused = false;
        else paused = true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        MovingBackGround.getInstance().draw(g,paused);
//        if (paused) return ;

        for (shoot tir : shoots){
            tir.checkBarkhord();
        }
        for (shoot tir : shoots){
            tir.update(paused);
            tir.draw(g);

        }

        int missileWidth , missileHeight;
        missileWidth = ImageLoader.getImage("missile").getWidth(null);
        missileHeight = ImageLoader.getImage("missile").getHeight(null);

        for (Missile missile : missiles){
            if (missile.visible)
                g.drawImage(ImageLoader.getImage("missile"),missile.x-missileWidth/2,missile.y - missileHeight/2 , null);
            missile.update(paused);
        }

        spaceShip.draw(g);
        spaceShip.update();
        testBird.update(paused);
        testBird.draw(g);




    }
}
