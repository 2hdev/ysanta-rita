package workers;

import conexion.InicioSesion;
import interfaces.Principal;
import interfaces.PrincipalAdmin;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class WorkerLogin extends SwingWorker {

    private final JProgressBar barraProgreso;
    private final JButton boton;
    private final Map<String, String> mapa;
    private final JFrame frame;
    private boolean conecto = false, correcto;

    @Override
    protected Void doInBackground() throws Exception {
        boton.setEnabled(false);
        barraProgreso.setIndeterminate(true);
        barraProgreso.setVisible(true);
        InicioSesion is = new InicioSesion();
        conecto = is.iniciarSesion(mapa.get("usuario"), mapa.get("pass"));
        setCorrecto(true);
        return null;
    }

    @Override
    protected void done() {
        if (conecto) {
            if (InicioSesion.getUsuario().contains("admin")) {
                PrincipalAdmin pa = new PrincipalAdmin();
                pa.setVisible(true);
                frame.dispose();
            } else {
                Principal p = new Principal();
                p.setVisible(true);
                frame.dispose();
            }
        } else {
            setCorrecto(false);
        }
        barraProgreso.setVisible(false);
        boton.setEnabled(true);
    }

    public WorkerLogin(JProgressBar barraProgreso, JButton boton, Map<String, String> mapa, JFrame frame) {
        this.barraProgreso = barraProgreso;
        this.boton = boton;
        this.mapa = mapa;
        this.frame = frame;
    }

    public boolean isCorrecto() {
        return correcto;
    }

    public void setCorrecto(boolean correcto) {
        this.correcto = correcto;
    }

}
