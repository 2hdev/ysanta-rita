package utilidades;

import interfaces.Cargos;
import java.awt.Color;
import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URISyntaxException;
import java.text.NumberFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import org.apache.commons.io.FilenameUtils;

public class Funciones {

    public void maximizar(JFrame ventana) {
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ventana.setMaximizedBounds(env.getMaximumWindowBounds());
    }

    public void restaurar(JFrame ventana) {
        ventana.setExtendedState(JFrame.NORMAL);
    }

    public void minimizar(JFrame ventana) {
        ventana.setExtendedState(JFrame.ICONIFIED);
    }

    public void agregarPlaceHolder(JComponent campo, String texto) {
        TextPrompt placeholder = new TextPrompt(texto, (JTextField) campo);
        placeholder.setForeground(Color.LIGHT_GRAY);
    }

    public static void seleccionar(JToggleButton boton, JPanel menu) {
        Component[] components = menu.getComponents();
        for (Component c : components) {
            if (c instanceof JToggleButton) {
                JToggleButton campo = (JToggleButton) c;
                campo.setSelected(campo.equals(boton));
            }
        }
    }

    public static void cambiarColor(JPanel panel, JPanel menu) {
        Component[] components = menu.getComponents();
        for (Component c : components) {
            if (c instanceof JPanel) {
                JPanel campo = (JPanel) c;
                if (campo.getName().startsWith("btn")) {
                    campo.setBackground(new Color(118, 173, 215));
                }
                if (campo.getName().equals(panel.getName())) {
                    panel.setBackground(new Color(149, 196, 240));
                }
            }
        }
    }

    public static void cambiarColorLateral(JPanel lat, JPanel menu) {
        Component[] components = menu.getComponents();
        for (Component c : components) {
            if (c instanceof JPanel) {
                JPanel campo = (JPanel) c;
                if (campo.getName().startsWith("lateral")) {
                    campo.setBackground(new Color(118, 173, 215));
                }
                if (campo.getName().equals(lat.getName())) {
                    lat.setBackground(new Color(255, 255, 255));
                }
            }
        }
    }

    public static boolean ventanaCerrada(JDesktopPane pane, Object obj) {
        JInternalFrame[] activos = pane.getAllFrames();
        boolean cerrado = true;
        int i = 0;
        while (i < activos.length && cerrado) {
            if (activos[i] == obj) {
                cerrado = false;
            }
            i++;
        }
        return cerrado;
    }

    public static void centrar(JInternalFrame frame, JDesktopPane panel) {
        JDesktopPane panelb = (JDesktopPane) panel;
        int x = (panelb.getWidth() / 2 - frame.getWidth() / 2);
        int y = (panelb.getHeight() / 2 - frame.getHeight() / 2);
        frame.setLocation(x, y);
        panelb.add(frame);
        frame.show();
    }

    public static void maximizar(JInternalFrame frame, JDesktopPane panel) {
        JDesktopPane panelb = (JDesktopPane) panel;
        frame.setLocation(0, 45);
        frame.setSize(panel.getWidth(), panel.getHeight() - 45);
        panelb.add(frame);
        frame.show();
    }

    public int calcularRUC(String p_numero) {
        int v_total, v_resto, k, v_numero_aux, v_digit;
        String v_numero_al = "";
        for (int i = 0; i < p_numero.length(); i++) {
            char c = p_numero.charAt(i);
            if (Character.isDigit(c)) {
                v_numero_al += c;
            } else {
                v_numero_al += (int) c;
            }
        }
        k = 2;
        v_total = 0;
        for (int i = v_numero_al.length() - 1; i >= 0; i--) {
            k = k > 11 ? 2 : k; //el 11 es el p_basemax
            v_numero_aux = v_numero_al.charAt(i) - 48;
            v_total += v_numero_aux * k++;
        }
        v_resto = v_total % 11;
        v_digit = v_resto > 1 ? 11 - v_resto : 0;
        return v_digit;
    }

    public void habilitarCampos(JPanel panel) {
        Component[] components = panel.getComponents();
        for (Component c : components) {
            if (c instanceof JTextField || c instanceof JComboBox || c instanceof JTextArea) {
                c.setEnabled(true);
            }
        }
    }

    public void habilitarCampos(java.util.List<JComponent> componentes) {
        componentes.stream().filter((c) -> (c instanceof JTextField || c instanceof JComboBox || c instanceof JTextArea)).forEachOrdered((c) -> {
            c.setEnabled(true);
        });
    }

    public void inhabilitarCampos(JPanel panel) {
        Component[] components = panel.getComponents();
        for (Component c : components) {
            if (c instanceof JTextField) {
                c.setEnabled(false);
            }
        }
    }

