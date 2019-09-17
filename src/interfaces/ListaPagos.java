package interfaces;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import utilidades.Funciones;
import utilidades.Validaciones;

public class ListaPagos extends javax.swing.JInternalFrame {

    Funciones f;
    dao.Pagos p = new dao.Pagos();

    public ListaPagos() {
        initComponents();
        f = new Funciones();
        btnNuevoPago.setVisible(false);
        utilidades.Funciones.cerrarConEscape(ListaPagos.this);
    }

    @Override
    public void dispose() {
        if (conexion.InicioSesion.getUsuario().contains("admin")) {
            PrincipalAdmin.accionar("inicio");
        } else {
            Principal.accionar("inicio");
        }
        super.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoRadio = new javax.swing.ButtonGroup();
        panelBusqueda = new javax.swing.JPanel();
        labelBuscar = new javax.swing.JLabel();
        campoBuscar = new javax.swing.JTextField();
        radioLote = new javax.swing.JRadioButton();
        radioFecha = new javax.swing.JRadioButton();
        radioMes = new javax.swing.JRadioButton();
        radioYear = new javax.swing.JRadioButton();
        campoFecha = new com.toedter.calendar.JDateChooser();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPagos = new javax.swing.JTable();
        btnNuevoPago = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();

        setClosable(true);
        setTitle("Pagos Efectuados");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/y_mini.png"))); // NOI18N

        labelBuscar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelBuscar.setText("Buscar:");

        campoBuscar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoBuscarKeyReleased(evt);
            }
        });

        grupoRadio.add(radioLote);
        radioLote.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        radioLote.setSelected(true);
        radioLote.setText("Por Nº Lote");
        radioLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioLoteActionPerformed(evt);
            }
        });

        grupoRadio.add(radioFecha);
        radioFecha.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        radioFecha.setText("Por Fecha de Lote");
        radioFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFechaActionPerformed(evt);
            }
        });

        grupoRadio.add(radioMes);
        radioMes.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        radioMes.setText("Por Mes");
        radioMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMesActionPerformed(evt);
            }
        });

        grupoRadio.add(radioYear);
        radioYear.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        radioYear.setText("Por Año");
        radioYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioYearActionPerformed(evt);
            }
        });

        campoFecha.setDateFormatString("dd/MM/yyyy");
        campoFecha.setEnabled(false);
        campoFecha.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoFecha.setMaxSelectableDate(new java.util.Date(32503694508000L));
        campoFecha.setMinSelectableDate(new java.util.Date(-2208974960000L));
        campoFecha.getDateEditor().getUiComponent().addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if(Validaciones.Letras(evt.getKeyChar()) || Validaciones.Espacio(evt.getKeyChar())) evt.consume();
            }
        });

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBusquedaLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(labelBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(radioLote)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioMes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioYear)
                .addGap(10, 10, 10)
                .addComponent(radioFecha)
                .addGap(27, 27, 27)
                .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addGap(20, 20, 20))
        );
        panelBusquedaLayout.setVerticalGroup(
            panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(radioFecha)
                    .addComponent(radioLote)
                    .addComponent(labelBuscar)
                    .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioMes)
                    .addComponent(radioYear)
                    .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(9, 9, 9))
        );

        tablaPagos.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tablaPagos.setModel(new clases.tablas.TablaLotePagos(p.listarLotesPagos()));
        tablaPagos.setRowHeight(20);
        tablaPagos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaPagos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tablaPagosFocusGained(evt);
            }
        });
        tablaPagos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPagosMouseClicked(evt);
            }
        });
        tablaPagos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaPagosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPagos);
        tablaPagos.setAutoCreateRowSorter(true);
        tablaPagos.getTableHeader().setFont(new java.awt.Font("SegoeUI", 0, 12));
        tablaPagos.getColumnModel().getColumn(1).setCellRenderer(utilidades.Renderers.rendererFecha());
        tablaPagos.getColumnModel().getColumn(3).setCellRenderer(utilidades.Renderers.rendererCentro());
        tablaPagos.getColumnModel().getColumn(4).setCellRenderer(utilidades.Renderers.rendererNumeros());
        tablaPagos.getColumnModel().getColumn(5).setCellRenderer(utilidades.Renderers.rendererNumeros());
        tablaPagos.getColumnModel().getColumn(4).setMinWidth(80);
        tablaPagos.getColumnModel().getColumn(4).setMaxWidth(80);
        tablaPagos.getColumnModel().getColumn(3).setMinWidth(100);
        tablaPagos.getColumnModel().getColumn(3).setMaxWidth(100);
        tablaPagos.getColumnModel().getColumn(1).setMinWidth(100);
        tablaPagos.getColumnModel().getColumn(1).setMaxWidth(100);

        btnNuevoPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/factura.png"))); // NOI18N
        btnNuevoPago.setToolTipText("Nuevo Lote de Pago");
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

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imprimir.png"))); // NOI18N
        btnImprimir.setToolTipText("Imprimir Pagos por Lote");
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
                        .addGap(766, 766, 766)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNuevoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyReleased
        if (radioLote.isSelected()) {
            f.filtrarBusquedaAbstract(campoBuscar.getText().toUpperCase(), tablaPagos, 0);
        } else if (radioFecha.isSelected()) {
            f.filtrarBusquedaAbstract(campoBuscar.getText().toUpperCase(), tablaPagos, 1);
        } else if (radioMes.isSelected()) {
            f.filtrarBusquedaAbstract(campoBuscar.getText().toUpperCase(), tablaPagos, 3);
        } else if (radioYear.isSelected()) {
            f.filtrarBusquedaAbstract(campoBuscar.getText().toUpperCase(), tablaPagos, 4);
        }
    }//GEN-LAST:event_campoBuscarKeyReleased

    private void btnNuevoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPagoActionPerformed
        Pagos ip = new Pagos();
        Funciones.centrar(ip, conexion.InicioSesion.getUsuario().contains("admin") ? PrincipalAdmin.panelEscritorio : Principal.panelEscritorio);
        btnNuevoPago.setEnabled(false);
    }//GEN-LAST:event_btnNuevoPagoActionPerformed

    private void tablaPagosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaPagosKeyPressed
        if (tablaPagos.getRowCount() > 0) {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                ListaFacturasxLotes lfl = new ListaFacturasxLotes(tablaPagos.getValueAt(tablaPagos.getSelectedRow(), 0).toString());
                Funciones.centrar(lfl, conexion.InicioSesion.getUsuario().contains("admin") ? PrincipalAdmin.panelEscritorio : Principal.panelEscritorio);
            }
        }
    }//GEN-LAST:event_tablaPagosKeyPressed

    private void tablaPagosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPagosMouseClicked
        if (evt.getClickCount() == 2) {
            if (tablaPagos.getSelectedRow() >= 0) {
                ListaFacturasxLotes lfl = new ListaFacturasxLotes(tablaPagos.getValueAt(tablaPagos.getSelectedRow(), 0).toString());
                Funciones.centrar(lfl, conexion.InicioSesion.getUsuario().contains("admin") ? PrincipalAdmin.panelEscritorio : Principal.panelEscritorio);
            }
        }
    }//GEN-LAST:event_tablaPagosMouseClicked

    private void tablaPagosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaPagosFocusGained
        if (evt.getComponent().getMousePosition() == null) {
            tablaPagos.changeSelection(0, 0, false, false);
        }
    }//GEN-LAST:event_tablaPagosFocusGained

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        if (tablaPagos.getSelectedRow() > -1) {
            String elLote = tablaPagos.getValueAt(tablaPagos.getSelectedRow(), 0).toString();
            modelos.LotePagos lotePago = dao.Pagos.obtenerLotePago(elLote);
            reportes.Informes inf = new reportes.Informes();
            inf.mostrarInformePagos(dao.Reportes.obtenerPagosPorLote(elLote, "TODOS"), elLote, lotePago);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un lote para imprimir su contenido.", "Seleccionar Lote", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void radioMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMesActionPerformed
        tablaPagos.setRowSorter(null);
        campoBuscar.setText("");
        campoBuscar.setEnabled(true);
        campoFecha.setEnabled(false);
        campoFecha.setDate(null);
        btnBuscar.setEnabled(false);
    }//GEN-LAST:event_radioMesActionPerformed

    private void radioYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioYearActionPerformed
        tablaPagos.setRowSorter(null);
        campoBuscar.setText("");
        campoBuscar.setEnabled(true);
        campoFecha.setEnabled(false);
        campoFecha.setDate(null);
        btnBuscar.setEnabled(false);
    }//GEN-LAST:event_radioYearActionPerformed

    private void radioLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioLoteActionPerformed
        tablaPagos.setRowSorter(null);
        campoBuscar.setText("");
        campoBuscar.setEnabled(false);
        campoFecha.setEnabled(false);
        campoFecha.setDate(null);
        btnBuscar.setEnabled(true);
    }//GEN-LAST:event_radioLoteActionPerformed

    private void radioFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFechaActionPerformed
        tablaPagos.setRowSorter(null);
        campoFecha.setEnabled(true);
        ((javax.swing.JTextField) campoFecha.getDateEditor().getUiComponent()).setEnabled(false);
        btnBuscar.setEnabled(true);
        campoBuscar.setText("");
        campoBuscar.setEnabled(false);
    }//GEN-LAST:event_radioFechaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (!f.validarDateChooser(campoFecha)) {
            JOptionPane.showMessageDialog(null, "Ingrese una fecha válida.", "Formato incorrecto de fecha", JOptionPane.ERROR_MESSAGE);
        }
        f.filtrarBusquedaFechaRango(campoFecha.getDate(), campoFecha.getDate(), tablaPagos, 1);
    }//GEN-LAST:event_btnBuscarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    protected static javax.swing.JButton btnImprimir;
    protected static javax.swing.JButton btnNuevoPago;
    private javax.swing.JTextField campoBuscar;
    private com.toedter.calendar.JDateChooser campoFecha;
    private javax.swing.ButtonGroup grupoRadio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBuscar;
    private javax.swing.JPanel panelBusqueda;
    private javax.swing.JRadioButton radioFecha;
    private javax.swing.JRadioButton radioLote;
    private javax.swing.JRadioButton radioMes;
    private javax.swing.JRadioButton radioYear;
    protected static javax.swing.JTable tablaPagos;
    // End of variables declaration//GEN-END:variables
}
