import menus.ChoosePlayerMenu;
import menus.GameFrame;
import menus.GamePanel;
import menus.PlayerMenu;
import resources.GlobalHashMap;

import java.awt.*;

public class LoadBeforeRun {
    private static LoadBeforeRun ourInstance = new LoadBeforeRun();

    public static LoadBeforeRun getInstance() {
        return ourInstance;
    }

    private LoadBeforeRun() {
        do {
            do {

                    Graphics2D g2d = (Graphics2D) GameFrame.bs.getDrawGraphics();

                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                    GlobalHashMap.getInstance().panelHashMap.get("GamePanel").setVisible(true);
                    GamePanel.getInstance().paintComponent(g2d);
                    GlobalHashMap.getInstance().panelHashMap.get("GamePanel").setVisible(false);
                    GameFrame.getInstance().revalidate();
                    GlobalHashMap.getInstance().panelHashMap.get("PlayerMenu").setVisible(true);
                    PlayerMenu.getInstance().paintComponent(g2d);
                    GlobalHashMap.getInstance().panelHashMap.get("PlayerMenu").setVisible(false);
                    GameFrame.getInstance().revalidate();
                    GlobalHashMap.getInstance().panelHashMap.get("choose_menu").setVisible(true);
                    ChoosePlayerMenu.getInstance().paintComponent(g2d);
                    GlobalHashMap.getInstance().panelHashMap.get("choose_menu").setVisible(true);
                    GameFrame.getInstance().revalidate();



                    g2d.dispose();

            } while (GameFrame.bs.contentsRestored());
            GameFrame.bs.show();
        }while (GameFrame.bs.contentsLost());
    }
}
