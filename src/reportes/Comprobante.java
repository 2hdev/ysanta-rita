package reportes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import utilidades.VisorReporte;

public class Comprobante {

    dao.Comprobante c;    
    
    public void abrirComprobante(String idLectura, JInternalFrame frame){
        JasperReport reporte;
        try{
            reporte = (JasperReport)JRLoader.loadObjectFromFile(utilidades.Estaticos.RUTA_APP+utilidades.Estaticos.COMPROBANTE);
            Map parametros = new HashMap();            
            parametros.put("RUTA_FONDO", utilidades.Estaticos.RUTA_APP.getAbsolutePath()+utilidades.Estaticos.FONDO);
            parametros.put("RUTA_UA", utilidades.Estaticos.RUTA_APP.getAbsolutePath()+utilidades.Estaticos.UA);
            parametros.put("RUTA_D", utilidades.Estaticos.RUTA_APP.getAbsolutePath()+utilidades.Estaticos.DESC);
            parametros.put("RUTA_PP", utilidades.Estaticos.RUTA_APP.getAbsolutePath()+utilidades.Estaticos.PP);
            parametros.put("RUTA_P", utilidades.Estaticos.RUTA_APP.getAbsolutePath()+utilidades.Estaticos.PAG);
            
            ArrayList<String> datos  = new dao.Comprobante().obtenerComprobante(idLectura);
            
            parametros.put("nomAp", datos.get(0));
            parametros.put("numMedidor", datos.get(1));
            parametros.put("numUsuario", datos.get(2));
            parametros.put("FechaActual", datos.get(3));
            parametros.put("FechaAnterior", datos.get(4));
            parametros.put("LecturaActual", Integer.parseInt(datos.get(5)));
            parametros.put("LecturaAnterior", Integer.parseInt(datos.get(6)));
            parametros.put("MinimoM3", Integer.parseInt(datos.get(7)));
            parametros.put("ExcedenteM3", Integer.parseInt(datos.get(8)));
            parametros.put("TotalM3", Integer.parseInt(datos.get(9)));
            parametros.put("MinimoImporte", Integer.parseInt(datos.get(10)));
            parametros.put("ExcedenteImporte", Integer.parseInt(datos.get(11)));
            parametros.put("TotalImporte", Integer.parseInt(datos.get(12)));
            parametros.put("facturaActual", Integer.parseInt(datos.get(12)));
            Integer anterior = dao.Comprobante.obtenerSaldoAnteriorALectura(idLectura);
            parametros.put("facturaAnterior",  anterior);
            parametros.put("numComprobante", datos.get(13));
            parametros.put("vencimiento", datos.get(14));
            parametros.put("IVA10", Integer.parseInt(datos.get(15)));
            parametros.put("ERSSAN", Integer.parseInt(datos.get(16)));
            parametros.put("totalCargos", 0);
            parametros.put("totalMas10", Integer.parseInt(datos.get(12))+anterior+Integer.parseInt(datos.get(15)));
            parametros.put("dirUsuario", datos.get(17));
            parametros.put("pendientes", dao.Comprobante.obtenerPendientesAnterioresA(datos.get(13), dao.Medidor.obtenerIdMedidorPorLectura(idLectura)));
            parametros.put("estado", datos.get(21));
            
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametros, new JREmptyDataSource(1));
            VisorReporte visor = new VisorReporte(jprint, false, true);
            visor.setLocationRelativeTo(frame);
            visor.setTitle("Comprobante - Vista Previa - Y");
            visor.setIconImage(new ImageIcon(getClass().getResource(utilidades.Estaticos.ICONO)).getImage());
            visor.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            visor.setVisible(true);

        }
        catch(JRException ex){
            Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar mostrar reporte: ", ex);
        }
    }
    
    public void abrirComprobantes(String idLoteFactura, JInternalFrame frame){
        JasperReport reporte;
        try{
            reporte = (JasperReport)JRLoader.loadObjectFromFile(utilidades.Estaticos.RUTA_APP+utilidades.Estaticos.COMPROBANTENEO);
            Map parametros = new HashMap();            
            parametros.put("RUTA_FONDO", utilidades.Estaticos.RUTA_APP.getAbsolutePath()+utilidades.Estaticos.FONDO);
            parametros.put("RUTA_UA", utilidades.Estaticos.RUTA_APP.getAbsolutePath()+utilidades.Estaticos.UA);
            parametros.put("RUTA_D", utilidades.Estaticos.RUTA_APP.getAbsolutePath()+utilidades.Estaticos.DESC);
            parametros.put("RUTA_PP", utilidades.Estaticos.RUTA_APP.getAbsolutePath()+utilidades.Estaticos.PP);
            parametros.put("RUTA_P", utilidades.Estaticos.RUTA_APP.getAbsolutePath()+utilidades.Estaticos.PAG);
            
            java.util.List<modelos.Comprobantes> datos  = new dao.Comprobante().obtenerComprobantes(idLoteFactura);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(datos));
            VisorReporte visor = new VisorReporte(jprint, false, true);
            visor.setLocationRelativeTo(frame);
            visor.setTitle("Listado de Comprobantes del Lote Nº "+idLoteFactura+" - Vista Previa - Y");
            visor.setIconImage(new ImageIcon(getClass().getResource(utilidades.Estaticos.ICONO)).getImage());
            visor.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            visor.setVisible(true);

        }
        catch(JRException ex){
            Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al abrir comprobantes: ", ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Advertencia",JOptionPane.WARNING_MESSAGE);          
        }
    }
    
}
