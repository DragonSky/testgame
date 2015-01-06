/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitennis;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stewartpj
 */
public class Bird {

    private double loc_x;
    private double loc_y;
    private double xa;
    private double ya;
    public int size_x;
    public int size_y;

    Bird(double loc_x, double loc_y, double xa, double ya, int size_x, int size_y) {
        this.loc_x = loc_x;
        this.loc_y = loc_y;
        this.xa = xa;
        this.ya = ya;
        this.size_x = size_x;
        this.size_y = size_y;
    }

    public void paint(Graphics2D g2d){
        g2d.fillOval(this.getLoc_x(), this.getLoc_y(), this.size_x, this.size_y);
    }
    public void move(int window_width, int window_height, Birds object_list) {
        // Check for collision with window frame
        if ((loc_x >= (window_width - this.size_x)) || (loc_x <= 0)) {
            xa = xa * -1;
            if (loc_x < 0) {
                loc_x = 0;
            } else if (loc_x > (window_width - this.size_x)) {
                loc_x = (window_width - this.size_x);
            }

        }
        if ((loc_y >= (window_height - this.size_y)) || (loc_y <= 0)) {
            ya = ya * -1;
            if (loc_y < 0) {
                loc_y = 0;
            }
            if (loc_y > (window_height - this.size_y)) {
                loc_y = (window_height - this.size_y);
            }
        }

        // Check for collision with other objects
        
        
        
        
        
        
        loc_x = (this.loc_x + (1.0 * xa));
        //System.out.println("loc_x: " + loc_x );
        loc_y = (this.loc_y + (1.0 * ya));
        //System.out.println("loc_y: " + loc_y );
    }

    /**
     * @return the loc_x
     */
    public int getLoc_x() {
        return (int) loc_x;
    }

    /**
     * @return the loc_y
     */
    public int getLoc_y() {
        return (int) loc_y;
    }

}