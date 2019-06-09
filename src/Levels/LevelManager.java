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


    public void update(){
        if (currentLevel.levelFinished() && currentLevel.nextLevel != null){
            if(!currentLevel.markFinished) {
                currentLevel.levelFinishedTime = System.currentTimeMillis();
                currentLevel.markFinished = true;
            }

            if (System.currentTimeMillis()-currentLevel.levelFinishedTime > 5000) {
                currentLevel = currentLevel.nextLevel;
                currentLevel.markFinished= false;

            }
        }
    }
}
