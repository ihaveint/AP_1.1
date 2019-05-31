package gameObjects;

import Animations.BeCareFul.BeCareFul;
import menus.GamePanel;
import resources.ImageLoader;
import resources.Location;

import static menus.GamePanel.*;


import java.awt.*;

public class SpaceShip implements Drawable{

    BeCareFul test;
    public SpaceShip(){
        test = new BeCareFul();
    }
    @Override
    public void draw(Graphics g) {
        Location drawLocation = getLocation();
//        if (test.currentLayer <= 11 ) {

//        }

        g.drawImage(ImageLoader.getImage("SpaceShip"),drawLocation.x,drawLocation.y,null);
        test.draw(g);
    }
    public static Location getLocation(){
        return new Location(mouseLocation.x - GamePanel.getInstance().spaceShipWidth/2,mouseLocation.y - GamePanel.getInstance().spaceShipHeight/2);

    }

    public void update() {
        if (test.currentPercentage <= 11){
            test.update();
        }
    }
}
