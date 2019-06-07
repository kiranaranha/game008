/**
 * Created by h205p2 on 2/5/16.
 */

import java.awt.event.*;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player {
    int x = 250;
    int y = 600;
    int xa = 0;
    int ya = 0;
    int width = 100;
    int height = 20;

    public Player() {
    }

    public void move() {
        x = x + xa;
        //y = y + ya;
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, y, width,height);
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            xa = -2;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            xa = 2;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            ya = -2;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            ya = 2;
        }
    }
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            xa = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            xa = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            ya = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            ya = 0;
        }
    }

    public Rectangle getRectangle(){
        return new Rectangle(x,y,width,height);
    }

}