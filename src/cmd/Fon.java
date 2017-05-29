package cmd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by kaval on 19.05.2017.
 */
public class Fon extends JPanel implements ActionListener, Runnable {
    int live = 20;

    Timer mainTimer = new Timer(20, this);

    Image img = new ImageIcon("png/grass.jpg").getImage();

    Player p = new Player();

    Wall w = new Wall();

    Thread enemiesSpawn = new Thread(this);

    List<Enemy> enemies = new ArrayList<Enemy>();

    public Fon(){
        mainTimer.start();
        enemiesSpawn.start();
        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
    }

    @Override
    public void run() {
        while(true){
            Random rndm = new Random();
            try {
                Thread.sleep(rndm.nextInt(2000));
                enemies.add(new Enemy(700, rndm.nextInt(530), rndm.nextInt(10)+1,this));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private class MyKeyAdapter extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            p.keyPressed(e);
        }
        public void keyReleased(KeyEvent e){
            p.keyReleased(e);
        }
    }
    public void paint(Graphics g){
        g = (Graphics2D) g;
        g.drawImage(img,0,0,null);
        g.drawImage(p.img,p.x,p.y,null);
        g.drawImage(w.img,w.x,w.y,null);


        g.setColor(Color.WHITE);
        Font font = new Font("Arial", Font.ITALIC, 20);
        g.setFont(font);
        g.drawString("HP"+live,20,30);

        Iterator<Enemy> i = enemies.iterator();
        while(i.hasNext()){
            Enemy e = i.next();
            if (e.x >= 1400 || e.x <= -1400){
                i.remove();
            } else {
                e.move();
                g.drawImage(e.img,e.x,e.y,null);
            }
        }
    }
    public void actionPerformed(ActionEvent e){
        p.move();
        repaint();
        CollisionWithWall();
    }
    private void CollisionWithWall(){
        Iterator<Enemy> i = enemies.iterator();
        while (i.hasNext()){
            Enemy e = i.next();
            if (w.getRect().intersects(e.getRect())){
                i.remove();
                if (live<=0){

                }else live-=1;
            }
        }
    }
    private void win(){

    }
}
