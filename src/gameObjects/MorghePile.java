package gameObjects;

import resources.ImageLoader;
import resources.Location;

import java.awt.*;

public class MorghePile extends Bird {


    int sign = 1;
    public MorghePile(){
        super(defaultImage = ImageLoader.getImage("morghePile"),"PileBoxes.txt",3);

    }
    public void update(){
        int deltaX = sign * 2;
        birdLocation.x += sign * 2;
        if (birdLocation.x + img.getWidth(null)/2 > Toolkit.getDefaultToolkit().getScreenSize().getWidth() || birdLocation.x - img.getWidth(null)/2 < 0) {
            sign *= -1;
        }
        for (Location bandageLocation : bandageLocations){
            bandageLocation.x += deltaX;
        }
    }

}
