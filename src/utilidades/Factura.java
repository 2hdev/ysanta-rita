package utilidades;

import java.math.BigDecimal;

public class Factura {
    
    public static Integer calcularIVA5(Integer monto){
        java.math.BigDecimal tot = new java.math.BigDecimal(monto).divide(BigDecimal.valueOf(21), 0, java.math.RoundingMode.HALF_UP);
        Integer iva5 = tot.setScale(0, java.math.RoundingMode.HALF_UP).intValueExact();
        return iva5;
    }
    
    public static Integer calcularIVA10(Integer monto){
        java.math.BigDecimal tot = new java.math.BigDecimal(monto).divide(BigDecimal.valueOf(11), 0, java.math.RoundingMode.HALF_UP);
        Integer iva10 = tot.setScale(0, java.math.RoundingMode.HALF_UP).intValueExact();
        return iva10;
    }
    
}
