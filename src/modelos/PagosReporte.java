package modelos;

import java.util.Date;

public class PagosReporte {
    
    private String numLote;
    private Date fechaLote;
    private Date fecha;
    private String numPago;
    private String codigo;
    private String nombre;
    private String numMedidor, numFactura, concepto;
    private Integer importe;
    private Integer ERSSAN;

    public PagosReporte() {
    }

    public String getNumLote() {
        return numLote;
    }

    public void setNumLote(String numLote) {
        this.numLote = numLote;
    }

    public Date getFechaLote() {
        return fechaLote;
    }

    public void setFechaLote(Date fechaLote) {
        this.fechaLote = fechaLote;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNumPago() {
        return numPago;
    }

    public void setNumPago(String numPago) {
        this.numPago = numPago;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumMedidor() {
        return numMedidor;
    }

    public void setNumMedidor(String numMedidor) {
        this.numMedidor = numMedidor;
    }

    public Integer getImporte() {
        return importe;
    }

    public void setImporte(Integer importe) {
        this.importe = importe;
    }

    public Integer getERSSAN() {
        return ERSSAN;
    }

    public void setERSSAN(Integer ERSSAN) {
        this.ERSSAN = ERSSAN;
    }

    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
    
}
