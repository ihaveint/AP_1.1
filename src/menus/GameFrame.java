package menus;

import Listener.GameKeyListener;
import resources.GlobalHashMap;
import resources.Location;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameFrame extends FullSizeFrame implements Runnable{
    private boolean running = false;
    private int fps;
    private Thread thread;
    long startTime = 0;

    private static GameFrame ourInstance = new GameFrame();

    public static GameFrame getInstance() {
        return ourInstance;
    }
//    class loadThread extends Thread{
//        public void run(){
//            currentPanel = LoadPanel.getInstance();
//        }
//    }
    private GameFrame() {
        super();


        PlayerMenu.getInstance().setVisible(false);
        this.getContentPane().add(GlobalHashMap.getInstance().panelHashMap.get("GamePanel"));
        this.getContentPane().add(GlobalHashMap.getInstance().panelHashMap.get("PlayerMenu"));
        this.getContentPane().add(GlobalHashMap.getInstance().panelHashMap.get("choose_menu"));
        this.getContentPane().add(GlobalHashMap.getInstance().panelHashMap.get("LoadPanel"));

        this.getContentPane().add(LoadPanel.getInstance());
        currentPanel = LoadPanel.getInstance();
//        Thread loadThread = new loadThread();
//        loadThread.start();

        this.addKeyListener(GameKeyListener.getInstance());
    }


    public synchronized void start(){
        startTime = System.currentTimeMillis();
        if(running){
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    boolean fl = false;
    boolean fl2 = false;
    @Override
    public void run() {
        long timer = System.currentTimeMillis();
        long lastLoopTime = System.nanoTime();
        final int Target_fps = 100;
        final long Optimal_Time = 1_000_000_000 /Target_fps;
        int frames = 0;

        createBufferStrategy(3);
        BufferStrategy bs = getBufferStrategy();
        Graphics2D g2d = (Graphics2D)bs.getDrawGraphics();
        while (running){



            render(bs);
            long now = System.nanoTime();
            long updateLength = now-lastLoopTime;
            lastLoopTime = now;


            double elapsed = updateLength/((double) Optimal_Time);

            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                fps = frames;
                frames = 0;
            }

            render(bs);
            update(elapsed);



            try {
                Thread.sleep(Math.abs((lastLoopTime-System.nanoTime())+Optimal_Time)/1_000_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }


    }
    Location test = new Location(40,40);
    public void render(BufferStrategy bs){
        do {
            do {

                Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();

                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                if (fl2 == false){

                    GlobalHashMap.getInstance().panelHashMap.get("GamePanel").setVisible(true);
                    GamePanel.getInstance().paintComponent(g2d);
                    GlobalHashMap.getInstance().panelHashMap.get("PlayerMenu").setVisible(true);
                    PlayerMenu.getInstance().paintComponent(g2d);
                    GlobalHashMap.getInstance().panelHashMap.get("choose_menu").setVisible(true);
                    ChoosePlayerMenu.getInstance().paintComponent(g2d);
                    GlobalHashMap.getInstance().panelHashMap.get("PlayerMenu").setVisible(false);
                    GlobalHashMap.getInstance().panelHashMap.get("choose_menu").setVisible(false);
                    GlobalHashMap.getInstance().panelHashMap.get("GamePanel").setVisible(false);
                    fl2 = true;
                }
                if (System.currentTimeMillis()-startTime >= 5000 && !fl ){
                    GlobalHashMap.getInstance().panelHashMap.get("choose_menu").setVisible(true);
                    setCurrentPanel("choose_menu");
                    fl = true;
                }


                getInstance().paintComponents(g2d);


                g2d.dispose();

            } while (bs.contentsRestored());
            bs.show();
        }while (bs.contentsLost());
    }

    public void update(double elapsed){

//        test.x += 20;


    }

}
