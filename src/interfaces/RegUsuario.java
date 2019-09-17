package interfaces;

import java.util.Calendar;
import javax.swing.JOptionPane;
import utilidades.Funciones;
import utilidades.Validaciones;

public class RegUsuario extends javax.swing.JInternalFrame {

    Funciones f;
    dao.Usuarios u;
    modelos.Usuario mu;
    modelos.Zona lacero = new modelos.Zona(0, "NINGUNA", "NINGUNA");
    
    public RegUsuario() {
        initComponents();
        f = new Funciones();
        u = new dao.Usuarios();
        campoCodigo.setText(String.valueOf(u.obtenerID()));
        inhabilitar();
    }
    
    private void inhabilitar(){
        campoMonto.setText("");
        campoMonto.setEnabled(false);
        ((javax.swing.JTextField)campoPlazo.getDateEditor().getUiComponent()).setText("");
        campoPlazo.setEnabled(false);   
    }
    
    void habilitar(){
        campoMonto.setText("");
        campoMonto.setEnabled(true);
        ((javax.swing.JTextField)campoPlazo.getDateEditor().getUiComponent()).setText("");
        campoPlazo.setEnabled(true);
        f.agregarPlaceHolder(campoMonto, "Escriba el monto o % de descuento");
        f.agregarPlaceHolder(((javax.swing.JTextField)campoPlazo.getDateEditor().getUiComponent()), "dd/MM/aaaa");
        Calendar cal = Calendar.getInstance(); cal.setTime(new java.util.Date()); cal.add(Calendar.YEAR, 2);
        campoPlazo.setDate(cal.getTime());
    }
    
    private void calcularRUC(){
        if(String.valueOf(comboDoc.getSelectedItem()).equals("RUC")){
            labelDV.setVisible(true);
            if(campoDocN.getText().isEmpty()){
                campoDocN.requestFocus();
            }
            else{
            campoObs.requestFocus();
            Integer dv = f.calcularRUC(campoDocN.getText());
            labelDV.setText(dv.toString());
            }
        }
        else {
            labelDV.setVisible(false);
            labelDV.setText("_");
        }
    }

    @Override
    public void dispose() {
        ListaUsuarios.btnNuevoUsuario.setEnabled(true);
        super.dispose();
    }
    private boolean locked;
    @Override
    public void reshape(int x, int y, int width, int height) {
        if(!locked) super.reshape(x, y, width, height);
    }
    
    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        labelCodigo = new javax.swing.JLabel();
        campoCodigo = new javax.swing.JTextField();
        labelNombre = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        labelDireccion = new javax.swing.JLabel();
        campoDireccion = new javax.swing.JTextField();
        labelTelefono = new javax.swing.JLabel();
        campoTelefono = new javax.swing.JTextField();
        labelDoc = new javax.swing.JLabel();
        comboDoc = new javax.swing.JComboBox();
        campoDocN = new javax.swing.JTextField();
        labelDocN = new javax.swing.JLabel();
        labelApellido = new javax.swing.JLabel();
        campoApellido = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoObs = new javax.swing.JTextArea();
        labelObs = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        labelDV = new javax.swing.JLabel();
        labelTD = new javax.swing.JLabel();
        comboTD = new javax.swing.JComboBox();
        campoMonto = new javax.swing.JTextField();
        labelPlazo = new javax.swing.JLabel();
        campoPlazo = new com.toedter.calendar.JDateChooser();
        labelZona = new javax.swing.JLabel();
        comboZona = new javax.swing.JComboBox<>();

        setClosable(true);
        setTitle("Registrar Usuario");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/y_mini.png"))); // NOI18N

        labelCodigo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelCodigo.setText("Código:");

        campoCodigo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoCodigo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        campoCodigo.setEnabled(false);

        labelNombre.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelNombre.setLabelFor(campoNombre);
        labelNombre.setText("Nombre/s:");

