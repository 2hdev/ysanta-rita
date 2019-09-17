package modelos;

import java.util.Date;

public class Comprobante {
    
    private Date fechaAnterior;
    private Date fechaActual;
    private Integer lecturaAnterior; //lectura = estado del medidor
    private Integer lecturaActual;
    private Date fechaVencimiento;
    private int IVA10;
    private int ERSSAN;
    private String estado; //pendiente, pagado
    private String idUsuario;
    private Integer idLectura;
    private Integer idComprobante;
    private Integer idLoteFac;
    private Integer idZona;
    private int m3Minimo, m3Excedente, m3Total, impMinimo, impExcedente, impTotal;

    public Comprobante() {
    }

    public Date getFechaAnterior() {
        return fechaAnterior;
    }

    public void setFechaAnterior(Date fechaAnterior) {
        this.fechaAnterior = fechaAnterior;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public int getLecturaAnterior() {
        return lecturaAnterior;
    }

    public void setLecturaAnterior(Integer lecturaAnterior) {
        this.lecturaAnterior = lecturaAnterior;
    }

    public int getLecturaActual() {
        return lecturaActual;
    }

    public void setLecturaActual(Integer lecturaActual) {
        this.lecturaActual = lecturaActual;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getIVA10() {
        return IVA10;
    }

    public void setIVA10(int IVA10) {
        this.IVA10 = IVA10;
    }

    public int getERSSAN() {
        return ERSSAN;
    }

    public void setERSSAN(int ERSSAN) {
        this.ERSSAN = ERSSAN;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdLectura() {
        return idLectura;
    }

    public void setIdLectura(Integer idLectura) {
        this.idLectura = idLectura;
    }

    public Integer getIdLoteFac() {
        return idLoteFac;
    }

    public void setIdLoteFac(Integer idLoteFac) {
        this.idLoteFac = idLoteFac;
    }

    public Integer getIdZona() {
        return idZona;
    }

    public void setIdZona(Integer idZona) {
        this.idZona = idZona;
    }

    public int getM3Minimo() {
        return m3Minimo;
    }

    public void setM3Minimo(int m3Minimo) {
        this.m3Minimo = m3Minimo;
    }

    public int getM3Excedente() {
        return m3Excedente;
    }

    public void setM3Excedente(int m3Excedente) {
        this.m3Excedente = m3Excedente;
    }

    public int getM3Total() {
        return m3Total;
    }

    public void setM3Total(int m3Total) {
        this.m3Total = m3Total;
    }

    public int getImpMinimo() {
        return impMinimo;
    }

    public void setImpMinimo(int impMinimo) {
        this.impMinimo = impMinimo;
    }

    public int getImpExcedente() {
        return impExcedente;
    }

    public void setImpExcedente(int impExcedente) {
        this.impExcedente = impExcedente;
    }

    public int getImpTotal() {
        return impTotal;
    }

    public void setImpTotal(int impTotal) {
        this.impTotal = impTotal;
    }

    public Integer getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(Integer idComprobante) {
        this.idComprobante = idComprobante;
    }

    @Override
    public String toString() {
        return ""+ idComprobante + "";
    }
    
}
