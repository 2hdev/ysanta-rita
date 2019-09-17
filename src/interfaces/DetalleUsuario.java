package interfaces;

import clases.tablas.TablaUsuarios;
import dao.Usuarios;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import utilidades.Funciones;
import utilidades.Validaciones;

public class DetalleUsuario extends javax.swing.JDialog {
    
    Funciones f;
    modelos.Usuario mu;
    Usuarios u;
    Integer idUsuario;
    List<modelos.Zona> zonas;
    modelos.Zona lacero = new modelos.Zona(0, "NINGUNA", "NINGUNA");
    
    public DetalleUsuario(javax.swing.JInternalFrame parent, boolean modal, Integer idUsuario) {
        this.idUsuario = idUsuario;
        f = new Funciones();
        zonas = dao.Zonas.listaZonas();
        initComponents();
        Funciones.cerrarConEscape(DetalleUsuario.this);
        u = new dao.Usuarios();
        mu = u.obtenerUsuarioPorId(idUsuario);
        campoCodigo.setText(idUsuario.toString());
        campoNombre.setText(mu.getNombre());
        campoApellido.setText(mu.getApellido());
        campoDireccion.setText(mu.getDireccion());
        campoTelefono.setText(mu.getTelefono());
        campoDocN.setText(mu.getNumDocumento().contains("-")?mu.getNumDocumento().substring(0, mu.getNumDocumento().indexOf("-")):mu.getNumDocumento());
        labelDV.setText(mu.getNumDocumento().contains("-")?mu.getNumDocumento().substring(mu.getNumDocumento().indexOf("-")+1):"");
        comboDoc.setSelectedItem(mu.getTipoDocumento());
        comboTD.setSelectedItem(mu.getTipodesc());
        campoMonto.setText(mu.getMontoDescuento().toString());
        campoPlazo.setDate(mu.getPlazoDescuento());
        campoPlazo.setEnabled(false);
        campoMonto.setEnabled(false);
        campoObs.setText(mu.getObs());
        if(mu.getIdZona().equals(lacero.getIdentificador())) {comboZona.setSelectedIndex(lacero.getIdentificador());}
        else{
            for(int i = 0; i<comboZona.getModel().getSize(); i++){
                if(Objects.equals(((modelos.Zona)comboZona.getItemAt(i)).getIdentificador(), mu.getIdZona())){comboZona.setSelectedIndex(i); break;}
            }
        }
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
        labelMedidor = new javax.swing.JLabel();
        Sep1 = new javax.swing.JSeparator();
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
        btnEditar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaMedidores = new javax.swing.JList(dao.Cuentas.obtenerCuentasYMedidores(idUsuario).toArray());
        labelTD = new javax.swing.JLabel();
        comboTD = new javax.swing.JComboBox();
        campoMonto = new javax.swing.JTextField();
        labelPlazo = new javax.swing.JLabel();
        campoPlazo = new com.toedter.calendar.JDateChooser();
        btnVer = new javax.swing.JButton();
        labelZona = new javax.swing.JLabel();
        comboZona = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalle de Usuario");
        setModal(true);
        setName("detalleUsuario"); // NOI18N
        setType(java.awt.Window.Type.POPUP);

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(utilidades.Estaticos.ICONO)));

        labelCodigo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelCodigo.setText("Código:");

        campoCodigo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoCodigo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        campoCodigo.setEnabled(false);

        labelNombre.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelNombre.setText("Nombres/s:");

        campoNombre.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoNombre.setEnabled(false);
        campoNombre.setName("nombre_usu"); // NOI18N
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
        labelDireccion.setText("Dirección:");

        campoDireccion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoDireccion.setEnabled(false);
        campoDireccion.setName("direccion_usu"); // NOI18N
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
        labelTelefono.setText("Teléfono:");

        campoTelefono.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoTelefono.setEnabled(false);
        campoTelefono.setName("telefono_usu"); // NOI18N
        campoTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoTelefonoFocusLost(evt);
            }
        });
        campoTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoTelefonoKeyTyped(evt);
            }
        });

        labelMedidor.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelMedidor.setText("Medidores Asignados:");

        labelDoc.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelDoc.setText("Tipo de Documento:");

        comboDoc.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        comboDoc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CI", "RUC", "DNI" }));
        comboDoc.setEnabled(false);
        comboDoc.setName("tipo_doc_usu"); // NOI18N

        campoDocN.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoDocN.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        campoDocN.setEnabled(false);
        campoDocN.setName("num_doc_usu"); // NOI18N
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
        labelApellido.setText("Apellido/s:");

        campoApellido.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoApellido.setEnabled(false);
        campoApellido.setName("apellido_usu"); // NOI18N
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
        campoObs.setEnabled(false);
        campoObs.setName("obs_usu"); // NOI18N
        campoObs.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoObsFocusLost(evt);
            }
        });
        campoObs.addKeyListener(new java.awt.event.KeyAdapter() {
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

        labelDV.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelDV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        btnEditar.setToolTipText("Editar Usuario");
        btnEditar.setBorderPainted(false);
        btnEditar.setContentAreaFilled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        listaMedidores.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        listaMedidores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaMedidores.setToolTipText("Modifique los datos de este campo desde el módulo \"Medidores\".");
        jScrollPane2.setViewportView(listaMedidores);

        labelTD.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelTD.setText("Tipo de Descuento:");

        comboTD.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        comboTD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NINGUNO", "PORCENTAJE", "MONTO" }));
        comboTD.setEnabled(false);
        comboTD.setName("tipo_descuento"); // NOI18N
        comboTD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTDActionPerformed(evt);
            }
        });

        campoMonto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoMonto.setEnabled(false);
        campoMonto.setName("monto_descuento_usu"); // NOI18N
        campoMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoMontoKeyTyped(evt);
            }
        });

        labelPlazo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelPlazo.setText("Plazo:");

        campoPlazo.setDateFormatString("dd/MM/yyyy");
        campoPlazo.setEnabled(false);
        campoPlazo.setMaxSelectableDate(new java.util.Date(32503694508000L));
        campoPlazo.setMinSelectableDate(new java.util.Date(-2208974960000L));
        campoPlazo.setName("plazo_descuento"); // NOI18N
        campoPlazo.getDateEditor().getUiComponent().addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if(Validaciones.Letras(evt.getKeyChar()) || Validaciones.Espacio(evt.getKeyChar())) evt.consume();
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

        labelZona.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelZona.setText("Zona:");

        comboZona.setModel(new javax.swing.DefaultComboBoxModel(zonas.toArray()));
        comboZona.insertItemAt(lacero, 0);
        comboZona.setSelectedIndex(0);
        comboZona.setEnabled(false);
        comboZona.setName("id_zona"); // NOI18N

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelContenedorLayout.createSequentialGroup()
                            .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelNombre)
                                .addComponent(labelCodigo))
                            .addGap(18, 18, 18)
                            .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panelContenedorLayout.createSequentialGroup()
                                    .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(202, 202, 202)
                                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelContenedorLayout.createSequentialGroup()
                            .addComponent(labelMedidor)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelContenedorLayout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar))
                            .addComponent(Sep1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelContenedorLayout.createSequentialGroup()
                            .addComponent(labelDoc)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(comboDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(labelDocN)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(campoDocN, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelDV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(panelContenedorLayout.createSequentialGroup()
                            .addComponent(labelObs)
                            .addGap(28, 28, 28)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelContenedorLayout.createSequentialGroup()
                            .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelTD)
                                .addComponent(labelPlazo))
                            .addGap(18, 18, 18)
                            .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelContenedorLayout.createSequentialGroup()
                                    .addComponent(comboTD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(campoMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(campoPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelApellido)
                            .addComponent(labelDireccion)
                            .addComponent(labelTelefono)
                            .addComponent(labelZona))
                        .addGap(23, 23, 23)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboZona, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(campoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(campoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(55, 55, 55))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelCodigo)
                        .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEditar))
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
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelZona))
                .addGap(15, 15, 15)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefono)
                    .addComponent(campoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelDoc)
                        .addComponent(comboDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelDocN)
                        .addComponent(campoDocN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelDV, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(Sep1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMedidor)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnVer)))
                .addGap(15, 15, 15)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addGap(27, 27, 27))
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
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNombreFocusLost
        campoNombre.setText(f.removerEspaciosExtra(campoNombre.getText()));
        campoNombre.setText(campoNombre.getText().trim());
    }//GEN-LAST:event_campoNombreFocusLost

    private void campoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNombreKeyTyped
        f.convertirAMayusculas(evt);
        if(Validaciones.Longitud(campoNombre, 45)) evt.consume();
    }//GEN-LAST:event_campoNombreKeyTyped

    private void campoDireccionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoDireccionFocusLost
        campoDireccion.setText(f.removerEspaciosExtra(campoDireccion.getText()));
    }//GEN-LAST:event_campoDireccionFocusLost

    private void campoDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDireccionKeyTyped
        f.convertirAMayusculas(evt);
        if(Validaciones.Longitud(campoDireccion, 100)) evt.consume();
    }//GEN-LAST:event_campoDireccionKeyTyped

    private void campoTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTelefonoKeyTyped
        if(Validaciones.Letras(evt.getKeyChar())) evt.consume();
        if(Validaciones.Longitud(campoTelefono, 12)) evt.consume();
    }//GEN-LAST:event_campoTelefonoKeyTyped

    private void campoDocNFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoDocNFocusLost
        calcularRUC();
    }//GEN-LAST:event_campoDocNFocusLost

    private void campoDocNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDocNKeyTyped
        if(!Validaciones.Numeros(evt.getKeyChar())) evt.consume();
        if(Validaciones.Longitud(campoDocN, 13)) evt.consume();
    }//GEN-LAST:event_campoDocNKeyTyped

    private void campoApellidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoApellidoFocusLost
        campoApellido.setText(f.removerEspaciosExtra(campoApellido.getText()));
        campoApellido.setText(campoApellido.getText().trim());
    }//GEN-LAST:event_campoApellidoFocusLost

    private void campoApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoApellidoKeyTyped
        f.convertirAMayusculas(evt);
        if(Validaciones.Longitud(campoApellido, 45)) evt.consume();
    }//GEN-LAST:event_campoApellidoKeyTyped

    private void campoObsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoObsFocusLost
        campoObs.setText(f.removerEspaciosExtra(campoObs.getText()));
        campoObs.setText(campoObs.getText().trim());
    }//GEN-LAST:event_campoObsFocusLost

    private void campoObsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoObsKeyTyped
        f.convertirAMayusculas(evt);
    }//GEN-LAST:event_campoObsKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(!f.recorrerHabilitados(panelContenedor)) return;
        calcularRUC();
        java.util.Map cambios = new java.util.HashMap();
        if(!mu.getTipoDocumento().equals(comboDoc.getSelectedItem())) {
            cambios.put(String.format("%s=?", comboDoc.getName()), comboDoc.getSelectedItem().toString());
        }
        if(comboDoc.getSelectedItem().equals("RUC")){
            if(mu.getNumDocumento().contains("-")){
                if(!campoDocN.getText().equals(mu.getNumDocumento().substring(0, mu.getNumDocumento().indexOf("-")))){
                    cambios.put(String.format("%s=?", campoDocN.getName()), campoDocN.getText()+"-"+labelDV.getText());
                }
            }
            else cambios.put(String.format("%s=?", campoDocN.getName()), campoDocN.getText()+"-"+labelDV.getText());
        }
        else if(!campoDocN.getText().equals(mu.getNumDocumento())) {
            cambios.put(String.format("%s=?", campoDocN.getName()), campoDocN.getText());
        }
        
        if(comboTD.getSelectedItem().equals(mu.getTipodesc())){
            if(!comboTD.getSelectedItem().equals("NINGUNO")){
                if(!campoMonto.getText().equals(mu.getMontoDescuento().toString())) {
                    cambios.put(String.format("%s=?", campoMonto.getName()), comboTD.getSelectedItem().equals("NINGUNO")?"0":campoMonto.getText());
                }

                if(!campoPlazo.getDate().equals(mu.getPlazoDescuento())) {
                    cambios.put(String.format("%s=?", campoPlazo.getName()), comboTD.getSelectedItem().equals("NINGUNO")?null:((javax.swing.JTextField)(campoPlazo.getDateEditor().getUiComponent())).getText());
                }
            }
        }
        else {
            cambios.put(String.format("%s=?", comboTD.getName()), comboTD.getSelectedItem().toString());
            cambios.put(String.format("%s=?", campoMonto.getName()), comboTD.getSelectedItem().equals("NINGUNO")?"0":campoMonto.getText());
            cambios.put(String.format("%s=?", campoPlazo.getName()), comboTD.getSelectedItem().equals("NINGUNO")?null:((javax.swing.JTextField)(campoPlazo.getDateEditor().getUiComponent())).getText());
        }
        
        if(!mu.getNombre().equals(campoNombre.getText())) {cambios.put(String.format("%s=?", campoNombre.getName()), campoNombre.getText());}
        if(!mu.getApellido().equals(campoApellido.getText())){cambios.put(String.format("%s=?", campoApellido.getName()), campoApellido.getText());}
        if(!mu.getDireccion().equals(campoDireccion.getText())) {cambios.put(String.format("%s=?", campoDireccion.getName()), campoDireccion.getText());}
        if(!mu.getTelefono().equals(campoTelefono.getText())) {cambios.put(String.format("%s=?", campoTelefono.getName()), campoTelefono.getText());}
        if(!mu.getObs().equals(campoObs.getText())) {cambios.put(String.format("%s=?", campoObs.getName()), campoObs.getText());}
        if(!mu.getIdZona().equals(((modelos.Zona)comboZona.getSelectedItem()).getIdentificador())){cambios.put(String.format("%s=?", comboZona.getName()), ((modelos.Zona)comboZona.getSelectedItem()).getIdentificador().toString());}

       if(u.actualizarUsuario(cambios, idUsuario)){
            JOptionPane.showMessageDialog(null, "Se actualizaron los datos correctamente.");
            f.limpiarCampos(panelContenedor);
            ListaUsuarios.pagina = 1;
            ListaUsuarios.cantidad = 1;
            if(conexion.InicioSesion.getUsuario().contains("admin")){PrincipalAdmin.lu.getBtnAnterior().setEnabled(ListaUsuarios.pagina > 1); PrincipalAdmin.lu.getBtnSiguiente().setEnabled(ListaUsuarios.cantidad > ListaUsuarios.pagina);} 
            else {Principal.lu.getBtnAnterior().setEnabled(ListaUsuarios.pagina > 1); Principal.lu.getBtnSiguiente().setEnabled(ListaUsuarios.cantidad > ListaUsuarios.pagina);}
            ((TablaUsuarios)ListaUsuarios.tablaUsuarios.getModel()).limpiar();
            ((TablaUsuarios)ListaUsuarios.tablaUsuarios.getModel()).setUsuarios(dao.Usuarios.listarUsuariosPag(ListaUsuarios.pagina, null));
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "No se ha podido actualizar los datos.");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        f.habilitarCampos(panelContenedor);
        campoCodigo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(true);
        campoObs.setEnabled(true);
        campoPlazo.setEnabled(true);
        comboZona.setEnabled(true);
        if(comboTD.getSelectedItem().equals("NINGUNO")) campoPlazo.setEnabled(false); campoMonto.setEnabled(false);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void campoTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoTelefonoFocusLost
        campoTelefono.setText(f.removerEspaciosExtra(campoTelefono.getText()));
        campoTelefono.setText(campoTelefono.getText().trim());
    }//GEN-LAST:event_campoTelefonoFocusLost

    private void comboTDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTDActionPerformed
        if(comboTD.getSelectedItem().toString().equals("NINGUNO")){
            campoMonto.setText("");
            campoMonto.setEnabled(false);
            ((javax.swing.JTextField)campoPlazo.getDateEditor().getUiComponent()).setText("");
            campoPlazo.setEnabled(false);   
        }
        else {
            campoMonto.setText("");
            campoMonto.setEnabled(true);
            ((javax.swing.JTextField)campoPlazo.getDateEditor().getUiComponent()).setText("");
            campoPlazo.setEnabled(true);
            f.agregarPlaceHolder(campoMonto, "Escriba el monto o % de descuento");
            f.agregarPlaceHolder(((javax.swing.JTextField)campoPlazo.getDateEditor().getUiComponent()), "dd/MM/aaaa");
            Calendar cal = Calendar.getInstance(); cal.setTime(new java.util.Date()); cal.add(Calendar.YEAR, 2);
            campoPlazo.setDate(cal.getTime());
        }
    }//GEN-LAST:event_comboTDActionPerformed

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

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        if(listaMedidores.getSelectedIndex()>=0){
            reportes.Informes inf = new reportes.Informes();
            inf.mostrarResumenCuenta(dao.Reportes.obtenerResumenCuenta(listaMedidores.getSelectedValue().getIdentificador()), this);
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "Seleccione un medidor en la lista para obtener su resumen de cuenta.", "Seleccionar en la lista", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnVerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator Sep1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVer;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelApellido;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelDV;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelDoc;
    private javax.swing.JLabel labelDocN;
    private javax.swing.JLabel labelMedidor;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelObs;
    private javax.swing.JLabel labelPlazo;
    private javax.swing.JLabel labelTD;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel labelZona;
    private javax.swing.JList<modelos.Cuenta> listaMedidores;
    private javax.swing.JPanel panelContenedor;
    // End of variables declaration//GEN-END:variables
}
