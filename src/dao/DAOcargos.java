/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Cargos;

/**
 *
 * @author 2HDEV
 */
public class DAOcargos {

    public ArrayList<Cargos> ListarCargos() {
        Connection con = Conectar.getConnect();
        ArrayList<Cargos> cargos = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM cargos WHERE close_cargo=0");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cargos cargo = new Cargos();
                cargo.setId_cargo(rs.getInt("id_cargo"));
                cargo.setConcepto_cargo(rs.getString("concepto_cargo"));
                cargo.setMonto_cargo(rs.getInt("monto_cargo"));
                cargos.add(cargo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOcargos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOcargos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cargos;
    }

    public Cargos BuscarCargos(int id) {
        Connection con = Conectar.getConnect();
        Cargos cargo = new Cargos();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM cargos WHERE id_cargo=? and close_cargo=0");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cargo.setId_cargo(rs.getInt("id_cargo"));
                cargo.setConcepto_cargo(rs.getString("concepto_cargo"));
                cargo.setMonto_cargo(rs.getInt("monto_cargo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOcargos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOcargos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cargo;
    }

    public int AgregarCargo(Cargos cargo) {
        Connection con = Conectar.getConnect();
        int r = 0;
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO cargos(concepto_cargo, monto_cargo) VALUES (?, ?)");
            ps.setString(1, cargo.getConcepto_cargo());
            ps.setInt(2, cargo.getMonto_cargo());
            r = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOcargos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOcargos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return r;
    }

    public int ActualizarCargo(Cargos cargo) {
        Connection con = Conectar.getConnect();
        int r = 0;
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE cargos SET concepto_cargo = ?, monto_cargo = ? WHERE id_cargo=?");
            ps.setString(1, cargo.getConcepto_cargo());
            ps.setInt(2, cargo.getMonto_cargo());
            ps.setInt(3, cargo.getId_cargo());
            r = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOcargos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOcargos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return r;
    }

    public int CerrarCargo(int id_cargo) {
        Connection con = Conectar.getConnect();
        int r = 0;
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE cargos SET close_cargo = !close_cargo WHERE id_cargo=?");
            ps.setInt(1, id_cargo);
            r = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOcargos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOcargos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return r;
    }
}
