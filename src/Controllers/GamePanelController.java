package Controllers;

import Listener.GameMouseMotionListener;
import gameObjects.*;
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

        for (Bird bird : GamePanel.getInstance().currentLevel.final_birds) {
            if (!bird.died)
                bird.shake();
        }
    }

    public static void applyPowerUp(PowerUps powerUp) {
        if (powerUp instanceof RedPowerUp){
            UpgradbleShoot.upgrade();
        }
    }


    public void newShoot(int x , int y) {
//        GamePanel.main.add(new shoot(x , y));
        GamePanel.main_shoots.add(new RedShoot(x , y));
    }

    public void newMissile(int x, int y) {
        if (GamePanel.getInstance().spaceShip.missileCnt ==  0 ) return ;
        GamePanel.getInstance().spaceShip.missileCnt --;
        GamePanel.missiles.add(new Missile(x,y));

    }

    public void MoveBackToPlayerMenu() {
        GameFrame.getInstance().setCurrentPanel("PlayerMenu");
    }
}
