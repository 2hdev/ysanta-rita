package clases.tablas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TablaLecturas extends AbstractTableModel{
    private final List<modelos.Lectura> lecturas;
    private final String[] columnas = {
        "Nº Lote",
        "Descripción",
        "Fecha",
        "Fecha de Vencimiento"
    };
    public TablaLecturas(){
        lecturas = new ArrayList<>();
    }

    public TablaLecturas(List<modelos.Lectura> lecturas){
        this.lecturas = lecturas;
    }

    @Override
    public int getRowCount() {
        return lecturas.size();
    }

    @Override
    public String getColumnName(int column){
        return columnas[column];
    }

    @Override
    public int getColumnCount() {
       return columnas.length;
    }

    public modelos.Lectura getLectura(int row){
        return lecturas.get(row);
    }

    @Override
    public Class getColumnClass(int column){
        switch (column){
            case 0: return Integer.class;
            case 1: return String.class;
            default: return java.util.Date.class;
        }
    }

    boolean[] canEdit = new boolean [] {
        false, false, false, false
    };

    @Override
    public boolean isCellEditable(int row, int column){
       return canEdit [column];
    }

    @Override
    public Object getValueAt(int row, int column){
        modelos.Lectura lectura = getLectura(row);

        switch (column){
            case 0: return lectura.getIdentificador();
            case 1: return lectura.getDescripcion();
            case 2: return lectura.getFechaLectura();
            case 3: return lectura.getFechaVencimiento();
            default: return null;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int column){
        modelos.Lectura lectura = getLectura(row);
        switch (column){
            case 0: lectura.setIdentificador((Integer)value); break;
            case 1: lectura.setDescripcion((String)value); break;
            case 2: lectura.setFechaLectura((java.util.Date)value); break;
            case 3: lectura.setFechaVencimiento((java.util.Date)value); break;
        }
    }
}  
