package interfaces;

import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JOptionPane;
import utilidades.Funciones;
import utilidades.Validaciones;

public class Medidor extends javax.swing.JInternalFrame {

    Funciones f;
    dao.Medidor m;
    modelos.Medidor med;
    modelos.Lectura l;
    boolean tiene = false;
    
    public Medidor() {
        initComponents();
        f = new Funciones();
        f.agregarPlaceHolder(((javax.swing.JTextField)campoFechaActual.getDateEditor().getUiComponent()), "dd/MM/aaaa");
        campoFechaActual.setDate(new Date());
        
    }

    @Override
    public void dispose() {
        ListaMedidores.btnNuevoMedidor.setEnabled(true);
        super.dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        labelMedidor = new javax.swing.JLabel();
        campoNumMedidor = new javax.swing.JTextField();
        labelDescripcion = new javax.swing.JLabel();
        campoDescripcion = new javax.swing.JTextField();
        labelActual = new javax.swing.JLabel();
        labelMedicion = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        campoActual = new javax.swing.JTextField();
        campoFechaActual = new com.toedter.calendar.JDateChooser();
        labelObs = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoObs = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        labelUsuario = new javax.swing.JLabel();
        campoNumCuenta = new javax.swing.JTextField();
        btnBuscarCuenta = new javax.swing.JButton();

        setClosable(true);
        setTitle("Registrar Medidor");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/y_mini.png"))); // NOI18N

        labelMedidor.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelMedidor.setText("Nº Medidor:");

        campoNumMedidor.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoNumMedidor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNumMedidorKeyTyped(evt);
            }
        });

        labelDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelDescripcion.setText("Descripción:");

        campoDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoDescripcion.setText("MEDIDOR");
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

        labelActual.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelActual.setText("Lectura Actual:");

        labelMedicion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelMedicion.setText("Medición:");

        labelFecha.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelFecha.setText("Fecha:");

        campoActual.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoActual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoActualKeyTyped(evt);
            }
        });

        campoFechaActual.setDateFormatString("dd/MM/yyyy");
        campoFechaActual.setMaxSelectableDate(new java.util.Date(32503694508000L));
        campoFechaActual.setMinSelectableDate(new java.util.Date(-2208974960000L));
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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoObsKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoObsKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(campoObs);

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

        labelUsuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelUsuario.setText("Asignar a Cuenta Nº:");

        campoNumCuenta.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoNumCuenta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoNumCuentaFocusLost(evt);
            }
        });
        campoNumCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNumCuentaActionPerformed(evt);
            }
        });
        campoNumCuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNumCuentaKeyTyped(evt);
            }
        });

        btnBuscarCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btnBuscarCuenta.setToolTipText("Ver Resumen de Cuenta");
        btnBuscarCuenta.setBorderPainted(false);
        btnBuscarCuenta.setContentAreaFilled(false);
        btnBuscarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCuentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addComponent(labelUsuario)
                        .addGap(18, 18, 18)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoNumMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelContenedorLayout.createSequentialGroup()
                                    .addComponent(btnGuardar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnCancelar))
                                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelContenedorLayout.createSequentialGroup()
                                        .addComponent(campoNumCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelContenedorLayout.createSequentialGroup()
                                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(campoActual, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panelContenedorLayout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(labelMedicion)))
                                        .addGap(57, 57, 57)
                                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(campoFechaActual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorLayout.createSequentialGroup()
                                                .addComponent(labelFecha)
                                                .addGap(54, 54, 54))))))))
                    .addComponent(labelObs)
                    .addComponent(labelActual)
                    .addComponent(labelMedidor)
                    .addComponent(labelDescripcion))
                .addGap(41, 41, 41))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMedidor)
                    .addComponent(campoNumMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDescripcion))
                        .addGap(20, 20, 20)
                        .addComponent(labelMedicion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelActual)
                            .addComponent(campoActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addComponent(labelFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelObs)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(campoNumCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelUsuario)
                            .addComponent(btnBuscarCuenta))))
                .addGap(20, 20, 20)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(!f.recorrerYValidar(panelContenedor)) return;
        if(!f.validarDateChooser(campoFechaActual)) {campoFechaActual.requestFocusInWindow(); return;}
        med = new modelos.Medidor();
        l = new modelos.Lectura();
        med.setNumeroMedidor(campoNumMedidor.getText());
        med.setDescripcion(campoDescripcion.getText());
        med.setObservacion(campoObs.getText());
        med.setEstado("");
        if(tiene){
            String[] options = {"Sí", "No"};
            int seleccion = javax.swing.JOptionPane.showOptionDialog(
                null, "Ya se han asignado medidores a este número de cuenta.\nLos medidores anteriores se darán de baja. \n¿Continuar?", "Dar de Baja a Medidores Anteriores", 
                javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if(seleccion == 0){
                dao.Medidor.darBajaMedidoresEnCuenta(campoNumCuenta.getText());
            }
            else return;
        }
        m = new dao.Medidor();
        l.setLectura(Integer.parseInt(campoActual.getText()));
        l.setFechaLectura(campoFechaActual.getDate());
        if(m.verificarMedidor(med.getNumeroMedidor())){
            JOptionPane.showMessageDialog(null, "El número de medidor ya está registrado actualmente.");
            return;
        }
        if(m.insertarMedidor(med,l, campoNumCuenta.getText())){
            JOptionPane.showMessageDialog(null, "Se registró correctamente.");
            ListaMedidores.insertarEnTabla();
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "No se ha podido registrar los datos.");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void campoNumMedidorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNumMedidorKeyTyped
        if(!Validaciones.NumerosyLetras(evt.getKeyChar())) evt.consume();
        if(Validaciones.Longitud(campoNumMedidor, 11)) evt.consume();
        f.convertirAMayusculas(evt);
    }//GEN-LAST:event_campoNumMedidorKeyTyped

    private void campoDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDescripcionKeyTyped
        if(Validaciones.Longitud(campoNumMedidor, 50)) evt.consume();
        f.convertirAMayusculas(evt);
    }//GEN-LAST:event_campoDescripcionKeyTyped

    private void campoObsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoObsFocusLost
        campoObs.setText(f.removerEspaciosExtra(campoObs.getText()));
        campoObs.setText(campoObs.getText().trim());
    }//GEN-LAST:event_campoObsFocusLost

    private void campoActualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoActualKeyTyped
        if(Validaciones.Longitud(campoActual, 11)) evt.consume();
        if(!Validaciones.Numeros(evt.getKeyChar())) evt.consume();
    }//GEN-LAST:event_campoActualKeyTyped

    private void campoObsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoObsKeyTyped
        f.convertirAMayusculas(evt);
    }//GEN-LAST:event_campoObsKeyTyped

    private void campoDescripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoDescripcionFocusLost
        campoDescripcion.setText(f.removerEspaciosExtra(campoDescripcion.getText()));
        campoDescripcion.setText(campoDescripcion.getText().trim());
    }//GEN-LAST:event_campoDescripcionFocusLost

    private void campoNumCuentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNumCuentaKeyTyped
        if(Validaciones.Longitud(campoNumCuenta, 11)) evt.consume();
        if(!Validaciones.Numeros(evt.getKeyChar())) evt.consume();
    }//GEN-LAST:event_campoNumCuentaKeyTyped

    private void btnBuscarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCuentaActionPerformed
        interfaces.dialogos.BuscarCuenta bc = new interfaces.dialogos.BuscarCuenta(Medidor.this, campoNumCuenta, true);
        bc.setLocationRelativeTo(Medidor.this);
        bc.setVisible(true);
    }//GEN-LAST:event_btnBuscarCuentaActionPerformed

    private void campoObsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoObsKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_TAB){
            utilidades.Funciones.transferirFoco(campoObs, evt);
        }
    }//GEN-LAST:event_campoObsKeyPressed

    private void campoNumCuentaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNumCuentaFocusLost
        validarCuenta();
    }//GEN-LAST:event_campoNumCuentaFocusLost

    private void campoNumCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNumCuentaActionPerformed
        campoNumCuenta.transferFocus();
    }//GEN-LAST:event_campoNumCuentaActionPerformed

    private void validarCuenta(){
        if(campoNumCuenta.getText().isEmpty()){
            campoNumCuenta.requestFocus();
        }
        else{
            boolean existe = dao.Cuentas.existeCuenta(campoNumCuenta.getText());
            if(!existe){
                JOptionPane.showMessageDialog(null, "El número de cuenta no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                campoNumCuenta.setText("");
                campoNumCuenta.requestFocus();
                btnGuardar.setEnabled(false);
                return;
            }
            else{
                btnGuardar.setEnabled(true);
                btnGuardar.requestFocus();
                tiene = dao.Cuentas.tieneMedidoresLaCuenta(campoNumCuenta.getText());
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCuenta;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JTextField campoActual;
    private javax.swing.JTextField campoDescripcion;
    private com.toedter.calendar.JDateChooser campoFechaActual;
    private javax.swing.JTextField campoNumCuenta;
    private javax.swing.JTextField campoNumMedidor;
    private javax.swing.JTextArea campoObs;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelActual;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelMedicion;
    private javax.swing.JLabel labelMedidor;
    private javax.swing.JLabel labelObs;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPanel panelContenedor;
    // End of variables declaration//GEN-END:variables
}
