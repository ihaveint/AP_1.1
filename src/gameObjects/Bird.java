package gameObjects;

import resources.ImageLoader;
import resources.Location;
import resources.RectLoader;

import java.awt.*;
import java.util.ArrayList;

public abstract class Bird implements Drawable{

    Image img;
    int heart = 100;
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
    @Override
    public void draw(Graphics g) {

        if (visible==false) return ;
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
    }

    public void update(){

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

    public void die(){
        visible = false;
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
