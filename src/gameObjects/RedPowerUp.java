package gameObjects;

import resources.ImageLoader;
import resources.Location;
import resources.RectLoader;

import java.awt.*;
import java.util.ArrayList;

public class RedPowerUp extends PowerUps {
    Image img;
    String boxName = "RedBox.txt";
    public RedPowerUp(){
        this((int)defaultLocation.x,(int)defaultLocation.y);

    }

    ArrayList<Rectangle> rectangles = new ArrayList<>();

    public RedPowerUp(int x, int y) {
        location = new Location(x,y);
        img = ImageLoader.getImage("red_powerUp");
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

            return new Location(location.x - img.getWidth(null)/2 , location.y - img.getHeight(null)/2);

    }
    @Override
    public void draw(Graphics g) {
        g.drawImage(img,(int)getDrawLocation().x,(int)getDrawLocation().y,null);
    }

    @Override
    public void update() {
        location.y += 2;
    }

    @Override
    public boolean hit(Rectangle b) {

        if (SpaceShip.showResume) return false;
        if (visible==false) return false;

        for (Rectangle rectangle : this.rectangles)
        {

            if (new Rectangle(rectangle.xmin + (int)getDrawLocation().x , rectangle.ymin + (int)getDrawLocation().y , rectangle.xmax + (int)getDrawLocation().x , rectangle.ymax + (int)getDrawLocation().y ).hit(b)) {
                return true;

            }
        }

        return false;
    }
}
