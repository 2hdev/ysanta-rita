package utilidades;

import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Estaticos {

    public static String FACTURA = "/etc/inf/factura_obligado.jasper";
    public static String FACTURAx = "/etc/inf/factura.jasper";
    public static String FACTURA_COPIAx = "/etc/inf/factura_copia.jasper";
    public static String SUBFACTURA = "/etc/inf/subfactura_obligado.jasper";
    public static String SUBFACTURAx = "/etc/inf/subfactura.jasper";
    public static String RECIBO = "/etc/inf/recibo.jasper";
    public static String RECIBO_COPIA = "/etc/inf/recibo_copia.jasper";
    public static String COMPROBANTE = "/etc/inf/Comprobante.jasper";
    public static String COMPROBANTENEO = "/etc/inf/ComprobanteNeo.jasper";
    public static String ICONO = "/imagenes/y.png";
    public static String DESC = "/etc/img/desconexion.png";
    public static String UA = "/etc/img/ultimoaviso.png";
    public static String PP = "/etc/img/parcialmentepagado.png";
    public static String PAG = "/etc/img/pagado.png";
    public static String FONDO = "/etc/img/TicketY.jpg";
    public static String REPORTE_USUARIOS = "/etc/inf/ListadoUsuarios.jasper";
    public static String REPORTE_PAGOS = "/etc/inf/ListaPagos.jasper";
    public static String INFORME_PAGOS = "/etc/inf/Informe_Pagos.jasper";
    public static String REPORTE_PAGOS_ERSSAN = "/etc/inf/ListadoPagosERSSAN.jasper";
    public static String RESUMEN_CUENTA = "/etc/inf/ResumenCuenta.jasper";
    public static String COMPROBANTE_INTERNO = "/etc/inf/ComprobanteInterno.jasper";
    public static String REPORTE_MOROSOSDC = "/etc/inf/ListadoMorososDC.jasper";
    public static String HISTORIAL_PAGOS = "/etc/inf/HistorialPagos.jasper";
    public static String MANUAL = "/etc/ManualY1.3.pdf";
    public static String RESUMEN_PAGOS = "/etc/inf/ResumenPagos.jasper";
    public static final java.text.SimpleDateFormat FORMATODMA = new java.text.SimpleDateFormat("dd/MM/yyyy");
    public static final java.io.File RUTA_APP;
    public static final String IMAGEN_FONDO = "/etc/img/fondoreporte.png";
    public static final String LOG = "/etc/logs/log.properties";

    static {
        Object obj = null;
        try {
            obj = new java.io.File(new java.io.File(y.Y.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).
                    getParentFile().getParentFile().getPath());
        } catch (URISyntaxException ex) {
            Logger.getLogger(Estaticos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            RUTA_APP = (java.io.File) obj;
        }
    }

}
