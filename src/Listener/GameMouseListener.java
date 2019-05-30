package Listener;

import Controllers.MouseController;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameMouseListener implements MouseListener {
    private static GameMouseListener ourInstance = new GameMouseListener();

    public static GameMouseListener getInstance() {
        return ourInstance;
    }

    private GameMouseListener() {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        MouseController.mousePressed(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        MouseController.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
