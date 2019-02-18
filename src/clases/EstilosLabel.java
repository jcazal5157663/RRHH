package clases;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class EstilosLabel {

    public void CambiarColor(JButton boton, Color entrada, Color Salida) {
        boton.setOpaque(true);
        boton.setFocusable(false);
        boton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(entrada);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(Salida);
            }
        });

        boton.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                boton.setBackground(entrada);
            }

            @Override
            public void focusLost(FocusEvent e) {
                boton.setBackground(Salida);
            }
        });
    }

}
