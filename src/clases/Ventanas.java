/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Component;
import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author josec
 */
public class Ventanas {

    public Ventanas() {

    }

    public void Abrir_ventana(JDesktopPane escritorio, JInternalFrame ventana, Boolean Quitar_barra_deTitulo) {
        for (Component component : escritorio.getComponents()) {

            if (!component.getClass().getName().equals("javax.swing.JPanel")) {
                escritorio.remove(component);

            }
        }

        if (Quitar_barra_deTitulo) {
            ((javax.swing.plaf.basic.BasicInternalFrameUI) ventana.getUI()).setNorthPane(null);
        }

        if (!ventana.isVisible()) {
            escritorio.add(ventana);

            Dimension desktopSize = escritorio.getSize();
            Dimension FrameSize = ventana.getSize();
            ventana.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            ventana.show();
            try {
                ventana.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Ventanas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
