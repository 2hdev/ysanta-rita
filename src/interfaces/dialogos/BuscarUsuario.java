package interfaces.dialogos;

import java.awt.Toolkit;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import utilidades.Funciones;

public class BuscarUsuario extends javax.swing.JDialog {

    private final JInternalFrame parent; private final JTextField campo;
    Funciones f = new Funciones();
    
    public BuscarUsuario(JInternalFrame parent, JTextField campo, boolean modal) {
        initComponents();
        this.parent = parent;
        this.campo = campo;
        Funciones.cerrarConEscape(BuscarUsuario.this);
        dao.Usuarios.obtenerUsuarios().entrySet().stream().map((m) -> {
            Object[] fila = new Object[4];
            fila[0] = m.getKey();
            fila[1] = String.valueOf(m.getValue().substring(0, m.getValue().indexOf("|")));
            fila[2] = String.valueOf(m.getValue().substring(m.getValue().indexOf("|")+1, m.getValue().indexOf(",")));
            fila[3] = m.getValue().substring(m.getValue().indexOf(",")+1).equals("1");
            return fila;
        }).forEachOrdered((fila) -> {
            ((DefaultTableModel)tablaUsuarios.getModel()).addRow(fila);
        });
        tablaUsuarios.getColumnModel().getColumn(0).setCellRenderer(utilidades.Renderers.rendererCerrado(3));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoFiltros = new javax.swing.ButtonGroup();
        labelBuscar = new javax.swing.JLabel();
        campoBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        radioNumUsuario = new javax.swing.JRadioButton();
        radioNomape = new javax.swing.JRadioButton();
        radioNumDoc = new javax.swing.JRadioButton();
        labelMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Cuenta");
        setAlwaysOnTop(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(utilidades.Estaticos.ICONO)));
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setName(""); // NOI18N
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        labelBuscar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        labelBuscar.setText("Buscar:");

        campoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoBuscarKeyReleased(evt);
            }
        });

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº Usuario", "Nombre y Apellido", "Nº Documento", "I"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaUsuarios.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tablaUsuariosFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios);
        tablaUsuarios.getColumnModel().getColumn(3).setMinWidth(0);
        tablaUsuarios.getColumnModel().getColumn(3).setMaxWidth(0);

        btnAceptar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        grupoFiltros.add(radioNumUsuario);
        radioNumUsuario.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        radioNumUsuario.setSelected(true);
        radioNumUsuario.setText("Por Nº Usuario");
        radioNumUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNumUsuarioActionPerformed(evt);
            }
        });

        grupoFiltros.add(radioNomape);
        radioNomape.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        radioNomape.setText("Por Nombre/Apellido");
        radioNomape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNomapeActionPerformed(evt);
            }
        });

        grupoFiltros.add(radioNumDoc);
        radioNumDoc.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        radioNumDoc.setText("Por Nº Documento");
        radioNumDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNumDocActionPerformed(evt);
            }
        });

        labelMensaje.setFont(new java.awt.Font("Segoe UI", 2, 11)); // NOI18N
        labelMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMensaje.setText("Los códigos de usuario señalados en color verde indican que ya se les ha asignado una o más cuentas a los mismos.");
        labelMensaje.setEnabled(false);
        labelMensaje.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(radioNumUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioNomape)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioNumDoc))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAceptar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCancelar))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBuscar)
                    .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioNumUsuario)
                    .addComponent(radioNomape)
                    .addComponent(radioNumDoc))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(labelMensaje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaUsuariosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaUsuariosFocusGained
        if(evt.getComponent().getMousePosition() == null){if(tablaUsuarios.getSelectedRow() < 0) tablaUsuarios.changeSelection(0, 0, false, false);}
    }//GEN-LAST:event_tablaUsuariosFocusGained

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if(tablaUsuarios.getSelectedRow() >= 0){ 
            campo.setText(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0).toString());
            dispose();
            parent.requestFocus();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        parent.requestFocus();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void radioNumUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNumUsuarioActionPerformed
        tablaUsuarios.setRowSorter(null);
    }//GEN-LAST:event_radioNumUsuarioActionPerformed

    private void radioNomapeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNomapeActionPerformed
        tablaUsuarios.setRowSorter(null);
    }//GEN-LAST:event_radioNomapeActionPerformed

    private void radioNumDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNumDocActionPerformed
        tablaUsuarios.setRowSorter(null);
    }//GEN-LAST:event_radioNumDocActionPerformed

    private void campoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyReleased
        if(radioNumUsuario.isSelected()){
            f.filtrarBusqueda(campoBuscar.getText().toUpperCase(), tablaUsuarios, 0);
        }
        else if(radioNomape.isSelected()){
            f.filtrarBusqueda(campoBuscar.getText().toUpperCase(), tablaUsuarios, 1);
        }
        else if(radioNumDoc.isSelected()){
            f.filtrarBusqueda(campoBuscar.getText().toUpperCase(), tablaUsuarios, 2);
        }
    }//GEN-LAST:event_campoBuscarKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.ButtonGroup grupoFiltros;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBuscar;
    private javax.swing.JLabel labelMensaje;
    private javax.swing.JRadioButton radioNomape;
    private javax.swing.JRadioButton radioNumDoc;
    private javax.swing.JRadioButton radioNumUsuario;
    private javax.swing.JTable tablaUsuarios;
    // End of variables declaration//GEN-END:variables
}
