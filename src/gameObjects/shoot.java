package gameObjects;

import Controllers.GamePanelController;
import menus.GameFrame;
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
    Rectangle whichRect;
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
        if (visible == false) return ;
        for (SampleBird sampleBird : GamePanel.sampleBirds) {
            if (hitChicken(sampleBird)){
                sampleBird.reduceHeart(25);
                sampleBird.addBandate((Rectangle.common_cache.xmin+Rectangle.common_cache.xmax)/2,Rectangle.common_cache.ymin);
            }
        }


        for (Bird bird : GamePanel.final_birds){
            if (hitBird(bird)){
                bird.reduceHeart(25);
                bird.addBandage((Rectangle.common_cache.xmin+Rectangle.common_cache.xmax)/2,Rectangle.common_cache.ymin);
            }
        }



    }

    private boolean hitBird(Bird bird) {
        for (Rectangle rectangle : this.rectangles){
            Rectangle check = new Rectangle(rectangle.xmin + x  - shootWidth/2, rectangle.ymin + y -shootHeight/2 , rectangle.xmax + x  -shootWidth/2 , rectangle.ymax + y - shootHeight/2);

            if (bird.hit(check)){
                whichRect = check;
                visible = false;
                bird.shake(false , 300);
                return true;

            }
        }
        return false;
    }

    @Override
    public void draw(Graphics g) {
        if (visible) {
            g.drawImage(ImageLoader.getImage("RedBullet"), x - shootWidth / 2, y - shootHeight / 2, null);
        }
    }

    public boolean hitChicken(SampleBird bird){
        if (visible == false) return false;
        if (bird.died) return false;

        for (Rectangle rectangle : this.rectangles){
            Rectangle check = new Rectangle(rectangle.xmin + x  - shootWidth/2, rectangle.ymin + y -shootHeight/2 , rectangle.xmax + x  -shootWidth/2 , rectangle.ymax + y - shootHeight/2);

            if (bird.hit(check)){
                whichRect = check;
                visible = false;
                bird.shake(false , 300);
                return true;

            }
        }
        return false;

    }
}
