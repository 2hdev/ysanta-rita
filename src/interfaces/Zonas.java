package interfaces;

import clases.tablas.TablaZonas;
import utilidades.Funciones;

public class Zonas extends javax.swing.JInternalFrame {

    public static void setT(TablaZonas t) {
        Zonas.t = t;
    }

    public static TablaZonas getT() {
        return t;
    }
        
    static TablaZonas t;
    Funciones f = new Funciones();
    
    public Zonas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoRadio = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaZonas = new javax.swing.JTable();
        btnNuevaZona = new javax.swing.JButton();
        labelBuscar = new javax.swing.JLabel();
        campoBuscar = new javax.swing.JTextField();
        radioCod = new javax.swing.JRadioButton();
        radioZona = new javax.swing.JRadioButton();

        setClosable(true);
        setTitle("Zonas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/y_mini.png"))); // NOI18N

        t = new TablaZonas(dao.Zonas.listaZonas());
        tablaZonas.setModel(t);
        if(tablaZonas.getRowCount() > 0) tablaZonas.requestFocus();
        tablaZonas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaZonas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tablaZonasFocusGained(evt);
            }
        });
        tablaZonas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaZonasMouseClicked(evt);
            }
        });
        tablaZonas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaZonasKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaZonas);
        tablaZonas.getTableHeader().setFont(new java.awt.Font("SegoeUI", 0, 12));
        tablaZonas.setAutoCreateRowSorter(true);
        tablaZonas.getColumnModel().getColumn(0).setMinWidth(150);
        tablaZonas.getColumnModel().getColumn(0).setMaxWidth(150);

        btnNuevaZona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/addbarrio.png"))); // NOI18N
        btnNuevaZona.setMnemonic(java.awt.event.KeyEvent.VK_N);
        btnNuevaZona.setToolTipText("Nueva Zona");
        btnNuevaZona.setContentAreaFilled(false);
        btnNuevaZona.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevaZona.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnNuevaZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaZonaActionPerformed(evt);
            }
        });

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

        grupoRadio.add(radioCod);
        radioCod.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        radioCod.setSelected(true);
        radioCod.setText("Por Código");
        radioCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCodActionPerformed(evt);
            }
        });

        grupoRadio.add(radioZona);
        radioZona.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        radioZona.setText("Por Nombre de Zona");
        radioZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioZonaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevaZona, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(labelBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(radioCod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioZona)))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBuscar)
                    .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioCod)
                    .addComponent(radioZona))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNuevaZona, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaZonaActionPerformed
        interfaces.dialogos.AMZona ec = new interfaces.dialogos.AMZona();
        ec.setLocationRelativeTo(this);
        ec.setVisible(true);
    }//GEN-LAST:event_btnNuevaZonaActionPerformed

    private void tablaZonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaZonasMouseClicked
        if(tablaZonas.getRowCount() > 0){
            if(evt.getClickCount() == 2){
                interfaces.dialogos.AMZona ec = new interfaces.dialogos.AMZona(this, true, t.getZona(tablaZonas.getSelectedRow()));
                ec.setLocationRelativeTo(this);
                ec.setVisible(true);
            }
        }
    }//GEN-LAST:event_tablaZonasMouseClicked

    private void tablaZonasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaZonasKeyPressed
        if(tablaZonas.getRowCount() > 0){
            if(evt.getKeyCode()==evt.VK_ENTER){
                interfaces.dialogos.AMZona ec = new interfaces.dialogos.AMZona(this, true, t.getZona(tablaZonas.getSelectedRow()));
                ec.setLocationRelativeTo(this);
                ec.setVisible(true);
            }
        }
    }//GEN-LAST:event_tablaZonasKeyPressed

    private void campoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyReleased
        f.filtrarBusquedaAbstract(campoBuscar.getText(), tablaZonas, radioCod.isSelected()?0:1);
    }//GEN-LAST:event_campoBuscarKeyReleased

    private void tablaZonasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaZonasFocusGained
        if(evt.getComponent().getMousePosition() == null) tablaZonas.changeSelection(0, 0, false, false);
    }//GEN-LAST:event_tablaZonasFocusGained

    private void radioCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCodActionPerformed
        tablaZonas.setRowSorter(null);
        campoBuscar.setText("");
    }//GEN-LAST:event_radioCodActionPerformed

    private void radioZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioZonaActionPerformed
        tablaZonas.setRowSorter(null);
        campoBuscar.setText("");
    }//GEN-LAST:event_radioZonaActionPerformed

    private void campoBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyTyped
        f.convertirAMayusculas(evt);
    }//GEN-LAST:event_campoBuscarKeyTyped

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btnNuevaZona;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.ButtonGroup grupoRadio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBuscar;
    private javax.swing.JRadioButton radioCod;
    private javax.swing.JRadioButton radioZona;
    public static javax.swing.JTable tablaZonas;
    // End of variables declaration//GEN-END:variables
}
