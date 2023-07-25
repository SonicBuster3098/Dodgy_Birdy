package dodgyBirdy;

import java.awt.*;
import javax.swing.JPanel;

import dodgyBirdy.entitys.Background;
import dodgyBirdy.entitys.Cactus;
import dodgyBirdy.entitys.Player;

public class GamePanel extends JPanel implements Runnable{
    final int orginalTileSize = 16;
    final int scale = 3;

    public final int tileSize = orginalTileSize * scale;
    final int maxScreenCol = 12;
    final int maxScreenRow = 4;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    Thread thread;
    int FPS = 60;
    int score = 0;

    public boolean addedScore = false;

    KeyHandler keyH = new KeyHandler();
    Player player = new Player(this, keyH);
    Background background = new Background(this);
    Cactus cactus = new Cactus(this);


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.setBackground(Color.CYAN);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        startGameThread();

    }

    public void startGameThread(){
        thread = new Thread(this);
        thread.start();
    }

    public void update(){
        player.update();
        cactus.update();

        if(player.x == cactus.x && player.y == cactus.y){
            System.exit(0);
        }
        if(player.x > cactus.x){
            if(!addedScore){
                score++;
                addedScore = true;
            }
        }
    }


    

    public void paintComponent(Graphics g){
        String strScore = Integer.toString(score);

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setFont(new Font("Ink Free", Font.BOLD, 50));
        g2.drawString(strScore, 288, 96);

        background.draw(g2);
        player.draw(g2);
        cactus.draw(g2);

        g2.dispose();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(thread != null){

            repaint();
            update();


            try{
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0){
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;

            }catch(InterruptedException e){
                e.printStackTrace();
            }
            
        }
    }


}