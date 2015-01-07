/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitennis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author stewartpj
 */
@SuppressWarnings("serial")
public class Game extends JPanel {

    static int CANVAS_SIZE_X = 600;
    static int CANVAS_SIZE_Y = 600;
    static int OBJECT_1_SIZE_X = 30;
    static int OBJECT_1_SIZE_Y = 30;

    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;

    Birds birdcage = new Birds();
    

    public Game() {
        birdcage.add(new Bird(200, 200, 0, 0, 100, 100));
        birdcage.add(new Bird(300, 250, 2, 0, 15, 15));
        birdcage.add(new Bird(30, 50, 1, 2.2, 15, 15));
        birdcage.add(new Bird(20, 50, 1.2, 2.5, 15, 15));
        birdcage.add(new Bird(10, 50, 1.1, 2.1, 15, 15));
        birdcage.add(new Bird(150, 50, 1.2, 2, 15, 15));
        birdcage.add(new Bird(160, 50, 1.5, 2.5, 15, 15));
    }

    public void moveBall() {
        birdcage.contents().stream().forEach((bird) -> {
            bird.move(this.getWidth(), this.getHeight(), this.birdcage);
        });//        if (x >= (this.getWidth() - (OBJECT_1_SIZE_X)) || x < 0){
//            xa = xa * -1;
//        }
//        if (y >= (this.getHeight() - (OBJECT_1_SIZE_Y)) || y < 0){
//            ya = ya * -1;
//            
//        }
//        x = x + (1 * xa);
//        y = y + (1 * ya);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.red);
        birdcage.contents().stream().forEach((bird) -> {
            bird.paint(g2d);
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mini Tennis");
        Game game = new Game();
        frame.add(game);
        frame.setSize(CANVAS_SIZE_X, CANVAS_SIZE_Y);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            game.moveBall();
            game.repaint();
            try {
                Thread.sleep(10);

            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
