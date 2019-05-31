package gameObjects;

import resources.RectLoader;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class HpBar implements Drawable{
    int x , y;
    ArrayList<Rectangle> rectangles = new ArrayList<>();
    double percentage = 1;
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
    @Override
    public void draw(Graphics g) {
        g.drawImage(resources.ImageLoader.getImage("HP2"),x,y,null);
        Rectangle rect = rectangles.get(0);
        g.setColor(Color.GREEN);
        g.fillRect(x+rect.xmin,y+rect.ymin ,(int)((rect.xmax - rect.xmin ) * percentage),rect.ymax - rect.ymin);
    }
}
