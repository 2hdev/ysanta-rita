package dao;

import conexion.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.ResumenPagos;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import utilidades.Funciones;

public class Reportes {

    static Connection con;

    public static List<modelos.UsuarioReporte> obtenerUsuarios() {
        List<modelos.UsuarioReporte> usuarios = new ArrayList<>();
        con = Conectar.getConnect();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("SELECT u.id_usuario, CONCAT_WS(\" \", u.nombre_usu, u.apellido_usu) AS noap, "
                    + "GROUP_CONCAT(m.numero_med) as medidores, deudaActualDeCuenta(c.id_cuenta) AS saldo "
                    + "FROM (usuarios u, medidores m) "
                    + "INNER JOIN cuentas c ON c.id_usuario = u.id_usuario "
                    + "INNER JOIN medidores_por_cuentas mc ON c.id_cuenta = mc.id_cuenta AND mc.id_medidor = m.id_medidor "
                    + "GROUP BY c.id_cuenta ORDER BY u.id_usuario DESC");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelos.UsuarioReporte usuario = new modelos.UsuarioReporte();
                usuario.setCodigo(rs.getString("u.id_usuario"));
                usuario.setNombre(rs.getString("noap"));
                usuario.setNumMedidor(rs.getString("medidores"));
                Integer saldo = rs.getInt("saldo");
                usuario.setCuentaActual(saldo != null ? saldo : 0);
                usuarios.add(usuario);
            }
            if (!ps.isClosed()) {
                ps.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, "Error al intentar obtener usuarios: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, "Error al intentar obtener usuarios: --> ", ex);
            }
        }

        return usuarios;
    }

    public static List<modelos.UsuarioReporte> obtenerUsuariosPorZona(String idZona) {
        List<modelos.UsuarioReporte> usuarios = new ArrayList<>();
        con = Conectar.getConnect();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("SELECT u.id_usuario, CONCAT_WS(\" \", u.nombre_usu, u.apellido_usu) AS noap, "
                    + "GROUP_CONCAT(m.numero_med) AS medidores, deudaActualDeCuenta(c.id_cuenta) AS saldo "
                    + "FROM (usuarios u, medidores m) "
                    + "INNER JOIN cuentas c ON c.id_usuario = u.id_usuario "
                    + "INNER JOIN medidores_por_cuentas mc ON c.id_cuenta = mc.id_cuenta AND mc.id_medidor = m.id_medidor "
                    + "LEFT JOIN zonas z ON z.id_zona = u.id_zona WHERE z.id_zona = ? "
                    + "GROUP BY c.id_cuenta ORDER BY u.id_usuario DESC");
            ps.setString(1, idZona);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelos.UsuarioReporte usuario = new modelos.UsuarioReporte();
                usuario.setCodigo(rs.getString("u.id_usuario"));
                usuario.setNombre(rs.getString("noap"));
                usuario.setNumMedidor(rs.getString("medidores"));
                Integer saldo = rs.getInt("saldo");
                usuario.setCuentaActual(saldo != null ? saldo : 0);
                usuarios.add(usuario);
            }
            if (!ps.isClosed()) {
                ps.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, "Error al intentar obtener usuarios por zona: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, "Error al intentar obtener usuarios por zona: --> ", ex);
            }
        }

        return usuarios;
    }

    public static List<modelos.UsuarioReporte> obtenerUsuariosMorososDC() {
        List<modelos.UsuarioReporte> usuarios = new ArrayList<>();
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT u.id_usuario, CONCAT_WS(\" \", u.nombre_usu, u.apellido_usu) AS noap, "
                    + "GROUP_CONCAT(m.numero_med) AS medidor, c.id_cuenta "
                    + "FROM (usuarios u, medidores m) "
                    + "INNER JOIN cuentas c ON c.id_usuario = u.id_usuario "
                    + "INNER JOIN medidores_por_cuentas mc ON c.id_cuenta = mc.id_cuenta AND mc.id_medidor = m.id_medidor "
                    + "GROUP BY c.id_cuenta ORDER BY u.id_usuario DESC ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer saldo = dao.Cuentas.obtenerSaldoConexion(rs.getString("c.id_cuenta"));
                if (saldo > 0) {
                    modelos.UsuarioReporte usuario = new modelos.UsuarioReporte();
                    usuario.setCodigo(rs.getString("u.id_usuario"));
                    usuario.setNombre(rs.getString("noap"));
                    usuario.setNumMedidor(rs.getString("medidor"));
                    usuario.setCuentaActual(saldo != null ? saldo : 0);
                    usuarios.add(usuario);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, "Error al intentar obtener usuarios morosos: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, "Error al intentar obtener usuarios morosos: --> ", ex);
            }
        }

        return usuarios;
    }

    public static List<modelos.UsuarioReporte> obtenerUsuariosMorososDCPorZona(String idZona) {
        List<modelos.UsuarioReporte> usuarios = new ArrayList<>();
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT u.id_usuario, CONCAT_WS(\" \", u.nombre_usu, u.apellido_usu) AS noap, "
                    + "GROUP_CONCAT(m.numero_med) AS medidor, c.id_cuenta "
                    + "FROM (usuarios u, medidores m) "
                    + "INNER JOIN cuentas c ON c.id_usuario = u.id_usuario "
                    + "INNER JOIN medidores_por_cuentas mc ON c.id_cuenta = mc.id_cuenta AND mc.id_medidor = m.id_medidor "
                    + "LEFT JOIN zonas z ON z.id_zona = u.id_zona WHERE z.id_zona = ? "
                    + "GROUP BY c.id_cuenta ORDER BY u.id_usuario DESC");
            ps.setString(1, idZona);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer saldo = dao.Cuentas.obtenerSaldoConexion(rs.getString("c.id_cuenta"));
                if (saldo > 0) {
                    modelos.UsuarioReporte usuario = new modelos.UsuarioReporte();
                    usuario.setCodigo(rs.getString("u.id_usuario"));
                    usuario.setNombre(rs.getString("noap"));
                    usuario.setNumMedidor(rs.getString("medidor"));
                    usuario.setCuentaActual(saldo != null ? saldo : 0);
                    usuarios.add(usuario);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, "Error al intentar obtener usuarios morosos por zona: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, "Error al intentar obtener usuarios por zona: --> ", ex);
            }
        }

        return usuarios;
    }

    public static List<modelos.PagosReporte> obtenerPagosPorLote(String idLote, String tipo) {
        List<modelos.PagosReporte> pagos = new ArrayList<>();
        con = Conectar.getConnect();
        try {
            String sql = "SELECT IF(p.numFactura LIKE '___-___-_______', SUBSTRING(p.numFactura, 9), p.numFactura) AS numFactura, GROUP_CONCAT(DISTINCT dp.tipo_concepto) as conceptos, "
                    + "p.id_pago, p.fecha_pago, p.id_usuario, CONCAT_WS(\" \", u.nombre_usu, u.apellido_usu) AS noap, p.importe_total, m.numero_med, p.anulado "
                    + "FROM (pagos p, detalle_pago dp, usuarios u, medidores m) "
                    + "LEFT JOIN cuentas c ON c.id_usuario = u.id_usuario "
                    + "LEFT JOIN medidores_por_cuentas mc ON c.id_cuenta = mc.id_cuenta AND mc.id_medidor = m.id_medidor "
                    + "WHERE p.id_pago = dp.id_pago AND u.id_usuario = p.id_usuario AND p.id_loteP = ? AND p.numFactura NOT LIKE '%C' ";
            String where;
            switch (tipo) {
                case "CONSUMO":
                    where = "AND (dp.tipo_concepto = 'COMPROBANTES' OR dp.tipo_concepto = 'ANTERIORES')";
                    break;
                case "DERECHO DE CONEXIÓN":
                    where = "AND dp.tipo_concepto = 'DERCONEX'";
                    break;
                case "ADELANTADO":
                    where = "AND dp.tipo_concepto = 'ADELANTADO'";
                    break;
                case "OTROS":
                    where = "AND dp.tipo_concepto = 'OTROS'";
                    break;
                case "TODOS":
                default:
                    where = "";
            }
            PreparedStatement ps = con.prepareStatement(sql + where + " GROUP BY p.id_pago ORDER BY p.id_pago ASC");
            ps.setString(1, idLote);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelos.PagosReporte pago = new modelos.PagosReporte();
                pago.setNumPago(rs.getString("p.id_pago"));
                pago.setFecha(rs.getDate("p.fecha_pago"));
                pago.setCodigo(rs.getString("anulado") == null ? rs.getString("p.id_usuario") : null);
                pago.setNombre(rs.getString("anulado") == null ? rs.getString("noap") : null);
                pago.setNumMedidor(rs.getString("anulado") == null ? rs.getString("m.numero_med") : null);
                pago.setImporte(rs.getString("anulado") == null ? rs.getInt("p.importe_total") : null);
                pago.setNumFactura(rs.getString("numFactura"));
                pago.setConcepto(rs.getString("anulado") == null ? rs.getString("conceptos") : "ANULADO");
                pagos.add(pago);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, "Error al intentar obtener pagos por lote: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, "Error al intentar obtener pagos por lote: --> ", ex);
            }
        }

        return pagos;
    }

    public static List<modelos.PagosReporte> PagosPorLote(String idLote) {
        List<modelos.PagosReporte> pagos = new ArrayList<>();
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT p.id_pago, comp.id_usuario, p.numFactura, (IFNULL((SELECT ERSSAN FROM deudas_anteriores WHERE id_usuario=comp.id_usuario),0)+comp.ERSSAN) as ERSSAN, CONCAT(u.nombre_usu,\" \",u.apellido_usu) as nombre_usu,u.num_doc_usu, u.direccion_usu, u.telefono_usu, CONCAT(month(comp.fecha_act),\"/\",lf.anho_loteFac) as ciclo, m.numero_med, p.fecha_pago, comp.vencimiento, p.importe_total, round(((p.importe_total+(IFNULL((SELECT ERSSAN FROM deudas_anteriores WHERE id_usuario=comp.id_usuario),0))+comp.ERSSAN)/11),0)AS iva, (p.importe_total+(IFNULL((SELECT ERSSAN FROM deudas_anteriores WHERE id_usuario=comp.id_usuario),0))+comp.ERSSAN) as total_factura FROM pagos p, detalle_pago dp, usuarios u, pagos_por_comprobantes pc, comprobantes comp, lotefacturas lf, lecturas lec, medidores m WHERE p.id_pago=dp.id_pago AND u.id_usuario=p.id_usuario AND pc.id_detalle = dp.iddetalle AND comp.id_comprobante=pc.id_comprobante AND lf.id_loteFac=comp.id_loteFac AND comp.id_lectura=lec.id_lectura AND m.id_medidor=lec.id_medidor AND p.id_loteP=? AND p.anulado IS NULL ORDER BY id_usuario");
            ps.setString(1, idLote);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelos.PagosReporte pago = new modelos.PagosReporte();
                pago.setNumPago(rs.getString("id_pago"));
                pago.setFecha(rs.getDate("fecha_pago"));
                pago.setCodigo(rs.getString("id_usuario"));
                pago.setNombre(rs.getString("nombre_usu"));
                pago.setImporte(rs.getInt("total_factura"));
                pago.setNumFactura(rs.getString("numFactura"));
                pagos.add(pago);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, "Error al intentar obtener pagos por lote: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, "Error al intentar obtener pagos por lote: --> ", ex);
            }
        }

        return pagos;
    }

    public static List<modelos.PagosReporte> obtenerPagosPorFecha(Date desde, Date hasta) {
        List<modelos.PagosReporte> pagos = new ArrayList<>();
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT p.id_pago, p.fecha_pago, p.id_usuario, CONCAT_WS(\" \", u.nombre_usu, u.apellido_usu) AS noap, "
                    + "p.importe_total FROM pagos p, usuarios u, medidores m, detalle_pago dp "
                    + "WHERE u.id_usuario = p.id_usuario AND p.anulado IS NULL "
                    + "AND dp.id_pago = p.id_pago AND (tipo_concepto = \"COMPROBANTES\" OR dp.tipo_concepto = \"ANTERIORES\") "
                    + "AND p.fecha_pago BETWEEN ? AND ? AND p.numFactura NOT LIKE '%C' "
                    + "GROUP BY p.id_pago ORDER BY p.id_pago DESC");
            ps.setDate(1, Funciones.utilDateaSqlDate(desde));
            ps.setDate(2, Funciones.utilDateaSqlDate(hasta));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelos.PagosReporte pago = new modelos.PagosReporte();
                pago.setNumPago(rs.getString("p.id_pago"));
                pago.setFecha(rs.getDate("p.fecha_pago"));
                pago.setCodigo(rs.getString("p.id_usuario"));
                pago.setNombre(rs.getString("noap"));
                pago.setImporte(rs.getInt("p.importe_total"));
                pago.setERSSAN(new utilidades.Calculos(pago.getImporte()).getERSSAN());
                pagos.add(pago);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, "Error al intentar obtener pagos por fecha: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, "Error al intentar obtener pagos por fecha: --> ", ex);
            }
        }

        return pagos;
    }

    public static modelos.ResumenCuenta obtenerResumenCuenta(Integer idCuenta) {
        modelos.ResumenCuenta resumen = null;
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT CONCAT_WS(\" \", u.nombre_usu, u.apellido_usu) AS noap, c.id_cuenta, m.numero_med, c.saldoderechoconex, c.saldocomprobantes, c.saldoafavor "
                    + "FROM usuarios u, cuentas c, medidores m, medidores_por_cuentas mc "
                    + "WHERE u.id_usuario = c.id_usuario AND mc.id_medidor = m.id_medidor AND c.id_cuenta = mc.id_cuenta AND m.estado_med = ? AND c.id_cuenta = ?");
            ps.setString(1, "ACTIVO");
            ps.setInt(2, idCuenta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                resumen = new modelos.ResumenCuenta();
                resumen.setNomape(rs.getString("noap"));
                resumen.setNumcuenta(rs.getString("c.id_cuenta"));
                resumen.setNummedidor(rs.getString("m.numero_med"));
                resumen.setDerconex(rs.getInt("c.saldoderechoconex"));
                resumen.setSaldoanterior(rs.getInt("c.saldocomprobantes"));
                resumen.setSaldoafavor(rs.getInt("c.saldoafavor"));
                resumen.setSaldo(dao.Cuentas.obtenerSaldoCuenta(idCuenta));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, "Error al intentar obtener resumen de cuenta: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, "Error al intentar obtener resumen de cuenta: --> ", ex);
            }
        }

        return resumen;
    }

    public static List<modelos.HistorialPago> obtenerHistorial(String idUsuario, Date desde, Date hasta) {
        List<modelos.HistorialPago> hp = new ArrayList();
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT p.numFactura, DATE_FORMAT(p.fecha_pago, \"%d/%m/%Y\") AS fecha, p.importe_total, GROUP_CONCAT(DISTINCT dp.concepto) as conceptos "
                    + "FROM pagos p, detalle_pago dp, usuarios u "
                    + "WHERE p.id_pago = dp.id_pago AND p.anulado IS NULL AND p.id_usuario = u.id_usuario AND u.id_usuario = ? " + ((desde != null && hasta != null) ? "AND p.fecha_pago BETWEEN ? AND ? " : "") + "GROUP BY p.id_pago ORDER BY p.fecha_pago");

            ps.setString(1, idUsuario);
            if (desde != null && hasta != null) {
                ps.setDate(2, Funciones.utilDateaSqlDate(desde));
                ps.setDate(3, Funciones.utilDateaSqlDate(hasta));
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelos.HistorialPago arq = new modelos.HistorialPago();
                arq.setNumFactura(rs.getString("p.numFactura"));
                arq.setFecha(rs.getString("fecha"));
                arq.setImporte(rs.getInt("p.importe_total"));
                arq.setConcepto(rs.getString("conceptos"));
                hp.add(arq);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, "Error al intentar obtener historial de pago de usuario: ", ex);
            return null;
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, "Error al intentar obtener historial de pago de usuario: ", ex);
            }
        }
        return hp;
    }

    public static List<ResumenPagos> ResumendePagos(int mes, int anho, int id_lote) {
        Connection con = Conectar.getConnect();
        ResultSet rs = null;
        List<ResumenPagos> resumen = new ArrayList<>();
        try {
//            PreparedStatement ps = con.prepareStatement("SELECT pagos.id_usuario,CONCAT(usuarios.nombre_usu," ",usuarios.apellido_usu) as nombre_usu, pagos.numFactura, SUM(subtotal) as saldo_mes, IFNULL((SELECT ROUND((SUM(subtotal))) FROM detalle_pago dp WHERE dp.id_pago=pagos.id_pago AND dp.tipo_concepto='DEUDAS'),0) AS saldo_anterior, ROUND(((SUM(subtotal)+ROUND((((SUM(subtotal))/1.1)*0.02),0))/11),0) AS IVA10,(SELECT SUM(subtotal) from detalle_pago dp WHERE dp.id_pago=detalle_pago.id_pago AND dp.tipo_concepto!='CARGOSADD' AND dp.tipo_concepto!='ERSSAN') as saldo_acumulado FROM detalle_pago, pagos, usuarios WHERE usuarios.id_usuario=pagos.id_usuario AND detalle_pago.id_pago=pagos.id_pago AND detalle_pago.tipo_concepto='COMPROBANTES' AND pagos.id_loteP=? And pagos.anulado IS NULL GROUP BY detalle_pago.id_pago ");
            PreparedStatement ps = con.prepareStatement("SELECT pagos.id_usuario,CONCAT(usuarios.nombre_usu,\" \",usuarios.apellido_usu) as nombre_usu, pagos.numFactura, (SUM(subtotal)+ROUND((((SUM(subtotal))/1.1)*0.02),0)) as saldo_mes, IFNULL((SELECT ROUND((SUM(subtotal)+((SUM(subtotal)/1.1)*0.02))) FROM detalle_pago dp WHERE dp.id_pago=pagos.id_pago AND dp.tipo_concepto='DEUDAS'),0) AS saldo_anterior, ROUND(((SUM(subtotal)+ROUND((((SUM(subtotal))/1.1)*0.02),0))/11),0) AS IVA10,(SELECT SUM(subtotal) from detalle_pago dp WHERE dp.id_pago=detalle_pago.id_pago AND dp.tipo_concepto!='CARGOSADD') as saldo_acumulado FROM detalle_pago, pagos, usuarios WHERE usuarios.id_usuario=pagos.id_usuario AND detalle_pago.id_pago=pagos.id_pago AND detalle_pago.tipo_concepto='COMPROBANTES' AND pagos.id_loteP=? And pagos.anulado IS NULL GROUP BY detalle_pago.id_pago");
//            ps.setInt(1, mes);
//            ps.setInt(2, anho);
            ps.setInt(1, id_lote);
            rs = ps.executeQuery();
            while (rs.next()) {
                ResumenPagos rp = new ResumenPagos();
                rp.setId_usuario(rs.getInt("id_usuario"));
                rp.setNombre_usu(rs.getString("nombre_usu"));
                rp.setNumFactura(rs.getString("numFactura"));
                rp.setSaldo_mes(rs.getLong("saldo_mes"));
                rp.setSaldo_anterior(rs.getLong("saldo_anterior"));
                rp.setSaldo_acumulado(rs.getLong("saldo_acumulado"));
                rp.setIVA10(rs.getInt("IVA10"));
                resumen.add(rp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resumen;
    }
}
