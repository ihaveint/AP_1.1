package gameObjects;

import Controllers.GamePanelController;
import resources.ImageLoader;

import java.awt.*;

public class shoot implements Drawable{
    public int x , y;
    int shootWidth , shootHeight;
    public shoot(int x , int y){
        this.x = x;
        this.y  = y;
        shootWidth = ImageLoader.getImage("RedBullet").getWidth(null);
        shootHeight = ImageLoader.getImage("RedBullet").getHeight(null);
    }

    public void update() {
        this.y -= 3;
        if (this.y <= Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2){
            GamePanelController.shakeScreen();

        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(ImageLoader.getImage("RedBullet"),x-shootWidth/2,y-shootHeight/2,null);
    }
}
