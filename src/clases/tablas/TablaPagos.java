package clases.tablas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TablaPagos extends AbstractTableModel {

    private List<modelos.Pago> pagos;
    private final String[] columnas = {
        "Nº Pago",
        "Factura/Recibo Nº",
        "Fecha de Pago",
        "Cód. Usuario",
        "Usuario",
        "Importe",
        "Pagado"
    };

    public TablaPagos(List<modelos.Pago> pagos) {
        this.pagos = pagos;
    }

    public TablaPagos() {
        pagos = new ArrayList<>();
    }

    public String[] getColumnas() {
        return columnas;
    }

    public void limpiar() {
        pagos.clear();
    }

    public void setPagos(List<modelos.Pago> pagos) {
        this.pagos = pagos;
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int columna) {
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

    public modelos.Pago getPago(int fila) {
        return pagos.get(fila);
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        modelos.Pago pago = getPago(fila);
        switch (columna) {
            case 0:
                return pago.getIdentificador();
            case 1:
                return pago.getNumFactura();
            case 2:
                return pago.getFechaPago();
            case 3:
                return pago.getIdUsuario();
            case 4:
                return pago.getNombre();
            case 5:
                return pago.getTotal();
            case 6:
                return pago.getEstado_pago();
            default:
                return null;
        }
    }

    @Override
    public Class getColumnClass(int columna) {
        switch (columna) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return java.util.Date.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return Integer.class;
            case 6:
                return Boolean.class;
            default:
                return null;
        }
    }

    boolean[] canEdit = new boolean[]{
        false, false, false, false, false, false, true//, false
    };

    @Override
    public boolean isCellEditable(int fila, int columna) {
        return canEdit[columna];
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        modelos.Pago pago = getPago(row);
        dao.Pagos.ActualizarEstadoPago(Integer.valueOf(getValueAt(row, 0).toString()), (Boolean) value);
        pago.setEstado_pago((Boolean) value);
        fireTableCellUpdated(row, col);
    }
}
