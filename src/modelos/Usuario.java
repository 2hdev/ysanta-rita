package modelos;

import java.util.Date;

public class Usuario {
    private int identificador;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String tipoDocumento;
    private String numDocumento;
    private String tipodesc;
    private Date plazoDescuento;
    private Integer montoDescuento;
    private String obs;
    private Integer cuentaAnterior;
    private Integer cuentaActual;
    private Integer idZona;

    public Usuario() {
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getTipodesc() {
        return tipodesc;
    }

    public void setTipodesc(String tipodesc) {
        this.tipodesc = tipodesc;
    }

    public Date getPlazoDescuento() {
        return plazoDescuento;
    }

    public void setPlazoDescuento(Date plazoDescuento) {
        this.plazoDescuento = plazoDescuento;
    }

    public Integer getMontoDescuento() {
        return montoDescuento;
    }

    public void setMontoDescuento(Integer montoDescuento) {
        this.montoDescuento = montoDescuento;
    }
    
    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Integer getCuentaAnterior() {
        return cuentaAnterior;
    }

    public void setCuentaAnterior(Integer cuentaAnterior) {
        this.cuentaAnterior = cuentaAnterior;
    }

    public Integer getCuentaActual() {
        return cuentaActual;
    }

    public void setCuentaActual(Integer cuentaActual) {
        this.cuentaActual = cuentaActual;
    }

    @Override
    public String toString() {
        return nombre +" "+ apellido;
    }

    public Integer getIdZona() {
        return idZona;
    }

    public void setIdZona(Integer idZona) {
        this.idZona = idZona;
    }
    
}
