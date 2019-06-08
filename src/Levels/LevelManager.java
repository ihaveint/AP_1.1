package Levels;

public class LevelManager {
    private static LevelManager ourInstance = new LevelManager();

    public static LevelManager getInstance() {
        return ourInstance;
    }


    private LevelManager() {

    }
}
