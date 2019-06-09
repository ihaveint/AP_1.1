package gameObjects;

import resources.Location;

import java.awt.*;
import java.util.ArrayList;

public class RedShoot extends UpgradbleShoot implements  Drawable {
    ArrayList<singleRedShoot> ajza = new ArrayList();
    static Location defaultBuildLocation = new Location(500,500);

    public RedShoot(int x , int y ){

        this(buildLocation = new Location(x,y),buildCount);

    }
    public RedShoot(Location buildLocation , int count){
        buildCount = count;
        ajza = RedShootBuilder.build(count,buildLocation);
    }

    public RedShoot(int count){
        this(defaultBuildLocation,count);
    }
    public RedShoot(){
        this(buildCount);
    }
    @Override
    public void draw(Graphics g) {

        for (singleRedShoot singleRedShoot : ajza){
            singleRedShoot.draw(g);
        }
    }

    public void update(){
        update(false);
    }
    public void update(boolean paused){
        if (paused==true) return;
        for (singleRedShoot singleRedShoot : ajza){
            singleRedShoot.update();
        }
    }

    @Override
    public void checkBarkhord() {
        for (singleRedShoot singleRedShoot : ajza){
            singleRedShoot.checkBarkhord();
        }
    }
}