    public void convertirAMayusculas(java.awt.event.KeyEvent evt) {
        evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
    }

    public void convertirAMinusculas(java.awt.event.KeyEvent evt) {
        if (!Validaciones.Espacio(evt.getKeyChar())) {
            evt.consume();
        }
        evt.setKeyChar(Character.toLowerCase(evt.getKeyChar()));
    }

    public boolean recorrerYValidar(JPanel panel) {
        boolean valido = true;
        Component[] components = panel.getComponents();
        for (Component c : components) {
            if (c instanceof JTextField) {
                JTextField campo = (JTextField) c;
                if (Validaciones.CampoVacio(campo.getText())) {
                    campo.requestFocus();
                    valido = false;
                    break;
                }
            }
            if (c instanceof JTextArea) {
                JTextArea campo = (JTextArea) c;
                if (Validaciones.CampoVacio(campo.getText())) {
                    campo.requestFocus();
                    valido = false;
                    break;
                }
            }
        }
        return valido;
    }

    public boolean recorrerHabilitados(JPanel panel) {
        boolean valido = true;
        Component[] components = panel.getComponents();
        for (Component c : components) {
            if (c instanceof JTextField && c.isEnabled()) {
                JTextField campo = (JTextField) c;
                if (Validaciones.CampoVacio(campo.getText())) {
                    campo.requestFocus();
                    valido = false;
                    break;
                }
            }
            if (c instanceof JTextArea && c.isEnabled()) {
                JTextArea campo = (JTextArea) c;
                if (Validaciones.CampoVacio(campo.getText())) {
                    campo.requestFocus();
                    valido = false;
                    break;
                }
            }
        }
        return valido;
    }

    public String removerEspaciosExtra(String cadena) {
        return cadena.replaceAll(" {2,}", " "); //cuando encuentra dos o más espacios consecutivos
    }

    public boolean validarDateChooser(com.toedter.calendar.JDateChooser cal) {
        if (((JTextField) cal.getDateEditor().getUiComponent()).getText().isEmpty()) {
            return false;
        }
        if (java.awt.Color.RED == cal.getDateEditor().getUiComponent().getForeground()) {
            return false;
        }
        return true;
    }

    public boolean validarYearChooser(JSpinner cal) {
        if (((JSpinner.DefaultEditor) cal.getEditor()).getTextField().getText().isEmpty()) {
            return false;
        }
        return true;
    }

    public void limpiarCampos(JPanel panel) {
        Component[] components = panel.getComponents();
        for (Component c : components) {
            if (c instanceof JTextField) {
                JTextField campo = (JTextField) c;
                campo.setText("");
            } else if (c instanceof JComboBox) {
                JComboBox combo = (JComboBox) c;
                if (combo.getItemCount() > 0) {
                    combo.setSelectedIndex(0);
                }
            } else if (c instanceof JTextArea) {
                JScrollPane campo = (JScrollPane) c;
                JTextArea ta = (JTextArea) campo.getViewport().getView();
                ta.setText("");
            } else if (c instanceof javax.swing.JList) {
                javax.swing.JList campo = (javax.swing.JList) c;
                ((javax.swing.DefaultListModel) campo.getModel()).removeAllElements();
            } else if (c instanceof JCheckBox) {
                JCheckBox checkbox = (JCheckBox) c;
                checkbox.setSelected(false);
            } else if (c instanceof com.toedter.calendar.JDateChooser) {
                com.toedter.calendar.JDateChooser campo = (com.toedter.calendar.JDateChooser) c;
                ((JTextField) campo.getDateEditor().getUiComponent()).setText("");
            }
        }
    }

