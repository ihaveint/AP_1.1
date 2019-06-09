package gameObjects;

import RandomGenerator.RandomLocationGenerator;
import resources.ImageLoader;
import resources.Location;
import resources.RectLoader;

import java.awt.*;
import java.util.ArrayList;

public class Egg implements Drawable {
    Image img = ImageLoader.getImage("Egg");
    String boxName = "EggBoxes.txt";
    Location location;
    public boolean crashed = false;
    ArrayList<Rectangle> rectangles = new ArrayList<>();

    public Egg(Location location) {
        this.location = location;
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

    public Egg(){
        this(RandomLocationGenerator.getRandomLocation());

    }

    public Location getDrawLocation(){
        return  new Location(location.x -  img.getWidth(null)/2,location.y - img.getHeight(null)/2);
    }

    @Override
    public void draw(Graphics g) {
        if (crashed) return ;
        g.drawImage(img,(int)getDrawLocation().x,(int)getDrawLocation().y,null);
    }
    public void update(){
        location.y += 2;
    }

    public boolean hit(Rectangle b) {
        if (SpaceShip.showResume) return false;
        if (crashed) return false;
        for (Rectangle rectangle : this.rectangles)
        {
            if (new Rectangle(rectangle.xmin + (int)getDrawLocation().x , rectangle.ymin + (int)getDrawLocation().y , rectangle.xmax + (int)getDrawLocation().x , rectangle.ymax + (int)getDrawLocation().y ).hit(b)) {
                return true;

            }
        }

        return false;
    }
}
