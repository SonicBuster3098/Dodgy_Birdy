package dodgyBirdy.entitys;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import dodgyBirdy.GamePanel;

public class Background extends Entity{

    GamePanel gp;
    BufferedImage image = null;
    int x1, x2, y1, y2;

    public Background(GamePanel gp){
        this.gp = gp;
        setDefaultValues();
        getImages();
    }
    
    public void getImages(){
        try{
            image = ImageIO.read(getClass().getResourceAsStream("../graphics/dB_Sun.png"));
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public void setDefaultValues(){
        x1 = 0;
        x2 = 576;
        y1 = 175;
        y2 = 175;
        
    }

    public void draw(Graphics2D g2){
        drawFloor(g2);
        g2.drawImage(image, 10,10,50,50,null);
    }

    public void drawFloor(Graphics2D g2){
        Color lesserYellow = new Color(251,219,101);
        g2.setColor(Color.yellow);
        g2.fillRect(x1, y1, 576, 1000);
        x1 -= 5;
        g2.setColor(lesserYellow);
        g2.fillRect(x2, y2, 576, 192);
        x2 -= 5;

        if(x1 < 0 - 576){
            x1 = x2 + 576;
        }
        if(x2 < 0 - 576){
            x2 = x1 + 576;
        }

         
    }




}
