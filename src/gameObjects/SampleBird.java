package gameObjects;

import resources.ImageLoader;
import resources.RectLoader;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SampleBird implements Drawable {

    double x , y;
    ArrayList<Rectangle> rectangles = new ArrayList<>();
    HpBar hp = new HpBar();
    double heart = 100;
    boolean visible = true;
    long shakeTime;
    boolean died = false;
    public void loadBoxes(){
        rectangles = RectLoader.loadRectangles("src/GameObjects/sampleBox2.txt");
        for (Rectangle rect : rectangles){
            rect.xmin /= 2;
            rect.ymin /= 2;
            rect.xmax /= 2;
            rect.ymax /= 2;
        }

    }
    public SampleBird(){
        this(0,0);

    }
    public SampleBird(int x , int y){
        this.x = x;
        this.y = y;

        loadBoxes();
        shakeStartTime = -500000;
    }

    public double shakeX , shakeY;
    @Override
    public void draw(Graphics g) {

        hp.x = (int)this.x + 80;
        hp.y = (int)this.y - 120;



        if (died) {
            long diff = System.currentTimeMillis() - shakeStartTime;
            float percentage = (float) 1.0001 - (float) diff / (shakeTime);
//            System.out.println(percentage);
            float alpha = Math.min((float) 1, percentage);
            alpha = Math.max((float)0.01,alpha);
            AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setComposite(ac);

        }

        long currentTime = System.currentTimeMillis();
        if (visible && currentTime - shakeStartTime > shakeTime) {
            g.drawImage(ImageLoader.getImage("chicken"), (int) x + 30, (int) y, null);
            hp.draw(g);
        }
        if (currentTime - shakeStartTime <= shakeTime){
            shakeX = Math.random() * 8;
            shakeY = Math.random() * 8;
            g.drawImage(ImageLoader.getImage("chicken"), (int) x + 30 + (int)shakeX, (int) y + (int)shakeY, null);
            hp.draw(g);
        }else{
            shakeY = shakeX = 0;
            if (died){
                visible = false;
            }
        }


    }

    public void update(){
        x+= 0.5;
    }

    public boolean hit(Rectangle b){
        for (Rectangle rectangle : this.rectangles)
        {

            if (new Rectangle(rectangle.xmin + (int)x + 30 , rectangle.ymin + (int)y , rectangle.xmax + (int)x + 30  , rectangle.ymax + (int)y).hit(b)) return true;
        }

        return false;
    }


    public void die() {

        visible = false;
        shake(true,300);

    }

    public void reduceHeart(int value) {
        this.heart -= value;
        hp.percentage -= 0.25;
        if (this.heart <= 0){
            this.die();
        }else{
//            this.shake();
        }
    }
    public long shakeStartTime;

    public void shake(boolean died , long shakeTime){
        shakeStartTime = System.currentTimeMillis();
        this.died = died;
        if (died){
            hp.percentage = 0;
        }
        this.shakeTime = shakeTime;
    }
    public void shake(){
        shake(true);
    }
    public void shake(boolean died) {
        shake(died,2000);

    }
}
