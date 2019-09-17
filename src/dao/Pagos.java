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
import utilidades.Funciones;

public class Pagos {

    static Connection con;
    modelos.Auditoria au;
    Funciones f = new Funciones();

    public static Integer getIDLotePago(java.util.Date fecha) {
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id_loteP FROM lotepagos WHERE YEAR(CURRENT_DATE()) = anho_loteP AND mes_loteP = ?");
            ps.setString(1, new java.text.SimpleDateFormat("MMMM").format(fecha).toUpperCase());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_loteP");
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar obtener lote de pago: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar obtener lote de pago: --> ", ex);
            }
        }
        return null;
    }

    public int BuscarErssanxPago(int id_pago) {
        con = Conectar.getConnect();
        int total = 0;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT total_factura(?) as total_factura");
            ps.setInt(1, id_pago);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getInt("total_factura");
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar obtener erssan de pago: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar obtener erssan de pago: --> ", ex);
            }
        }
        return total;
    }

    public boolean actualizarDescripcionLotePago(String descripcion, String descripcionAnterior, Integer idLotePago) {
        con = Conectar.getConnect();
        PreparedStatement ps, ps1;
        try {
            con.setAutoCommit(false);

            ps1 = con.prepareStatement("SET @usuario = ?");
            ps1.setString(1, conexion.InicioSesion.getUsuario());
            ps1.execute();

            ps = con.prepareStatement("UPDATE lotepagos SET descripcion_loteP = ? WHERE id_loteP = ?");
            ps.setString(2, descripcion);
            ps.setInt(3, idLotePago);
            ps.executeUpdate();
            con.commit();

        } catch (SQLException ex) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar actualizar descripción de lote de pago: ---> ", ex1);
            }
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar actualizar descripción de lote de pago: ", ex);
            return false;
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar actualizar descripción de lote de pago: --> ", ex);
            }
        }
        return true;
    }

    public boolean insertarLotePago(modelos.LotePagos pago) {
        con = Conectar.getConnect();
        PreparedStatement ps, ps1;
        try {
            con.setAutoCommit(false);

            ps1 = con.prepareStatement("SET @usuario = ?");
            ps1.setString(1, conexion.InicioSesion.getUsuario());
            ps1.execute();

            ps = con.prepareStatement("INSERT INTO lotepagos(fecha_generacion_loteP, obs_lote, descripcion_loteP, mes_loteP, anho_loteP) VALUES(?, ?, ?, ?, ?)");
            ps.setDate(1, Funciones.utilDateaSqlDate(pago.getFechaLote()));
            ps.setString(2, pago.getObservacion());
            ps.setString(3, pago.getDescripcion());
            ps.setString(4, pago.getMes());
            ps.setString(5, pago.getAnho());
            ps.executeUpdate();
            con.commit();

        } catch (SQLException ex) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar insertar lote de pago: ---> ", ex1);
            }
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar insertar lote de pago: ", ex);
            return false;
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar insertar lote de pago: --> ", ex);
            }
        }
        return true;
    }

    public boolean anularFactura(String idPago) {
        con = Conectar.getConnect();
        CallableStatement cs;
        try {
            con.setAutoCommit(false);
            cs = con.prepareCall("{CALL anularFactura(?)}");
            cs.setString(1, idPago);
            cs.execute();
            con.commit();
        } catch (SQLException ex) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar anular factura: ---> ", ex1);
            }
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar anular factura: ", ex);
            return false;
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar anular factura: --> ", ex);
            }
        }
        return true;
    }

    public boolean existeMismaFechaLote(modelos.LotePagos lp) {
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) as existe FROM lotepagos WHERE mes_loteP = ? AND anho_loteP = ?");
            ps.setString(1, lp.getMes());
            ps.setString(2, lp.getAnho());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getInt("existe") > 0) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar obtener misma fecha de lote de pago: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar obtener misma fecha de lote de pago: --> ", ex);
            }
        }
        return false;
    }

    public static String numeroFactura() {
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT MAX(numFactura) as fact FROM pagos WHERE numFactura LIKE '___-___-_______'");
            ResultSet rs = ps.executeQuery();
            if (rs.next() && rs.getString("fact") != null) {
                String[] ultimo = rs.getString("fact").split("-");
                Integer siguiente = Integer.parseInt(ultimo[2]) + 1;
                String patron = "0000000";
                StringBuilder sb = new StringBuilder(ultimo[0]);
                sb.append("-").append(ultimo[1]).append("-").append(patron.substring(0, patron.length() - siguiente.toString().length())).append(siguiente.toString());
                return sb.toString();
            } else {
                return "001-001-0000001";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar obtener número de factura: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar obtener número de factura: --> ", ex);
            }
        }
        return "";
    }

    public static String numeroRecibo() {
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT MAX(numFactura) as fact FROM pagos WHERE numFactura LIKE '__________'");
            ResultSet rs = ps.executeQuery();
            if (rs.next() && rs.getString("fact") != null) {
                String ultimo = rs.getString("fact");
                Integer siguiente = Integer.parseInt(ultimo) + 1;
                String patron = "0000000000";
                StringBuilder sb = new StringBuilder(patron.substring(0, patron.length() - siguiente.toString().length()));
                sb.append(siguiente.toString());
                return sb.toString();
            } else {
                return "0000000001";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar obtener número de recibo: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar obtener número de recibo: --> ", ex);
            }
        }
        return "";
    }

    public static String numeroComprobanteInterno() {
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT numFactura as fact FROM pagos WHERE numFactura LIKE '%C' ORDER BY CAST(numFactura AS INT) DESC LIMIT 1");
            ResultSet rs = ps.executeQuery();
            if (rs.next() && rs.getString("fact") != null) {
                String ultimo = rs.getString("fact").substring(0, rs.getString("fact").length() - 1);
                Integer siguiente = Integer.parseInt(ultimo) + 1;
                return siguiente.toString() + "C";
            } else {
                return "1C";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar obtener número de comprobante interno: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar obtener número de comprobante interno: --> ", ex);
            }
        }
        return "";
    }

    public static List<modelos.LotePagos> listarLotesPagos() {
        List<modelos.LotePagos> lp = null;
        con = Conectar.getConnect();
        try {
            Statement sent = con.createStatement();
            ResultSet rs = sent.executeQuery("SELECT id_loteP, descripcion_loteP, anho_loteP, mes_loteP, fecha_generacion_loteP "
                    + "FROM lotepagos ORDER BY id_loteP DESC");
            lp = new ArrayList<>();
            while (rs.next()) {
                modelos.LotePagos l = new modelos.LotePagos();
                l.setIdentificador(rs.getString("id_loteP"));
                l.setDescripcion(rs.getString("descripcion_loteP"));
                l.setAnho(rs.getString("anho_loteP"));
                l.setMes(rs.getString("mes_loteP"));
                l.setFechaLote(rs.getDate("fecha_generacion_loteP") == null ? null : rs.getTimestamp("fecha_generacion_loteP"));
                PreparedStatement ps = con.prepareStatement("SELECT COALESCE(SUM(importe_total),0) AS total "
                        + "FROM lotepagos LEFT JOIN pagos ON pagos.id_loteP = lotepagos.id_loteP WHERE pagos.anulado IS NULL AND pagos.id_loteP = ? AND numFactura NOT LIKE '%C'");
                ps.setString(1, rs.getString("id_loteP"));
                ResultSet rs2 = ps.executeQuery();
                if (rs2.next()) {
                    l.setTotal(rs2.getInt("total"));
                }
                lp.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar listar lotes de pagos: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar listar lotes de pagos: --> ", ex);
            }
        }
        return lp;
    }

    public static List<modelos.Pago> listarPagosxLotes(String idLote) {
        List<modelos.Pago> p = null;
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT u.id_usuario, CONCAT(u.nombre_usu,' ',u.apellido_usu) as nombre_usu, p.id_pago, p.fecha_pago, p.numFactura, p.importe_total, p.estado_pago "
                    + "FROM pagos p, usuarios u WHERE p.anulado IS NULL AND p.id_loteP = ? AND p.numFactura NOT LIKE '%C' AND u.id_usuario=p.id_usuario ORDER BY u.id_usuario DESC");
            ps.setString(1, idLote);
            ResultSet rs = ps.executeQuery();
            p = new ArrayList<>();
            while (rs.next()) {
                modelos.Pago l = new modelos.Pago();
                l.setIdentificador(rs.getInt("p.id_pago"));
                l.setFechaPago(rs.getDate("p.fecha_pago") == null ? null : rs.getTimestamp("p.fecha_pago"));
                l.setNumFactura(rs.getString("p.numFactura"));
                l.setTotal(rs.getInt("p.importe_total"));
                l.setEstado_pago(rs.getBoolean("estado_pago"));
                l.setNombre(rs.getString("nombre_usu"));
                l.setIdUsuario(rs.getString("id_usuario"));
                p.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar listar pagos por lote: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar listar pagos por lote: --> ", ex);
            }
        }
        return p;
    }

    public static List<String> listarPago(String idPago) {
        List<String> p = new ArrayList<>();
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT p.id_usuario, p.fecha_pago, p.importe_total, CONCAT_WS(\" \", u.nombre_usu, u.apellido_usu) AS noap, "
                    + "p.numFactura, u.direccion_usu, u.num_doc_usu "
                    + "FROM pagos p, usuarios u WHERE p.id_pago = ? AND u.id_usuario = p.id_usuario LIMIT 1");
            ps.setString(1, idPago);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p.add(utilidades.Estaticos.FORMATODMA.format(rs.getDate("p.fecha_pago")));
                p.add(rs.getString("importe_total"));
                p.add(rs.getString("noap"));
                p.add(rs.getString("p.numFactura"));
                p.add(rs.getString("u.direccion_usu"));
                p.add(rs.getString("u.num_doc_usu"));
                p.add(rs.getString("p.id_usuario"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar mostrar pago: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar mostrar pago: --> ", ex);
            }
        }
        return p;
    }

    public List<modelos.DetallePago> listarDetallePago(String idPago) {
        List<modelos.DetallePago> p = null;
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT concepto, subtotal, monto_descuento, cantidad, tipo_iva FROM detalle_pago WHERE id_pago = ?");
            ps.setString(1, idPago);
            ResultSet rs = ps.executeQuery();
            p = new ArrayList<>();
            while (rs.next()) {
                modelos.DetallePago dp = new modelos.DetallePago();
                dp.setConcepto(rs.getString("concepto"));
                dp.setSubtotal(rs.getInt("subtotal"));
                dp.setTipoIVA(rs.getInt("tipo_iva"));
                dp.setCantidad(rs.getInt("cantidad"));
                dp.setMontoDescuento(rs.getInt("monto_descuento"));
                p.add(dp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar listar detalle de pago: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar listar detalle de pago: --> ", ex);
            }
        }
        return p;
    }

    public boolean actualizarComprobante(String idCompr, String estado) {
        con = Conectar.getConnect();
        PreparedStatement ps, ps1;
        try {
            con.setAutoCommit(false);
            ps1 = con.prepareStatement("SET @usuario = ?");
            ps1.setString(1, conexion.InicioSesion.getUsuario());
            ps1.execute();

            ps = con.prepareStatement("UPDATE comprobantes SET estado = ? WHERE id_comprobante = ?");
            ps.setString(1, estado);
            ps.setString(2, idCompr);
            ps.executeUpdate();

            con.commit();
        } catch (SQLException ex) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar actualizar estado de comprobante : ---> ", ex1);
            }
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar actualizar estado de comprobante: ", ex);
            return false;
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar actualizar estado de comprobante: --> ", ex);
            }
        }
        return true;
    }

    public boolean insertarPago(modelos.Pago pago, ArrayList<modelos.DetallePago> dpago, ArrayList<String> estados) {
        con = Conectar.getConnect();
        CallableStatement cs, cs1;
        PreparedStatement ps2, ps1;
        try {
            con.setAutoCommit(false);

            ps1 = con.prepareStatement("SET @usuario = ?");
            ps1.setString(1, conexion.InicioSesion.getUsuario());
            ps1.execute();

            cs = con.prepareCall("{CALL insertarPago(?, ?, ?, ?, ?, ?)}");
            cs.setDate(1, Funciones.utilDateaSqlDate(pago.getFechaPago()));
            cs.setInt(2, pago.getTotal());
            cs.setString(3, pago.getNumFactura());
            cs.setString(4, pago.getIdLote());
            cs.setString(5, pago.getIdUsuario());
            cs.registerOutParameter(6, java.sql.Types.INTEGER);
            cs.execute();
            pago.setIdentificador(cs.getInt(6));

            cs1 = con.prepareCall("{CALL insertarDetallePago(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            for (modelos.DetallePago detpago : dpago) {

                cs1.setString(1, detpago.getConcepto());
                cs1.setInt(2, detpago.getSubtotal());
                cs1.setInt(3, detpago.getCantidad());
                cs1.setInt(4, detpago.getTipoIVA());
                cs1.setInt(5, pago.getIdentificador());
                cs1.setInt(6, detpago.getMontoDescuento());
                cs1.setString(7, detpago.getTipoPago());
                cs1.setInt(8, detpago.getIdCuenta());
                if (detpago.getIdComprobante() != null) {
                    cs1.setInt(9, Integer.parseInt(detpago.getIdComprobante()));
                } else {
                    cs1.setNull(9, java.sql.Types.INTEGER);
                }

                if (detpago.getTipoPago().equals("ADELANTADO")) {
                    dao.Cuentas.actualizarSaldoAFavor(detpago.getIdCuenta(), detpago.getSubtotal(), true);
                }

                cs1.execute();
                cs1.clearParameters();
            }

            ps2 = con.prepareStatement("UPDATE comprobantes SET estado = ? WHERE id_comprobante = ?");
            for (String estado : estados) {
                String est[] = estado.split("-");
                ps2.setString(1, est[1]);
                ps2.setString(2, est[0]);
                ps2.addBatch();

            }
            ps2.executeBatch();

            con.commit();
        } catch (SQLException ex) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar insertar pago de comprobante: ---> ", ex1);
            }
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar insertar pago de comprobante: ", ex);
            return false;
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar insertar pago de comprobante: --> ", ex);
            }
        }
        return true;
    }

    public int AgregarPago(modelos.Pago pago, ArrayList<modelos.DetallePago> dpago, ArrayList<String> estados) {
        con = Conectar.getConnect();
        CallableStatement cs, cs1;
        PreparedStatement ps2, ps1;
        try {
            con.setAutoCommit(false);

            ps1 = con.prepareStatement("SET @usuario = ?");
            ps1.setString(1, conexion.InicioSesion.getUsuario());
            ps1.execute();

            cs = con.prepareCall("{CALL insertarPago(?, ?, ?, ?, ?, ?)}");
            cs.setDate(1, Funciones.utilDateaSqlDate(pago.getFechaPago()));
            cs.setInt(2, pago.getTotal());
            cs.setString(3, pago.getNumFactura());
            cs.setString(4, pago.getIdLote());
            cs.setString(5, pago.getIdUsuario());
            cs.registerOutParameter(6, java.sql.Types.INTEGER);
            cs.execute();
            pago.setIdentificador(cs.getInt(6));

            cs1 = con.prepareCall("{CALL insertarDetallePago(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            for (modelos.DetallePago detpago : dpago) {

                cs1.setString(1, detpago.getConcepto());
                cs1.setInt(2, detpago.getSubtotal());
                cs1.setInt(3, detpago.getCantidad());
                cs1.setInt(4, detpago.getTipoIVA());
                cs1.setInt(5, pago.getIdentificador());
                cs1.setInt(6, detpago.getMontoDescuento());
                cs1.setString(7, detpago.getTipoPago());
                cs1.setInt(8, detpago.getIdCuenta());
                if (detpago.getIdComprobante() != null) {
                    cs1.setInt(9, Integer.parseInt(detpago.getIdComprobante()));
                } else {
                    cs1.setNull(9, java.sql.Types.INTEGER);
                }

                if (detpago.getTipoPago().equals("ADELANTADO")) {
                    dao.Cuentas.actualizarSaldoAFavor(detpago.getIdCuenta(), detpago.getSubtotal(), true);
                }

                cs1.execute();
                cs1.clearParameters();
            }

            ps2 = con.prepareStatement("UPDATE comprobantes SET estado = ? WHERE id_comprobante = ?");
            for (String estado : estados) {
                String est[] = estado.split("-");
                ps2.setString(1, est[1]);
                ps2.setString(2, est[0]);
                ps2.addBatch();

            }
            ps2.executeBatch();

            con.commit();
        } catch (SQLException ex) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar insertar pago de comprobante: ---> ", ex1);
            }
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar insertar pago de comprobante: ", ex);
            return 0;
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar insertar pago de comprobante: --> ", ex);
            }
        }
        return pago.getIdentificador();
    }

    public boolean insertarPagoMulti(modelos.Pago pago, ArrayList<modelos.DetallePago> detpago) {
        con = Conectar.getConnect();
        CallableStatement cs;
        PreparedStatement ps, ps1;
        try {
            con.setAutoCommit(false);

            ps1 = con.prepareStatement("SET @usuario = ?");
            ps1.setString(1, conexion.InicioSesion.getUsuario());
            ps1.execute();

            cs = con.prepareCall("{CALL insertarPago(?, ?, ?, ?, ?, ?)}");
            cs.setDate(1, Funciones.utilDateaSqlDate(pago.getFechaPago()));
            cs.setInt(2, pago.getTotal());
            cs.setString(3, pago.getNumFactura());
            cs.setString(4, pago.getIdLote());
            cs.setString(5, pago.getIdUsuario());
            cs.registerOutParameter(6, java.sql.Types.INTEGER);
            cs.execute();
            pago.setIdentificador(cs.getInt(6));

            for (modelos.DetallePago d : detpago) {
                ps = con.prepareStatement("INSERT INTO detalle_pago(concepto, subtotal, cantidad, tipo_iva, id_pago, monto_descuento, tipo_concepto) VALUES(?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, d.getConcepto());
                ps.setInt(2, d.getSubtotal());
                ps.setInt(3, d.getCantidad());
                ps.setInt(4, d.getTipoIVA());
                ps.setInt(5, pago.getIdentificador());
                ps.setInt(6, d.getMontoDescuento());
                ps.setString(7, d.getTipoPago());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int id_detalle = (int) rs.getLong(1);
                    if (d.getTipoPago().equals("COMPROBANTES")) {
                        ps = con.prepareStatement("INSERT INTO pagos_por_comprobantes (id_detalle, id_comprobante) VALUES (?, ?)");
                        ps.setInt(1, id_detalle);
                        ps.setInt(2, Integer.valueOf(d.getIdComprobante()));
                        ps.executeUpdate();
                    }
                }
            }
            con.commit();
        } catch (SQLException ex) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar insertar pago por otros conceptos: ---> ", ex1);
            }
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar insertar pago por otros conceptos: ", ex);
            return false;
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar insertar pago por otros conceptos: --> ", ex);
            }
        }
        return true;
    }

    public boolean insertarPagoMulti(modelos.Pago pago, modelos.DetallePago d) {
        con = Conectar.getConnect();
        CallableStatement cs, cs1;
        PreparedStatement ps1;
        try {
            con.setAutoCommit(false);

            ps1 = con.prepareStatement("SET @usuario = ?");
            ps1.setString(1, conexion.InicioSesion.getUsuario());
            ps1.execute();
            cs = con.prepareCall("{CALL insertarPago(?, ?, ?, ?, ?, ?)}");
            cs.setDate(1, Funciones.utilDateaSqlDate(pago.getFechaPago()));
            cs.setInt(2, pago.getTotal());
            cs.setString(3, pago.getNumFactura());
            cs.setString(4, pago.getIdLote());
            cs.setString(5, pago.getIdUsuario());
            cs.registerOutParameter(6, java.sql.Types.INTEGER);
            cs.execute();
            pago.setIdentificador(cs.getInt(6));

            cs1 = con.prepareCall("{CALL insertarDetallePago(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cs1.setString(1, d.getConcepto());
            cs1.setInt(2, d.getSubtotal());
            cs1.setInt(3, d.getCantidad());
            cs1.setInt(4, d.getTipoIVA());
            cs1.setInt(5, pago.getIdentificador());
            cs1.setInt(6, d.getMontoDescuento());
            cs1.setString(7, d.getTipoPago());
            if (d.getIdCuenta() != null) {
                cs1.setInt(8, d.getIdCuenta());
            } else {
                cs1.setNull(8, java.sql.Types.INTEGER);
            }
            if (d.getIdComprobante() != null) {
                cs1.setInt(9, Integer.parseInt(d.getIdComprobante()));
            } else {
                cs1.setNull(9, java.sql.Types.INTEGER);
            }
            cs1.execute();
            ps1 = con.prepareStatement("SELECT c.id_usuario,(IFNULL((SELECT ERSSAN FROM deudas_anteriores WHERE id_usuario=c.id_usuario),0)+c.ERSSAN) as ERSSAN, (SELECT subtotal FROM deudas_anteriores WHERE id_usuario=c.id_usuario) AS subtotal FROM pagos p, detalle_pago dp, pagos_por_comprobantes pc, comprobantes c WHERE p.id_pago=dp.id_pago AND dp.iddetalle=pc.id_detalle AND c.id_comprobante=pc.id_comprobante AND estado_pago='PENDIENTE' AND p.id_usuario=? GROUP BY p.id_usuario");
            ps1.setInt(1, Integer.valueOf(pago.getIdUsuario()));
            ResultSet rs = ps1.executeQuery();
            if (rs.next()) {
                PreparedStatement ps = con.prepareStatement("INSERT INTO detalle_pago(concepto, tipo_concepto, subtotal, cantidad, tipo_iva, id_pago, monto_descuento) VALUES (?,?,?,?,?,?,?)");
                ps.setString(1, "TASA RETRIBUTARIA ERSSAN");
                ps.setString(2, "ERSSAN");
                ps.setInt(3, rs.getInt("ERSSAN"));
                ps.setInt(4, 1);
                ps.setInt(5, 0);
                ps.setInt(6, pago.getIdentificador());
                ps.setInt(7, 0);
                ps.executeUpdate();
                if (rs.getString("subtotal") != null) {
                    con.prepareStatement("INSERT INTO detalle_pago(concepto, tipo_concepto, subtotal, cantidad, tipo_iva, id_pago, monto_descuento) VALUES (?,?,?,?,?,?,?)");
                    ps.setString(1, "DEUDAS ANTERIORES");
                    ps.setString(2, "DEUDAS");
                    ps.setInt(3, rs.getInt("subtotal"));
                    ps.setInt(4, 1);
                    ps.setInt(5, 0);
                    ps.setInt(6, pago.getIdentificador());
                    ps.setInt(7, 0);
                    ps.executeUpdate();
                }
            }
            con.commit();

        } catch (SQLException ex) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar insertar pago: ---> ", ex1);
            }
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar insertar pago: ", ex);
            return false;
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar insertar pago: --> ", ex);
            }
        }
        return true;
    }

    public boolean insertarPagoxDetallexCargos(modelos.Pago pago, modelos.DetallePago d, ArrayList<modelos.DetallePago> cargos) {
        con = Conectar.getConnect();
        CallableStatement cs, cs1;
        PreparedStatement ps1;
        try {
            con.setAutoCommit(false);

            ps1 = con.prepareStatement("SET @usuario = ?");
            ps1.setString(1, conexion.InicioSesion.getUsuario());
            ps1.execute();
            cs = con.prepareCall("{CALL insertarPago(?, ?, ?, ?, ?, ?)}");
            cs.setDate(1, Funciones.utilDateaSqlDate(pago.getFechaPago()));
            cs.setInt(2, pago.getTotal());
            cs.setString(3, pago.getNumFactura());
            cs.setString(4, pago.getIdLote());
            cs.setString(5, pago.getIdUsuario());
            cs.registerOutParameter(6, java.sql.Types.INTEGER);
            cs.execute();
            pago.setIdentificador(cs.getInt(6));

            cs1 = con.prepareCall("{CALL insertarDetallePago(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cs1.setString(1, d.getConcepto());
            cs1.setInt(2, d.getSubtotal());
            cs1.setInt(3, d.getCantidad());
            cs1.setInt(4, d.getTipoIVA());
            cs1.setInt(5, pago.getIdentificador());
            cs1.setInt(6, d.getMontoDescuento());
            cs1.setString(7, d.getTipoPago());
            if (d.getIdCuenta() != null) {
                cs1.setInt(8, d.getIdCuenta());
            } else {
                cs1.setNull(8, java.sql.Types.INTEGER);
            }
            if (d.getIdComprobante() != null) {
                cs1.setInt(9, Integer.parseInt(d.getIdComprobante()));
            } else {
                cs1.setNull(9, java.sql.Types.INTEGER);
            }
            cs1.execute();

            ps1 = con.prepareStatement("SELECT cuentas.id_usuario, medidores_por_cuentas.saldo_medidor, medidores_por_cuentas.erssan_medidor FROM medidores_por_cuentas, cuentas, medidores WHERE medidores_por_cuentas.id_cuenta=cuentas.id_cuenta AND medidores_por_cuentas.id_medidor=medidores.id_medidor AND medidores.estado_med='ACTIVO' AND cuentas.id_usuario=?");
            ps1.setInt(1, Integer.valueOf(pago.getIdUsuario()));
            ResultSet rs = ps1.executeQuery();
            if (rs.next()) {
                PreparedStatement ps = con.prepareStatement("INSERT INTO detalle_pago(concepto, tipo_concepto, subtotal, cantidad, tipo_iva, id_pago, monto_descuento) VALUES (?,?,?,?,?,?,?)");
                ps.setString(1, "TASA RETRIBUTARIA ERSSAN");
                ps.setString(2, "ERSSAN");
                ps.setInt(3, rs.getInt("erssan_medidor") + d.getErssan());
                ps.setInt(4, 1);
                ps.setInt(5, 0);
                ps.setInt(6, pago.getIdentificador());
                ps.setInt(7, 0);
                ps.executeUpdate();
                if (rs.getString("saldo_medidor") != null) {
                    ps = con.prepareStatement("INSERT INTO detalle_pago(concepto, tipo_concepto, subtotal, cantidad, tipo_iva, id_pago, monto_descuento) VALUES (?,?,?,?,?,?,?)");
                    ps.setString(1, "DEUDAS ANTERIORES");
                    ps.setString(2, "DEUDAS");
                    ps.setInt(3, rs.getInt("saldo_medidor"));
                    ps.setInt(4, 1);
                    ps.setInt(5, 0);
                    ps.setInt(6, pago.getIdentificador());
                    ps.setInt(7, 0);
                    ps.executeUpdate();
                }
            }

            for (modelos.DetallePago detalle : cargos) {
                PreparedStatement ps = con.prepareStatement("INSERT INTO detalle_pago(concepto, tipo_concepto, subtotal, cantidad, tipo_iva, id_pago, monto_descuento) VALUES (?,?,?,?,?,?,?)");
                ps.setString(1, detalle.getConcepto());
                ps.setString(2, "CARGOSADD");
                ps.setInt(3, detalle.getSubtotal());
                ps.setInt(4, detalle.getCantidad());
                ps.setInt(5, 0);
                ps.setInt(6, pago.getIdentificador());
                ps.setInt(7, 0);
                ps.executeUpdate();
            }

            ps1 = con.prepareStatement("SELECT comprobantes.id_usuario,comprobantes.id_comprobante as id_comprobante, detalle_pago.iddetalle as iddetalle, cuentas.id_cuenta as id_cuenta, medidores_por_cuentas.id_medidor as id_medidor, pagos.importe_total as importe_total, comprobantes.ERSSAN as erssan FROM `comprobantes`, pagos, detalle_pago, pagos_por_comprobantes, lecturas, medidores, medidores_por_cuentas, cuentas WHERE comprobantes.id_comprobante=pagos_por_comprobantes.id_comprobante AND pagos_por_comprobantes.id_detalle=detalle_pago.iddetalle AND detalle_pago.id_pago =pagos.id_pago AND comprobantes.id_lectura=lecturas.id_lectura AND lecturas.id_medidor=medidores.id_medidor AND medidores_por_cuentas.id_medidor=medidores.id_medidor AND medidores_por_cuentas.id_cuenta = cuentas.id_cuenta AND pagos.id_pago=?");
            ps1.setInt(1, pago.getIdentificador());
            rs = ps1.executeQuery();
            if (rs.next()) {
                ps1 = con.prepareStatement("UPDATE medidores_por_cuentas SET saldo_medidor=?, erssan_medidor=erssan_medidor+? WHERE id_cuenta=? AND id_medidor=?");
                ps1.setInt(1, rs.getInt("importe_total"));
                ps1.setInt(2, rs.getInt("erssan"));
                ps1.setInt(3, rs.getInt("id_cuenta"));
                ps1.setInt(4, rs.getInt("id_medidor"));
                ps1.executeUpdate();
            }
            con.commit();
        } catch (SQLException ex) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar insertar pago: ---> ", ex1);
            }
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar insertar pago: ", ex);
            return false;
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar insertar pago: --> ", ex);
            }
        }
        return true;
    }

    public static boolean existeNumFactura(String numFactura) {
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT COUNT(numFactura) as existe FROM pagos WHERE numFactura = ?");
            ps.setString(1, numFactura);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getInt("existe") > 0) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar buscar número de factura: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar buscar número de factura: --> ", ex);
            }
        }
        return false;
    }

    public static modelos.LotePagos obtenerLotePago(String idLote) {
        modelos.LotePagos lp = null;
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT fecha_generacion_loteP, mes_loteP, anho_loteP FROM lotepagos WHERE id_loteP = ?");
            ps.setString(1, idLote);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                lp = new modelos.LotePagos();
                lp.setFechaLote(rs.getDate("fecha_generacion_loteP"));
                lp.setMes(rs.getString("mes_loteP"));
                lp.setAnho(rs.getString("anho_loteP"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar obtener lote de pago: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar obtener lote de pago: --> ", ex);
            }
        }
        return lp;
    }

    public Integer reasignarNumFactura(String idPago) {
        Integer nuevo = null;
        String numnuevo = numeroFactura();
        con = Conectar.getConnect();
        PreparedStatement ps0, ps, psi, ps1, ps2, ps3, ps4, ps5;
        try {
            con.setAutoCommit(false);

            ps1 = con.prepareStatement("SET @usuario = ?");
            ps1.setString(1, conexion.InicioSesion.getUsuario());
            ps1.execute();

            ps0 = con.prepareStatement("UPDATE pagos SET anulado = true WHERE id_pago = ?");
            ps0.setString(1, idPago);
            ps0.executeUpdate();

            psi = con.prepareStatement("INSERT INTO pagos(fecha_pago, importe_total, id_loteP, numFactura, tipo_pago, estado_pago, id_usuario) "
                    + "SELECT fecha_pago, importe_total, id_loteP, ?, tipo_pago, estado_pago, id_usuario FROM pagos WHERE id_pago = ?", Statement.RETURN_GENERATED_KEYS);
            psi.setString(1, numnuevo);
            psi.setString(2, idPago);
            psi.executeUpdate();
            try (ResultSet generatedKeys = psi.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idPagoNuevo = generatedKeys.getInt(1);
                    ps = con.prepareStatement("SELECT iddetalle, concepto, tipo_concepto, subtotal, cantidad, tipo_iva, monto_descuento FROM detalle_pago WHERE id_pago = ?");
                    ps.setString(1, idPago);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        ps2 = con.prepareStatement("INSERT INTO detalle_pago(concepto, tipo_concepto, subtotal, cantidad, "
                                + "tipo_iva, id_pago, monto_descuento) SELECT concepto, tipo_concepto, subtotal, cantidad, "
                                + "tipo_iva, ?, monto_descuento FROM detalle_pago WHERE iddetalle = ?", Statement.RETURN_GENERATED_KEYS);
                        ps2.setInt(1, idPagoNuevo);
                        ps2.setInt(2, rs.getInt("iddetalle"));
                        ps2.executeUpdate();
                        try (ResultSet idDetalleNuevo = ps2.getGeneratedKeys()) {
                            if (idDetalleNuevo.next()) {
                                ps3 = con.prepareStatement("SELECT pc.id_detalle, pc.id_comprobante FROM pagos_por_comprobantes pc WHERE pc.id_detalle = ?");
                                ps3.setInt(1, rs.getInt("iddetalle"));
                                ResultSet rs2 = ps3.executeQuery();
                                if (rs2.next()) {
                                    ps5 = con.prepareStatement("INSERT INTO pagos_por_comprobantes(id_detalle, id_comprobante) VALUES(?, ?)");
                                    ps5.setInt(1, idDetalleNuevo.getInt(1));
                                    ps5.setInt(2, rs2.getInt("pc.id_comprobante"));
                                    ps5.executeUpdate();
                                } else {
                                    ps3 = con.prepareStatement("SELECT pc.id_detalle, pc.id_cuenta FROM pagos_por_cuentas pc WHERE pc.id_detalle = ?");
                                    ps3.setInt(1, rs.getInt("iddetalle"));
                                    ResultSet rs3 = ps3.executeQuery();
                                    if (rs3.next()) {
                                        ps4 = con.prepareStatement("INSERT INTO pagos_por_cuentas(id_detalle, id_cuenta) VALUES(?, ?)");
                                        ps4.setInt(1, idDetalleNuevo.getInt(1));
                                        ps4.setInt(2, rs3.getInt("pc.id_cuenta"));
                                        ps4.executeUpdate();
                                    }
                                }
                            }
                        }
                    }

                    au = new modelos.Auditoria();
                    au.setIdAuditado(String.format("%s", idPagoNuevo));
                    au.setTablaAuditada("PAGOS");
                    au.setDetalleAuditado(String.join(" ", "SE ANULÓ EL PAGO Nº", idPago, "PARA GENERAR UN NUEVA FACTURA:", numnuevo, ". EL NUEVO Nº DE PAGO ES",
                            String.format("%s", idPagoNuevo)));
                    au.setAccion("ACTUALIZAR");
                    au.setAutor(conexion.InicioSesion.getUsuario());
                    dao.Auditoria.AfterInsert(au);
                    con.commit();
                    nuevo = idPagoNuevo;
                } else {
                    return null;
                }
            }
        } catch (SQLException ex) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar reasignar número de factura: ---> ", ex1);
            }
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar reasignar número de factura: ", ex);
            return null;
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, "Error al intentar reasignar número de factura: --> ", ex);
            }
        }
        return nuevo;
    }

    public ArrayList<modelos.Pago> ImprimirPagosxNfactura(String inicio, String fin) {
        con = Conectar.getConnect();
        ArrayList<modelos.Pago> pagos = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareCall("SELECT * FROM pagos WHERE CONVERT(SUBSTRING(numFactura,9), UNSIGNED INTEGER) BETWEEN CONVERT(SUBSTRING(?,9), UNSIGNED INTEGER) AND CONVERT(SUBSTRING(?,9), UNSIGNED INTEGER)");
            ps.setString(1, inicio);
            ps.setString(2, fin);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelos.Pago pago = new modelos.Pago();
                pago.setIdentificador(rs.getInt("id_pago"));
                pagos.add(pago);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pagos;
    }

    public static void ActualizarEstadoPago(int id_pago, Boolean x) {
        con = Conectar.getConnect();
        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement("UPDATE pagos SET estado_pago = ? WHERE id_pago = ?");
            ps.setBoolean(1, x);
            ps.setInt(2, id_pago);
            ps.executeUpdate();
            ps = con.prepareStatement("SELECT comprobantes.id_usuario,comprobantes.id_comprobante as id_comprobante, comprobantes.id_loteFac, detalle_pago.iddetalle as iddetalle, cuentas.id_cuenta as id_cuenta, medidores_por_cuentas.id_medidor as id_medidor, pagos.importe_total as importe_total,  erssanxPago(?) as erssan FROM `comprobantes`, pagos, detalle_pago, pagos_por_comprobantes, lecturas, medidores, medidores_por_cuentas, cuentas WHERE comprobantes.id_comprobante=pagos_por_comprobantes.id_comprobante AND pagos_por_comprobantes.id_detalle=detalle_pago.iddetalle AND detalle_pago.id_pago =pagos.id_pago AND comprobantes.id_lectura=lecturas.id_lectura AND lecturas.id_medidor=medidores.id_medidor AND medidores_por_cuentas.id_medidor=medidores.id_medidor AND medidores_por_cuentas.id_cuenta = cuentas.id_cuenta AND pagos.id_pago=?");
            ps.setInt(1, id_pago);
            ps.setInt(2, id_pago);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ps = con.prepareStatement("UPDATE comprobantes SET estado = ? WHERE id_usuario = ? AND loteFac_dependiente=?");
                ps.setString(1, x ? "PAGADO" : "PENDIENTE");
                ps.setInt(2, rs.getInt("id_usuario"));
                ps.setInt(3, rs.getInt("id_loteFac"));
                ps.executeUpdate();
                ps = con.prepareStatement("UPDATE medidores_por_cuentas SET saldo_medidor=(saldo_medidor+?), erssan_medidor=(erssan_medidor+?) WHERE id_cuenta=? AND id_medidor=?");
                ps.setInt(1, x ? (-1 * rs.getInt("importe_total")) : rs.getInt("importe_total"));
                ps.setInt(2, x ? (-1 * rs.getInt("erssan")) : rs.getInt("erssan"));
                ps.setInt(3, rs.getInt("id_cuenta"));
                ps.setInt(4, rs.getInt("id_medidor"));
                ps.executeUpdate();
            }
            con.commit();
        } catch (SQLException ex) {
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, null, ex);
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static int ContarFacturasNoPagadas(int id_usuario) {
        con = Conectar.getConnect();
        int r = 0;
        try {
            PreparedStatement ps = con.prepareStatement("select COUNT(comprobantes.estado) as no_pagados from comprobantes where comprobantes.estado = 'PENDIENTE' and comprobantes.id_usuario=?");
            ps.setInt(1, id_usuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                r = rs.getInt("no_pagados");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return r;
    }
}
