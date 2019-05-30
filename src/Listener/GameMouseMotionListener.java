package Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class GameMouseMotionListener implements MouseMotionListener {
    private static GameMouseMotionListener ourInstance = new GameMouseMotionListener();

    public static GameMouseMotionListener getInstance() {
        return ourInstance;
    }

    private GameMouseMotionListener() {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Controllers.MouseController.getInstance().setCursorLocation("GamePanel",e.getX(),e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Controllers.MouseController.getInstance().setCursorLocation("GamePanel",e.getX(),e.getY());
    }
}
