package modelos;

public class ResumenCuenta {
    
    private String nomape, numcuenta, nummedidor;
    private Integer saldoanterior, saldo, derconex, saldoafavor;

    public ResumenCuenta() {
    }

    public String getNomape() {
        return nomape;
    }

    public void setNomape(String nomape) {
        this.nomape = nomape;
    }

    public String getNumcuenta() {
        return numcuenta;
    }

    public void setNumcuenta(String numcuenta) {
        this.numcuenta = numcuenta;
    }

    public String getNummedidor() {
        return nummedidor;
    }

    public void setNummedidor(String nummedidor) {
        this.nummedidor = nummedidor;
    }

    public Integer getSaldoanterior() {
        return saldoanterior;
    }

    public void setSaldoanterior(Integer saldoanterior) {
        this.saldoanterior = saldoanterior;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public Integer getDerconex() {
        return derconex;
    }

    public void setDerconex(Integer derconex) {
        this.derconex = derconex;
    }

    public Integer getSaldoafavor() {
        return saldoafavor;
    }

    public void setSaldoafavor(Integer saldoafavor) {
        this.saldoafavor = saldoafavor;
    }
    
}
