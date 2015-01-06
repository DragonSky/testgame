/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitennis;

import java.awt.Graphics2D;

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

    public void paint(Graphics2D g2d) {
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
        for (Bird bird : object_list.contents()) {
            if (bird != this) {
                if (bird.collides_with(this)) {
                    if (bird.collides_with_x(this)) {
                        //System.out.println("x_collision");
                        xa = xa * -1;
                    }

                    if (bird.collides_with_y(this)) {
                        ya = ya * -1;
                    }
                }
            }
        }

        loc_x = (this.loc_x + (1.0 * xa));
        //System.out.println("loc_x: " + loc_x );
        loc_y = (this.loc_y + (1.0 * ya));
        //System.out.println("loc_y: " + loc_y );
    }

    private boolean collides_with(Bird other_bird) {

        return this.loc_x < other_bird.loc_x + other_bird.size_x
                && this.loc_x + this.size_x > other_bird.loc_x
                && this.loc_y < other_bird.loc_y + other_bird.size_y
                && this.size_y + this.loc_y > other_bird.loc_y;
        }

    private boolean collides_with_x(Bird that) {
        return true;
        //return this.loc_x < that.loc_x && this.loc_x + this.size_x > that.loc_x;
                
    }

    private boolean collides_with_y(Bird other_bird) {
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.loc_x) ^ (Double.doubleToLongBits(this.loc_x) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.loc_y) ^ (Double.doubleToLongBits(this.loc_y) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.xa) ^ (Double.doubleToLongBits(this.xa) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.ya) ^ (Double.doubleToLongBits(this.ya) >>> 32));
        hash = 79 * hash + this.size_x;
        hash = 79 * hash + this.size_y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bird other = (Bird) obj;
        if (Double.doubleToLongBits(this.loc_x) != Double.doubleToLongBits(other.loc_x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.loc_y) != Double.doubleToLongBits(other.loc_y)) {
            return false;
        }
        if (Double.doubleToLongBits(this.xa) != Double.doubleToLongBits(other.xa)) {
            return false;
        }
        if (Double.doubleToLongBits(this.ya) != Double.doubleToLongBits(other.ya)) {
            return false;
        }
        if (this.size_x != other.size_x) {
            return false;
        }
        if (this.size_y != other.size_y) {
            return false;
        }
        return true;
    }

}
