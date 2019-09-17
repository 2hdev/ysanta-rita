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
public class Cargos {

    int id_cargo;
    int cantidad;
    String concepto_cargo;
    int monto_cargo;
    int close_cargo;
    int subtotal;

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getConcepto_cargo() {
        return concepto_cargo;
    }

    public void setConcepto_cargo(String concepto_cargo) {
        this.concepto_cargo = concepto_cargo;
    }

    public int getMonto_cargo() {
        return monto_cargo;
    }

    public void setMonto_cargo(int monto_cargo) {
        this.monto_cargo = monto_cargo;
    }

    public int getClose_cargo() {
        return close_cargo;
    }

    public void setClose_cargo(int close_cargo) {
        this.close_cargo = close_cargo;
    }

}
