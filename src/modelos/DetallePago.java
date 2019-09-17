package modelos;

public class DetallePago {

    Integer identificador;
    String concepto;
    Integer subtotal;
    Integer cantidad;
    Integer tipoIVA;
    String idPago;
    String idComprobante;
    Integer montoDescuento;
    String tipoPago;
    Integer idCuenta;
    Integer erssan;

    public DetallePago() {
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Integer getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getTipoIVA() {
        return tipoIVA;
    }

    public void setTipoIVA(Integer tipoIVA) {
        this.tipoIVA = tipoIVA;
    }

    public String getIdPago() {
        return idPago;
    }

    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }

    public Integer getMontoDescuento() {
        return montoDescuento;
    }

    public void setMontoDescuento(Integer montoDescuento) {
        this.montoDescuento = montoDescuento;
    }

    public String getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(String idComprobante) {
        this.idComprobante = idComprobante;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Integer getErssan() {
        return erssan;
    }

    public void setErssan(Integer erssan) {
        this.erssan = erssan;
    }

}
