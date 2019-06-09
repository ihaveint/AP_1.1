package Levels;

import menus.GamePanel;

public class LevelManager {
    private static LevelManager ourInstance = new LevelManager();

    public static LevelManager getInstance() {
        return ourInstance;
    }

    public Level currentLevel;
    public Level firstLevel;
    private LevelManager() {
        currentLevel = GamePanel.getInstance().currentLevel;
    }

    long levelFinishedTime = -5000;
    boolean markFinished = false;
    public void update(){
        if (currentLevel.levelFinished() && currentLevel.nextLevel != null){
            if(!markFinished) {
                levelFinishedTime = System.currentTimeMillis();
                markFinished = true;
            }

            if (System.currentTimeMillis()-levelFinishedTime > 5000)
                currentLevel = currentLevel.nextLevel;
        }
    }
}
