package gameObjects;

import menus.GamePanel;
import resources.ImageLoader;
import resources.Location;
import resources.RectLoader;

import java.awt.*;
import java.util.ArrayList;

public abstract class Bird implements Drawable{

    Image img;
    int heart = 100;
    public boolean died = false;
    public long shakeTime;
    int bandageWidth , bandageHeight;
    HpBar hp = new HpBar();
    boolean visible = true;
    static String defaultBoxName = "sampleBox2.txt";
    ArrayList<Rectangle> rectangles = new ArrayList<>();
    Location birdLocation = new Location(200,200);
    static Image defaultImage = ImageLoader.getImage("chicken");
    public void setImage(Image img){
        this.img = img;
    }
    public Bird(){
        this(defaultImage);
    }
    public Bird(Image img){
        this(img,defaultBoxName);


    }
    public Bird(Image img , String boxName){
        this(img,boxName,1);

    }
    public Bird(Image img, String boxName , int taghsimBar){
        this.img = img;
        loadBoxes(boxName,taghsimBar);
    }
    public void loadBoxes(String boxFileName , int tahghsimBar){
        rectangles = RectLoader.loadRectangles("src/GameObjects/" + boxFileName);
        for (Rectangle rect : rectangles){
            rect.xmin /= tahghsimBar;
            rect.ymin /= tahghsimBar;
            rect.xmax /= tahghsimBar;
            rect.ymax /= tahghsimBar;
        }

    }
    public void loadBoxes(String boxFileName){
        loadBoxes(boxFileName,1);
    }
    public void loadBoxes(){
        loadBoxes(defaultBoxName);

    }
    public boolean insideRange(double parameter , double rangeMin , double rangeMax){
        return parameter >= rangeMin && parameter <= rangeMax;
    }
    public boolean insideScreen(){
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        return insideRange(birdLocation.x,img.getWidth(null)/2,size.getWidth()-img.getWidth(null)/2) &&
                insideRange(birdLocation.y,img.getHeight(null)/2,size.getHeight()-img.getHeight(null));

    }

    public Location getDrawLocation(){
        return new Location(birdLocation.x - img.getWidth(null)/2 , birdLocation.y - img.getHeight(null)/2);
    }
    double shakeX, shakeY;
    boolean mark_explosion = false;
    @Override
    public void draw(Graphics g) {

        if (died && !mark_explosion){
            mark_explosion = true;
            GamePanel.getInstance().add_explosion((int)getDrawLocation().x,(int)getDrawLocation().y);

        }
        hp.x = (int)birdLocation.x + 80;
        hp.y = (int)birdLocation.y - 120;
        bandageWidth =  ImageLoader.getImage("bandage").getWidth(null);
        bandageHeight =  ImageLoader.getImage("bandage").getHeight(null);
        if (died) {
            long diff = System.currentTimeMillis() - shakeStartTime;
            float percentage = (float) 1.0001 - (float) diff / (shakeTime);
            float alpha = Math.min((float) 1, percentage);
            alpha = Math.max((float)0.01,alpha);
            AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setComposite(ac);

        }
        long currentTime = System.currentTimeMillis();
        if (visible && currentTime - shakeStartTime > shakeTime) {
            g.drawImage(img,(int)getDrawLocation().x , (int)getDrawLocation().y , null);
            for (Location bandageLocation : bandageLocations){

                g.drawImage(ImageLoader.getImage("bandage"),(int)bandageLocation.x - bandageWidth/2,(int)bandageLocation.y - bandageHeight/ 2,null);
            }
            hp.draw(g);
        }
        if (currentTime - shakeStartTime <= shakeTime){
            if (GamePanel.paused){
                shakeX = shakeY = 0;
            }
            else {
                shakeX = Math.random() * 8;
                shakeY = Math.random() * 8;
            }
            g.drawImage(img,(int)getDrawLocation().x  + (int)shakeX , (int)getDrawLocation().y   +(int) shakeY, null);
            for (Location bandageLocation : bandageLocations){

                g.drawImage(ImageLoader.getImage("bandage"),(int)bandageLocation.x - bandageWidth/2,(int)bandageLocation.y - bandageHeight/ 2,null);
            }
            hp.draw(g);
        }
        heart = Math.max(heart,0);


        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(ac);

        /*
        g.drawImage(img,(int)getDrawLocation().x , (int)getDrawLocation().y , null);
        hp.x = (int)birdLocation.x + 80;
        hp.y = (int)birdLocation.y - 120;
        hp.draw(g);
        bandageWidth =  ImageLoader.getImage("bandage").getWidth(null);
        bandageHeight =  ImageLoader.getImage("bandage").getHeight(null);
        System.out.println(bandageLocations.size());
        for (Location bandageLocation : bandageLocations){

            g.drawImage(ImageLoader.getImage("bandage"),(int)bandageLocation.x - bandageWidth/2,(int)bandageLocation.y - bandageHeight/ 2,null);
        }
        */
    }

    public void update(boolean paused){

    }
    public void expand_hp(){
        if (hp.decreasing) {
            hp.decreasing = false;
        }
        hp.increasing = true;
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


    public void die(){
        visible = false;
        shake(true,300);
    }

    ArrayList<Location> bandageLocations = new ArrayList<>();
    public boolean hit(Rectangle b){
        if (SpaceShip.showResume) return false;
        for (Rectangle rectangle : this.rectangles)
        {

            if (new Rectangle(rectangle.xmin + (int)getDrawLocation().x , rectangle.ymin + (int)getDrawLocation().y , rectangle.xmax + (int)getDrawLocation().x , rectangle.ymax + (int)getDrawLocation().y ).hit(b)) {

                expand_hp();
                return true;

            }
        }

        return false;
    }
    public void addBandage(int x, int y) {
        bandageLocations.add(new Location(x-ImageLoader.getImage("bandage").getWidth(null)/2,y-ImageLoader.getImage("bandage").getHeight(null)/2 ));
    }
}
