
package Adapter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Adapter extends KeyAdapter{

    @Override
    public void keyPressed(KeyEvent e) {
       int letra = e.getKeyChar();
        System.out.println(letra);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        super.keyTyped(e); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e); //To change body of generated methods, choose Tools | Templates.
    }

         
    
    
}
