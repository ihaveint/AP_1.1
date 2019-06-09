package gameObjects;

import resources.ImageLoader;
import resources.Location;

import java.awt.*;
import java.util.ArrayList;

public class singleRedShoot implements  Drawable{

    ArrayList<Rectangle> rectangles = new ArrayList<>();
    Image shootImage;
    static  Image defaultImage = ImageLoader.getImage("RedBullet");
    Location shootLocation = new Location();
    int deltaX ,  deltaY;

    static  Location defaultLocation = new Location(400,400);

    String boxName;
    static String defaultBoxName = "BulletBoxes.txt";

    public singleRedShoot(){
        this(defaultBoxName);
    }
    public singleRedShoot(String boxName){
        this(boxName,defaultImage);
    }
    public singleRedShoot(String boxName , Image img){
        this(boxName,img,defaultLocation);
    }
    public singleRedShoot(String boxName , Image img , Location shootLocation){
        this(boxName,img,shootLocation,0,-3);

    }
    public singleRedShoot(String boxName , Image img , Location shootLocation , int deltaX , int deltaY){
        this.boxName = boxName;
        this.shootImage = img;
        this.shootLocation = shootLocation;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        loadBoxes(boxName);

    }
    public void loadBoxes(String boxName){

        // TODO
    }
    public Location getDrawLocation(){
        return  new Location(shootLocation.x -  shootImage.getWidth(null)/2,shootLocation.y - shootImage.getHeight(null)/2);
    }
    @Override
    public void draw(Graphics g) {
        g.drawImage(shootImage,(int)getDrawLocation().x,(int)getDrawLocation().y,null);
    }


    public void update(){
        shootLocation.x +=  deltaX;
        shootLocation.y += deltaY;
    }
}
