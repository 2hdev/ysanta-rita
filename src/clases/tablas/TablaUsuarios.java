package clases.tablas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TablaUsuarios extends AbstractTableModel{
    
    static Connection con;
    static Statement sent;
    static ResultSet rs;
    
    private List<modelos.UsuarioReporte> usuarios;
    private final String[] columnas = {
        "Código", 
        "Nombre y Apellido", 
        "Nº Documento", 
        "Cuenta Actual",
        "Saldo a Favor",
        "Zona"
    };
    
    public TablaUsuarios(List<modelos.UsuarioReporte> usuarios){
        this.usuarios = usuarios;
    }
    public TablaUsuarios(){
        usuarios = new ArrayList<>();
    }
    
    public String[] getColumnas(){
        return columnas;
    }
    
    @Override
    public String getColumnName(int columna){
        return columnas[columna];
    }
    
    public void limpiar(){
        usuarios.clear();
    }
    
    public void setUsuarios(List<modelos.UsuarioReporte> usuarios){
        this.usuarios = usuarios;
        fireTableDataChanged();
    }
    
    public void setUsuario(modelos.UsuarioReporte usuario){
        usuarios.add(usuario);
        fireTableRowsInserted(usuarios.size() - 1, usuarios.size() - 1);
    }
    
    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }
    
    public modelos.UsuarioReporte getUsuario(int fila){
        return usuarios.get(fila);
    }
    
    @Override
    public Object getValueAt(int fila, int columna) {
        modelos.UsuarioReporte usuario = getUsuario(fila);
        switch(columna){
            case 0: return usuario.getCodigo();
            case 1: return usuario.getNombre();
            case 2: return usuario.getNumDocumento();
            case 3: return usuario.getCuentaActual();
            case 4: return usuario.getSaldoAFavor();
            case 5: return usuario.getZona();
            default: return null;
        }
    }
    
    @Override
    public Class getColumnClass(int columna){
        switch (columna){
            case 0: return String.class;
            case 1: return String.class;
            case 2: return String.class;
            case 3: return Integer.class;
            case 4: return Integer.class;
            case 5: return String.class;
            default: return null;
        }
    }

    boolean[] canEdit = new boolean [] {
        false, false, false, false, false, false
    };

    @Override
    public boolean isCellEditable(int fila, int columna){
       return canEdit [columna];
    }
    
}
