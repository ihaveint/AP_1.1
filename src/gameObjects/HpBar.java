package gameObjects;

import java.awt.*;

public class HpBar implements Drawable{
    int x , y;
    @Override
    public void draw(Graphics g) {
        g.drawImage(resources.ImageLoader.getImage("HP"),x,y,null);
    }
}
