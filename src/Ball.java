/**
 * Created by h205p2 on 2/8/16.
 */

import java.awt.event.*;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
    int x = 250;
    int y = 20;
    int xa = 2;
    int ya = 2;
    private Player ourPlayer;

    public Ball(Player player){
        ourPlayer = player;
    }

    public void paint(Graphics2D g) {
        g.fillOval(x,y,20,20);
    }
    public void move() {
        checkCollisions();
        x = x + xa;
        y = y + ya;
    }
    public void checkCollisions(){
        if(x == 680 || x == 0){
            xa = -xa;
        }
        if(y == 0){
            ya = -ya;
        }
        if(new Rectangle(x,y,20,20).intersects(ourPlayer.getRectangle())){
            ya = -ya;
        }
        if(y == 690){
            System.exit(0);
        }
    }

}