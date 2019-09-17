package modelos;

public class ComprobanteInterno {
    
    String numcuenta, numMedidor, nomApe, numComprobante, estadoComprobante;
    Integer saldoAnterior, saldoActual;

    public ComprobanteInterno() {
    }

    public String getNumcuenta() {
        return numcuenta;
    }

    public void setNumcuenta(String numcuenta) {
        this.numcuenta = numcuenta;
    }

    public String getNumMedidor() {
        return numMedidor;
    }

    public void setNumMedidor(String numMedidor) {
        this.numMedidor = numMedidor;
    }

    public String getNomApe() {
        return nomApe;
    }

    public void setNomApe(String nomApe) {
        this.nomApe = nomApe;
    }

    public String getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(String numComprobante) {
        this.numComprobante = numComprobante;
    }

    public String getEstadoComprobante() {
        return estadoComprobante;
    }

    public void setEstadoComprobante(String estadoComprobante) {
        this.estadoComprobante = estadoComprobante;
    }

    public Integer getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(Integer saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public Integer getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(Integer saldoActual) {
        this.saldoActual = saldoActual;
    }
    
}
