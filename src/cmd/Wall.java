package cmd;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kaval on 19.05.2017.
 */
public class Wall {
    Image img = new ImageIcon("png/wall2.png").getImage();
    int x =80;
    int y =0;
    public Rectangle getRect(){
        return new Rectangle(x, y, 57, 899);
    }
}
