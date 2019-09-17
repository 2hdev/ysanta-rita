package dao;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import conexion.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

public class Zonas {
    
    static Connection con;
    modelos.Auditoria au;
    
    public static List<modelos.Zona> listaZonas(){
        
        List<modelos.Zona> lz = null;
        con = Conectar.getConnect();
        try{
            Statement sent = con.createStatement();
            ResultSet rs = sent.executeQuery("SELECT id_zona, zona, descripcion FROM zonas");           
            lz = new ArrayList<>();
            while(rs.next()){
                modelos.Zona z = new modelos.Zona();
                z.setIdentificador(rs.getInt("id_zona"));
                z.setZona(rs.getString("zona"));
                z.setDescripcion(rs.getString("descripcion"));
                lz.add(z);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Zonas.class.getName()).log(Level.SEVERE, "Error al intentar listar zonas: ", ex);
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Zonas.class.getName()).log(Level.SEVERE, "Error al intentar listar zonas: --> ", ex);
            }
        }
        
        return lz;
    }
    
    public static List<modelos.Zona> listaZonasxLote(int idLote){
        
        List<modelos.Zona> lz = null;
        con = Conectar.getConnect();
        try{
            PreparedStatement ps = con.prepareStatement("SELECT id_zona, zona FROM zonas WHERE id_zona "
                    + "IN(SELECT id_zona FROM comprobantes WHERE id_LoteFac = ? AND estado != 'ELIMINADO')");
            ps.setInt(1, idLote);
            ResultSet rs = ps.executeQuery();           
            lz = new ArrayList<>();
            while(rs.next()){
                modelos.Zona z = new modelos.Zona();
                z.setIdentificador(rs.getInt("id_zona"));
                z.setZona(rs.getString("zona"));
                lz.add(z);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Zonas.class.getName()).log(Level.SEVERE, "Error al intentar listar zonas por lote: ", ex);
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Zonas.class.getName()).log(Level.SEVERE, "Error al intentar actualizar zona: --> ", ex);
            }
        }
        
        return lz;
    }
    
    public boolean insertarZona(modelos.Zona zona){
        con = Conectar.getConnect();
        PreparedStatement ps, ps1;
        try {
            con.setAutoCommit(false);
            
            ps1 = con.prepareStatement("SET @usuario = ?");
            ps1.setString(1, conexion.InicioSesion.getUsuario());
            ps1.execute();
            
            ps = con.prepareStatement("INSERT INTO zonas(zona, descripcion) VALUES(?, ?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, zona.getZona());
            ps.setString(2, zona.getDescripcion());
            ps.executeUpdate();
            
            con.commit();
            
        }
        catch (SQLException ex) {
            try {
                if(con != null) con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Zonas.class.getName()).log(Level.SEVERE, "Error al intentar actualizar zona: ---> ", ex1);
            }
            Logger.getLogger(Zonas.class.getName()).log(Level.SEVERE, "Error al intentar insertar zona: ", ex);
            return false;
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Zonas.class.getName()).log(Level.SEVERE, "Error al intentar insertar zona: --> ", ex);
            }
        } 
        return true;
    }    
    
    public boolean actualizarZona(modelos.Zona zant, List<String> parametros, List<String> valores, int idZona){
        
        con = Conectar.getConnect();
        PreparedStatement ps, ps1;
        try {
            con.setAutoCommit(false);
            if(parametros.size()>0){
                
                ps1 = con.prepareStatement("SET @usuario = ?");
                ps1.setString(1, conexion.InicioSesion.getUsuario());
                ps1.execute();
                
                String sentencia = String.format("UPDATE zonas SET %s WHERE id_zona=?", StringUtils.join(parametros, ","));
                System.out.println(sentencia);
                ps = con.prepareStatement(sentencia);
                int p = 1;
                for (String key : valores) {
                    ps.setString(p++, key);
                }
                ps.setInt(p++, idZona);
                ps.executeUpdate();
            }
            
        con.commit();
        }
        catch (SQLException ex) {
            Logger.getLogger(Zonas.class.getName()).log(Level.SEVERE, "Error al intentar actualizar zona: ", ex);
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Zonas.class.getName()).log(Level.SEVERE, "Error al intentar actualizar zona: ---> ", ex1);
            }
            return false;
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            }
            catch (SQLException ex) {
                Logger.getLogger(Zonas.class.getName()).log(Level.SEVERE, "Error al intentar actualizar zona: --> ", ex);
            }
        }
        return true;
    }
    
    public static JsonArray listaComprobantesxZona(int idLote, int idZona){
        JsonArray ja = new JsonArray();
        con = Conectar.getConnect();
        try{
            PreparedStatement ps = con.prepareStatement("SELECT c.id_comprobante, c.fecha_act, c.id_usuario, u.nombre_usu, u.apellido_usu, m.numero_med, c.impTotal as total, c.id_lectura, c.lec_actual, l.es_actual, c.estado, l.id_medidor "
                    + "FROM comprobantes c, cuentas cu, medidores_por_cuentas mc, usuarios u, medidores m, zonas z, lecturas l "
                    + "WHERE c.id_usuario = u.id_usuario AND cu.id_usuario = c.id_usuario AND l.id_medidor = m.id_medidor AND c.id_lectura = l.id_lectura "
                    + "AND mc.id_medidor = l.id_medidor AND mc.id_cuenta = cu.id_cuenta AND z.id_zona = c.id_zona AND id_LoteFac = ? AND z.id_zona = ? "
                    + "AND l.es_actual != 'T' AND c.estado != 'ELIMINADO' ORDER BY c.id_comprobante DESC");
            ps.setInt(1, idLote);
            ps.setInt(2, idZona);
            ResultSet rs = ps.executeQuery();           
            while(rs.next()){
                JsonObject o = new JsonObject();
                o.addProperty("idComprobante", rs.getInt("c.id_comprobante"));
                o.addProperty("fecha", utilidades.Estaticos.FORMATODMA.format(rs.getDate("c.fecha_act")));
                o.addProperty("idUsuario", rs.getInt("c.id_usuario"));
                o.addProperty("nombreAp", rs.getString("u.nombre_usu")+" "+rs.getString("u.apellido_usu"));
                o.addProperty("numeroMed", rs.getString("m.numero_med"));
                o.addProperty("impTotal", rs.getInt("total"));
                o.addProperty("numLectura", rs.getString("c.id_lectura"));
                o.addProperty("lectura", rs.getInt("c.lec_actual"));
                o.addProperty("actual", rs.getString("l.es_actual"));
                o.addProperty("estado", rs.getString("c.estado"));
                o.addProperty("idMedidor", rs.getInt("l.id_medidor"));
                ja.add(o);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Zonas.class.getName()).log(Level.SEVERE, "Error al intentar listar comprobantes por zona: ", ex);
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Zonas.class.getName()).log(Level.SEVERE, "Error al intentar listar comprobantes por zona: --> ", ex);
            }
        }        
        return ja;
    }
}
