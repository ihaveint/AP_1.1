package Levels;

import java.util.ArrayList;

public class Level {
    Level nextLevel = null;
    String displayName ;
    int levelId;
    static int levelCounter = 0;
    static ArrayList<Level> levelsInstances = new ArrayList<>();
    public Level() {
        levelCounter++;
        levelId = levelCounter;

        displayName = "Level " + levelId;
        if (levelsInstances.size() > 0) {
            levelsInstances.get(levelsInstances.size() - 1).nextLevel = this;
        }
        levelsInstances.add(this);
    }
    

}
