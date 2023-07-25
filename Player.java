package dodgyBirdy.entitys;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import dodgyBirdy.GamePanel;
import dodgyBirdy.KeyHandler;
 
public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;
    boolean jumping = false;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getImages();
    }
    
    public void setDefaultValues(){
        x = 20;
        y = 150;
        velocity =  10;
        skin = 0;
        action = "walking";
    }

    public void getImages(){
        try{
            walk1 = ImageIO.read(getClass().getResourceAsStream("../graphics/player_walk1.png"));
            walk2 = ImageIO.read(getClass().getResourceAsStream("../graphics/player_walk2.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update(){

        if(skin >= 1){
            skin = 0;
        }

        skin++;

        if(keyH.jump){
            jumping = true;
        }

        if(jumping){
            y -= velocity;
            velocity--;
        }
        if(y >= 150){
            velocity = 11;
            jumping = false;
        }
        
    }

    public void draw(Graphics2D g2){
        BufferedImage image = null;

        switch(action){
            case "jump":
                break;
            
            case "walking":
                image = walk1;
                break;

        
        }

        switch(skin){
            case 0:
                image = walk1;
                break;
            case 1:
                image = walk2;
                break;
        }

        g2.drawImage(image, x, y, 30, 30,null);
    }



    




}
