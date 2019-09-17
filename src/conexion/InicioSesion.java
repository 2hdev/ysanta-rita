package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InicioSesion {

    private static String usuario;

    public boolean iniciarSesion(String alias, String pass) {
        boolean inicio = false;
        try {
            Connection con = Conectar.getConnect();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE alias_usuario = ? AND pass_usuario = SUBSTRING(SHA2(?, 0),1,32)");
            ps.setString(1, alias);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            inicio = (rs.next());

            if (inicio) {
                setUsuario(alias);
                Logger.getLogger(InicioSesion.class.getName()).log(Level.INFO, "{0} inici\u00f3 sesi\u00f3n.", alias);
            } else {
                Logger.getLogger(InicioSesion.class.getName()).log(Level.WARNING, "Usuario o contraseña incorrectos.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, "Error en llamada: ", ex);
        }
        return inicio;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static final void setUsuario(String usuario) {
        InicioSesion.usuario = usuario;
    }

}
