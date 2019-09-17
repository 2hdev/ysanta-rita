package interfaces;

import clases.tablas.TablaCuentas;
import java.awt.event.InputEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import utilidades.Funciones;
import utilidades.Validaciones;

public class NuevaCuenta extends javax.swing.JInternalFrame {

    Funciones f;
    dao.Cuentas c;
    modelos.Usuario u;
    
    public NuevaCuenta() {
        initComponents();
        f = new Funciones();
        Funciones.cerrarConEscape(NuevaCuenta.this);
        asignarEvento();
    }

    @Override
    public void dispose() {
        ListaCuentas.btnRegistrarCuenta.setEnabled(true);
        super.dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        labelDerconex = new javax.swing.JLabel();
        campoDerconex = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        labelUsuario = new javax.swing.JLabel();
        campoNumUsuario = new javax.swing.JTextField();
        campoUsuario = new javax.swing.JTextField();
        labelCompAnt = new javax.swing.JLabel();
        campoCompAnt = new javax.swing.JTextField();
        labelFavor = new javax.swing.JLabel();
        campoFavor = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Registrar Cuenta");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/y_mini.png"))); // NOI18N

        labelDerconex.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelDerconex.setText("<html>Deuda por <br>Derecho de Conexión:</html>");

        campoDerconex.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
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
        labelUsuario.setText("Asignada al Usuario:");

        campoNumUsuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
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

        labelCompAnt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelCompAnt.setText("<html>Deuda por <br>Comprobantes Anteriores:</html>");

        campoCompAnt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
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

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(labelFavor)
                        .addGap(18, 18, 18)
                        .addComponent(campoFavor, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelContenedorLayout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar))
                            .addGroup(panelContenedorLayout.createSequentialGroup()
                                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelUsuario)
                                    .addComponent(labelDerconex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelContenedorLayout.createSequentialGroup()
                                        .addComponent(campoDerconex, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(45, 45, 45)
                                        .addComponent(labelCompAnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(campoCompAnt, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelContenedorLayout.createSequentialGroup()
                                        .addComponent(campoNumUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoUsuario)))))))
                .addGap(40, 40, 40))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(campoNumUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelUsuario)
                            .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelDerconex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoDerconex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(labelCompAnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCompAnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFavor)
                    .addComponent(campoFavor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addGap(41, 41, 41))
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
        if(u == null) return;
        if(!f.recorrerYValidar(panelContenedor)) return;
        modelos.Cuenta cuenta = new modelos.Cuenta();
        cuenta.setUsuario(u.getIdentificador());
        cuenta.setSaldoAFavor(Integer.parseInt(campoFavor.getText().replace(".", "")));
        cuenta.setSaldoComprobantes(Integer.parseInt(campoCompAnt.getText().replace(".", "")));
        cuenta.setSaldoDC(Integer.parseInt(campoDerconex.getText().replace(".", "")));
        c = new dao.Cuentas();
        if(c.insertarCuenta(cuenta)){
            JOptionPane.showMessageDialog(null, "Se registró la cuenta correctamente.");
            f.limpiarCampos(panelContenedor);
            ListaCuentas.tc = new TablaCuentas(dao.Cuentas.obtenerCuentasYMedidores());
            ((TablaCuentas)ListaCuentas.tablaCuentas.getModel()).limpiar();
            ListaCuentas.tablaCuentas.setModel(ListaCuentas.tc);
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "No se ha podido registrar los datos.");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void campoNumUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNumUsuarioActionPerformed
        campoNumUsuario.transferFocus();
    }//GEN-LAST:event_campoNumUsuarioActionPerformed

    private void campoNumUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNumUsuarioFocusLost
        validarUsuario();
    }//GEN-LAST:event_campoNumUsuarioFocusLost

    private void campoNumUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNumUsuarioKeyTyped
        if(Validaciones.Longitud(campoNumUsuario, 11)) evt.consume();
        if(!Validaciones.Numeros(evt.getKeyChar())) evt.consume();
    }//GEN-LAST:event_campoNumUsuarioKeyTyped

    private void campoDerconexFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoDerconexFocusGained
        if(campoDerconex.getText().length()>0)
            campoDerconex.setText(campoDerconex.getText().replace(".", ""));
    }//GEN-LAST:event_campoDerconexFocusGained

    private void campoCompAntFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCompAntFocusGained
        if(campoCompAnt.getText().length()>0)
            campoCompAnt.setText(campoCompAnt.getText().replace(".", ""));
    }//GEN-LAST:event_campoCompAntFocusGained

    private void campoFavorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoFavorFocusGained
        if(campoFavor.getText().length()>0)
            campoFavor.setText(campoFavor.getText().replace(".", ""));
    }//GEN-LAST:event_campoFavorFocusGained

    private void campoDerconexFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoDerconexFocusLost
        if(campoDerconex.getText().length()>0)
            f.formatearNumero(campoDerconex);
        else campoDerconex.setText("0");
    }//GEN-LAST:event_campoDerconexFocusLost

    private void campoCompAntFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCompAntFocusLost
        if(campoCompAnt.getText().length()>0)
            f.formatearNumero(campoCompAnt);
        else campoCompAnt.setText("0");
    }//GEN-LAST:event_campoCompAntFocusLost

    private void campoFavorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoFavorFocusLost
        if(campoFavor.getText().length()>0)
            f.formatearNumero(campoFavor);
        else campoFavor.setText("0");
    }//GEN-LAST:event_campoFavorFocusLost

    private void campoDerconexKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDerconexKeyTyped
        if(Validaciones.Longitud(campoDerconex, 11)) evt.consume();
        if(!Validaciones.Numeros(evt.getKeyChar())) evt.consume();
    }//GEN-LAST:event_campoDerconexKeyTyped

    private void campoCompAntKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCompAntKeyTyped
        if(Validaciones.Longitud(campoCompAnt, 11)) evt.consume();
        if(!Validaciones.Numeros(evt.getKeyChar())) evt.consume();
    }//GEN-LAST:event_campoCompAntKeyTyped

    private void campoFavorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoFavorKeyTyped
        if(Validaciones.Longitud(campoFavor, 11)) evt.consume();
        if(!Validaciones.Numeros(evt.getKeyChar())) evt.consume();
    }//GEN-LAST:event_campoFavorKeyTyped

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
    
    private Action buscarUsuario(){
        return new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                interfaces.dialogos.BuscarUsuario bc = new interfaces.dialogos.BuscarUsuario(NuevaCuenta.this, campoNumUsuario, true);
                bc.setLocationRelativeTo(NuevaCuenta.this);
                bc.setVisible(true);
            }
        };
    }
    
    private void asignarEvento(){
        campoNumUsuario.getInputMap(javax.swing.JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK), "Buscar");
        campoNumUsuario.getActionMap().put("Buscar", buscarUsuario());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JTextField campoCompAnt;
    private javax.swing.JTextField campoDerconex;
    private javax.swing.JTextField campoFavor;
    private javax.swing.JTextField campoNumUsuario;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JLabel labelCompAnt;
    private javax.swing.JLabel labelDerconex;
    private javax.swing.JLabel labelFavor;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPanel panelContenedor;
    // End of variables declaration//GEN-END:variables
}
