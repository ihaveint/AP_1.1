package menus;

import Animations.Resume.Resume;
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
    public static Resume resumeAnimation = new Resume();
    public SpaceShip spaceShip = new SpaceShip();
    public static ArrayList<SampleBird> sampleBirds = new ArrayList<>();
    public static GamePanel ourInstance = new GamePanel();

    public static GamePanel getInstance() {
        return ourInstance;
    }

    public GamePanel(){
        super();

        sampleBirds.add(new SampleBird(0,100));

        sampleBirds.add(new SampleBird(600,300));
        spaceShipWidth = ImageLoader.getImage("SpaceShip").getWidth(null);
        spaceShipHeight = ImageLoader.getImage("SpaceShip").getHeight(null);
        shootWidth = ImageLoader.getImage("RedBullet").getWidth(null);
        shootHeight = ImageLoader.getImage("RedBullet").getHeight(null);
//        this.addMouseMotionListener(GameMouseMotionListener.getInstance());
//        this.addKeyListener(GameKeyListener.getInstance());
//        this.addMouseListener(GameMouseListener.getInstance());
    }

    public static void pause() {
        paused = true;
    }

    public static void switchState() {
        if (paused) {
            paused = false;
            resumeAnimation.currentPercentage = 0;
            SpaceShip.showResume = true;
        }
        else paused = true;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        MovingBackGround.getInstance().draw(g,paused);


        for (shoot tir : shoots){

            tir.checkBarkhord();
        }
        for (shoot tir : shoots){

            tir.draw(g);

        }

        int missileWidth , missileHeight;
        missileWidth = ImageLoader.getImage("missile").getWidth(null);
        missileHeight = ImageLoader.getImage("missile").getHeight(null);

        for (Missile missile : missiles){
            if (missile.visible)
                g.drawImage(ImageLoader.getImage("missile"),missile.x-missileWidth/2,missile.y - missileHeight/2 , null);
        }


        for (SampleBird sampleBird : sampleBirds){
            sampleBird.draw(g);
        }

        spaceShip.draw(g);
        if (SpaceShip.showResume) {
            resumeAnimation.draw(g);
            resumeAnimation.update();
        }
        for (shoot tir : shoots){
            tir.update(paused||spaceShip.showResume);

        }

        for (Missile missile : missiles){
            missile.update(paused||spaceShip.showResume);
        }
        spaceShip.update();
        for (SampleBird sampleBird : sampleBirds){
            sampleBird.update(paused || spaceShip.showResume);
        }


        if (paused){
            PauseFrame.getInstance().draw(g);
        }




    }
}
