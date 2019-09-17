package dao;

import conexion.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;
import utilidades.Funciones;

public class Usuarios {
    
    static Connection con;
    modelos.Auditoria au;
    
    public int obtenerID(){
        int id = 0;
        ResultSet rs;
        Statement sent;
        try{
            con = Conectar.getConnect();
            sent = con.createStatement();
            rs = sent.executeQuery("SELECT IFNULL(MAX(id_usuario+1), 1) as idUsuario FROM usuarios");
            if(rs.next()){
                id = rs.getInt("idUsuario");
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, "Error al intentar obtener nuevo identificador de usuario: ", ex);
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            }
            catch (SQLException ex) {
                Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, "Error al intentar obtener nuevo identificador de usuario: --> ", ex);
            }
        }
        return id;
    }
    
    public boolean insertarUsuario(modelos.Usuario usuario){
        con = Conectar.getConnect();
        PreparedStatement ps, ps1;
        try {
            con.setAutoCommit(false);
            
            ps1 = con.prepareStatement("SET @usuario = ?");
            ps1.setString(1, conexion.InicioSesion.getUsuario());
            ps1.execute();
            
            ps = con.prepareStatement("INSERT INTO usuarios(id_usuario, nombre_usu, apellido_usu, direccion_usu, "
                    + "telefono_usu, tipo_doc_usu, num_doc_usu, obs_usu, tipo_descuento, monto_descuento_usu, plazo_descuento, id_zona) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, usuario.getIdentificador());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellido());
            ps.setString(4, usuario.getDireccion());
            ps.setString(5, usuario.getTelefono());
            ps.setString(6, usuario.getTipoDocumento());
            ps.setString(7, usuario.getNumDocumento());
            ps.setString(8, usuario.getObs());
            ps.setString(9, usuario.getTipodesc());
            ps.setInt(10, usuario.getMontoDescuento());
            ps.setDate(11, usuario.getPlazoDescuento() == null ? null : Funciones.utilDateaSqlDate(usuario.getPlazoDescuento()));
            ps.setInt(12, usuario.getIdZona());
            ps.executeUpdate();

            con.commit();
        }
        catch (SQLException ex) {
            try {
                if(con != null) con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, "Error al intentar insertar usuario: ---> ", ex1);
            }
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, "Error al intentar insertar usuario: ", ex);
            return false;
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, "Error al intentar insertar usuario: ", ex);
            }
        } 
        return true;
    }
    
    public boolean actualizarUsuario(java.util.Map<String, ?> valores, int idUsuario){       
        con = Conectar.getConnect();
        PreparedStatement ps, ps1;
        try {
            con.setAutoCommit(false);
            if(valores.size()>0){
                ps1 = con.prepareStatement("SET @usuario = ?");
                ps1.setString(1, conexion.InicioSesion.getUsuario());
                ps1.execute();
                
                String sentenciae = String.format("UPDATE usuarios SET %s WHERE id_usuario=?", StringUtils.join(valores.keySet(), ","));
                ps = con.prepareStatement(sentenciae);
                int p = 1;
                for (String key : valores.keySet()) {
                    if(key.equals("plazo_descuento=?")){
                        if(key == null) ps.setDate(p++, null);
                        else{
                            try {
                                java.util.Date parsed = utilidades.Estaticos.FORMATODMA.parse(valores.get(key).toString());
                                ps.setDate(p++, Funciones.utilDateaSqlDate(parsed));
                            } catch (ParseException ex) {
                                Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, "Error al parsear fecha: ", ex);
                            }
                        }
                    }
                    else ps.setString(p++, valores.get(key).toString());
                }
                ps.setInt(p++, idUsuario);
                ps.executeUpdate();
            }
            con.commit();
        }
        catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, "Error al intentar actualizar usuario: ", ex);
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, "Error al intentar actualizar usuario: ---> ", ex1);
            }
            return false;
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            }
            catch (SQLException ex) {
                Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, "Error al intentar actualizar usuario: --> ", ex);
            }
        }
        return true;
    }
    
    public modelos.Usuario obtenerUsuarioPorId(int idUsuario){
        modelos.Usuario mu = null;
        ResultSet rs;
        PreparedStatement ps;
        try{
            con = Conectar.getConnect();
            ps = con.prepareStatement("SELECT nombre_usu, apellido_usu, direccion_usu, telefono_usu, "
                    + "tipo_doc_usu, num_doc_usu, obs_usu, tipo_descuento, monto_descuento_usu, plazo_descuento, id_zona FROM usuarios WHERE id_usuario = ?");
            ps.setInt(1, idUsuario);
            rs = ps.executeQuery();
            if(rs.next()){
                mu = new modelos.Usuario();
                mu.setIdentificador(idUsuario);
                mu.setNombre(rs.getString("nombre_usu"));
                mu.setApellido(rs.getString("apellido_usu"));
                mu.setDireccion(rs.getString("direccion_usu"));
                mu.setTelefono(rs.getString("telefono_usu"));
                mu.setTipoDocumento(rs.getString("tipo_doc_usu"));
                mu.setNumDocumento(rs.getString("num_doc_usu"));
                mu.setTipodesc(rs.getString("tipo_descuento"));
                mu.setMontoDescuento(rs.getInt("monto_descuento_usu"));
                mu.setPlazoDescuento(rs.getDate("plazo_descuento"));
                mu.setObs(rs.getString("obs_usu"));
                mu.setIdZona(rs.getInt("id_zona"));
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, "Error al intentar obtener usuario: ", ex);
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            }
            catch (SQLException ex) {
                Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, "Error al intentar obtener usuario: --> ", ex);
            }
        }
        return mu;
    }
    
    public static List<modelos.UsuarioReporte> listarUsuariosLike(String cual, String cadena){
        List<modelos.UsuarioReporte> u = new ArrayList<>();
        con = Conectar.getConnect();
        try{
            try (PreparedStatement ps = con.prepareStatement("SELECT u.id_usuario, CONCAT_WS(\" \", u.nombre_usu, u.apellido_usu) AS noap, u.num_doc_usu, "
                    + "z.zona AS zona, deudaActual(u.id_usuario) AS saldo, saldoAFavor(u.id_usuario) AS afavor "
                    + "FROM usuarios u LEFT JOIN zonas z ON z.id_zona = u.id_zona WHERE "+cual+" LIKE ?")) {
                ps.setString(1, "%"+cadena+"%");
                try (ResultSet rs = ps.executeQuery()) {
                    while(rs.next()){
                        modelos.UsuarioReporte usuario = new modelos.UsuarioReporte();
                        usuario.setCodigo(rs.getString("u.id_usuario"));
                        usuario.setNombre(rs.getString("noap"));
                        usuario.setNumDocumento(rs.getString("u.num_doc_usu"));
                        usuario.setZona(rs.getString("zona") == null ? "NINGUNA": rs.getString("zona"));
                        usuario.setSaldoAFavor(rs.getInt("afavor"));
                        usuario.setCuentaActual(rs.getInt("saldo"));
                        u.add(usuario);
                    }
                }
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, "Error al intentar listar usuarios: ", ex);
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, "Error al intentar listar usuarios: --> ", ex);
            }
        }
        
        return u;
    }
    
    public static int contarUsuarios(){
        int cant = 0;
        ResultSet rs;
        Statement sent;
        try{
            con = Conectar.getConnect();
            sent = con.createStatement();
            rs = sent.executeQuery("SELECT COUNT(id_usuario) as cantidad FROM usuarios");
            if(rs.next()){
                cant = rs.getInt("cantidad");
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, "Error al intentar contar usuarios: ", ex);
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            }
            catch (SQLException ex) {
                Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, "Error al intentar contar usuarios: -->", ex);
            }
        }
        return cant;
    }
    
    public static List<modelos.UsuarioReporte> listarUsuariosPag(int numPagina, String ordena){
        List<modelos.UsuarioReporte> u = new ArrayList<>();
        con = Conectar.getConnect();
        try{
            try (Statement sent = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
                sent.setFetchSize(50); //para que obtenga 50 registros
                try (ResultSet rs = sent.executeQuery("SELECT u.id_usuario, CONCAT_WS(\" \", u.nombre_usu, u.apellido_usu) AS noap, u.num_doc_usu, "
                        + "z.zona AS zona, deudaActual(u.id_usuario) AS saldo, saldoAFavor(u.id_usuario) AS afavor FROM usuarios u "
                        + "LEFT JOIN zonas z ON z.id_zona = u.id_zona".concat(ordena==null?"":" ORDER BY "+ordena))) {
                    int fila = 50 * (numPagina-1) + 1;
                    int cont = 1;
                    if (rs.absolute(fila) && 50 > 0) {
                        do{
                            modelos.UsuarioReporte usuario = new modelos.UsuarioReporte();
                            usuario.setCodigo(rs.getString("u.id_usuario"));
                            usuario.setNombre(rs.getString("noap"));
                            usuario.setNumDocumento(rs.getString("u.num_doc_usu"));
                            usuario.setZona(rs.getString("zona") == null ? "NINGUNA": rs.getString("zona"));
                            usuario.setSaldoAFavor(rs.getInt("afavor"));
                            usuario.setCuentaActual(rs.getInt("saldo"));
                            u.add(usuario);
                            cont++;
                        }while(rs.next()  && (cont <= 50));
                    }
                }
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, "Error al intentar listar usuarios: ", ex);
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, "Error al intentar listar usuarios: -->", ex);
            }
        }
        
        return u;
    }
    
    public static Map<Integer, String> obtenerUsuarios(){
        con = Conectar.getConnect();
        try{
            PreparedStatement ps = con.prepareStatement("SELECT u.id_usuario, CONCAT_WS(\" \", u.nombre_usu, u.apellido_usu) AS noap, u.num_doc_usu, "
                    + "IF((SELECT COUNT(c.id_cuenta) AS cuenta FROM cuentas c WHERE c.id_usuario = u.id_usuario) > 0, true, false) AS existe "
                    + "FROM usuarios u");
            ResultSet rs = ps.executeQuery();
            rs.last();
            int numRows = rs.getRow();
            rs.beforeFirst();
            if(numRows == 0){
                return null;
            }
            else{
                Map<Integer, String> mapa = new HashMap();
                while(rs.next()){
                    mapa.put(rs.getInt("u.id_usuario"), String.join("|", rs.getString("noap"), rs.getString("u.num_doc_usu")).concat(",")+rs.getString("existe"));
                }
                return mapa;
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, "Error al intentar obtener usuarios: ", ex);
            return null;
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, "Error al intentar listar usuarios: --> ", ex);
            }
        }
    }
    
    public static String obtenerUsuario(String idUsuario){
        con = Conectar.getConnect();
        try{
            PreparedStatement ps = con.prepareStatement("SELECT CONCAT_WS(\" \", u.nombre_usu, u.apellido_usu) AS noap FROM usuarios u WHERE u.id_usuario = ?");
            ps.setString(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString("noap");
            }
            return null;
            }
        catch(SQLException ex){
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, "Error al intentar obtener usuario: ", ex);
            return null;
        }
        finally{
            try {
                if(!con.isClosed()) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, "Error al intentar obtener usuario: --> ", ex);
            }
        }
    }
    
}
