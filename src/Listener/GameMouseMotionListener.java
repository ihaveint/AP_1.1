package Listener;

import menus.GamePanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import gameObjects.Rectangle;
import menus.PauseFrame;
import resources.Location;

public class GameMouseMotionListener implements MouseMotionListener {
    public static Location mouseLocation = new Location();
    public static boolean insideResume = false;
    public static boolean insideQuit = false;
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
        mouseLocation = new Location(e.getXOnScreen(),e.getYOnScreen());
//        Controllers.MouseController.getInstance().setCursorLocation("GamePanel",e.getXOnScreen(),e.getYOnScreen());
        if (GamePanel.paused){

            if (PauseFrame.getInstance().resumeRectangle.inside(new Location(e.getX(),e.getY()))){
                insideResume = true;
            }else{
                insideResume = false;
            }

            if (PauseFrame.getInstance().quitRectangle.inside(new Location(e.getX(),e.getY()))){
                insideQuit = true;
            }
            else{
                insideQuit = false;
            }
        }

    }
}
