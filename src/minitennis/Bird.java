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

    Bird() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public void move(int width, int height) {
        if ((loc_x >= (width - this.size_x)) || (loc_x <= 0)){
            xa = xa * -1;
            
            
        }
        if ((loc_y >= (height - this.size_y)) || (loc_y <= 0)){
            ya = ya * -1;
        }
        
        loc_x = (this.loc_x + (1.0 * xa));
        //System.out.println("loc_x: " + loc_x );
        loc_y =  (this.loc_y+ (1.0 * ya));
        //System.out.println("loc_y: " + loc_y );
    }

    /**
     * @return the loc_x
     */
    public int getLoc_x() {
        return (int)loc_x;
    }

    /**
     * @return the loc_y
     */
    public int getLoc_y() {
        return (int)loc_y;
    }
            
}        
//        if (loc_x >= (width - size_x) || loc_x <= 0) {
//            xa = xa * -1.0;
//            System.out.println("bounceX");
//            if(loc_x < 0 ){
//                loc_x = 0;
//            }
//        }
//        if (loc_y >= (height - size_y) || loc_y <= 0) {
//            ya = ya * -1.0;
//            System.out.println("bounceY");
//            if(loc_y < 0 ){
//                loc_y = 0;
//            }
//
//        }
//        loc_x = (int) (loc_x + (1.0 * xa));
//        loc_y = (int) (loc_y + (1.0 * ya));
//    }
