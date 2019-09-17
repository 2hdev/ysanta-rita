package dao;

import conexion.Conectar;
import java.sql.CallableStatement;
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
import utilidades.Funciones;

public class Medidor {
    
    static Connection con;
    
    public static List<modelos.Medidor> medidoresAsignados(int idCuenta){        
        List<modelos.Medidor> m = new ArrayList<>();
        con = Conectar.getConnect();
        try{
            PreparedStatement ps = con.prepareStatement("SELECT m.id_medidor, m.numero_med FROM medidores m, medidores_por_cuentas mc WHERE mc.id_medidor = m.id_medidor AND mc.id_cuenta = ? AND m.estado_med = ?");
            ps.setInt(1, idCuenta);
            ps.setString(2, "ACTIVO");
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                modelos.Medidor me = new modelos.Medidor();
                me.setNumeroMedidor(rs.getString("numero_med"));
                me.setIdentificador(rs.getInt("id_medidor"));
                m.add(me);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar obtener medidores asignados: ", ex);
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar obtener medidores asignados: --> ", ex);
            }
        }
        return m;
    }
    
    public boolean verificarMedidor(String num_med){
        boolean existe = false;
        con = Conectar.getConnect();
        PreparedStatement ps;
        try{
            ps = con.prepareStatement("SELECT COUNT(numero_med) AS cuenta FROM medidores WHERE numero_med = ?");
            ps.setString(1, num_med);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                existe = (rs.getInt("cuenta") > 0);                
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar verificar medidor: ", ex);
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar verificar medidor: --> ", ex);
            }
        }
        return existe;
    }
    
    public boolean verificarMedidor(String num_med, int idMedidor){
        boolean existe = false;
        con = Conectar.getConnect();
        PreparedStatement ps;
        try{
            ps = con.prepareStatement("SELECT COUNT(numero_med) AS cuenta FROM medidores WHERE numero_med = ? AND id_medidor != ?");
            ps.setString(1, num_med);
            ps.setInt(2, idMedidor);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                existe = (rs.getInt("cuenta") > 0);                
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar verificar medidor: ", ex);
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar verificar medidor: ", ex);
            }
        }
        return existe;
    }
    
    public boolean insertarMedidor(modelos.Medidor m, modelos.Lectura l, String idCuenta){
        con = Conectar.getConnect();
        PreparedStatement ps, ps1;
        CallableStatement cs;
        int id = 0;
        try {
            java.sql.Date fechalect = Funciones.utilDateaSqlDate(l.getFechaLectura());
            con.setAutoCommit(false);
            
            ps1 = con.prepareStatement("SET @usuario = ?");
            ps1.setString(1, conexion.InicioSesion.getUsuario());
            ps1.execute();
            
            cs = con.prepareCall("{CALL insertarMedidor(?,?,?,?)}");
            cs.setString(1, m.getNumeroMedidor());
            cs.setString(2, m.getDescripcion());
            cs.setString(3, m.getObservacion());
            cs.registerOutParameter(4, java.sql.Types.INTEGER);
            cs.execute();
            id = cs.getInt(4);
            l.setIdMedidor(id);
            
            ps = con.prepareStatement("INSERT INTO lecturas(lectura, fecha_lec, id_medidor) VALUES(?,?,?)");
            ps.setInt(1, l.getLectura());
            ps.setDate(2, fechalect);
            ps.setInt(3, l.getIdMedidor());
            ps.executeUpdate();
            
            if(idCuenta != null && !idCuenta.trim().equals("")){
                PreparedStatement ps2 = con.prepareStatement("INSERT INTO medidores_por_cuentas(id_cuenta, id_medidor) VALUES(?,?)");
                ps2.setString(1, idCuenta);
                ps2.setInt(2, id);
                ps2.executeUpdate();
            }
            con.commit();
        }
        catch (SQLException ex) {
            try {
                if(con != null) con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar insertar medidor: ---> ", ex1);
            }
            Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar insertar medidor: ", ex);
            return false;
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar insertar medidor: --> ", ex);
            }
        } 
        return true;
        
    }
    
    public List<modelos.Medidor> listarMedidores(){
        List<modelos.Medidor> lm = null;
        con = Conectar.getConnect();
        try{
            Statement sent = con.createStatement();
            ResultSet rs = sent.executeQuery("SELECT m.id_medidor, m.numero_med, "
                    + "MAX(CASE WHEN es_actual = 'S' THEN lectura END) AS lecturaactual, "
                    + "MAX(CASE WHEN es_actual = 'N' THEN lectura END) lecturaanterior "
                    + "FROM medidores m, lecturas l "
                    + "WHERE m.id_medidor = l.id_medidor AND m.estado_med != 'ELIMINADO' "
                    + "GROUP BY l.id_medidor ");           
            lm = new ArrayList<>();
            while(rs.next()){
                modelos.Medidor m = new modelos.Medidor();
                m.setIdentificador(rs.getInt("m.id_medidor"));
                m.setNumeroMedidor(rs.getString("m.numero_med"));
                m.setLecturaActual(rs.getInt("lecturaactual"));
                m.setLecturaAnterior(rs.getInt("lecturaanterior"));
                lm.add(m);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar listar medidores: ", ex);
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar listar medidores: --> ", ex);
            }
        }        
        return lm;
    }
    
    public modelos.Lectura getMedidor(String numMedidor){
        modelos.Lectura l = null;
        con = Conectar.getConnect();
        PreparedStatement ps;
        try{
            ps = con.prepareStatement("SELECT l.lectura AS lecturaactual, l.fecha_lec FROM lecturas l, medidores m WHERE l.id_medidor = m.id_medidor AND m.numero_med = ? AND l.es_actual != 'T' ORDER BY l.id_lectura DESC LIMIT 1");           
            ps.setString(1, numMedidor);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                l = new modelos.Lectura();
                l.setLectura(rs.getInt("lecturaactual"));
                l.setFechaLectura(rs.getDate("l.fecha_lec"));
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar obtener medidor: ", ex);
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar obtener medidor: --> ", ex);
            }
        }
        
        return l;
    }
    
    public modelos.Lectura getLecturaAnteriorPor(String idMedidor, String idLectura){
        modelos.Lectura l = null;      
        con = Conectar.getConnect();
        PreparedStatement ps;
        try{
            ps = con.prepareStatement("SELECT lectura, fecha_lec FROM lecturas WHERE id_medidor = ? AND id_lectura < ? AND es_actual != 'T' ORDER BY id_lectura DESC LIMIT 1");           
            ps.setString(1, idMedidor);
            ps.setString(2, idLectura);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                l = new modelos.Lectura();
                l.setLectura(rs.getInt("lectura"));
                l.setFechaLectura(rs.getDate("fecha_lec"));
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar obtener lectura anterior: ", ex);
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar obtener lectura anterior: --> ", ex);
            }
        }
        return l;
    }
    
    public modelos.Medidor obtenerDetalleMedidor(int idMedidor){
        con = Conectar.getConnect();
        modelos.Medidor m = null;
        try{
            PreparedStatement ps = con.prepareStatement("SELECT m.numero_med, m.descripcion_med, m.obs_med, m.estado_med, mc.id_cuenta "
                    + "FROM medidores m, medidores_por_cuentas mc WHERE mc.id_medidor = m.id_medidor AND m.id_medidor = ?");           
            ps.setInt(1, idMedidor);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                m = new modelos.Medidor();
                m.setIdentificador(idMedidor);
                m.setNumeroMedidor(rs.getString("m.numero_med"));
                m.setDescripcion(rs.getString("m.descripcion_med"));
                m.setObservacion(rs.getString("m.obs_med"));
                m.setNumeroCuenta(rs.getInt("mc.id_cuenta"));
                m.setEstado(rs.getString("m.estado_med"));
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar obtener detalle de medidor: ", ex);
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar obtener detalle de medidor: --> ", ex);
            }
        }
        return m;
    }
       
    public boolean actualizarMedidor(java.util.Map<String, String> valores, int idMedidor){
        con = Conectar.getConnect();
        PreparedStatement ps, ps1;
        try {
            con.setAutoCommit(false);
            if(valores.size()>0){
                
                ps1 = con.prepareStatement("SET @usuario = ?");
                ps1.setString(1, conexion.InicioSesion.getUsuario());
                ps1.execute();
                
                String sentenciae = String.format("UPDATE medidores SET %s WHERE id_medidor=?", StringUtils.join(valores.keySet(), ","));
                System.out.println(sentenciae);
                ps = con.prepareStatement(sentenciae);
                int p = 1;
                for (String key : valores.keySet()) {
                    System.out.println("Valor de p: "+p+" valor: "+key);
                    ps.setString(p++, valores.get(key));
                }
                System.out.println("Valor de p: "+p+" valor: "+idMedidor);
                ps.setInt(p++, idMedidor);
                ps.executeUpdate();
            }
            con.commit();
        }
        catch (SQLException ex) {
            Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar actualizar medidor: ", ex);
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar actualizar medidor: ---> ", ex1);
            }
            return false;
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            }
            catch (SQLException ex) {
                Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar actualizar medidor: --> ", ex);
            }
        }
        return true;
    }
    
    public int insertarLectura(modelos.Lectura l){
        int id = 0;
        con = Conectar.getConnect();
        PreparedStatement ps, ps1;
        CallableStatement cs;
        try {
            java.sql.Date fechalect = Funciones.utilDateaSqlDate(l.getFechaLectura());
            con.setAutoCommit(false);
            
            ps1 = con.prepareStatement("SET @usuario = ?");
            ps1.setString(1, conexion.InicioSesion.getUsuario());
            ps1.execute();
            
            ps = con.prepareStatement("UPDATE lecturas SET es_actual = CASE WHEN es_actual = 'N' THEN 'A' WHEN es_actual = 'S' THEN 'N' WHEN es_actual = 'A' THEN 'A' WHEN es_actual = 'T' THEN 'T' END WHERE id_medidor = ?");
            ps.setInt(1, l.getIdMedidor());
            ps.executeUpdate();
            
            cs = con.prepareCall("{CALL insertarLectura(?,?,?,?)}");
            cs.setInt(1, l.getLectura());
            cs.setDate(2, fechalect);
            cs.setInt(3, l.getIdMedidor());
            cs.registerOutParameter(4, java.sql.Types.INTEGER);
            cs.execute();
            id = cs.getInt(4);
            l.setIdentificador(id);
            con.commit();
            
        }
        catch (SQLException ex) {
            try {
                if(con != null) con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar insertar lectura: ---> ", ex1);
            }
            Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar insertar lectura: ", ex);
            return -1;
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar insertar lectura: --> ", ex);
            }
        } 
        return id;       
    }
    
    public boolean actualizarLectura(modelos.Lectura l){
        con = Conectar.getConnect();
        PreparedStatement ps, ps1;
        try {
            java.sql.Date fechalect = Funciones.utilDateaSqlDate(l.getFechaLectura());
            con.setAutoCommit(false);
            
            ps1 = con.prepareStatement("SET @usuario = ?");
            ps1.setString(1, conexion.InicioSesion.getUsuario());
            ps1.execute();
            
            ps = con.prepareStatement("UPDATE lecturas SET fecha_lec = ?, lectura = ? WHERE id_lectura = ?");
            ps.setDate(1, fechalect);
            ps.setInt(2, l.getLectura());
            ps.setInt(3, l.getIdentificador());
            ps.executeUpdate();
            
            con.commit();
        }
        catch (SQLException ex) {
            try {
                if(con != null) con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar actualizar lectura: ---> ", ex1);
            }
            Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar actualizar lectura: ", ex);
            return false;
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar actualizar lectura: --> ", ex);
            }
        } 
        return true;
    }
    
    public String[][] obtenerHistorial(int idMedidor){        
        String[][] datos = new String[4][2];
        int i = 0;
        con = Conectar.getConnect();
        PreparedStatement ps;
        try{
            ps = con.prepareStatement("SELECT l.fecha_lec AS fechalectura, lectura FROM lecturas l WHERE id_medidor = ? AND l.es_actual != 'T' ORDER BY fecha_lec DESC, id_lectura DESC LIMIT 4");           
            ps.setInt(1, idMedidor);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                datos[i][0] = String.valueOf(utilidades.Estaticos.FORMATODMA.format(rs.getDate("fechalectura")));
                datos[i][1] = rs.getString("lectura");
                i++;
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar obtener historial de medidor: ", ex);
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar obtener historial de medidor: --> ", ex);
            }
        }
        return datos;
    }
    
    public static int obtenerIdMedidorPorLectura(String numLectura){
        int med = 0;        
        con = Conectar.getConnect();
        PreparedStatement ps;
        try{
            ps = con.prepareStatement("SELECT id_medidor AS numeromed FROM lecturas WHERE id_lectura = ?");           
            ps.setString(1, numLectura);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                med = rs.getInt("numeromed");
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar obtener medidor por lectura: ", ex);
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar obtener medidor por lectura: --> ", ex);
            }
        }
        return med;
    }
    
    public modelos.Lectura obtenerUltimaLectura(String idMedidor){
        modelos.Lectura l = null;   
        con = Conectar.getConnect();
        try{
            PreparedStatement ps = con.prepareStatement("SELECT id_lectura, lectura, fecha_lec "
                    + "FROM lecturas WHERE lectura = (SELECT MAX(lectura) FROM lecturas WHERE id_medidor = ? AND es_actual != 'T') AND id_medidor = ? ORDER BY id_lectura DESC LIMIT 1");
            ps.setString(1, idMedidor);
            ps.setString(2, idMedidor);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                l = new modelos.Lectura();
                l.setIdentificador(rs.getInt("id_lectura"));
                l.setLectura(rs.getInt("lectura"));
                l.setFechaLectura(rs.getTimestamp("fecha_lec"));
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar obtener última lectura: ", ex);
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar obtener última lectura: --> ", ex);
            }
        }
        return l;
    }
    
    public boolean darBajaComprobanteyLectura(String idComp, String idLectura, String ea){
        int idMedidor = obtenerIdMedidorPorLectura(idLectura);
        con = Conectar.getConnect();
        PreparedStatement ps, psi, ps1, ps2;
        try {
            con.setAutoCommit(false);
            
            ps1 = con.prepareStatement("SET @usuario = ?");
            ps1.setString(1, conexion.InicioSesion.getUsuario());
            ps1.execute();
            
            if(ea.equals("S")){
                ps2 = con.prepareStatement("UPDATE lecturas SET es_actual = ? WHERE id_medidor = ? AND es_actual = ?");
                ps2.setString(1, "S");
                ps2.setInt(2, idMedidor);
                ps2.setString(3, "N");
                ps2.executeUpdate();
            }
            
            psi = con.prepareStatement("UPDATE lecturas SET es_actual = ? WHERE id_medidor = ? "
                    + "AND id_lectura = (SELECT MAX(l.id_lectura) FROM (SELECT * FROM lecturas) l WHERE l.id_medidor = ? AND l.es_actual = ?)");
            psi.setString(1, "N");
            psi.setInt(2, idMedidor);
            psi.setInt(3, idMedidor);
            psi.setString(4, "A");
            psi.executeUpdate();
            
            ps = con.prepareStatement("UPDATE comprobantes c, lecturas l SET c.estado = ?, l.es_actual = ? WHERE c.id_comprobante = ? AND l.id_lectura = ?");
            ps.setString(1, "ELIMINADO");
            ps.setString(2, "T");
            ps.setString(3, idComp);
            ps.setString(4, idLectura);
            ps.executeUpdate();
            
            con.commit();
        }
        catch (SQLException ex) {
            try {
                if(con != null) con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar dar de baja comprobante y lectura: ---> ", ex1);
            }
            Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar dar de baja comprobante y lectura: ", ex);
            return false;
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar dar de baja comprobante y lectura: --> ", ex);
            }
        }
        return true;
    }
    
    public static boolean darBajaMedidoresEnCuenta(String idCuenta){
        con = Conectar.getConnect();
        PreparedStatement ps, ps1;
        try {
            con.setAutoCommit(false);
            
            ps1 = con.prepareStatement("SET @usuario = ?");
            ps1.setString(1, conexion.InicioSesion.getUsuario());
            ps1.execute();
           
            ps = con.prepareStatement("UPDATE medidores SET medidores.estado_med = ?" +
                    "WHERE medidores.id_medidor IN (SELECT id_medidor FROM medidores_por_cuentas WHERE id_cuenta = ?) AND medidores.estado_med = ?");
            ps.setString(1, "ELIMINADO");
            ps.setString(2, idCuenta);
            ps.setString(3, "ACTIVO");
            ps.executeUpdate();
            
            con.commit();
        }
        catch (SQLException ex) {
            try {
                if(con != null) con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar dar de baja medidor en cuenta: ---> ", ex1);
            }
            Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar dar de baja medidor en cuenta: ", ex);
            return false;
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar dar de baja medidor en cuenta: --> ", ex);
            }
        }
        return true;
    }
    
    public static boolean tieneSaldoMedidor(int idMedidor){
        boolean tiene = false;
        con = Conectar.getConnect();
        PreparedStatement ps;
        try{
            ps = con.prepareStatement("SELECT IF(mc.saldo_medidor > 0, true, false) AS tiene FROM medidores_por_cuentas mc WHERE mc.id_medidor = ?");           
            ps.setInt(1, idMedidor);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return tiene = rs.getBoolean("tiene");
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar obtener saldo de medidor: ", ex);
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar obtener saldo de medidor: --> ", ex);
            }
        }
        return tiene;
    }
    
    public boolean desconectarMedidor(Integer idMedidor, String estado){
        con = Conectar.getConnect();
        PreparedStatement ps;
        if(idMedidor == null) return false;
        try{
            con.setAutoCommit(false);
            ps = con.prepareStatement("UPDATE medidores SET estado_med = ? WHERE id_medidor = ?");
            ps.setString(1, estado);
            ps.setInt(2, idMedidor);
            ps.executeUpdate();            
            con.commit();
        }
        catch(SQLException ex){
            try {
                if(con != null) con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar desconectar medidor: ---> ", ex1);
            }
            Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar desconectar medidor: ", ex);
            return false;
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, "Error al intentar desconectar medidor: --> ", ex);
            }
        }
        return true;
    }
}
