package gameObjects;

import Animations.BeCareFul.BeCareFul;
import menus.GamePanel;
import resources.ImageLoader;
import resources.Location;
import resources.RectLoader;

import static menus.GamePanel.*;


import java.awt.*;
import java.util.ArrayList;

public class SpaceShip implements Drawable{

    boolean showWarning = false;
    double warningPercent = 0;
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

        g.drawImage(ImageLoader.getImage("SpaceShip"),drawLocation.x,drawLocation.y,null);
        if (showWarning)
            test.draw(g);
    }
    public static Location getLocation(){
        return new Location(mouseLocation.x - GamePanel.getInstance().spaceShipWidth/2,mouseLocation.y - GamePanel.getInstance().spaceShipHeight/2);

    }

    public void update() {

        if (showWarning)
            test.update();

        if (hit(GamePanel.testBird)){
            if (!showWarning){
                test.currentPercentage = 0;
            }
            showWarning = true;
        }
        if (showWarning){
            warningPercent += 0.0025;
            if( warningPercent >= 1){
                warningPercent = 0;
                showWarning = false;
            }
        }

    }
    public boolean hit(SampleBird sampleBird){
        for (Rectangle rectangle : rectangles){
            if (sampleBird.hit(new Rectangle(rectangle.xmin + getLocation().x , rectangle.ymin + getLocation().y , rectangle.xmax + getLocation().x ,  rectangle.ymax + getLocation().y))) {
                return true;

            }
        }
        return false;
    }
}
