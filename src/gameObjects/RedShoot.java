package gameObjects;

import resources.Location;

import java.awt.*;
import java.util.ArrayList;

public class RedShoot extends UpgradbleShoot implements  Drawable {
    ArrayList<singleRedShoot> ajza = new ArrayList();
    RedShoot nextShoot;
    RedShoot currentShoot;
    public static int buildCount;
    static Location defaultBuildLocation = new Location(500,500);

    public RedShoot(Location buildLocation , int count){
        buildCount = count;
        currentShoot = this;
        currentShoot.ajza = RedShootBuilder.build(count,buildLocation);
    }

    public RedShoot(int count){
        this(defaultBuildLocation,count);
    }
    public RedShoot(){
        this(buildCount);
    }
    @Override
    public void draw(Graphics g) {

        for (singleRedShoot singleRedShoot : currentShoot.ajza){
            singleRedShoot.draw(g);
        }
    }


    public void update(){
        for (singleRedShoot singleRedShoot : currentShoot.ajza){
            singleRedShoot.update();
        }
    }

    @Override
    public void upgrade() {
        buildCount ++;
//        currentShoot.nextShoot = new RedShoot(buildCount+1);
//        currentShoot = currentShoot.nextShoot;

    }
    public void downgrade(){
        // TODO
    }
}
