package dodgyBirdy;

import javax.swing.JFrame;

public class Main{


    public static void main(String args[]){
        JFrame frame = new JFrame();

        frame.add(new GamePanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Obstacle Course");
    }
}
