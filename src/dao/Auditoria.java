package dao;

import conexion.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Auditoria {
    
    static Connection con;
    
    public static boolean AfterInsert(modelos.Auditoria au) {
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO auditoria(id_auditado, tabla_auditada, detalle_auditado, "
                    + "accion_auditado, fecha_hora_auditado, autor_auditado) VALUES(?, ?, ? ,?, NOW(), ?)");
            ps.setString(1, au.getIdAuditado());
            ps.setString(2, au.getTablaAuditada());
            ps.setString(3, au.getDetalleAuditado());
            ps.setString(4, au.getAccion());
            ps.setString(5, au.getAutor());
            ps.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Auditoria.class.getName()).log(Level.SEVERE, "Error en Auditoría: ", ex);
            return false;
        }
        finally {
            try {
                if(!con.isClosed()) con.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(Auditoria.class.getName()).log(Level.SEVERE, "Error en Auditoría: -->", ex);
            }
        }
        return true;
    }
    
    public List<modelos.Auditoria> listarAuditoria(){
        List<modelos.Auditoria> la = null;
        con = Conectar.getConnect();
        try{
            Statement sent = con.createStatement();
            ResultSet rs = sent.executeQuery("SELECT id_auditoria, id_auditado, tabla_auditada, detalle_auditado, "
                    + "accion_auditado, DATE_FORMAT(fecha_hora_auditado, \"%d/%m/%Y %T\") as fechahora, autor_auditado FROM auditoria "
                    + "ORDER BY id_auditoria DESC");           
            la = new ArrayList<>();
            while(rs.next()){
                modelos.Auditoria a = new modelos.Auditoria();
                a.setIdentificador(rs.getString("id_auditoria"));
                a.setIdAuditado(rs.getString("id_auditado"));
                a.setTablaAuditada(rs.getString("tabla_auditada"));
                a.setDetalleAuditado(rs.getString("detalle_auditado"));
                a.setAccion(rs.getString("accion_auditado"));
                a.setFechaHora(rs.getString("fechahora"));
                a.setAutor(rs.getString("autor_auditado"));
                la.add(a);
            }
        }
        catch(SQLException ex){
            java.util.logging.Logger.getLogger(Auditoria.class.getName()).log(Level.WARNING, "Error al listar info Auditoría: ", ex);
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(Auditoria.class.getName()).log(Level.WARNING, "Error en Auditoría: -->", ex);
            }
        }
        
        return la;
    }
    
}