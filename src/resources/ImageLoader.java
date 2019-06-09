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
            hashMap.put("RedBullet2",ImageIO.read(new File("src/resources/red2.png")));
            hashMap.put("red_powerUp",ImageIO.read(new File("src/resources/RedBox.png")));
            hashMap.put("LogoName",ImageIO.read(new File("src/resources/Ci5logo.png")));
            hashMap.put("lower_bar",ImageIO.read(new File("src/resources/bar.png")).getScaledInstance(460/3*2,90/3*2,Image.SCALE_AREA_AVERAGING));
            hashMap.put("OK",ImageIO.read(new File("src/resources/OK.png")));
            hashMap.put("missile",ImageIO.read(new File("src/resources/missile.png")));
            hashMap.put("choose_menu",ImageIO.read(new File("src/resources/choose_menu.jpg")).getScaledInstance(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height,Image.SCALE_AREA_AVERAGING));
            hashMap.put("chicken",ImageIO.read(new File("src/resources/BigChickenRed.png")).getScaledInstance(310/2,261/2,Image.SCALE_AREA_AVERAGING));
            hashMap.put("randomBird",ImageIO.read(new File("src/resources/randomBird.png")).getScaledInstance(545/3,454/3,Image.SCALE_AREA_AVERAGING));
            hashMap.put("morghePile",ImageIO.read(new File("src/resources/morghePile.png")).getScaledInstance(556/3,559/3,Image.SCALE_AREA_AVERAGING));
            hashMap.put("HP",ImageIO.read(new File("src/resources/hp_bar.png")).getScaledInstance(429/2,185,Image.SCALE_AREA_AVERAGING));
            hashMap.put("HP2",ImageIO.read(new File("src/resources/hp_bar2.png")).getScaledInstance(429/2,185,Image.SCALE_AREA_AVERAGING));
            hashMap.put("HP3",ImageIO.read(new File("src/resources/hp_bar3.png")).getScaledInstance(429/2,185,Image.SCALE_AREA_AVERAGING));
            hashMap.put("HP_BIG",ImageIO.read(new File("src/resources/hp_bar2.png")).getScaledInstance(429*3,185,Image.SCALE_AREA_AVERAGING));
            hashMap.put("firstLayer",ImageIO.read(new File("src/Animations/BeCareful/firstLayer.png")).getScaledInstance(429/2,185,Image.SCALE_AREA_AVERAGING));
            for (int i = 1 ; i <= 11 ; i ++){
                hashMap.put("layer" + i ,ImageIO.read(new File("src/Animations/BeCareful/layer" + i + ".png")).getScaledInstance(429/2,185,Image.SCALE_AREA_AVERAGING));
            }
            hashMap.put("resume",ImageIO.read(new File("src/Animations/Resume/resuming.png")).getScaledInstance(2100/4,1500/4,Image.SCALE_AREA_AVERAGING));
            hashMap.put("bandage",ImageIO.read(new File("src/resources/bandage.png")).getScaledInstance(260/20,280/20,Image.SCALE_AREA_AVERAGING));
            hashMap.put("resume_button",ImageIO.read(new File("src/resources/resume.png")).getScaledInstance(485/2,90/2,Image.SCALE_AREA_AVERAGING));
            hashMap.put("frame",ImageIO.read(new File("src/resources/frame.png")).getScaledInstance(828/2,426/2,Image.SCALE_AREA_AVERAGING));
            hashMap.put("quit_button",ImageIO.read(new File("src/resources/quit.png")).getScaledInstance(485/2,90/2,Image.SCALE_AREA_AVERAGING));
            hashMap.put("upper_left",ImageIO.read(new File("src/resources/upper_left.png")));
            hashMap.put("upper_left2",ImageIO.read(new File("src/resources/upper_left2.png")));
            hashMap.put("box1",ImageIO.read(new File("src/resources/box1.png")));
            hashMap.put("box2",ImageIO.read(new File("src/resources/box2.png")));
            for (int i = 1 ; i <= 16 ; i ++){
                hashMap.put("heat" + (i - 1),ImageIO.read(new File("src/resources/heat/" + i + ".png")));
            }
            hashMap.put("small_exp",ImageIO.read(new File("src/resources/explosion.png")));

        }
        catch (Exception e){e.printStackTrace();}
    }
    public static Image getImage(String imageName){
        return hashMap.get(imageName);
    }
}
