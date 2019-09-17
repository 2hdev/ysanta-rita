package clases.tablas;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class TablaLecturasXZonas extends AbstractTableModel {

    private JsonArray lotesLxz;
    private final String columnas[] = {
        "Nº Comprobante",
        "Fecha",
        "Cód. Usuario",
        "Nombre Usuario",
        "Nº Medidor",
        "Lectura",
        "Importe Total"
    };

    public TablaLecturasXZonas(JsonArray lotesLxz) {
        this.lotesLxz = lotesLxz;
    }

    public void setLecturasXZonas(JsonArray lotesLxz) {
        this.lotesLxz = lotesLxz;
        fireTableDataChanged();
    }

    boolean canEdit[] = new boolean[]{false, false, false, false, false, false, false};

    public String[] getColumnas() {
        return columnas;
    }

    @Override
    public boolean isCellEditable(int fila, int columna) {
        return canEdit[columna];
    }

    @Override
    public Class getColumnClass(int columna) {
        switch (columna) {
            case 0:
                return Integer.class;
            case 1:
                return java.util.Date.class;
            case 2:
                return Integer.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return Integer.class;
            case 6:
                return Integer.class;
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int columna) {
        return columnas[columna];
    }

    @Override
    public int getRowCount() {
        return lotesLxz.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        JsonObject obj = (JsonObject) lotesLxz.get(fila);
        switch (columna) {
            case 0:
                return obj.get("idComprobante").getAsInt();
            case 1: {
                try {
                    return utilidades.Estaticos.FORMATODMA.parse(obj.get("fecha").getAsString());
                } catch (ParseException ex) {
                    Logger.getLogger(TablaLecturasXZonas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case 2:
                return obj.get("idUsuario").getAsInt();
            case 3:
                return obj.get("nombreAp").getAsString();
            case 4:
                return obj.get("numeroMed").getAsString();
            case 5:
                return obj.get("lectura").getAsInt();
            case 6:
                return obj.get("impTotal").getAsInt();
            case 7:
                return obj.get("numLectura").getAsInt();
            case 8:
                return obj.get("actual").getAsString();
            case 9:
                return obj.get("estado").getAsString();
            case 10:
                return obj.get("idMedidor").getAsInt();
            default:
                return null;
        }
    }

}
