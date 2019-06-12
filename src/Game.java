
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sun.audio.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


@SuppressWarnings("serial")
public class Game extends JPanel {
    Player player = new Player(this);
    public static ArrayList<Ball> balls= new ArrayList<Ball>();
    public static int count;
    Image bg = new ImageIcon("/Users/kiran/IdeaProjects/game008/images/piib22keeih11.png").getImage();


    public Game() {

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
                player.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                player.keyPressed(e);
            }
        });
        setFocusable(true);
    }

    public void move() {
        if(balls.size()>0) {
            for (Ball x : balls) {
                x.move();
            }
        }
        player.move();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(bg, 0, 0, null);
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(bg, 0, 0, null);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);
        for(Ball x : balls){
            x.paint(g2d);
        }
        g2d.setColor(Color.YELLOW);
        player.paint(g2d);
        g2d.drawString("Time:"+count/100,20,20);

    }


    public static void addBall(Game game, int count){
        int side = (int)(Math.random() * (4 - 1) + 1);
        int startx=0;
        int starty=0;
        int xa= 1;
        int ya =1;
        if(side==1){
            startx =0;
            starty = (int)(Math.random() * (game.getHeight()));
        }
        else if(side==2){
            starty =-10;
            startx = (int)(Math.random() * (game.getWidth()));
        }
        else if(side==3){
            startx =game.getWidth();
            starty = (int)(Math.random() * (game.getHeight()));
        }
        else if(side==4){
            starty =game.getHeight();
            startx = (int)(Math.random() * (game.getWidth()));
        }
        if(count==0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            startx=0;
            starty=0;
        }
        if(count%2==0){
            xa=1;
            ya=1;
        }
        else if(count%2==1){
            xa =2;
            ya=2;
        }

        balls.add(new Ball(game,startx,starty,xa,ya));

    }
    public void gameOver() {
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }
}