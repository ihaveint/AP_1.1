package gameObjects;

import resources.ImageLoader;
import resources.Location;
import resources.Vector;

import java.awt.*;

public class RandomBird extends Bird {

    Location randomLocation = null;
    public RandomBird(){
        super(ImageLoader.getImage("randomBird"));

    }
    public double get_dist(Location a , Location b){
        return (a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y);
    }
    public void update(){
        if (randomLocation == null || get_dist(birdLocation,randomLocation) < 1 || insideScreen() == false){
            randomLocation = new Location();

            randomLocation.x = Math.random() * Toolkit.getDefaultToolkit().getScreenSize().getWidth();
            randomLocation.y = Math.random() * Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        }

        Vector moveDirection = new Vector(randomLocation.x-birdLocation.x,randomLocation.y-birdLocation.y);
        moveDirection = moveDirection.get_yekke();
        birdLocation.x += moveDirection.getX();
        birdLocation.y += moveDirection.getY();



    }
}
