package reportes;

import conexion.Conectar;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import utilidades.VisorReporte;

public class Factura {

    utilidades.VisorReporte visor;
    JasperPrint jprint;

    public JasperPrint getJprint() {
        return jprint;
    }

    public void setJprint(JasperPrint jprint) {
        this.jprint = jprint;
    }

    public VisorReporte getVisor() {
        return visor;
    }

    private void setVisor(VisorReporte vis, String titulo) {
        visor = vis;
        visor.setTitle(titulo);
        visor.setIconImage(new ImageIcon(Factura.class.getResource(utilidades.Estaticos.ICONO)).getImage());
        visor.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public boolean imprimir(String rutaerror) {
        try {
            JasperPrintManager.printReport(getJprint(), false);
            int resp = JOptionPane.showConfirmDialog(null, "¿Se pudo imprimir correctamente?", "Consulta de estado", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.NO_OPTION) {
                throw new JRException("Según el usuario, no se pudo imprimir.");
            }
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "No se han encontrado impresoras instaladas o no se puede imprimir el informe en este momento.\nEl archivo será almacenado en su equipo para su posterior impresión.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            String nombrearchivo = new java.text.SimpleDateFormat("yyyy-MM-dd hh-mm-ss'.jrprint'").format(new java.util.Date());
            java.io.File destFile;
            try {
                destFile = new java.io.File(utilidades.Estaticos.RUTA_APP + File.separator + "impresiones" + File.separator + rutaerror + File.separator + nombrearchivo);
            } catch (Exception ex1) {
                ex1.getMessage();
                JOptionPane.showMessageDialog(null, "No se encuentra la ruta especificada: no se puede guardar el archivo.", "Error al guardar copia de impresión", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            String destFileName = destFile.toString();
            try {
                JRSaver.saveObject(getJprint(), destFileName);
            } catch (JRException exsave) {
                exsave.getMessage();
            }
        }
        return true;
    }

    public void ImprimirMuchos(int id_pago, String monto, String ultimo_aviso) {
        Connection con = Conectar.getConnect();
        JasperReport reporte;
        File file = null;
        try {
            file = new java.io.File(utilidades.Estaticos.RUTA_APP.getAbsolutePath() + utilidades.Estaticos.SUBFACTURA);
            reporte = (JasperReport) JRLoader.loadObjectFromFile(utilidades.Estaticos.RUTA_APP.getAbsolutePath() + utilidades.Estaticos.FACTURA);
            Map parametros = new HashMap();
            parametros.put("id_pago", id_pago);
            parametros.put("total_letras", new utilidades.NumeroALetras().Convertir(monto, true));
            parametros.put("SUBREPORT_DIR", file.getAbsolutePath());
            parametros.put("ultimo_aviso", ultimo_aviso);
            JasperPrintManager.printReport(JasperFillManager.fillReport(reporte, parametros, con), false);
        } catch (Exception ex) {
            System.out.println("Error al imprimir todos --> " + ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public Factura() {
    }

    public void mostrarFactura(int id_pago, String monto, String ultimo_aviso) {
        Connection con = Conectar.getConnect();
        JasperReport reporte;
        File file;
        try {
            file = new java.io.File(utilidades.Estaticos.RUTA_APP.getAbsolutePath() + utilidades.Estaticos.SUBFACTURA);
            reporte = (JasperReport) JRLoader.loadObjectFromFile(utilidades.Estaticos.RUTA_APP.getAbsolutePath() + utilidades.Estaticos.FACTURA);
        } catch (Exception ex) {
            System.out.println("error-->" + ex.getMessage());
            ex.getMessage();
            return;
        }
        Map parametros = new HashMap();
        parametros.put("id_pago", id_pago);
        parametros.put("total_letras", new utilidades.NumeroALetras().Convertir(monto, true));
        parametros.put("SUBREPORT_DIR", file.getAbsolutePath());
        parametros.put("ultimo_aviso", ultimo_aviso);
        try {
            setJprint(JasperFillManager.fillReport(reporte, parametros, con));
        } catch (JRException ex) {
            System.out.println("error-->" + ex);
            ex.getMessage();
            return;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        setVisor(new utilidades.VisorReporte(getJprint(), false, "fni"), "Factura Generada - Vista Previa - Y");
        getVisor().setVisible(true);
    }

    public void mostrarFacturax(String numFactura, java.util.Date fecha, String nombreCli, String dirCli, String rucCli, Integer monto, List<modelos.Factura> df) {
        JasperReport reporte;
        File file;
        try {
            file = new java.io.File(utilidades.Estaticos.RUTA_APP.getAbsolutePath() + utilidades.Estaticos.SUBFACTURA);
            reporte = (JasperReport) JRLoader.loadObjectFromFile(utilidades.Estaticos.RUTA_APP.getAbsolutePath() + utilidades.Estaticos.FACTURA);
        } catch (Exception ex) {
            ex.getMessage();
            return;
        }
        Map parametros = new HashMap();
        parametros.put("numFactura", numFactura);
        parametros.put("fechaFact", utilidades.Estaticos.FORMATODMA.format(fecha));
        parametros.put("nombreCli", nombreCli);
        parametros.put("dirCli", dirCli);
        parametros.put("rucCli", rucCli);
        parametros.put("totalletras", new utilidades.NumeroALetras().Convertir(monto.toString(), true));
        parametros.put("subtotal10", monto);
        parametros.put("totaliva10", utilidades.Factura.calcularIVA10(monto));
        parametros.put("totaliva", utilidades.Factura.calcularIVA10(monto));
        parametros.put("total", monto);
        parametros.put("SUBREPORT_DIR", file.getAbsolutePath());
        parametros.put("SUBREPORT_DATA", df);
        try {
            setJprint(JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(df)));
        } catch (JRException ex) {
            ex.getMessage();
            return;
        }
        setVisor(new utilidades.VisorReporte(getJprint(), false, "fni"), "Factura Generada - Vista Previa - Y");
        getVisor().setVisible(true);
    }

    public void mostrarFacturaReimpresa(List<modelos.Factura> detalle, List<String> cabecera) {
        JasperReport reporte;
        File file;
        try {
            file = new java.io.File(utilidades.Estaticos.RUTA_APP.getAbsolutePath() + utilidades.Estaticos.SUBFACTURA);
            reporte = (JasperReport) JRLoader.loadObjectFromFile(utilidades.Estaticos.RUTA_APP.getAbsolutePath() + utilidades.Estaticos.FACTURA);
        } catch (Exception ex) {
            ex.getMessage();
            return;
        }
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

            parametros.put("SUBREPORT_DIR", file.getAbsolutePath());
            parametros.put("SUBREPORT_DATA", detalle);

            setJprint(JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(detalle)));
            setVisor(new utilidades.VisorReporte(getJprint(), false, "fni"), "Factura Generada - Vista Previa - Y");
            getVisor().setVisible(true);
        } catch (JRException ex) {
            ex.getMessage();
            return;
        }
    }
}