        campoNombre.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoNombreFocusLost(evt);
            }
        });
        campoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNombreKeyTyped(evt);
            }
        });

        labelDireccion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelDireccion.setLabelFor(campoDireccion);
        labelDireccion.setText("Dirección:");

        campoDireccion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoDireccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoDireccionFocusLost(evt);
            }
        });
        campoDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoDireccionKeyTyped(evt);
            }
        });

        labelTelefono.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelTelefono.setLabelFor(campoTelefono);
        labelTelefono.setText("Teléfono:");

        campoTelefono.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoTelefonoKeyTyped(evt);
            }
        });

        labelDoc.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelDoc.setText("Tipo de Documento:");

        comboDoc.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        comboDoc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CI", "RUC", "DNI" }));
        comboDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDocActionPerformed(evt);
            }
        });

        campoDocN.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoDocN.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        campoDocN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoDocNFocusLost(evt);
            }
        });
        campoDocN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoDocNKeyTyped(evt);
            }
        });

        labelDocN.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelDocN.setText("Documento Nº:");

        labelApellido.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelApellido.setLabelFor(campoApellido);
        labelApellido.setText("Apellido/s:");

        campoApellido.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoApellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoApellidoFocusLost(evt);
            }
        });
        campoApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoApellidoKeyTyped(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        campoObs.setColumns(20);
        campoObs.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoObs.setLineWrap(true);
        campoObs.setRows(5);
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
        campoObs.getAccessibleContext().setAccessibleParent(panelContenedor);

        labelObs.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelObs.setText("Observación:");

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

        labelDV.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelDV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelDV.setText("_");
        labelDV.setVisible(false);

        labelTD.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelTD.setText("Tipo de Descuento:");

        comboTD.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        comboTD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NINGUNO", "PORCENTAJE", "MONTO" }));
        comboTD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTDActionPerformed(evt);
            }
        });

        campoMonto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoMontoKeyTyped(evt);
            }
        });

        labelPlazo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelPlazo.setText("Plazo:");

        campoPlazo.setDateFormatString("dd/MM/yyyy");
        campoPlazo.setMaxSelectableDate(new java.util.Date(32503694508000L));
        campoPlazo.setMinSelectableDate(new java.util.Date(-2208974960000L));
        campoPlazo.getDateEditor().getUiComponent().addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if(Validaciones.Letras(evt.getKeyChar()) || Validaciones.Espacio(evt.getKeyChar())) evt.consume();
            }
        });

        labelZona.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelZona.setText("Zona:");

        comboZona.setModel(new javax.swing.DefaultComboBoxModel(dao.Zonas.listaZonas().toArray()));
        comboZona.insertItemAt(lacero, 0);
        comboZona.setSelectedIndex(lacero.getIdentificador());

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelObs)
                    .addComponent(labelPlazo)
                    .addComponent(labelTD)
                    .addComponent(labelDoc)
                    .addComponent(labelTelefono)
                    .addComponent(labelZona)
                    .addComponent(labelDireccion)
                    .addComponent(labelApellido)
                    .addComponent(labelNombre)
                    .addComponent(labelCodigo))
                .addGap(18, 18, 18)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(campoDireccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                        .addComponent(campoApellido, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(campoNombre, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelContenedorLayout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar))
                            .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelContenedorLayout.createSequentialGroup()
                                    .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(comboTD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(panelContenedorLayout.createSequentialGroup()
                                            .addComponent(labelDocN)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(campoDocN, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(campoMonto)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelDV, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(comboZona, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCodigo)
                    .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelApellido)
                    .addComponent(campoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDireccion)
                    .addComponent(campoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(labelZona)
                    .addComponent(comboZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefono)
                    .addComponent(campoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDocN)
                    .addComponent(campoDocN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDV)
                    .addComponent(labelDoc)
                    .addComponent(comboDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTD)
                    .addComponent(comboTD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPlazo)
                    .addComponent(campoPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelObs)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addGap(30, 30, 30))
        );

        campoMonto.getAccessibleContext().setAccessibleParent(this);
        campoPlazo.getAccessibleContext().setAccessibleParent(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("RegUsuario");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoMontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoMontoKeyTyped
        if(!Validaciones.Numeros(evt.getKeyChar())) evt.consume();
        if(campoMonto.getCaretPosition() == 0){
            if(evt.getKeyChar() == 48) evt.consume(); //previene el 0 como primer valor
        }
        switch(comboTD.getSelectedItem().toString()){
            case "PORCENTAJE":
            if(Validaciones.Longitud(campoMonto, 3)) evt.consume();
            if((campoMonto.getText().length() > 0) && Integer.parseInt(campoMonto.getText()) > 10) evt.consume();
            if((campoMonto.getText().length() > 0) && (Integer.parseInt(campoMonto.getText()) == 10 && evt.getKeyChar() != 48)) evt.consume();
            break;
            case "MONTO":
            if(Validaciones.Longitud(campoMonto, 11)) evt.consume();
        }
    }//GEN-LAST:event_campoMontoKeyTyped

    private void comboTDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTDActionPerformed
        if(comboTD.getSelectedItem().toString().equals("NINGUNO")){
            inhabilitar();
        }
        else habilitar();
    }//GEN-LAST:event_comboTDActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(!f.recorrerHabilitados(panelContenedor)) return;
        if(campoPlazo.isEnabled()){if(!f.validarDateChooser(campoPlazo)) {campoPlazo.requestFocusInWindow(); return;}}
        calcularRUC();
        mu = new modelos.Usuario();
        mu.setIdentificador(Integer.parseInt(campoCodigo.getText()));
        mu.setNombre(campoNombre.getText());
        mu.setApellido(campoApellido.getText());
        mu.setDireccion(campoDireccion.getText());
        mu.setTelefono(campoTelefono.getText());
        mu.setTipoDocumento(String.valueOf(comboDoc.getSelectedItem()));
        mu.setNumDocumento((comboDoc.getSelectedItem().equals("RUC"))?campoDocN.getText()+"-"+labelDV.getText():campoDocN.getText());
        mu.setObs(campoObs.getText());
        mu.setTipodesc(comboTD.getSelectedItem().toString());
        mu.setMontoDescuento(campoMonto.isEnabled()?Integer.parseInt(campoMonto.getText()):0);
        mu.setPlazoDescuento(campoPlazo.isEnabled()?campoPlazo.getDate():null);
        mu.setIdZona(((modelos.Zona)comboZona.getSelectedItem()).getIdentificador());
        u = new dao.Usuarios();
        if(u.insertarUsuario(mu)){
            JOptionPane.showMessageDialog(null, "Se registró al usuario correctamente.");
            f.limpiarCampos(panelContenedor);
            ListaUsuarios.pagina = 1;
            ListaUsuarios.cantidad = 1;
            ListaUsuarios.relistar(null);
            if(conexion.InicioSesion.getUsuario().contains("admin")){PrincipalAdmin.lu.getBtnAnterior().setEnabled(ListaUsuarios.pagina > 1); PrincipalAdmin.lu.getBtnSiguiente().setEnabled(ListaUsuarios.cantidad > ListaUsuarios.pagina);}
            else {Principal.lu.getBtnAnterior().setEnabled(ListaUsuarios.pagina > 1); Principal.lu.getBtnSiguiente().setEnabled(ListaUsuarios.cantidad > ListaUsuarios.pagina);}
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "No se ha podido registrar los datos.");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void campoObsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoObsKeyTyped
        f.convertirAMayusculas(evt);
        if(campoObs.getText().length()>= 140) evt.consume();
    }//GEN-LAST:event_campoObsKeyTyped

    private void campoObsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoObsKeyPressed
        if(evt.getKeyCode()==evt.VK_TAB){
            utilidades.Funciones.transferirFoco(campoObs, evt);
        }
    }//GEN-LAST:event_campoObsKeyPressed

    private void campoObsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoObsFocusLost
        campoObs.setText(f.removerEspaciosExtra(campoObs.getText()));
        campoObs.setText(campoObs.getText().trim());
    }//GEN-LAST:event_campoObsFocusLost

    private void campoApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoApellidoKeyTyped
        f.convertirAMayusculas(evt);
        if(Validaciones.Longitud(campoApellido, 45)) evt.consume();
    }//GEN-LAST:event_campoApellidoKeyTyped

    private void campoApellidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoApellidoFocusLost
        campoApellido.setText(f.removerEspaciosExtra(campoApellido.getText()));
    }//GEN-LAST:event_campoApellidoFocusLost

    private void campoDocNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDocNKeyTyped
        if(campoDocN.getCaretPosition() == 0){
            if(evt.getKeyChar() == 48) evt.consume();
        }
        if(!Validaciones.Numeros(evt.getKeyChar())) evt.consume();
        if(Validaciones.Longitud(campoDocN, 13)) evt.consume();
    }//GEN-LAST:event_campoDocNKeyTyped

    private void campoDocNFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoDocNFocusLost
        calcularRUC();
    }//GEN-LAST:event_campoDocNFocusLost

    private void comboDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDocActionPerformed
        if(!comboDoc.getSelectedItem().toString().equals("RUC")){
            labelDV.setText("_");
            labelDV.setVisible(false);
        }
    }//GEN-LAST:event_comboDocActionPerformed

    private void campoTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTelefonoKeyTyped
        if(Validaciones.Letras(evt.getKeyChar())) evt.consume();
        if(Validaciones.Longitud(campoTelefono, 12)) evt.consume();
    }//GEN-LAST:event_campoTelefonoKeyTyped

    private void campoDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDireccionKeyTyped
        f.convertirAMayusculas(evt);
        if(Validaciones.Longitud(campoDireccion, 100)) evt.consume();
    }//GEN-LAST:event_campoDireccionKeyTyped

    private void campoDireccionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoDireccionFocusLost
        campoDireccion.setText(f.removerEspaciosExtra(campoDireccion.getText()));
        campoDireccion.setText(campoDireccion.getText().trim());
    }//GEN-LAST:event_campoDireccionFocusLost

    private void campoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNombreKeyTyped
        f.convertirAMayusculas(evt);
        if(Validaciones.Longitud(campoNombre, 45)) evt.consume();
    }//GEN-LAST:event_campoNombreKeyTyped

    private void campoNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNombreFocusLost
        campoNombre.setText(f.removerEspaciosExtra(campoNombre.getText()));
        campoNombre.setText(campoNombre.getText().trim());
    }//GEN-LAST:event_campoNombreFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JTextField campoApellido;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JTextField campoDireccion;
    private javax.swing.JTextField campoDocN;
    private javax.swing.JTextField campoMonto;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextArea campoObs;
    private com.toedter.calendar.JDateChooser campoPlazo;
    private javax.swing.JTextField campoTelefono;
    private javax.swing.JComboBox comboDoc;
    private javax.swing.JComboBox comboTD;
    private javax.swing.JComboBox<modelos.Zona> comboZona;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelApellido;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelDV;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelDoc;
    private javax.swing.JLabel labelDocN;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelObs;
    private javax.swing.JLabel labelPlazo;
    private javax.swing.JLabel labelTD;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel labelZona;
    private javax.swing.JPanel panelContenedor;
    // End of variables declaration//GEN-END:variables
}
