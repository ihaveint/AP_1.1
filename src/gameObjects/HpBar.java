package gameObjects;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class HpBar implements Drawable{
    int x , y;
    ArrayList<Rectangle> rectangles = new ArrayList<>();
    double percentage = 1;
    public void loadBoxes(){
        try{
            Scanner input = new Scanner(new File("src/GameObjects/HpBar.txt"));

            while(input.hasNextLine()){
                int xmin , ymin , xmax , ymax;
                String line = input.nextLine();
                String []arr = line.split(" ");
                xmin = Integer.parseInt(arr[0]);
                ymin = Integer.parseInt(arr[1]);
                xmax = Integer.parseInt(arr[2]);
                ymax = Integer.parseInt(arr[3]);
                this.rectangles.add(new Rectangle(xmin/2,ymin,xmax/2,ymax));

            }

            input.close();
        }
        catch (Exception e){}
    }
    public HpBar(){
        loadBoxes();
    }
    @Override
    public void draw(Graphics g) {
        g.drawImage(resources.ImageLoader.getImage("HP2"),x,y,null);
        Rectangle rect = rectangles.get(0);
        g.setColor(Color.GREEN);
        g.fillRect(x+rect.xmin,y+rect.ymin ,(int)((rect.xmax - rect.xmin ) * percentage),rect.ymax - rect.ymin - 1);
    }
}
