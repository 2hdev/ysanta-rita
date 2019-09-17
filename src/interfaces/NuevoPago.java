package interfaces;

import clases.tablas.TablaComprobantesPendientes;
import clases.tablas.TablaLotePagos;
import clases.tablas.TablaPagos;
import static interfaces.ListaFacturasxLotes.tablaPagosxLote;
import static interfaces.ListaPagos.tablaPagos;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.TableCellRenderer;
import utilidades.Funciones;
import utilidades.Validaciones;

public class NuevoPago extends javax.swing.JInternalFrame {

    Funciones f = new Funciones();
    String idLote;
    modelos.Usuario u;
    dao.Comprobante c = new dao.Comprobante();
    Integer descuento = 0;
    Integer importe = 0;
    Integer tot = 0;
    clases.tablas.TablaComprobantesPendientes pendientes = new clases.tablas.TablaComprobantesPendientes();
    java.util.Date hoy = new java.util.Date();

    Map<Integer, TableCellRenderer> mapa;

    public NuevoPago(String idLote) {
        initComponents();
        this.idLote = idLote;
        f.agregarPlaceHolder(((javax.swing.JTextField) campoFecha.getDateEditor().getUiComponent()), "dd/MM/aaaa");
        campoFecha.setDate(hoy);
        mapaRenderers();
    }

