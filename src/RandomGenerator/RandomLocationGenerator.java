package RandomGenerator;

import resources.Location;

import java.awt.*;

public class RandomLocationGenerator {
    private static RandomLocationGenerator ourInstance = new RandomLocationGenerator();

    public static RandomLocationGenerator getInstance() {
        return ourInstance;
    }

    private RandomLocationGenerator() {

    }

    public  static Location getRandomLocation(){
        Location ret  = new Location();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        ret.x =  Math.random()  *screenSize.getWidth();
        ret.y  = Math.random() * screenSize.getHeight();
        return ret;
    }
}
