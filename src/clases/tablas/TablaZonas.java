package clases.tablas;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TablaZonas extends AbstractTableModel{
    
    private final List<modelos.Zona> zonas;
    private final String[] columnas = {"Código de Zona", "Zona", "Descripción"};

    public TablaZonas(List<modelos.Zona> zonas) {
        this.zonas = zonas;
    }
    
    boolean[] editable = new boolean []{false, false, false};
    
    @Override
    public boolean isCellEditable(int fila, int columna) {
        return editable[columna];
    }

    @Override
    public Class getColumnClass(int columna) {
        switch(columna){
            case 0: return Integer.class;
            case 1: 
            case 2: return String.class;
            default: return null;
        }
    }

    @Override
    public String getColumnName(int columna) {
        return columnas[columna];
    }    
    
    @Override
    public int getRowCount() {
        return zonas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }
    
    public modelos.Zona getZona(int fila){
        return zonas.get(fila);
    }
    
    @Override
    public Object getValueAt(int fila, int columna) {
        modelos.Zona zona = zonas.get(fila);
        switch (columna){
            case 0: return zona.getIdentificador();
            case 1: return zona.getZona();
            case 2: return zona.getDescripcion();
            default: return null;
        }
    }

}