    @Override
    public void dispose() {
        ListaFacturasxLotes.btnNuevoPago.setEnabled(true);
        super.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        labelFecha = new javax.swing.JLabel();
        campoFecha = new com.toedter.calendar.JDateChooser();
        labelUsuario = new javax.swing.JLabel();
        campoNumUsuario = new javax.swing.JTextField();
        campoUsuario = new javax.swing.JTextField();
        labelNFact = new javax.swing.JLabel();
        campoFact = new javax.swing.JFormattedTextField();
        labelConcepto = new javax.swing.JLabel();
        campoConcepto = new javax.swing.JTextField();
        panelDetalles = new javax.swing.JTabbedPane();
        panelPendientes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPendientes = new javax.swing.JTable();
        labelDescuento = new javax.swing.JLabel();
        btnDescuento = new javax.swing.JToggleButton();
        labelImporte = new javax.swing.JLabel();
        campoImporte = new javax.swing.JTextField();
        labelImporteDesc = new javax.swing.JLabel();
        campoImporteDesc = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        labelMedidor = new javax.swing.JLabel();
        comboMedidores = new javax.swing.JComboBox();
        labelTotal = new javax.swing.JLabel();
        labelMontoTotal = new javax.swing.JLabel();
        labelCuenta = new javax.swing.JLabel();
        comboCuenta = new javax.swing.JComboBox<>();

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
        campoNumUsuario.setNextFocusableComponent(campoFact);
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
        labelNFact.setText("Factura Nº :");

        try {
            campoFact.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoFact.setEnabled(false);
        campoFact.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        campoFact.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        campoFact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoFactFocusLost(evt);
            }
        });
        campoFact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoFactKeyPressed(evt);
            }
        });

        labelConcepto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelConcepto.setText("Concepto:");

        campoConcepto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoConcepto.setText("CONSUMO DE AGUA");
        campoConcepto.setEnabled(false);
        campoConcepto.setNextFocusableComponent(campoImporte);
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

        panelDetalles.setFocusable(false);

        panelPendientes.setFocusable(false);

        tablaPendientes.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tablaPendientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº Comprobante", "Medidor", "Monto Total", "Monto Pagado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
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
        tablaPendientes.setToolTipText("Seleccione el o los comprobantes de la lista para efectuar el pago. Se puede seleccionar más de un comprobante por pago.");
        tablaPendientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tablaPendientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPendientesMouseClicked(evt);
            }
        });
        tablaPendientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaPendientesKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPendientes);
        if (tablaPendientes.getColumnModel().getColumnCount() > 0) {
            tablaPendientes.getColumnModel().getColumn(0).setResizable(false);
            tablaPendientes.getColumnModel().getColumn(1).setResizable(false);
            tablaPendientes.getColumnModel().getColumn(2).setResizable(false);
            tablaPendientes.getColumnModel().getColumn(3).setResizable(false);
        }
        tablaPendientes.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout panelPendientesLayout = new javax.swing.GroupLayout(panelPendientes);
        panelPendientes.setLayout(panelPendientesLayout);
        panelPendientesLayout.setHorizontalGroup(
            panelPendientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPendientesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        panelPendientesLayout.setVerticalGroup(
            panelPendientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPendientesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        panelDetalles.addTab("Comprobantes Pendientes", panelPendientes);

        labelDescuento.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelDescuento.setText("¿Descuento a Cuenta Actual?");

        btnDescuento.setText("No");
        btnDescuento.setEnabled(false);
        btnDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescuentoActionPerformed(evt);
            }
        });

        labelImporte.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelImporte.setText("Importe:");

        campoImporte.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoImporte.setEnabled(false);
        campoImporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoImporteKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoImporteKeyTyped(evt);
            }
        });

        labelImporteDesc.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelImporteDesc.setText("Importe:");
        labelImporteDesc.setVisible(false);

        campoImporteDesc.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoImporteDesc.setNextFocusableComponent(btnGuardar);
        campoImporteDesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoImporteDescKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoImporteDescKeyTyped(evt);
            }
        });
        campoImporteDesc.setVisible(false);

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

        labelMedidor.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelMedidor.setText("Medidor Nº:");

        comboMedidores.setEnabled(false);
        comboMedidores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMedidoresActionPerformed(evt);
            }
        });

        labelTotal.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelTotal.setText("Total a Pagar:");

        labelMontoTotal.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelMontoTotal.setText("0");

        labelCuenta.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelCuenta.setText("Cuenta Nº:");

        comboCuenta.setEnabled(false);
        comboCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCuentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelFecha, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelCuenta, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelNFact, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelConcepto, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelImporte, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelContenedorLayout.createSequentialGroup()
                                .addComponent(campoNumUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(campoConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoFact, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelContenedorLayout.createSequentialGroup()
                                .addComponent(comboCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(labelMedidor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboMedidores, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorLayout.createSequentialGroup()
                                .addComponent(labelTotal)
                                .addGap(59, 59, 59)
                                .addComponent(labelMontoTotal)
                                .addGap(59, 59, 59))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelContenedorLayout.createSequentialGroup()
                        .addComponent(labelDescuento)
                        .addGap(16, 16, 16)
                        .addComponent(btnDescuento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelImporteDesc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoImporteDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(labelFecha)
                            .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(labelUsuario)
                            .addComponent(campoNumUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(labelCuenta)
                            .addComponent(comboCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMedidor)
                            .addComponent(comboMedidores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(labelNFact)
                            .addComponent(campoFact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(labelConcepto)
                            .addComponent(campoConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(labelImporte)
                            .addComponent(campoImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(labelDescuento)
                            .addComponent(btnDescuento)
                            .addComponent(labelImporteDesc)
                            .addComponent(campoImporteDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(btnGuardar)))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(panelDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelMontoTotal)
                            .addComponent(labelTotal))))
                .addGap(20, 20, 20))
        );

        panelDetalles.getAccessibleContext().setAccessibleName("Saldo Actual");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoNumUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNumUsuarioKeyPressed
        campoNumUsuario.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, java.util.Collections.EMPTY_SET);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            u = null;
            validarUsuario();
        }
    }//GEN-LAST:event_campoNumUsuarioKeyPressed

    private void campoNumUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNumUsuarioKeyTyped
        if (Validaciones.Longitud(campoNumUsuario, 11)) {
            evt.consume();
        }
        if (!Validaciones.Numeros(evt.getKeyChar()) && !Validaciones.Espacio(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_campoNumUsuarioKeyTyped

    private void campoConceptoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoConceptoKeyTyped
        if (Validaciones.Longitud(campoConcepto, 100)) {
            evt.consume();
        }
        if (!Validaciones.NumerosyLetras(evt.getKeyChar()) && !Validaciones.Espacio(evt.getKeyChar())) {
            evt.consume();
        }
        f.convertirAMayusculas(evt);
    }//GEN-LAST:event_campoConceptoKeyTyped

    private void campoConceptoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoConceptoFocusLost
        f.removerEspaciosExtra(campoConcepto.getText());
        campoConcepto.setText(campoConcepto.getText().trim());
    }//GEN-LAST:event_campoConceptoFocusLost

    private void btnDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescuentoActionPerformed
        btnDescuento.setText(btnDescuento.isSelected() ? "Sí" : "No");
        labelImporteDesc.setVisible(btnDescuento.isSelected());
        campoImporteDesc.setVisible(btnDescuento.isSelected());
        if (btnDescuento.isSelected()) {
            switch (u.getTipodesc()) {
                case "NINGUNO":
                    break;
                case "PORCENTAJE":
                    System.out.println("Descuento: " + u.getMontoDescuento());
                    java.math.BigDecimal total = new java.math.BigDecimal(java.math.BigDecimal.valueOf(tot).toString()).multiply(
                            ((java.math.BigDecimal.valueOf(u.getMontoDescuento()).divide(java.math.BigDecimal.valueOf(100)))));
                    descuento = total.setScale(0, java.math.RoundingMode.HALF_UP).intValueExact();
                    break;
                case "MONTO":
                    System.out.println("Descuento: " + u.getMontoDescuento());
                    descuento = u.getMontoDescuento();
                    break;
            }
            campoImporteDesc.setText(String.valueOf(descuento));
            if (importe <= descuento) {
                JOptionPane.showMessageDialog(null, "El importe es menor o igual al descuento.", "Atención", JOptionPane.WARNING_MESSAGE);
                campoImporteDesc.requestFocus();
            } else {
                labelMontoTotal.setText(f.formatearNumero(importe - descuento));
            }
        } else {
            labelMontoTotal.setText(f.formatearNumero(importe));
            descuento = 0;
        }
    }//GEN-LAST:event_btnDescuentoActionPerformed
    private void campoImporteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoImporteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            if (campoImporte.getText().equals("")) {
                return;
            }
            btnDescuento.setEnabled(true);
            btnGuardar.setEnabled(true);
            importe = Integer.parseInt(campoImporte.getText());
            btnDescuento.requestFocus();
            labelMontoTotal.setText(f.formatearNumero(importe));
        }
    }//GEN-LAST:event_campoImporteKeyPressed

    private void campoImporteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoImporteKeyTyped
        if (Validaciones.Longitud(campoImporte, 11)) {
            evt.consume();
        }
        if (!Validaciones.Numeros(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_campoImporteKeyTyped

    private void campoImporteDescKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoImporteDescKeyPressed
        campoImporteDesc.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, java.util.Collections.EMPTY_SET);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            if (campoImporteDesc.getText().equals("")) {
                return;
            } else {
                if (descuento >= importe) {
                    JOptionPane.showMessageDialog(null, "El importe es menor o igual al descuento.", "Atención", JOptionPane.WARNING_MESSAGE);
                    campoImporteDesc.requestFocus();

                } else {
                    descuento = Integer.parseInt(campoImporteDesc.getText());
                    importe = Integer.parseInt(campoImporte.getText());
                    labelMontoTotal.setText(f.formatearNumero(importe - descuento));
                    btnGuardar.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_campoImporteDescKeyPressed

    private void campoImporteDescKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoImporteDescKeyTyped
        if (Validaciones.Longitud(campoImporteDesc, 11)) {
            evt.consume();
        }
        if (!Validaciones.Numeros(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_campoImporteDescKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (!Validaciones.numeroFacturaValido(campoFact.getText())) {
            campoFact.requestFocus();
            return;
        }
        if (labelMontoTotal.getText().equals("0")) {
            JOptionPane.showMessageDialog(null, "Monto a Pagar es 0.\nPulse \"Enter\" en el campo \"Importe\" para confirmar el importe ingresado.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!f.validarDateChooser(campoFecha)) {
            campoFecha.requestFocusInWindow();
            return;
        }
        if (campoUsuario.getText().isEmpty()) {
            campoUsuario.requestFocus();
            return;
        }
        if (campoFact.getText().isEmpty()) {
            campoFact.requestFocus();
            return;
        }
        if (campoConcepto.getText().isEmpty()) {
            campoConcepto.requestFocus();
            return;
        }
        if (campoImporte.getText().isEmpty()) {
            campoImporte.requestFocus();
            return;
        }
        if (btnDescuento.isSelected()) {
            if (campoImporteDesc.getText().isEmpty()) {
                campoImporteDesc.requestFocus();
                return;
            }
        }
        modelos.Pago p = new modelos.Pago();
        Integer restas = importe;
        ArrayList<modelos.DetallePago> detpago = new ArrayList<>();
        ArrayList<String> estados = new ArrayList<>();

        for (int i : tablaPendientes.getSelectedRows()) {

            modelos.DetallePago dp = new modelos.DetallePago();
            dp.setConcepto(campoConcepto.getText());
            dp.setCantidad(1);
            dp.setTipoIVA(10);
            dp.setMontoDescuento(descuento);
            dp.setTipoPago("COMPROBANTES");
            dp.setIdCuenta(((modelos.Cuenta) comboCuenta.getSelectedItem()).getIdentificador());
            Integer saldo = Integer.parseInt(((TablaComprobantesPendientes) tablaPendientes.getModel()).getValueAt(i, 1).toString())
                    - Integer.parseInt(((TablaComprobantesPendientes) tablaPendientes.getModel()).getValueAt(i, 2).toString());
            if (restas > saldo) {
                dp.setSubtotal(saldo);
                restas -= saldo;
                estados.add(tablaPendientes.getValueAt(i, 0).toString() + "-PAGADO");
            } else if (restas < saldo) {
                dp.setSubtotal(restas);
                restas -= saldo;
                estados.add(tablaPendientes.getValueAt(i, 0).toString() + "-PARCIALMENTE PAGADO");
            } else {
                dp.setSubtotal(restas);
                restas -= saldo;
                estados.add(tablaPendientes.getValueAt(i, 0).toString() + "-PAGADO");
            }

            dp.setIdComprobante(tablaPendientes.getValueAt(i, 0).toString());

            detpago.add(dp);
        }
        List<modelos.Factura> df = new ArrayList<>();

        p.setFechaPago(campoFecha.getDate());
        p.setTotal(importe - descuento);
        p.setNumFactura(campoFact.getText());
        p.setIdLote(idLote);
        p.setIdUsuario(campoNumUsuario.getText());

        modelos.Factura n = new modelos.Factura();
        n.setCodDetalle(null);
        n.setCantDetalle(1);
        n.setDescDetalle(campoConcepto.getText());
        n.setPrecioUnitDetalle(restas > 0 ? importe - restas - descuento : importe - descuento);
        n.setdDetalle(restas > 0 ? importe - restas - descuento : importe - descuento);
        df.add(n);

        if (restas > 0) {
            if (detpago.size() < tablaPendientes.getRowCount()) {
                JOptionPane.showMessageDialog(null, "No se puede registrar un pago por adelantado al existir comprobantes pendientes de pago.\n"
                        + "Compruebe que todos los comprobantes en la tabla hayan sido seleccionados y vuelva a intentarlo.", "Ocurrió un error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                modelos.DetallePago dp = new modelos.DetallePago();
                dp.setConcepto("PAGO POR ADELANTADO POR CONSUMO");
                dp.setCantidad(1);
                dp.setTipoIVA(10);
                dp.setMontoDescuento(descuento);
                dp.setTipoPago("ADELANTADO");
                dp.setIdCuenta(((modelos.Cuenta) comboCuenta.getSelectedItem()).getIdentificador());
                dp.setSubtotal(restas);
                detpago.add(dp);

                modelos.Factura m = new modelos.Factura();
                m.setCodDetalle(null);
                m.setCantDetalle(1);
                m.setDescDetalle(dp.getConcepto());
                m.setPrecioUnitDetalle(null);
                m.setdDetalle(dp.getSubtotal());
                df.add(m);
            }
        }
        dao.Pagos pago = new dao.Pagos();
        reportes.Factura fact = new reportes.Factura();
        int id_pago = pago.AgregarPago(p, detpago, estados);
        int total_pago = pago.BuscarErssanxPago(id_pago);
        List<String> cab = dao.Pagos.listarPago(String.format("%s", id_pago));
        int no_pagados = dao.Pagos.ContarFacturasNoPagadas(Integer.valueOf(cab.get(6)));
        if (no_pagados > 1) {
            fact.mostrarFactura(id_pago, String.valueOf(total_pago), "ÚLTIMO AVISO");
        } else if (no_pagados > 2) {
            fact.mostrarFactura(id_pago, String.valueOf(total_pago), "DESCONEXIÓN");
        } else {
            fact.mostrarFactura(id_pago, String.valueOf(total_pago), "");
        }
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
                if (id_pago != 0) {
                    JOptionPane.showMessageDialog(null, "Se ha registrado el pago con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    if (!fact.imprimir("fni")) {
                        JOptionPane.showMessageDialog(null, "No se pudo imprimir. Se guardó una copia de la factura.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    ((TablaPagos) tablaPagosxLote.getModel()).limpiar();
                    ((TablaPagos) tablaPagosxLote.getModel()).setPagos(dao.Pagos.listarPagosxLotes(idLote));
                    ((TablaLotePagos) tablaPagos.getModel()).limpiar();
                    ((TablaLotePagos) tablaPagos.getModel()).setPagos(dao.Pagos.listarLotesPagos());
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha podido registrar los datos.", "Ocurrió un error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void campoFechaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoFechaKeyPressed
        campoFecha.getDateEditor().getUiComponent().setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, java.util.Collections.EMPTY_SET);
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            campoNumUsuario.requestFocusInWindow();
        }
    }//GEN-LAST:event_campoFechaKeyPressed

    private void comboMedidoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMedidoresActionPerformed
        if (comboMedidores.getModel().getSize() > 0) {
            pendientes.setCompPendientes((dao.Comprobante.getComprobantesPendientesxCuentaYMedidor(((modelos.Cuenta) comboCuenta.getSelectedItem()).getIdentificador(), ((modelos.Medidor) comboMedidores.getSelectedItem()).getIdentificador())));
            tablaPendientes.setModel(pendientes);
            tablaPendientes.getColumnModel().getColumn(0).setResizable(false);
            tablaPendientes.getColumnModel().getColumn(1).setResizable(false);
            Funciones.setRenderers(mapa, tablaPendientes);
            tablaPendientes.setRowSelectionInterval(0, 0);
            campoImporte.setText("");
            importe = 0;
            descuento = 0;
            labelMontoTotal.setText(f.formatearNumero(importe));
            btnDescuento.setEnabled(false);
            campoConcepto.setText("");
            tot = Integer.parseInt(tablaPendientes.getValueAt(0, 1).toString()) - Integer.parseInt(tablaPendientes.getValueAt(0, 2).toString());
        }
    }//GEN-LAST:event_comboMedidoresActionPerformed

    private void tablaPendientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPendientesMouseClicked
        if (tablaPendientes.getSelectedRow() > 0) {
            tablaPendientes.setRowSelectionInterval(0, tablaPendientes.getSelectedRow());
        }
        tot = 0;
        for (int i : tablaPendientes.getSelectedRows()) {
            tot += Integer.parseInt(tablaPendientes.getValueAt(i, 1).toString()) - Integer.parseInt(tablaPendientes.getValueAt(i, 2).toString());
            System.out.println("Total: " + tot);
        }
    }//GEN-LAST:event_tablaPendientesMouseClicked

    private void campoFactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoFactKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            if (dao.Pagos.existeNumFactura(campoFact.getText())) {
                JOptionPane.showMessageDialog(null, "El número de factura ya existe en la base de datos.", null, JOptionPane.ERROR_MESSAGE);
                campoFact.requestFocus();
            } else {
                campoFact.transferFocus();
            }
        }
    }//GEN-LAST:event_campoFactKeyPressed

    private void campoFactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoFactFocusLost
        if (!campoFact.getText().equals("")) {
            if (dao.Pagos.existeNumFactura(campoFact.getText())) {
                JOptionPane.showMessageDialog(null, "El número de factura ya existe en la base de datos.", null, JOptionPane.ERROR_MESSAGE);
                campoFact.requestFocus();
                if (tablaPendientes.getRowCount() > 0) {
                    tablaPendientes.setRowSelectionInterval(0, tablaPendientes.getSelectedRow());
                }
            }
        }
    }//GEN-LAST:event_campoFactFocusLost

    private void campoConceptoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoConceptoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            campoConcepto.transferFocus();
        }
    }//GEN-LAST:event_campoConceptoKeyPressed

    private void tablaPendientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaPendientesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_LEFT || evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (evt.isShiftDown()) {
                evt.consume();
            }
            evt.consume();
        }
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            tablaPendientes.transferFocus();
        }
    }//GEN-LAST:event_tablaPendientesKeyPressed

    private void comboCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCuentaActionPerformed
        if (comboCuenta.getModel().getSize() > 0) {
            comboMedidores.removeAllItems();
            comboMedidores.setModel(new javax.swing.DefaultComboBoxModel(((modelos.Cuenta) comboCuenta.getSelectedItem()).getMedidores().toArray()));
            comboMedidores.setEnabled(true);
            pendientes.setCompPendientes(dao.Comprobante.getComprobantesPendientesxCuentaYMedidor(((modelos.Cuenta) comboCuenta.getSelectedItem()).getIdentificador(), ((modelos.Medidor) comboMedidores.getSelectedItem()).getIdentificador()));
            tablaPendientes.setModel(pendientes);
            tablaPendientes.getColumnModel().getColumn(0).setResizable(false);
            tablaPendientes.getColumnModel().getColumn(1).setResizable(false);
            tablaPendientes.getColumnModel().getColumn(2).setResizable(false);
            Funciones.setRenderers(mapa, tablaPendientes);
            tablaPendientes.setRowSelectionInterval(0, 0);
        }
    }//GEN-LAST:event_comboCuentaActionPerformed

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
                campoFecha.setDate(hoy);
                comboMedidores.removeAllItems();
                comboMedidores.setEnabled(false);
                campoFact.setEnabled(false);
                campoConcepto.setEnabled(false);
                campoImporte.setEnabled(false);
                btnDescuento.setEnabled(false);
                descuento = 0;
                importe = 0;
                labelMontoTotal.setText(f.formatearNumero(importe));
                btnGuardar.setEnabled(false);
                return;
            } else {
                campoUsuario.setText(u.getNombre() + " " + u.getApellido());
                tablaPendientes.setModel(new javax.swing.table.DefaultTableModel());
                Funciones.limpiarTabla(tablaPendientes);
                List<modelos.Cuenta> cm = dao.Cuentas.obtenerCuentasYMedidoresPendientes(u.getIdentificador());
                if (cm.size() > 0) {
                    comboCuenta.setEnabled(true);
                    comboCuenta.setModel(new javax.swing.DefaultComboBoxModel(cm.toArray()));
                    comboMedidores.setEnabled(true);
                    comboMedidores.setModel(new javax.swing.DefaultComboBoxModel(((modelos.Cuenta) comboCuenta.getSelectedItem()).getMedidores().toArray()));
                    pendientes.setCompPendientes(dao.Comprobante.getComprobantesPendientesxCuentaYMedidor(((modelos.Cuenta) comboCuenta.getSelectedItem()).getIdentificador(), ((modelos.Medidor) comboMedidores.getSelectedItem()).getIdentificador()));
                    tablaPendientes.setModel(pendientes);
                    tablaPendientes.getColumnModel().getColumn(0).setResizable(false);
                    tablaPendientes.getColumnModel().getColumn(1).setResizable(false);
                    tablaPendientes.getColumnModel().getColumn(2).setResizable(false);
                    Funciones.setRenderers(mapa, tablaPendientes);
                    tablaPendientes.setRowSelectionInterval(0, 0);
                    campoFact.setEnabled(true);
                    campoConcepto.setEnabled(true);
                    campoImporte.setEnabled(true);
                    campoNumUsuario.transferFocus();
                    descuento = importe = 0;
                    tot = Integer.parseInt(tablaPendientes.getValueAt(0, 1).toString()) - Integer.parseInt(tablaPendientes.getValueAt(0, 2).toString());
                    campoFact.setText(dao.Pagos.numeroFactura());
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario no cuenta con comprobantes pendientes de pago.", "Atención", JOptionPane.WARNING_MESSAGE);
                    f.limpiarCampos(panelContenedor);
                    campoFecha.setDate(hoy);
                    campoUsuario.requestFocus();
                    comboMedidores.removeAllItems();
                    comboMedidores.setEnabled(false);
                    comboCuenta.removeAllItems();
                    comboCuenta.setEnabled(false);
                    campoFact.setEnabled(false);
                    campoConcepto.setEnabled(false);
                    campoImporte.setEnabled(false);
                    btnDescuento.setEnabled(false);
                    descuento = importe = 0;
                    labelMontoTotal.setText(f.formatearNumero(importe));
                    btnGuardar.setEnabled(false);
                    tablaPendientes.setModel(new javax.swing.table.DefaultTableModel());
                    Funciones.limpiarTabla(tablaPendientes);
                }
            }
        }
    }

    private void mapaRenderers() {
        mapa = new HashMap();
        mapa.put(0, utilidades.Renderers.rendererDerecha());
        mapa.put(1, utilidades.Renderers.rendererNumeros());
        mapa.put(2, utilidades.Renderers.rendererNumeros());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JToggleButton btnDescuento;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JTextField campoConcepto;
    private javax.swing.JFormattedTextField campoFact;
    private com.toedter.calendar.JDateChooser campoFecha;
    private javax.swing.JTextField campoImporte;
    private javax.swing.JTextField campoImporteDesc;
    private javax.swing.JTextField campoNumUsuario;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JComboBox<modelos.Cuenta> comboCuenta;
    private javax.swing.JComboBox comboMedidores;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelConcepto;
    private javax.swing.JLabel labelCuenta;
    private javax.swing.JLabel labelDescuento;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelImporte;
    private javax.swing.JLabel labelImporteDesc;
    private javax.swing.JLabel labelMedidor;
    private javax.swing.JLabel labelMontoTotal;
    private javax.swing.JLabel labelNFact;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JTabbedPane panelDetalles;
    private javax.swing.JPanel panelPendientes;
    private javax.swing.JTable tablaPendientes;
    // End of variables declaration//GEN-END:variables
}
