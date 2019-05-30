package gameObjects;

import resources.ImageLoader;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SampleBird implements Drawable {

    double x , y;
    ArrayList<Rectangle> rectangles = new ArrayList<>();
    double heart = 100;
    boolean visible = true;

    boolean died = false;
    public void loadBoxes(){
        try{
            Scanner input = new Scanner(new File("src/GameObjects/sampleBox2.txt"));

            while(input.hasNextLine()){
                int xmin , ymin , xmax , ymax;
                String line = input.nextLine();
                String []arr = line.split(" ");
                xmin = Integer.parseInt(arr[0]);
                ymin = Integer.parseInt(arr[1]);
                xmax = Integer.parseInt(arr[2]);
                ymax = Integer.parseInt(arr[3]);
                this.rectangles.add(new Rectangle(xmin/2,ymin/2,xmax/2,ymax/2));

            }

            input.close();
        }
        catch (Exception e){}
    }
    public SampleBird(){
        loadBoxes();
        shakeStartTime = -500000;

    }

    public double shakeX , shakeY;
    @Override
    public void draw(Graphics g) {
        long currentTime = System.currentTimeMillis();
        if (visible && currentTime - shakeStartTime > 2000) {
            g.drawImage(ImageLoader.getImage("chicken"), (int) x + 30, (int) y, null);
        }
        if (currentTime - shakeStartTime <= 2000){
            shakeX = Math.random() * 8;
            shakeY = Math.random() * 8;
            g.drawImage(ImageLoader.getImage("chicken"), (int) x + 30 + (int)shakeX, (int) y + (int)shakeY, null);
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
    }

    public void reduceHeart(int value) {
        this.heart -= value;
        if (this.heart <= 0){
            this.die();
        }else{
//            this.shake();
        }
    }
    public long shakeStartTime;

    public void shake() {
        shakeStartTime = System.currentTimeMillis();
        died = true;
    }
}
