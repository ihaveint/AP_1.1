package menus;

import gameObjects.HpBar;
import resources.ImageLoader;

import java.awt.*;

public class LoadPanel extends FullSizePanel{
    public HpBar hp = new HpBar();
    private static LoadPanel ourInstance = new LoadPanel();

    public static LoadPanel getInstance() {
        return ourInstance;
    }

    public LoadPanel() {
        super();
        hp.percentage = 0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        hp.draw(g);
        hp.percentage += 0.01;
        hp.percentage = Math.min(1,hp.percentage);

    }
}
