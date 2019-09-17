package reportes;

import javax.swing.ImageIcon;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Archivos {

    public static void abrirGuardado(utilidades.VisorReporte visor, String titulo){
        visor.setTitle(String.join(" ", "Viendo: ", titulo, "-", "Y"));
        visor.setIconImage(new ImageIcon(Archivos.class.getResource(utilidades.Estaticos.ICONO)).getImage());
        visor.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        visor.setVisible(true);
    }
    
}
