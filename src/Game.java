/**
 * Created by h205p2 on 2/5/16.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JPanel{
    public static Ball theBall;
    public static Player ourplayer;

    public Game(Ball ball, Player player) {
        theBall = ball;
        ourplayer = player;

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
                ourplayer.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                ourplayer.keyPressed(e);
            }
        });
        setFocusable(true);
    }
    public void move(){
        ourplayer.move();
        theBall.move();
    }
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);
        ourplayer.paint(g2d);
        theBall.paint(g2d);
    }
}