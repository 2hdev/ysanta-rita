package modelos;

public class Medidor {

    private Integer identificador;
    private String numeroMedidor;
    private String descripcion;
    private String observacion;
    private String estado;
    private Integer usuario;
    private Integer lecturaAnterior;
    private Integer lecturaActual;
    private Integer numeroCuenta;
    
    public Medidor() {
    }

    public Medidor(String numeroMedidor) {
        this.numeroMedidor = numeroMedidor;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getNumeroMedidor() {
        return numeroMedidor;
    }

    public void setNumeroMedidor(String numeroMedidor) {
        this.numeroMedidor = numeroMedidor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public Integer getLecturaAnterior() {
        return lecturaAnterior;
    }

    public void setLecturaAnterior(Integer lecturaAnterior) {
        this.lecturaAnterior = lecturaAnterior;
    }

    public Integer getLecturaActual() {
        return lecturaActual;
    }

    public void setLecturaActual(Integer lecturaActual) {
        this.lecturaActual = lecturaActual;
    }

    public Integer getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Integer numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    
    @Override
    public String toString() {
        return ""+numeroMedidor+"";
    }
    
}
