/*
Esta clase sirve para realizar atajos de teclado en los tres tipos de Ventana
Jdialog
JInternalFrame
JFrame

el mismo utiliza una clase Abstracta que se llama Metodo, el cual ayuda a que se pueda definir funciones
al momento de llamar dicha clase.

el constructor recibe dos parametros, uno es el tipo de Ventana y Otro es un numero entero el cual indica
el codigo de teclado con el cual sera ejecutado el metodo abstracto.

Example:
La Forma de llamar a esta clase y usar el metodo es de la sgte Forma:
    
        new atajoTeclado(this, KeyEvent.VK_F1) {
            @Override
            public void Metodo() {
                operacion = 1;
                modal.setLocationRelativeTo(null);
                modal.setVisible(true);
            }
        };

Derechos de José Cazal
 */
package clases;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.KeyStroke;

public abstract class atajoTeclado {

    public atajoTeclado(final JDialog dialog, int teclado) {
        dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(teclado, 0), "Atajo"); //$NON-NLS-1$
        dialog.getRootPane().getActionMap().put("Atajo", new AbstractAction() { //$NON-NLS-1$
            @Override
            public void actionPerformed(ActionEvent e) {
                Metodo();
            }
        });
    }

    public atajoTeclado(final JInternalFrame dialog, int teclado) {
        dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(teclado, 0), "Atajo"); //$NON-NLS-1$
        dialog.getRootPane().getActionMap().put("Atajo", new AbstractAction() { //$NON-NLS-1$
            @Override
            public void actionPerformed(ActionEvent e) {
                Metodo();
            }
        });
    }

    public atajoTeclado(final JFrame dialog, int teclado) {
        dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(teclado, 0), "Atajo"); //$NON-NLS-1$
        dialog.getRootPane().getActionMap().put("Atajo", new AbstractAction() { //$NON-NLS-1$
            @Override
            public void actionPerformed(ActionEvent e) {
                Metodo();
            }
        });
    }

    public abstract void Metodo();

}
