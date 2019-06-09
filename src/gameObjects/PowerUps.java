package gameObjects;

import resources.Location;

import java.awt.*;

public abstract class PowerUps implements Drawable{

    public boolean visible =  true;
    Location location = new Location(500,500);

    public  abstract  void update();

    public abstract boolean hit(Rectangle rectangle);
}
