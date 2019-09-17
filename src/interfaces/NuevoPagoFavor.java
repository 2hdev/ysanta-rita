package interfaces;

import clases.tablas.TablaLotePagos;
import clases.tablas.TablaPagos;
import static interfaces.ListaFacturasxLotes.tablaPagosxLote;
import static interfaces.ListaPagos.tablaPagos;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import utilidades.Funciones;
import utilidades.Validaciones;
import java.util.logging.Logger;
import java.util.logging.Level;

public class NuevoPagoFavor extends javax.swing.JInternalFrame {

    dao.Cuentas cuentas = new dao.Cuentas();
    modelos.Usuario u;
    modelos.Pago p = new modelos.Pago();
    private JButton boton; private final String idLote;
    Funciones f = new Funciones();
    Integer afavor, importe = 0;
    
    public NuevoPagoFavor(JButton boton, String idLote) {
        initComponents();
        this.boton = boton;
        this.idLote = idLote;
        f.agregarPlaceHolder(((javax.swing.JTextField)campoFecha.getDateEditor().getUiComponent()), "dd/MM/aaaa");
        campoFecha.setDate(new java.util.Date());
        campoFact.setText(dao.Pagos.numeroFactura());
    }
    
    @Override
    public void dispose() {
        ((TablaPagos)tablaPagosxLote.getModel()).limpiar();
        ((TablaPagos)tablaPagosxLote.getModel()).setPagos(dao.Pagos.listarPagosxLotes(idLote));
        ((TablaLotePagos)tablaPagos.getModel()).limpiar();
        ((TablaLotePagos)tablaPagos.getModel()).setPagos(dao.Pagos.listarLotesPagos());
        boton.setEnabled(true);
        super.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelFecha = new javax.swing.JLabel();
        campoFecha = new com.toedter.calendar.JDateChooser();
        labelUsuario = new javax.swing.JLabel();
        campoNumUsuario = new javax.swing.JTextField();
        campoUsuario = new javax.swing.JTextField();
        labelMedidor = new javax.swing.JLabel();
        comboCuenta = new javax.swing.JComboBox();
        labelSA = new javax.swing.JLabel();
        labelSaldo = new javax.swing.JLabel();
        campoImporte = new javax.swing.JTextField();
        labelImporteDesc = new javax.swing.JLabel();
        campoFact = new javax.swing.JFormattedTextField();
        labelNFact = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Saldo a Favor");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/y_mini.png"))); // NOI18N

        labelFecha.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelFecha.setText("Fecha:");

        campoFecha.setDateFormatString("dd/MM/yyyy");
        campoFecha.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoFecha.setMaxSelectableDate(new java.util.Date(32503694508000L));
        campoFecha.setMinSelectableDate(new java.util.Date(-2208974960000L));
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

        labelMedidor.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelMedidor.setText("Cuenta Nº:");

        comboCuenta.setEnabled(false);
        comboCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCuentaActionPerformed(evt);
            }
        });

        labelSA.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelSA.setText("Saldo a Favor Actual:");
        labelSA.setEnabled(false);

        labelSaldo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelSaldo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelSaldo.setText("0");
        labelSaldo.setEnabled(false);

        campoImporte.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoImporte.setEnabled(false);
        campoImporte.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoImporteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoImporteFocusLost(evt);
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

        labelNFact.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelNFact.setText("Factura Nº :");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelFecha, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelMedidor, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelNFact, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(145, 145, 145))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelSA)
                                .addGap(62, 62, 62)
                                .addComponent(labelSaldo))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(campoNumUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(campoFact, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                                .addComponent(labelImporteDesc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(labelFecha)
                    .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(labelUsuario)
                    .addComponent(campoNumUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMedidor)
                    .addComponent(comboCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSA)
                    .addComponent(labelSaldo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(labelNFact)
                    .addComponent(campoFact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelImporteDesc)
                        .addComponent(campoImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoFechaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoFechaKeyPressed
        campoFecha.getDateEditor().getUiComponent().setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, java.util.Collections.EMPTY_SET);
        if(evt.getKeyCode() == KeyEvent.VK_TAB) campoNumUsuario.requestFocusInWindow();
    }//GEN-LAST:event_campoFechaKeyPressed

    private void campoNumUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNumUsuarioKeyPressed
        campoNumUsuario.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, java.util.Collections.EMPTY_SET);
        if(evt.getKeyCode()==KeyEvent.VK_ENTER || evt.getKeyCode()==KeyEvent.VK_TAB){
            u = null;
            validarUsuario();
        }
    }//GEN-LAST:event_campoNumUsuarioKeyPressed

    private void campoNumUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNumUsuarioKeyTyped
        if(Validaciones.Longitud(campoNumUsuario, 11)) evt.consume();
        if(!Validaciones.Numeros(evt.getKeyChar()) && !Validaciones.Espacio(evt.getKeyChar())) evt.consume();
    }//GEN-LAST:event_campoNumUsuarioKeyTyped

    private void comboCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCuentaActionPerformed
        if(u!= null && comboCuenta.getItemCount() > 0){
            afavor = ((modelos.Cuenta)comboCuenta.getSelectedItem()).getSaldoAFavor();
            labelSaldo.setText(f.formatearNumero(afavor));
        }
    }//GEN-LAST:event_comboCuentaActionPerformed

    private void campoImporteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoImporteFocusLost
        if(!campoImporte.getText().isEmpty()){
            f.formatearNumero(campoImporte);
        }
    }//GEN-LAST:event_campoImporteFocusLost

    private void campoImporteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoImporteKeyPressed
        campoImporte.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, java.util.Collections.EMPTY_SET);
        if(evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB){
            if(campoImporte.getText().equals("") || campoImporte.getText().isEmpty()) return;
            else {btnGuardar.setEnabled(true); btnGuardar.requestFocus();}
        }
    }//GEN-LAST:event_campoImporteKeyPressed

    private void campoImporteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoImporteKeyTyped
        if(Validaciones.Longitud(campoImporte, 11)) evt.consume();
        if(!Validaciones.Numeros(evt.getKeyChar())) evt.consume();
    }//GEN-LAST:event_campoImporteKeyTyped

    private void campoFactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoFactFocusLost
        if(!campoFact.getText().equals("")){
            if(dao.Pagos.existeNumFactura(campoFact.getText())){
                JOptionPane.showMessageDialog(null, "El número de factura ya existe en la base de datos.", null, JOptionPane.ERROR_MESSAGE);
                campoFact.requestFocus();
            }
        }
    }//GEN-LAST:event_campoFactFocusLost

    private void campoFactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoFactKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB){
            if(dao.Pagos.existeNumFactura(campoFact.getText())){
                JOptionPane.showMessageDialog(null, "El número de factura ya existe en la base de datos.", null, JOptionPane.ERROR_MESSAGE);
                campoFact.requestFocus();
            }
            else campoFact.transferFocus();
        }
    }//GEN-LAST:event_campoFactKeyPressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(!Validaciones.numeroFacturaValido(campoFact.getText())){campoFact.requestFocus(); return;}
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
        
        importe = Integer.parseInt(campoImporte.getText().replace(".", ""));
        
        p = new modelos.Pago();
        p.setFechaPago(campoFecha.getDate());
        p.setTotal(importe);
        p.setNumFactura(campoFact.getText());
        p.setIdLote(idLote);
        p.setIdUsuario(campoNumUsuario.getText());

        generarFactura();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void campoImporteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoImporteFocusGained
        if(campoImporte.getText().length()>0)
            campoImporte.setText(campoImporte.getText().replace(".", ""));
    }//GEN-LAST:event_campoImporteFocusGained

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
                comboCuenta.removeAllItems();
                comboCuenta.setEnabled(false);
                campoFact.setEnabled(false);
                campoImporte.setEnabled(false);
                importe = 0;
                campoFact.setValue(null);
                labelSaldo.setText("0");
                btnGuardar.setEnabled(false);
                return;
            }
            else{
                campoUsuario.setText(u.getNombre()+" "+u.getApellido());
                List<modelos.Cuenta> cm = cuentas.cuentasSaldo(Integer.parseInt(campoNumUsuario.getText()));
                if(cm.size() > 0){
                    comboCuenta.setEnabled(true);
                    comboCuenta.setModel(new javax.swing.DefaultComboBoxModel(cm.toArray()));
                    afavor = ((modelos.Cuenta)comboCuenta.getSelectedItem()).getSaldoAFavor();
                    labelSaldo.setText(f.formatearNumero(afavor));
                    campoFact.setEnabled(true);
                    campoFact.setText(dao.Pagos.numeroFactura());
                    campoImporte.setEnabled(true);
                    campoNumUsuario.transferFocus();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Ninguna cuenta está vinculada al usuario actualmente o este aún cuenta con cuentas pendientes de pago.", "Atención", JOptionPane.WARNING_MESSAGE);
                    campoFecha.setDate(new java.util.Date());
                    campoUsuario.requestFocus();
                    comboCuenta.removeAllItems();
                    comboCuenta.setEnabled(false);
                    campoFact.setEnabled(false);
                    campoFact.setValue(null);
                    campoImporte.setEnabled(false);
                    labelSaldo.setText("0");
                    btnGuardar.setEnabled(false);
                    importe = 0;
                }
            }
        }
    }
    
    void generarFactura(){
        modelos.DetallePago dp = new modelos.DetallePago();
        dp.setCantidad(1);
        dp.setConcepto("PAGO POR ADELANTADO POR CONSUMO DE AGUA");
        dp.setSubtotal(importe);
        dp.setTipoIVA(10);
        dp.setMontoDescuento(0);
        dp.setTipoPago("ADELANTADO");
        dp.setIdCuenta(((modelos.Cuenta)comboCuenta.getSelectedItem()).getIdentificador());

        List<modelos.Factura> df = new ArrayList<>();
        modelos.Factura n = new modelos.Factura();
        n.setCodDetalle(null);
        n.setCantDetalle(1);
        n.setDescDetalle("PAGO POR ADELANTADO POR CONSUMO DE AGUA");
        n.setPrecioUnitDetalle(importe);
        n.setExentaDetalle(null);
        n.setcDetalle(null);
        n.setdDetalle(importe);
        df.add(n);

        reportes.Factura fact = new reportes.Factura();
        fact.mostrarFacturax(campoFact.getText().substring(campoFact.getText().lastIndexOf("-")+1), campoFecha.getDate(), 
        campoUsuario.getText(), u.getDireccion(), u.getNumDocumento(), importe, df);
        
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Confirma que los datos ingresados son correctos?", "Confirmar pago", 
                                   JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
        switch(respuesta){
            case -1:
            case JOptionPane.NO_OPTION: 
                break;
            case JOptionPane.YES_OPTION:{
                if(fact.getVisor() != null && fact.getVisor().isShowing()) fact.getVisor().dispose();
                dao.Pagos pago = new dao.Pagos();
                if(pago.insertarPagoMulti(p, dp) && dao.Cuentas.actualizarSaldoAFavor(((modelos.Cuenta)comboCuenta.getSelectedItem()).getIdentificador(), importe, true)){
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
                else JOptionPane.showMessageDialog(null, "No se ha podido registrar los datos.", "Ocurrió un error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JFormattedTextField campoFact;
    private com.toedter.calendar.JDateChooser campoFecha;
    private javax.swing.JTextField campoImporte;
    private javax.swing.JTextField campoNumUsuario;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JComboBox comboCuenta;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelImporteDesc;
    private javax.swing.JLabel labelMedidor;
    private javax.swing.JLabel labelNFact;
    private javax.swing.JLabel labelSA;
    private javax.swing.JLabel labelSaldo;
    private javax.swing.JLabel labelUsuario;
    // End of variables declaration//GEN-END:variables
}
