package interfaces;

import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import utilidades.Funciones;

public class ListaMedidores extends javax.swing.JInternalFrame {
    
    static dao.Medidor med;
    Funciones f;
    public ListaMedidores() {
        initComponents();
        insertarEnTabla();
        f = new Funciones();
        utilidades.Funciones.cerrarConEscape(ListaMedidores.this);
    }
    
    protected static void insertarEnTabla(){
        Funciones.limpiarTabla(tablaMedidores);
        med = new dao.Medidor();
        med.listarMedidores().stream().map((m) -> {
            String[] fila = new String[4];
            fila[0] = String.valueOf(m.getIdentificador());
            fila[1] = String.valueOf(m.getNumeroMedidor());
            fila[2] = String.valueOf(m.getLecturaActual());
            fila[3] = String.valueOf(m.getLecturaAnterior());
            return fila;
        }).forEachOrdered((fila) -> {
            ((DefaultTableModel)tablaMedidores.getModel()).addRow(fila);
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelBuscar = new javax.swing.JLabel();
        campoBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMedidores = new javax.swing.JTable();
        btnNuevoMedidor = new javax.swing.JButton();

        setClosable(true);
        setTitle("Medidores");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/y_mini.png"))); // NOI18N

        labelBuscar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelBuscar.setText("Buscar:");

        campoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoBuscarKeyReleased(evt);
            }
        });

        tablaMedidores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "I", "Nº Medidor", "Lectura Actual", "Lectura Anterior"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaMedidores.setToolTipText("");
        tablaMedidores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaMedidores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMedidoresMouseClicked(evt);
            }
        });
        tablaMedidores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaMedidoresKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaMedidores);
        tablaMedidores.setRowSorter(new TableRowSorter<>(tablaMedidores.getModel()));
        tablaMedidores.getTableHeader().setFont(new java.awt.Font("SegoeUI", 0, 12));

        tablaMedidores.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaMedidores.getColumnModel().getColumn(0).setMinWidth(0);
        tablaMedidores.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tablaMedidores.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);

        btnNuevoMedidor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/medidor.png"))); // NOI18N
        btnNuevoMedidor.setToolTipText("Registrar Medidor");
        btnNuevoMedidor.setBorderPainted(false);
        btnNuevoMedidor.setContentAreaFilled(false);
        btnNuevoMedidor.setIconTextGap(0);
        btnNuevoMedidor.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnNuevoMedidor.setMaximumSize(new java.awt.Dimension(50, 50));
        btnNuevoMedidor.setMinimumSize(new java.awt.Dimension(50, 50));
        btnNuevoMedidor.setPreferredSize(new java.awt.Dimension(50, 50));
        btnNuevoMedidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoMedidorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevoMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBuscar)
                    .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNuevoMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyReleased
        f.filtrarBusqueda(campoBuscar.getText(), tablaMedidores, 1);
    }//GEN-LAST:event_campoBuscarKeyReleased

    private void tablaMedidoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMedidoresMouseClicked
        if(evt.getClickCount() == 2){
            if(tablaMedidores.getSelectedRow() >= 0){
                DetalleMedidor dm = new DetalleMedidor(this, true, Integer.parseInt(tablaMedidores.getValueAt(tablaMedidores.getSelectedRow(), 0).toString()));
                dm.setLocationRelativeTo(conexion.InicioSesion.getUsuario().contains("admin")?PrincipalAdmin.panelEscritorio:Principal.panelEscritorio);
                dm.setVisible(true);
            }
        }
    }//GEN-LAST:event_tablaMedidoresMouseClicked

    private void btnNuevoMedidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoMedidorActionPerformed
        Medidor rm = new Medidor();
        Funciones.centrar(rm, conexion.InicioSesion.getUsuario().contains("admin")?PrincipalAdmin.panelEscritorio:Principal.panelEscritorio);
        btnNuevoMedidor.setEnabled(false);
    }//GEN-LAST:event_btnNuevoMedidorActionPerformed

    private void tablaMedidoresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaMedidoresKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(tablaMedidores.getSelectedRow() >= 0){
                DetalleMedidor dm = new DetalleMedidor(this, true, Integer.parseInt(tablaMedidores.getValueAt(tablaMedidores.getSelectedRow(), 0).toString()));
                tablaMedidores.getInputMap(javax.swing.JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0), "Enter");
                tablaMedidores.getActionMap().put("Enter", new AbstractAction() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent ae) {
                        dm.setLocationRelativeTo(conexion.InicioSesion.getUsuario().contains("admin")?PrincipalAdmin.panelEscritorio:Principal.panelEscritorio);
                        dm.setVisible(true);
                    }
                });                
            }
        }
    }//GEN-LAST:event_tablaMedidoresKeyPressed

    @Override
    public void dispose() {
        if(conexion.InicioSesion.getUsuario().contains("admin")) PrincipalAdmin.accionar("inicio");
        else Principal.accionar("inicio");
        super.dispose(); 
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected static javax.swing.JButton btnNuevoMedidor;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBuscar;
    protected static javax.swing.JTable tablaMedidores;
    // End of variables declaration//GEN-END:variables
}
