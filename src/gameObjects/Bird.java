package gameObjects;

import resources.ImageLoader;
import resources.Location;

import java.awt.*;

public abstract class Bird implements Drawable{

    Image img;
    Location birdLocation = new Location(200,200);
    static Image defaultImage = ImageLoader.getImage("chicken");
    public void setImage(Image img){
        this.img = img;
    }
    public Bird(){
        this(defaultImage);
    }
    public Bird(Image img){
        this.img = img;

    }
    public boolean insideRange(double parameter , double rangeMin , double rangeMax){
        return parameter >= rangeMin && parameter <= rangeMax;
    }
    public boolean insideScreen(){
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        return insideRange(birdLocation.x,img.getWidth(null)/2,size.getWidth()-img.getWidth(null)/2) &&
                insideRange(birdLocation.y,img.getHeight(null)/2,size.getHeight()-img.getHeight(null));

    }

    public Location getDrawLocation(){
        return new Location(birdLocation.x - img.getWidth(null)/2 , birdLocation.y - img.getHeight(null)/2);
    }
    @Override
    public void draw(Graphics g) {
        g.drawImage(img,(int)getDrawLocation().x , (int)getDrawLocation().y , null);
    }
}
