package gameObjects;

import Controllers.GamePanelController;
import Listener.GameMouseMotionListener;
import menus.GamePanel;

import java.util.ArrayList;
import java.util.Random;

public class MorgheEntehari extends RandomBird {

//    static long lastAmbush = 0;
    static int remaining = 1500;
    static ArrayList<MorgheEntehari> instances = new ArrayList<>();
    public MorgheEntehari(){
        super();

        instances.add(this);
    }


    public void update(){
        long now = System.currentTimeMillis();
//        if (now - lastAmbush >= 10000){
        remaining --;
        if (remaining <= 0){
            Random rand = new Random();
            int randomId = rand.nextInt(instances.size());
            instances.get(randomId).lockIn();
            remaining = 1500;
        }

        super.update();


    }
}
