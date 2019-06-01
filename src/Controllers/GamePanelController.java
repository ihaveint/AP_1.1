package Controllers;

import Listener.GameMouseMotionListener;
import gameObjects.Missile;
import gameObjects.Rectangle;
import gameObjects.SampleBird;
import gameObjects.shoot;
import menus.GameFrame;
import menus.GamePanel;
import menus.PauseFrame;
import menus.PlayerMenu;

public class GamePanelController {
    private static GamePanelController ourInstance = new GamePanelController();

    public static GamePanelController getInstance() {
        return ourInstance;
    }

    private GamePanelController() {
    }

    public static void shakeScreen() {
        for (SampleBird sampleBird : GamePanel.sampleBirds) {
            if (!sampleBird.died)
                sampleBird.shake();
        }
//        GamePanel.testBird.shake();
    }

    public void repaintPanel(){

        //GamePanel.getInstance().repaint();
    }

    public void newShoot(int x , int y) {
        GamePanel.shoots.add(new shoot(x , y));
    }

    public void newMissile(int x, int y) {
        GamePanel.missiles.add(new Missile(x,y));
    }

    public void MoveBackToPlayerMenu() {
        GameFrame.getInstance().setCurrentPanel("PlayerMenu");

//        PlayerMenu.getInstance().requestFocus();
//        PlayerMenu.getInstance().requestFocusInWindow();
//        PlayerMenu.getInstance().removeMouseMotionListener(GameMouseMotionListener.getInstance());
//        PlayerMenu.getInstance().addMouseMotionListener(GameMouseMotionListener.getInstance());
    }
}
