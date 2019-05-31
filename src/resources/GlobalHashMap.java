package resources;

import menus.*;

import java.util.HashMap;

public class GlobalHashMap {
    private static GlobalHashMap ourInstance = new GlobalHashMap();

    public static GlobalHashMap getInstance() {
        return ourInstance;
    }

    public HashMap<String, Panel> panelHashMap = new HashMap<>();

    private GlobalHashMap() {

        panelHashMap.put("GamePanel", GamePanel.getInstance());
        panelHashMap.put("PlayerMenu", PlayerMenu.getInstance());
        panelHashMap.put("choose_menu", ChoosePlayerMenu.getInstance());
        panelHashMap.put("FullSizePanel",new FullSizePanel());
        panelHashMap.put("LoadPanel",LoadPanel.getInstance());

    }

}
