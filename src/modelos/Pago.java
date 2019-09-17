package modelos;

import java.util.Date;

public class Pago {

    private int identificador;
    private java.util.Date fechaPago;
    private String descripcion;
    private Integer total;
    private String nombre;
    private String numFactura;
    private String idLote;
    private Boolean estado_pago;
    String idUsuario;

    public Pago() {
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public String getIdLote() {
        return idLote;
    }

    public void setIdLote(String idLote) {
        this.idLote = idLote;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Boolean getEstado_pago() {
        return estado_pago;
    }

    public void setEstado_pago(Boolean estado_pago) {
        this.estado_pago = estado_pago;
    }

}
