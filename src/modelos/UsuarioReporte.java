package modelos;

public class UsuarioReporte {
    
    private String codigo;
    private String nombre;
    private String numDocumento;
    private String numMedidor;
    private Integer cuentaActual, saldoAFavor;
    private String zona;

    public UsuarioReporte() {
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

    public Integer getCuentaActual() {
        return cuentaActual;
    }

    public void setCuentaActual(Integer cuentaActual) {
        this.cuentaActual = cuentaActual;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public Integer getSaldoAFavor() {
        return saldoAFavor;
    }

    public void setSaldoAFavor(Integer saldoAFavor) {
        this.saldoAFavor = saldoAFavor;
    }
    
    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

}
