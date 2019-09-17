package interfaces;

import clases.tablas.TablaCuentas;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import utilidades.Funciones;

public class ListaCuentas extends javax.swing.JInternalFrame {

    Funciones f = new Funciones();
    protected static TablaCuentas tc;
    
    public ListaCuentas() {
        initComponents();
        Funciones.cerrarConEscape(ListaCuentas.this);       
        asignarEvento();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoFiltros = new javax.swing.ButtonGroup();
        labelBuscar = new javax.swing.JLabel();
        campoBuscar = new javax.swing.JTextField();
        radioNumCuenta = new javax.swing.JRadioButton();
        radioMedidores = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCuentas = new javax.swing.JTable();
        btnRegistrarCuenta = new javax.swing.JButton();
        btnVer = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cuentas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/y_mini.png"))); // NOI18N

        labelBuscar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        labelBuscar.setText("Buscar:");

        campoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoBuscarKeyReleased(evt);
            }
        });

        grupoFiltros.add(radioNumCuenta);
        radioNumCuenta.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        radioNumCuenta.setSelected(true);
        radioNumCuenta.setText("Por Nº Cuenta");
        radioNumCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNumCuentaActionPerformed(evt);
            }
        });

        grupoFiltros.add(radioMedidores);
        radioMedidores.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        radioMedidores.setText("Por Nº Medidor");
        radioMedidores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMedidoresActionPerformed(evt);
            }
        });

        tc = new TablaCuentas(dao.Cuentas.obtenerCuentasYMedidores());
        tablaCuentas.setModel(tc);
        tablaCuentas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tablaCuentasFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCuentas);

        btnRegistrarCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/addcuenta.png"))); // NOI18N
        btnRegistrarCuenta.setToolTipText("Registrar Cuenta");
        btnRegistrarCuenta.setBorderPainted(false);
        btnRegistrarCuenta.setContentAreaFilled(false);
        btnRegistrarCuenta.setIconTextGap(0);
        btnRegistrarCuenta.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnRegistrarCuenta.setMaximumSize(new java.awt.Dimension(50, 50));
        btnRegistrarCuenta.setMinimumSize(new java.awt.Dimension(50, 50));
        btnRegistrarCuenta.setPreferredSize(new java.awt.Dimension(50, 50));
        btnRegistrarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCuentaActionPerformed(evt);
            }
        });

        btnVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ver.png"))); // NOI18N
        btnVer.setToolTipText("Ver Resumen de Cuenta");
        btnVer.setBorderPainted(false);
        btnVer.setContentAreaFilled(false);
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

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
                        .addComponent(radioNumCuenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioMedidores))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnRegistrarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(369, 369, 369)
                            .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBuscar)
                    .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioNumCuenta)
                    .addComponent(radioMedidores))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnRegistrarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVer))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyReleased
        if(radioNumCuenta.isSelected()){
            f.filtrarBusquedaAbstract(campoBuscar.getText().toUpperCase(), tablaCuentas, 0);
        }
        else if(radioMedidores.isSelected()){
            f.filtrarBusquedaAbstract(campoBuscar.getText().toUpperCase(), tablaCuentas, 1);
        }
    }//GEN-LAST:event_campoBuscarKeyReleased

    private void radioNumCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNumCuentaActionPerformed
        tablaCuentas.setRowSorter(null);
    }//GEN-LAST:event_radioNumCuentaActionPerformed

    private void radioMedidoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMedidoresActionPerformed
        tablaCuentas.setRowSorter(null);
    }//GEN-LAST:event_radioMedidoresActionPerformed

    private void tablaCuentasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaCuentasFocusGained
        if(evt.getComponent().getMousePosition() == null){if(tablaCuentas.getSelectedRow() < 0) tablaCuentas.changeSelection(0, 0, false, false);}
    }//GEN-LAST:event_tablaCuentasFocusGained

    private void btnRegistrarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCuentaActionPerformed
        NuevaCuenta nc = new NuevaCuenta();
        Funciones.centrar(nc, conexion.InicioSesion.getUsuario().contains("admin")?PrincipalAdmin.panelEscritorio:Principal.panelEscritorio);
        btnRegistrarCuenta.setEnabled(false);
    }//GEN-LAST:event_btnRegistrarCuentaActionPerformed

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        if(tablaCuentas.getSelectedRow()>=0){
            reportes.Informes inf = new reportes.Informes();
            inf.mostrarResumenCuenta(dao.Reportes.obtenerResumenCuenta(((TablaCuentas)tablaCuentas.getModel()).getCuenta(tablaCuentas.convertRowIndexToModel(tablaCuentas.getSelectedRow())).getIdentificador()), null);
        }
        else{
            JOptionPane.showMessageDialog(null, "Seleccione una cuenta en la lista para obtener su resumen de cuenta.", "Seleccionar en la lista", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnVerActionPerformed
    
    private Action verDetalle(){
        return new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                acceder();
            }
        };
    }
    
    private void acceder(){
        DetalleCuenta dc = new DetalleCuenta(ListaCuentas.this, true, tc.getCuenta(tablaCuentas.convertRowIndexToModel(tablaCuentas.getSelectedRow())));
        dc.setLocationRelativeTo(conexion.InicioSesion.getUsuario().contains("admin")?PrincipalAdmin.panelEscritorio:Principal.panelEscritorio);
        dc.setVisible(true);
    }
    
    private void asignarEvento(){
        tablaCuentas.getInputMap(javax.swing.JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0), "Enter");
        tablaCuentas.getActionMap().put("Enter", verDetalle());
        tablaCuentas.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(evt.getClickCount() == 2){
                    if(tablaCuentas.getSelectedRow() >= 0){
                        acceder();
                    }
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected static javax.swing.JButton btnRegistrarCuenta;
    private javax.swing.JButton btnVer;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.ButtonGroup grupoFiltros;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBuscar;
    private javax.swing.JRadioButton radioMedidores;
    private javax.swing.JRadioButton radioNumCuenta;
    protected static javax.swing.JTable tablaCuentas;
    // End of variables declaration//GEN-END:variables
}
