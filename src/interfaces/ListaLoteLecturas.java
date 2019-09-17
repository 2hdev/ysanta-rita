package interfaces;

import clases.tablas.TablaLotesLecturas;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import utilidades.Funciones;

public class ListaLoteLecturas extends javax.swing.JInternalFrame {

    dao.Medidor med;
    Funciones f = new Funciones();

    public ListaLoteLecturas() {
        med = new dao.Medidor();
        initComponents();
        accesoADetalle();
    }
    static TablaLotesLecturas tll;

    public static void setTll(TablaLotesLecturas tll) {
        ListaLoteLecturas.tll = tll;
    }

    public static TablaLotesLecturas getTll() {
        return tll;
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

        grupoBotones = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLecturas = new javax.swing.JTable();
        labelBuscar = new javax.swing.JLabel();
        campoBuscar = new javax.swing.JTextField();
        btnNuevoLoteComprobante = new javax.swing.JButton();
        radioLote = new javax.swing.JRadioButton();
        radioFecha = new javax.swing.JRadioButton();
        radioDesc = new javax.swing.JRadioButton();
        radioMes = new javax.swing.JRadioButton();
        radioYear = new javax.swing.JRadioButton();

        setClosable(true);
        setTitle("Lecturas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/y_mini.png"))); // NOI18N

        tll = new TablaLotesLecturas(dao.Comprobante.listarLotesLecturas());
        tablaLecturas.setModel(tll);
        tablaLecturas.setToolTipText("Haga clic dos veces sobre una fila para visualizar las lecturas ingresadas de cada lote.");
        tablaLecturas.getTableHeader().setReorderingAllowed(false);
        tablaLecturas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tablaLecturasFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(tablaLecturas);
        tablaLecturas.getTableHeader().setFont(new java.awt.Font("SegoeUI", 0, 12));
        tablaLecturas.setAutoCreateRowSorter(true);
        tablaLecturas.getColumnModel().getColumn(4).setCellRenderer(utilidades.Renderers.rendererFecha());
        tablaLecturas.getColumnModel().getColumn(3).setCellRenderer(utilidades.Renderers.rendererCentro());
        tablaLecturas.getColumnModel().getColumn(4).setMinWidth(120);
        tablaLecturas.getColumnModel().getColumn(4).setMaxWidth(120);
        tablaLecturas.getColumnModel().getColumn(2).setMinWidth(80);
        tablaLecturas.getColumnModel().getColumn(2).setMaxWidth(80);
        tablaLecturas.getColumnModel().getColumn(3).setMinWidth(100);
        tablaLecturas.getColumnModel().getColumn(3).setMaxWidth(100);
        tablaLecturas.getColumnModel().getColumn(0).setMinWidth(85);
        tablaLecturas.getColumnModel().getColumn(0).setMaxWidth(85);

        labelBuscar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelBuscar.setText("Buscar:");

        campoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoBuscarKeyReleased(evt);
            }
        });

        btnNuevoLoteComprobante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/generarfactura.png"))); // NOI18N
        btnNuevoLoteComprobante.setToolTipText("Nuevo Lote de Comprobantes");
        btnNuevoLoteComprobante.setBorderPainted(false);
        btnNuevoLoteComprobante.setContentAreaFilled(false);
        btnNuevoLoteComprobante.setIconTextGap(0);
        btnNuevoLoteComprobante.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnNuevoLoteComprobante.setMaximumSize(new java.awt.Dimension(50, 50));
        btnNuevoLoteComprobante.setMinimumSize(new java.awt.Dimension(50, 50));
        btnNuevoLoteComprobante.setPreferredSize(new java.awt.Dimension(50, 50));
        btnNuevoLoteComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoLoteComprobanteActionPerformed(evt);
            }
        });

        grupoBotones.add(radioLote);
        radioLote.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        radioLote.setSelected(true);
        radioLote.setText("Por Nº Lote");
        radioLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioLoteActionPerformed(evt);
            }
        });

        grupoBotones.add(radioFecha);
        radioFecha.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        radioFecha.setText("Por Fecha de Vencimiento");
        radioFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFechaActionPerformed(evt);
            }
        });

        grupoBotones.add(radioDesc);
        radioDesc.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        radioDesc.setText("Por Descripción");
        radioDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDescActionPerformed(evt);
            }
        });

        grupoBotones.add(radioMes);
        radioMes.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        radioMes.setText("Por Mes");
        radioMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMesActionPerformed(evt);
            }
        });

        grupoBotones.add(radioYear);
        radioYear.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        radioYear.setText("Por Año");
        radioYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioYearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addComponent(labelBuscar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(radioLote)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(radioDesc)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(radioMes)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(radioYear)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(radioFecha)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnNuevoLoteComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(labelBuscar)
                    .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioLote)
                    .addComponent(radioDesc)
                    .addComponent(radioMes)
                    .addComponent(radioYear)
                    .addComponent(radioFecha))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNuevoLoteComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyReleased
        if (radioLote.isSelected()) {
            f.filtrarBusquedaAbstract(campoBuscar.getText().toUpperCase(), tablaLecturas, 0);
        } else if (radioDesc.isSelected()) {
            f.filtrarBusquedaAbstract(campoBuscar.getText().toUpperCase(), tablaLecturas, 1);
        } else if (radioMes.isSelected()) {
            f.filtrarBusquedaAbstract(campoBuscar.getText().toUpperCase(), tablaLecturas, 3);
        } else if (radioYear.isSelected()) {
            f.filtrarBusquedaAbstract(campoBuscar.getText().toUpperCase(), tablaLecturas, 2);
        } else if (radioFecha.isSelected()) {
            f.filtrarBusquedaAbstract(campoBuscar.getText().toUpperCase(), tablaLecturas, 4);
        }
    }//GEN-LAST:event_campoBuscarKeyReleased

    private void btnNuevoLoteComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoLoteComprobanteActionPerformed
        if (dao.Zonas.listaZonas().size() > 0) {
            LoteFactura lf = new LoteFactura();
            Funciones.centrar(lf, conexion.InicioSesion.getUsuario().contains("admin") ? PrincipalAdmin.panelEscritorio : Principal.panelEscritorio);
        } else {
            String[] options = {"Sí", "Más Tarde"};
            int seleccion = javax.swing.JOptionPane.showOptionDialog(
                    null, "No se puede registrar un lote mientras no exista al menos una zona. ¿Registrar ahora?", "Aviso: Registrar una zona",
                    javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (seleccion == 0) {
                Zonas z = new Zonas();
                Funciones.centrar(z, conexion.InicioSesion.getUsuario().contains("admin") ? PrincipalAdmin.panelEscritorio : Principal.panelEscritorio);
                z.btnNuevaZona.doClick();
            }
        }
    }//GEN-LAST:event_btnNuevoLoteComprobanteActionPerformed

    private void tablaLecturasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaLecturasFocusGained
        if (evt.getComponent().getMousePosition() == null) {
            if (tablaLecturas.getSelectedRow() < 0) {
                tablaLecturas.changeSelection(0, 0, false, false);
            }
        }
    }//GEN-LAST:event_tablaLecturasFocusGained

    private void radioFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFechaActionPerformed
        campoBuscar.setText("");
        tablaLecturas.setRowSorter(null);
    }//GEN-LAST:event_radioFechaActionPerformed

    private void radioLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioLoteActionPerformed
        tablaLecturas.setRowSorter(null);
    }//GEN-LAST:event_radioLoteActionPerformed

    private void radioDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDescActionPerformed
        tablaLecturas.setRowSorter(null);
    }//GEN-LAST:event_radioDescActionPerformed

    private void radioMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMesActionPerformed
        tablaLecturas.setRowSorter(null);
    }//GEN-LAST:event_radioMesActionPerformed

    private void radioYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioYearActionPerformed
        tablaLecturas.setRowSorter(null);
    }//GEN-LAST:event_radioYearActionPerformed

    private void acceder() {
        if (tablaLecturas.getRowCount() > 0) {
            LecturasxZonaxUsuarios lzu = new LecturasxZonaxUsuarios((int) (tablaLecturas.getValueAt(tablaLecturas.getSelectedRow(), 0)), (java.util.Date) (tablaLecturas.getValueAt(tablaLecturas.getSelectedRow(), 4)));
            Funciones.centrar(lzu, conexion.InicioSesion.getUsuario().contains("admin") ? PrincipalAdmin.panelEscritorio : Principal.panelEscritorio);
        }
    }

    private Action verDetalle() {
        return new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                acceder();
            }
        };
    }

    private void accesoADetalle() {
        tablaLecturas.getInputMap(javax.swing.JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0), "Enter");
        tablaLecturas.getActionMap().put("Enter", verDetalle());
        tablaLecturas.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    if (tablaLecturas.getSelectedRow() >= 0) {
                        acceder();
                    }
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevoLoteComprobante;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBuscar;
    private javax.swing.JRadioButton radioDesc;
    private javax.swing.JRadioButton radioFecha;
    private javax.swing.JRadioButton radioLote;
    private javax.swing.JRadioButton radioMes;
    private javax.swing.JRadioButton radioYear;
    protected static javax.swing.JTable tablaLecturas;
    // End of variables declaration//GEN-END:variables
}
