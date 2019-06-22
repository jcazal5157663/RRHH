package Adapter;

import clases.atajoTeclado;
import java.awt.event.KeyEvent;

public class jInternalFrameAdapter extends javax.swing.JInternalFrame {

    public jInternalFrameAdapter() {
        SalirEscape();
    }

    private void SalirEscape() {
        new atajoTeclado(this, KeyEvent.VK_ESCAPE) {
            @Override
            public void Metodo() {
                dispose();
            }
        };
    }

}
