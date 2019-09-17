package modelos;

import java.io.File;
import org.apache.commons.io.FilenameUtils;

public class Archivos {

    File archivo;
    String nombre;
    String ubicacion;

    public Archivos() {
    
    }
    
    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
        this.nombre =  FilenameUtils.removeExtension(archivo.getName());
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = archivo.getAbsolutePath();
    }
    
    @Override
    public String toString() {
        return ""+ nombre +"";
    }
}
