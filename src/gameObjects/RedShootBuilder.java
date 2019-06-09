package gameObjects;

import resources.ImageLoader;
import resources.Location;

import java.util.ArrayList;

public class RedShootBuilder {
    private static RedShootBuilder ourInstance = new RedShootBuilder();

    public static RedShootBuilder getInstance() {
        return ourInstance;
    }

    private RedShootBuilder() {
    }

    public static ArrayList<singleRedShoot> build(int cntShoots , Location buildLocation) {
        ArrayList<singleRedShoot> response = new ArrayList<>();

        if (cntShoots >= 1){
            singleRedShoot straight = new singleRedShoot(singleRedShoot.defaultBoxName,singleRedShoot.defaultImage,buildLocation);
            response.add(straight);


        }
        if (cntShoots >= 2){
            singleRedShoot rightShoot = new singleRedShoot("red2.txt", ImageLoader.getImage("RedBullet"),new Location(buildLocation.x + 20,buildLocation.y),0,-3);
            response.add(rightShoot);
//            singleRedShoot rightShoot = new singleRedShoot("red2.txt", ImageLoader.getImage("RedBullet2"),new Location(buildLocation.x + 20,buildLocation.y),2,-2);
//            response.add(rightShoot);

        }
        if (cntShoots >= 3){
            singleRedShoot rightShoot = new singleRedShoot("red2.txt", ImageLoader.getImage("RedBullet"),new Location(buildLocation.x - 20,buildLocation.y),0,-3);
            response.add(rightShoot);
        }

        return response;
    }
}
