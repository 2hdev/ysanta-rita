package interfaces;

import clases.tablas.TablaLotePagos;
import clases.tablas.TablaPagos;
import static interfaces.ListaPagos.tablaPagos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import utilidades.Funciones;
import utilidades.Validaciones;

public class ListaFacturasxLotes extends javax.swing.JInternalFrame {

    Funciones f;
    dao.Pagos p = new dao.Pagos();
    String idLote;

    public ListaFacturasxLotes(String idLote) {
        this.idLote = idLote;
        initComponents();
        f = new Funciones();
        setTitle("Pagos Efectuados - Lote Nº " + idLote);
        utilidades.Funciones.cerrarConEscape(ListaFacturasxLotes.this);
        btnNuevoPago.setVisible(false);
    }

    @Override
    public void dispose() {
        if (menuOpciones.isShowing()) {
            menuOpciones.setVisible(false);
            return;
        }
        super.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoRadio = new javax.swing.ButtonGroup();
        menuOpciones = new javax.swing.JPopupMenu();
        menuReimprimir = new javax.swing.JMenuItem();
        menuReimprimirRecibo = new javax.swing.JMenuItem();
        menuReimprimirOrig = new javax.swing.JMenuItem();
        panelBusqueda = new javax.swing.JPanel();
        FechaDesde = new com.toedter.calendar.JDateChooser();
        FechaHasta = new com.toedter.calendar.JDateChooser();
        labelBuscar = new javax.swing.JLabel();
        campoBuscar = new javax.swing.JTextField();
        radioUsuario = new javax.swing.JRadioButton();
        radioFecha = new javax.swing.JRadioButton();
        labelDesde = new javax.swing.JLabel();
        labelHasta = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPagosxLote = new javax.swing.JTable();
        btnNuevoPago = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();

        menuOpciones.setMaximumSize(new java.awt.Dimension(151, 50));
        menuOpciones.setMinimumSize(new java.awt.Dimension(151, 50));
        menuOpciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                menuOpcionesKeyPressed(evt);
            }
        });

        menuReimprimir.setText("Reimprimir Factura como Copia");
        menuReimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReimprimirActionPerformed(evt);
            }
        });
        menuOpciones.add(menuReimprimir);

        menuReimprimirRecibo.setText("Reimprimir Recibo");
        menuReimprimirRecibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReimprimirReciboActionPerformed(evt);
            }
        });
        menuOpciones.add(menuReimprimirRecibo);

        menuReimprimirOrig.setText("Reimprimir Factura");
        menuReimprimirOrig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReimprimirOrigActionPerformed(evt);
            }
        });
        menuOpciones.add(menuReimprimirOrig);

        setClosable(true);
        setTitle("Pagos Efectuados");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/y_mini.png"))); // NOI18N

        FechaDesde.setDateFormatString("dd/MM/yyyy");
        FechaDesde.setEnabled(false);
        FechaDesde.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        FechaDesde.setMaxSelectableDate(new java.util.Date(32503694508000L));
        FechaDesde.setMinSelectableDate(new java.util.Date(-2208974960000L));
        FechaDesde.getDateEditor().getUiComponent().addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if(Validaciones.Letras(evt.getKeyChar()) || Validaciones.Espacio(evt.getKeyChar())) evt.consume();
            }
        });

        FechaHasta.setDateFormatString("dd/MM/yyyy");
        FechaHasta.setEnabled(false);
        FechaHasta.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        FechaHasta.setMaxSelectableDate(new java.util.Date(32503694508000L));
        FechaHasta.setMinSelectableDate(new java.util.Date(-2208974960000L));
        FechaHasta.getDateEditor().getUiComponent().addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if(Validaciones.Letras(evt.getKeyChar()) || Validaciones.Espacio(evt.getKeyChar())) evt.consume();
            }
        });

        labelBuscar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelBuscar.setText("Buscar:");

        campoBuscar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoBuscarKeyTyped(evt);
            }
        });

        grupoRadio.add(radioUsuario);
        radioUsuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        radioUsuario.setSelected(true);
        radioUsuario.setText("Por Nº Pago");
        radioUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioUsuarioActionPerformed(evt);
            }
        });

        grupoRadio.add(radioFecha);
        radioFecha.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        radioFecha.setText("Por Fecha");
        radioFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFechaActionPerformed(evt);
            }
        });

        labelDesde.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelDesde.setText("Desde:");

        labelHasta.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelHasta.setText("Hasta:");

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setEnabled(false);
        btnBuscar.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBusquedaLayout = new javax.swing.GroupLayout(panelBusqueda);
        panelBusqueda.setLayout(panelBusquedaLayout);
        panelBusquedaLayout.setHorizontalGroup(
            panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBusquedaLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(labelBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(radioUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioFecha)
                .addGap(52, 52, 52)
                .addComponent(labelDesde)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(labelHasta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addGap(4, 4, 4))
        );
        panelBusquedaLayout.setVerticalGroup(
            panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBusquedaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(radioFecha)
                    .addComponent(radioUsuario)
                    .addComponent(labelDesde)
                    .addComponent(labelBuscar)
                    .addComponent(labelHasta)
                    .addComponent(FechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(10, 10, 10))
        );

        tablaPagosxLote.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tablaPagosxLote.setModel(new TablaPagos(dao.Pagos.listarPagosxLotes(idLote)));
        tablaPagosxLote.setRowHeight(20);
        tablaPagosxLote.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaPagosxLote.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tablaPagosxLoteFocusGained(evt);
            }
        });
        tablaPagosxLote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPagosxLoteMouseClicked(evt);
            }
        });
        tablaPagosxLote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaPagosxLoteKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPagosxLote);
        tablaPagosxLote.getTableHeader().setFont(new java.awt.Font("SegoeUI", 0, 12));
        tablaPagosxLote.getColumnModel().getColumn(3).setCellRenderer(utilidades.Renderers.rendererNumeros());
        tablaPagosxLote.getColumnModel().getColumn(2).setCellRenderer(utilidades.Renderers.rendererFecha());

        btnNuevoPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/POS.png"))); // NOI18N
        btnNuevoPago.setToolTipText("Nuevo Pago");
        btnNuevoPago.setBorderPainted(false);
        btnNuevoPago.setContentAreaFilled(false);
        btnNuevoPago.setIconTextGap(0);
        btnNuevoPago.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnNuevoPago.setMaximumSize(new java.awt.Dimension(50, 50));
        btnNuevoPago.setMinimumSize(new java.awt.Dimension(50, 50));
        btnNuevoPago.setPreferredSize(new java.awt.Dimension(50, 50));
        btnNuevoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPagoActionPerformed(evt);
            }
        });

        btnImprimir.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imprimir.png"))); // NOI18N
        btnImprimir.setToolTipText("Imprimir facturas");
        btnImprimir.setBorderPainted(false);
        btnImprimir.setContentAreaFilled(false);
        btnImprimir.setIconTextGap(0);
        btnImprimir.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnImprimir.setMaximumSize(new java.awt.Dimension(50, 50));
        btnImprimir.setMinimumSize(new java.awt.Dimension(50, 50));
        btnImprimir.setPreferredSize(new java.awt.Dimension(50, 50));
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
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
                        .addComponent(btnNuevoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyReleased
        if (radioUsuario.isSelected()) {
            f.filtrarBusquedaAbstract(campoBuscar.getText().toUpperCase(), tablaPagosxLote, 0);
        } else if (radioFecha.isSelected()) {
            f.filtrarBusquedaAbstract(campoBuscar.getText().toUpperCase(), tablaPagosxLote, 1);
        }
    }//GEN-LAST:event_campoBuscarKeyReleased

    private void btnNuevoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPagoActionPerformed
        int seleccion = JOptionPane.showOptionDialog(null, "¿Qué tipo de factura desea generar?",
                "Seleccionar Opciones Disponibles", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                new Object[]{"Pago por Consumo", "Derecho de Conexión/Consumos Anteriores", "Otros Servicios", "Pago por Adelantado"}, "Pago por Consumo");
        switch (seleccion) {
            case -1:
                btnNuevoPago.setEnabled(true);
                break;
            case 0:
                NuevoPago np = new NuevoPago(idLote);
                Funciones.centrar(np, conexion.InicioSesion.getUsuario().contains("admin") ? PrincipalAdmin.panelEscritorio : Principal.panelEscritorio);
                btnNuevoPago.setEnabled(false);
                break;
            case 1:
                NuevoPagoDC dc = new NuevoPagoDC(idLote);
                Funciones.centrar(dc, conexion.InicioSesion.getUsuario().contains("admin") ? PrincipalAdmin.panelEscritorio : Principal.panelEscritorio);
                btnNuevoPago.setEnabled(false);
                break;
            case 2:
                NuevoPagoOtros npo = new NuevoPagoOtros(idLote);
                Funciones.centrar(npo, conexion.InicioSesion.getUsuario().contains("admin") ? PrincipalAdmin.panelEscritorio : Principal.panelEscritorio);
                btnNuevoPago.setEnabled(false);
                break;
            case 3:
                NuevoPagoFavor pa = new NuevoPagoFavor(btnNuevoPago, idLote);
                Funciones.centrar(pa, conexion.InicioSesion.getUsuario().contains("admin") ? PrincipalAdmin.panelEscritorio : Principal.panelEscritorio);
                btnNuevoPago.setEnabled(false);
                break;
        }
    }//GEN-LAST:event_btnNuevoPagoActionPerformed

    private void tablaPagosxLoteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaPagosxLoteKeyPressed
        if (tablaPagosxLote.getRowCount() > 0) {
            if (tablaPagosxLote.getSelectedRow() > -1) {
                if (evt.getKeyCode() == KeyEvent.VK_CONTEXT_MENU) {
                    java.awt.Component c = (java.awt.Component) evt.getSource();
                    if (Validaciones.numeroFacturaValido(tablaPagosxLote.getValueAt(tablaPagosxLote.getSelectedRow(), 1).toString())) {
                        menuReimprimirRecibo.setVisible(false);
                        menuReimprimir.setVisible(false);
                        menuReimprimirOrig.setVisible(true);
                    } else {
                        menuReimprimir.setVisible(false);
                        menuReimprimirOrig.setVisible(false);
                        menuReimprimirRecibo.setVisible(true);
                    }
                    menuOpciones.show(c, c.getX(), c.getY());
                    menuOpciones.requestFocus();
                }
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    tablaPagosxLote.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter"); //para que no pase el foco a la siguiente fila cuando se presiona Enter
                    DetalleFactura df = new DetalleFactura(this, true, tablaPagosxLote.getValueAt(tablaPagosxLote.getSelectedRow(), 0).toString(), idLote);
                    tablaPagosxLote.getActionMap().put("Enter", new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            df.setLocationRelativeTo(conexion.InicioSesion.getUsuario().contains("admin") ? PrincipalAdmin.panelEscritorio : Principal.panelEscritorio);
                            df.setVisible(true);
                        }
                    });
                }
            }
        }
    }//GEN-LAST:event_tablaPagosxLoteKeyPressed

    private void tablaPagosxLoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPagosxLoteMouseClicked
        if (tablaPagosxLote.getRowCount() > 0) {
            if (tablaPagosxLote.getSelectedRow() > -1) {
                if (SwingUtilities.isRightMouseButton(evt)) {
                    java.awt.Point point = evt.getPoint();
                    int currentRow = tablaPagosxLote.rowAtPoint(point);
                    tablaPagosxLote.setRowSelectionInterval(currentRow, currentRow);
                    if (Validaciones.numeroFacturaValido(tablaPagosxLote.getValueAt(tablaPagosxLote.getSelectedRow(), 1).toString())) {
                        menuReimprimirRecibo.setVisible(false);
                        menuReimprimir.setVisible(false);
                        menuReimprimirOrig.setVisible(true);
                    } else {
                        menuReimprimir.setVisible(false);
                        menuReimprimirOrig.setVisible(false);
                        menuReimprimirRecibo.setVisible(true);
                    }

                    menuOpciones.show(evt.getComponent(), evt.getX(), evt.getY());
                    menuOpciones.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_tablaPagosxLoteMouseClicked

    private void tablaPagosxLoteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaPagosxLoteFocusGained
        if (tablaPagosxLote.getRowCount() > 0) {
            if (tablaPagosxLote.getSelectedRow() < 0) {
                tablaPagosxLote.setRowSelectionInterval(0, 0);
            }
        }
    }//GEN-LAST:event_tablaPagosxLoteFocusGained

    private void menuReimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReimprimirActionPerformed
        java.util.List<modelos.DetallePago> dp = new dao.Pagos().listarDetallePago(tablaPagosxLote.getValueAt(tablaPagosxLote.getSelectedRow(), 0).toString());
        java.util.List<modelos.Factura> df = new java.util.ArrayList<>();
        dp.stream().map((det) -> {
            modelos.Factura n = new modelos.Factura();
            n.setCodDetalle(null);
            n.setCantDetalle(det.getCantidad());
            n.setDescDetalle(det.getConcepto());
            n.setPrecioUnitDetalle(det.getSubtotal());
            n.setExentaDetalle(det.getTipoIVA() == 0 ? det.getCantidad() * (det.getSubtotal() - det.getMontoDescuento()) : null);
            n.setcDetalle(det.getTipoIVA() == 5 ? det.getCantidad() * (det.getSubtotal() - det.getMontoDescuento()) : null);
            n.setdDetalle(det.getTipoIVA() == 10 ? det.getCantidad() * (det.getSubtotal() - det.getMontoDescuento()) : null);
            return n;
        }).forEachOrdered((n) -> {
            df.add(n);
        });
        reportes.Informes inf = new reportes.Informes();
        inf.mostrarFacturaReimpresa(df, dao.Pagos.listarPago(tablaPagosxLote.getValueAt(tablaPagosxLote.getSelectedRow(), 0).toString()));
    }//GEN-LAST:event_menuReimprimirActionPerformed

    private void radioFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFechaActionPerformed
        FechaDesde.setEnabled(true);
        FechaHasta.setEnabled(true);
        tablaPagosxLote.setRowSorter(null);
        campoBuscar.setEnabled(false);
        btnBuscar.setEnabled(true);
    }//GEN-LAST:event_radioFechaActionPerformed

    private void radioUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioUsuarioActionPerformed
        FechaDesde.setEnabled(false);
        FechaHasta.setEnabled(false);
        FechaDesde.setDate(null);
        FechaHasta.setDate(null);
        tablaPagosxLote.setRowSorter(null);
        campoBuscar.setEnabled(true);
        btnBuscar.setEnabled(false);
    }//GEN-LAST:event_radioUsuarioActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        f.filtrarBusquedaFechaRango(FechaDesde.getDate(), FechaHasta.getDate(), tablaPagosxLote, 1);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void campoBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyTyped
        f.convertirAMayusculas(evt);
    }//GEN-LAST:event_campoBuscarKeyTyped

    private void menuReimprimirReciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReimprimirReciboActionPerformed
        java.util.List<modelos.DetallePago> dp = new dao.Pagos().listarDetallePago(tablaPagosxLote.getValueAt(tablaPagosxLote.getSelectedRow(), 0).toString());
        java.util.List<modelos.Recibo> df = new java.util.ArrayList<>();
        java.util.List<String> cabecera = dao.Pagos.listarPago(tablaPagosxLote.getValueAt(tablaPagosxLote.getSelectedRow(), 0).toString());
        dp.stream().map((det) -> {
            modelos.Recibo n = new modelos.Recibo();
            n.setFecha(utilidades.Estaticos.FORMATODMA.format(((TablaPagos) (tablaPagosxLote.getModel())).getValueAt(tablaPagosxLote.getSelectedRow(), 2)));
            n.setConceptoRec(det.getConcepto().concat(".-"));
            n.setImporteRecibo(Integer.parseInt(((TablaPagos) (tablaPagosxLote.getModel())).getValueAt(tablaPagosxLote.getSelectedRow(), 3).toString()));
            n.setNombreRec(cabecera.get(2));
            n.setSumaRec(new utilidades.NumeroALetras().Convertir(((TablaPagos) (tablaPagosxLote.getModel())).getValueAt(tablaPagosxLote.getSelectedRow(), 3).toString(), true) + " GUARANÍES ");
            return n;
        }).forEachOrdered((n) -> {
            df.add(n);
        });
        reportes.Informes inf = new reportes.Informes();
        inf.mostrarReciboReimpreso(df, tablaPagosxLote.getValueAt(tablaPagosxLote.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_menuReimprimirReciboActionPerformed

    private void menuOpcionesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_menuOpcionesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            menuOpciones.setVisible(false);
        }
    }//GEN-LAST:event_menuOpcionesKeyPressed

    private void menuReimprimirOrigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReimprimirOrigActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "Esta operación implica anular el nº de factura vinculado a este pago y asignarle un nuevo número. ¿Continuar? ", "Advertencia", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_NO_OPTION) {
            dao.Pagos pago = new dao.Pagos();
            Integer nuevo;
            if ((nuevo = pago.reasignarNumFactura(tablaPagosxLote.getValueAt(tablaPagosxLote.getSelectedRow(), 0).toString())) != null) {
                java.util.List<modelos.DetallePago> dp = new dao.Pagos().listarDetallePago(String.format("%s", nuevo));
                java.util.List<modelos.Factura> df = new java.util.ArrayList<>();
                dp.stream().map((det) -> {
                    modelos.Factura n = new modelos.Factura();
                    n.setCodDetalle(null);
                    n.setCantDetalle(det.getCantidad());
                    n.setDescDetalle(det.getConcepto());
                    n.setPrecioUnitDetalle(det.getSubtotal());
                    n.setExentaDetalle(det.getTipoIVA() == 0 ? det.getCantidad() * (det.getSubtotal() - det.getMontoDescuento()) : null);
                    n.setcDetalle(det.getTipoIVA() == 5 ? det.getCantidad() * (det.getSubtotal() - det.getMontoDescuento()) : null);
                    n.setdDetalle(det.getTipoIVA() == 10 ? det.getCantidad() * (det.getSubtotal() - det.getMontoDescuento()) : null);
                    return n;
                }).forEachOrdered((n) -> {
                    df.add(n);
                });
                reportes.Factura fact = new reportes.Factura();
                List<String> cab = dao.Pagos.listarPago(String.format("%s", nuevo));
                int total = pago.BuscarErssanxPago(nuevo);
                int no_pagados = dao.Pagos.ContarFacturasNoPagadas(Integer.valueOf(cab.get(6)));
                 if (no_pagados > 1) {
                    fact.mostrarFactura(nuevo, String.valueOf(total), "ÚLTIMO AVISO");
                } else if(no_pagados > 2){
                    fact.mostrarFactura(nuevo, String.valueOf(total), "DESCONEXIÓN");
                }else{
                    fact.mostrarFactura(nuevo, String.valueOf(total), "");
                }
                if (!fact.imprimir("fni")) {
                    JOptionPane.showMessageDialog(null, "No se pudo imprimir. Se guardó una copia de la factura.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (fact.getVisor() != null && fact.getVisor().isShowing()) {
                    fact.getVisor().dispose();
                }
                ((TablaPagos) tablaPagosxLote.getModel()).limpiar();
                ((TablaPagos) tablaPagosxLote.getModel()).setPagos(dao.Pagos.listarPagosxLotes(idLote));
                ((TablaLotePagos) tablaPagos.getModel()).limpiar();
                ((TablaLotePagos) tablaPagos.getModel()).setPagos(dao.Pagos.listarLotesPagos());
            }
        }
    }//GEN-LAST:event_menuReimprimirOrigActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        ImprimirFacturas imprimir = new ImprimirFacturas(this, true);
        imprimir.setLocationRelativeTo(conexion.InicioSesion.getUsuario().contains("admin") ? PrincipalAdmin.panelEscritorio : Principal.panelEscritorio);
        imprimir.setVisible(true);
    }//GEN-LAST:event_btnImprimirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser FechaDesde;
    private com.toedter.calendar.JDateChooser FechaHasta;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnImprimir;
    protected static javax.swing.JButton btnNuevoPago;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.ButtonGroup grupoRadio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBuscar;
    private javax.swing.JLabel labelDesde;
    private javax.swing.JLabel labelHasta;
    private javax.swing.JPopupMenu menuOpciones;
    private javax.swing.JMenuItem menuReimprimir;
    private javax.swing.JMenuItem menuReimprimirOrig;
    private javax.swing.JMenuItem menuReimprimirRecibo;
    private javax.swing.JPanel panelBusqueda;
    private javax.swing.JRadioButton radioFecha;
    private javax.swing.JRadioButton radioUsuario;
    protected static javax.swing.JTable tablaPagosxLote;
    // End of variables declaration//GEN-END:variables
}
