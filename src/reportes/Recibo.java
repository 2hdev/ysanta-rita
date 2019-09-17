package reportes;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import utilidades.VisorReporte;

public class Recibo {
    
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

    public boolean imprimir(String rutaerror){
        try{
            JasperPrintManager.printReport(getJprint(), false);
            int resp = JOptionPane.showConfirmDialog(null, "¿Se pudo imprimir correctamente?", "Consulta de estado", JOptionPane.YES_NO_OPTION);
            if(resp == JOptionPane.NO_OPTION){
                throw new JRException("Según el usuario, no se pudo imprimir.");
            }
        }
        catch(JRException ex){
            JOptionPane.showMessageDialog(null, "No se han encontrado impresoras instaladas o no se puede imprimir el informe en este momento.\nEl archivo será almacenado en su equipo para su posterior impresión.", "Advertencia",JOptionPane.WARNING_MESSAGE);
            String nombrearchivo = new java.text.SimpleDateFormat("yyyy-MM-dd hh-mm-ss'.jrprint'").format(new java.util.Date());
            java.io.File destFile;
            try {  
                destFile = new java.io.File(utilidades.Estaticos.RUTA_APP+File.separator+"impresiones"+File.separator+rutaerror+File.separator+nombrearchivo);
            }
            catch (Exception ex1) {
                ex1.getMessage();
                JOptionPane.showMessageDialog(null, "No se encuentra la ruta especificada: no se puede guardar el archivo.", "Error al guardar copia de impresión", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            String destFileName = destFile.toString();
            try {
                JRSaver.saveObject(getJprint(), destFileName);
            }
            catch (JRException exsave) {
                exsave.getMessage();
            }
        }
        return true;
    }
    
    public Recibo() {
    }
    
    public void mostrarRecibo(String numRecibo, List<modelos.Recibo> df){
        URL path; JasperReport reporte;
        try {
            path = Paths.get(new java.io.File(y.Y.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).
                    getParentFile().getParentFile().getPath()+utilidades.Estaticos.RECIBO).toFile().toURL();
        }
        catch (MalformedURLException ex) {
            ex.getMessage();
            return;
        } catch (URISyntaxException ex) {
            ex.getReason();
            return;
        }
        try {
            reporte = (JasperReport)JRLoader.loadObject(path);
        } catch (JRException ex) {
            ex.getMessage();
            return;
        }
        Map parametros = new HashMap();
        parametros.put("numRecibo", numRecibo);
        JRDataSource src = new JRBeanCollectionDataSource(df);
        try {
            setJprint(JasperFillManager.fillReport(reporte, parametros, src));
        } catch (JRException ex) {
            ex.getMessage();
            return;
        }
        setVisor(new utilidades.VisorReporte(getJprint(), false, "otros"), "Recibo Generado - Vista Previa - Y");
        getVisor().setVisible(true);
    }
    
}
