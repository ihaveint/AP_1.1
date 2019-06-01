package Animations.explosions;

import gameObjects.Drawable;

import resources.ImageLoader;
import resources.Location;

import java.awt.*;
import java.awt.image.BufferedImage;

public class small_explosion implements Drawable {

    Image img;
    int width , height;
    public Location p;
    public Double timeSinceCreated;
    public boolean remove = false;
    public small_explosion(int x , int y){
        img = ImageLoader.getImage("small_exp");
        p = new Location(x,y);
    }

    double constant = 1;
    @Override
    public void draw(Graphics g) {
        if (!remove) {
            g.drawImage(img, (int) p.x + 125, (int) p.y + 40, width, height, null);
            width += constant;
            height += constant;
            p.x -= (double) constant / 2;
            p.y -= (double) constant / 2;
            if (height >= 150) {
                remove = true;
            }

        }
    }
}
