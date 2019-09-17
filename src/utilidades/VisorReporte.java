package utilidades;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.io.File;
import java.util.logging.Level;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.view.JasperViewer;

public class VisorReporte extends JasperViewer {

    JButton print = new javax.swing.JButton();
    JTextField inicio, fin;
    int total = 0;
    FocusListener minimo = new FocusListener() {

        @Override
        public void focusGained(FocusEvent e) {
        }

        @Override
        public void focusLost(FocusEvent e) {
            try {
                if (inicio.getText().isEmpty()) {
                    return;
                }
                int v = Integer.parseInt(inicio.getText());
                if (v > 0 && v <= total) {

                } else {
                    inicio.setText("1");
                }
            } catch (NumberFormatException ex) {
                java.util.logging.Logger.getLogger(VisorReporte.class.getName()).log(Level.WARNING, "Error al parsear número: ", ex);
            }
        }
    };

    FocusListener maximo = new FocusListener() {

        @Override
        public void focusGained(FocusEvent e) {
        }

        @Override
        public void focusLost(FocusEvent e) {
            try {
                if (fin.getText().isEmpty()) {
                    return;
                }
                int v = Integer.parseInt(fin.getText());
                if (v > 0 && v <= total) {

                } else {
                    fin.setText(String.format("%d", total));
                }
            } catch (NumberFormatException ex) {
                java.util.logging.Logger.getLogger(VisorReporte.class.getName()).log(Level.WARNING, "Error al parsear número: ", ex);
            }
        }
    };

    KeyAdapter adapt = new KeyAdapter() {
        @Override
        public void keyTyped(java.awt.event.KeyEvent evt) {
            if (!Validaciones.Numeros(evt.getKeyChar())) {
                evt.consume();
            }
        }
    };

    public JButton getBtnPrint() {
        return print;
    }

    public void setBtnPrint(JButton print) {
        this.print = print;
    }

