package utilidades;

import java.awt.Component;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class Renderers{
    
    public static TableCellRenderer rendererFecha(){
        TableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {  
            if(value instanceof java.util.Date) {
                    value = utilidades.Estaticos.FORMATODMA.format(value);
                    setHorizontalAlignment(JLabel.CENTER);
                }
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        };
        return tableCellRenderer;
    }
    
    public static TableCellRenderer rendererCentro(){
        TableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if(value instanceof String) {
                    setHorizontalAlignment(JLabel.CENTER);
                }
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        };
        return tableCellRenderer;
    }
    
    public static TableCellRenderer rendererDerecha(){
        TableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                setHorizontalAlignment(JLabel.RIGHT);
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        };
        return tableCellRenderer;
    }
    
    public static TableCellRenderer rendererNumeros(){
        TableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMANY);
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if(value instanceof Integer) {
                value = nf.format(value);
                setHorizontalAlignment(JLabel.RIGHT);
            }
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        };
        return tableCellRenderer;
    }
    
    public static TableCellRenderer rendererCerrado(int columna){
        java.awt.Color color = new java.awt.Color(102, 255, 102).brighter();
        TableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column){        
            int modelRow = table.convertRowIndexToModel(row);
             Component renderer = super.getTableCellRendererComponent(
                table, value, selected, focused, row, column);
            Boolean cerrado =  (Boolean)table.getModel().getValueAt(modelRow, columna);
            if(cerrado != null && cerrado){
                renderer.setBackground(color);
            }
            else{
                renderer.setBackground(null);
            }
            return renderer;
            //return super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            }
        };
        return tableCellRenderer;
    }
}
