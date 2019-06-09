package Levels;

import gameObjects.*;
import menus.GamePanel;

import java.awt.*;
import java.util.ArrayList;

public class Level implements Drawable {
    public Level nextLevel = null;
    String displayName ;
    int levelId;
    static int levelCounter = 0;
    static ArrayList<Level> levelsInstances = new ArrayList<>();
    public ArrayList<PowerUps> powerUps = new ArrayList<>();
    public ArrayList<SampleBird>  sampleBirds = new ArrayList<>();
    public ArrayList<Bird> final_birds = new ArrayList<>();
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


        for (SampleBird sampleBird : sampleBirds){
            sampleBird.draw(g);
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



        for (SampleBird sampleBird : sampleBirds){
            sampleBird.update(GamePanel.paused || GamePanel.getInstance().spaceShip.showResume);
        }




        ArrayList<SampleBird> sampleBirdAfter = new ArrayList<>();
        ArrayList<Bird> finalBirdsAfter =  new ArrayList<>();
        for (int i = 0 ; i < sampleBirds.size() ; i ++) {
            SampleBird sampleBird = sampleBirds.get(i);
            if ((System.currentTimeMillis() - sampleBird.shakeStartTime > sampleBird.shakeTime) && sampleBird.died) {
                continue;
            }
            else{
                sampleBirdAfter.add(sampleBird);
            }
        }
        sampleBirds = sampleBirdAfter;


        for (int i = 0 ; i < final_birds.size() ; i ++) {
            Bird sampleBird = final_birds.get(i);
            if ((System.currentTimeMillis() - sampleBird.shakeStartTime > sampleBird.shakeTime) && sampleBird.died) {
                continue;

            }
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
        for (SampleBird sampleBird : sampleBirds){
            if (sampleBird.died == false && sampleBird.isInScreen()) {
                return false;
            }
        }
        for (Bird bird : final_birds){

            if (bird.died == false) {
                return false;
            }
        }
        return true;
    }
}
