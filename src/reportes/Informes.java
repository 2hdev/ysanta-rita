package reportes;

import interfaces.Principal;
import interfaces.PrincipalAdmin;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import modelos.ResumenPagos;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import utilidades.VisorPanel;
import utilidades.VisorReporte;

public class Informes {

    JasperReport reporte;
    private final String ruta = utilidades.Estaticos.RUTA_APP.getAbsolutePath();

    public void mostrarInformeUsuarios(List<modelos.UsuarioReporte> usuarios, JPanel panel, Map mapa) {
        try {
            Map parametros = new HashMap();
            parametros.put("RUTA_IMAGEN", ruta + utilidades.Estaticos.IMAGEN_FONDO);
            if (mapa != null) {
                parametros.put("zona", mapa.get("zona").toString());
            }
            reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta + utilidades.Estaticos.REPORTE_USUARIOS);

            JasperPrint jp = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(usuarios));
            jp.setName("Listado de Usuarios - Y");
            VisorPanel visor = new VisorPanel(jp, true);
            panel.add(visor);
            panel.repaint();
            panel.revalidate();
        } catch (JRException ex) {
            if (ex.getMessage().equals("The report filling thread was interrupted.")) {
                javax.swing.JOptionPane.showMessageDialog(null, "Se interrumpió la carga del reporte.", "Atención", javax.swing.JOptionPane.WARNING_MESSAGE);
            } else {
                Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, "Error al intentar mostrar reporte: ", ex);
            }
            panel.removeAll();
            panel.repaint();
            panel.revalidate();
        }
    }

    public void mostrarInformeMorososDC(List<modelos.UsuarioReporte> usuarios, JPanel panel, Map mapa) {
        try {
            Map parametros = new HashMap();
            parametros.put("RUTA_IMAGEN", ruta + utilidades.Estaticos.IMAGEN_FONDO);
            if (mapa != null) {
                parametros.put("zona", mapa.get("zona").toString());
            }
            reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta + utilidades.Estaticos.REPORTE_MOROSOSDC);

            JasperPrint jp = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(usuarios));
            jp.setName("Listado de Morosos (por Derecho de Conexión) - Y");
            VisorPanel visor = new VisorPanel(jp, true);
            panel.add(visor);
            panel.repaint();
            panel.revalidate();

        } catch (JRException ex) {
            if (ex.getMessage().equals("The report filling thread was interrupted.")) {
                javax.swing.JOptionPane.showMessageDialog(null, "Se interrumpió la carga del reporte.", "Atención", javax.swing.JOptionPane.WARNING_MESSAGE);
            } else {
                Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, "Error al intentar mostrar reporte: ", ex);
            }
            panel.removeAll();
            panel.repaint();
            panel.revalidate();
        }
    }

    public void mostrarInformePagos(List<modelos.PagosReporte> pagos, String numLote, modelos.LotePagos lotepago) {
        try {
            Map parametros = new HashMap();
            parametros.put("RUTA_IMAGEN", ruta + utilidades.Estaticos.IMAGEN_FONDO);
            parametros.put("numLote", numLote);
            parametros.put("fechaLote", lotepago.getFechaLote());
            parametros.put("mes", lotepago.getMes());
            parametros.put("year", lotepago.getAnho());
            reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta + utilidades.Estaticos.REPORTE_PAGOS);
            JasperPrint jp = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(pagos));
            jp.setName("Listado de Pagos - SUI");
            VisorReporte visor = new VisorReporte(jp, false, true);
            visor.setLocationRelativeTo(conexion.InicioSesion.getUsuario().contains("admin") ? PrincipalAdmin.panelEscritorio : Principal.panelEscritorio);
            visor.setTitle("Listado de Pagos - SUI");
            visor.setIconImage(new ImageIcon(getClass().getResource(utilidades.Estaticos.ICONO)).getImage());
            visor.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            visor.setVisible(true);
            ((javax.swing.JFrame) visor).toFront();
        } catch (JRException ex) {
            Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, "Error al intentar mostrar reporte: ", ex);
        }
    }

    public void mostrarInformePagos(List<modelos.PagosReporte> pagos, Map lotepago, JPanel panel) {
        try {
            Map parametros = new HashMap();
            parametros.put("RUTA_IMAGEN", ruta + utilidades.Estaticos.IMAGEN_FONDO);
            parametros.put("numLote", lotepago.get("numLote").toString());
            parametros.put("fechaLote", (java.util.Date) lotepago.get("fechaLote"));
            parametros.put("mes", lotepago.get("mes").toString());
            parametros.put("year", lotepago.get("year").toString());
            reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta + utilidades.Estaticos.REPORTE_PAGOS);
            JasperPrint jp = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(pagos));
            jp.setName("Listado de Pagos - SUI");
            VisorPanel visor = new VisorPanel(jp, true);
            panel.add(visor);
            panel.repaint();
            panel.revalidate();
        } catch (JRException ex) {
            if (ex.getMessage().equals("The report filling thread was interrupted.")) {
                javax.swing.JOptionPane.showMessageDialog(null, "Se interrumpió la carga del reporte.", "Atención", javax.swing.JOptionPane.WARNING_MESSAGE);
            } else {
                Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, "Error al intentar mostrar reporte: ", ex);
            }
            panel.removeAll();
            panel.repaint();
            panel.revalidate();
        }
    }

    public void mostrarInformePagosERSSAN(List<modelos.PagosReporte> pagos, java.util.Date desde, java.util.Date hasta, JPanel panel) {
        try {
            Map parametros = new HashMap();
            parametros.put("RUTA_IMAGEN", ruta + utilidades.Estaticos.IMAGEN_FONDO);
            parametros.put("fechaDesde", desde);
            parametros.put("fechaHasta", hasta);
            reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta + utilidades.Estaticos.REPORTE_PAGOS_ERSSAN);
            JasperPrint jp = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(pagos));
            jp.setName("Listado de Pagos c/ ERSSAN - Y");
            VisorPanel visor = new VisorPanel(jp, true);
            panel.add(visor);
            panel.repaint();
            panel.revalidate();
        } catch (JRException ex) {
            if (ex.getMessage().equals("The report filling thread was interrupted.")) {
                javax.swing.JOptionPane.showMessageDialog(null, "Se interrumpió la carga del reporte.", "Atención", javax.swing.JOptionPane.WARNING_MESSAGE);
            } else {
                Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, "Error al intentar mostrar reporte: ", ex);
            }
            panel.removeAll();
            panel.repaint();
            panel.revalidate();
        }
    }

    public void mostrarFacturaReimpresa(List<modelos.Factura> detalle, List<String> cabecera) {
        try {
            Map parametros = new HashMap();

            parametros.put("numFactura", cabecera.get(3));
            parametros.put("fechaFact", cabecera.get(0));
            parametros.put("nombreCli", cabecera.get(2));
            parametros.put("dirCli", cabecera.get(4));
            parametros.put("rucCli", cabecera.get(5));

            parametros.put("totalletras", new utilidades.NumeroALetras().Convertir(String.valueOf(cabecera.get(1)), true));
            parametros.put("subtotal10", Integer.parseInt(cabecera.get(1)));
            parametros.put("totaliva10", utilidades.Factura.calcularIVA10(Integer.parseInt(cabecera.get(1))));
            parametros.put("totaliva", utilidades.Factura.calcularIVA10(Integer.parseInt(cabecera.get(1))));
            parametros.put("total", Integer.parseInt(cabecera.get(1)));

            parametros.put("RUTA_IMAGEN", ruta + "/etc/img/copia_factura.jpg");

            reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta + utilidades.Estaticos.FACTURA_COPIAx);
            JasperPrint jp = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(detalle));
            jp.setName("Factura Reimpresa - Y");
            VisorReporte visor = new VisorReporte(jp, false, true);
            visor.setLocationRelativeTo(conexion.InicioSesion.getUsuario().contains("admin") ? PrincipalAdmin.panelEscritorio : Principal.panelEscritorio);
            visor.setTitle("Factura Reimpresa - Vista Previa - Y");
            visor.setIconImage(new ImageIcon(getClass().getResource(utilidades.Estaticos.ICONO)).getImage());
            visor.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            visor.setVisible(true);
            ((javax.swing.JFrame) visor).toFront();
        } catch (JRException ex) {
            Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, "Error al intentar mostrar reporte: ", ex);
        }
    }

    public void mostrarReciboReimpreso(List<modelos.Recibo> detalle, String numRecibo) {
        try {
            Map parametros = new HashMap();
            parametros.put("RUTA_IMAGEN", ruta + "/etc/img/copia_recibo.jpg");
            parametros.put("numRecibo", numRecibo);
            reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta + utilidades.Estaticos.RECIBO_COPIA);
            JRDataSource src = new JRBeanCollectionDataSource(detalle);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametros, src);
            jprint.setName("Recibo Reimpreso - Y");
            VisorReporte visor = new VisorReporte(jprint, false, true);
            visor.setLocationRelativeTo(conexion.InicioSesion.getUsuario().contains("admin") ? PrincipalAdmin.panelEscritorio : Principal.panelEscritorio);
            visor.setTitle("Recibo Reimpreso - Vista Previa - Y");
            visor.setIconImage(new ImageIcon(getClass().getResource(utilidades.Estaticos.ICONO)).getImage());
            visor.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            visor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, "Error al intentar mostrar reporte: ", ex);
        }
    }

    public void mostrarResumenCuenta(modelos.ResumenCuenta detalle, javax.swing.JDialog dialogo) {
        try {
            Map parametros = new HashMap();
            modelos.Empresa e = new dao.Parametros().getEmpresa();
            parametros.put("razonSocial", e.getNombre());
            parametros.put("numcuenta", detalle.getNumcuenta());
            parametros.put("nummedidor", detalle.getNummedidor());
            parametros.put("nomape", detalle.getNomape());
            parametros.put("derconex", detalle.getDerconex());
            parametros.put("saldoanterior", detalle.getSaldoanterior());
            parametros.put("saldo", detalle.getSaldo());
            parametros.put("saldoafavor", detalle.getSaldoafavor());
            reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta + utilidades.Estaticos.RESUMEN_CUENTA);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametros, new JREmptyDataSource(1));
            jprint.setName("Resumen de Cuenta - Y");
            VisorReporte visor = new VisorReporte(jprint, false, true);
            visor.setLocationRelativeTo(conexion.InicioSesion.getUsuario().contains("admin") ? PrincipalAdmin.panelEscritorio : Principal.panelEscritorio);
            visor.setTitle("Resumen de Cuenta - Y");
            visor.setIconImage(new ImageIcon(getClass().getResource(utilidades.Estaticos.ICONO)).getImage());
            visor.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            visor.setVisible(true);
            if (dialogo != null) {
                dialogo.dispose();
            }
            ((javax.swing.JFrame) visor).toFront();
        } catch (JRException ex) {
            Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, "Error al intentar mostrar reporte: ", ex);
        }
    }

    public void mostrarComprobanteInterno(modelos.ComprobanteInterno detalle) {
        try {
            Map parametros = new HashMap();
            modelos.Empresa e = new dao.Parametros().getEmpresa();
            parametros.put("razonSocial", e.getNombre());
            parametros.put("numcuenta", detalle.getNumcuenta());
            parametros.put("nummedidor", detalle.getNumMedidor());
            parametros.put("nomape", detalle.getNomApe());
            parametros.put("numcomprobante", detalle.getNumComprobante());
            parametros.put("estadocomprobante", detalle.getEstadoComprobante());
            parametros.put("saldoanterior", detalle.getSaldoAnterior());
            parametros.put("saldoactual", detalle.getSaldoActual());
            reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta + utilidades.Estaticos.COMPROBANTE_INTERNO);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametros, new JREmptyDataSource(1));
            jprint.setName("Comprobante Interno - Y");
            VisorReporte visor = new VisorReporte(jprint, false, true);
            visor.setLocationRelativeTo(conexion.InicioSesion.getUsuario().contains("admin") ? PrincipalAdmin.panelEscritorio : Principal.panelEscritorio);
            visor.setTitle("Comprobante Interno - Y");
            visor.setIconImage(new ImageIcon(getClass().getResource(utilidades.Estaticos.ICONO)).getImage());
            visor.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            visor.setVisible(true);
            String nombrearchivo = new java.text.SimpleDateFormat("yyyy-MM-dd HH-mm-ss' - " + detalle.getNumComprobante() + ".jrprint'").format(new java.util.Date());
            File destFile = new java.io.File(ruta + File.separator + "impresiones" + File.separator + "ci" + File.separator + nombrearchivo);
            String destFileName = destFile.toString();
            JRSaver.saveObject(jprint, destFileName);
        } catch (JRException ex) {
            Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, "Error en reporte: ", ex);
        }
    }

    public void mostrarHistorialPago(List<modelos.HistorialPago> hp, String nomape, Integer codigo, java.util.Date desde, java.util.Date hasta) {
        try {
            Map parametros = new HashMap();
            parametros.put("RUTA_IMAGEN", ruta + utilidades.Estaticos.IMAGEN_FONDO);

            modelos.Empresa e = new dao.Parametros().getEmpresa();
            parametros.put("razonSocial", e.getNombre());
            parametros.put("RUC", e.getRUC());
            parametros.put("codigo", codigo);
            parametros.put("nomape", nomape);
            if (desde != null && hasta != null) {
                parametros.put("desde", desde);
                parametros.put("hasta", hasta);
            }
            reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta + utilidades.Estaticos.HISTORIAL_PAGOS);

            JasperPrint jp = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(hp));
            VisorReporte visor = new VisorReporte(jp, false, true);
            visor.setLocationRelativeTo(conexion.InicioSesion.getUsuario().contains("admin") ? PrincipalAdmin.panelEscritorio : Principal.panelEscritorio);
            visor.setTitle("Historial de Pago - Y");
            visor.setIconImage(new ImageIcon(getClass().getResource(utilidades.Estaticos.ICONO)).getImage());
            visor.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            visor.setExtendedState(MAXIMIZED_BOTH);
            visor.setVisible(true);
            ((javax.swing.JFrame) visor).toFront();

        } catch (JRException ex) {
            Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, "Error al intentar mostrar reporte: ", ex);
        }
    }

    public void mostrarResumenPagos(int numLote, int mes, int anho, List<ResumenPagos> resumen, JPanel panel) {
        try {
            JasperPrint jp = null;
            Map parametros = new HashMap();
            parametros.put("id_lote", numLote);
            parametros.put("Mes", mes);
            parametros.put("Anho", anho);
            reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta + utilidades.Estaticos.RESUMEN_PAGOS);
            try {
                jp = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(resumen));
            } catch (Throwable ex) {
                ex.printStackTrace();
            }
            jp.setName("Resumen de Pagos por Mes - SUI");
            VisorPanel visor = new VisorPanel(jp, true);
            panel.add(visor);
            panel.repaint();
            panel.revalidate();
        } catch (JRException ex) {
            if (ex.getMessage().equals("The report filling thread was interrupted.")) {
                javax.swing.JOptionPane.showMessageDialog(null, "Se interrumpió la carga del reporte.", "Atención", javax.swing.JOptionPane.WARNING_MESSAGE);
            } else {
                Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, "Error al intentar mostrar reporte: ", ex);
            }
            panel.removeAll();
            panel.repaint();
            panel.revalidate();
        }
    }
}
