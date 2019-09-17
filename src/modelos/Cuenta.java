package modelos;

import java.util.List;

public class Cuenta {
    private Integer identificador;
    private Integer usuario;
    private Integer saldoComprobantes;
    private Integer saldoDC;
    private Integer saldoAFavor;
    private List<Medidor> medidores;

    public Cuenta(Integer identificador, Integer usuario, Integer saldoComprobantes, Integer saldoDC, Integer saldoAFavor, List<Medidor> medidores) {
        this.identificador = identificador;
        this.usuario = usuario;
        this.saldoComprobantes = saldoComprobantes;
        this.saldoDC = saldoDC;
        this.saldoAFavor = saldoAFavor;
        this.medidores = medidores;
    }

    public Cuenta() {
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public Integer getSaldoComprobantes() {
        return saldoComprobantes;
    }

    public void setSaldoComprobantes(Integer saldoComprobantes) {
        this.saldoComprobantes = saldoComprobantes;
    }

    public Integer getSaldoDC() {
        return saldoDC;
    }

    public void setSaldoDC(Integer saldoDC) {
        this.saldoDC = saldoDC;
    }

    public Integer getSaldoAFavor() {
        return saldoAFavor;
    }

    public void setSaldoAFavor(Integer saldoAFavor) {
        this.saldoAFavor = saldoAFavor;
    }

    public List<Medidor> getMedidores() {
        return medidores;
    }

    public void setMedidores(List<Medidor> medidores) {
        this.medidores = medidores;
    }

    @Override
    public String toString() {
        if(medidores != null){
            if(medidores.size()>0){
                if(medidores.get(0).getIdentificador() != null) return "" + identificador;
                else return "" + identificador + " " + medidores + "";
            }
            else return "" + identificador;
        }
        else return "" + identificador;
    }
    
}
