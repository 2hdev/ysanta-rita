package clases.tablas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TablaLotePagos extends AbstractTableModel{
    private List<modelos.LotePagos> pagos;
    private final String[] columnas = {
            "Nº Lote",
            "Fecha de Lote",
            "Descripción",
            "Mes",
            "Año",
            "Total"
        };
    
    public TablaLotePagos(List<modelos.LotePagos> pagos){
        this.pagos = pagos;
    }
    public TablaLotePagos(){
        pagos = new ArrayList<>();
    }
    
    public void limpiar(){
        pagos.clear();
    }
    
    public void setPagos(List<modelos.LotePagos> pagos){
        this.pagos = pagos;
        fireTableDataChanged();
    }
    
    @Override
    public String getColumnName(int columna){
        return columnas[columna];
    }
    
    @Override
    public int getRowCount() {
        return pagos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }
    
    public modelos.LotePagos getPago(int fila){
        return pagos.get(fila);
    }
    
    @Override
    public Object getValueAt(int fila, int columna) {
        modelos.LotePagos pago = getPago(fila);
        switch(columna){
            case 0: return pago.getIdentificador();
            case 1: return pago.getFechaLote();
            case 2: return pago.getDescripcion();
            case 3: return pago.getMes();
            case 4: return pago.getAnho() == null ? null : Integer.parseInt(pago.getAnho());
            case 5: return pago.getTotal();
            default: return null;
        }
    }
    
    @Override
    public Class getColumnClass(int columna){
        switch (columna){
            case 0: return String.class;
            case 1: return java.util.Date.class;
            case 2: return String.class;
            case 3: return String.class;
            case 4: return Integer.class;
            case 5: return Integer.class;
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
