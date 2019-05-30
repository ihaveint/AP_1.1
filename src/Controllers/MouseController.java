package Controllers;

import menus.GamePanel;
import resources.Location;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.HashMap;

public class MouseController {
    private static HashMap<String, JPanel> hashMap = new HashMap<>();
    private static MouseController ourInstance = new MouseController();

    public static MouseController getInstance() {
        return ourInstance;
    }

    private MouseController() {
        hashMap.put("GamePanel", GamePanel.getInstance());
    }

    public void setCursorLocation(String componentName, int x , int y){
        Object component =  hashMap.get(componentName);
        Class<?> someClass = component.getClass();
        Field mouseLocation = null;
        try {
            mouseLocation = someClass.getField("mouseLocation");
            mouseLocation.set(component,new Location(x,y));
            GamePanelController.getInstance().repaintPanel();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
