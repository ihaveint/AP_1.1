package Controllers;

import gameObjects.SpaceShip;
import menus.GamePanel;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class KeyController {

    final private long inf = 1000000000;
    private long lastShootMillis = -inf;

    private static HashMap<String, JPanel> hashMap = new HashMap<>();

    private static KeyController ourInstance = new KeyController();

    public static KeyController getInstance() {
        return ourInstance;
    }

    private KeyController() {

    }
    public int getSpaceKey(){
        return KeyEvent.VK_SPACE;
    }
    public int getMissileKey() {return KeyEvent.VK_M;}
    public int getEscapeKey() {return KeyEvent.VK_ESCAPE;}
    public void pressed(int keyCode){
        if (SpaceShip.showResume) return ;
        long now = System.currentTimeMillis();
        long diff = now - lastShootMillis;
        if (keyCode == getSpaceKey()){
            if (diff >= 200){
                GamePanelController.getInstance().newShoot((int)GamePanel.mouseLocation.x,(int)GamePanel.mouseLocation.y);
                lastShootMillis = now;
            }
        }
        else if (keyCode == getMissileKey()){
            GamePanelController.getInstance().newMissile((int)GamePanel.mouseLocation.x,(int)GamePanel.mouseLocation.y);
        }
        else if (keyCode == getEscapeKey()){
//            GamePanel.pause();
            GamePanel.switchState();

        }
    }
}
