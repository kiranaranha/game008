import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Player {
    int x = 350;
    int xa = 0;
    int y= 350;
    int ya=0;
    int width = 45;
    int height = 45;
    int boost = 1;
    boolean right = false;
    boolean left = false;
    boolean up = false;
    boolean down = false;
    private Game game;
    private Image img = new ImageIcon("images/1519887564269.png").getImage();


    public Player(Game game) {
        this.game= game;
    }

    public void move() {
        if (x + xa > 0 && x + xa < game.getWidth()-10) {
            x = x + xa*boost;
        }
        if (y + ya > 0 && y + ya < game.getHeight()-10) {
            y = y + ya*boost;
        }

    }

    public void paint(Graphics2D g) {
        g.drawImage(img, x, y, null);

    }


    public void keyPressed(KeyEvent e) { // Movement controls
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            xa = -2;
            left = true;

        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            xa = 2;
            right = true;

        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            ya = 2;
            down = true;

        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            ya = -2;
            up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            //Boost modifies the move method and causes the player to move faster while the spacebar is held
            boost=2;
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            /*You may notice this new stuff such as the booleans "left" and "right". In the previous game,
             * if we released the left or right arrow key while another one was held our character would just
             * completely stop when it should have gone back to the original movement. These if statements
             * make it work now. Try holding the right arrow key, pressing the left one, and then releasing the
             * left one. You should now move right again instead of just stopping as you would in the other game.*/
            left = false;
            if(!right) {
                xa = 0;
            }
            else if(right){
                xa = 2;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = false;
            if(!left) {
                xa = 0;
            }
            else if(left){
                xa = -2;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = false;
            if(!up) {
                ya = 0;
            }
            else if(up){
                ya = -2;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            up = false;
            if(!down) {
                ya = 0;
            }
            else if(down){
                ya = 2;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            boost=1;

        }
    }


    public Rectangle getBounds() {
        //Called by the ball class to detect if a ball collides with the player
        return new Rectangle(x+9, y, width, height);
    }
}