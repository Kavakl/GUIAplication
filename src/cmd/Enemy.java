package cmd;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kaval on 19.05.2017.
 */
public class Enemy {
    int x;
    int y;
    int v;
    Image img = new ImageIcon("png/Enemy.png").getImage();
    Fon fon;

    public Rectangle getRect(){
        return new Rectangle(x, y, 51, 53);
    }
    public Enemy(int x, int y, int v, Fon fon){
        this.x=x;
        this.y=y;
        this.v=v;
        this.fon=fon;
    }
    public void move(){
        x -= v;
    }

}
