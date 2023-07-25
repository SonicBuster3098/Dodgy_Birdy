package dodgyBirdy.entitys;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import dodgyBirdy.GamePanel;

public class Cactus extends Entity{

    GamePanel gp;
    BufferedImage image = null;

    public Cactus(GamePanel gp){
        this.gp = gp;
        setDefaultValues();
        getImages();
    }

    public void setDefaultValues(){
        x = 580;
        y = 150;
    }

    public void getImages(){
        try{
            image = ImageIO.read(getClass().getResourceAsStream("../graphics/Cactus.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        g2.drawImage(image, x, y, 30, 30, null);
    }

    public void update(){
        x -= 5;
        if(x <= -30){
            x = 580;
            gp.addedScore = false;
        }
    }
}
