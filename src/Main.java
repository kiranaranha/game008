import javax.swing.*;

/**
 * Created by h205p2 on 2/11/16.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();
        Ball ball = new Ball(player);
        Game game = new Game(ball, player);
        JFrame frame = new JFrame("Our Game");
        frame.add(game);
        frame.setSize(700, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(10);
        }
    }
}