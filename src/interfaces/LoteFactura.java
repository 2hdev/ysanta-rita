package interfaces;

import clases.tablas.TablaLotesLecturas;
import javax.swing.JOptionPane;
import utilidades.Funciones;
import utilidades.Validaciones;

public class LoteFactura extends javax.swing.JInternalFrame {
    
    Funciones f;
    modelos.LoteComprobantes lc;
    String accion;
    dao.Comprobante c;
    
    public LoteFactura() {
        initComponents();
        f = new Funciones();
        c = new dao.Comprobante();
        lc = new modelos.LoteComprobantes();        
        accion = "INS";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelDescripcion = new javax.swing.JLabel();
        campoDescripcion = new javax.swing.JTextField();
        labelFecha = new javax.swing.JLabel();
        campoFechaActual = new com.toedter.calendar.JDateChooser();
        labelFecha1 = new javax.swing.JLabel();
        campoFechaVenc = new com.toedter.calendar.JDateChooser();
        labelObs = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoObs = new javax.swing.JTextArea();
        labelCorrespond = new javax.swing.JLabel();
        comboMeses = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        selectYear = new javax.swing.JSpinner();

        setClosable(true);
        setTitle("Lote de Comprobantes");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/y_mini.png"))); // NOI18N

        labelDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelDescripcion.setText("Descripción:");

        campoDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoDescripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoDescripcionFocusLost(evt);
            }
        });
        campoDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoDescripcionKeyTyped(evt);
            }
        });

        labelFecha.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelFecha.setText("Fecha:");

        campoFechaActual.setDateFormatString("dd/MM/yyyy");
        campoFechaActual.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        campoFechaActual.setMaxSelectableDate(new java.util.Date(32503694508000L));
        campoFechaActual.setMinSelectableDate(new java.util.Date(-2208974960000L));
        campoFechaActual.getDateEditor().getUiComponent().addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if(Validaciones.Letras(evt.getKeyChar()) || Validaciones.Espacio(evt.getKeyChar())) evt.consume();
            }
        });

        campoFechaActual.setDate(new java.util.Date());

        labelFecha1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelFecha1.setText("Fecha de Vencimiento:");

        campoFechaVenc.setDateFormatString("dd/MM/yyyy");
        campoFechaVenc.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        campoFechaVenc.setMaxSelectableDate(new java.util.Date(32503694508000L));
        campoFechaVenc.setMinSelectableDate(new java.util.Date(-2208974960000L));
        campoFechaActual.getDateEditor().getUiComponent().addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if(Validaciones.Letras(evt.getKeyChar()) || Validaciones.Espacio(evt.getKeyChar())) evt.consume();
            }
        });

        labelObs.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelObs.setText("Observación:");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        campoObs.setColumns(20);
        campoObs.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoObs.setLineWrap(true);
        campoObs.setRows(5);
        campoObs.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoObsFocusLost(evt);
            }
        });
        campoObs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoObsKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(campoObs);

        labelCorrespond.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelCorrespond.setText("Correspondiente a:");

        comboMeses.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        comboMeses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));
        comboMeses.setPreferredSize(new java.awt.Dimension(130, 21));

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

        selectYear.setModel(new javax.swing.SpinnerNumberModel(java.time.Year.now().getValue(), 1990, 3000, 1));
        selectYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                selectYearKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelObs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelFecha1)
                            .addComponent(labelCorrespond))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoFechaVenc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboMeses, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectYear, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnGuardar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCancelar))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelDescripcion)
                                .addComponent(labelFecha))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(campoFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(campoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(labelFecha)
                    .addComponent(campoFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(labelDescripcion)
                    .addComponent(campoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(comboMeses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCorrespond)
                    .addComponent(selectYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(labelFecha1)
                    .addComponent(campoFechaVenc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelObs)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDescripcionKeyTyped
        f.convertirAMayusculas(evt);
        if(Validaciones.Longitud(campoDescripcion, 50)) evt.consume();
    }//GEN-LAST:event_campoDescripcionKeyTyped

    private void campoObsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoObsFocusLost
        campoObs.setText(f.removerEspaciosExtra(campoObs.getText()));
        campoObs.setText(campoObs.getText().trim());
    }//GEN-LAST:event_campoObsFocusLost

    private void campoObsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoObsKeyTyped
        f.convertirAMayusculas(evt);
    }//GEN-LAST:event_campoObsKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(!f.validarDateChooser(campoFechaActual)){campoFechaActual.requestFocus(); return;}
        if(!f.validarDateChooser(campoFechaVenc)){campoFechaVenc.requestFocus(); return;}
        if(!f.validarYearChooser(selectYear)){selectYear.requestFocus(); return;}
        if(Validaciones.CampoVacio(campoDescripcion.getText())){campoDescripcion.requestFocus(); return;}
        switch(accion){
            case "INS": 
                lc.setFechaGeneracion(campoFechaActual.getDate());
                lc.setFechaVencimiento(campoFechaVenc.getDate());
                lc.setDescripcion(campoDescripcion.getText());
                lc.setMesLote(comboMeses.getSelectedItem().toString());
                lc.setAnhoLote(Integer.parseInt(selectYear.getValue().toString()));
                lc.setObservacion(campoObs.getText());
                if(c.existeMismaFechaLote(lc)){
                    JOptionPane.showMessageDialog(null, "No se puede guardar: Actualmente existe un lote similar según su mes y año de vencimiento y mes y año de lote.", "Atención", JOptionPane.WARNING_MESSAGE);
                    comboMeses.requestFocus();
                    return;
                }
                else{
                    if(c.insertarLoteLectura(lc)){
                        JOptionPane.showMessageDialog(null, "Se almacenó el lote con éxito.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        ListaLoteLecturas.setTll(new TablaLotesLecturas(dao.Comprobante.listarLotesLecturas()));
                        ListaLoteLecturas.tablaLecturas.setModel(ListaLoteLecturas.getTll());
                        ((javax.swing.table.AbstractTableModel)ListaLoteLecturas.tablaLecturas.getModel()).fireTableDataChanged();
                        dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "No se ha podido registrar el lote. Por favor, inténtelo más tarde.", "Mensaje", JOptionPane.ERROR_MESSAGE);
                        dispose();
                    }
                }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void campoDescripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoDescripcionFocusLost
        campoDescripcion.setText(f.removerEspaciosExtra(campoDescripcion.getText()));
        campoDescripcion.setText(campoDescripcion.getText().trim());
    }//GEN-LAST:event_campoDescripcionFocusLost

    private void selectYearKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_selectYearKeyTyped
        if(!Validaciones.Numeros(evt.getKeyChar())) evt.consume();
    }//GEN-LAST:event_selectYearKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JTextField campoDescripcion;
    private com.toedter.calendar.JDateChooser campoFechaActual;
    private com.toedter.calendar.JDateChooser campoFechaVenc;
    private javax.swing.JTextArea campoObs;
    private javax.swing.JComboBox<String> comboMeses;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCorrespond;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelFecha1;
    private javax.swing.JLabel labelObs;
    private javax.swing.JSpinner selectYear;
    // End of variables declaration//GEN-END:variables
}
