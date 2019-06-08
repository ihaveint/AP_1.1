package gameObjects;

import Listener.GameMouseMotionListener;
import resources.ImageLoader;
import resources.Location;
import resources.Vector;

import java.awt.*;

public class RandomBird extends Bird {

    public boolean locked = false;
    Location randomLocation = null;
    public RandomBird(){
        super(ImageLoader.getImage("randomBird"));

    }
    public double get_dist(Location a , Location b){
        return (a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y);
    }
    public Location get_randomLocation(){
        randomLocation = new Location();

        randomLocation.x = Math.random() * Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        randomLocation.y = Math.random() * Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        return randomLocation;
    }
    public void moveInDirection(Vector moveDirection){
        moveDirection = moveDirection.get_yekke();
        birdLocation.x += moveDirection.getX();
        birdLocation.y += moveDirection.getY();
    }
    public void moveInRandomDirection(){
        Vector moveDirection = new Vector(randomLocation.x-birdLocation.x,randomLocation.y-birdLocation.y);
        moveInDirection(moveDirection);
    }
    public boolean sholdGenerateNewRandomLocation(){

        if (randomLocation == null || get_dist(birdLocation,randomLocation) < 1 || insideScreen() == false){
            return true;
        }
        return false;
    }
    public void update(){
        if (locked){
            moveInSpaceShipDirection();
        }
        else {
            if (sholdGenerateNewRandomLocation()) {
                randomLocation = get_randomLocation();
            }
            moveInRandomDirection();
        }
    }

    void moveInSpaceShipDirection() {
        Vector moveDirection = new Vector(GameMouseMotionListener.mouseLocation.x - birdLocation.x , GameMouseMotionListener.mouseLocation.y - birdLocation.y);
        moveInDirection(moveDirection);
    }

    public void lockIn(){
        locked = true;

    }
}
