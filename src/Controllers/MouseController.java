package Controllers;

import Listener.GameKeyListener;
import Listener.GameMouseMotionListener;
import gameObjects.SpaceShip;
import menus.GamePanel;
import resources.Location;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.lang.reflect.Field;
import java.util.HashMap;

public class MouseController {
    private static HashMap<String, JPanel> hashMap = new HashMap<>();
    private static MouseController ourInstance = new MouseController();

    public static MouseController getInstance() {
        return ourInstance;
    }

    private MouseController() {
        hashMap.put("GamePanel", GamePanel.getInstance());
    }

    public static void mousePressed(MouseEvent e) {
        if (!GamePanel.paused && GamePanel.getInstance().running) {

            KeyController.getInstance().pressed(KeyController.getInstance().getSpaceKey());
        }
        else{
            if (GameMouseMotionListener.insideResume){
                GamePanel.getInstance().running = true;
                KeyController.getInstance().pressed(KeyController.getInstance().getEscapeKey());
            }
            if (GameMouseMotionListener.insideQuit){
                GamePanelController.getInstance().MoveBackToPlayerMenu();
            }
        }

    }

//    public void setCursorLocation(String componentName, int x , int y){
//        if (GamePanel.paused) return ;
//        Object component =  hashMap.get(componentName);
//        Class<?> someClass = component.getClass();
//        Field mouseLocation = null;
//        try {
//            mouseLocation = someClass.getField("mouseLocation");
//            mouseLocation.set(component,new Location(x,y));
//            GamePanelController.getInstance().repaintPanel();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
}
