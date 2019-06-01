package menus;

import gameObjects.Drawable;
import gameObjects.Rectangle;
import resources.ImageLoader;
import resources.Location;

import java.awt.*;

public class PauseFrame implements Drawable {
    private static PauseFrame ourInstance = new PauseFrame();

    private Location location = new Location(500,500);
    public Rectangle resumeRectangle ;
    public static PauseFrame getInstance() {
        return ourInstance;
    }

    private PauseFrame() {
        resumeRectangle = new Rectangle(90+(int)location.x,530,ImageLoader.getImage("resume_button").getWidth(null),
                ImageLoader.getImage("resume_button").getHeight(null));
        resumeRectangle.xmax += resumeRectangle.xmin;
        resumeRectangle.ymax += resumeRectangle.ymin;
        resumeRectangle.print();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(ImageLoader.getImage("frame"),(int)location.x,(int)location.y,null);
        g.drawImage(ImageLoader.getImage("resume_button"),90+(int)location.x,530,null);
        g.drawImage(ImageLoader.getImage("quit_button"),90+(int)location.x,630,null);
    }

    public Location getLocation(){
        return new Location(location.x,location.y);
    }

}
