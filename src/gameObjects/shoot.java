package gameObjects;

import Controllers.GamePanelController;

import java.awt.*;

public class shoot {
    public int x , y;

    public shoot(int x , int y){
        this.x = x;
        this.y  = y;
    }

    public void update() {
        this.y -= 3;
        if (this.y <= Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2){
            GamePanelController.shakeScreen();

        }
    }
}
