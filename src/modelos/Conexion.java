
package modelos;

public class Conexion {
    
    private static String ip;
    private static String puerto;
    private static String bd;
    private static String usuario;
    private static String pass;

    public static String getIp() {
        return ip;
    }

    public static void setIp(String ip) {
        Conexion.ip = ip;
    }

    public static String getPuerto() {
        return puerto;
    }

    public static void setPuerto(String puerto) {
        Conexion.puerto = puerto;
    }

    public static String getBd() {
        return bd;
    }

    public static void setBd(String bd) {
        Conexion.bd = bd;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        Conexion.usuario = usuario;
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        Conexion.pass = pass;
    }   
    
}
