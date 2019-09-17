package clases.tablas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TablaCuentas extends AbstractTableModel{

    private List<modelos.Cuenta> cuentas;
    private final String[] columnas = {
            "Cuenta Nº",
            "Medidores",
        };
    
    public TablaCuentas(List<modelos.Cuenta> cuentas){
        this.cuentas = cuentas;
    }
    public TablaCuentas(){
        cuentas = new ArrayList<>();
    }
    
    public void limpiar(){
        cuentas.clear();
    }
    
    public void setCuentas(List<modelos.Cuenta> cuentas){
        this.cuentas = cuentas;
        fireTableDataChanged();
    }
    
    @Override
    public String getColumnName(int columna){
        return columnas[columna];
    }
    
    @Override
    public int getRowCount() {
        return cuentas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }
    
    public modelos.Cuenta getCuenta(int fila){
        return cuentas.get(fila);
    }
    
    @Override
    public Object getValueAt(int fila, int columna) {
        modelos.Cuenta cuenta = getCuenta(fila);
        switch(columna){
            case 0: return cuenta.getIdentificador();
            case 1: return cuenta.getMedidores()!=null?cuenta.getMedidores().toString().replace("[", "").replace("]", ""):"{SIN MEDIDORES}";
            case 2: return cuenta.getMedidores();
            default: return null;
        }
    }
    
    @Override
    public Class getColumnClass(int columna){
        switch (columna){
            case 0: return Integer.class;
            case 1: return Object.class;
            default: return null;
        }
    }

    boolean[] canEdit = new boolean [] {
        false, false
    };

    @Override
    public boolean isCellEditable(int fila, int columna){
       return canEdit [columna];
    }

}
