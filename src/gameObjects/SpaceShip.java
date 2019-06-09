package gameObjects;

import Animations.BeCareFul.BeCareFul;
import Listener.GameMouseMotionListener;
import menus.GamePanel;
import resources.ImageLoader;
import resources.Location;
import resources.RectLoader;

import static menus.GamePanel.*;


import java.awt.*;
import java.util.ArrayList;

public class SpaceShip implements Drawable{

    public static double currentHeat = 0;
    public static Location drawLocation = GameMouseMotionListener.mouseLocation;
    boolean showWarning = false;
    public static boolean showResume = false;
    public static double resumePerecnt = 0;
    public double warningPercent = 0;
    public BeCareFul test;
    ArrayList<Rectangle> rectangles = new ArrayList<>();
    public void loadBoxes(){
        rectangles = RectLoader.loadRectangles("src/GameObjects/SpaceShipBoxes.txt");
    }
    public SpaceShip() {
        test = new BeCareFul();
        loadBoxes();
    }
    @Override
    public void draw(Graphics g) {
        Location drawLocation = getLocation();

        g.drawImage(ImageLoader.getImage("SpaceShip"),(int)drawLocation.x,(int)drawLocation.y,null);
        if (showWarning)
            test.draw(g);
        if (showResume) {
            GamePanel.resumeAnimation.draw(g);
        }
    }
    public static Location getLocation(){
//        return new Location((int) GameMouseMotionListener.mouseLocation.x - GamePanel.getInstance().spaceShipWidth/2,(int)GameMouseMotionListener.mouseLocation.y - GamePanel.getInstance().spaceShipHeight/2);
            return new Location(drawLocation.x - GamePanel.getInstance().spaceShipWidth/2 , drawLocation.y - GamePanel.getInstance().spaceShipHeight/2);
    }

    public void update(boolean paused) {

        if (!paused){
            drawLocation = GameMouseMotionListener.mouseLocation;
        }
        if (showWarning)
            test.update();

        for (SampleBird sampleBird : GamePanel.getInstance().currentLevel.sampleBirds) {
            if (hit(sampleBird) && sampleBird.died == false){
                if (!showWarning){
                    test.currentPercentage = 0;
                    test.currentLayer = 1;
                }
                showWarning = true;
            }
        }
        for (Bird bird : GamePanel.final_birds){
            if (hitBird(bird) && bird.died == false){
                if (!showWarning){
                    test.currentPercentage = 0;
                    test.currentLayer = 1;
                }
                showWarning = true;
            }
        }
        if (showWarning){
            warningPercent += 0.0025;
            if( warningPercent >= 1){
                warningPercent = 0;
                showWarning = false;
            }
        }

        if (showResume){
            resumeAnimation.currentPercentage += 0.0012;
            if (resumeAnimation.currentPercentage >= 1){
                resumeAnimation.currentPercentage = 0;
                showResume = false;
            }
        }



    }

    private boolean hitBird(Bird bird) {
        if (showResume) return false;
        for (Rectangle rectangle : rectangles){
            if (bird.hit(new Rectangle(rectangle.xmin + (int)getLocation().x , rectangle.ymin +(int) getLocation().y , rectangle.xmax + (int)getLocation().x ,  rectangle.ymax + (int)getLocation().y))) {
                return true;

            }
        }
        return false;
    }

    public boolean hit(SampleBird sampleBird){
        if (showResume) return false;
        for (Rectangle rectangle : rectangles){
            if (sampleBird.hit(new Rectangle(rectangle.xmin + (int)getLocation().x , rectangle.ymin +(int) getLocation().y , rectangle.xmax + (int)getLocation().x ,  rectangle.ymax + (int)getLocation().y))) {
                return true;

            }
        }
        return false;
    }
}
