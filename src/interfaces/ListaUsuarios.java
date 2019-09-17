package interfaces;

import clases.tablas.TablaUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import utilidades.Funciones;
import utilidades.Validaciones;


public class ListaUsuarios extends javax.swing.JInternalFrame {
    
    static int pagina = 1, cantidad = 1;
    
    Funciones f;
    public ListaUsuarios() {
        initComponents();
        f = new Funciones();
        pagina = 1;
        totalFilas();
        labelBarra.setText(String.format("/%d", cantidad));
        relistar(null);
        btnAnterior.setEnabled(pagina > 1);
        btnSiguiente.setEnabled(cantidad > pagina);
        asignarEventos();
    }

    public JButton getBtnAnterior() {
        return btnAnterior;
    }

    public JButton getBtnSiguiente() {
        return btnSiguiente;
    }
    
    public static void totalFilas(){
        cantidad = (int)Math.ceil(dao.Usuarios.contarUsuarios()/50.0);
    }
    
    @Override
    public void dispose() {
        if(conexion.InicioSesion.getUsuario().contains("admin")) PrincipalAdmin.accionar("inicio");
        else Principal.accionar("inicio");
        pagina = 1;
        radioCodigo.setSelected(true);
        totalFilas();
        labelBarra.setText(String.format("/%d", cantidad));
        relistar(grupoBotones.getSelection().getActionCommand());
        campoNum.setEnabled(true);
        btnAnterior.setEnabled(pagina > 1);
        btnSiguiente.setEnabled(cantidad > pagina);
        super.dispose();
    }
    
    public static void relistar(String ordena){
        totalFilas();
        labelBarra.setText(String.format("/%d", cantidad));
        ((TablaUsuarios)tablaUsuarios.getModel()).limpiar();
        ((TablaUsuarios)tablaUsuarios.getModel()).setUsuarios(dao.Usuarios.listarUsuariosPag(pagina, ordena));
        campoNum.setText(String.format("%d", pagina));
    }
    
