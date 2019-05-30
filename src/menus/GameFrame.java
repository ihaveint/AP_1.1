package menus;

import Listener.GameKeyListener;
import resources.Location;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameFrame extends FullSizeFrame implements Runnable{
    private boolean running = false;
    private int fps;
    private Thread thread;


    private static GameFrame ourInstance = new GameFrame();

    public static GameFrame getInstance() {
        return ourInstance;
    }

    private GameFrame() {
        super();
        hashMap.put("GamePanel",GamePanel.getInstance());
        hashMap.put("PlayerMenu",PlayerMenu.getInstance());
        PlayerMenu.getInstance().setVisible(false);
        this.getContentPane().add(hashMap.get("GamePanel"));
        this.getContentPane().add(hashMap.get("PlayerMenu"));
        hashMap.get("PlayerMenu").setVisible(false);
        currentPanel =  GamePanel.getInstance();
        this.addKeyListener(GameKeyListener.getInstance());
    }


    public synchronized void start(){
        if(running){
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        long timer = System.currentTimeMillis();
        long lastLoopTime = System.nanoTime();
        final int Target_fps = 100;
        final long Optimal_Time = 1_000_000_000 /Target_fps;
        int frames = 0;

        createBufferStrategy(3);
        BufferStrategy bs = getBufferStrategy();
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



                getInstance().paintComponents(g2d);

//                g2d.setColor(Color.GREEN);
//                g2d.fillOval(test.x,test.y,20,20);



                g2d.dispose();

            } while (bs.contentsRestored());
            bs.show();
        }while (bs.contentsLost());
    }

    public void update(double elapsed){

//        test.x += 20;


    }

}
