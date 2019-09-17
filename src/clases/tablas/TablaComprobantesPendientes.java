package clases.tablas;

import java.util.List;
import modelos.Comprobante;
import javax.swing.table.AbstractTableModel;

public class TablaComprobantesPendientes extends AbstractTableModel{
    private List<Comprobante> compPendientes;
    private final String[] columnas = {
        "Nº Comprobante",
        "Monto Total",
        "Monto Pagado"
    };
    public TablaComprobantesPendientes(){
    }

    public TablaComprobantesPendientes(List<Comprobante> compPendientes){
        this.compPendientes = compPendientes;
    }

    public void setCompPendientes(List<Comprobante> compPendientes){
        this.compPendientes = compPendientes;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return compPendientes.size();
    }

    @Override
    public String getColumnName(int columna){
        return columnas[columna];
    }

    @Override
    public int getColumnCount() {
       return columnas.length;
    }

    public Comprobante getComprobantePendiente(int fila){
        return compPendientes.get(fila);
    }

    @Override
    public Class getColumnClass(int column){
        switch (column){
            case 0: return String.class;
            case 1: return String.class;
            case 2: return Integer.class;
            case 3: return Integer.class;
            default: return null;
        }
    }

    boolean[] canEdit = new boolean [] {
        false, false, false
    };

    @Override
    public boolean isCellEditable(int row, int column){
       return canEdit [column];
    }

    @Override
    public Object getValueAt(int fila, int columna){
        Comprobante comprobante = getComprobantePendiente(fila);
        switch(columna){
            case 0: return comprobante.getIdComprobante().toString();
            case 1: return comprobante.getImpTotal();
            case 2: return comprobante.getImpMinimo(); //monto ya pagado
            case 3: return comprobante.getFechaVencimiento();
            case 4: return comprobante.getERSSAN();
            default: return null;
        }
    }
}
