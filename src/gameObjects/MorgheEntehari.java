package gameObjects;

import Controllers.GamePanelController;
import Listener.GameMouseMotionListener;
import RandomGenerator.RandomLocationGenerator;
import menus.GamePanel;
import resources.Location;

import java.util.ArrayList;
import java.util.Random;

public class MorgheEntehari extends RandomBird {

//    static long lastAmbush = 0;
    static int remaining = 1500;
    static ArrayList<MorgheEntehari> instances = new ArrayList<>();
    public MorgheEntehari(){
        this(RandomLocationGenerator.getRandomLocation());
    }

    public MorgheEntehari(Location location){
        super();
        instances.add(this);
    }

    public ArrayList<MorgheEntehari> filterInstances(int levelId){
        ArrayList<MorgheEntehari> ret= new ArrayList<>();
        for  (MorgheEntehari morgheEntehari : instances){
            if(morgheEntehari.whichLevel==levelId){
                ret.add(morgheEntehari);
            }
        }
        return ret;
    }
    public void update(boolean paused){
        if (paused) return ;
//        if (now - lastAmbush >= 10000){
        remaining --;
        if (remaining <= 0){
            Random rand = new Random();
            int randomId = rand.nextInt(instances.size());
            instances.get(randomId).lockIn();
            remaining = 1500;
        }

        super.update(paused);


    }
}
