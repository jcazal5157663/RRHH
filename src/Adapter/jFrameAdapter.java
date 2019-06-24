package Adapter;

import clases.atajoTeclado;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class jFrameAdapter extends JFrame {

    public jFrameAdapter() {
        Atajos();
    }

    private void Atajos() {
        new atajoTeclado(this, KeyEvent.VK_ESCAPE) {
            @Override
            public void Metodo() {
                dispose();
            }
        };

    }

}
