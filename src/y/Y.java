package y;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Y {

    public static void main(String[] args) {

        java.io.File logFile = new java.io.File(utilidades.Estaticos.RUTA_APP.toString() + utilidades.Estaticos.LOG);
        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream(logFile));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Y.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SecurityException ex) {
            Logger.getLogger(Y.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            Logger.getLogger(Y.class.getName()).log(Level.SEVERE, null, e);
        }
        new Login().setVisible(true);

    }

}
