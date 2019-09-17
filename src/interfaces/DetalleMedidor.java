package interfaces;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import utilidades.Funciones;
import utilidades.Validaciones;

public class DetalleMedidor extends javax.swing.JDialog {

    Funciones f;
    private final Integer idMedidor;
    dao.Medidor dm;
    modelos.Medidor m;
    modelos.Lectura l;

    public DetalleMedidor(javax.swing.JInternalFrame parent, boolean modal, Integer idMedidor) {
        f = new Funciones();
        this.idMedidor = idMedidor;
        dm = new dao.Medidor();
        initComponents();
        utilidades.Funciones.cerrarConEscape(DetalleMedidor.this);
        f.inhabilitarCampos(panelContenedor);
        m = dm.obtenerDetalleMedidor(idMedidor);
        campoCodigo.setText(String.valueOf(m.getNumeroMedidor()));
        campoDescripcion.setText(m.getDescripcion());
        campoObs.setText(m.getObservacion());
        labelCuenta.setText(labelCuenta.getText() + String.format(Locale.GERMAN, " %d", m.getNumeroCuenta()));
        if (m.getEstado().equals("AVERIADO")) {
            btnDescRec.setVisible(false);
            btnHabRec.setVisible(true);
        } else {
            btnDescRec.setVisible(true);
            btnHabRec.setVisible(false);
        }

        l = dm.obtenerUltimaLectura(idMedidor.toString());
        boolean sepago = dao.Comprobante.verificarEstado(l.getIdentificador());
        btnEditarLectura.setEnabled(!sepago);
        btnEditarLectura.setToolTipText(sepago ? "No se puede editar la última lectura: ya se realizó el pago (parcial o total) del comprobante correspondiente." : null);
        ArrayList<String> comprobante = new dao.Comprobante().obtenerComprobante(l.getIdentificador().toString());
        if (comprobante == null) {
            btnEditarLectura.setEnabled(false);
            btnEditarLectura.setToolTipText("La primera lectura no se puede editar.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        labelNumMedidor = new javax.swing.JLabel();
        campoCodigo = new javax.swing.JTextField();
        labelDescripcion = new javax.swing.JLabel();
        campoDescripcion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoObs = new javax.swing.JTextArea();
        labelObs = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        labelCuenta = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaHistorial = new javax.swing.JTable();
        btnEditarLectura = new javax.swing.JButton();
        btnDescRec = new javax.swing.JButton();
        btnHabRec = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalle de Medidor");
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        panelContenedor.setToolTipText("");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(utilidades.Estaticos.ICONO)));

        labelNumMedidor.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelNumMedidor.setText("Nº Medidor:");

        campoCodigo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoCodigo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        campoCodigo.setEnabled(false);
        campoCodigo.setName("numero_med"); // NOI18N

        labelDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelDescripcion.setText("Descripción:");

        campoDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoDescripcion.setName("descripcion_med"); // NOI18N
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

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setName("observacion_lec"); // NOI18N

        campoObs.setColumns(20);
        campoObs.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoObs.setLineWrap(true);
        campoObs.setRows(5);
        campoObs.setEnabled(false);
        campoObs.setName("obs_med"); // NOI18N
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

        labelObs.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelObs.setText("Observación:");

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

        labelCuenta.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelCuenta.setText("Asignado a cuenta Nº:");
        labelCuenta.setToolTipText("");
        labelCuenta.setEnabled(false);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        btnEditar.setToolTipText("Editar Medidor");
        btnEditar.setBorderPainted(false);
        btnEditar.setContentAreaFilled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        tablaHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha de Lectura", "Lectura"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        String[][] datos = dm.obtenerHistorial(idMedidor);
        for(int i = 0; i<4; i++){
            ((javax.swing.table.DefaultTableModel)tablaHistorial.getModel()).addRow(new String[]{datos[i][0],datos[i][1]});
        }
        tablaHistorial.setEnabled(false);
        jScrollPane2.setViewportView(tablaHistorial);
        if (tablaHistorial.getColumnModel().getColumnCount() > 0) {
            tablaHistorial.getColumnModel().getColumn(0).setResizable(false);
            tablaHistorial.getColumnModel().getColumn(1).setResizable(false);
        }
        if(tablaHistorial.getValueAt(1, 0) == null) btnEditarLectura.setEnabled(false);

        btnEditarLectura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar_.png"))); // NOI18N
        btnEditarLectura.setToolTipText("Editar Última Lectura");
        btnEditarLectura.setBorderPainted(false);
        btnEditarLectura.setContentAreaFilled(false);
        btnEditarLectura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarLecturaActionPerformed(evt);
            }
        });

        btnDescRec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/desconectar.png"))); // NOI18N
        btnDescRec.setToolTipText("Eliminar Medidor");
        btnDescRec.setBorderPainted(false);
        btnDescRec.setContentAreaFilled(false);
        btnDescRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescRecActionPerformed(evt);
            }
        });

        btnHabRec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/habilitar.png"))); // NOI18N
        btnHabRec.setToolTipText("Habilitar Medidor");
        btnHabRec.setBorderPainted(false);
        btnHabRec.setContentAreaFilled(false);
        btnHabRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabRecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorLayout.createSequentialGroup()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelContenedorLayout.createSequentialGroup()
                                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelDescripcion, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelObs, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelContenedorLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(labelNumMedidor)))
                        .addGap(12, 12, 12)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCuenta)
                            .addGroup(panelContenedorLayout.createSequentialGroup()
                                .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96)
                                .addComponent(btnHabRec, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDescRec, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelContenedorLayout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar))
                            .addGroup(panelContenedorLayout.createSequentialGroup()
                                .addComponent(btnEditarLectura, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(35, 35, 35))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNumMedidor)
                            .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDescRec, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnHabRec, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDescripcion)
                    .addComponent(campoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelObs)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelCuenta)
                .addGap(32, 32, 32)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarLectura))
                .addGap(27, 27, 27)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addGap(35, 35, 35))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarLecturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarLecturaActionPerformed
        EditarLectura el = new EditarLectura(l);
        Funciones.centrar(el, conexion.InicioSesion.getUsuario().contains("admin") ? PrincipalAdmin.panelEscritorio : Principal.panelEscritorio);
        dispose();
    }//GEN-LAST:event_btnEditarLecturaActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        f.habilitarCampos(panelContenedor);
        campoObs.setEnabled(true);
        btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (!f.recorrerYValidar(panelContenedor)) {
            return;
        }
        if (dm.verificarMedidor(campoCodigo.getText(), idMedidor)) {
            JOptionPane.showMessageDialog(null, "El número de medidor ya está registrado actualmente.");
            return;
        }

        java.util.Map cambios = new java.util.HashMap();

        if (!String.valueOf(m.getNumeroMedidor()).equals(campoCodigo.getText())) {
            cambios.put(String.format("%s=?", campoCodigo.getName()), campoCodigo.getText());
        }
        if (!m.getDescripcion().equals(campoDescripcion.getText())) {
            cambios.put(String.format("%s=?", campoDescripcion.getName()), campoDescripcion.getText());
        }
        if (!m.getObservacion().equals(campoObs.getText())) {
            cambios.put(String.format("%s=?", campoObs.getName()), campoObs.getText());
        }

        if (cambios.size() > 0) {
            if (dm.actualizarMedidor(cambios, idMedidor)) {
                JOptionPane.showMessageDialog(null, "Se han actualizado los datos correctamente.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                ListaMedidores.insertarEnTabla();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrió un error intentando actualizar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void campoObsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoObsKeyTyped
        f.convertirAMayusculas(evt);
    }//GEN-LAST:event_campoObsKeyTyped

    private void campoObsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoObsKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB || evt.getKeyCode() == KeyEvent.VK_ENTER) {
            utilidades.Funciones.transferirFoco(campoObs, evt);
        }
    }//GEN-LAST:event_campoObsKeyPressed

    private void campoObsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoObsFocusLost
        campoObs.setText(f.removerEspaciosExtra(campoObs.getText()));
        campoObs.setText(campoObs.getText().trim());
    }//GEN-LAST:event_campoObsFocusLost

    private void campoDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDescripcionKeyTyped
        f.convertirAMayusculas(evt);
        if (Validaciones.Longitud(campoDescripcion, 100)) {
            evt.consume();
        }
    }//GEN-LAST:event_campoDescripcionKeyTyped

    private void campoDescripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoDescripcionFocusLost
        campoDescripcion.setText(f.removerEspaciosExtra(campoDescripcion.getText()));
        campoDescripcion.setText(campoDescripcion.getText().trim());
    }//GEN-LAST:event_campoDescripcionFocusLost

    private void btnDescRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescRecActionPerformed
        String[] options = dao.Medidor.tieneSaldoMedidor(m.getIdentificador()) ? new String[]{"Está averiado"} : new String[]{"Está averiado", "Para eliminarlo"};
        String estado;
        int seleccion = javax.swing.JOptionPane.showOptionDialog(
                null, "¿Por qué desea dar de baja al medidor?", "Dar de Baja a Medidor",
                javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        switch (seleccion) {
            case 0:
                estado = "AVERIADO";
                break;
            case 1:
                estado = "ELIMINADO";
                break;
            default:
                return;
        }
        if (dm.desconectarMedidor(idMedidor, estado)) {
            JOptionPane.showMessageDialog(null, "Se modificó el estado del medidor a " + estado + ".", "Atención", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar modificar el estado del medidor.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        dispose();
    }//GEN-LAST:event_btnDescRecActionPerformed

    private void btnHabRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabRecActionPerformed
        if (dm.desconectarMedidor(idMedidor, "ACTIVO")) {
            JOptionPane.showMessageDialog(null, "Se habilitó el medidor.", "Atención", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar modificar el estado del medidor.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnHabRecActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDescRec;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEditarLectura;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnHabRec;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JTextField campoDescripcion;
    private javax.swing.JTextArea campoObs;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCuenta;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelNumMedidor;
    private javax.swing.JLabel labelObs;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JTable tablaHistorial;
    // End of variables declaration//GEN-END:variables
}
