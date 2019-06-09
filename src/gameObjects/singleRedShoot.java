package gameObjects;

import menus.GamePanel;
import resources.ImageLoader;
import resources.Location;
import resources.RectLoader;

import java.awt.*;
import java.util.ArrayList;

public class singleRedShoot implements  Drawable{

    boolean visible = true;
    ArrayList<Rectangle> rectangles = new ArrayList<>();
    Image shootImage;
    static  Image defaultImage = ImageLoader.getImage("RedBullet");
    Location shootLocation = new Location();
    int deltaX ,  deltaY;
    int shootWidth , shootHeight;

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
        shootWidth = img.getWidth(null);
        shootHeight = img.getHeight(null);

        loadBoxes(boxName);

    }
    public void loadBoxes(String boxFileName , int tahghsimBar){
        rectangles = RectLoader.loadRectangles("src/GameObjects/" + boxFileName);
        for (Rectangle rect : rectangles){
            rect.xmin /= tahghsimBar;
            rect.ymin /= tahghsimBar;
            rect.xmax /= tahghsimBar;
            rect.ymax /= tahghsimBar;
        }

    }
    public void loadBoxes(String boxFileName){
        loadBoxes(boxFileName,1);
    }
    public Location getDrawLocation(){
        return  new Location(shootLocation.x -  shootImage.getWidth(null)/2,shootLocation.y - shootImage.getHeight(null)/2);
    }
    @Override
    public void draw(Graphics g) {
        if (!visible) return ;
        g.drawImage(shootImage,(int)getDrawLocation().x,(int)getDrawLocation().y,null);
    }


    public void update(){
        shootLocation.x +=  deltaX;
        shootLocation.y += deltaY;
    }

    public void checkBarkhord() {
        if (visible == false) return ;


        for (Bird bird : GamePanel.getInstance().currentLevel.final_birds){
            if (hitBird(bird)){
                bird.reduceHeart(25);
                bird.addBandage((Rectangle.common_cache.xmin+Rectangle.common_cache.xmax)/2,Rectangle.common_cache.ymin);
            }
        }

    }
    private boolean hitBird(Bird bird) {
        for (Rectangle rectangle : this.rectangles){
            Rectangle check = new Rectangle(rectangle.xmin + (int)shootLocation.x  - shootWidth/2, rectangle.ymin + (int)shootLocation.y -shootHeight/2 , rectangle.xmax + (int)shootLocation.x  -shootWidth/2 , rectangle.ymax + (int)shootLocation.y - shootHeight/2);

            if (bird.hit(check)){
                visible = false;
                bird.shake(false , 300);
                return true;

            }
        }
        return false;
    }

}
