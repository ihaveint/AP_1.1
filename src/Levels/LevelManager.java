package Levels;

import menus.GamePanel;

public class LevelManager {
    private static LevelManager ourInstance = new LevelManager();

    public static LevelManager getInstance() {
        return ourInstance;
    }

    public Level currentLevel;
    private LevelManager() {
        currentLevel = GamePanel.getInstance().currentLevel;
    }

    public void update(){
        if (currentLevel.levelFinished()){
            currentLevel = currentLevel.nextLevel;
        }
    }
}
