package modelos;

import java.util.Date;

public class LoteComprobantes {
    
    private Integer identificador;
    private Date fechaGeneracion;
    private Date fechaVencimiento;
    private String descripcion;
    private String observacion;
    private String mesLote;
    private Integer anhoLote;

    public LoteComprobantes() {
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMesLote() {
        return mesLote;
    }

    public void setMesLote(String mesLote) {
        this.mesLote = mesLote;
    }

    public Integer getAnhoLote() {
        return anhoLote;
    }

    public void setAnhoLote(Integer anhoLote) {
        this.anhoLote = anhoLote;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
}
