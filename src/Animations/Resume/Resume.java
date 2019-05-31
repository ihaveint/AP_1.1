package Animations.Resume;

import gameObjects.Drawable;
import gameObjects.SpaceShip;
import resources.ImageLoader;
import resources.Location;

import java.awt.*;

public class Resume implements Drawable {
    public double currentPercentage = 0;
    public double currentLayer = 1;
    @Override
    public void draw(Graphics g) {

//        Location spaceShipLocation = SpaceShip.getLocation();


        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)currentPercentage);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(ac);


        g.drawImage(ImageLoader.getImage("resume"), 600,-100,null);



    }

    public void update() {
        if (currentPercentage <= 1)
            currentPercentage += 0.002;
        currentLayer += 0.03;
    }
}
