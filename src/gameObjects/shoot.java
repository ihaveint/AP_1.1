package gameObjects;

import Controllers.GamePanelController;
import menus.GamePanel;
import resources.ImageLoader;
import resources.RectLoader;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class shoot implements Drawable{
    public int x , y;
    int shootWidth , shootHeight;
    ArrayList<Rectangle> rectangles = new ArrayList<>();
    String type = "shoot";
    public boolean visible = true;
    public void loadBoxes(){
        rectangles = RectLoader.loadRectangles("src/GameObjects/BulletBoxes.txt");

    }
    public shoot(int x , int y){
        this.x = x;
        this.y  = y;
        shootWidth = ImageLoader.getImage("RedBullet").getWidth(null);
        shootHeight = ImageLoader.getImage("RedBullet").getHeight(null);
        loadBoxes();
    }

    public void update(boolean paused){
        if (paused) return ;
        this.y -= 3;
        if (visible && this.y <= Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2 && type == "Missile"){
            visible = false;
            GamePanelController.shakeScreen();
        }
    }

    public void checkBarkhord(){
        if (hitChicken(GamePanel.testBird)){
            GamePanel.testBird.reduceHeart(25);
//            GamePanel.testBird.die();
        }
    }

    @Override
    public void draw(Graphics g) {
        if (visible) {
            g.drawImage(ImageLoader.getImage("RedBullet"), x - shootWidth / 2, y - shootHeight / 2, null);
        }
    }

    public boolean hitChicken(SampleBird bird){
        if (visible == false) return false;
        for (Rectangle rectangle : this.rectangles){
            if (bird.hit(new Rectangle(rectangle.xmin + x  - shootWidth/2, rectangle.ymin + y -shootHeight/2 , rectangle.xmax + x  -shootWidth/2 , rectangle.ymax + y - shootHeight/2))){
                visible = false;
                bird.shake(false , 300);
                return true;

            }
//            if (bird.hit(rectangle)){
//                return true;
//            }
        }
        return false;

    }
}
