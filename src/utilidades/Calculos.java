package utilidades;

public final class Calculos {
    
    modelos.Parametros mp;
    dao.Parametros p;
    private Integer lecturaActual, lecturaAnterior, excedente, total, totalConIVA, excedenteM3, ERSSAN, totalM3, IVA;
    /*Orden de llamada:
        calculartotalm3, calcularexcedentem3, getexcedentem3, calcularexcedente, calculartotal, gettotal
        calcularerrsan, calculartotalconiva, calculariva
     */
    public Calculos(Integer lecturaActual, Integer lecturaAnterior) {
        p = new dao.Parametros();
        mp = p.obtenerParametros();
        this.lecturaActual = lecturaActual;
        this.lecturaAnterior = lecturaAnterior;
        calcularTotalM3(lecturaActual, lecturaAnterior);
        calcularExcedentem3();
        calcularExcedente();
        calcularTotal();
        calcularERSSAN();
        calcularTotalConIVA();
        calcularIVA();
    }

    public Integer getExcedenteM3() {
        return excedenteM3;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getExcedente() {
        return excedente;
    }

    public Integer getERSSAN() {
        return ERSSAN;
    }
    
    public Integer getM3Minimo(){
        return mp.getM3minimo();
    }
    
    public Integer getTotalM3(){
        return totalM3;
    }
    
    public Integer getImporteMinimo(){
        return mp.getImportemin();
    }

    public Integer getIVA() {
        return IVA;
    }

    private Integer calcularERSSAN(){
        java.math.BigDecimal tot = new java.math.BigDecimal(java.math.BigDecimal.valueOf(mp.getErssan()).toString()).divide(java.math.BigDecimal.valueOf(100)).multiply(java.math.BigDecimal.valueOf(getTotal()));
        this.ERSSAN = tot.setScale(0, java.math.RoundingMode.HALF_UP).intValueExact();
        return ERSSAN;
    }
    
    private void calcularTotal(){
        this.total = mp.getImportemin()+calcularExcedente();
    }
    
    private Integer calcularTotalConIVA(){
        this.totalConIVA = (((mp.getIva()+100)*getTotal())/100);
        return totalConIVA;
    }
    
    public Integer getTotalConIVA(){
        //System.out.println("El total con IVA es: "+totalConIVA);
        return totalConIVA;
    }
    
    private void calcularIVA(){
        this.IVA = ((getTotalConIVA()*mp.getIva())/(mp.getIva()+100));//getTotal()/mp.getIva();
    }
    
    private void calcularTotalM3(Integer lecturaActual, Integer lecturaAnterior){
        this.totalM3 = lecturaActual - lecturaAnterior;
    }
    
    private void calcularExcedentem3(){
        this.excedenteM3 = (getTotalM3()-mp.getM3minimo())<0?0:(getTotalM3()-mp.getM3minimo()); 
    }
    
    private Integer calcularExcedente(){
        this.excedente = getExcedenteM3()*mp.getPreciom3();
        return excedente;
    }
    
    public Calculos(Integer total){
        p = new dao.Parametros();
        mp = p.obtenerParametros();
        calcularERSSAN(total);
    }
    
    private Integer calcularERSSAN(Integer total){
        java.math.BigDecimal tot = (new java.math.BigDecimal(java.math.BigDecimal.valueOf(mp.getErssan()).toString())
                .divide(java.math.BigDecimal.valueOf(100)))
                .multiply(
                java.math.BigDecimal.valueOf(total).subtract(
                    (java.math.BigDecimal.valueOf(total).multiply(
                            java.math.BigDecimal.valueOf(mp.getIva())))
                                .divide(java.math.BigDecimal.valueOf(mp.getIva()).add(java.math.BigDecimal.valueOf(100)), 2)
                    )
                );
        this.ERSSAN = tot.setScale(0, java.math.RoundingMode.HALF_UP).intValueExact();
        return ERSSAN;
    }
}