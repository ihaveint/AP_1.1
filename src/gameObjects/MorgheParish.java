package gameObjects;

import RandomGenerator.RandomLocationGenerator;
import resources.ImageLoader;
import resources.Location;

import java.awt.*;

public class MorgheParish extends Bird{

    int sign;
    public MorgheParish(){
        this(Math.random()<0.5 ? 1 :-1);
    }
    public MorgheParish(int sign){
        this(sign,RandomLocationGenerator.getRandomLocation());

    }
    public MorgheParish(int sign , Location location){
        super(defaultImage = ImageLoader.getImage("chicken"),"sampleBox2.txt",2);
        this.sign = sign;
        birdLocation = location;
    }

    public void update(boolean paused){
        if (paused) return ;
        int deltaX = sign * 2;
        birdLocation.x += sign * 2;
        if (birdLocation.x - img.getWidth(null)/2 > Toolkit.getDefaultToolkit().getScreenSize().getWidth() || birdLocation.x + img.getWidth(null)/2 < 0) {
            visible = false;
        }
        for (Location bandageLocation : bandageLocations){
            bandageLocation.x += deltaX;
        }
    }
}
