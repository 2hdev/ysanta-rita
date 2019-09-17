package modelos;


public class Factura {
    
    private String codDetalle;
    private Integer cantDetalle;
    private String descDetalle;
    private Integer precioUnitDetalle;
    private Integer exentaDetalle;
    private Integer cDetalle;
    private Integer dDetalle;

    public Factura(String codDetalle, Integer cantDetalle, String descDetalle, Integer precioUnitDetalle, Integer exentaDetalle, Integer cDetalle, Integer dDetalle) {
        this.codDetalle = codDetalle;
        this.cantDetalle = cantDetalle;
        this.descDetalle = descDetalle;
        this.precioUnitDetalle = precioUnitDetalle;
        this.exentaDetalle = exentaDetalle;
        this.cDetalle = cDetalle;
        this.dDetalle = dDetalle;
    }

    public Factura() {
    }

    public String getCodDetalle() {
        return codDetalle;
    }

    public void setCodDetalle(String codDetalle) {
        this.codDetalle = codDetalle;
    }

    public Integer getCantDetalle() {
        return cantDetalle;
    }

    public void setCantDetalle(Integer cantDetalle) {
        this.cantDetalle = cantDetalle;
    }

    public String getDescDetalle() {
        return descDetalle;
    }

    public void setDescDetalle(String descDetalle) {
        this.descDetalle = descDetalle;
    }

    public Integer getPrecioUnitDetalle() {
        return precioUnitDetalle;
    }

    public void setPrecioUnitDetalle(Integer precioUnitDetalle) {
        this.precioUnitDetalle = precioUnitDetalle;
    }

    public Integer getExentaDetalle() {
        return exentaDetalle;
    }

    public void setExentaDetalle(Integer exentaDetalle) {
        this.exentaDetalle = exentaDetalle;
    }

    public Integer getcDetalle() {
        return cDetalle;
    }

    public void setcDetalle(Integer cDetalle) {
        this.cDetalle = cDetalle;
    }

    public Integer getdDetalle() {
        return dDetalle;
    }

    public void setdDetalle(Integer dDetalle) {
        this.dDetalle = dDetalle;
    }
    
}