    public void filtrarBusqueda(String consulta, JTable tabla, int columna) {
        DefaultTableModel dm = (DefaultTableModel) tabla.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        tabla.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + consulta, columna));
    }

    public void filtrarBusquedaAbstract(String consulta, JTable tabla, int columna) {
        AbstractTableModel dm = (AbstractTableModel) tabla.getModel();
        TableRowSorter<AbstractTableModel> tr = new TableRowSorter<>(dm);
        tabla.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + consulta, columna));
    }

    public void filtrarBusquedaFechaRango(java.util.Date desde, java.util.Date hasta, JTable tabla, int columna) {
        AbstractTableModel dm = (AbstractTableModel) tabla.getModel();
        TableRowSorter<AbstractTableModel> tr = new TableRowSorter<>(dm);
        tabla.setRowSorter(tr);
        java.util.List<RowFilter<Object, Object>> filters = new java.util.ArrayList<>(2);

        LocalDateTime ldtd = LocalDateTime.ofInstant(desde.toInstant(), java.time.ZoneId.systemDefault());
        ldtd = ldtd.minusDays(1);
        desde = java.util.Date.from(ldtd.atZone(java.time.ZoneId.systemDefault()).toInstant());

        filters.add(RowFilter.dateFilter(RowFilter.ComparisonType.AFTER, desde));
        filters.add(RowFilter.dateFilter(RowFilter.ComparisonType.BEFORE, hasta));
        RowFilter rf = RowFilter.andFilter(filters);
        tr.setRowFilter(rf);
    }

    public void filtrarBusquedaFecha(java.util.Date fecha, JTable tabla, int columna) {
        AbstractTableModel dm = (AbstractTableModel) tabla.getModel();
        TableRowSorter<AbstractTableModel> tr = new TableRowSorter<>(dm);
        tabla.setRowSorter(tr);
        tr.setRowFilter(RowFilter.dateFilter(RowFilter.ComparisonType.EQUAL, fecha, columna));
    }

    public void formatearNumero(JTextField campo) {
        String b;
        b = campo.getText();
        if (b.isEmpty()) {
            b = "0";
        } else {
            b = b.replace(".", "");
            b = NumberFormat.getNumberInstance(Locale.GERMAN).format(Double.parseDouble(b));
        }
        campo.setText(b);
    }

    public String formatearNumero(Integer num) {
        String numero = "0";
        if (num == null) {
            return numero;
        } else {
            return NumberFormat.getNumberInstance(Locale.GERMAN).format(num);
        }
    }

    public boolean compararFechas(java.util.Date anterior, java.util.Date actual) {
        Integer resultado = actual.compareTo(anterior);
        return resultado < 0;
    }

    public static void limpiarTabla(JTable tabla) {
        for (int i = tabla.getRowCount() - 1; i >= 0; i--) {
            ((DefaultTableModel) tabla.getModel()).removeRow(i);
        }
    }

    public static void cerrarConEscape(final JInternalFrame jif) {
        ActionListener escListener = (ActionEvent e) -> {
            jif.dispose();
        };
        jif.getRootPane().registerKeyboardAction(escListener, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
    }

    public static void cerrarConEscape(final javax.swing.JDialog dialog) {
        ActionListener escListener = (ActionEvent e) -> {
            dialog.dispose();
        };
        dialog.getRootPane().registerKeyboardAction(escListener, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
    }

    public static void transferirFoco(JTextArea ta, KeyEvent e) {
        e.consume();
        if (e.isShiftDown()) {
            ta.transferFocusBackward();
        } else {
            ta.transferFocus();
        }
    }

    public static void eliminarArchivo(String archivo, String subcadena) {
        File file = null;
        try {
            file = new File(new java.io.File(y.Y.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).
                    getParentFile().getParentFile().getPath() + archivo);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();
            for (File fileName : files) {
                if (FilenameUtils.removeExtension(fileName.getName()).endsWith(subcadena)) {
                    fileName.delete();
                    break;
                }
            }
        }
    }

    public static java.sql.Date utilDateaSqlDate(java.util.Date fecha) {
        return java.sql.Date.valueOf(LocalDateTime.ofInstant(Instant.ofEpochMilli(fecha.getTime()), ZoneId.systemDefault()).toLocalDate());
    }

    public static LocalDate utilDateaLocalDate(java.util.Date fecha) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(fecha.getTime()), ZoneId.systemDefault()).toLocalDate();
    }

    public static java.util.Date LocalDateaUtilDate(LocalDate fecha) {
        return java.util.Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static void setRenderers(Map<Integer, TableCellRenderer> mapa, JTable tabla) {
        mapa.entrySet().forEach((entry) -> {
            tabla.getColumnModel().getColumn(entry.getKey()).setCellRenderer(entry.getValue());
        });
    }

    public static void setMinimoyMaximoColumnas(Map<Integer, Integer> mapa, JTable tabla) { //solo usar esta función cuando se desea que el mínimo y máximo de anchura de la columna sea el mismo
        mapa.entrySet().forEach((entry) -> {
            tabla.getColumnModel().getColumn(entry.getKey()).setMinWidth(entry.getValue());
            tabla.getColumnModel().getColumn(entry.getKey()).setMaxWidth(entry.getValue());
        });
    }

    public static int ConvertirMesaNumero(String mes) {
        switch (mes) {
            case "ENERO":
                return 1;
            case "FEBRERO":
                return 2;
            case "MARZO":
                return 3;
            case "ABRIL":
                return 4;
            case "MAYO":
                return 5;
            case "JUNIO":
                return 6;
            case "JULIO":
                return 7;
            case "AGOSTO":
                return 8;
            case "SEPTIEMBRE":
                return 9;
            case "OCTUBRE":
                return 10;
            case "NOVIEMBRE":
                return 11;
            default:
                return 12;

        }
    }
}
