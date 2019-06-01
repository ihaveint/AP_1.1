package Listener;

import menus.GamePanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import gameObjects.Rectangle;
import menus.PauseFrame;
import resources.Location;

public class GameMouseMotionListener implements MouseMotionListener {
    public static boolean insideResume = false;
    private static GameMouseMotionListener ourInstance = new GameMouseMotionListener();

    public static GameMouseMotionListener getInstance() {
        return ourInstance;
    }

    private GameMouseMotionListener() {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Controllers.MouseController.getInstance().setCursorLocation("GamePanel",e.getXOnScreen(),e.getYOnScreen());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Controllers.MouseController.getInstance().setCursorLocation("GamePanel",e.getXOnScreen(),e.getYOnScreen());
        if (GamePanel.paused){
            System.out.println("hey");
            System.out.println(e.getX() + " " + e.getY());
            if (PauseFrame.getInstance().resumeRectangle.inside(new Location(e.getX(),e.getY()))){
                insideResume = true;
            }else{
                insideResume = false;
            }
        }

    }
}
