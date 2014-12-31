/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitennis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.HashSet;
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

    static int CANVAS_SIZE_X = 300;
    static int CANVAS_SIZE_Y = 400;
    static int OBJECT_1_SIZE_X = 30;
    static int OBJECT_1_SIZE_Y = 30;

    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;

    public class Bird {
        private int loc_x;
        private int loc_y;
        private int xa;
        private int ya;
        private int size_x;
        private int size_y;

        public void Bird(int loc_x, int loc_y, int xa, int ya, int size_x, int size_y) {
            this.loc_x = loc_x;
            this.loc_y = loc_y;
            this.xa = xa;
            this.ya = ya;
            this.size_x = size_x;
            this.size_y = size_y;
        }
    

    public void move(int width, int height) {
        if (x >= (width - size_x) || loc_x < 0) {
            xa = xa * -1;
        }
        if (y >= (height - size_y) || loc_y < 0) {
            ya = ya * -1;

        }
        loc_x = loc_x + (1 * xa);
        loc_y = loc_y + (1 * ya);
    }
}

public void moveBall() {
        if (x >= (this.getWidth() - (OBJECT_1_SIZE_X)) || x < 0){
            xa = xa * -1;
        }
        if (y >= (this.getHeight() - (OBJECT_1_SIZE_Y)) || y < 0){
            ya = ya * -1;
            
        }
        x = x + (1 * xa);
        y = y + (1 * ya);

    }

    @Override
        public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.red);
        g2d.fillOval(x, y, OBJECT_1_SIZE_X, OBJECT_1_SIZE_Y);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mini Tennis");
        Game game = new Game();
        frame.add(game);
        frame.setSize(CANVAS_SIZE_X, CANVAS_SIZE_Y);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Bird bird1 = new Bird(0, 0, 1, 1, 30, 30);
        
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