    public VisorReporte(JasperPrint jasperPrint, boolean isExitOnClose, boolean imprime) {
        super(jasperPrint, isExitOnClose);
        ((JPanel) this.viewer.getComponent(0)).remove(1); //si se escribe remove 0 es remover el botón de guardar. remove 1 es remover el de imprimir
        if (imprime) {
            print.setToolTipText("Imprimir");
            print.setPreferredSize(new java.awt.Dimension(25, 25));
            print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/printer.png")));
            print.addActionListener((java.awt.event.ActionEvent evt) -> {
                inicio = new JTextField();
                fin = new JTextField();
                Object[] message = {
                    "Desde la página:", inicio,
                    "Hasta:", fin
                };
                total = jasperPrint.getPages().size();
                inicio.addKeyListener(adapt);
                fin.addKeyListener(adapt);
                inicio.addFocusListener(minimo);
                fin.addFocusListener(maximo);
                inicio.setText("1");
                fin.setText(String.format("%d", total));
                boolean valido;
                do {
                    int option = JOptionPane.showConfirmDialog(null, message, "Imprimir", JOptionPane.OK_CANCEL_OPTION);
                    if (option == JOptionPane.OK_OPTION) {
                        valido = valido();
                        if (valido) {
                            int ini = Integer.parseInt(inicio.getText()) - 1;
                            int end = Integer.parseInt(fin.getText()) - 1;
                            try {
                                JasperPrintManager.printPages(jasperPrint, ini, end, false);
                            } catch (JRException ex) {
                                JOptionPane.showMessageDialog(null, "No se han encontrado impresoras instaladas o no se puede imprimir el informe en este momento.\nPor favor, guarde el reporte generado en formato PDF para poder imprimirla correctamente más adelante.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                java.util.logging.Logger.getLogger(VisorReporte.class.getName()).log(Level.SEVERE, "Error al intentar imprimir reporte: ", ex);
                            }
                            break;
                        }
                    } else {
                        return;
                    }
                } while (!valido);
            });
            ((JPanel) this.viewer.getComponent(0)).add(print, 0);
            if (jasperPrint.getPages().isEmpty()) {
                print.setEnabled(false);
            }
        }
    }

    public VisorReporte(String sourceFile, boolean isXMLFile, boolean isExitOnClose, boolean imprime, boolean elimina) throws JRException {
        super(sourceFile, isXMLFile, isExitOnClose);
        ((JPanel) this.viewer.getComponent(0)).remove(1); //si se escribe remove 0 es remover el botón de guardar. remove 1 es remover el de imprimir
        if (imprime) {
            print.setToolTipText("Imprimir");
            print.setPreferredSize(new java.awt.Dimension(25, 25));
            print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/printer.png")));
            print.addActionListener((java.awt.event.ActionEvent evt) -> {
                try {
                    JasperPrintManager.printReport(sourceFile, false);
                    java.io.File aeliminar = new java.io.File(sourceFile);
                    if (aeliminar.exists() && elimina) {
                        aeliminar.delete();
                    }
                } catch (JRException ex) {
                    JOptionPane.showMessageDialog(null, "No se han encontrado impresoras instaladas o no se puede imprimir el informe en este momento.\nPor favor, guarde el reporte generado en formato PDF para poder imprimirla correctamente más adelante.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    java.util.logging.Logger.getLogger(VisorReporte.class.getName()).log(Level.SEVERE, "Error al intentar imprimir reporte: ", ex);
                    return;
                }
                dispose();
            });
            ((JPanel) this.viewer.getComponent(0)).add(print, 0);
        }
    }

    public VisorReporte(JasperPrint jasperPrint, boolean isExitOnClose, String rutaerror) {
        super(jasperPrint, isExitOnClose);
        ((JPanel) this.viewer.getComponent(0)).remove(1); //si se escribe remove 0 es remover el botón de guardar. remove 1 es remover el de imprimir
        print.setToolTipText("Imprimir");
        print.setPreferredSize(new java.awt.Dimension(25, 25));
        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/printer.png")));
        print.addActionListener((java.awt.event.ActionEvent evt) -> {
            try {
                JasperPrintManager.printReport(jasperPrint, false);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, "No se han encontrado impresoras instaladas o no se puede imprimir el informe en este momento.\nEl archivo será almacenado en su equipo para su posterior impresión.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                String nombrearchivo = new java.text.SimpleDateFormat("yyyy-MM-dd hh-mm-ss'.jrprint'").format(new java.util.Date());
                java.io.File destFile;
                try {
                    destFile = new java.io.File(utilidades.Estaticos.RUTA_APP + File.separator + "impresiones" + File.separator + rutaerror + File.separator + nombrearchivo);
                } catch (Exception ex1) {
                    ex1.getMessage();
                    JOptionPane.showMessageDialog(null, "No se encuentra la ruta especificada: no se puede guardar el archivo.", "Error al guardar copia de impresión", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String destFileName = destFile.toString();
                try {
                    JRSaver.saveObject(jasperPrint, destFileName);
                } catch (JRException exsave) {
                    exsave.getMessage();
                    java.util.logging.Logger.getLogger(VisorReporte.class.getName()).log(Level.SEVERE, "Error al intentar guardar reporte: ", exsave);
                }
            }
        });
        ((JPanel) this.viewer.getComponent(0)).add(print, 0);
        if (jasperPrint.getPages().isEmpty()) {
            print.setEnabled(false);
        }
    }

    private boolean valido() {
        boolean valido = true;
        if (Validaciones.CampoVacio(inicio.getText())) {
            JOptionPane.showMessageDialog(null, "Ingrese desde qué página desea imprimir.", "Inicio de rango ausente", JOptionPane.ERROR_MESSAGE);
            valido = false;
        }
        if (Validaciones.CampoVacio(fin.getText())) {
            JOptionPane.showMessageDialog(null, "Ingrese hasta qué página desea imprimir.", "Fin de rango ausente", JOptionPane.ERROR_MESSAGE);
            valido = false;
        }
        if (Integer.parseInt(inicio.getText()) > Integer.parseInt(fin.getText())) {
            JOptionPane.showMessageDialog(null, "El número de página inicial ingresado es menor al número de página final.", "Rango inválido", JOptionPane.ERROR_MESSAGE);
            valido = false;
        }
        return valido;
    }
}
