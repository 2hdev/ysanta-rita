package modelos;

public class Zona {
    
    private Integer identificador;
    private String descripcion;
    private String zona;

    public Zona(Integer identificador, String descripcion, String zona) {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.zona = zona;
    }

    public Zona() {
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    @Override
    public String toString() {
        return ""+ identificador + " - "+zona + "";
    }
}
