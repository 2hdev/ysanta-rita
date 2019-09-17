package conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author LAFI
 */
public class Conectar {

    private static Connection conex;
    private static final BasicDataSource BDS = new BasicDataSource();

    public static BasicDataSource getConexion() {
        BDS.setDriverClassName("com.mysql.jdbc.Driver");
        BDS.setUsername(modelos.Conexion.getUsuario());
        BDS.setPassword(modelos.Conexion.getPass());
        BDS.setUrl("jdbc:mysql://" + modelos.Conexion.getIp() + (modelos.Conexion.getPuerto().equals("") ? "" : (":" + modelos.Conexion.getPuerto())) + "/" + modelos.Conexion.getBd());
        return BDS;
    }

    public static Connection getConnect() {
        try {
            conex = getConexion().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conex;
    }

    public static boolean probarConexion(String ip, String db, String puerto, String user, String pass) {
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName("com.mysql.jdbc.Driver");
        bds.setUsername(modelos.Conexion.getUsuario());
        bds.setPassword(modelos.Conexion.getPass());
        bds.setUrl("jdbc:mysql://" + ip + (puerto.equals("") ? "" : (":" + puerto)) + "/" + db);

        try {
            conex = bds.getConnection();
            if (conex != null || !conex.isClosed()) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, "Error al intentar probar conexión: ", e);
            return false;
        } finally {
            if (conex != null) {
                try {
                    conex.close();
                    bds.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, "Error al intentar probar conexión: --> ", ex);
                }
            }
        }
        return false;
    }
}
