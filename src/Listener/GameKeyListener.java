package Listener;

import Controllers.KeyController;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener {
    private static GameKeyListener ourInstance = new GameKeyListener();

    public static GameKeyListener getInstance() {
        return ourInstance;
    }

    private GameKeyListener() {
    }

    @Override
    public void keyTyped(KeyEvent e) {

        KeyController.getInstance().pressed(e.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        KeyController.getInstance().pressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
