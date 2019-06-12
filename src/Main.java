import javax.swing.*;


public class Main {
    public static int count;
    public static int sleeptime =10;

    public static void main(String[] args) throws InterruptedException {


        JFrame frame = new JFrame("Advanced Game");
        Game game = new Game();
        frame.add(game);
        frame.setSize(700, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        count = 0;

        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(sleeptime);
            if(count%500==0){
                game.addBall(game, count/500);
            }
            count++;
            game.count = count;
        }
    }
}