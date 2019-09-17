package interfaces.dialogos;

import clases.tablas.TablaZonas;
import interfaces.Zonas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import utilidades.Funciones;
import utilidades.Validaciones;

public class AMZona extends javax.swing.JDialog {
    
    String accion = "";
    modelos.Zona zonaant, zona;
    Funciones f = new Funciones();
    
    public AMZona(javax.swing.JInternalFrame parent, boolean modal, modelos.Zona zonaant) {
        initComponents();
        this.zonaant = zonaant;
        f.agregarPlaceHolder(campoZona, "Escriba la denominación de la zona");
        f.agregarPlaceHolder(campoDesc, "Escriba una descripción adicional de la zona (opcional)");
        campoZona.setText(zonaant.getZona());
        campoDesc.setText(zonaant.getDescripcion());
        accion = "EDIT";
    }

    public AMZona() {
        initComponents();
        accion = "INS";
        f.agregarPlaceHolder(campoZona, "Escriba la denominación de la zona");
        f.agregarPlaceHolder(campoDesc, "Escriba una descripción adicional de la zona (opcional)");
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        labelZona = new javax.swing.JLabel();
        campoZona = new javax.swing.JTextField();
        labelDesc = new javax.swing.JLabel();
        campoDesc = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nueva Zona");
        setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        setIconImage(null);
        setIconImages(null);
        setModal(true);
        setName("AMZona"); // NOI18N
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        labelZona.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelZona.setText("Zona:");

        campoZona.setBackground(new java.awt.Color(240, 240, 240));
        campoZona.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShadowColor(new java.awt.Color(204, 204, 204));
        dropShadowBorder1.setShowLeftShadow(true);
        campoZona.setBorder(dropShadowBorder1);
        campoZona.setName("zona"); // NOI18N
        campoZona.setPreferredSize(new java.awt.Dimension(5, 30));
        campoZona.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoZonaFocusLost(evt);
            }
        });
        campoZona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoZonaKeyTyped(evt);
            }
        });

        labelDesc.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelDesc.setText("Descripción:");

        campoDesc.setBackground(new java.awt.Color(240, 240, 240));
        campoDesc.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder2 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder2.setShadowColor(new java.awt.Color(204, 204, 204));
        dropShadowBorder2.setShowLeftShadow(true);
        campoDesc.setBorder(dropShadowBorder2);
        campoDesc.setName("descripcion"); // NOI18N
        campoDesc.setPreferredSize(new java.awt.Dimension(5, 30));
        campoDesc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoDescFocusLost(evt);
            }
        });
        campoDesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoDescKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelZona)
                                    .addComponent(labelDesc))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(campoZona, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(campoDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar)))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelZona)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoZona, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(labelDesc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(campoZona.getText().isEmpty() || campoZona.getText().equals("")) return;
        dao.Zonas z = new dao.Zonas();
        switch(accion){
            case "INS":
                zona = new modelos.Zona();
                zona.setZona(campoZona.getText());
                zona.setDescripcion(campoDesc.getText());                
                if(z.insertarZona(zona)) {
                    JOptionPane.showMessageDialog(null, "Se registró la zona con éxito.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    Zonas.setT(new TablaZonas(dao.Zonas.listaZonas()));
                    Zonas.tablaZonas.setModel(Zonas.getT());
                    ((javax.swing.table.AbstractTableModel)Zonas.tablaZonas.getModel()).fireTableDataChanged();
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error intentando registrar la zona.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }                
                break;
            case "EDIT":
                List<String> columnas = new ArrayList<>();  List<String> datos = new ArrayList<>();
                if(!zonaant.getZona().equals(campoZona.getText())){columnas.add(String.format("%s=?", campoZona.getName())); datos.add(campoZona.getText());}
                if(!zonaant.getDescripcion().equals(campoDesc.getText())){columnas.add(String.format("%s=?", campoDesc.getName())); datos.add(campoDesc.getText());}
                if(columnas.size() > 0){
                    if(z.actualizarZona(zonaant, columnas, datos, zonaant.getIdentificador())){
                        JOptionPane.showMessageDialog(null, "Se actualizaron los datos correctamente.");
                        Zonas.setT(new TablaZonas(dao.Zonas.listaZonas()));
                        Zonas.tablaZonas.setModel(Zonas.getT());
                        ((javax.swing.table.AbstractTableModel)Zonas.tablaZonas.getModel()).fireTableDataChanged();
                        dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "No se ha podido actualizar los datos.");
                    }
                }
                else {JOptionPane.showMessageDialog(null, "No se ha actualizado ningún dato.", "Atención", JOptionPane.WARNING_MESSAGE); return;}
                break;
            default: return;
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void campoZonaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoZonaFocusLost
        campoZona.setText(f.removerEspaciosExtra(campoZona.getText()));
        campoZona.setText(campoZona.getText().trim());
    }//GEN-LAST:event_campoZonaFocusLost

    private void campoDescFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoDescFocusLost
        campoDesc.setText(f.removerEspaciosExtra(campoDesc.getText()));
        campoDesc.setText(campoDesc.getText().trim());
    }//GEN-LAST:event_campoDescFocusLost

    private void campoZonaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoZonaKeyTyped
        if(Validaciones.Longitud(campoZona, 100)) evt.consume();
        if(!Validaciones.Letras(evt.getKeyChar()) && !Validaciones.Espacio(evt.getKeyChar()) && !Validaciones.Numeros(evt.getKeyChar())) evt.consume();
        f.convertirAMayusculas(evt);
    }//GEN-LAST:event_campoZonaKeyTyped

    private void campoDescKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDescKeyTyped
        if(Validaciones.Longitud(campoDesc, 45)) evt.consume();
        if(!Validaciones.Letras(evt.getKeyChar()) && !Validaciones.Espacio(evt.getKeyChar()) && !Validaciones.Numeros(evt.getKeyChar())) evt.consume();
        f.convertirAMayusculas(evt);
    }//GEN-LAST:event_campoDescKeyTyped
    
    @Override
    protected JRootPane createRootPane() {
        ActionListener actionListener = (ActionEvent actionEvent) -> {
            dispose();
        };
        JRootPane rootPane = new JRootPane();
        KeyStroke stroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
        rootPane.registerKeyboardAction(actionListener, stroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        return rootPane;
  }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JTextField campoDesc;
    private javax.swing.JTextField campoZona;
    private javax.swing.JLabel labelDesc;
    private javax.swing.JLabel labelZona;
    // End of variables declaration//GEN-END:variables
}
