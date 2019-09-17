package interfaces;

import clases.tablas.TablaLecturasXZonas;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.tree.DefaultMutableTreeNode;
import utilidades.Funciones;

public class LecturasxZonaxUsuarios extends javax.swing.JInternalFrame {

    private final int idLote;
    private final Date fechaVenc;
    DefaultMutableTreeNode nodo;

    Map<Integer, TableCellRenderer> mapa;
    Map<Integer, Integer> mapasizecolumnas;
    String[] titulos = {"Nº Comprobante", "Fecha", "Cód. Usuario", "Nombre Usuario", "Nº Medidor", "Lectura", "Importe Total"};

    public LecturasxZonaxUsuarios(int idLote, Date fechaVenc) {
        this.idLote = idLote;
        mapaRenderers();
        initComponents();
        this.fechaVenc = fechaVenc;
        eliminarComprobante();
        accesoADetalle();
        descontarDeAFavor();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        arbolZonas = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDetalle = new javax.swing.JTable();
        btnAddComprobante = new javax.swing.JButton();

        setClosable(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/y_mini.png"))); // NOI18N

        arbolZonas.setModel(new clases.arboles.ArbolComprobantesxZonas().ArbolComprobantesxZonas(idLote));
        arbolZonas.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                arbolZonasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(arbolZonas);

        tablaDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº Comprobante", "Fecha", "Cód. Usuario", "Nombre Usuario", "Nº Medidor", "Lectura", "Importe Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDetalle.setAutoCreateRowSorter(true);
        tablaDetalle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tablaDetalleFocusGained(evt);
            }
        });
        jScrollPane2.setViewportView(tablaDetalle);

        btnAddComprobante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/generarfactura.png"))); // NOI18N
        btnAddComprobante.setToolTipText("Nuevo Comprobante");
        btnAddComprobante.setBorderPainted(false);
        btnAddComprobante.setContentAreaFilled(false);
        btnAddComprobante.setIconTextGap(0);
        btnAddComprobante.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnAddComprobante.setMaximumSize(new java.awt.Dimension(50, 50));
        btnAddComprobante.setMinimumSize(new java.awt.Dimension(50, 50));
        btnAddComprobante.setPreferredSize(new java.awt.Dimension(50, 50));
        btnAddComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddComprobanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(713, 713, 713))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnAddComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void arbolZonasValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_arbolZonasValueChanged
        nodo = (DefaultMutableTreeNode) arbolZonas.getLastSelectedPathComponent();
        if (nodo == null) {
            return;
        }
        if (nodo.getLevel() == 1) {
            tablaDetalle.setModel(new TablaLecturasXZonas(dao.Zonas.listaComprobantesxZona(idLote, ((modelos.Zona) nodo.getUserObject()).getIdentificador())));
            utilidades.Funciones.setRenderers(mapa, tablaDetalle);
            utilidades.Funciones.setMinimoyMaximoColumnas(mapasizecolumnas, tablaDetalle);
        } else {
            if (tablaDetalle.getModel() instanceof TablaLecturasXZonas) {
                DefaultTableModel tbl = new DefaultTableModel(null, ((TablaLecturasXZonas) tablaDetalle.getModel()).getColumnas());
                tablaDetalle.setModel(tbl);
            } else {
                DefaultTableModel tbl = new DefaultTableModel(null, titulos);
                tablaDetalle.setModel(tbl);
            }
        }
    }//GEN-LAST:event_arbolZonasValueChanged

    private void btnAddComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddComprobanteActionPerformed
        btnAddComprobante.setEnabled(false);
        NuevaLecturaNeo nn = new NuevaLecturaNeo(idLote, fechaVenc);
        Funciones.centrar(nn, conexion.InicioSesion.getUsuario().contains("admin") ? PrincipalAdmin.panelEscritorio : Principal.panelEscritorio);
    }//GEN-LAST:event_btnAddComprobanteActionPerformed

    private void tablaDetalleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaDetalleFocusGained
        if (evt.getComponent().getMousePosition() == null) {
            if (tablaDetalle.getSelectedRow() < 0) {
                tablaDetalle.changeSelection(0, 0, false, false);
            }
        }
    }//GEN-LAST:event_tablaDetalleFocusGained

    private void eliminarComprobante() {
        tablaDetalle.getInputMap(javax.swing.JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0), "DEL");
        tablaDetalle.getActionMap().put("DEL", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                if (!((TablaLecturasXZonas) tablaDetalle.getModel()).getValueAt(tablaDetalle.getSelectedRow(), 9).toString().equals("PENDIENTE")) {
                    JOptionPane.showMessageDialog(null, "No se puede eliminar: el comprobante ya fue parcial o totalmente pagado.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String actual = ((TablaLecturasXZonas) tablaDetalle.getModel()).getValueAt(tablaDetalle.getSelectedRow(), 8).toString();
                    switch (actual) {
                        case "S":
                            int resp = JOptionPane.showConfirmDialog(null, "¿Desea realmente eliminar el comprobante Nº " + ((TablaLecturasXZonas) tablaDetalle.getModel()).getValueAt(tablaDetalle.getSelectedRow(), 0).toString() + " con su correspondiente lectura?", "Confirmar", JOptionPane.YES_NO_OPTION);
                            if (resp == JOptionPane.YES_OPTION) {
                                dao.Medidor ac = new dao.Medidor();
                                boolean estado = ac.darBajaComprobanteyLectura(((TablaLecturasXZonas) tablaDetalle.getModel()).getValueAt(tablaDetalle.getSelectedRow(), 0).toString(),
                                        ((TablaLecturasXZonas) tablaDetalle.getModel()).getValueAt(tablaDetalle.getSelectedRow(), 7).toString(), actual);
                                if (estado) {
                                    JOptionPane.showMessageDialog(null, "Se eliminó correctamente.", "Atención", JOptionPane.INFORMATION_MESSAGE);
                                    arbolZonas.setModel(new clases.arboles.ArbolComprobantesxZonas().ArbolComprobantesxZonas(idLote));
                                    DefaultTableModel tbl = new DefaultTableModel(null, titulos);
                                    tablaDetalle.setModel(tbl);
                                } else {
                                    JOptionPane.showMessageDialog(null, "No se puede eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            break;
                        case "N":
                            int res = JOptionPane.showConfirmDialog(null, "¿Desea realmente eliminar el comprobante nº " + ((TablaLecturasXZonas) tablaDetalle.getModel()).getValueAt(tablaDetalle.getSelectedRow(), 0).toString() + " con su correspondiente lectura?", "Confirmar", JOptionPane.YES_NO_OPTION);
                            if (res == JOptionPane.YES_OPTION) {
                                dao.Medidor ac = new dao.Medidor();
                                boolean estado = ac.darBajaComprobanteyLectura(((TablaLecturasXZonas) tablaDetalle.getModel()).getValueAt(tablaDetalle.getSelectedRow(), 0).toString(),
                                        ((TablaLecturasXZonas) tablaDetalle.getModel()).getValueAt(tablaDetalle.getSelectedRow(), 7).toString(), actual);
                                if (estado) {
                                    JOptionPane.showMessageDialog(null, "Se eliminó correctamente.", "Atención", JOptionPane.INFORMATION_MESSAGE);
                                    arbolZonas.setModel(new clases.arboles.ArbolComprobantesxZonas().ArbolComprobantesxZonas(idLote));
                                    DefaultTableModel tbl = new DefaultTableModel(null, titulos);
                                    tablaDetalle.setModel(tbl);
                                } else {
                                    JOptionPane.showMessageDialog(null, "No se pudo eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            break;
                        case "A":
                            JOptionPane.showMessageDialog(null, "No se puede eliminar: ya existe más de una lectura posterior a esta, correspondiente a este medidor.", "Error", JOptionPane.ERROR_MESSAGE);
                            break;
                        default:
                            return;
                    }
                }
            }
        });
    }

    private void mapaRenderers() {
        mapa = new HashMap();
        mapa.put(1, utilidades.Renderers.rendererFecha());
        mapa.put(5, utilidades.Renderers.rendererNumeros());
        mapa.put(6, utilidades.Renderers.rendererNumeros());

        mapasizecolumnas = new HashMap();
        mapasizecolumnas.put(6, 100);
        mapasizecolumnas.put(5, 100);
        mapasizecolumnas.put(1, 80);
        mapasizecolumnas.put(0, 100);
    }

    private void accesoADetalle() {
        tablaDetalle.getInputMap(javax.swing.JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0), "Enter");
        tablaDetalle.getActionMap().put("Enter", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                reportes.Factura fact = new reportes.Factura();
                dao.Pagos pago = new dao.Pagos();
                int id_pago = dao.Comprobante.BuscarIdPagoxComprobante(Integer.valueOf(((TablaLecturasXZonas) tablaDetalle.getModel()).getValueAt(tablaDetalle.getSelectedRow(), 0).toString()));
                System.out.println(id_pago);
                List<String> cab = dao.Pagos.listarPago(String.format("%s", id_pago));
                System.out.println(cab);
                int total = pago.BuscarErssanxPago(id_pago);
                int no_pagados = dao.Pagos.ContarFacturasNoPagadas(Integer.valueOf(cab.get(6)));
                if (no_pagados > 1) {
                    fact.mostrarFactura(id_pago, String.valueOf(total), "ÚLTIMO AVISO");
                } else if(no_pagados > 2){
                    fact.mostrarFactura(id_pago, String.valueOf(total), "DESCONEXIÓN");
                }else{
                    fact.mostrarFactura(id_pago, String.valueOf(total), "");
                }
//                reportes.Comprobante c = new reportes.Comprobante();
//                c.abrirComprobante(((TablaLecturasXZonas) tablaDetalle.getModel()).getValueAt(tablaDetalle.getSelectedRow(), 7).toString(), LecturasxZonaxUsuarios.this);
            }
        });
    }

    private void descontarDeAFavor() {
        tablaDetalle.getInputMap(javax.swing.JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, 0), "PAGAR");
        tablaDetalle.getActionMap().put("PAGAR", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                if (!((TablaLecturasXZonas) tablaDetalle.getModel()).getValueAt(tablaDetalle.getSelectedRow(), 9).toString().equals("PENDIENTE")
                        && !((TablaLecturasXZonas) tablaDetalle.getModel()).getValueAt(tablaDetalle.getSelectedRow(), 9).toString().equals("PARCIALMENTE PAGADO")) {
                    JOptionPane.showMessageDialog(null, "El comprobante ya totalmente pagado.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (dao.Comprobante.obtenerPendientesAnterioresA(
                            ((TablaLecturasXZonas) tablaDetalle.getModel()).getValueAt(tablaDetalle.getSelectedRow(), 0).toString(),
                            Integer.parseInt(((TablaLecturasXZonas) tablaDetalle.getModel()).getValueAt(tablaDetalle.getSelectedRow(), 10).toString())) > 0) {
                        JOptionPane.showMessageDialog(null, "Existen comprobantes anteriores a este aún pendientes de pago.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        Integer afavor = dao.Cuentas.medidorSaldo(Integer.parseInt(((TablaLecturasXZonas) tablaDetalle.getModel()).getValueAt(tablaDetalle.getSelectedRow(), 10).toString()));
                        if (afavor > 0) {
                            int resp = JOptionPane.showConfirmDialog(null, "¿Desea realmente efectuar el pago del comprobante Nº " + ((TablaLecturasXZonas) tablaDetalle.getModel()).getValueAt(tablaDetalle.getSelectedRow(), 0).toString() + " con el saldo a favor que posee su cuenta?", "Confirmar", JOptionPane.YES_NO_OPTION);
                            if (resp == JOptionPane.YES_OPTION) {
                                dao.Pagos pago = new dao.Pagos();
                                modelos.Pago p = new modelos.Pago();
                                java.util.Date hoy = new java.util.Date();
                                p.setFechaPago(hoy);
                                p.setNumFactura(dao.Pagos.numeroComprobanteInterno());
                                Integer elLote = dao.Pagos.getIDLotePago(hoy);
                                if (elLote == null) {
                                    pago.insertarLotePago(new modelos.LotePagos(hoy, "GENERADO AUTOMÁTICAMENTE AL INSERTARSE UN COMPROBANTE INTERNO", "PAGOS CORRESPONDIENTE AL MES",
                                            new java.text.SimpleDateFormat("MMMM").format(hoy).toUpperCase(), new java.text.SimpleDateFormat("yyyy").format(hoy)));
                                    elLote = dao.Pagos.getIDLotePago(hoy);
                                }
                                p.setIdLote(String.valueOf(elLote));
                                String idUsuario = ((TablaLecturasXZonas) tablaDetalle.getModel()).getValueAt(tablaDetalle.getSelectedRow(), 2).toString();
                                p.setIdUsuario(idUsuario);
                                modelos.DetallePago dp = new modelos.DetallePago();
                                dp.setCantidad(1);
                                dp.setConcepto("PAGO POR CONSUMO - DESCONTADO DEL SALDO A FAVOR DEL USUARIO");
                                dp.setTipoIVA(0);
                                dp.setMontoDescuento(0);
                                dp.setIdComprobante(((TablaLecturasXZonas) tablaDetalle.getModel()).getValueAt(tablaDetalle.getSelectedRow(), 0).toString());
                                dp.setTipoPago("COMPROBANTES");
                                Integer idCuenta = Integer.parseInt(dao.Cuentas.getCuenta(Integer.parseInt(((TablaLecturasXZonas) tablaDetalle.getModel()).getValueAt(tablaDetalle.getSelectedRow(), 10).toString()), idUsuario));
                                dp.setIdCuenta(idCuenta);
                                int total = Integer.parseInt(((TablaLecturasXZonas) tablaDetalle.getModel()).getValueAt(tablaDetalle.getSelectedRow(), 6).toString());
                                total = total - dao.Comprobante.obtenerYaPagado(((TablaLecturasXZonas) tablaDetalle.getModel()).getValueAt(tablaDetalle.getSelectedRow(), 0).toString());
                                if (total <= afavor) {
                                    dao.Cuentas.actualizarSaldoAFavor(idCuenta, total, false);
                                    pago.actualizarComprobante(((TablaLecturasXZonas) tablaDetalle.getModel()).getValueAt(tablaDetalle.getSelectedRow(), 0).toString(), "PAGADO");
                                    dp.setSubtotal(total);
                                    p.setTotal(total);
                                } else {
                                    dao.Cuentas.actualizarSaldoAFavor(idCuenta, afavor, false);
                                    pago.actualizarComprobante(((TablaLecturasXZonas) tablaDetalle.getModel()).getValueAt(tablaDetalle.getSelectedRow(), 0).toString(), "PARCIALMENTE PAGADO");
                                    dp.setSubtotal(afavor);
                                    p.setTotal(afavor);
                                }
                                if (pago.insertarPagoMulti(p, dp)) {
                                    modelos.ComprobanteInterno ci = new modelos.ComprobanteInterno();
                                    ci.setNomApe(dao.Usuarios.obtenerUsuario(idUsuario));
                                    ci.setNumComprobante(((TablaLecturasXZonas) tablaDetalle.getModel()).getValueAt(tablaDetalle.getSelectedRow(), 0).toString());
                                    ci.setEstadoComprobante(dao.Comprobante.obtenerEstado(((TablaLecturasXZonas) tablaDetalle.getModel()).getValueAt(tablaDetalle.getSelectedRow(), 0).toString()));
                                    ci.setNumMedidor(((TablaLecturasXZonas) tablaDetalle.getModel()).getValueAt(tablaDetalle.getSelectedRow(), 4).toString());
                                    ci.setNumcuenta(idCuenta.toString());
                                    ci.setSaldoActual(afavor - total >= 0 ? afavor - total : 0);
                                    ci.setSaldoAnterior(afavor);

                                    new reportes.Informes().mostrarComprobanteInterno(ci);

                                    JOptionPane.showMessageDialog(null, "Se ha registrado la transacción con éxito.", "Transacción Exitosa", JOptionPane.INFORMATION_MESSAGE);
                                    arbolZonas.setModel(new clases.arboles.ArbolComprobantesxZonas().ArbolComprobantesxZonas(idLote));
                                    DefaultTableModel tbl = new DefaultTableModel(null, titulos);
                                    tablaDetalle.setModel(tbl);

                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "La cuenta actualmente no dispone de saldo a favor.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected static javax.swing.JTree arbolZonas;
    protected static javax.swing.JButton btnAddComprobante;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    protected static javax.swing.JTable tablaDetalle;
    // End of variables declaration//GEN-END:variables
}
