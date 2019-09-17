package workers;

import java.util.Date;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class WorkerInformes extends SwingWorker {

    private JProgressBar barraProgreso;
    private reportes.Informes inf = new reportes.Informes();
    private JPanel panelCarga, panelVisor;
    private worker tipo;
    private JButton boton;
    private Map<String, ?> mapa;

    public enum worker {
        USUARIOS, MOROSOS_DC, PAGOS, PAGOS_ERSSAN, USUARIOS_ZONA, MOROSOS_DC_ZONA, RESUMEN
    };

    public WorkerInformes(JPanel panelVisor, JPanel panelCarga, JProgressBar barraProgreso, worker tipo, JButton boton) {
        this.barraProgreso = barraProgreso;
        this.panelCarga = panelCarga;
        this.panelVisor = panelVisor;
        this.tipo = tipo;
        this.boton = boton;
    }

    public WorkerInformes(JPanel panelVisor, JPanel panelCarga, JProgressBar barraProgreso, worker tipo, JButton boton, Map<String, ?> mapa) {
        this.barraProgreso = barraProgreso;
        this.panelCarga = panelCarga;
        this.panelVisor = panelVisor;
        this.tipo = tipo;
        this.boton = boton;
        this.mapa = mapa;
    }

    @Override
    protected Void doInBackground() throws Exception {
        panelVisor.removeAll();
        barraProgreso.setIndeterminate(true);
        switch (tipo) {
            case MOROSOS_DC:
                do {
                    java.util.List<modelos.UsuarioReporte> lista = dao.Reportes.obtenerUsuariosMorososDC();
                    inf.mostrarInformeMorososDC(lista, panelVisor, null);
                    break;
                } while (!isCancelled());
                break;
            case MOROSOS_DC_ZONA:
                do {
                    java.util.List<modelos.UsuarioReporte> lista = dao.Reportes.obtenerUsuariosMorososDCPorZona(mapa.get("idZona").toString());
                    inf.mostrarInformeMorososDC(lista, panelVisor, mapa);
                    break;
                } while (!isCancelled());
                break;
            case USUARIOS:
                do {
                    java.util.List<modelos.UsuarioReporte> lista = dao.Reportes.obtenerUsuarios();
                    inf.mostrarInformeUsuarios(lista, panelVisor, null);
                    break;
                } while (!isCancelled());
                break;
            case USUARIOS_ZONA:
                do {
                    java.util.List<modelos.UsuarioReporte> lista = dao.Reportes.obtenerUsuariosPorZona(mapa.get("idZona").toString());
                    inf.mostrarInformeUsuarios(lista, panelVisor, mapa);
                    break;
                } while (!isCancelled());
                break;
            case PAGOS_ERSSAN:
                do {
                    java.util.List<modelos.PagosReporte> lista = dao.Reportes.obtenerPagosPorFecha((Date) mapa.get("desde"), (Date) mapa.get("hasta"));
                    inf.mostrarInformePagosERSSAN((lista), (Date) mapa.get("desde"), (Date) mapa.get("hasta"), panelVisor);
                    break;
                } while (!isCancelled());
                break;
            case PAGOS:
                java.util.List<modelos.PagosReporte> lista = dao.Reportes.PagosPorLote(mapa.get("numLote").toString());
                do {
                    inf.mostrarInformePagos(lista, mapa, panelVisor);
                    break;
                } while (!isCancelled());
                break;
            case RESUMEN:
                do {
                    java.util.List<modelos.ResumenPagos> resumen = dao.Reportes.ResumendePagos(Integer.valueOf(mapa.get("mes").toString()), Integer.valueOf(mapa.get("anho").toString()), Integer.valueOf(mapa.get("numLote").toString()));
                    inf.mostrarResumenPagos(Integer.valueOf(mapa.get("numLote").toString()), Integer.valueOf(mapa.get("mes").toString()), Integer.valueOf(mapa.get("anho").toString()), resumen, panelVisor);
                    break;
                } while (!isCancelled());
                break;
        }
        return null;
    }

    @Override
    protected void done() {
        panelCarga.setVisible(false);
        boton.setEnabled(true);
    }
}
