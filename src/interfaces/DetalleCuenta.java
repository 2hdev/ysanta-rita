package interfaces;

import clases.tablas.TablaCuentas;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import utilidades.Funciones;
import utilidades.Validaciones;

public class DetalleCuenta extends javax.swing.JDialog {
    
    Funciones f;
    private final modelos.Cuenta cuenta;
    dao.Cuentas c;
    modelos.Medidor m;
    modelos.Usuario u;
    
    public DetalleCuenta(javax.swing.JInternalFrame parent, boolean modal, modelos.Cuenta cuenta) {
        f = new Funciones();
        this.cuenta = dao.Cuentas.obtenerSaldos(cuenta);
        c = new dao.Cuentas();
        initComponents();
        utilidades.Funciones.cerrarConEscape(DetalleCuenta.this);
        f.inhabilitarCampos(panelContenedor);
        campoCodigo.setText(String.valueOf(cuenta.getIdentificador()));
        campoNumUsuario.setText(String.valueOf(cuenta.getUsuario()));
        u = new dao.Usuarios().obtenerUsuarioPorId(Integer.parseInt(campoNumUsuario.getText()));
        campoUsuario.setText(u.getNombre()+" "+u.getApellido());
        campoDerconex.setText(f.formatearNumero(cuenta.getSaldoDC()));
        campoCompAnt.setText(f.formatearNumero(cuenta.getSaldoComprobantes()));
        campoFavor.setText(f.formatearNumero(cuenta.getSaldoAFavor()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        labelNumMedidor = new javax.swing.JLabel();
        campoCodigo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        labelUsuario = new javax.swing.JLabel();
        campoNumUsuario = new javax.swing.JTextField();
        campoUsuario = new javax.swing.JTextField();
        labelDerconex = new javax.swing.JLabel();
        campoDerconex = new javax.swing.JTextField();
        labelCompAnt = new javax.swing.JLabel();
        campoCompAnt = new javax.swing.JTextField();
        labelFavor = new javax.swing.JLabel();
        campoFavor = new javax.swing.JTextField();
        Sep1 = new javax.swing.JSeparator();
        labelMedidor = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaMedidores = cuenta.getMedidores() != null ? new javax.swing.JList(cuenta.getMedidores().toArray()) : new javax.swing.JList();
        btnVer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalle de Cuenta");
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setResizable(false);

        panelContenedor.setToolTipText("");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(utilidades.Estaticos.ICONO)));

        labelNumMedidor.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelNumMedidor.setText("Cuenta Nº:");

        campoCodigo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoCodigo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        campoCodigo.setEnabled(false);
        campoCodigo.setName("numero_med"); // NOI18N

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

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        btnEditar.setToolTipText("Editar Cuenta");
        btnEditar.setBorderPainted(false);
        btnEditar.setContentAreaFilled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        labelUsuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelUsuario.setText("Asignada al Usuario:");

        campoNumUsuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoNumUsuario.setName("id_usuario"); // NOI18N
        campoNumUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoNumUsuarioFocusLost(evt);
            }
        });
        campoNumUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNumUsuarioActionPerformed(evt);
            }
        });
        campoNumUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNumUsuarioKeyTyped(evt);
            }
        });

        campoUsuario.setEditable(false);
        campoUsuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoUsuario.setEnabled(false);

        labelDerconex.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelDerconex.setText("<html>Deuda por <br>Derecho de Conexión:</html>");

        campoDerconex.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoDerconex.setName("saldoderechoconex"); // NOI18N
        campoDerconex.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoDerconexFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoDerconexFocusLost(evt);
            }
        });
        campoDerconex.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoDerconexKeyTyped(evt);
            }
        });

        labelCompAnt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelCompAnt.setText("<html>Deuda por <br>Comprobantes Anteriores:</html>");

        campoCompAnt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoCompAnt.setName("saldocomprobantes"); // NOI18N
        campoCompAnt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoCompAntFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoCompAntFocusLost(evt);
            }
        });
        campoCompAnt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoCompAntKeyTyped(evt);
            }
        });

        labelFavor.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelFavor.setText("Saldo a Favor:");

        campoFavor.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoFavor.setName("saldoafavor"); // NOI18N
        campoFavor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoFavorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoFavorFocusLost(evt);
            }
        });
        campoFavor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoFavorKeyTyped(evt);
            }
        });

        labelMedidor.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelMedidor.setText("Medidores Asignados:");

        listaMedidores.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        listaMedidores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaMedidores.setToolTipText("Modifique los datos de este campo desde el módulo \"Medidores\".");
        jScrollPane2.setViewportView(listaMedidores);

        btnVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ver.png"))); // NOI18N
        btnVer.setToolTipText("Ver Resumen de Cuenta");
        btnVer.setBorderPainted(false);
        btnVer.setContentAreaFilled(false);
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorLayout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(labelFavor)
                .addGap(18, 18, 18)
                .addComponent(campoFavor, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200))
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNumMedidor)
                            .addGroup(panelContenedorLayout.createSequentialGroup()
                                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(labelUsuario)
                                    .addComponent(labelDerconex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelContenedorLayout.createSequentialGroup()
                                        .addComponent(campoDerconex, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(22, 22, 22)
                                        .addComponent(labelCompAnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(campoCompAnt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelContenedorLayout.createSequentialGroup()
                                        .addComponent(campoNumUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelContenedorLayout.createSequentialGroup()
                                        .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(271, 271, 271)
                                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelContenedorLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(labelMedidor)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelContenedorLayout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar))
                            .addComponent(Sep1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelNumMedidor)
                        .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEditar))
                .addGap(30, 30, 30)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(campoNumUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUsuario))
                .addGap(30, 30, 30)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelDerconex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoDerconex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCompAnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCompAnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFavor)
                    .addComponent(campoFavor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(Sep1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelMedidor)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnVer, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(33, 33, 33)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addGap(30, 30, 30))
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
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        f.habilitarCampos(panelContenedor);
        campoCodigo.setEnabled(false);
        campoUsuario.setEnabled(false);
        btnGuardar.setEnabled(true);
        boolean pagodc = c.verificarPago("DERCONEX", cuenta.getIdentificador());
        campoDerconex.setEnabled(!pagodc);
        campoDerconex.setToolTipText(pagodc?"Este campo está deshabilitado porque ya se realizó un pago relacionado al derecho de conexión de esta cuenta.":null);
        boolean pagoactual = c.verificarPago("ANTERIORES", cuenta.getIdentificador());
        campoCompAnt.setEnabled(!pagoactual);
        campoCompAnt.setToolTipText(pagoactual?"Este campo está deshabilitado porque ya se realizó un pago relacionado a las deudas (anteriores a los generados por el sistema \"Y\") de esta cuenta.":null);
        boolean pagoadel = c.verificarPago("ADELANTADO", cuenta.getIdentificador());
        campoFavor.setEnabled(!pagoadel);
        campoFavor.setToolTipText(pagoadel?"Este campo está deshabilitado porque ya se realizó un pago relacionado al saldo a favor de esta cuenta.":null);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(!f.recorrerYValidar(panelContenedor)) return;       
        java.util.Map cambios = new java.util.HashMap();
        if(u.getIdentificador() != cuenta.getUsuario()){cambios.put(String.format("%s=?", campoNumUsuario.getName()), u.getIdentificador());}
        if(!String.valueOf(cuenta.getSaldoComprobantes()).equals(campoCompAnt.getText().replace(".", ""))) {cambios.put(String.format("%s=?", campoCompAnt.getName()), campoCompAnt.getText().replace(".", ""));}
        if(!String.valueOf(cuenta.getSaldoAFavor()).equals(campoFavor.getText().replace(".", ""))) {cambios.put(String.format("%s=?", campoFavor.getName()), campoFavor.getText().replace(".", ""));}
        if(!String.valueOf(cuenta.getSaldoDC()).equals(campoDerconex.getText().replace(".", ""))) {cambios.put(String.format("%s=?", campoDerconex.getName()), campoDerconex.getText().replace(".", ""));}
        if(cambios.size() >0){
            if(c.actualizarCuenta(cambios, cuenta.getIdentificador())){
                JOptionPane.showMessageDialog(null, "Se han actualizado los datos de la cuenta correctamente.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                ListaCuentas.tc = new TablaCuentas(dao.Cuentas.obtenerCuentasYMedidores());
                ((TablaCuentas)ListaCuentas.tablaCuentas.getModel()).limpiar();
                ListaCuentas.tablaCuentas.setModel(ListaCuentas.tc);
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Ocurrió un error intentando actualizar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void campoNumUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNumUsuarioFocusLost
        validarUsuario();
    }//GEN-LAST:event_campoNumUsuarioFocusLost

    private void campoNumUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNumUsuarioActionPerformed
        campoNumUsuario.transferFocus();
    }//GEN-LAST:event_campoNumUsuarioActionPerformed

    private void campoNumUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNumUsuarioKeyTyped
        if(Validaciones.Longitud(campoNumUsuario, 11)) evt.consume();
        if(!Validaciones.Numeros(evt.getKeyChar())) evt.consume();
    }//GEN-LAST:event_campoNumUsuarioKeyTyped

    private void campoDerconexFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoDerconexFocusGained
        if(campoDerconex.getText().length()>0)
        campoDerconex.setText(campoDerconex.getText().replace(".", ""));
    }//GEN-LAST:event_campoDerconexFocusGained

    private void campoDerconexFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoDerconexFocusLost
        if(campoDerconex.getText().length()>0)
        f.formatearNumero(campoDerconex);
        else campoDerconex.setText("0");
    }//GEN-LAST:event_campoDerconexFocusLost

    private void campoDerconexKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDerconexKeyTyped
        if(Validaciones.Longitud(campoDerconex, 11)) evt.consume();
        if(!Validaciones.Numeros(evt.getKeyChar())) evt.consume();
    }//GEN-LAST:event_campoDerconexKeyTyped

    private void campoCompAntFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCompAntFocusGained
        if(campoCompAnt.getText().length()>0)
        campoCompAnt.setText(campoCompAnt.getText().replace(".", ""));
    }//GEN-LAST:event_campoCompAntFocusGained

    private void campoCompAntFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCompAntFocusLost
        if(campoCompAnt.getText().length()>0)
        f.formatearNumero(campoCompAnt);
        else campoCompAnt.setText("0");
    }//GEN-LAST:event_campoCompAntFocusLost

    private void campoCompAntKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCompAntKeyTyped
        if(Validaciones.Longitud(campoCompAnt, 11)) evt.consume();
        if(!Validaciones.Numeros(evt.getKeyChar())) evt.consume();
    }//GEN-LAST:event_campoCompAntKeyTyped

    private void campoFavorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoFavorFocusGained
        if(campoFavor.getText().length()>0)
        campoFavor.setText(campoFavor.getText().replace(".", ""));
    }//GEN-LAST:event_campoFavorFocusGained

    private void campoFavorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoFavorFocusLost
        if(campoFavor.getText().length()>0)
        f.formatearNumero(campoFavor);
        else campoFavor.setText("0");
    }//GEN-LAST:event_campoFavorFocusLost

    private void campoFavorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoFavorKeyTyped
        if(Validaciones.Longitud(campoFavor, 11)) evt.consume();
        if(!Validaciones.Numeros(evt.getKeyChar())) evt.consume();
    }//GEN-LAST:event_campoFavorKeyTyped

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        if(listaMedidores.getModel().getSize()>0){
            reportes.Informes inf = new reportes.Informes();
            inf.mostrarResumenCuenta(dao.Reportes.obtenerResumenCuenta(cuenta.getIdentificador()), this);
        }
        else{
            JOptionPane.showMessageDialog(null, "Ningún medidor está relacionado actualmente con la cuenta.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnVerActionPerformed

    private void validarUsuario(){
        if(campoNumUsuario.getText().isEmpty()){
            campoNumUsuario.requestFocus();
        }
        else{
            u = new dao.Usuarios().obtenerUsuarioPorId(Integer.parseInt(campoNumUsuario.getText()));
            if(u == null){
                JOptionPane.showMessageDialog(null, "El número de cuenta no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                campoNumUsuario.setText("");
                campoUsuario.setText("");
                campoNumUsuario.requestFocus();
                btnGuardar.setEnabled(false);
            }
            else{
                campoUsuario.setText(u.getNombre()+" "+u.getApellido());
                btnGuardar.setEnabled(true);
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator Sep1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVer;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JTextField campoCompAnt;
    private javax.swing.JTextField campoDerconex;
    private javax.swing.JTextField campoFavor;
    private javax.swing.JTextField campoNumUsuario;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCompAnt;
    private javax.swing.JLabel labelDerconex;
    private javax.swing.JLabel labelFavor;
    private javax.swing.JLabel labelMedidor;
    private javax.swing.JLabel labelNumMedidor;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JList<modelos.Cuenta> listaMedidores;
    private javax.swing.JPanel panelContenedor;
    // End of variables declaration//GEN-END:variables
}
