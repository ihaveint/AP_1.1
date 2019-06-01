package gameObjects;

import resources.RectLoader;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class HpBar implements Drawable{
    int x , y;
    public  String type = "bird_hp";
    public boolean decreasing = false;
    public boolean increasing = false;
    public double drawPercentage = 0 ;
    ArrayList<Rectangle> rectangles = new ArrayList<>();
    public double percentage = 1;
    public void loadBoxes(){
        rectangles = RectLoader.loadRectangles("src/GameObjects/HpBar.txt");
        for (Rectangle rect : rectangles){
            rect.xmin /= 2;
            rect.xmax /= 2;
        }
    }



    public HpBar(){
        loadBoxes();
    }
    public HpBar(int x , int y){
        this.x = x;
        this.y = y;
        loadBoxes();
    }
    @Override
    public void draw(Graphics g) {
//        g.drawImage(resources.ImageLoader.getImage("HP2"),x,y,null);
//        Rectangle rect = rectangles.get(0);
//        g.setColor(Color.GREEN);
//        g.fillRect(x+rect.xmin,y+rect.ymin ,(int)((rect.xmax - rect.xmin ) * percentage),rect.ymax - rect.ymin);


        if (type.equals("bird_hp")) {
            draw(g, drawPercentage);
        }
        else{
            draw(g,1);
        }
//        draw(g,1);
    }


    public void draw(Graphics g , double zarbdar){

//        g.drawImage(resources.ImageLoader.getImage("HP2"),x,y,(int)(resources.ImageLoader.getImage("HP2").getWidth(null)*zarbdar),
//                (int)(resources.ImageLoader.getImage("HP2").getHeight(null)*zarbdar),null);

        g.setColor(Color.RED);
        Rectangle rect = rectangles.get(0);
        g.fillRect(x+rect.xmin,y+rect.ymin , (int) ((rect.xmax - rect.xmin) * zarbdar) , rect.ymax - rect.ymin );
        g.setColor(Color.GREEN);
        g.fillRect(x+rect.xmin,y+rect.ymin ,(int)( ((rect.xmax - rect.xmin ) * percentage) * zarbdar) , rect.ymax - rect.ymin );

        update_percentage();
    }
    public long last_complete = -500000;
    public void update_percentage(){
        if (increasing){
            drawPercentage += 0.005;
            if (drawPercentage >= 1) {
                System.out.println("come on man ! ");
                drawPercentage = 1;
                last_complete = System.currentTimeMillis();
            }
        }else if (decreasing){
            drawPercentage -= 0.005;
            if (drawPercentage < 0 ) drawPercentage = 0;
        }


        if (drawPercentage == 1 && System.currentTimeMillis() - last_complete > 3000){
            decreasing = true;
            increasing = false;

        }



    }

}
