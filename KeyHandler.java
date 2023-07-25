package dodgyBirdy;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

    public boolean duck,jump;
  
    

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){

            jump = true;

        }
        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
            duck = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            jump = false;
        }
        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
            duck = false;
            
        }
    }
    
}
