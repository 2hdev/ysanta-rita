package conexion;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;

public class Conexiones {
    
    static Properties props = new Properties();
    
    public static void obtenerConexiones() {
        try {
            java.io.File jarFile = new java.io.File(utilidades.Estaticos.RUTA_APP.toString()+"/etc/db.properties");
            try (FileInputStream in = new FileInputStream(jarFile)) {
                props.load(in);
            }
            modelos.Conexion.setIp(props.getProperty("ip"));
            modelos.Conexion.setPuerto(props.getProperty("port"));
            modelos.Conexion.setBd(props.getProperty("db"));
            modelos.Conexion.setUsuario(props.getProperty("user"));
            modelos.Conexion.setPass(props.getProperty("pass"));
        }
        catch (IOException ex) {
            java.util.logging.Logger.getLogger(Conexiones.class.getName()).log(Level.WARNING, "Error al leer el archivo de conexión: ", ex);
        }
    }
    
}
