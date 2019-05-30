package resources;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.util.HashMap;

public class ImageLoader {
    public static HashMap<String, Image> hashMap = new HashMap<>();
    private static ImageLoader ourInstance = new ImageLoader();

    public static ImageLoader getInstance() {
        return ourInstance;
    }

    private ImageLoader() {
        try{

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            hashMap.put("BackGround", ImageIO.read(new File("src/resources/BackGround1.png")).getScaledInstance(screenSize.width, screenSize.height,Image.SCALE_AREA_AVERAGING));
            hashMap.put("SpaceShip",ImageIO.read(new File("src/resources/SpaceShip.png")));
            hashMap.put("Mouse",ImageIO.read(new File("src/resources/Mouse.png")));
            hashMap.put("RedBullet",ImageIO.read(new File("src/resources/RedBullet1.png")));
            hashMap.put("LogoName",ImageIO.read(new File("src/resources/Ci5logo.png")));
            hashMap.put("OK",ImageIO.read(new File("src/resources/OK.png")));
            hashMap.put("missile",ImageIO.read(new File("src/resources/missile.png")));
            hashMap.put("choose_menu",ImageIO.read(new File("src/resources/choose_menu.jpg")).getScaledInstance(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height,Image.SCALE_AREA_AVERAGING));
            hashMap.put("chicken",ImageIO.read(new File("src/resources/BigChickenRed.png")).getScaledInstance(310/2,261/2,Image.SCALE_AREA_AVERAGING));
            hashMap.put("HP",ImageIO.read(new File("src/resources/hp_bar.png")));
        }
        catch (Exception e){e.printStackTrace();}
    }
    public static Image getImage(String imageName){
        return hashMap.get(imageName);
    }
}
