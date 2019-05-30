package gameObjects;

import resources.ImageLoader;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SampleBird implements Drawable {

    double x , y;
    ArrayList<Rectangle> rectangles = new ArrayList<>();

    boolean visible = true;
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
//                System.out.println(xmin + " " + ymin + " " + xmax + " " + ymax);

                this.rectangles.add(new Rectangle(xmin,ymin,xmax,ymax));

            }

            input.close();
        }
        catch (Exception e){}
    }
    public SampleBird(){
        loadBoxes();

    }

    @Override
    public void draw(Graphics g) {
        if (visible)
            g.drawImage(ImageLoader.getImage("chicken"),(int)x + 30,(int)y ,null);

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
}
