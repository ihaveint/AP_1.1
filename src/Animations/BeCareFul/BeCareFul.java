package Animations.BeCareFul;

import gameObjects.Drawable;
import gameObjects.SpaceShip;
import resources.ImageLoader;
import resources.Location;

import java.awt.*;
import java.util.HashMap;

public class BeCareFul implements Drawable {

    public double currentPercentage = 0;

    @Override
    public void draw(Graphics g) {

        Location spaceShipLocation = SpaceShip.getLocation();


        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)currentPercentage);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(ac);


        g.drawImage(ImageLoader.getImage("firstLayer"), spaceShipLocation.x,spaceShipLocation.y - 100,null);


    }

    public void update() {
        if (currentPercentage <= 1)
            currentPercentage += 0.005;
    }
}
