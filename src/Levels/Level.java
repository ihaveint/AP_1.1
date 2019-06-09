package Levels;

import RandomGenerator.RandomLocationGenerator;
import gameObjects.*;
import menus.GamePanel;
import resources.Location;

import java.awt.*;
import java.util.ArrayList;

public class Level implements Drawable {
    long powerUpCounter = 1000;
    public Level nextLevel = null;
    String displayName ;
    public int levelId;
    static int levelCounter = 0;
    static ArrayList<Level> levelsInstances = new ArrayList<>();
    public ArrayList<PowerUps> powerUps = new ArrayList<>();
    public ArrayList<Bird> final_birds = new ArrayList<>();
    long levelFinishedTime = -5000;
    boolean markFinished = false;
    public Level() {
        levelCounter++;
        levelId = levelCounter;

        displayName = "Level " + levelId;
        if (levelsInstances.size() > 0) {
            levelsInstances.get(levelsInstances.size() - 1).nextLevel = this;
        }
        levelsInstances.add(this);
    }





    @Override
    public void draw(Graphics g) {

        powerUpCounter -= 3;
        if (powerUpCounter <= 0){
            powerUpCounter =1000;
            Location randomLocation = RandomLocationGenerator.getRandomLocation();
            powerUps.add(new RedPowerUp((int)randomLocation.x,(int)randomLocation.y));
        }

        for (Bird bird : final_birds){
            bird.draw(g);
        }

        for (PowerUps powerUps  : powerUps){
            if (powerUps.visible){
                powerUps.draw(g);
                powerUps.update();
            }
        }




        ArrayList<Bird> finalBirdsAfter =  new ArrayList<>();

        for (int i = 0 ; i < final_birds.size() ; i ++) {
            Bird sampleBird = final_birds.get(i);
            if ((System.currentTimeMillis() - sampleBird.shakeStartTime > sampleBird.shakeTime) && sampleBird.died) {
                continue;

            }
            else if (sampleBird instanceof MorgheParish && !sampleBird.insideScreen()) continue;
            else{
                finalBirdsAfter.add(sampleBird);
            }
        }

        final_birds = finalBirdsAfter;




        for (Bird bird : final_birds){
            bird.update(GamePanel.paused || GamePanel.getInstance().spaceShip.showResume);
        }
    }
    public boolean levelFinished(){
        for (Bird bird : final_birds){

            if (bird.died == false) {
                return false;
            }
        }
        return true;
    }
}
