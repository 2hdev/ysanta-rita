package interfaces;

import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import utilidades.Funciones;

public class Auditoria extends javax.swing.JInternalFrame {

    Funciones f = new Funciones();
    dao.Auditoria a = new dao.Auditoria();
    
    public Auditoria() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAuditoria = new javax.swing.JTable();
        labelBuscar = new javax.swing.JLabel();
        campoBuscar = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Auditoría");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/y_mini.png"))); // NOI18N

        tablaAuditoria.setModel(new clases.tablas.TablaAuditoria(a.listarAuditoria()));
        tablaAuditoria.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        if(tablaAuditoria.getRowCount() > 0) tablaAuditoria.requestFocus();
        tablaAuditoria.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaAuditoria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tablaAuditoriaFocusGained(evt);
            }
        });
        tablaAuditoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAuditoriaMouseClicked(evt);
            }
        });
        tablaAuditoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaAuditoriaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaAuditoria);
        tablaAuditoria.getTableHeader().setFont(new java.awt.Font("SegoeUI", 0, 12));
        tablaAuditoria.setAutoCreateRowSorter(true);
        tablaAuditoria.getColumnModel().getColumn(0).setMinWidth(150);
        tablaAuditoria.getColumnModel().getColumn(0).setMaxWidth(150);
        tablaAuditoria.getColumnModel().getColumn(0).setCellRenderer(utilidades.Renderers.rendererNumeros());

        labelBuscar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelBuscar.setLabelFor(campoBuscar);
        labelBuscar.setText("Buscar:");
        labelBuscar.setToolTipText("");
        labelBuscar.setFocusable(false);

        campoBuscar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoBuscarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBuscar)
                    .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaAuditoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAuditoriaMouseClicked
        if(tablaAuditoria.getRowCount() > 0){
            if(evt.getClickCount() == 2){
                interfaces.dialogos.DetalleAuditoria ec = new interfaces.dialogos.DetalleAuditoria(this, true, ((clases.tablas.TablaAuditoria)tablaAuditoria.getModel()).getAuditoria(tablaAuditoria.getSelectedRow()));
                ec.setLocationRelativeTo(this);
                ec.setVisible(true);
            }
        }
    }//GEN-LAST:event_tablaAuditoriaMouseClicked

    private void tablaAuditoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaAuditoriaKeyPressed
        if(tablaAuditoria.getRowCount() > 0){
            if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                interfaces.dialogos.DetalleAuditoria ec = new interfaces.dialogos.DetalleAuditoria(this, true, ((clases.tablas.TablaAuditoria)tablaAuditoria.getModel()).getAuditoria(tablaAuditoria.convertRowIndexToModel(tablaAuditoria.getSelectedRow())));
                javax.swing.JInternalFrame frame = this;
                tablaAuditoria.getInputMap(javax.swing.JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0), "Enter");
                tablaAuditoria.getActionMap().put("Enter", new AbstractAction() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent ae) {
                    ec.setLocationRelativeTo(frame);
                    ec.setVisible(true);
                }
            });
            }
        }
    }//GEN-LAST:event_tablaAuditoriaKeyPressed

    private void campoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyReleased
        f.filtrarBusquedaAbstract(campoBuscar.getText(), tablaAuditoria, 3);
    }//GEN-LAST:event_campoBuscarKeyReleased

    private void tablaAuditoriaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaAuditoriaFocusGained
        if(evt.getComponent().getMousePosition() == null) tablaAuditoria.changeSelection(0, 0, false, false);
    }//GEN-LAST:event_tablaAuditoriaFocusGained

    private void campoBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyTyped
        f.convertirAMayusculas(evt);
    }//GEN-LAST:event_campoBuscarKeyTyped

    @Override
    public void dispose() {
        if(conexion.InicioSesion.getUsuario().contains("admin")) PrincipalAdmin.accionar("inicio");
        else Principal.accionar("inicio");
        super.dispose(); 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBuscar;
    public static javax.swing.JTable tablaAuditoria;
    // End of variables declaration//GEN-END:variables
}
