/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.event.ActionListener;
import javax.swing.JDialog;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.KeyStroke;

/**
 *
 * @author CAZAL
 */
public class Cerrar_Escape {

    public void addEscapeListener(final JDialog dialog) {
        ActionListener escListener = (ActionEvent e) -> {
            dialog.setVisible(false);
        };
        dialog.getRootPane().registerKeyboardAction(escListener,
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_IN_FOCUSED_WINDOW);
    }
    public void addEscapeListener(final JInternalFrame dialog) {
        ActionListener escListener = (ActionEvent e) -> {
            dialog.setVisible(false);
        };
        dialog.getRootPane().registerKeyboardAction(escListener,
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_IN_FOCUSED_WINDOW);
    }
    public void abrir_atajos_F1(final JDialog dialog) {
        dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "Cancel"); //$NON-NLS-1$
        dialog.getRootPane().getActionMap().put("Cancel", new AbstractAction() { //$NON-NLS-1$
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);
            }
        });
    }

    public void abrir_atajos_F2(final JDialog dialog) {
        dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "Cancel"); //$NON-NLS-1$
        dialog.getRootPane().getActionMap().put("Cancel", new AbstractAction() { //$NON-NLS-1$
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);
            }
        });
    }

    public void abrir_atajos_F3(final JDialog dialog) {
        dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0), "Cancel"); //$NON-NLS-1$
        dialog.getRootPane().getActionMap().put("Cancel", new AbstractAction() { //$NON-NLS-1$
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);
            }
        });
    }

    public void abrir_atajos_F4(final JDialog dialog) {
        dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0), "Cancel"); //$NON-NLS-1$
        dialog.getRootPane().getActionMap().put("Cancel", new AbstractAction() { //$NON-NLS-1$
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);
            }
        });
    }

    public void abrir_atajos_F5(final JDialog dialog) {
        dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0), "Cancel"); //$NON-NLS-1$
        dialog.getRootPane().getActionMap().put("Cancel", new AbstractAction() { //$NON-NLS-1$
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);
            }
        });
    }

    public void abrir_atajos_F6(final JDialog dialog) {
        dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0), "Cancel"); //$NON-NLS-1$
        dialog.getRootPane().getActionMap().put("Cancel", new AbstractAction() { //$NON-NLS-1$
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);
            }
        });
    }

    public void abrir_atajos_F7(final JDialog dialog) {
        dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0), "Cancel"); //$NON-NLS-1$
        dialog.getRootPane().getActionMap().put("Cancel", new AbstractAction() { //$NON-NLS-1$
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);
            }
        });
    }

    public void abrir_atajos_F8(final JDialog dialog) {
        dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0), "Cancel"); //$NON-NLS-1$
        dialog.getRootPane().getActionMap().put("Cancel", new AbstractAction() { //$NON-NLS-1$
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);
            }
        });
    }

    public void abrir_atajos_F9(final JDialog dialog) {
        dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0), "Cancel"); //$NON-NLS-1$
        dialog.getRootPane().getActionMap().put("Cancel", new AbstractAction() { //$NON-NLS-1$
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);
            }
        });
    }

    public void abrir_atajos_F10(final JDialog dialog) {
        dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0), "Cancel"); //$NON-NLS-1$
        dialog.getRootPane().getActionMap().put("Cancel", new AbstractAction() { //$NON-NLS-1$
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);
            }
        });
    }

    public void abrir_atajos_F11(final JDialog dialog) {
        dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0), "Cancel"); //$NON-NLS-1$
        dialog.getRootPane().getActionMap().put("Cancel", new AbstractAction() { //$NON-NLS-1$
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);
            }
        });
    }

    public void abrir_atajos_F12(final JDialog dialog) {
        dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0), "Cancel"); //$NON-NLS-1$
        dialog.getRootPane().getActionMap().put("Cancel", new AbstractAction() { //$NON-NLS-1$
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);
            }
        });
    }

    public void abrir_atajos_F2(boolean modal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
