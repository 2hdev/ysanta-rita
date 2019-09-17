package clases.tablas;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelos.LoteComprobantes;

public class TablaLotesLecturas extends AbstractTableModel{
    private final List<modelos.LoteComprobantes> lotesComp;
    private final String columnas[] = {
        "Nº Lote",
        "Descripción",
        "Año",
        "Mes",
        "Fecha Vencimiento",
    };

    public TablaLotesLecturas(List<LoteComprobantes> lotesComp) {
        this.lotesComp = lotesComp;
    }

    @Override
    public int getRowCount() {
        return lotesComp.size();
    }
    
    @Override
    public String getColumnName(int columna){
        return columnas[columna];
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }
    
    public modelos.LoteComprobantes getLoteComprobante(int fila){
        return lotesComp.get(fila);
    }
    
    @Override
    public Object getValueAt(int fila, int columna) {
        modelos.LoteComprobantes lc = getLoteComprobante(fila);
        switch(columna){
            case 0: return lc.getIdentificador();
            case 1: return lc.getDescripcion();
            case 2: return lc.getAnhoLote();
            case 3: return lc.getMesLote();
            case 4: return lc.getFechaVencimiento();
            default: return null;
        }
    }
    
    @Override
    public Class getColumnClass(int columna){
        switch (columna){
            case 0: return Integer.class;
            case 1: return String.class;
            case 2: return Integer.class;
            case 3: return String.class;
            case 4: return java.util.Date.class;
            default: return null;
        }
    }
    
    boolean canEdit[] = new boolean[]{false, false, false, false, false};
    
    @Override
    public boolean isCellEditable(int fila, int columna){
        return canEdit[columna];
    }
}
