import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements /* ActionListener, */Runnable{
    static final public int tileSize = 48;

    private static int screenRowCound = 16;
    private static int screenColCount = 21;

    public final static  int windWidth = tileSize * screenColCount;
    public final static  int windHeight = tileSize * screenRowCound;

    public final static int worldscreenRowCount = 44;
    public final static int worldscreenColCount = 60;
    
    public final static int worldHeight = tileSize * worldscreenRowCount;
    public final static int worldWidth = tileSize * worldscreenColCount;
    
    WorldMap worldMap = WorldMap.getInstance();
    public static CollisionDetector cosDec = CollisionDetector.getInstance();

    public static KeyHandler keyHandler = new KeyHandler();
    Thread  gameThread;
    int FPS =60;
    public static Player player = new Player(keyHandler);

    GamePanel() {
        setPreferredSize(new Dimension(windWidth,windHeight));
        setBackground(Color.BLACK);

        this.addKeyListener(keyHandler);
        this.setFocusable(true);
        this.setDoubleBuffered(true); // all drawing will be done offscreen the screen
    }
    public void StartGameThread()
    {
        // starting a thread so we can make time
        gameThread = new Thread(this);
        gameThread.start();
    }
        //Runnable Interface
        @Override
    public void run() {
        double drawInterval =1000000000/FPS; // draw screen every 1/60 second 
        double deltaTime = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer=0;
        int frames = 0;
        // ass long gameThread is exist repeat block
        while(gameThread !=null){
            currentTime = System.nanoTime();
            deltaTime += (currentTime - lastTime)/drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (deltaTime >= 1) {
                // update info charchters pos 
                update();
                // draw screen with unpdated info
                repaint();
                deltaTime--;
                frames++;
            }
            if (timer >= 1000000000) {
                System.out.println("FPS: "+frames);
                // System.out.println();
                timer = 0;
                frames = 0;
            }
        }
        }
    public void update(){   
        player.update();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);

        worldMap.mapDraw(g2);
        player.draw(g2);
        g2.dispose();// release memory
    }

}
