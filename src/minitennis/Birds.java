/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitennis;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stewartpj
 */
public class Birds {
    private final List<Bird> birdcage;

    public Birds() {
        this.birdcage = new ArrayList<>();
    }
    
    public void add(Bird bird){
        birdcage.add(bird);
    }
    
    public List<Bird> contents(){
        return birdcage;
    }
}
