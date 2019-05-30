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



        }
        catch (Exception e){e.printStackTrace();}
    }
    public static Image getImage(String imageName){
        return hashMap.get(imageName);
    }
}
