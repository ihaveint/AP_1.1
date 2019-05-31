package gameObjects;

import resources.ImageLoader;

import java.awt.*;

public class MovingBackGround implements Drawable{
    private int firstY , secondY;
    private static MovingBackGround ourInstance = new MovingBackGround();
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    public static MovingBackGround getInstance() {
        return ourInstance;
    }

    private MovingBackGround() {

        firstY = -height;
        secondY = 0;

    }

    @Override
    public void draw(Graphics g) {
        draw(g,false);


    }

    public void draw(Graphics g, boolean paused) {

        g.drawImage(ImageLoader.getImage("BackGround"),0,firstY,null);
        g.drawImage(ImageLoader.getImage("BackGround"),0,secondY,null);
        if (paused) return ;
        firstY += 1;
        secondY += 1;
        if (secondY >= height){
            secondY = -height;
        }
        if (firstY >= height){
            firstY = -height;
        }
    }
}
