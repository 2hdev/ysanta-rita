package interfaces;

import clases.tablas.TablaLotePagos;
import clases.tablas.TablaPagos;
import static interfaces.ListaFacturasxLotes.tablaPagosxLote;
import static interfaces.ListaPagos.tablaPagos;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import utilidades.Funciones;
import utilidades.Validaciones;

public class NuevoPagoOtros extends javax.swing.JInternalFrame {

    Funciones f = new Funciones();
    String idLote;
    modelos.Usuario u;
    dao.Comprobante c = new dao.Comprobante();
    Integer descuento = 0;
    Integer montocuenta = 0;
    Integer importe = 0;
    Integer exenta = 0;
    Integer cinco = 0;
    Integer diez = 0;
    modelos.DetallePago dp;
    modelos.Pago p;
    java.util.Date hoy = new java.util.Date();

    public NuevoPagoOtros(String idLote) {
        initComponents();
        this.idLote = idLote;
        f.agregarPlaceHolder(((javax.swing.JTextField) campoFecha.getDateEditor().getUiComponent()), "dd/MM/aaaa");
        campoFecha.setDate(new java.util.Date());
    }

    @Override
    public void dispose() {
        ListaFacturasxLotes.btnNuevoPago.setEnabled(true);
        super.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioOpc = new javax.swing.ButtonGroup();
        panelContenedor = new javax.swing.JPanel();
        labelFecha = new javax.swing.JLabel();
        campoFecha = new com.toedter.calendar.JDateChooser();
        labelUsuario = new javax.swing.JLabel();
        campoNumUsuario = new javax.swing.JTextField();
        campoUsuario = new javax.swing.JTextField();
        labelNFact = new javax.swing.JLabel();
        labelConcepto = new javax.swing.JLabel();
        campoConcepto = new javax.swing.JTextField();
        labelImporte = new javax.swing.JLabel();
        campoImporte = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaConceptos = new javax.swing.JTable();
        campoNumFactRec = new javax.swing.JTextField();
        radioFact = new javax.swing.JRadioButton();
        radioRec = new javax.swing.JRadioButton();
        labelCantidad = new javax.swing.JLabel();
        campoCantidad = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        labelIVA = new javax.swing.JLabel();
        comboIVA = new javax.swing.JComboBox();
        labelIVA5 = new javax.swing.JLabel();
        labelIVA10 = new javax.swing.JLabel();
        labelTotalIVA = new javax.swing.JLabel();
        labelIVA5monto = new javax.swing.JLabel();
        labelIVA10monto = new javax.swing.JLabel();
        labelTotalIVAmonto = new javax.swing.JLabel();
        labelSub5 = new javax.swing.JLabel();
        labelSub10 = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        label10 = new javax.swing.JLabel();
        labelTotalmonto = new javax.swing.JLabel();
        labelSubEx = new javax.swing.JLabel();
        labelEx = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Nuevo Pago");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/y_mini.png"))); // NOI18N

        labelFecha.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelFecha.setText("Fecha:");

        campoFecha.setDateFormatString("dd/MM/yyyy");
        campoFecha.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoFecha.setMaxSelectableDate(new java.util.Date(32503694508000L));
        campoFecha.setMinSelectableDate(new java.util.Date(-2208974960000L));
        campoFecha.setNextFocusableComponent(campoUsuario);
        campoFecha.getDateEditor().getUiComponent().addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if(Validaciones.Letras(evt.getKeyChar()) || Validaciones.Espacio(evt.getKeyChar())) evt.consume();
            }
        });
        campoFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoFechaKeyPressed(evt);
            }
        });

        labelUsuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelUsuario.setText("Usuario:");

        campoNumUsuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoNumUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoNumUsuarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNumUsuarioKeyTyped(evt);
            }
        });

        campoUsuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoUsuario.setEnabled(false);
        campoUsuario.setFocusable(false);

        labelNFact.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelNFact.setText("Nº:");

        labelConcepto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelConcepto.setText("Concepto:");

        campoConcepto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoConcepto.setEnabled(false);
        campoConcepto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoConceptoFocusLost(evt);
            }
        });
        campoConcepto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoConceptoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoConceptoKeyTyped(evt);
            }
        });

        labelImporte.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelImporte.setText("Importe:");

        campoImporte.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoImporte.setEnabled(false);
        campoImporte.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoImporteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoImporteFocusLost(evt);
            }
        });
        campoImporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoImporteKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoImporteKeyTyped(evt);
            }
        });

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

        tablaConceptos.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tablaConceptos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cantidad", "Concepto", "Importe", "IVA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
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
        tablaConceptos.setToolTipText("");
        tablaConceptos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaConceptosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaConceptos);
        if (tablaConceptos.getColumnModel().getColumnCount() > 0) {
            tablaConceptos.getColumnModel().getColumn(0).setResizable(false);
            tablaConceptos.getColumnModel().getColumn(1).setResizable(false);
            tablaConceptos.getColumnModel().getColumn(2).setResizable(false);
            tablaConceptos.getColumnModel().getColumn(3).setResizable(false);
        }

        campoNumFactRec.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoNumFactRecFocusLost(evt);
            }
        });
        campoNumFactRec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoNumFactRecKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNumFactRecKeyTyped(evt);
            }
        });

        radioOpc.add(radioFact);
        radioFact.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        radioFact.setText("Factura");
        radioFact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFactActionPerformed(evt);
            }
        });

        radioOpc.add(radioRec);
        radioRec.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        radioRec.setSelected(true);
        radioRec.setText("Recibo");
        radioRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioRecActionPerformed(evt);
            }
        });

        labelCantidad.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelCantidad.setText("Cantidad:");

        campoCantidad.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoCantidad.setEnabled(false);
        campoCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoCantidadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoCantidadKeyTyped(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flechader.png"))); // NOI18N
        btnAdd.setToolTipText("Pulse este botón para agregar el detalle a la tabla.");
        btnAdd.setContentAreaFilled(false);
        btnAdd.setEnabled(false);
        btnAdd.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        labelIVA.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelIVA.setText("I.V.A.:");

        comboIVA.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "EXENTA", "5%", "10%" }));
        comboIVA.setSelectedIndex(2);
        comboIVA.setEnabled(false);
        comboIVA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboIVAKeyPressed(evt);
            }
        });

        labelIVA5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelIVA5.setText("I.V.A. 5%:");

        labelIVA10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelIVA10.setText("I.V.A. 10%:");

        labelTotalIVA.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelTotalIVA.setText("Total I.V.A.:");

        labelIVA5monto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelIVA5monto.setText("0");
        labelIVA5monto.setEnabled(false);
        labelIVA5monto.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        labelIVA10monto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelIVA10monto.setText("0");
        labelIVA10monto.setEnabled(false);
        labelIVA10monto.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        labelTotalIVAmonto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelTotalIVAmonto.setText("0");
        labelTotalIVAmonto.setEnabled(false);
        labelTotalIVAmonto.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        labelSub5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelSub5.setText("Subtotal 5%:");

        labelSub10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelSub10.setText("Subtotal 10%:");

        labelTotal.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelTotal.setText("Total:");

        label5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        label5.setText("0");
        label5.setEnabled(false);
        label5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        label10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        label10.setText("0");
        label10.setEnabled(false);
        label10.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        labelTotalmonto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelTotalmonto.setText("0");
        labelTotalmonto.setEnabled(false);
        labelTotalmonto.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        labelSubEx.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelSubEx.setText("Subtotal Exenta:");

        labelEx.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelEx.setText("0");
        labelEx.setEnabled(false);
        labelEx.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTotalIVA, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelIVA10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelIVA5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelIVA5monto)
                            .addComponent(labelIVA10monto)
                            .addComponent(labelTotalIVAmonto))
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelContenedorLayout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar))
                            .addGroup(panelContenedorLayout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelContenedorLayout.createSequentialGroup()
                                        .addComponent(labelSubEx)
                                        .addGap(18, 18, 18)
                                        .addComponent(labelEx))
                                    .addGroup(panelContenedorLayout.createSequentialGroup()
                                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelTotal, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(labelSub10, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(labelSub5, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(18, 18, 18)
                                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label5)
                                            .addComponent(label10)
                                            .addComponent(labelTotalmonto)))))))
                    .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelContenedorLayout.createSequentialGroup()
                            .addComponent(labelFecha)
                            .addGap(25, 25, 25)
                            .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelContenedorLayout.createSequentialGroup()
                            .addComponent(labelConcepto)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelContenedorLayout.createSequentialGroup()
                                    .addComponent(radioFact)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(radioRec)
                                    .addGap(39, 39, 39)
                                    .addComponent(labelNFact)
                                    .addGap(18, 18, 18)
                                    .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelContenedorLayout.createSequentialGroup()
                                            .addComponent(labelUsuario)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(campoNumUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(campoNumFactRec, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(panelContenedorLayout.createSequentialGroup()
                                    .addComponent(campoConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelCantidad)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(campoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(labelImporte)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(campoImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelIVA)
                                    .addGap(18, 18, 18)
                                    .addComponent(comboIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jScrollPane1)))
                .addGap(18, 18, 18)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelFecha))
                    .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(labelUsuario)
                        .addComponent(campoNumUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNFact)
                            .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(radioRec, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(radioFact, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGap(58, 58, 58)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(labelConcepto)
                            .addComponent(campoConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCantidad)
                            .addComponent(campoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelImporte)
                            .addComponent(campoImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelIVA)
                            .addComponent(comboIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(campoNumFactRec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelContenedorLayout.createSequentialGroup()
                                .addComponent(labelIVA5monto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelIVA10monto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelTotalIVAmonto))
                            .addGroup(panelContenedorLayout.createSequentialGroup()
                                .addComponent(labelIVA5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelIVA10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelTotalIVA))))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelEx)
                            .addComponent(labelSubEx))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label5)
                            .addComponent(labelSub5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label10)
                            .addComponent(labelSub10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTotalmonto, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelTotal, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboIVAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboIVAKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            btnAdd.doClick();
        }
    }//GEN-LAST:event_comboIVAKeyPressed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (campoConcepto.getText().isEmpty()) {
            campoConcepto.requestFocus();
            return;
        }
        if (campoImporte.getText().isEmpty()) {
            campoImporte.requestFocus();
            return;
        }
        if (radioFact.isSelected()) {
            if (campoCantidad.getText().isEmpty()) {
                campoCantidad.requestFocus();
                return;
            }
        }
        campoImporte.setText(campoImporte.getText().replace(".", ""));
        ((javax.swing.table.DefaultTableModel) tablaConceptos.getModel()).addRow(new String[]{campoCantidad.getText(), campoConcepto.getText(), campoImporte.getText().replace(".", ""), comboIVA.getSelectedItem().toString()});
        importe += Integer.parseInt(campoImporte.getText()) * Integer.parseInt(campoCantidad.getText());
        switch (comboIVA.getSelectedItem().toString()) {
            case "EXENTA":
                exenta += Integer.parseInt(campoImporte.getText()) * Integer.parseInt(campoCantidad.getText());
                labelEx.setText(f.formatearNumero(exenta));
                break;
            case "5%":
                cinco += Integer.parseInt(campoImporte.getText()) * Integer.parseInt(campoCantidad.getText());
                labelIVA5monto.setText(f.formatearNumero(utilidades.Factura.calcularIVA5(cinco)));
                label5.setText(f.formatearNumero(cinco));
                break;
            case "10%":
                diez += Integer.parseInt(campoImporte.getText()) * Integer.parseInt(campoCantidad.getText());
                labelIVA10monto.setText(f.formatearNumero(utilidades.Factura.calcularIVA10(diez)));
                label10.setText(f.formatearNumero(diez));
                break;
        }

        labelTotalIVAmonto.setText(f.formatearNumero(Integer.parseInt(labelIVA5monto.getText().replace(".", "")) + Integer.parseInt(labelIVA10monto.getText().replace(".", ""))));
        labelTotalmonto.setText(f.formatearNumero(importe));
        campoConcepto.setText("");
        campoImporte.setText("");
        campoCantidad.setText("");
        btnGuardar.setEnabled(true);
        campoConcepto.requestFocus();
    }//GEN-LAST:event_btnAddActionPerformed

    private void campoCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCantidadKeyTyped
        if (Validaciones.Longitud(campoCantidad, 10)) {
            evt.consume();
        }
        if (!Validaciones.Numeros(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_campoCantidadKeyTyped

    private void campoCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCantidadKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB || evt.getKeyCode() == KeyEvent.VK_ENTER) {
            campoImporte.requestFocus();
        }
    }//GEN-LAST:event_campoCantidadKeyPressed

    private void radioRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioRecActionPerformed
        campoNumFactRec.setText(dao.Pagos.numeroRecibo());
        campoCantidad.setEnabled(false);
        btnAdd.setEnabled(false);
        comboIVA.setEnabled(false);
    }//GEN-LAST:event_radioRecActionPerformed

    private void radioFactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFactActionPerformed
        campoNumFactRec.setText(dao.Pagos.numeroFactura());
        campoCantidad.setEnabled(true);
        btnAdd.setEnabled(true);
        comboIVA.setEnabled(true);
    }//GEN-LAST:event_radioFactActionPerformed

    private void campoNumFactRecKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNumFactRecKeyTyped
        if (radioRec.isSelected()) {
            if (Validaciones.Longitud(campoNumFactRec, 10)) {
                evt.consume();
            }
            if (!Validaciones.Numeros(evt.getKeyChar())) {
                evt.consume();
            }
        } else if (radioFact.isSelected()) {
            if (Validaciones.Longitud(campoNumFactRec, 15)) {
                evt.consume();
            }
            if (!Validaciones.Numeros(evt.getKeyChar()) && Validaciones.Simbolos(evt.getKeyChar())) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_campoNumFactRecKeyTyped

    private void campoNumFactRecKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNumFactRecKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (radioRec.isSelected()) {
                if (!Validaciones.longitudValida(campoNumFactRec.getText(), 10)) {
                    campoNumFactRec.requestFocus();
                    return;
                } else {
                    if (dao.Pagos.existeNumFactura(campoNumFactRec.getText())) {
                        JOptionPane.showMessageDialog(null, "El número de recibo ya existe en la base de datos.", null, JOptionPane.ERROR_MESSAGE);
                        campoNumFactRec.requestFocus();
                        return;
                    }
                }
            } else if (radioFact.isSelected()) {
                if (!Validaciones.longitudValida(campoNumFactRec.getText(), 15)) {
                    campoNumFactRec.requestFocus();
                    return;
                } else {
                    if (!Validaciones.numeroFacturaValido(campoNumFactRec.getText())) {
                        campoNumFactRec.requestFocus();
                        return;
                    } else {
                        if (dao.Pagos.existeNumFactura(campoNumFactRec.getText())) {
                            JOptionPane.showMessageDialog(null, "El número de factura ya existe en la base de datos.", null, JOptionPane.ERROR_MESSAGE);
                            campoNumFactRec.requestFocus();
                            return;
                        }
                    }
                }
            }
            campoConcepto.requestFocus();
        }
    }//GEN-LAST:event_campoNumFactRecKeyPressed

    private void campoNumFactRecFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNumFactRecFocusLost
        if (radioRec.isSelected()) {
            if (!Validaciones.longitudValida(campoNumFactRec.getText(), 10)) {
                campoNumFactRec.requestFocus();
                return;
            }
        } else if (radioFact.isSelected()) {
            if (!Validaciones.longitudValida(campoNumFactRec.getText(), 15)) {
                campoNumFactRec.requestFocus();
                return;
            } else {
                if (!Validaciones.numeroFacturaValido(campoNumFactRec.getText())) {
                    campoNumFactRec.requestFocus();
                    return;
                } else {
                    if (dao.Pagos.existeNumFactura(campoNumFactRec.getText())) {
                        JOptionPane.showMessageDialog(null, "El número de factura ya existe en la base de datos.", null, JOptionPane.ERROR_MESSAGE);
                        campoNumFactRec.requestFocus();
                        return;
                    }
                }
            }
        }
    }//GEN-LAST:event_campoNumFactRecFocusLost

    private void tablaConceptosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaConceptosKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            if (tablaConceptos.getSelectedRow() >= 0) {
                removerFila();
            }
            if (tablaConceptos.getRowCount() < 1) {
                btnGuardar.setEnabled(false);
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (tablaConceptos.getSelectedRow() >= 0) {
                campoConcepto.setText(tablaConceptos.getValueAt(tablaConceptos.getSelectedRow(), 1).toString());
                campoImporte.setText(tablaConceptos.getValueAt(tablaConceptos.getSelectedRow(), 2).toString());
                campoCantidad.setText(tablaConceptos.getValueAt(tablaConceptos.getSelectedRow(), 0).toString());
                comboIVA.setSelectedItem(tablaConceptos.getValueAt(tablaConceptos.getSelectedRow(), 3).toString());
                removerFila();
            }
        }
    }//GEN-LAST:event_tablaConceptosKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (!f.validarDateChooser(campoFecha)) {
            campoFecha.requestFocusInWindow();
            return;
        }
        if (campoNumFactRec.getText().isEmpty()) {
            campoNumFactRec.requestFocus();
            return;
        }
        if (campoUsuario.getText().isEmpty()) {
            campoUsuario.requestFocus();
            return;
        }
        if (campoNumFactRec.getText().isEmpty()) {
            campoNumFactRec.requestFocus();
            return;
        }
        if (radioRec.isSelected()) {
            if (campoConcepto.getText().isEmpty()) {
                campoConcepto.requestFocus();
                return;
            }
            if (campoImporte.getText().isEmpty()) {
                campoImporte.requestFocus();
                return;
            }
        } else {
            if (tablaConceptos.getRowCount() < 1) {
                JOptionPane.showMessageDialog(null, "Ingrese al menos un detalle en la tabla para poder efectuar la transacción.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                campoConcepto.requestFocus();
                return;
            }
        }
        p = new modelos.Pago();
        p.setFechaPago(campoFecha.getDate());
        p.setTotal(importe);
        p.setNumFactura(campoNumFactRec.getText());
        p.setIdLote(idLote);
        p.setIdUsuario(campoNumUsuario.getText());

        if (radioFact.isSelected()) {
            generarFactura();
        } else {
            generarRecibo();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void campoImporteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoImporteKeyTyped
        if (Validaciones.Longitud(campoImporte, 10)) {
            evt.consume();
        }
        if (!Validaciones.Numeros(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_campoImporteKeyTyped

    private void campoImporteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoImporteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            if (campoImporte.getText().equals("")) {
                return;
            }

            if (radioRec.isSelected()) {
                btnGuardar.setEnabled(true);
                btnGuardar.requestFocus();
                importe = Integer.parseInt(campoImporte.getText());
            } else if (radioFact.isSelected()) {
                comboIVA.requestFocus();
            }
        }
    }//GEN-LAST:event_campoImporteKeyPressed

    private void campoConceptoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoConceptoKeyTyped
        if (Validaciones.Longitud(campoConcepto, 100)) {
            evt.consume();
        }
        if (!Validaciones.NumerosyLetras(evt.getKeyChar()) && !Validaciones.Espacio(evt.getKeyChar())) {
            evt.consume();
        }
        f.convertirAMayusculas(evt);
    }//GEN-LAST:event_campoConceptoKeyTyped

    private void campoConceptoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoConceptoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            if (radioRec.isSelected()) {
                campoImporte.requestFocus();
            } else if (radioFact.isSelected()) {
                campoCantidad.requestFocus();
            }
        }
    }//GEN-LAST:event_campoConceptoKeyPressed

    private void campoConceptoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoConceptoFocusLost
        f.removerEspaciosExtra(campoConcepto.getText());
        campoConcepto.setText(campoConcepto.getText().trim());
    }//GEN-LAST:event_campoConceptoFocusLost

    private void campoNumUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNumUsuarioKeyTyped
        if (Validaciones.Longitud(campoNumUsuario, 11)) {
            evt.consume();
        }
        if (!Validaciones.Numeros(evt.getKeyChar()) && !Validaciones.Espacio(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_campoNumUsuarioKeyTyped

    private void campoNumUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNumUsuarioKeyPressed
        campoNumUsuario.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, java.util.Collections.EMPTY_SET);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            u = null;
            validarUsuario();
        }
    }//GEN-LAST:event_campoNumUsuarioKeyPressed

    private void campoFechaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoFechaKeyPressed
        campoFecha.getDateEditor().getUiComponent().setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, java.util.Collections.EMPTY_SET);
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            campoNumUsuario.requestFocusInWindow();
        }
    }//GEN-LAST:event_campoFechaKeyPressed

    private void campoImporteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoImporteFocusLost
        if (!campoImporte.getText().isEmpty() || campoImporte.getText().length() > 0) {
            f.formatearNumero(campoImporte);
        }
    }//GEN-LAST:event_campoImporteFocusLost

    private void campoImporteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoImporteFocusGained
        if (campoImporte.getText().length() > 0) {
            campoImporte.setText(campoImporte.getText().replace(".", ""));
        }
    }//GEN-LAST:event_campoImporteFocusGained

    void validarUsuario() {
        if (campoNumUsuario.getText().isEmpty()) {
            campoUsuario.requestFocus();
        } else {
            u = new dao.Usuarios().obtenerUsuarioPorId(Integer.parseInt(campoNumUsuario.getText()));
            if (u == null) {
                JOptionPane.showMessageDialog(null, "El código de usuario no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                campoUsuario.setText("");
                campoNumUsuario.requestFocus();
                f.limpiarCampos(panelContenedor);
                campoNumFactRec.setEnabled(false);
                campoConcepto.setEnabled(false);
                campoImporte.setEnabled(false);
                campoCantidad.setEnabled(false);
                campoFecha.setDate(hoy);
                descuento = 0;
                montocuenta = 0;
                importe = 0;
                btnGuardar.setEnabled(false);
                return;
            } else {
                campoUsuario.setText(u.getNombre() + " " + u.getApellido());
                tablaConceptos.setModel(new javax.swing.table.DefaultTableModel(null, new String[]{"Cantidad", "Concepto", "Importe", "I.V.A."}));
                Funciones.limpiarTabla(tablaConceptos);
                campoNumFactRec.setEnabled(true);
                campoConcepto.setEnabled(true);
                campoImporte.setEnabled(true);
                radioFact.requestFocus();
                if (radioFact.isSelected()) {
                    btnAdd.setEnabled(true);
                    campoCantidad.setEnabled(true);
                    comboIVA.setEnabled(true);
                    campoNumFactRec.setText(dao.Pagos.numeroFactura());
                } else {
                    campoNumFactRec.setText(dao.Pagos.numeroRecibo());
                }
            }
        }
    }

    void generarFactura() {
        ArrayList<modelos.DetallePago> ap = new ArrayList();
        for (int i = 0; i < tablaConceptos.getRowCount(); i++) {
            dp = new modelos.DetallePago();
            dp.setCantidad(Integer.parseInt(tablaConceptos.getValueAt(i, 0).toString()));
            dp.setConcepto(tablaConceptos.getValueAt(i, 1).toString());
            dp.setSubtotal(Integer.parseInt(tablaConceptos.getValueAt(i, 2).toString()));
            switch (tablaConceptos.getValueAt(i, 3).toString()) {
                case "5%":
                    dp.setTipoIVA(5);
                    break;
                case "10%":
                    dp.setTipoIVA(10);
                    break;
                case "EXENTA":
                    dp.setTipoIVA(0);
                    break;
            }
            dp.setMontoDescuento(descuento);
            dp.setTipoPago("OTROS");
            ap.add(dp);
        }

        List<modelos.Factura> df = new ArrayList<>();
        for (int i = 0; i < tablaConceptos.getRowCount(); i++) {
            modelos.Factura n = new modelos.Factura();
            n.setCodDetalle(null);
            n.setCantDetalle(Integer.parseInt(tablaConceptos.getValueAt(i, 0).toString()));
            n.setDescDetalle(tablaConceptos.getValueAt(i, 1).toString());
            n.setPrecioUnitDetalle(Integer.parseInt(tablaConceptos.getValueAt(i, 2).toString()));
            n.setExentaDetalle(tablaConceptos.getValueAt(i, 3).toString().equals("EXENTA") ? Integer.parseInt(tablaConceptos.getValueAt(i, 2).toString()) * Integer.parseInt(tablaConceptos.getValueAt(i, 0).toString()) : null);
            n.setcDetalle(tablaConceptos.getValueAt(i, 3).toString().equals("5%") ? Integer.parseInt(tablaConceptos.getValueAt(i, 2).toString()) * Integer.parseInt(tablaConceptos.getValueAt(i, 0).toString()) : null);
            n.setdDetalle(tablaConceptos.getValueAt(i, 3).toString().equals("10%") ? Integer.parseInt(tablaConceptos.getValueAt(i, 2).toString()) * Integer.parseInt(tablaConceptos.getValueAt(i, 0).toString()) : null);
            df.add(n);
        }

        reportes.Factura fact = new reportes.Factura();
        fact.mostrarFacturax(campoNumFactRec.getText().substring(campoNumFactRec.getText().lastIndexOf("-") + 1), campoFecha.getDate(),
                campoUsuario.getText(), u.getDireccion(), u.getNumDocumento(), importe - descuento, df);
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Confirma que los datos ingresados son correctos?", "Confirmar pago",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
        switch (respuesta) {
            case -1:
            case JOptionPane.NO_OPTION:
                break;
            case JOptionPane.YES_OPTION: {
                if (fact.getVisor() != null && fact.getVisor().isShowing()) {
                    fact.getVisor().dispose();
                }
                dao.Pagos pago = new dao.Pagos();
                if (pago.insertarPagoMulti(p, ap)) {
                    JOptionPane.showMessageDialog(null, "Se ha registrado la transacción con éxito.", "Transacción Exitosa", JOptionPane.INFORMATION_MESSAGE);
                    if (!fact.imprimir("fni")) {
                        JOptionPane.showMessageDialog(null, "No se pudo imprimir. Se guardó una copia de la factura.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    finalizar();
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha podido registrar los datos.", "Ocurrió un error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    void generarRecibo() {
        dp = new modelos.DetallePago();
        dp.setCantidad(1);
        dp.setConcepto(campoConcepto.getText());
        dp.setSubtotal(Integer.parseInt(campoImporte.getText().replace(".", "")));
        dp.setTipoIVA(0);
        dp.setMontoDescuento(descuento);
        dp.setTipoPago("OTROS");
        List<modelos.Recibo> re = new ArrayList<>();
        modelos.Recibo n = new modelos.Recibo();
        n.setFecha(utilidades.Estaticos.FORMATODMA.format(campoFecha.getDate()));
        n.setConceptoRec(campoConcepto.getText().concat(".-"));
        n.setImporteRecibo(dp.getSubtotal());
        n.setNombreRec(campoUsuario.getText());
        n.setSumaRec(new utilidades.NumeroALetras().Convertir(campoImporte.getText().replace(".", ""), true) + " GUARANÍES ");
        re.add(n);

        reportes.Recibo fact = new reportes.Recibo();
        fact.mostrarRecibo(campoNumFactRec.getText(), re);

        int respuesta = JOptionPane.showConfirmDialog(null, "¿Confirma que los datos ingresados son correctos?", "Confirmar pago",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
        switch (respuesta) {
            case -1:
            case JOptionPane.NO_OPTION:
                break;
            case JOptionPane.YES_OPTION: {
                if (fact.getVisor() != null && fact.getVisor().isShowing()) {
                    fact.getVisor().dispose();
                }
                dao.Pagos pago = new dao.Pagos();
                if (pago.insertarPagoMulti(p, dp)) {
                    JOptionPane.showMessageDialog(null, "Se ha registrado la transacción con éxito.", "Transacción Exitosa", JOptionPane.INFORMATION_MESSAGE);
                    if (!fact.imprimir("otros")) {
                        JOptionPane.showMessageDialog(null, "No se pudo imprimir. Se guardó una copia del recibo.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    finalizar();
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha podido registrar la transacción. Por favor, inténtelo de nuevo más tarde.", "Ocurrió un error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    void removerFila() {
        importe -= Integer.parseInt(tablaConceptos.getValueAt(tablaConceptos.getSelectedRow(), 2).toString()) * Integer.parseInt(tablaConceptos.getValueAt(tablaConceptos.getSelectedRow(), 0).toString());
        switch (tablaConceptos.getValueAt(tablaConceptos.getSelectedRow(), 3).toString()) {
            case "EXENTA":
                exenta -= Integer.parseInt(tablaConceptos.getValueAt(tablaConceptos.getSelectedRow(), 2).toString()) * Integer.parseInt(tablaConceptos.getValueAt(tablaConceptos.getSelectedRow(), 0).toString());
                labelEx.setText(f.formatearNumero(Integer.parseInt(labelEx.getText().replace(".", "")) - (Integer.parseInt(tablaConceptos.getValueAt(tablaConceptos.getSelectedRow(), 2).toString()) * Integer.parseInt(tablaConceptos.getValueAt(tablaConceptos.getSelectedRow(), 0).toString()))));
                break;
            case "5%":
                cinco -= Integer.parseInt(tablaConceptos.getValueAt(tablaConceptos.getSelectedRow(), 2).toString()) * Integer.parseInt(tablaConceptos.getValueAt(tablaConceptos.getSelectedRow(), 0).toString());
                labelIVA5monto.setText(f.formatearNumero(utilidades.Factura.calcularIVA5(cinco)));
                label5.setText(f.formatearNumero(Integer.parseInt(label5.getText().replace(".", "")) - (Integer.parseInt(tablaConceptos.getValueAt(tablaConceptos.getSelectedRow(), 2).toString()) * Integer.parseInt(tablaConceptos.getValueAt(tablaConceptos.getSelectedRow(), 0).toString()))));
                break;
            case "10%":
                diez -= Integer.parseInt(tablaConceptos.getValueAt(tablaConceptos.getSelectedRow(), 2).toString()) * Integer.parseInt(tablaConceptos.getValueAt(tablaConceptos.getSelectedRow(), 0).toString());
                labelIVA10monto.setText(f.formatearNumero(utilidades.Factura.calcularIVA10(diez)));
                label10.setText(f.formatearNumero(Integer.parseInt(label10.getText().replace(".", "")) - (Integer.parseInt(tablaConceptos.getValueAt(tablaConceptos.getSelectedRow(), 2).toString()) * Integer.parseInt(tablaConceptos.getValueAt(tablaConceptos.getSelectedRow(), 0).toString()))));
                break;
        }

        labelTotalIVAmonto.setText(f.formatearNumero(Integer.parseInt(labelIVA5monto.getText().replace(".", "")) + Integer.parseInt(labelIVA10monto.getText().replace(".", ""))));
        labelTotalmonto.setText(f.formatearNumero(importe));

        ((javax.swing.table.DefaultTableModel) tablaConceptos.getModel()).removeRow(tablaConceptos.getSelectedRow());
    }

    void finalizar() {
        ((TablaPagos) tablaPagosxLote.getModel()).limpiar();
        ((TablaPagos) tablaPagosxLote.getModel()).setPagos(dao.Pagos.listarPagosxLotes(idLote));
        ((TablaLotePagos) tablaPagos.getModel()).limpiar();
        ((TablaLotePagos) tablaPagos.getModel()).setPagos(dao.Pagos.listarLotesPagos());
        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JTextField campoCantidad;
    private javax.swing.JTextField campoConcepto;
    private com.toedter.calendar.JDateChooser campoFecha;
    private javax.swing.JTextField campoImporte;
    private javax.swing.JTextField campoNumFactRec;
    private javax.swing.JTextField campoNumUsuario;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JComboBox comboIVA;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label10;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelConcepto;
    private javax.swing.JLabel labelEx;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelIVA;
    private javax.swing.JLabel labelIVA10;
    private javax.swing.JLabel labelIVA10monto;
    private javax.swing.JLabel labelIVA5;
    private javax.swing.JLabel labelIVA5monto;
    private javax.swing.JLabel labelImporte;
    private javax.swing.JLabel labelNFact;
    private javax.swing.JLabel labelSub10;
    private javax.swing.JLabel labelSub5;
    private javax.swing.JLabel labelSubEx;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelTotalIVA;
    private javax.swing.JLabel labelTotalIVAmonto;
    private javax.swing.JLabel labelTotalmonto;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JRadioButton radioFact;
    private javax.swing.ButtonGroup radioOpc;
    private javax.swing.JRadioButton radioRec;
    private javax.swing.JTable tablaConceptos;
    // End of variables declaration//GEN-END:variables
}
