package modelos;

import java.util.Date;

public class Lectura {
    
    private Integer identificador;
    private Integer lectura;
    private Date fechaLectura;
    private String descripcion;
    private Date fechaVencimiento;
    private String observacion;
    private String mensaje;
    private Integer idMedidor;

    public Lectura() {
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public Integer getLectura() {
        return lectura;
    }

    public void setLectura(Integer lectura) {
        this.lectura = lectura;
    }

    public Date getFechaLectura() {
        return fechaLectura;
    }

    public void setFechaLectura(Date fechaLectura) {
        this.fechaLectura = fechaLectura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getIdMedidor() {
        return idMedidor;
    }

    public void setIdMedidor(Integer idMedidor) {
        this.idMedidor = idMedidor;
    }
    
}
