package cmd;

import javax.swing.*;

/**
 * Created by kaval on 19.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        JFrame j = new JFrame("Shooting");
        j.add(new Fon());
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setSize(900,600);
        j.setVisible(true);
    }
}
