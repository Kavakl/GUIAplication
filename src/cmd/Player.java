package cmd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by kaval on 19.05.2017.
 */
public class Player {
    public static final int MAX_TOP =10;
    public static final int MAX_BOTTOM =500;



    Image img_c = new ImageIcon("png/Archer1.png").getImage();
    Image img_u = new ImageIcon("png/Archer1_u.png").getImage();
    Image img_d = new ImageIcon("png/Archer1_d.png").getImage();
    Image img = img_c;
    int x=30;
    int y=200;
    int dy = 0;
    public Rectangle getRect(){
        return new Rectangle(x, y, 51, 53);
    }
    public void move(){
        y-=dy;
        if (y<= MAX_TOP) y = MAX_TOP;
        if (y>=MAX_BOTTOM) y = MAX_BOTTOM;
    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP){
            dy = 11;
            img = img_u;
        }
        if (key == KeyEvent.VK_DOWN){
            dy = -11;
            img = img_d;
        }
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP||key == KeyEvent.VK_DOWN){
            dy = 0;
            img = img_c;
        }
    }
}

