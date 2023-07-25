package dodgyBirdy.entitys;

import java.awt.Color;
import java.awt.Graphics2D;

import dodgyBirdy.GamePanel;

public class Background extends Entity{

    GamePanel gp;

    public Background(GamePanel gp){
        this.gp = gp;
        setDefaultValues();
    }
    
    

    public void setDefaultValues(){
        x = 0;
        y = 515;
    }

    public void draw(Graphics2D g2){
        drawFloor(g2);
    }

    public void drawFloor(Graphics2D g2){
        g2.setColor(Color.yellow);
        g2.fillRect(x,y,10000000,10000);
    }


}
