package modelos;

import java.util.Date;

public class LotePagos {

    private String identificador;
    private Date fechaLote;
    private String observacion;
    private String descripcion;
    private String mes;
    private String anho;
    private Integer total;

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Date getFechaLote() {
        return fechaLote;
    }

    public void setFechaLote(Date fechaLote) {
        this.fechaLote = fechaLote;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public LotePagos(Date fechaLote, String observacion, String descripcion, String mes, String anho) {
        this.fechaLote = fechaLote;
        this.observacion = observacion;
        this.descripcion = descripcion;
        this.mes = mes;
        this.anho = anho;
    }

    public LotePagos() {
    }

    @Override
    public String toString() {
        return "LotePagos{" + "identificador=" + identificador + ", fechaLote=" + fechaLote + ", observacion=" + observacion + ", descripcion=" + descripcion + ", mes=" + mes + ", anho=" + anho + ", total=" + total + '}';
    }

}
