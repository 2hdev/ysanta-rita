package modelos;

public class Auditoria {
    
    private String identificador;
    private String idAuditado;
    private String detalleAuditado;
    private String tablaAuditada;
    private String accion;
    private String fechaHora;
    private String autor;

    public Auditoria() {
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getIdAuditado() {
        return idAuditado;
    }

    public void setIdAuditado(String idAuditado) {
        this.idAuditado = idAuditado;
    }

    public String getDetalleAuditado() {
        return detalleAuditado;
    }

    public void setDetalleAuditado(String detalleAuditado) {
        this.detalleAuditado = detalleAuditado;
    }

    public String getTablaAuditada() {
        return tablaAuditada;
    }

    public void setTablaAuditada(String tablaAuditada) {
        this.tablaAuditada = tablaAuditada;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
}
