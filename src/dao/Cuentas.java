package dao;

import conexion.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

public class Cuentas {

    static Connection con;

    public static boolean existeCuenta(String idCuenta) {
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT COUNT(id_cuenta) as existe FROM cuentas WHERE id_cuenta = ?");
            ps.setString(1, idCuenta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getInt("existe") > 0) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al buscar cuenta: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al buscar cuenta: --> ", ex);
            }
        }
        return false;
    }

    public static Integer obtenerSaldoConexion(String idCuenta) {
        Integer saldo = 0;
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT saldoderechoconex FROM cuentas WHERE id_cuenta = ?");
            ps.setString(1, idCuenta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                saldo = rs.getInt("saldoderechoconex");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar obtener saldo de derecho de conexión: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar obtener saldo de derecho de conexión: --> ", ex);
            }
        }
        return saldo;
    }

    public boolean actualizarCuenta(java.util.Map<String, ?> valores, Integer idCuenta) {
        con = Conectar.getConnect();
        PreparedStatement ps, ps1;
        try {
            con.setAutoCommit(false);
            if (valores.size() > 0) {
                ps1 = con.prepareStatement("SET @usuario = ?");
                ps1.setString(1, conexion.InicioSesion.getUsuario());
                ps1.execute();

                String sentenciae = String.format("UPDATE cuentas SET %s WHERE id_cuenta=?", StringUtils.join(valores.keySet(), ","));
                ps = con.prepareStatement(sentenciae);
                int p = 1;
                for (String key : valores.keySet()) {
                    ps.setString(p++, valores.get(key).toString());
                }
                ps.setInt(p++, idCuenta);
                ps.executeUpdate();
            }
            con.commit();
        } catch (SQLException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar actualizar cuenta: ", ex);
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar actualizar cuenta: ---> ", ex1);
            }
            return false;
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar actualizar cuenta: ", ex);
            }
        }
        return true;
    }

    public static boolean actualizarCuentaDC(Integer idCuenta, Integer monto) {
        con = Conectar.getConnect();
        try {
            con.setAutoCommit(false);

            PreparedStatement ps1 = con.prepareStatement("SET @usuario = ?");
            ps1.setString(1, conexion.InicioSesion.getUsuario());
            ps1.execute();

            PreparedStatement ps = con.prepareStatement("UPDATE cuentas SET saldoderechoconex = saldoderechoconex - ? WHERE id_cuenta = ?");
            ps.setInt(1, monto);
            ps.setInt(2, idCuenta);
            ps.executeUpdate();

            con.commit();
        } catch (SQLException ex) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar actualizar derecho de conexión: ---> ", ex1);
            }
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar actualizar derecho de conexión: ", ex);
            return false;
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar actualizar derecho de conexión: --> ", ex);
            }
        }
        return true;
    }

    public static boolean actualizarCuentaComp(Integer idCuenta, Integer monto) {
        con = Conectar.getConnect();
        try {
            con.setAutoCommit(false);

            PreparedStatement ps1 = con.prepareStatement("SET @usuario = ?");
            ps1.setString(1, conexion.InicioSesion.getUsuario());
            ps1.execute();

            PreparedStatement ps = con.prepareStatement("UPDATE cuentas SET saldocomprobantes = saldocomprobantes - ? WHERE id_cuenta = ?");
            ps.setInt(1, monto);
            ps.setInt(2, idCuenta);
            ps.executeUpdate();

            con.commit();
        } catch (SQLException ex) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar actualizar saldo de comprobantes: ---> ", ex1);
            }
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar actualizar saldo de comprobantes: ", ex);
            return false;
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar actualizar saldo de comprobantes: --> ", ex);
            }
        }
        return true;
    }

    public static boolean actualizarSaldoAFavor(Integer idCuenta, Integer monto, boolean sube) {
        con = Conectar.getConnect();
        try {
            con.setAutoCommit(false);

            PreparedStatement ps1 = con.prepareStatement("SET @usuario = ?");
            ps1.setString(1, conexion.InicioSesion.getUsuario());
            ps1.execute();

            PreparedStatement ps = con.prepareStatement("UPDATE cuentas SET saldoafavor = saldoafavor " + (sube ? "+" : "-") + " ? WHERE id_cuenta = ?");
            ps.setInt(1, monto);
            ps.setInt(2, idCuenta);
            ps.executeUpdate();

            con.commit();
        } catch (SQLException ex) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar actualizar saldo a favor: ---> ", ex1);
            }
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar actualizar saldo a favor: ", ex);
            return false;
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar actualizar saldo a favor: --> ", ex);
            }
        }
        return true;
    }

    public List<modelos.Cuenta> cuentasConPendientes(int idUsuario) {
        List<modelos.Cuenta> cuentas = new ArrayList<>();
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT DISTINCT c.id_cuenta, c.saldoderechoconex, c.saldocomprobantes "
                    + "FROM cuentas c WHERE c.id_usuario = ? AND (c.saldoderechoconex > 0 OR c.saldocomprobantes > 0)");
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelos.Cuenta cuenta = new modelos.Cuenta();
                cuenta.setIdentificador(rs.getInt("c.id_cuenta"));
                cuenta.setSaldoDC(rs.getInt("c.saldoderechoconex"));
                cuenta.setSaldoComprobantes(rs.getInt("c.saldocomprobantes"));
                cuentas.add(cuenta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar buscar cuentas pendientes de usuario: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar buscar cuentas pendientes de usuario: --> ", ex);
            }
        }
        return cuentas;
    }

    public List<modelos.Cuenta> cuentasSaldo(int idUsuario) {
        List<modelos.Cuenta> cuentas = new ArrayList<>();
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT DISTINCT c.id_cuenta, c.saldoafavor "
                    + "FROM medidores m, cuentas c, medidores_por_cuentas mc WHERE c.id_usuario = ? AND mc.id_medidor = m.id_medidor AND c.saldocomprobantes <= 0");
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelos.Cuenta cuenta = new modelos.Cuenta();
                cuenta.setIdentificador(rs.getInt("c.id_cuenta"));
                cuenta.setSaldoAFavor(rs.getInt("c.saldoafavor"));
                int pendientes = dao.Comprobante.contarComprobantesPendientes(cuenta.getIdentificador().toString());
                if (pendientes == 0) {
                    cuentas.add(cuenta);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar obtener cuentas con saldo a favor de usuario: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar obtener cuentas con saldo a favor de usuario: ", ex);
            }
        }
        return cuentas;
    }

    public static Integer medidorSaldo(Integer idMedidor) {
        Integer saldo = 0;
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT c.saldoafavor FROM cuentas c, medidores_por_cuentas mc WHERE c.id_cuenta = mc.id_cuenta AND mc.id_medidor = ?");
            ps.setInt(1, idMedidor);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                saldo = rs.getInt("c.saldoafavor");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar obtener saldo de medidor: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar obtener saldo de medidor: --> ", ex);
            }
        }
        return saldo;
    }

    public static String getCuenta(Integer idMedidor, String idUsuario) {
        String cuenta = null;
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT mc.id_cuenta FROM cuentas c, medidores_por_cuentas mc WHERE c.id_usuario = ? AND mc.id_medidor = ?");
            ps.setString(1, idUsuario);
            ps.setInt(2, idMedidor);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("mc.id_cuenta");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar obtener cuenta: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar obtener saldo de medidor: --> ", ex);
            }
        }
        return cuenta;
    }

    public static Map<Integer, String> obtenerCuentas() {
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT c.id_cuenta, CONCAT_WS(\" \", u.nombre_usu, u.apellido_usu) AS noap, u.num_doc_usu, "
                    + "IF((SELECT COUNT(mc.id_cuenta) AS cuenta FROM medidores_por_cuentas mc WHERE mc.id_cuenta = c.id_cuenta) > 0, true, false) AS existe "
                    + "FROM usuarios u, cuentas c WHERE c.id_usuario = u.id_usuario ORDER BY c.id_cuenta");
            ResultSet rs = ps.executeQuery();
            rs.last();
            int numRows = rs.getRow();
            rs.beforeFirst();
            if (numRows == 0) {
                return null;
            } else {
                Map<Integer, String> mapa = new HashMap();
                while (rs.next()) {
                    mapa.put(rs.getInt("c.id_cuenta"), String.join("|", rs.getString("noap"), rs.getString("u.num_doc_usu")).concat(",") + rs.getString("existe"));
                }
                return mapa;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar obtener cuentas: ", ex);
            return null;
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar obtener cuentas: --> ", ex);
            }
        }
    }

    public static List<modelos.Cuenta> obtenerCuentasYMedidores(int idUsuario) {
        List<modelos.Cuenta> cuentas = new ArrayList<>();
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT c.id_cuenta, m.numero_med "
                    + "FROM cuentas c, medidores_por_cuentas mc, medidores m "
                    + "WHERE mc.id_cuenta = c.id_cuenta AND m.id_medidor = mc.id_medidor AND c.id_usuario = ?");
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (cuentas.size() > 0) {
                    if (cuentas.get(cuentas.size() - 1).getIdentificador().equals(rs.getInt("c.id_cuenta"))) {
                        modelos.Medidor med = new modelos.Medidor(rs.getString("m.numero_med"));
                        cuentas.get(cuentas.size() - 1).getMedidores().add(med);
                    } else {
                        modelos.Cuenta cuenta = new modelos.Cuenta();
                        cuenta.setIdentificador(rs.getInt("c.id_cuenta"));
                        List<modelos.Medidor> medidores = new ArrayList();
                        modelos.Medidor med = new modelos.Medidor(rs.getString("m.numero_med"));
                        medidores.add(med);
                        cuenta.setMedidores(medidores);
                        cuentas.add(cuenta);
                    }
                } else {
                    modelos.Cuenta cuenta = new modelos.Cuenta();
                    cuenta.setIdentificador(rs.getInt("c.id_cuenta"));
                    List<modelos.Medidor> medidores = new ArrayList();
                    modelos.Medidor med = new modelos.Medidor(rs.getString("m.numero_med"));
                    medidores.add(med);
                    cuenta.setMedidores(medidores);
                    cuentas.add(cuenta);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar obtener cuentas y medidores: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar obtener cuentas y medidores: --> ", ex);
            }
        }
        return cuentas;
    }

    public static List<modelos.Cuenta> obtenerCuentasYMedidoresPendientes(Integer idUsuario) {
        List<modelos.Cuenta> cuentas = new ArrayList<>();
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT c.id_cuenta, m.numero_med, m.id_medidor "
                    + "FROM cuentas c, medidores_por_cuentas mc, medidores m "
                    + "WHERE mc.id_cuenta = c.id_cuenta AND m.id_medidor = mc.id_medidor AND c.id_usuario = ? AND mc.saldo_medidor > 0");
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (cuentas.size() > 0) {
                    if (cuentas.get(cuentas.size() - 1).getIdentificador().equals(rs.getInt("c.id_cuenta"))) {
                        modelos.Medidor med = new modelos.Medidor(rs.getString("m.numero_med"));
                        med.setIdentificador(rs.getInt("m.id_medidor"));
                        cuentas.get(cuentas.size() - 1).getMedidores().add(med);
                    } else {
                        modelos.Cuenta cuenta = new modelos.Cuenta();
                        cuenta.setIdentificador(rs.getInt("c.id_cuenta"));
                        List<modelos.Medidor> medidores = new ArrayList();
                        modelos.Medidor med = new modelos.Medidor(rs.getString("m.numero_med"));
                        med.setIdentificador(rs.getInt("m.id_medidor"));
                        medidores.add(med);
                        cuenta.setMedidores(medidores);
                        cuentas.add(cuenta);
                    }
                } else {
                    modelos.Cuenta cuenta = new modelos.Cuenta();
                    cuenta.setIdentificador(rs.getInt("c.id_cuenta"));
                    List<modelos.Medidor> medidores = new ArrayList();
                    modelos.Medidor med = new modelos.Medidor(rs.getString("m.numero_med"));
                    med.setIdentificador(rs.getInt("m.id_medidor"));
                    medidores.add(med);
                    cuenta.setMedidores(medidores);
                    cuentas.add(cuenta);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar obtener cuentas/medidores pendientes de pago: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar obtener cuentas/medidores pendientes de pago: --> ", ex);
            }
        }
        return cuentas;
    }

    public static List<modelos.Cuenta> obtenerCuentasYMedidores() {
        List<modelos.Cuenta> cuentas = new ArrayList<>();
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id_cuenta, id_usuario, obtenerMedidoresPorCuenta(id_cuenta) as medidores FROM cuentas ORDER BY id_cuenta");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelos.Cuenta cuenta = new modelos.Cuenta();
                cuenta.setIdentificador(rs.getInt("id_cuenta"));
                if (rs.getString("medidores") != null) {
                    List<String> med = Arrays.asList(rs.getString("medidores").split(","));
                    List<modelos.Medidor> medidores = new ArrayList<>();
                    med.forEach((numMedidor) -> {
                        medidores.add(new modelos.Medidor(numMedidor));
                    });
                    cuenta.setMedidores(medidores);
                } else {
                    cuenta.setMedidores(null);
                }
                cuenta.setUsuario(rs.getInt("id_usuario"));
                cuentas.add(cuenta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar obtener cuentas y medidores: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar obtener cuentas y medidores: --> ", ex);
            }
        }
        return cuentas;
    }

    public static Integer obtenerSaldoCuenta(int idCuenta) {
        Integer total = 0;
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT SUM(mc.saldo_medidor) AS total FROM medidores_por_cuentas mc WHERE mc.id_cuenta = ?");
            ps.setInt(1, idCuenta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar obtener saldo de cuenta: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar obtener saldo de cuenta: --> ", ex);
            }
        }
        return total;
    }

    public static modelos.Cuenta obtenerSaldos(modelos.Cuenta cuenta) {
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT c.saldoderechoconex, c.saldocomprobantes, c.saldoafavor FROM cuentas c WHERE c.id_cuenta = ?");
            ps.setInt(1, cuenta.getIdentificador());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cuenta.setSaldoAFavor(rs.getInt("c.saldoafavor"));
                cuenta.setSaldoComprobantes(rs.getInt("c.saldocomprobantes"));
                cuenta.setSaldoDC(rs.getInt("c.saldoderechoconex"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar obtener saldos de cuenta: ", ex);
            cuenta.setSaldoAFavor(0);
            cuenta.setSaldoComprobantes(0);
            cuenta.setSaldoDC(0);
            return cuenta;
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar obtener saldos de cuenta: --> ", ex);
            }
        }
        return cuenta;
    }

    public static List<modelos.Cuenta> obtenerCuentasDeUsuario(int idUsuario) {
        List<modelos.Cuenta> cuentas = new ArrayList<>();
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT cuentas.id_cuenta FROM cuentas, medidores_por_cuentas, medidores WHERE cuentas.id_usuario = ? AND medidores_por_cuentas.id_cuenta=cuentas.id_cuenta AND medidores.id_medidor=medidores_por_cuentas.id_medidor AND medidores.estado_med='ACTIVO'");
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelos.Cuenta cuenta = new modelos.Cuenta();
                cuenta.setIdentificador(rs.getInt("id_cuenta"));
                cuentas.add(cuenta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar obtener cuentas de usuario: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar obtener cuentas de usuario: --> ", ex);
            }
        }
        return cuentas;
    }

    public boolean insertarCuenta(modelos.Cuenta cuenta) {
        con = Conectar.getConnect();
        PreparedStatement ps;
        try {
            con.setAutoCommit(false);
            ps = con.prepareStatement("INSERT INTO cuentas(saldoderechoconex, saldocomprobantes, id_usuario, saldoafavor) VALUES(?,?,?,?)");
            ps.setInt(1, cuenta.getSaldoDC());
            ps.setInt(2, cuenta.getSaldoComprobantes());
            ps.setInt(3, cuenta.getUsuario());
            ps.setInt(4, cuenta.getSaldoAFavor());
            ps.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar insertar cuenta: ---> ", ex1);
            }
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar insertar cuenta: ", ex);
            return false;
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar insertar cuenta: --> ", ex);
            }
        }
        return true;
    }

    public static boolean tieneMedidoresLaCuenta(String idCuenta) {
        boolean tiene = false;
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT IF((SELECT COUNT(mc.id_cuenta) AS cuenta FROM medidores_por_cuentas mc "
                    + "WHERE mc.id_cuenta = c.id_cuenta) > 0, true, false) AS existe FROM cuentas c WHERE c.id_cuenta = ?");
            ps.setString(1, idCuenta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return tiene = rs.getBoolean("existe");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar obtener medidores vinculados a cuenta: ", ex);
            return false;
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar obtener medidores vinculados a cuenta: --> ", ex);
            }
        }
        return tiene;
    }

    public boolean verificarPago(String concepto, Integer idCuenta) {
        con = Conectar.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT COUNT(dp.iddetalle) AS cuenta FROM detalle_pago dp, pagos p, pagos_por_cuentas pc, cuentas c "
                    + "WHERE c.id_cuenta = pc.id_cuenta AND p.id_pago = dp.id_pago AND dp.iddetalle = pc.id_detalle "
                    + "AND p.anulado IS NULL AND c.id_cuenta = ? AND dp.tipo_concepto = ?");
            ps.setInt(1, idCuenta);
            ps.setString(2, concepto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("cuenta") > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar verificar pago: ", ex);
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, "Error al intentar verificiar pago: --> ", ex);
            }
        }
        return false;
    }
}
