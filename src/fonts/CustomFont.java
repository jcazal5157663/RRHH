package fonts;

import java.awt.Font;
import java.io.InputStream;
/**
 * @web http://www.jc-mouse.net
 * @author Mouse
 */
public class CustomFont {

    private Font font = null;

    public CustomFont() {
        String fontName = "seguiemj.ttf" ;
        try {
            //Se carga la fuente
            InputStream is =  getClass().getResourceAsStream(fontName);
            font = Font.createFont(0, is);
        } catch (Exception ex) {
            //Si existe un error se carga fuente por defecto ARIAL
            System.err.println(fontName + " No se cargo la fuente");
            font = new Font("Arial", Font.PLAIN, 14);            
        }
  }

    /* Font.PLAIN = 0 , Font.BOLD = 1 , Font.ITALIC = 2
 * tamanio = float
 */
    public Font MyFont( int estilo, float tamanio)
    {
        Font tfont = font.deriveFont(estilo, tamanio);
        return tfont;
    }

}
