package modelos;

public class Recibo {
    
    private String numRecibo;
    private String fecha;
    private Integer importeRecibo;
    private String sumaRec;
    private String nombreRec;
    private String conceptoRec;

    public Recibo() {
    }
    
    public String getNumRecibo() {
        return numRecibo;
    }

    public void setNumRecibo(String numRecibo) {
        this.numRecibo = numRecibo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getImporteRecibo() {
        return importeRecibo;
    }

    public void setImporteRecibo(Integer importeRecibo) {
        this.importeRecibo = importeRecibo;
    }

    public String getSumaRec() {
        return sumaRec;
    }

    public void setSumaRec(String sumaRec) {
        this.sumaRec = sumaRec;
    }

    public String getNombreRec() {
        return nombreRec;
    }

    public void setNombreRec(String nombreRec) {
        this.nombreRec = nombreRec;
    }

    public String getConceptoRec() {
        return conceptoRec;
    }

    public void setConceptoRec(String conceptoRec) {
        this.conceptoRec = conceptoRec;
    }
    
    
    
}
