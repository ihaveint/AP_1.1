package Controllers;

import gameObjects.shoot;
import menus.GamePanel;

public class GamePanelController {
    private static GamePanelController ourInstance = new GamePanelController();

    public static GamePanelController getInstance() {
        return ourInstance;
    }

    private GamePanelController() {
    }
    public void repaintPanel(){

        //GamePanel.getInstance().repaint();
    }

    public void newShoot(int x , int y) {
        GamePanel.shoots.add(new shoot(x , y));
    }

}
