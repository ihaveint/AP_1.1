import menus.FullSizeFrame;
import menus.GameFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GameFrame main_window = GameFrame.getInstance();
//        main_window.setCurrentPanel("PlayerMenu");
        main_window.start();

    }
}
