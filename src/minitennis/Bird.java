/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitennis;

/**
 *
 * @author stewartpj
 */
public class Bird {
        private int loc_x;
        private int loc_y;
        private int xa;
        private int ya;
        private int size_x;
        private int size_y;

   
        Bird(int loc_x, int loc_y, int xa, int ya, int size_x, int size_y) {
            this.loc_x = loc_x;
            this.loc_y = loc_y;
            this.xa = xa;
            this.ya = ya;
            this.size_x = size_x;
            this.size_y = size_y;
        }
    

    public void move(int width, int height) {
        if (loc_x >= (width - size_x) || loc_x < 0) {
            xa = xa * -1;
        }
        if (loc_y >= (height - size_y) || loc_y < 0) {
            ya = ya * -1;

        }
        loc_x = loc_x + (1 * xa);
        loc_y = loc_y + (1 * ya);
    }
}