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
import java.util.logging.Logger;
import utilidades.Funciones;

public class Comprobante {

    static Connection con;
    modelos.Auditoria au;

    public boolean insertarComprobante(modelos.Comprobante compr) {
        con = Conectar.getConnect();
        PreparedStatement ps, ps1;
        try {
            java.sql.Date fechaActual = Funciones.utilDateaSqlDate(compr.getFechaActual());
            java.sql.Date fechaAnterior = compr.getFechaAnterior() == null ? null : Funciones.utilDateaSqlDate(compr.getFechaAnterior());
            java.sql.Date fechaVencimiento = Funciones.utilDateaSqlDate(compr.getFechaVencimiento());
            con.setAutoCommit(false);

            ps1 = con.prepareStatement("SET @usuario = ?");
            ps1.setString(1, conexion.InicioSesion.getUsuario());
            ps1.execute();

            ps = con.prepareStatement("INSERT INTO comprobantes"
                    + "(fecha_ant, fecha_act, lec_anterior, lec_actual, vencimiento, IVA10, ERSSAN, id_usuario, id_lectura, "
                    + "m3minimo, m3excedente, m3Total, impMinimo, impExcedente, impTotal, id_zona, id_loteFac) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setDate(1, fechaAnterior);
            ps.setDate(2, fechaActual);
            ps.setInt(3, compr.getLecturaAnterior());
            ps.setInt(4, compr.getLecturaActual());
            ps.setDate(5, fechaVencimiento);
            ps.setInt(6, compr.getIVA10());
            ps.setInt(7, compr.getERSSAN());
            ps.setString(8, compr.getIdUsuario());
            ps.setInt(9, compr.getIdLectura());
            ps.setInt(10, compr.getM3Minimo());
            ps.setInt(11, compr.getM3Excedente());
            ps.setInt(12, compr.getM3Total());
            ps.setInt(13, compr.getImpMinimo());
            ps.setInt(14, compr.getImpExcedente());
            ps.setInt(15, compr.getImpTotal());
            ps.setInt(16, compr.getIdZona());
            ps.setInt(17, compr.getIdLoteFac());
            ps.executeUpdate();

            ps = con.prepareStatement("UPDATE comprobantes SET loteFac_dependiente=? WHERE estado='PENDIENTE' AND id_usuario=?");
            ps.setInt(1, compr.getIdLoteFac());
            ps.setString(2, compr.getIdUsuario());
            ps.executeUpdate();

            con.commit();

        } catch (SQLException ex) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar insertar comprobante: --> ", ex1);
            }
            Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar insertar comprobante: ", ex);
            return false;
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar insertar comprobante: --->", ex);
            }
        }
        return true;
    }

    public List<modelos.Comprobantes> obtenerComprobantes(String idLoteFactura) {
        con = Conectar.getConnect();
        List<modelos.Comprobantes> datos = new ArrayList();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT u.nombre_usu, u.apellido_usu, m.numero_med, cu.id_usuario, c.fecha_act, c.fecha_ant, "
                    + "c.lec_actual AS lectAct, c.lec_anterior AS lectAnt, c.m3Minimo AS m3minimo, c.m3Excedente AS m3Excedente, c.m3Total AS m3Total, c.impMinimo AS impminimo, c.impExcedente AS impExcedente, c.impTotal AS impTotal, "
                    + "c.id_comprobante, c.vencimiento, c.iva10 AS IVA10, c.erssan AS ERSSAN, z.zona, c.id_lectura, m.id_medidor, c.estado "
                    + "FROM medidores m, comprobantes c, usuarios u, lecturas l, zonas z, lotefacturas lf, cuentas cu, medidores_por_cuentas mc "
                    + "WHERE c.id_loteFac = ? AND u.id_usuario = cu.id_usuario AND c.id_usuario = cu.id_usuario AND mc.id_cuenta = cu.id_cuenta "
                    + "AND mc.id_medidor = l.id_medidor AND m.id_medidor = l.id_medidor AND z.id_zona = c.id_zona AND lf.id_loteFac = c.id_loteFac "
                    + "AND c.id_lectura = l.id_lectura AND c.estado != ? AND l.es_actual != ? "
                    + "GROUP BY c.id_comprobante ASC");
            ps.setString(1, idLoteFactura);
            ps.setString(2, "ELIMINADO");
            ps.setString(3, "T");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelos.Comprobantes c = new modelos.Comprobantes();
                c.setNomAp(rs.getString("u.nombre_usu") + " " + rs.getString("u.apellido_usu"));
                c.setNumMedidor(rs.getString("m.numero_med"));
                c.setNumUsuario(rs.getString("cu.id_usuario"));
                c.setFechaActual(rs.getDate("c.fecha_act") == null ? "-" : utilidades.Estaticos.FORMATODMA.format(rs.getDate("c.fecha_act")));
                c.setFechaAnterior(rs.getDate("c.fecha_ant") == null ? "-" : utilidades.Estaticos.FORMATODMA.format(rs.getDate("c.fecha_ant")));
                c.setLecturaActual(rs.getInt("lectAct"));
                c.setLecturaAnterior(rs.getInt("lectAnt"));
                c.setMinimoM3(rs.getInt("m3minimo"));
                c.setExcedenteM3(rs.getInt("m3Excedente"));
                c.setTotalM3(rs.getInt("m3Total"));
                c.setMinimoImporte(rs.getInt("impminimo"));
                c.setExcedenteImporte(rs.getInt("impExcedente"));
                c.setTotalImporte(rs.getInt("impTotal"));
                c.setFacturaActual(rs.getInt("impTotal"));
                c.setFacturaAnterior(dao.Comprobante.obtenerSaldoAnteriorALectura(rs.getString("c.id_lectura")));
                c.setNumComprobante(rs.getString("c.id_comprobante"));
                c.setVencimiento(utilidades.Estaticos.FORMATODMA.format(rs.getDate("c.vencimiento")));
                c.setIVA10(rs.getInt("IVA10"));
                c.setERSSAN(rs.getInt("ERSSAN"));
                c.setTotalCargos(0);
                c.setTotalMas10(c.getTotalImporte() + c.getIVA10() + c.getFacturaAnterior());
                c.setDirUsuario(rs.getString("z.zona"));
                c.setPendientes(dao.Comprobante.obtenerPendientesAnterioresA(rs.getString("c.id_comprobante"), rs.getInt("m.id_medidor")));
                c.setEstado(rs.getString("c.estado"));
                datos.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar obtener comprobantes: ", ex);
        }
        return datos;
    }

    public String obtenerComprobantePorLectura(String idLectura) {
        String idComp = null;
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id_comprobante FROM comprobantes WHERE id_lectura = ?");
            ps.setString(1, idLectura);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idComp = rs.getString("id_comprobante");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar obtener comprobante por lectura: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar insertar comprobante: --> ", ex);
            }
        }
        return idComp;
    }

    public ArrayList<String> obtenerComprobante(String idLectura) {
        con = Conectar.getConnect();
        ArrayList<String> datos = null;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT u.nombre_usu, u.apellido_usu, cu.id_usuario, m.numero_med, m.id_medidor, "
                    + "c.fecha_act, c.fecha_ant, c.lec_actual AS lectAct, c.lec_anterior AS lectAnt, "
                    + "c.m3Minimo AS m3minimo, c.m3Excedente AS m3Excedente, c.m3Total AS m3Total, "
                    + "c.impMinimo AS impminimo, c.impExcedente AS impExcedente, c.impTotal AS impTotal, "
                    + "c.id_comprobante, c.vencimiento, c.iva10 AS IVA10, c.erssan AS ERSSAN, z.zona, z.id_zona, c.id_loteFac, c.estado "
                    + "FROM medidores m, comprobantes c, usuarios u, lecturas l, zonas z, lotefacturas lf, cuentas cu, medidores_por_cuentas mc "
                    + "WHERE c.id_lectura = ? AND u.id_usuario = cu.id_usuario AND c.id_usuario = cu.id_usuario AND mc.id_cuenta = cu.id_cuenta "
                    + "AND mc.id_medidor = l.id_medidor AND m.id_medidor = l.id_medidor AND z.id_zona = c.id_zona AND lf.id_loteFac = c.id_loteFac AND c.id_lectura = l.id_lectura");
            ps.setString(1, idLectura);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                datos = new ArrayList<>();
                datos.add(rs.getString("u.nombre_usu") + " " + rs.getString("u.apellido_usu"));
                datos.add(rs.getString("m.numero_med"));
                datos.add(rs.getString("cu.id_usuario"));
                datos.add(utilidades.Estaticos.FORMATODMA.format(rs.getDate("c.fecha_act")));
                datos.add(rs.getDate("c.fecha_ant") == null ? "-" : utilidades.Estaticos.FORMATODMA.format(rs.getDate("c.fecha_ant")));
                datos.add(rs.getString("lectAct"));
                datos.add(rs.getString("lectAnt"));
                datos.add(rs.getString("m3minimo"));
                datos.add(rs.getString("m3excedente"));
                datos.add(rs.getString("m3Total"));
                datos.add(rs.getString("impminimo"));
                datos.add(rs.getString("impExcedente"));
                datos.add(rs.getString("impTotal"));
                datos.add(rs.getString("c.id_comprobante"));
                datos.add(utilidades.Estaticos.FORMATODMA.format(rs.getDate("c.vencimiento")));
                datos.add(rs.getString("IVA10"));
                datos.add(rs.getString("ERSSAN"));
                datos.add(rs.getString("z.zona"));
                datos.add(rs.getString("z.id_zona"));
                datos.add(rs.getString("c.id_loteFac"));
                datos.add(rs.getString("m.id_medidor"));
                datos.add(rs.getString("c.estado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar obtener comprobante: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar obtener comprobante: -->", ex);
            }
        }
        return datos;
    }

    public boolean insertarLoteLectura(modelos.LoteComprobantes lc) {
        con = Conectar.getConnect();
        PreparedStatement ps, ps1;
        try {
            java.sql.Date fechagen = Funciones.utilDateaSqlDate(lc.getFechaGeneracion());
            java.sql.Date fechavenc = Funciones.utilDateaSqlDate(lc.getFechaVencimiento());
            con.setAutoCommit(false);

            ps1 = con.prepareStatement("SET @usuario = ?");
            ps1.setString(1, conexion.InicioSesion.getUsuario());
            ps1.execute();

            ps = con.prepareStatement("INSERT INTO lotefacturas(fecha_generacion_loteFac, fecha_vencimiento_loteFac, descripcion_loteFac, obs_lote, mes_loteFac, anho_loteFac) VALUES(?,?,?,?,?,?)");
            ps.setDate(1, fechagen);
            ps.setDate(2, fechavenc);
            ps.setString(3, lc.getDescripcion());
            ps.setString(4, lc.getObservacion());
            ps.setString(5, lc.getMesLote());
            ps.setInt(6, lc.getAnhoLote());
            ps.executeUpdate();
            con.commit();

        } catch (SQLException ex) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar insertar lote de comprobantes: ", ex1);
            }
            Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar insertar lote de comprobantes: --> ", ex);
            return false;
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar insertar lote de comprobante: -->", ex);
            }
        }
        return true;
    }

    public static List<modelos.LoteComprobantes> listarLotesLecturas() {
        List<modelos.LoteComprobantes> lm = null;
        con = Conectar.getConnect();
        try {
            Statement sent = con.createStatement();
            ResultSet rs = sent.executeQuery("SELECT id_loteFac, descripcion_loteFac, anho_loteFac, mes_loteFac, fecha_vencimiento_loteFac "
                    + "FROM lotefacturas ORDER BY id_loteFac DESC");
            lm = new ArrayList<>();
            while (rs.next()) {
                modelos.LoteComprobantes l = new modelos.LoteComprobantes();
                l.setIdentificador(rs.getInt("id_loteFac"));
                l.setDescripcion(rs.getString("descripcion_loteFac"));
                l.setAnhoLote(rs.getInt("anho_loteFac"));
                l.setMesLote(rs.getString("mes_loteFac"));
                l.setFechaVencimiento(rs.getDate("fecha_vencimiento_loteFac") == null ? null : rs.getTimestamp("fecha_vencimiento_loteFac"));
                lm.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar listar lotes de comprobantes: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar listar lotes de comprobantes: --> ", ex);
            }
        }
        return lm;
    }

    public boolean existeMismaFechaLote(modelos.LoteComprobantes ml) {
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) as existe FROM lotefacturas WHERE MONTH(fecha_vencimiento_loteFac) = ? "
                    + "AND YEAR(fecha_vencimiento_loteFac) = ? AND mes_loteFac = ? AND anho_loteFac = ?");
            ps.setInt(1, ml.getFechaVencimiento().getMonth() + 1);
            ps.setInt(2, ml.getFechaVencimiento().getYear());
            ps.setString(3, ml.getMesLote());
            ps.setInt(4, ml.getAnhoLote());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getInt("existe") > 0) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar buscar coincidencias de mes y año de lote: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar buscar coincidencias de mes y año de lote: --> ", ex);
            }
        }
        return false;
    }

    public static List<modelos.Comprobante> getComprobantesPendientesxCuentaYMedidor(Integer idCuenta, Integer idMedidor) {
        List<modelos.Comprobante> comprobantes = new ArrayList<>();
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT c.id_comprobante, c.IVA10 + c.impTotal as total, c.vencimiento, c.erssan "
                    + "FROM cuentas cu, medidores_por_cuentas mc, medidores m, comprobantes c "
                    + "INNER JOIN lecturas l ON l.id_lectura = c.id_lectura "
                    + "WHERE cu.id_cuenta = ? AND mc.id_medidor = ? AND m.id_medidor = l.id_medidor AND mc.id_cuenta = cu.id_cuenta AND m.id_medidor = mc.id_medidor "
                    + "AND c.estado != 'PAGADO' AND c.estado != 'ELIMINADO' AND l.es_actual != 'T'");
            ps.setInt(1, idCuenta);
            ps.setInt(2, idMedidor);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelos.Comprobante comprobante = new modelos.Comprobante();
                comprobante.setIdComprobante(rs.getInt("c.id_comprobante"));
                comprobante.setImpTotal(rs.getInt("total"));
                PreparedStatement ps2 = con.prepareStatement("SELECT obtenerMontoPagadoComprobante(?) as pagado");
                ps2.setString(1, rs.getString("c.id_comprobante"));
                ResultSet rs2 = ps2.executeQuery();
                if (rs2.next()) {
                    comprobante.setImpMinimo(rs2.getInt("pagado")); //trampa: es el monto ya abonado, no el importe mínimo
                }
                comprobante.setFechaVencimiento(rs.getTimestamp("c.vencimiento"));
                comprobante.setERSSAN(rs.getInt("c.erssan"));
                comprobantes.add(comprobante);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar obtener comprobantes pendientes por cuenta/medidor: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar obtener comprobantes pendientes por cuenta/medidor: --> ", ex);
            }
        }
        return comprobantes;
    }

    public static int contarComprobantesPendientes(String idCuenta) {
        int cuenta = 0;
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT COUNT(c.id_comprobante) as cuenta FROM medidores_por_cuentas mc, comprobantes c "
                    + "INNER JOIN lecturas l ON l.id_lectura = c.id_lectura "
                    + "WHERE mc.id_cuenta = ? AND mc.id_medidor = l.id_medidor AND c.estado != 'PAGADO' AND c.estado != 'ELIMINADO' AND l.es_actual != 'T'");
            ps.setString(1, idCuenta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cuenta = rs.getInt("cuenta");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar contar comprobantes pendientes: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar contar comprobantes pendientes: --> ", ex);
            }
        }
        return cuenta;
    }

    public static Integer obtenerSaldo(Integer idCuenta) {
        con = Conectar.getConnect();
        Integer total = 0;
        try {
            try (PreparedStatement ps = con.prepareStatement("SELECT deudaActualDeCuenta(?) as TOTAL")) {
                ps.setInt(1, idCuenta);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        total = rs.getInt("TOTAL");
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar obtener saldo de cuenta: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar obtener saldo de cuenta: --> ", ex);
            }
        }
        return total;
    }

    public static Integer obtenerYaPagado(String idComprobante) {
        con = Conectar.getConnect();
        Integer total = 0;
        try {
            try (PreparedStatement ps = con.prepareStatement("SELECT obtenerMontoPagadoComprobante(?) as pagado")) {
                ps.setString(1, idComprobante);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        total = rs.getInt("pagado");
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar obtener monto abonado de comprobante: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar obtener monto pagado de comprobante: --> ", ex);
            }
        }
        return total;
    }

    public static Integer obtenerSaldoAnteriorALectura(String idLectura) {
        int medidor = dao.Medidor.obtenerIdMedidorPorLectura(idLectura);
        Integer total = 0, yapagado = 0;
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT COALESCE(SUM(impTotal+IVA10), 0) AS TOTAL FROM comprobantes, "
                    + "lecturas WHERE lecturas.id_lectura = comprobantes.id_lectura AND lecturas.id_medidor = ? "
                    + "AND lecturas.id_lectura < ? AND comprobantes.estado != 'ELIMINADO' AND lecturas.es_actual != 'T'");
            ps.setInt(1, medidor);
            ps.setString(2, idLectura);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getInt("TOTAL");
            }
            PreparedStatement ps2 = con.prepareStatement("SELECT COALESCE(SUM(subtotal), 0) AS SUMA FROM detalle_pago, comprobantes, pagos, lecturas, pagos_por_comprobantes pc "
                    + "WHERE comprobantes.id_comprobante = pc.id_comprobante AND pagos.id_pago = detalle_pago.id_pago AND detalle_pago.iddetalle = pc.id_detalle "
                    + "AND pagos.anulado IS NULL AND comprobantes.id_lectura = lecturas.id_lectura AND lecturas.id_medidor = ? "
                    + "AND lecturas.id_lectura < ? AND comprobantes.estado != 'ELIMINADO' AND lecturas.es_actual != 'T'");
            ps2.setInt(1, medidor);
            ps2.setString(2, idLectura);
            ResultSet rs2 = ps2.executeQuery();
            if (rs2.next()) {
                yapagado = rs2.getInt("SUMA");
            }

            PreparedStatement ps3 = con.prepareStatement("SELECT saldocomprobantes AS TOTAL FROM cuentas c, medidores_por_cuentas mc, lecturas l WHERE c.id_cuenta = mc.id_cuenta AND mc.id_medidor = l.id_medidor AND l.id_medidor = ? LIMIT 1");
            int med = dao.Medidor.obtenerIdMedidorPorLectura(idLectura);
            ps3.setInt(1, med);
            ResultSet rs3 = ps3.executeQuery();
            if (rs3.next()) {
                total += rs3.getInt("TOTAL");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar obtener saldo anterior a lectura: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar obtener saldo anterior a lectura: --> ", ex);
            }
        }
        return total - yapagado;
    }

    public static int obtenerPendientesAnterioresA(String idComprobante, int idMedidor) {
        int pendientes = 0;
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) AS TOTAL FROM comprobantes c, lecturas "
                    + "WHERE lecturas.id_lectura = c.id_lectura AND lecturas.id_medidor = ? AND c.id_comprobante < ? AND c.estado != 'PAGADO' AND c.estado != 'ELIMINADO' AND lecturas.es_actual != 'T'");
            ps.setInt(1, idMedidor);
            ps.setString(2, idComprobante);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pendientes = rs.getInt("TOTAL");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar obtener cantidad de pendientes anteriores a comprobante: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar obtener cantidad de pendientes anteriores a comprobante: --> ", ex);
            }
        }
        return pendientes;
    }

    public boolean actualizarComprobante(modelos.Comprobante cant, modelos.Comprobante comp, String idCuenta) {
        con = Conectar.getConnect();
        PreparedStatement ps, ps1, ps2, ps3, ps4, ps5;
        try {

            java.sql.Date fechaActual = Funciones.utilDateaSqlDate(comp.getFechaActual());
            java.sql.Date fechaAnterior = comp.getFechaAnterior() == null ? null : Funciones.utilDateaSqlDate(comp.getFechaAnterior());
            java.sql.Date fechaVencimiento = Funciones.utilDateaSqlDate(comp.getFechaVencimiento());
            con.setAutoCommit(false);

            ps1 = con.prepareStatement("SET @usuario = ?");
            ps1.setString(1, conexion.InicioSesion.getUsuario());
            ps1.execute();

            ps4 = con.prepareStatement("SELECT p.id_pago, p.importe_total FROM pagos p, detalle_pago dp, pagos_por_comprobantes pc WHERE pc.id_comprobante = ? AND p.id_pago = dp.id_pago AND dp.iddetalle = pc.id_detalle AND p.numFactura LIKE '%C' AND p.anulado IS NULL");
            ps4.setInt(1, comp.getIdComprobante());
            ResultSet rs = ps4.executeQuery();
            if (rs.next()) {
                String idPago = rs.getString("p.id_pago");
                ps2 = con.prepareStatement("UPDATE cuentas SET saldoafavor = saldoafavor + ? WHERE id_cuenta = ?");
                ps2.setInt(1, rs.getInt("p.importe_total"));
                ps2.setString(2, idCuenta);
                ps2.executeUpdate();

                ps3 = con.prepareStatement("UPDATE pagos p SET p.anulado = true WHERE p.id_pago = ?");
                ps3.setString(1, idPago);
                ps3.executeUpdate();

                ps5 = con.prepareStatement("UPDATE medidores_por_cuentas mc SET mc.saldo_medidor = mc.saldo_medidor + ? WHERE mc.id_medidor = obtenerMedidorPorLectura(?)");
                ps5.setInt(1, rs.getInt("p.importe_total"));
                ps5.setInt(2, comp.getIdLectura());
                ps5.executeUpdate();

            }

            ps = con.prepareStatement("UPDATE comprobantes SET "
                    + "fecha_ant = ?, fecha_act = ?, lec_anterior = ?, lec_actual = ?, vencimiento = ?, IVA10 = ?, ERSSAN = ?, id_usuario = ?, id_lectura = ?, "
                    + "m3minimo = ?, m3excedente = ?, m3Total = ?, impMinimo = ?, impExcedente = ?, impTotal = ?, id_zona = ?, id_loteFac = ? "
                    + "WHERE id_comprobante = ?");
            ps.setDate(1, fechaAnterior);
            ps.setDate(2, fechaActual);
            ps.setInt(3, comp.getLecturaAnterior());
            ps.setInt(4, comp.getLecturaActual());
            ps.setDate(5, fechaVencimiento);
            ps.setInt(6, comp.getIVA10());
            ps.setInt(7, comp.getERSSAN());
            ps.setString(8, comp.getIdUsuario());
            ps.setInt(9, comp.getIdLectura());
            ps.setInt(10, comp.getM3Minimo());
            ps.setInt(11, comp.getM3Excedente());
            ps.setInt(12, comp.getM3Total());
            ps.setInt(13, comp.getImpMinimo());
            ps.setInt(14, comp.getImpExcedente());
            ps.setInt(15, comp.getImpTotal());
            ps.setInt(16, comp.getIdZona());
            ps.setInt(17, comp.getIdLoteFac());
            ps.setInt(18, comp.getIdComprobante());
            ps.executeUpdate();

            con.commit();
        } catch (SQLException ex) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar actualizar comprobante: ---> ", ex1);
            }
            Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar actualizar comprobante: ", ex);
            return false;
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar actualizar comprobante: --> ", ex);
            }
        }
        return true;
    }

    public static String obtenerEstado(String idComprobante) {
        String estado = "";
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT c.estado FROM comprobantes c WHERE c.id_comprobante = ?");
            ps.setString(1, idComprobante);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("c.estado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar obtener estado de comprobante: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar obtener estado de comprobante: --> ", ex);
            }
        }
        return estado;
    }

    public static boolean verificarEstado(Integer idComprobante) {
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT COUNT(pc.id_comprobante) AS existe FROM detalle_pago dp, pagos p, pagos_por_comprobantes pc, comprobantes c "
                    + "WHERE dp.tipo_concepto = 'COMPROBANTES' AND pc.id_comprobante = c.id_comprobante AND dp.iddetalle = pc.id_detalle AND dp.concepto NOT LIKE '%DESCONTADO DEL SALDO A FAVOR%' "
                    + "AND c.estado != 'PENDIENTE' AND c.estado != 'ELIMINADO' AND c.id_lectura = ? AND p.id_pago = dp.id_pago AND p.anulado IS NULL");
            ps.setInt(1, idComprobante);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("existe") > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar verificar estado de comprobante: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, "Error al intentar verificar estado de comprobante: --> ", ex);
            }
        }
        return false;
    }

    public static int BuscarIdPagoxComprobante(int id_comprabante) {
        con = Conectar.getConnect();
        int id_pago = 0;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT p.id_pago, p.importe_total FROM pagos p, detalle_pago dp, pagos_por_comprobantes pc WHERE pc.id_comprobante = ? AND p.id_pago = dp.id_pago AND dp.iddetalle = pc.id_detalle AND p.anulado IS NULL");
            ps.setInt(1, id_comprabante);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id_pago = rs.getInt("id_pago");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return id_pago;
    }

}
