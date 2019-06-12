import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Ball {
    int x = 0;
    int y = 0;
    int xa = 2;
    int ya = 2;
    int DIAMETER = 27;
    int speed =1;
    private Game game;
    private Image img = new ImageIcon("/Users/kiran/IdeaProjects/game008/images/images.png").getImage();

    public Ball(Game game, int xstart, int ystart,int xa, int ya) {
        /* The reason we have a "Game" argument for the Ball object is so that we can later on call game.getHeight()
         * This makes it so that we can change the dimensions of the game window and not have to go through the code
         * to correct all the values. Before, in the other game, we just manually inputed the game's height for the boundaries.*/
        this.game= game;
        x = xstart;
        y = ystart;
        this.xa = xa;
        this.ya = ya;
        speed = xa;
    }

    void move() {
        if(speed==1) {
            if (x + xa < 0)
                xa = 2;
            if (x + xa > game.getWidth() - 20)
                xa = -2;
            if (y + ya < 0)
                ya = 2;
            if (y + ya > game.getHeight() - 20)
                ya = -2;
        }
        else{
            if (x + xa < 0)
                xa = 3;
            if (x + xa > game.getWidth() - 20)
                xa = -3;
            if (y + ya < 0)
                ya = 3;
            if (y + ya > game.getHeight() - 20)
                ya = -3;
        }
        if (collision())
            game.gameOver();


        x = x + xa;
        y = y + ya;
    }
    private boolean collision() {
        return game.player.getBounds().intersects(getBounds());
    }

    public void paint(Graphics2D g) {
        //g.fillOval(x, y, DIAMETER, DIAMETER);
        g.drawImage(img, x, y, null);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }

}