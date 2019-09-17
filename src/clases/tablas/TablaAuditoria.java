package clases.tablas;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TablaAuditoria extends AbstractTableModel{
    
    private final List<modelos.Auditoria> auds;
    private final String[] columnas = {"Código de Auditoría", "Ident. Auditado", "Tabla", "Detalle", "Acción", "Fecha/Hora", "Autor"};

    public TablaAuditoria(List<modelos.Auditoria> auds) {
        this.auds = auds;
    }
    
    boolean[] editable = new boolean []{false, false, false, false, false, false, false};
    
    @Override
    public boolean isCellEditable(int fila, int columna) {
        return editable[columna];
    }

    @Override
    public Class getColumnClass(int columna) {
        switch(columna){
            case 0: 
            case 1: return Integer.class;
            case 2: 
            case 3:
            case 4:
            case 5: 
            case 6: return String.class;
            default: return null;
        }
    }

    @Override
    public String getColumnName(int columna) {
        return columnas[columna];
    }    
    
    @Override
    public int getRowCount() {
        return auds.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }
    
    public modelos.Auditoria getAuditoria(int fila){
        return auds.get(fila);
    }
    
    @Override
    public Object getValueAt(int fila, int columna) {
        modelos.Auditoria aud = auds.get(fila);
        switch (columna){
            case 0: return aud.getIdentificador();
            case 1: return aud.getIdAuditado();
            case 2: return aud.getTablaAuditada();
            case 3: return aud.getDetalleAuditado();
            case 4: return aud.getAccion();
            case 5: return aud.getFechaHora();
            case 6: return aud.getAutor();
            default: return null;
        }
    }

}