    public void limpiar(){
        tablaUsuarios.setRowSorter(null);
        campoBuscar.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotones = new javax.swing.ButtonGroup();
        labelBuscar = new javax.swing.JLabel();
        campoBuscar = new javax.swing.JTextField();
        radioNombre = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        btnNuevoUsuario = new javax.swing.JButton();
        radioNDoc = new javax.swing.JRadioButton();
        radioCodigo = new javax.swing.JRadioButton();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        campoNum = new javax.swing.JTextField();
        labelBarra = new javax.swing.JLabel();
        btnHistorial = new javax.swing.JButton();
        radioApellido = new javax.swing.JRadioButton();

        setClosable(true);
        setTitle("Usuarios");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/y_mini.png"))); // NOI18N

        labelBuscar.setText("Buscar:");

        grupoBotones.add(radioNombre);
        radioNombre.setText("Por Nombre");
        radioNombre.setActionCommand("u.nombre_usu");
        radioNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNombreActionPerformed(evt);
            }
        });

        tablaUsuarios.setModel(new TablaUsuarios());
        tablaUsuarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaUsuarios.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tablaUsuariosFocusGained(evt);
            }
        });
        tablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios);
        tablaUsuarios.getColumnModel().getColumn(2).setCellRenderer(utilidades.Renderers.rendererCentro());
        tablaUsuarios.getColumnModel().getColumn(3).setCellRenderer(utilidades.Renderers.rendererNumeros());
        tablaUsuarios.getColumnModel().getColumn(4).setCellRenderer(utilidades.Renderers.rendererNumeros());

        btnNuevoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevousuario.png"))); // NOI18N
        btnNuevoUsuario.setToolTipText("Nuevo Usuario");
        btnNuevoUsuario.setBorderPainted(false);
        btnNuevoUsuario.setContentAreaFilled(false);
        btnNuevoUsuario.setIconTextGap(0);
        btnNuevoUsuario.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnNuevoUsuario.setMaximumSize(new java.awt.Dimension(50, 50));
        btnNuevoUsuario.setMinimumSize(new java.awt.Dimension(50, 50));
        btnNuevoUsuario.setPreferredSize(new java.awt.Dimension(50, 50));
        btnNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoUsuarioActionPerformed(evt);
            }
        });

        grupoBotones.add(radioNDoc);
        radioNDoc.setText("Por Nº Documento");
        radioNDoc.setActionCommand("CAST(u.num_doc_usu AS INT)");
        radioNDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNDocActionPerformed(evt);
            }
        });

        grupoBotones.add(radioCodigo);
        radioCodigo.setSelected(true);
        radioCodigo.setText("Por Código");
        radioCodigo.setActionCommand("u.id_usuario");
        radioCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCodigoActionPerformed(evt);
            }
        });

        btnAnterior.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnAnterior.setText("<");
        btnAnterior.setEnabled(false);
        btnAnterior.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnSiguiente.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSiguiente.setText(">");
        btnSiguiente.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        campoNum.getInputMap(JComponent.WHEN_FOCUSED).put(enter, "Enter");
        campoNum.getActionMap().put("Enter", new AbstractAction() {
            @Override public void actionPerformed(ActionEvent e) {
                try {
                    int v = Integer.parseInt(campoNum.getText());
                    if(v>0 && v<=cantidad) {
                        pagina = v;
                        btnAnterior.setEnabled(pagina > 1);
                        btnSiguiente.setEnabled(cantidad > pagina);
                    }
                } catch(Exception ex) {
                    Logger.getLogger(ListaUsuarios.class.getName()).log(Level.WARNING, "Error al parsear número: ", ex);
                }
                relistar(grupoBotones.getSelection().getActionCommand());
            }
        });
        campoNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNumKeyTyped(evt);
            }
        });

        labelBarra.setText("/");

        btnHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/history.png"))); // NOI18N
        btnHistorial.setToolTipText("Mostrar Historial de Pago de Usuario");
        btnHistorial.setBorderPainted(false);
        btnHistorial.setContentAreaFilled(false);
        btnHistorial.setIconTextGap(0);
        btnHistorial.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnHistorial.setMaximumSize(new java.awt.Dimension(50, 50));
        btnHistorial.setMinimumSize(new java.awt.Dimension(50, 50));
        btnHistorial.setPreferredSize(new java.awt.Dimension(50, 50));
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });

        grupoBotones.add(radioApellido);
        radioApellido.setText("Por Apellido");
        radioApellido.setActionCommand("u.apellido_usu");
        radioApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioApellidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(223, 223, 223)
                                .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(campoNum, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelBarra)
                                .addGap(2, 2, 2)
                                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(297, 297, 297)
                                .addComponent(radioCodigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioApellido)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioNDoc)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelBuscar)
                            .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioCodigo)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioApellido)
                            .addComponent(radioNombre)
                            .addComponent(radioNDoc))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelBarra))))))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoUsuarioActionPerformed
        RegUsuario u = new RegUsuario();
        Funciones.centrar(u, conexion.InicioSesion.getUsuario().contains("admin")?PrincipalAdmin.panelEscritorio:Principal.panelEscritorio);
        u.setLocked(true);
        radioCodigo.setSelected(true);
        btnNuevoUsuario.setEnabled(false);
    }//GEN-LAST:event_btnNuevoUsuarioActionPerformed

    private void tablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuariosMouseClicked
        if(evt.getClickCount() == 2){
            if(tablaUsuarios.getSelectedRow() >= 0){
                DetalleUsuario du = new DetalleUsuario(this, true, Integer.parseInt(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0).toString()));
                du.setLocationRelativeTo(conexion.InicioSesion.getUsuario().contains("admin")?PrincipalAdmin.panelEscritorio:Principal.panelEscritorio);
                du.setVisible(true);
            }
        }
    }//GEN-LAST:event_tablaUsuariosMouseClicked

    private void tablaUsuariosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaUsuariosFocusGained
        if(evt.getComponent().getMousePosition() == null){if(tablaUsuarios.getSelectedRow() < 0){tablaUsuarios.changeSelection(0, 0, false, false);}}
    }//GEN-LAST:event_tablaUsuariosFocusGained

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        limpiar();
        ++pagina;
        btnAnterior.setEnabled(pagina > 1);
        btnSiguiente.setEnabled(cantidad > pagina);
        relistar(grupoBotones.getSelection().getActionCommand());
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        limpiar();
        --pagina;
        btnAnterior.setEnabled(pagina > 1);
        btnSiguiente.setEnabled(cantidad > pagina);
        relistar(grupoBotones.getSelection().getActionCommand());
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void campoNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNumKeyTyped
        if(!Validaciones.Numeros(evt.getKeyChar())) evt.consume();
    }//GEN-LAST:event_campoNumKeyTyped

    private void radioCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCodigoActionPerformed
        relistar(radioCodigo.getActionCommand());
        btnAnterior.setEnabled(pagina > 1);
        btnSiguiente.setEnabled(cantidad > pagina);
        campoNum.setEnabled(true);
    }//GEN-LAST:event_radioCodigoActionPerformed

    private void radioNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNombreActionPerformed
        relistar(radioNombre.getActionCommand());
        btnAnterior.setEnabled(pagina > 1);
        btnSiguiente.setEnabled(cantidad > pagina);
        campoNum.setEnabled(true);
    }//GEN-LAST:event_radioNombreActionPerformed

    private void radioNDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNDocActionPerformed
        relistar(radioNDoc.getActionCommand());
        btnAnterior.setEnabled(pagina > 1);
        btnSiguiente.setEnabled(cantidad > pagina);
        campoNum.setEnabled(true);
    }//GEN-LAST:event_radioNDocActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        btnHistorial.setEnabled(false);
        if(tablaUsuarios.getSelectedRow() > -1){
            Integer elID = Integer.parseInt(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0).toString());
                String[] opciones = {"Todo el Historial", "S/ Fecha"};
                int seleccion = javax.swing.JOptionPane.showOptionDialog(null, "¿Qué tipo de informe de pagos desea generar?", "Generar Informe",
                    javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                switch(seleccion){
                    case 0:
                        reportes.Informes inf = new reportes.Informes();
                        inf.mostrarHistorialPago(dao.Reportes.obtenerHistorial(elID.toString(), null, null), tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 1).toString(), elID, null, null);
                        btnHistorial.setEnabled(true);
                        break;
                    case 1: 
                        interfaces.dialogos.FechasParam ec = new interfaces.dialogos.FechasParam(this, btnHistorial, elID, tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 1).toString(), true);
                        ec.setLocationRelativeTo(this);
                        ec.setVisible(true);
                        break;
                    default: btnHistorial.setEnabled(true);
                }
        }
        else {JOptionPane.showMessageDialog(null, "Seleccione un usuario para mostrar su historial.", "Seleccionar Lote", JOptionPane.WARNING_MESSAGE); btnHistorial.setEnabled(true);}
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void radioApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioApellidoActionPerformed
        relistar(radioApellido.getActionCommand());
        btnAnterior.setEnabled(pagina > 1);
        btnSiguiente.setEnabled(cantidad > pagina);
        campoNum.setEnabled(true);
    }//GEN-LAST:event_radioApellidoActionPerformed

    private void asignarEventos(){
        KeyStroke acc = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        campoBuscar.getInputMap(JComponent.WHEN_FOCUSED).put(acc, "Enter");
        campoBuscar.getActionMap().put("Enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(campoBuscar.getText().isEmpty()) return;
                    ((TablaUsuarios)tablaUsuarios.getModel()).limpiar();
                    ((TablaUsuarios)tablaUsuarios.getModel()).setUsuarios(dao.Usuarios.listarUsuariosLike(grupoBotones.getSelection().getActionCommand(), campoBuscar.getText()));
                    pagina = cantidad = 1;
                    campoNum.setText(String.format("%d", pagina));
                    labelBarra.setText(String.format("/%d", cantidad));
                    campoNum.setEnabled(false);
                    btnAnterior.setEnabled(false);
                    btnSiguiente.setEnabled(false);
                }
                catch(Exception ex){Logger.getLogger(ListaUsuarios.class.getName()).log(Level.SEVERE, "Error al intentar listar usuarios: ", ex);}
              }
        });
        KeyStroke del = KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0);
        campoBuscar.getInputMap(JComponent.WHEN_FOCUSED).put(del, "Delete");
        campoBuscar.getActionMap().put("Delete", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    campoBuscar.setText("");
                    totalFilas();
                    labelBarra.setText(String.format("/%d", cantidad));
                    relistar(grupoBotones.getSelection().getActionCommand());
                    campoNum.setEnabled(true);
                    btnAnterior.setEnabled(pagina > 1);
                    btnSiguiente.setEnabled(cantidad > pagina);
                }
                catch(Exception ex){Logger.getLogger(ListaUsuarios.class.getName()).log(Level.SEVERE, "Error no definido al listar usuarios: ", ex);}
            }
        });
        tablaUsuarios.getInputMap(javax.swing.JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(acc, "Enter");
        tablaUsuarios.getActionMap().put("Enter", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                if(tablaUsuarios.getRowCount() > 0){
                    DetalleUsuario du = new DetalleUsuario(ListaUsuarios.this, true, Integer.parseInt(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0).toString()));
                    du.setLocationRelativeTo(conexion.InicioSesion.getUsuario().contains("admin")?PrincipalAdmin.panelEscritorio:Principal.panelEscritorio);
                    du.setVisible(true);
                }
            }
        });        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    protected static javax.swing.JButton btnHistorial;
    protected static javax.swing.JButton btnNuevoUsuario;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JTextField campoBuscar;
    private static javax.swing.JTextField campoNum;
    private javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JLabel labelBarra;
    private javax.swing.JLabel labelBuscar;
    private javax.swing.JRadioButton radioApellido;
    private javax.swing.JRadioButton radioCodigo;
    private javax.swing.JRadioButton radioNDoc;
    private javax.swing.JRadioButton radioNombre;
    protected static javax.swing.JTable tablaUsuarios;
    // End of variables declaration//GEN-END:variables
}
