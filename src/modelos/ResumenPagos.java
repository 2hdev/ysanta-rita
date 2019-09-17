/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author 2HDEV
 */
public class ResumenPagos {

    int id_usuario;
    String nombre_usu;
    String numFactura;
    Long saldo_mes;
    int IVA10;
    long saldo_anterior;
    long saldo_acumulado;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usu() {
        return nombre_usu;
    }

    public void setNombre_usu(String nombre_usu) {
        this.nombre_usu = nombre_usu;
    }

    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public int getIVA10() {
        return IVA10;
    }

    public void setIVA10(int IVA10) {
        this.IVA10 = IVA10;
    }

    public Long getSaldo_mes() {
        return saldo_mes;
    }

    public void setSaldo_mes(Long saldo_mes) {
        this.saldo_mes = saldo_mes;
    }

    public long getSaldo_anterior() {
        return saldo_anterior;
    }

    public void setSaldo_anterior(long saldo_anterior) {
        this.saldo_anterior = saldo_anterior;
    }

    public long getSaldo_acumulado() {
        return saldo_acumulado;
    }

    public void setSaldo_acumulado(long saldo_acumulado) {
        this.saldo_acumulado = saldo_acumulado;
    }

}
