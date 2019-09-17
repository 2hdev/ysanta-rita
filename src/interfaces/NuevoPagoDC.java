package interfaces;

import clases.tablas.TablaLotePagos;
import clases.tablas.TablaPagos;
import static interfaces.ListaFacturasxLotes.tablaPagosxLote;
import static interfaces.ListaPagos.tablaPagos;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import utilidades.Funciones;
import utilidades.Validaciones;


public class NuevoPagoDC extends javax.swing.JInternalFrame {

    Funciones f = new Funciones();
    dao.Cuentas cuentas = new dao.Cuentas();
    String idLote;
    modelos.Usuario u;
    dao.Comprobante c = new dao.Comprobante();
    Integer descuento = 0;
    Integer importe = 0;
    Integer tot = 0;
    Integer cuentaDC, cuentaComp = 0;
    modelos.Pago p;
    
    public NuevoPagoDC(String idLote) {
        initComponents();
        this.idLote = idLote;
        f.agregarPlaceHolder(((javax.swing.JTextField)campoFecha.getDateEditor().getUiComponent()), "dd/MM/aaaa");
        campoFecha.setDate(new java.util.Date());
    }

    @Override
    public void dispose() {
        ListaFacturasxLotes.btnNuevoPago.setEnabled(true);
        super.dispose(); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        labelFecha = new javax.swing.JLabel();
        campoFecha = new com.toedter.calendar.JDateChooser();
        labelUsuario = new javax.swing.JLabel();
        campoNumUsuario = new javax.swing.JTextField();
        campoUsuario = new javax.swing.JTextField();
        labelNFact = new javax.swing.JLabel();
        campoFact = new javax.swing.JFormattedTextField();
        labelConcepto = new javax.swing.JLabel();
        labelDescuento = new javax.swing.JLabel();
        btnDescuento = new javax.swing.JToggleButton();
        labelImporte = new javax.swing.JLabel();
        campoImporte = new javax.swing.JTextField();
        labelImporteDesc = new javax.swing.JLabel();
        campoImporteDesc = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        labelTotal = new javax.swing.JLabel();
        labelMontoTotal = new javax.swing.JLabel();
        labelSA = new javax.swing.JLabel();
        labelSaldo = new javax.swing.JLabel();
        comboConcepto = new javax.swing.JComboBox<>();
        labelNRec = new javax.swing.JLabel();
        campoNumRec = new javax.swing.JTextField();
        comboCuenta = new javax.swing.JComboBox<>();
        labelCuenta = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Nuevo Pago");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/y_mini.png"))); // NOI18N

        labelFecha.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelFecha.setText("Fecha:");

        campoFecha.setDateFormatString("dd/MM/yyyy");
        campoFecha.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoFecha.setMaxSelectableDate(new java.util.Date(32503694508000L));
        campoFecha.setMinSelectableDate(new java.util.Date(-2208974960000L));
        campoFecha.setNextFocusableComponent(campoUsuario);
        campoFecha.getDateEditor().getUiComponent().addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if(Validaciones.Letras(evt.getKeyChar()) || Validaciones.Espacio(evt.getKeyChar())) evt.consume();
            }
        });
        campoFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoFechaKeyPressed(evt);
            }
        });

        labelUsuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelUsuario.setText("Usuario:");

        campoNumUsuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoNumUsuario.setNextFocusableComponent(comboCuenta);
        campoNumUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoNumUsuarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNumUsuarioKeyTyped(evt);
            }
        });

        campoUsuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoUsuario.setEnabled(false);
        campoUsuario.setFocusable(false);

        labelNFact.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelNFact.setText("Factura Nº :");

        try {
            campoFact.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoFact.setEnabled(false);
        campoFact.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        campoFact.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        campoFact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoFactFocusLost(evt);
            }
        });
        campoFact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoFactKeyPressed(evt);
            }
        });

        labelConcepto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelConcepto.setText("Concepto:");

        labelDescuento.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelDescuento.setText("¿Descuento a Cuenta Actual?");

        btnDescuento.setText("No");
        btnDescuento.setEnabled(false);
        btnDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescuentoActionPerformed(evt);
            }
        });

        labelImporte.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelImporte.setText("Importe:");

        campoImporte.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoImporte.setEnabled(false);
        campoImporte.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoImporteFocusGained(evt);
            }
        });
        campoImporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoImporteKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoImporteKeyTyped(evt);
            }
        });

        labelImporteDesc.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelImporteDesc.setText("Importe:");
        labelImporteDesc.setVisible(false);

        campoImporteDesc.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoImporteDesc.setNextFocusableComponent(btnGuardar);
        campoImporteDesc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoImporteDescFocusGained(evt);
            }
        });
        campoImporteDesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoImporteDescKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoImporteDescKeyTyped(evt);
            }
        });
        campoImporteDesc.setVisible(false);

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
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

        labelTotal.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelTotal.setText("Total a Pagar:");

        labelMontoTotal.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelMontoTotal.setText("0");

        labelSA.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelSA.setText("Saldo Actual:");
        labelSA.setEnabled(false);

        labelSaldo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelSaldo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelSaldo.setText("0");
        labelSaldo.setEnabled(false);

        comboConcepto.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        comboConcepto.setToolTipText("");
        comboConcepto.setEnabled(false);
        comboConcepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboConceptoActionPerformed(evt);
            }
        });

        labelNRec.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelNRec.setText("Recibo Nº:");

        campoNumRec.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        campoNumRec.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoNumRecFocusLost(evt);
            }
        });
        campoNumRec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoNumRecKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNumRecKeyTyped(evt);
            }
        });

        comboCuenta.setEnabled(false);
        comboCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCuentaActionPerformed(evt);
            }
        });

        labelCuenta.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelCuenta.setText("Cuenta Nº:");

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(labelTotal)
                        .addGap(133, 133, 133)
                        .addComponent(labelMontoTotal))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(labelSA)
                        .addGap(100, 100, 100)
                        .addComponent(labelSaldo))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(labelUsuario)
                        .addGap(18, 18, 18)
                        .addComponent(campoNumUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelCuenta)
                        .addGap(4, 4, 4)
                        .addComponent(comboCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(labelFecha)
                        .addGap(18, 18, 18)
                        .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelContenedorLayout.createSequentialGroup()
                            .addComponent(btnGuardar)
                            .addGap(6, 6, 6)
                            .addComponent(btnCancelar))
                        .addGroup(panelContenedorLayout.createSequentialGroup()
                            .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panelContenedorLayout.createSequentialGroup()
                                    .addGap(43, 43, 43)
                                    .addComponent(labelConcepto)
                                    .addGap(18, 18, 18)
                                    .addComponent(comboConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(35, 35, 35)
                                    .addComponent(labelImporte))
                                .addGroup(panelContenedorLayout.createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addComponent(labelNFact)
                                    .addGap(18, 18, 18)
                                    .addComponent(campoFact, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelNRec))
                                .addGroup(panelContenedorLayout.createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addComponent(labelDescuento)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnDescuento)
                                    .addGap(76, 76, 76)
                                    .addComponent(labelImporteDesc)))
                            .addGap(26, 26, 26)
                            .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(campoImporteDesc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(campoImporte, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(campoNumRec, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(30, 30, 30))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(labelFecha))
                    .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(labelUsuario))
                    .addComponent(campoNumUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(labelCuenta))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(comboCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(labelConcepto))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(comboConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(labelImporte))
                    .addComponent(campoImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSA)
                    .addComponent(labelSaldo))
                .addGap(22, 22, 22)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(labelNFact))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(campoFact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoNumRec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelNRec)))
                .addGap(26, 26, 26)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDescuento)
                    .addComponent(campoImporteDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDescuento)
                            .addComponent(labelImporteDesc))))
                .addGap(25, 25, 25)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTotal)
                    .addComponent(labelMontoTotal))
                .addGap(50, 50, 50)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCuentaActionPerformed
        if(comboCuenta.getModel().getSize() > 0){
            campoImporte.setText("");
            importe = 0;
            descuento = 0;
            cuentaDC = ((modelos.Cuenta)comboCuenta.getSelectedItem()).getSaldoDC();
            cuentaComp = ((modelos.Cuenta)comboCuenta.getSelectedItem()).getSaldoComprobantes();
            comboConcepto.removeAllItems();
            if(cuentaDC > 0) comboConcepto.addItem("DERECHO DE CONEXIÓN");
            if(cuentaComp > 0) comboConcepto.addItem("COMPROBANTES ANTERIORES");
            labelSaldo.setText(comboConcepto.getSelectedItem().equals("DERECHO DE CONEXIÓN")?f.formatearNumero(cuentaDC):f.formatearNumero(cuentaComp));
            labelMontoTotal.setText(f.formatearNumero(importe));
            btnDescuento.setEnabled(false);
        }
    }//GEN-LAST:event_comboCuentaActionPerformed

    private void campoNumRecKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNumRecKeyTyped
        if(Validaciones.Longitud(campoNumRec, 10)) evt.consume();
        if(!Validaciones.Numeros(evt.getKeyChar())) evt.consume();
    }//GEN-LAST:event_campoNumRecKeyTyped

    private void campoNumRecKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNumRecKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(!Validaciones.longitudValida(campoNumRec.getText(), 10)){
                campoNumRec.requestFocus();
                return;
            }
            btnDescuento.requestFocus();
        }
    }//GEN-LAST:event_campoNumRecKeyPressed

    private void campoNumRecFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNumRecFocusLost
        if(!Validaciones.longitudValida(campoNumRec.getText(), 10)){
            campoNumRec.requestFocus();
            return;
        }
        else{
            if(dao.Pagos.existeNumFactura(campoNumRec.getText())){
                JOptionPane.showMessageDialog(null, "El número de recibo ya existe en la base de datos.", null, JOptionPane.ERROR_MESSAGE);
                campoNumRec.requestFocus();
                return;
            }
        }
    }//GEN-LAST:event_campoNumRecFocusLost

    private void comboConceptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboConceptoActionPerformed
        if(comboConcepto.getItemCount() > 0){
            labelSaldo.setText(comboConcepto.getSelectedItem().equals("DERECHO DE CONEXIÓN")?f.formatearNumero(cuentaDC):f.formatearNumero(cuentaComp));
            campoFact.setVisible(comboConcepto.getSelectedItem().equals("COMPROBANTES ANTERIORES"));
            labelNFact.setVisible(comboConcepto.getSelectedItem().equals("COMPROBANTES ANTERIORES"));
            campoNumRec.setVisible(comboConcepto.getSelectedItem().equals("DERECHO DE CONEXIÓN"));
            labelNRec.setVisible(comboConcepto.getSelectedItem().equals("DERECHO DE CONEXIÓN"));
            campoImporte.setText("");
            importe = tot = 0;
            labelMontoTotal.setText("0");
            campoFact.setText(comboConcepto.getSelectedItem().equals("DERECHO DE CONEXIÓN")?"":dao.Pagos.numeroFactura());
            campoNumRec.setText(comboConcepto.getSelectedItem().equals("DERECHO DE CONEXIÓN")?dao.Pagos.numeroRecibo():"");
        }
    }//GEN-LAST:event_comboConceptoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(campoFact.isVisible())
            if(!Validaciones.numeroFacturaValido(campoFact.getText())){campoFact.requestFocus(); return;}
        else if(campoNumRec.isVisible())
        if(!Validaciones.longitudValida(campoNumRec.getText(), 10)){campoNumRec.requestFocus(); return;}
        if(labelMontoTotal.getText().equals("0")){
            JOptionPane.showMessageDialog(null, "Monto a Pagar es 0.\nPulse \"Enter\" en el campo \"Importe\" para confirmar el importe ingresado.", "Atención", JOptionPane.WARNING_MESSAGE);
        }
        if(!f.validarDateChooser(campoFecha)) {campoFecha.requestFocusInWindow(); return;}
        if(campoUsuario.getText().isEmpty()){
            campoUsuario.requestFocus();
            return;
        }
        if(campoFact.getText().isEmpty()){
            campoFact.requestFocus();
            return;
        }
        if(campoImporte.getText().isEmpty()){
            campoImporte.requestFocus();
            return;
        }
        if(btnDescuento.isSelected()){
            if(campoImporteDesc.getText().isEmpty()){
                campoImporteDesc.requestFocus();
                return;
            }
        }
        tot = importe - descuento;
        p = new modelos.Pago();
        p.setFechaPago(campoFecha.getDate());
        p.setTotal(importe - descuento);
        p.setNumFactura(campoFact.isVisible()?campoFact.getText():campoNumRec.getText());
        p.setIdLote(idLote);
        p.setIdUsuario(campoNumUsuario.getText());

        if(campoFact.isVisible()){
            generarFactura();
        }
        else generarRecibo();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void campoImporteDescKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoImporteDescKeyTyped
        if(Validaciones.Longitud(campoImporteDesc, 11)) evt.consume();
        if(!Validaciones.Numeros(evt.getKeyChar())) evt.consume();
    }//GEN-LAST:event_campoImporteDescKeyTyped

    private void campoImporteDescKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoImporteDescKeyPressed
        campoImporteDesc.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, java.util.Collections.EMPTY_SET);
        if(evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB){
            if(campoImporteDesc.getText().equals("")) return;
            else{
                if(Integer.parseInt(campoImporteDesc.getText().replace(".", "")) >= importe){
                    JOptionPane.showMessageDialog(null, "El importe es menor o igual al descuento.", "Atención", JOptionPane.WARNING_MESSAGE);
                    campoImporteDesc.requestFocus();
                }
                else {
                    descuento = Integer.parseInt(campoImporteDesc.getText());
                    importe = Integer.parseInt(campoImporte.getText().replace(".", ""));
                    campoImporteDesc.setText(f.formatearNumero(descuento));
                    labelMontoTotal.setText(f.formatearNumero(importe-descuento));
                    btnGuardar.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_campoImporteDescKeyPressed

    private void campoImporteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoImporteKeyTyped
        if(Validaciones.Longitud(campoImporte, 11)) evt.consume();
        if(!Validaciones.Numeros(evt.getKeyChar())) evt.consume();
    }//GEN-LAST:event_campoImporteKeyTyped

    private void campoImporteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoImporteKeyPressed
        campoImporte.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, java.util.Collections.EMPTY_SET);
        if(evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB){
            if(campoImporte.getText().equals("")) return;
            if(Integer.parseInt(campoImporte.getText().replace(".", "")) > Integer.parseInt(labelSaldo.getText().replace(".", ""))) {JOptionPane.showMessageDialog(null, "El importe ingresado es mayor al monto total pendiente de pago.", "Atención", JOptionPane.WARNING_MESSAGE); return;}
            btnDescuento.setEnabled(true);
            btnGuardar.setEnabled(true);
            importe = Integer.parseInt(campoImporte.getText().replace(".", ""));
            switch(comboConcepto.getSelectedItem().toString()){
                case "DERECHO DE CONEXIÓN":
                    campoNumRec.requestFocus();
                    break;
                case "COMPROBANTES ANTERIORES":
                    campoFact.requestFocus();
                    break;
            }
            campoImporte.setText(f.formatearNumero(importe));
            labelMontoTotal.setText(f.formatearNumero(importe));
        }
    }//GEN-LAST:event_campoImporteKeyPressed

    private void campoImporteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoImporteFocusGained
        if(campoImporte.getText().length()>0)
        campoImporte.setText(campoImporte.getText().replace(".", ""));
    }//GEN-LAST:event_campoImporteFocusGained

    private void btnDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescuentoActionPerformed
        btnDescuento.setText(btnDescuento.isSelected()?"Sí":"No");
        labelImporteDesc.setVisible(btnDescuento.isSelected());
        campoImporteDesc.setVisible(btnDescuento.isSelected());
        if(btnDescuento.isSelected()){
            switch(u.getTipodesc()){
                case "NINGUNO":
                break;
                case "PORCENTAJE":
                System.out.println("Descuento: "+u.getMontoDescuento());
                java.math.BigDecimal total = new java.math.BigDecimal(java.math.BigDecimal.valueOf(tot).toString()).multiply(
                    ((java.math.BigDecimal.valueOf(u.getMontoDescuento()).divide(java.math.BigDecimal.valueOf(100)))));
                descuento = total.setScale(0, java.math.RoundingMode.HALF_UP).intValueExact();
                break;
                case "MONTO":
                System.out.println("Descuento: "+u.getMontoDescuento());
                descuento = u.getMontoDescuento();
                break;
            }
            campoImporteDesc.setText(String.valueOf(descuento));
            if(importe <= descuento) {
                JOptionPane.showMessageDialog(null, "El importe es menor o igual al descuento.", "Atención", JOptionPane.WARNING_MESSAGE);
                campoImporteDesc.requestFocus();
            }
            else labelMontoTotal.setText(f.formatearNumero(importe-descuento));
        }
        else{
            labelMontoTotal.setText(f.formatearNumero(importe));
            descuento = 0;
        }
    }//GEN-LAST:event_btnDescuentoActionPerformed

    private void campoFactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoFactKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB){
            if(dao.Pagos.existeNumFactura(campoFact.getText())){
                JOptionPane.showMessageDialog(null, "El número de factura ya existe en la base de datos.", null, JOptionPane.ERROR_MESSAGE);
                campoFact.requestFocus();
            }
            else campoFact.transferFocus();
        }
    }//GEN-LAST:event_campoFactKeyPressed

    private void campoFactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoFactFocusLost
        if(!campoFact.getText().equals("")){
            if(dao.Pagos.existeNumFactura(campoFact.getText())){
                JOptionPane.showMessageDialog(null, "El número de factura ya existe en la base de datos.", null, JOptionPane.ERROR_MESSAGE);
                campoFact.requestFocus();
            }
        }
    }//GEN-LAST:event_campoFactFocusLost

    private void campoNumUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNumUsuarioKeyTyped
        if(Validaciones.Longitud(campoNumUsuario, 11)) evt.consume();
        if(!Validaciones.Numeros(evt.getKeyChar()) && !Validaciones.Espacio(evt.getKeyChar())) evt.consume();
    }//GEN-LAST:event_campoNumUsuarioKeyTyped

    private void campoNumUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNumUsuarioKeyPressed
        campoNumUsuario.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, java.util.Collections.EMPTY_SET);
        if(evt.getKeyCode()==KeyEvent.VK_ENTER || evt.getKeyCode()==KeyEvent.VK_TAB){
            u = null;
            validarUsuario();
        }
    }//GEN-LAST:event_campoNumUsuarioKeyPressed

    private void campoFechaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoFechaKeyPressed
        campoFecha.getDateEditor().getUiComponent().setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, java.util.Collections.EMPTY_SET);
        if(evt.getKeyCode() == KeyEvent.VK_TAB) campoNumUsuario.requestFocusInWindow();
    }//GEN-LAST:event_campoFechaKeyPressed

    private void campoImporteDescFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoImporteDescFocusGained
        if(campoImporteDesc.getText().length()>0)
        campoImporteDesc.setText(campoImporteDesc.getText().replace(".", ""));
    }//GEN-LAST:event_campoImporteDescFocusGained

    void validarUsuario(){
        if(campoNumUsuario.getText().isEmpty()){
            campoUsuario.requestFocus();
        }
        else{
            u = new dao.Usuarios().obtenerUsuarioPorId(Integer.parseInt(campoNumUsuario.getText()));
            if(u == null){
                JOptionPane.showMessageDialog(null, "El código de usuario no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                campoUsuario.setText("");
                campoNumUsuario.requestFocus();
                f.limpiarCampos(panelContenedor);
                comboCuenta.removeAllItems();
                comboCuenta.setEnabled(false);
                comboConcepto.removeAllItems();
                campoFact.setEnabled(false);
                comboConcepto.setEnabled(false);
                campoImporte.setEnabled(false);
                btnDescuento.setEnabled(false);
                descuento = 0;
                importe = 0;
                campoFact.setValue(null);
                cuentaDC = cuentaComp = 0;
                labelSaldo.setText("0");
                labelMontoTotal.setText(f.formatearNumero(importe));
                btnGuardar.setEnabled(false);
                return;
            }
            else{
                campoUsuario.setText(String.format("%s %s", u.getNombre(), u.getApellido()));
                List<modelos.Cuenta> cm = cuentas.cuentasConPendientes(Integer.parseInt(campoNumUsuario.getText()));
                if(cm.size() > 0){
                    comboCuenta.setEnabled(true);
                    comboCuenta.setModel(new javax.swing.DefaultComboBoxModel(cm.toArray()));
                    comboConcepto.removeAllItems();
                    cuentaDC = ((modelos.Cuenta)comboCuenta.getSelectedItem()).getSaldoDC();
                    cuentaComp = ((modelos.Cuenta)comboCuenta.getSelectedItem()).getSaldoComprobantes();
                    if(cuentaDC > 0) comboConcepto.addItem("DERECHO DE CONEXIÓN");
                    if(cuentaComp > 0) comboConcepto.addItem("COMPROBANTES ANTERIORES");
                    labelSaldo.setText(comboConcepto.getSelectedItem().equals("DERECHO DE CONEXIÓN")?f.formatearNumero(cuentaDC):f.formatearNumero(cuentaComp));
                    campoFact.setEnabled(true);
                    comboConcepto.setEnabled(true);
                    campoImporte.setEnabled(true);
                    campoNumUsuario.transferFocus();
                    descuento = 0;
                    importe = 0;
                }
                else{
                    JOptionPane.showMessageDialog(null, "El usuario no tiene cuentas pendientes de pago.", "Atención", JOptionPane.WARNING_MESSAGE);
                    f.limpiarCampos(panelContenedor);
                    campoFecha.setDate(new java.util.Date());
                    campoUsuario.requestFocus();
                    comboCuenta.removeAllItems();
                    comboConcepto.removeAllItems();
                    comboCuenta.setEnabled(false);
                    campoFact.setEnabled(false);
                    campoFact.setValue(null);
                    comboConcepto.setEnabled(false);
                    campoImporte.setEnabled(false);
                    btnDescuento.setEnabled(false);
                    descuento = 0;
                    importe = 0;
                    cuentaDC = cuentaComp = 0;
                    labelSaldo.setText("0");
                    labelMontoTotal.setText(f.formatearNumero(importe));
                    btnGuardar.setEnabled(false);
                }
            }
        }
    }
    
    private void generarFactura(){
        modelos.DetallePago dp = new modelos.DetallePago();
        dp.setCantidad(1);
        dp.setConcepto(comboConcepto.getSelectedItem().toString());
        dp.setSubtotal(tot);
        dp.setTipoIVA(10);
        dp.setMontoDescuento(descuento);
        dp.setTipoPago("ANTERIORES");
        dp.setIdCuenta(((modelos.Cuenta)comboCuenta.getSelectedItem()).getIdentificador());

        List<modelos.Factura> df = new ArrayList<>();
        modelos.Factura n = new modelos.Factura();
        n.setCodDetalle(null);
        n.setCantDetalle(1);
        n.setDescDetalle("PAGO POR CONSUMO");
        n.setPrecioUnitDetalle(tot);
        n.setExentaDetalle(null);
        n.setcDetalle(null);
        n.setdDetalle(tot);
        df.add(n);
        
        reportes.Factura fact = new reportes.Factura();
        fact.mostrarFacturax(campoFact.getText().substring(campoFact.getText().lastIndexOf("-")+1), campoFecha.getDate(), 
        campoUsuario.getText(), u.getDireccion(), u.getNumDocumento(), importe-descuento, df);
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Confirma que los datos ingresados son correctos?", "Confirmar pago", 
                                   JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
        switch(respuesta){
            case -1:
            case JOptionPane.NO_OPTION: 
                break;
            case JOptionPane.YES_OPTION:{
                if(fact.getVisor() != null && fact.getVisor().isShowing()) fact.getVisor().dispose();
                dao.Pagos pago = new dao.Pagos();
                if(pago.insertarPagoMulti(p, dp) && dao.Cuentas.actualizarCuentaComp(((modelos.Cuenta)comboCuenta.getSelectedItem()).getIdentificador(), importe)){
                    JOptionPane.showMessageDialog(null, "Se ha registrado la transacción con éxito.", "Transacción Exitosa", JOptionPane.INFORMATION_MESSAGE);
                    if(!fact.imprimir("fni")){
                        JOptionPane.showMessageDialog(null, "No se pudo imprimir. Se guardó una copia de la factura.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    ((TablaPagos)tablaPagosxLote.getModel()).limpiar();
                    ((TablaPagos)tablaPagosxLote.getModel()).setPagos(dao.Pagos.listarPagosxLotes(idLote));
                    ((TablaLotePagos)tablaPagos.getModel()).limpiar();
                    ((TablaLotePagos)tablaPagos.getModel()).setPagos(dao.Pagos.listarLotesPagos());
                    dispose();
                }
                else JOptionPane.showMessageDialog(null, "No se ha podido registrar la transacción. Por favor, inténtelo de nuevo más tarde.", "Ocurrió un error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    void generarRecibo(){
        modelos.DetallePago dp = new modelos.DetallePago();
        dp.setCantidad(1);
        dp.setConcepto(comboConcepto.getSelectedItem().toString());
        dp.setSubtotal(Integer.parseInt(campoImporte.getText().replace(".", "")));
        dp.setTipoIVA(0);
        dp.setMontoDescuento(descuento);
        dp.setTipoPago("DERCONEX");
        dp.setIdCuenta(((modelos.Cuenta)comboCuenta.getSelectedItem()).getIdentificador());
        List<modelos.Recibo> re = new ArrayList<>();
        modelos.Recibo n = new modelos.Recibo();
        n.setFecha(utilidades.Estaticos.FORMATODMA.format(campoFecha.getDate()));
        n.setConceptoRec(comboConcepto.getSelectedItem().toString().concat(".-"));
        n.setImporteRecibo(Integer.parseInt(campoImporte.getText().replace(".", "")));
        n.setNombreRec(campoUsuario.getText());
        n.setSumaRec(new utilidades.NumeroALetras().Convertir(importe.toString(), true)+" GUARANÍES");
        re.add(n);
        
        reportes.Recibo fact = new reportes.Recibo();
        fact.mostrarRecibo(campoNumRec.getText(), re);
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Confirma que los datos ingresados son correctos?", "Confirmar pago", 
                                   JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
            switch(respuesta){
                case -1:
                case JOptionPane.NO_OPTION: 
                    break;
                case JOptionPane.YES_OPTION:{
                    if(fact.getVisor() != null && fact.getVisor().isShowing()) fact.getVisor().dispose();
                    dao.Pagos pago = new dao.Pagos();
                    if(pago.insertarPagoMulti(p, dp) && dao.Cuentas.actualizarCuentaDC(((modelos.Cuenta)comboCuenta.getSelectedItem()).getIdentificador(), importe)){
                        JOptionPane.showMessageDialog(null, "Se ha registrado la transacción con éxito.", "Transacción Exitosa", JOptionPane.INFORMATION_MESSAGE);
                        if(!fact.imprimir("otros")){
                            JOptionPane.showMessageDialog(null, "No se pudo imprimir. Se guardó una copia del recibo.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        ((TablaPagos)tablaPagosxLote.getModel()).limpiar();
                        ((TablaPagos)tablaPagosxLote.getModel()).setPagos(dao.Pagos.listarPagosxLotes(idLote));
                        ((TablaLotePagos)tablaPagos.getModel()).limpiar();
                        ((TablaLotePagos)tablaPagos.getModel()).setPagos(dao.Pagos.listarLotesPagos());
                        dispose();
                    }
                    else JOptionPane.showMessageDialog(null, "No se ha podido registrar la transacción. Por favor, inténtelo de nuevo más tarde.", "Ocurrió un error", JOptionPane.ERROR_MESSAGE);
                }
            }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JToggleButton btnDescuento;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JFormattedTextField campoFact;
    private com.toedter.calendar.JDateChooser campoFecha;
    private javax.swing.JTextField campoImporte;
    private javax.swing.JTextField campoImporteDesc;
    private javax.swing.JTextField campoNumRec;
    private javax.swing.JTextField campoNumUsuario;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JComboBox<String> comboConcepto;
    private javax.swing.JComboBox<modelos.Cuenta> comboCuenta;
    private javax.swing.JLabel labelConcepto;
    private javax.swing.JLabel labelCuenta;
    private javax.swing.JLabel labelDescuento;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelImporte;
    private javax.swing.JLabel labelImporteDesc;
    private javax.swing.JLabel labelMontoTotal;
    private javax.swing.JLabel labelNFact;
    private javax.swing.JLabel labelNRec;
    private javax.swing.JLabel labelSA;
    private javax.swing.JLabel labelSaldo;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPanel panelContenedor;
    // End of variables declaration//GEN-END:variables
}
