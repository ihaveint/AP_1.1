package menus;

import Animations.Resume.Resume;
import Animations.explosions.small_explosion;
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
    public boolean running = false;
    public static boolean paused = false;
    public static ArrayList<shoot> shoots = new ArrayList<shoot>();
    public static ArrayList<Missile> missiles = new ArrayList<>();
//    public static Location mouseLocation = new Location(700,700);
    public int spaceShipWidth , spaceShipHeight;
    public int shootWidth , shootHeight;
    public static Resume resumeAnimation = new Resume();
    public SpaceShip spaceShip = new SpaceShip();
    public static ArrayList<SampleBird> sampleBirds = new ArrayList<>();
    public static ArrayList<small_explosion> small_explosions = new ArrayList<>();
    public static ArrayList<Bird> final_birds = new ArrayList<>();

    public static GamePanel ourInstance = new GamePanel();

    public static GamePanel getInstance() {
        return ourInstance;
    }

    public static void reset() {
        for (SampleBird sampleBird : sampleBirds){
            sampleBird.hp.increasing = false;
            sampleBird.hp.decreasing = false;
            sampleBird.hp.drawPercentage = 0;
        }
    }

    public void add_explosion(int x , int y){
        small_explosions.add(new small_explosion(x,y));

    }
//    RandomBird test;
    public GamePanel(){
        super();

        final_birds.add(new MorgheEntehari());
        final_birds.add(new MorgheEntehari());
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

    public static synchronized void removeBird(int id) {
        for (int ptr = 0 ; ptr < sampleBirds.size() ; ptr ++){
            if (sampleBirds.get(ptr).id == id){
                sampleBirds.remove(ptr);
                break;
            }
        }

    }

    public static void drawHeat(int i , Graphics g) {
        g.drawImage(ImageLoader.getImage("heat" +i),0,0,400,400,null);
    }


    public static boolean delayHeat = false;
    long startDelay = -5000;
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        MovingBackGround.getInstance().draw(g,paused);
        g.drawImage(ImageLoader.getImage("upper_left"),0,0,400,400,null);

        spaceShip.currentHeat = Math.min(spaceShip.currentHeat,100);
        if (spaceShip.currentHeat == 100){
            delayHeat = true;
            startDelay = System.currentTimeMillis();
        }
        if (spaceShip.currentHeat < 0) {
            spaceShip.currentHeat = 0;
        }
        if (delayHeat && System.currentTimeMillis() - startDelay > 5000){
            delayHeat = false;

        }
//        if (!delayHeat) {
            drawHeat((int) (spaceShip.currentHeat / 100 * 16), g);
//        }



        for (small_explosion small_explosion : small_explosions){
            small_explosion.draw(g);
        }
        ArrayList<shoot> currentShoots = new ArrayList<>();
        for (shoot shoot : shoots){
            currentShoots.add(shoot);
        }
        for (shoot tir : currentShoots){

            tir.checkBarkhord();
        }
        for (shoot tir : currentShoots){

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

//        test.draw(g);
        for (Bird bird : final_birds){
            bird.draw(g);
        }
        spaceShip.draw(g);

        if (SpaceShip.showResume) {
            resumeAnimation.draw(g);
            resumeAnimation.update();
        }
        for (shoot tir : currentShoots){
            tir.update(paused||spaceShip.showResume);

        }

        for (Missile missile : missiles){
            missile.update(paused||spaceShip.showResume);
        }
        spaceShip.update(paused);
        for (SampleBird sampleBird : sampleBirds){
            sampleBird.update(paused || spaceShip.showResume);
        }



        for (int i = 0 ; i < sampleBirds.size() ; i ++) {
            SampleBird sampleBird = sampleBirds.get(i);
                if ((System.currentTimeMillis() - sampleBird.shakeStartTime > sampleBird.shakeTime) && sampleBird.died) {
                    GamePanel.removeBird(sampleBird.id);
                    i --;

                }
        }

        ArrayList<shoot> tirReplacement = new ArrayList<>();
        for (shoot tir : shoots){
            if (tir.y >= -50){
                tirReplacement.add(tir);
            }

        }
        shoots = tirReplacement;



//        test.update();
        for (Bird bird : final_birds){
            bird.update();
        }
        if (paused){
            PauseFrame.getInstance().draw(g);
            running = false;
        }


        SpaceShip.currentHeat -= 0.7;



    }
}
