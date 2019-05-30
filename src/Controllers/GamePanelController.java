package Controllers;

import gameObjects.Missile;
import gameObjects.shoot;
import menus.GamePanel;

public class GamePanelController {
    private static GamePanelController ourInstance = new GamePanelController();

    public static GamePanelController getInstance() {
        return ourInstance;
    }

    private GamePanelController() {
    }

    public static void shakeScreen() {
        GamePanel.testBird.shake();
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
}
