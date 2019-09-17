package interfaces;

import java.awt.event.MouseListener;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import utilidades.Funciones;
import utilidades.Validaciones;

public class VistaInformes extends javax.swing.JInternalFrame {

    reportes.Informes inf = new reportes.Informes();
    workers.WorkerInformes task;
    Funciones f = new Funciones();
    Date hoy = new Date();

    public VistaInformes() {
        initComponents();
        BasicInternalFrameUI UI = ((javax.swing.plaf.basic.BasicInternalFrameUI) VistaInformes.this.getUI()); //para no mover jinternalframe
        for (MouseListener listener : UI.getNorthPane().getMouseListeners()) {
            UI.getNorthPane().removeMouseListener(listener);
        }
        expandAll(arbolMenu, true);
        f.agregarPlaceHolder(((javax.swing.JTextField) desde.getDateEditor().getUiComponent()), "Desde: (dd/MM/aaaa)");
        f.agregarPlaceHolder(((javax.swing.JTextField) hasta.getDateEditor().getUiComponent()), "Hasta: (dd/MM/aaaa)");
        f.agregarPlaceHolder(numLote, "Ingrese un valor numérico mayor a cero.");
        desde.setDate(hoy);
        hasta.setDate(hoy);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        arbolMenu = new javax.swing.JTree(){
            protected void setExpandedState(TreePath path, boolean state) {
                //para no colapsar los nodos
                if (state) {
                    super.setExpandedState(path, state);
                }
            }
        };
        panelFiltros = new javax.swing.JPanel();
        verInforme = new javax.swing.JButton();
        introContenedor = new javax.swing.JPanel();
        panelLote = new javax.swing.JPanel();
        labelLote = new javax.swing.JLabel();
        numLote = new javax.swing.JTextField();
        panelFechas = new javax.swing.JPanel();
        labelDesde1 = new javax.swing.JLabel();
        desde = new com.toedter.calendar.JDateChooser();
        labelHasta = new javax.swing.JLabel();
        hasta = new com.toedter.calendar.JDateChooser();
        panelZona = new javax.swing.JPanel();
        labelZona = new javax.swing.JLabel();
        comboZona = new javax.swing.JComboBox<>();
        panelLoteTipo = new javax.swing.JPanel();
        labelLoteP = new javax.swing.JLabel();
        numLoteP = new javax.swing.JTextField();
        labelTipoPago = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<>();
        panelCarga = new javax.swing.JPanel();
        barraCarga = new javax.swing.JProgressBar();
        btnDetener = new javax.swing.JButton();
        panelVisor = new javax.swing.JPanel();

        setClosable(true);
        setTitle("Informes");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/y_mini.png"))); // NOI18N

        arbolMenu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Listados:");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Pagos");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Resumen de Pagos por Mes");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        arbolMenu.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        arbolMenu.setRootVisible(false);
        arbolMenu.setRowHeight(20);
        arbolMenu.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                arbolMenuValueChanged(evt);
            }
        });
        arbolMenu.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        jScrollPane1.setViewportView(arbolMenu);

        panelFiltros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12))); // NOI18N
        panelFiltros.setVisible(false);
        panelFiltros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        verInforme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ver.png"))); // NOI18N
        verInforme.setToolTipText("Ver Informe");
        verInforme.setBorderPainted(false);
        verInforme.setContentAreaFilled(false);
        verInforme.setIconTextGap(0);
        verInforme.setMargin(new java.awt.Insets(0, 0, 0, 0));
        verInforme.setMaximumSize(new java.awt.Dimension(50, 50));
        verInforme.setMinimumSize(new java.awt.Dimension(50, 50));
        verInforme.setPreferredSize(new java.awt.Dimension(50, 50));
        verInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verInformeActionPerformed(evt);
            }
        });
        panelFiltros.add(verInforme, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, -1, -1));

        introContenedor.setLayout(new java.awt.CardLayout());

        panelLote.setName("panellote"); // NOI18N

        labelLote.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelLote.setText("Lote Nº:");

        numLote.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        numLote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numLoteKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelLoteLayout = new javax.swing.GroupLayout(panelLote);
        panelLote.setLayout(panelLoteLayout);
        panelLoteLayout.setHorizontalGroup(
            panelLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLote)
                .addGap(18, 18, 18)
                .addComponent(numLote, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelLoteLayout.setVerticalGroup(
            panelLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoteLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLote)
                    .addComponent(numLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(143, Short.MAX_VALUE))
        );

        introContenedor.add(panelLote, "card2");

        panelFechas.setName("panelfechas"); // NOI18N

        labelDesde1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelDesde1.setText("Desde:");

        desde.setDateFormatString("dd/MM/yyyy");
        desde.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        desde.setMaxSelectableDate(new java.util.Date(32503694508000L));
        desde.setMinSelectableDate(new java.util.Date(-2208974960000L));
        desde.getDateEditor().getUiComponent().addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if(Validaciones.Letras(evt.getKeyChar()) || Validaciones.Espacio(evt.getKeyChar())) evt.consume();
            }
        });

        labelHasta.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelHasta.setText("Hasta:");

        hasta.setDateFormatString("dd/MM/yyyy");
        hasta.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        hasta.setMaxSelectableDate(new java.util.Date(32503694508000L));
        hasta.setMinSelectableDate(new java.util.Date(-2208974960000L));
        hasta.getDateEditor().getUiComponent().addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if(Validaciones.Letras(evt.getKeyChar()) || Validaciones.Espacio(evt.getKeyChar())) evt.consume();
            }
        });

        javax.swing.GroupLayout panelFechasLayout = new javax.swing.GroupLayout(panelFechas);
        panelFechas.setLayout(panelFechasLayout);
        panelFechasLayout.setHorizontalGroup(
            panelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFechasLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFechasLayout.createSequentialGroup()
                        .addComponent(labelHasta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hasta, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelFechasLayout.createSequentialGroup()
                        .addComponent(labelDesde1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(desde, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelFechasLayout.setVerticalGroup(
            panelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFechasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(labelDesde1)
                    .addComponent(desde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelHasta)
                    .addComponent(hasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        introContenedor.add(panelFechas, "card3");

        panelZona.setName("panellote"); // NOI18N

        labelZona.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelZona.setText("Zona:");

        comboZona.setModel(new javax.swing.DefaultComboBoxModel(dao.Zonas.listaZonas().toArray()));

        javax.swing.GroupLayout panelZonaLayout = new javax.swing.GroupLayout(panelZona);
        panelZona.setLayout(panelZonaLayout);
        panelZonaLayout.setHorizontalGroup(
            panelZonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelZonaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelZonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelZona)
                    .addComponent(comboZona, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelZonaLayout.setVerticalGroup(
            panelZonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelZonaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(labelZona)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        introContenedor.add(panelZona, "card2");

        panelLoteTipo.setName("panellote"); // NOI18N

        labelLoteP.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelLoteP.setText("Lote Nº:");

        numLoteP.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        numLoteP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numLotePKeyTyped(evt);
            }
        });

        labelTipoPago.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelTipoPago.setText("Concepto:");

        comboTipo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "CONSUMO", "DERECHO DE CONEXIÓN", "ADELANTADO", "OTROS" }));

        javax.swing.GroupLayout panelLoteTipoLayout = new javax.swing.GroupLayout(panelLoteTipo);
        panelLoteTipo.setLayout(panelLoteTipoLayout);
        panelLoteTipoLayout.setHorizontalGroup(
            panelLoteTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoteTipoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLoteTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelLoteTipoLayout.createSequentialGroup()
                        .addComponent(labelLoteP)
                        .addGap(18, 18, 18)
                        .addComponent(numLoteP, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLoteTipoLayout.createSequentialGroup()
                        .addComponent(labelTipoPago)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboTipo, 0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelLoteTipoLayout.setVerticalGroup(
            panelLoteTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoteTipoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelLoteTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLoteP)
                    .addComponent(numLoteP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLoteTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTipoPago)
                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        introContenedor.add(panelLoteTipo, "card2");

        panelFiltros.add(introContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 200, 190));

        btnDetener.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        btnDetener.setForeground(new java.awt.Color(204, 0, 0));
        btnDetener.setText("x");
        btnDetener.setToolTipText("Detener");
        btnDetener.setBorderPainted(false);
        btnDetener.setContentAreaFilled(false);
        btnDetener.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDetener.setIconTextGap(0);
        btnDetener.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnDetener.setPreferredSize(new java.awt.Dimension(17, 20));
        btnDetener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetenerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCargaLayout = new javax.swing.GroupLayout(panelCarga);
        panelCarga.setLayout(panelCargaLayout);
        panelCargaLayout.setHorizontalGroup(
            panelCargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCargaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnDetener, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barraCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        panelCargaLayout.setVerticalGroup(
            panelCargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCargaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(barraCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDetener, javax.swing.GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelFiltros.add(panelCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 160, 70));
        panelCarga.setVisible(false);

        panelVisor.setLayout(new javax.swing.BoxLayout(panelVisor, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelFiltros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelVisor, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelVisor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelFiltros, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void verInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verInformeActionPerformed
        DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) arbolMenu.getLastSelectedPathComponent();
        if (nodo == null) {
            return;
        }
        verInforme.setEnabled(false);
        panelCarga.setVisible(true);
        switch (nodo.toString()) {
            case "Pagos por Fecha":
                if (!f.validarDateChooser(desde)) {
                    desde.requestFocusInWindow();
                    verInforme.setEnabled(true);
                    panelCarga.setVisible(false);
                    return;
                }
                if (!f.validarDateChooser(hasta)) {
                    hasta.requestFocusInWindow();
                    verInforme.setEnabled(true);
                    panelCarga.setVisible(false);
                    return;
                }
                if (f.compararFechas(desde.getDate(), hasta.getDate())) {
                    JOptionPane.showMessageDialog(null, "La fecha de fin es menor a la fecha de inicio.", "Atención", JOptionPane.WARNING_MESSAGE);
                    hasta.requestFocusInWindow();
                    verInforme.setEnabled(true);
                    panelCarga.setVisible(false);
                    return;
                }
                Map<String, Date> mapa = new HashMap<>();
                mapa.put("desde", desde.getDate());
                mapa.put("hasta", hasta.getDate());
                task = new workers.WorkerInformes(panelVisor, panelCarga, barraCarga, workers.WorkerInformes.worker.PAGOS_ERSSAN, verInforme, mapa);
                arbolMenu.setEnabled(false);
                task.execute();
                arbolMenu.setEnabled(true);
                break;
            case "Pagos por Lote":
                if (Validaciones.CampoVacio(numLoteP.getText())) {
                    numLoteP.requestFocus();
                    verInforme.setEnabled(true);
                    panelCarga.setVisible(false);
                    return;
                }
                modelos.LotePagos lotePago = dao.Pagos.obtenerLotePago(numLoteP.getText());
                if (lotePago != null) {
                    Map mapaLote = new HashMap<>();
                    mapaLote.put("numLote", numLoteP.getText());
                    mapaLote.put("fechaLote", lotePago.getFechaLote());
                    mapaLote.put("mes", lotePago.getMes());
                    mapaLote.put("year", lotePago.getAnho());
                    mapaLote.put("tipo", comboTipo.getSelectedItem().toString());
                    task = new workers.WorkerInformes(panelVisor, panelCarga, barraCarga, workers.WorkerInformes.worker.PAGOS, verInforme, mapaLote);
                    arbolMenu.setEnabled(false);
                    task.execute();
                    arbolMenu.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(null, "No existe el número de lote ingresado.", "Lote inexistente", JOptionPane.WARNING_MESSAGE);
                    verInforme.setEnabled(true);
                    panelCarga.setVisible(false);
                }
                break;
            case "Resumen de Pagos por Mes":
                if (Validaciones.CampoVacio(numLote.getText())) {
                    numLote.requestFocus();
                    verInforme.setEnabled(true);
                    panelCarga.setVisible(false);
                    return;
                }
                lotePago = dao.Pagos.obtenerLotePago(numLote.getText());
                if (lotePago != null) {
                    Map mapaLote = new HashMap<>();
                    mapaLote.put("numLote", numLote.getText());
                    mapaLote.put("mes", Funciones.ConvertirMesaNumero(lotePago.getMes()));
                    mapaLote.put("anho", Integer.valueOf(lotePago.getAnho()));
                    task = new workers.WorkerInformes(panelVisor, panelCarga, barraCarga, workers.WorkerInformes.worker.RESUMEN, verInforme, mapaLote);
                    arbolMenu.setEnabled(false);
                    task.execute();
                    arbolMenu.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(null, "No existe el número de lote ingresado.", "Lote inexistente", JOptionPane.WARNING_MESSAGE);
                    verInforme.setEnabled(true);
                    panelCarga.setVisible(false);
                }
                break;
            case "Todos los Usuarios":
                task = new workers.WorkerInformes(panelVisor, panelCarga, barraCarga, workers.WorkerInformes.worker.USUARIOS, verInforme);
                arbolMenu.setEnabled(false);
                task.execute();
                arbolMenu.setEnabled(true);
                break;
            case "Usuarios por Zona":
                Map mapaUZ = new HashMap<>();
                mapaUZ.put("idZona", ((modelos.Zona) comboZona.getSelectedItem()).getIdentificador());
                mapaUZ.put("zona", ((modelos.Zona) comboZona.getSelectedItem()).getZona());
                task = new workers.WorkerInformes(panelVisor, panelCarga, barraCarga, workers.WorkerInformes.worker.USUARIOS_ZONA, verInforme, mapaUZ);
                arbolMenu.setEnabled(false);
                task.execute();
                arbolMenu.setEnabled(true);
                break;
            case "Todos":
                task = new workers.WorkerInformes(panelVisor, panelCarga, barraCarga, workers.WorkerInformes.worker.MOROSOS_DC, verInforme);
                arbolMenu.setEnabled(false);
                task.execute();
                arbolMenu.setEnabled(true);
                break;
            case "Por Zona":
                Map mapaUMZ = new HashMap<>();
                mapaUMZ.put("idZona", ((modelos.Zona) comboZona.getSelectedItem()).getIdentificador());
                mapaUMZ.put("zona", ((modelos.Zona) comboZona.getSelectedItem()).getZona());
                task = new workers.WorkerInformes(panelVisor, panelCarga, barraCarga, workers.WorkerInformes.worker.MOROSOS_DC_ZONA, verInforme, mapaUMZ);
                arbolMenu.setEnabled(false);
                task.execute();
                arbolMenu.setEnabled(true);
                break;
        }
    }//GEN-LAST:event_verInformeActionPerformed

    private void arbolMenuValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_arbolMenuValueChanged
        DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) arbolMenu.getLastSelectedPathComponent();
        if (nodo == null) {
            return;
        }
        panelFiltros.setVisible(nodo.getLevel() == 1 ? false : (nodo.getLevel() == 2));
        switch (nodo.toString()) {
            case "Pagos por Fecha":
                removerDePanel();
                actualizarPanel(panelFechas);
                break;
            case "Pagos por Lote":
                removerDePanel();
                actualizarPanel(panelLoteTipo);
                break;
            case "Resumen de Pagos por Mes":
                removerDePanel();
                actualizarPanel(panelLote);
                break;
            case "Todos los Usuarios":
                removerDePanel();
                break;
            case "Usuarios por Zona":
                removerDePanel();
                actualizarPanel(panelZona);
                break;
            case "Todos":
                removerDePanel();
                break;
            case "Por Zona":
                removerDePanel();
                actualizarPanel(panelZona);
        }
    }//GEN-LAST:event_arbolMenuValueChanged

    void actualizarPanel(javax.swing.JPanel actual) {
        introContenedor.add(actual);
        introContenedor.repaint();
        introContenedor.validate();
    }

    void removerDePanel() {
        introContenedor.remove(panelLote);
        introContenedor.remove(panelLoteTipo);
        introContenedor.remove(panelFechas);
        introContenedor.remove(panelZona);
    }

    private void numLoteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numLoteKeyTyped
        if (!Validaciones.Numeros(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_numLoteKeyTyped

    private void btnDetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetenerActionPerformed
        task.cancel(true);
        panelCarga.setVisible(false);
        verInforme.setEnabled(true);
    }//GEN-LAST:event_btnDetenerActionPerformed

    private void numLotePKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numLotePKeyTyped
        if (!Validaciones.Numeros(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_numLotePKeyTyped

    private void expandAll(JTree tree, boolean expand) {
        TreeNode root = (TreeNode) tree.getModel().getRoot();
        expandAll(tree, new TreePath(root), expand);
    }

    private void expandAll(JTree tree, TreePath parent, boolean expand) {
        // Traverse children
        TreeNode node = (TreeNode) parent.getLastPathComponent();
        if (node.getChildCount() >= 0) {
            for (Enumeration e = node.children(); e.hasMoreElements();) {
                TreeNode n = (TreeNode) e.nextElement();
                TreePath path = parent.pathByAddingChild(n);
                expandAll(tree, path, expand);
            }
        }
        // Expansion or collapse must be done bottom-up
        if (expand) {
            tree.expandPath(parent);
        } else {
            tree.collapsePath(parent);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arbolMenu;
    private javax.swing.JProgressBar barraCarga;
    private javax.swing.JButton btnDetener;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JComboBox<modelos.Zona> comboZona;
    protected static com.toedter.calendar.JDateChooser desde;
    protected static com.toedter.calendar.JDateChooser hasta;
    private javax.swing.JPanel introContenedor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDesde1;
    private javax.swing.JLabel labelHasta;
    private javax.swing.JLabel labelLote;
    private javax.swing.JLabel labelLoteP;
    private javax.swing.JLabel labelTipoPago;
    private javax.swing.JLabel labelZona;
    protected static javax.swing.JTextField numLote;
    protected static javax.swing.JTextField numLoteP;
    private javax.swing.JPanel panelCarga;
    private javax.swing.JPanel panelFechas;
    private javax.swing.JPanel panelFiltros;
    private javax.swing.JPanel panelLote;
    private javax.swing.JPanel panelLoteTipo;
    private javax.swing.JPanel panelVisor;
    private javax.swing.JPanel panelZona;
    protected static javax.swing.JButton verInforme;
    // End of variables declaration//GEN-END:variables
}
