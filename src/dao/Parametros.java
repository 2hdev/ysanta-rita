package dao;

import conexion.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

public class Parametros {

    static Connection con;
    modelos.Auditoria au;

    public modelos.Empresa getEmpresa() {
        modelos.Empresa e = null;
        try {
            con = Conectar.getConnect();
            Statement sent = con.createStatement();
            ResultSet rs = sent.executeQuery("SELECT e.nombre_emp, e.direccion_emp, e.telefono_emp, e.ruc_emp FROM empresa e");
            if (rs.next()) {
                e = new modelos.Empresa();
                e.setNombre(rs.getString("e.nombre_emp"));
                e.setDireccion(rs.getString("e.direccion_emp"));
                e.setTelefono(rs.getString("e.telefono_emp"));
                e.setRUC(rs.getString("e.ruc_emp"));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Parametros.class.getName()).log(Level.SEVERE, "Error al intentar obtener empresa: ", ex);
        }
        return e;
    }

    public boolean insertarParametros(modelos.Empresa emp, modelos.Parametros p) {
        con = Conectar.getConnect();
        PreparedStatement ps, ps1, ps2;
        try {
            con.setAutoCommit(false);

            ps1 = con.prepareStatement("SET @usuario = ?");
            ps1.setString(1, conexion.InicioSesion.getUsuario());
            ps1.execute();

            ps = con.prepareStatement("INSERT INTO empresa(nombre_emp, direccion_emp, telefono_emp, ruc_emp) VALUES(?,?,?,?)");
            ps.setString(1, emp.getNombre());
            ps.setString(2, emp.getDireccion());
            ps.setString(3, emp.getTelefono());
            ps.setString(4, emp.getRUC());
            ps.executeUpdate();

            ps2 = con.prepareStatement("INSERT INTO parametros(preciom3, importe_min, erssan, m3minimo, iva, interes) VALUES(?,?,?,?,?,?)");
            ps2.setInt(1, p.getPreciom3());
            ps2.setInt(2, p.getImportemin());
            ps2.setInt(3, p.getErssan());
            ps2.setInt(4, p.getM3minimo());
            ps2.setInt(5, p.getIva());
            ps2.setDouble(6, p.getInteres());
            ps2.executeUpdate();
            con.commit();

        } catch (SQLException ex) {
            Logger.getLogger(Parametros.class.getName()).log(Level.SEVERE, "Error al intentar insertar parámetros: ", ex);
            return false;
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Parametros.class.getName()).log(Level.SEVERE, "Error al intentar insertar parámetros: --> ", ex);
            }
        }
        return true;
    }

    public boolean contarEmpresa() {
        ResultSet rs;
        Statement sent;
        boolean existe = false;
        try {
            con = Conectar.getConnect();
            sent = con.createStatement();
            rs = sent.executeQuery("SELECT COUNT(*) as cuenta FROM empresa");
            if (rs.next()) {
                existe = rs.getInt("cuenta") != 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Parametros.class.getName()).log(Level.SEVERE, "Error al intentar buscar empresa: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Parametros.class.getName()).log(Level.SEVERE, "Error al intentar buscar empresa: ", ex);
            }
        }
        return existe;
    }

    public String listarParametros() {
        String lista = "";
        try {
            con = Conectar.getConnect();
            Statement sent = con.createStatement();
            ResultSet rs = sent.executeQuery("SELECT e.nombre_emp, e.direccion_emp, e.telefono_emp, e.ruc_emp, "
                    + "p.preciom3, p.importe_min, p.erssan, p.m3minimo, p.iva, p.interes "
                    + "FROM empresa e, parametros p LIMIT 1");
            if (rs.next()) {
                lista += rs.getString("e.nombre_emp") + ",";
                lista += rs.getString("e.direccion_emp") + ",";
                lista += rs.getString("e.telefono_emp") + ",";
                lista += rs.getString("e.ruc_emp") + ",";
                lista += rs.getString("p.preciom3") + ",";
                lista += rs.getString("p.importe_min") + ",";
                lista += rs.getString("p.erssan") + ",";
                lista += rs.getString("p.m3minimo") + ",";
                lista += rs.getString("p.iva") + ",";
                lista += rs.getString("p.interes");
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Parametros.class.getName()).log(Level.SEVERE, "Error al intentar listar parámetros: ", ex);
        }
        return lista;
    }

    public modelos.Parametros obtenerParametros() {
        modelos.Parametros p = null;
        try {
            con = Conectar.getConnect();
            Statement sent = con.createStatement();
            ResultSet rs = sent.executeQuery("SELECT p.preciom3, p.importe_min, p.erssan, p.m3minimo, p.iva FROM parametros p");
            if (rs.next()) {
                p = new modelos.Parametros();
                p.setPreciom3(rs.getInt("p.preciom3"));
                p.setImportemin(rs.getInt("p.importe_min"));
                p.setErssan(rs.getInt("p.erssan"));
                p.setM3minimo(rs.getInt("p.m3minimo"));
                p.setIva(rs.getInt("p.iva"));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Parametros.class.getName()).log(Level.SEVERE, "Error al intentar obtener parámetros: ", ex);
        }
        return p;
    }

    public boolean actualizarParametros(Map<String, String> valoresEmpresa, Map<String, String> valoresParametros) {

        con = Conectar.getConnect();
        PreparedStatement ps, ps1, ps2;
        try {
            con.setAutoCommit(false);

            ps1 = con.prepareStatement("SET @usuario = ?");
            ps1.setString(1, conexion.InicioSesion.getUsuario());
            ps1.execute();

            if (valoresEmpresa.size() > 0) {
                String sentenciae = String.format("UPDATE empresa SET %s", StringUtils.join(valoresEmpresa.keySet(), ","));
                ps = con.prepareStatement(sentenciae);
                int p = 1;
                for (String key : valoresEmpresa.keySet()) {
                    ps.setString(p++, valoresEmpresa.get(key));
                }
                ps.executeUpdate();
            }

            if (valoresParametros.size() > 0) {
                String sentenciap = String.format("UPDATE parametros SET %s", StringUtils.join(valoresParametros.keySet(), ","));
                ps2 = con.prepareStatement(sentenciap);
                int p = 1;
                for (String key : valoresParametros.keySet()) {
                    ps2.setString(p++, valoresParametros.get(key));
                }
                ps2.executeUpdate();
            }
            con.commit();
        } catch (SQLException ex) {
            Logger.getLogger(Parametros.class.getName()).log(Level.SEVERE, "Error al intentar actualizar parámetros: ", ex);
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Parametros.class.getName()).log(Level.SEVERE, "Error al intentar actualizar parámetros: ---> ", ex1);
            }
            return false;
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Parametros.class.getName()).log(Level.SEVERE, "Error al intentar actualizar parámetros: --> ", ex);
            }
        }
        return true;
    }
}
