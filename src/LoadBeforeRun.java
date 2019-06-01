import menus.*;
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

                    while (GamePanel.getInstance().spaceShip.test.currentPercentage <= 1 || GamePanel.getInstance().spaceShip.test.currentLayer <= 12){
                        GamePanel.getInstance().spaceShip.test.draw(g2d);
                        GamePanel.getInstance().spaceShip.test.update();
                    }
                    while (GamePanel.getInstance().resumeAnimation.currentPercentage <= 1 ){
                        GamePanel.getInstance().resumeAnimation.draw(g2d);
                        GamePanel.getInstance().resumeAnimation.update();
                    }
                    GamePanel.getInstance().resumeAnimation.currentPercentage = 0;
                    GamePanel.getInstance().resumeAnimation.currentLayer = 1;
                    GamePanel.getInstance().spaceShip.test.currentPercentage = 0;
                    GamePanel.getInstance().spaceShip.test.currentLayer = 1;
                    GamePanel.getInstance().paintComponent(g2d);
                    GlobalHashMap.getInstance().panelHashMap.get("GamePanel").setVisible(false);
                    GameFrame.getInstance().revalidate();
                    GlobalHashMap.getInstance().panelHashMap.get("PlayerMenu").setVisible(true);
                    PlayerMenu.getInstance().paintComponent(g2d);
                    GlobalHashMap.getInstance().panelHashMap.get("PlayerMenu").setVisible(false);
                    GameFrame.getInstance().revalidate();
                    GlobalHashMap.getInstance().panelHashMap.get("choose_menu").setVisible(true);
                    ChoosePlayerMenu.getInstance().paintComponent(g2d);
                    GlobalHashMap.getInstance().panelHashMap.get("choose_menu").setVisible(false);


                    GlobalHashMap.getInstance().panelHashMap.get("PlayerMenu").setVisible(true);
                    GameFrame.getInstance().revalidate();



                    g2d.dispose();


            } while (GameFrame.bs.contentsRestored());
            GameFrame.bs.show();

        }while (GameFrame.bs.contentsLost());
    }
}
