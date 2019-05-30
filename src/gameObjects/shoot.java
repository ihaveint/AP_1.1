package gameObjects;

import Controllers.GamePanelController;
import menus.GamePanel;
import resources.ImageLoader;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class shoot implements Drawable{
    public int x , y;
    int shootWidth , shootHeight;
    ArrayList<Rectangle> rectangles = new ArrayList<>();

    public void loadBoxes(){
        try {
            Scanner input = new Scanner(new File("src/gameObjects/BulletBoxes.txt"));
            while (input.hasNextLine()){
                int xmin , ymin , xmax , ymax;
                String line = input.nextLine();
                String []arr = line.split(" ");
                xmin = Integer.parseInt(arr[0]);
                ymin = Integer.parseInt(arr[1]);
                xmax = Integer.parseInt(arr[2]);
                ymax = Integer.parseInt(arr[3]);
                rectangles.add(new Rectangle(xmin,ymin,xmax,ymax));
            }
        }
        catch(Exception e){e.printStackTrace();}

    }
    public shoot(int x , int y){
        this.x = x;
        this.y  = y;
        shootWidth = ImageLoader.getImage("RedBullet").getWidth(null);
        shootHeight = ImageLoader.getImage("RedBullet").getHeight(null);
        loadBoxes();
    }

    public void update(){
        this.y -= 3;
        if (this.y <= Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2){
            GamePanelController.shakeScreen();

        }


    }

    public void checkBarkhord(){
        if (hitChicken(GamePanel.testBird)){
            GamePanel.testBird.die();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(ImageLoader.getImage("RedBullet"),x-shootWidth/2,y-shootHeight/2,null);
    }

    public boolean hitChicken(SampleBird bird){
        for (Rectangle rectangle : this.rectangles){
            if (bird.hit(new Rectangle(rectangle.xmin + x  - shootWidth/2, rectangle.ymin + y -shootHeight/2 , rectangle.xmax + x  -shootWidth/2 , rectangle.ymax + y - shootHeight/2))){
                return true;
            }
//            if (bird.hit(rectangle)){
//                return true;
//            }
        }
        return false;

    }
}
