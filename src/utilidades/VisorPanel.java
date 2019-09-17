package utilidades;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.util.logging.Level;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.swing.JRViewer;

public class VisorPanel extends JRViewer{  
    JButton print = new javax.swing.JButton();
    JTextField inicio, fin;
    int total = 0;
    FocusListener minimo = new FocusListener() {

        @Override
        public void focusGained(FocusEvent e) {}

        @Override
        public void focusLost(FocusEvent e) {
            try {
                if(inicio.getText().isEmpty()) return;
                int v = Integer.parseInt(inicio.getText());
            if(v>0 && v<=total) {
                
            }
            else inicio.setText("1");
            }
            catch(NumberFormatException ex) {
                java.util.logging.Logger.getLogger(VisorPanel.class.getName()).log(Level.WARNING, "Error al parsear número: ", ex);
            }
        }
    };
    
    FocusListener maximo = new FocusListener() {

        @Override
        public void focusGained(FocusEvent e) {}

        @Override
        public void focusLost(FocusEvent e) {
            try {
                if(fin.getText().isEmpty()) return;
                int v = Integer.parseInt(fin.getText());
            if(v>0 && v<=total) {
                
            }
            else fin.setText(String.format("%d", total));
            }
            catch(NumberFormatException ex) {
                java.util.logging.Logger.getLogger(VisorPanel.class.getName()).log(Level.WARNING, "Error al parsear número: ", ex);
            }
        }
    };

    KeyAdapter adapt = new KeyAdapter() {
        @Override
        public void keyTyped(java.awt.event.KeyEvent evt) {
            if(!Validaciones.Numeros(evt.getKeyChar())) evt.consume();
        }
    };
    
    public VisorPanel(JasperPrint jrPrint, boolean imprime) {
        super(jrPrint);
        ((JPanel) this.tlbToolBar).remove(1); //si se escribe remove 0 es remover el botón de guardar. remove 1 es remover el de imprimir
        if(imprime){
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
                total = jrPrint.getPages().size();
                inicio.addKeyListener(adapt); fin.addKeyListener(adapt); inicio.addFocusListener(minimo); fin.addFocusListener(maximo);
                inicio.setText("1");
                fin.setText(String.format("%d", total));
                boolean valido;
                do{
                    int option = JOptionPane.showConfirmDialog(null, message, "Imprimir", JOptionPane.OK_CANCEL_OPTION);
                    if (option == JOptionPane.OK_OPTION) {
                        valido = valido();
                        if(valido){
                            int ini = Integer.parseInt(inicio.getText())-1; int end = Integer.parseInt(fin.getText())-1;
                            try{
                                JasperPrintManager.printPages(jrPrint, ini, end, false);
                            }
                            catch(JRException ex){
                                JOptionPane.showMessageDialog(null, "No se han encontrado impresoras instaladas o no se puede imprimir el informe en este momento.\nPor favor, guarde el reporte generado en formato PDF para poder imprimirla correctamente más adelante.", "Advertencia",JOptionPane.WARNING_MESSAGE);
                                java.util.logging.Logger.getLogger(VisorPanel.class.getName()).log(Level.SEVERE, "Error al intentar imprimir reporte: ", ex);
                            }
                            break;
                        }
                    }
                    else return;
                }
                while(!valido);
            });
            ((JPanel) this.tlbToolBar).add(print, 1);
            if(jrPrint.getPages().isEmpty()) print.setEnabled(false);
        }
    }
    
    private boolean valido(){
        boolean valido = true;
        if(Validaciones.CampoVacio(inicio.getText())) {JOptionPane.showMessageDialog(null, "Ingrese desde qué página desea imprimir.", "Inicio de rango ausente", JOptionPane.ERROR_MESSAGE); valido = false;}
        if(Validaciones.CampoVacio(fin.getText())) {JOptionPane.showMessageDialog(null, "Ingrese hasta qué página desea imprimir.", "Fin de rango ausente", JOptionPane.ERROR_MESSAGE); valido = false;}
        if(Integer.parseInt(inicio.getText()) > Integer.parseInt(fin.getText())){JOptionPane.showMessageDialog(null, "El número de página inicial ingresado es menor al número de página final.", "Rango inválido", JOptionPane.ERROR_MESSAGE); valido = false;}
        return valido;
    }
}
