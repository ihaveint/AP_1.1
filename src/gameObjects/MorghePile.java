package gameObjects;

import resources.ImageLoader;

import java.awt.*;

public class MorghePile extends Bird {


    int sign = 1;
    public MorghePile(){
        super(defaultImage = ImageLoader.getImage("morghePile"));

    }
    public void update(){
        birdLocation.x += sign * 2;
        if (birdLocation.x + img.getWidth(null)/2 > Toolkit.getDefaultToolkit().getScreenSize().getWidth() || birdLocation.x - img.getWidth(null)/2 < 0) {
            sign *= -1;
        }
    }

}
