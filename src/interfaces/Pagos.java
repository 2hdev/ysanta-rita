package interfaces;

import javax.swing.JOptionPane;
import modelos.LotePagos;
import utilidades.Funciones;
import utilidades.Validaciones;

public class Pagos extends javax.swing.JInternalFrame {
    
    Funciones f;
    dao.Comprobante c;
    
    public Pagos() {
        c = new dao.Comprobante();
        initComponents();
        f = new Funciones();
        campoFechaLote.setDate(new java.util.Date());
    }

    @Override
    public void dispose() {
        ListaPagos.btnNuevoPago.setEnabled(true);
        super.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        labelDescripcion = new javax.swing.JLabel();
        campoDescripcion = new javax.swing.JTextField();
        labelFLote = new javax.swing.JLabel();
        campoFechaLote = new com.toedter.calendar.JDateChooser();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        labelCorrespond = new javax.swing.JLabel();
        comboMeses = new javax.swing.JComboBox<>();
        selectYear = new javax.swing.JSpinner();
        labelObs = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoObs = new javax.swing.JTextArea();

        setClosable(true);
        setTitle("Lote de Pagos");
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

        labelFLote.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelFLote.setText("Fecha de Lote:");

        campoFechaLote.setDateFormatString("dd/MM/yyyy");
        campoFechaLote.setFocusable(false);
        campoFechaLote.setMaxSelectableDate(new java.util.Date(32503694508000L));
        campoFechaLote.setMinSelectableDate(new java.util.Date(-2208974960000L));
        campoFechaLote.getDateEditor().getUiComponent().addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if(Validaciones.Letras(evt.getKeyChar()) || Validaciones.Espacio(evt.getKeyChar())) evt.consume();
            }
        });

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

        labelCorrespond.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelCorrespond.setText("Correspondiente a:");

        comboMeses.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        comboMeses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));
        comboMeses.setPreferredSize(new java.awt.Dimension(130, 21));

        selectYear.setModel(new javax.swing.SpinnerNumberModel(java.time.Year.now().getValue(), 1990, 3000, 1));
        selectYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                selectYearKeyTyped(evt);
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

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelDescripcion)
                            .addComponent(labelFLote)
                            .addComponent(labelCorrespond)
                            .addComponent(labelObs))
                        .addGap(18, 18, 18)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoFechaLote, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelContenedorLayout.createSequentialGroup()
                                .addComponent(comboMeses, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectYear, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelFLote)
                            .addComponent(campoFechaLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addComponent(campoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCorrespond)
                            .addComponent(comboMeses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(labelDescripcion)))
                .addGap(18, 18, 18)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelObs)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoDescripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoDescripcionFocusLost
        campoDescripcion.setText(f.removerEspaciosExtra(campoDescripcion.getText()));
        campoDescripcion.setText(campoDescripcion.getText().trim());
    }//GEN-LAST:event_campoDescripcionFocusLost

    private void campoDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDescripcionKeyTyped
        if(Validaciones.Longitud(campoDescripcion, 50)) evt.consume();
        f.convertirAMayusculas(evt);
    }//GEN-LAST:event_campoDescripcionKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(!f.recorrerYValidar(panelContenedor)) return;
        if(!f.validarDateChooser(campoFechaLote)) {campoFechaLote.requestFocusInWindow(); return;}
        LotePagos lp = new LotePagos();
        lp.setFechaLote(campoFechaLote.getDate());
        lp.setDescripcion(campoDescripcion.getText());
        lp.setObservacion(campoObs.getText());
        lp.setMes(comboMeses.getSelectedItem().toString());
        lp.setAnho(selectYear.getValue().toString());
        dao.Pagos p = new dao.Pagos();
        if(p.insertarLotePago(lp)){
            JOptionPane.showMessageDialog(null, "Se ha registrado el lote de pago con éxito.", "Éxito al guardar", JOptionPane.INFORMATION_MESSAGE);
            ListaPagos.tablaPagos.setModel(new clases.tablas.TablaLotePagos(dao.Pagos.listarLotesPagos()));
            this.dispose();
        }
        else {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar almacenar los datos. Por favor, inténtelo de nuevo más tarde", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void selectYearKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_selectYearKeyTyped
        if(!Validaciones.Numeros(evt.getKeyChar())) evt.consume();
    }//GEN-LAST:event_selectYearKeyTyped

    private void campoObsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoObsFocusLost
        campoObs.setText(f.removerEspaciosExtra(campoObs.getText()));
        campoObs.setText(campoObs.getText().trim());
    }//GEN-LAST:event_campoObsFocusLost

    private void campoObsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoObsKeyTyped
        f.convertirAMayusculas(evt);
    }//GEN-LAST:event_campoObsKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JTextField campoDescripcion;
    private com.toedter.calendar.JDateChooser campoFechaLote;
    private javax.swing.JTextArea campoObs;
    private javax.swing.JComboBox<String> comboMeses;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCorrespond;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelFLote;
    private javax.swing.JLabel labelObs;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JSpinner selectYear;
    // End of variables declaration//GEN-END:variables
}
