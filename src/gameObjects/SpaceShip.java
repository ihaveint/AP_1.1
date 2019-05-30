package gameObjects;

import menus.GamePanel;
import resources.ImageLoader;
import static menus.GamePanel.*;


import java.awt.*;

public class SpaceShip implements Drawable{

    @Override
    public void draw(Graphics g) {

        g.drawImage(ImageLoader.getImage("SpaceShip"),mouseLocation.x - GamePanel.getInstance().spaceShipWidth/2,mouseLocation.y - GamePanel.getInstance().spaceShipHeight/2,null);
    }
}
