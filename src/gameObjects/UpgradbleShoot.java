package gameObjects;

import resources.Location;

public abstract class UpgradbleShoot implements  Drawable{

    public static int buildCount = 1;
    static Location buildLocation;

    public static void upgrade()
    {
        buildCount ++;
    }
    public static void downgrade(){
        buildCount --;
        if (buildCount == 0 ) buildCount = 1;
    }

    public abstract void checkBarkhord();

    public abstract void update(boolean paused);
    public void update(){
        update(false);
    }
}
