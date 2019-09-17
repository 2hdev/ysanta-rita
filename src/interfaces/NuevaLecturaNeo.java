package interfaces;

import clases.tablas.TablaLecturasXZonas;
import modelos.Usuario;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.Position;
import utilidades.Funciones;
import utilidades.Validaciones;

public class NuevaLecturaNeo extends javax.swing.JInternalFrame {
    
    InputMap inputMap;
    ActionMap actionMap;
    int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
    Funciones f;
    modelos.Lectura l, lant;
    dao.Medidor m;
    String[] datos;
    Usuario u;
    utilidades.Calculos calc;
    dao.Comprobante compr;
    private final int idLote;
    private int idZona;
    private Date fechaVenc;
    Integer saldo = 0;
    
    java.util.Date hoy = new java.util.Date();
    
    public NuevaLecturaNeo(int idLote, int idZona) {
        this.idLote = idLote;
        this.idZona = idZona;
        initComponents();
        f = new Funciones();
        m = new dao.Medidor();
        compr = new dao.Comprobante();
        f.agregarPlaceHolder(((javax.swing.JTextField) campoFechaActual.getDateEditor().getUiComponent()), "dd/MM/aaaa");
        campoFechaActual.setDate(hoy);
        labelUltimaFecha.setVisible(false);
        nfactura.setText(dao.Pagos.numeroFactura());
        
    }
    
    public NuevaLecturaNeo(int idLote, Date fechaVenc) {
        this.idLote = idLote;
        this.fechaVenc = fechaVenc;
        initComponents();
        f = new Funciones();
        m = new dao.Medidor();
        compr = new dao.Comprobante();
        f.agregarPlaceHolder(((javax.swing.JTextField) campoFechaActual.getDateEditor().getUiComponent()), "dd/MM/aaaa");
        campoFechaActual.setDate(hoy);
        campoFechaVenc.setDate(fechaVenc);
        labelUltimaFecha.setVisible(false);
        nfactura.setText(dao.Pagos.numeroFactura());
        
        TableColumnModel columnModel = jTableCargos.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(1).setPreferredWidth(170);
        columnModel.getColumn(2).setPreferredWidth(20);
        columnModel.getColumn(3).setPreferredWidth(20);
        
        inputMap = panelContenedor.getInputMap(condition);
        actionMap = panelContenedor.getActionMap();
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0), "AgregarCargos");
        panelContenedor.getActionMap().put("AgregarCargos", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListadeCargosAdicionales();
            }
        });
        inputMap = jTableCargos.getInputMap(condition);
        actionMap = jTableCargos.getActionMap();

        // DELETE is a String constant that for me was defined as "Chupa el perro"
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "DELETE");
        actionMap.put("DELETE", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) jTableCargos.getModel();
                int row = jTableCargos.getSelectedRow();
                model.removeRow(row);
                model.fireTableDataChanged();
            }
        });
        
        DefaultTableModel model = (DefaultTableModel) jTableCargos.getModel();
        jTableCargos.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                int row = jTableCargos.getSelectedRow();
                if (row != -1) {
                    int subtotal = Integer.valueOf(model.getValueAt(row, 0).toString()) * Integer.valueOf(model.getValueAt(row, 2).toString());
                    model.setValueAt(subtotal, row, 3);
                }
            }
        });
        model.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int total_gral = 0;
                int subtotal_lectura = 0;
                int subtotal_cargos = 0;
                int erssan = 0;
                for (int x = 0; x < jTableCargos.getRowCount(); x++) {
                    subtotal_cargos += Integer.valueOf(jTableCargos.getValueAt(x, 3).toString());
                }
                if (!campoTotal.getText().equals("")) {
                    subtotal_lectura = campoTotal.getText().contains(".") ? Integer.valueOf(campoTotal.getText().replaceAll("\\.", "")) : Integer.valueOf(campoTotal.getText());
                }
                if (!campoERSSAN.getText().equals("")) {
                    erssan = campoERSSAN.getText().contains(".") ? Integer.valueOf(campoERSSAN.getText().replaceAll("\\.", "")) : Integer.valueOf(campoERSSAN.getText());
                }
                total_gral = subtotal_lectura + subtotal_cargos;
                total_general.setText(f.formatearNumero(total_gral));
            }
        });
    }
    
    public void ListadeCargosAdicionales() {
        Cargos cargos = new Cargos(NuevaLecturaNeo.this, true);
        cargos.setLocationRelativeTo(conexion.InicioSesion.getUsuario().contains("admin") ? PrincipalAdmin.panelEscritorio : Principal.panelEscritorio);
        
        TableColumnModel columnModel = cargos.jtableCargos.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(20);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(20);
        
        cargos.agregar.addActionListener((ActionEvent e) -> {
            DefaultTableModel model = (DefaultTableModel) cargos.jtableCargos.getModel();
            int row = cargos.jtableCargos.getSelectedRow();
            DefaultTableModel model2 = (DefaultTableModel) jTableCargos.getModel();
            model2.addRow(new Object[]{1, model.getValueAt(row, 1), model.getValueAt(row, 2), model.getValueAt(row, 2)});
        });
        
        condition = JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT;
        inputMap = cargos.jtableCargos.getInputMap(condition);
        actionMap = cargos.jtableCargos.getActionMap();
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "SELECTION");
        actionMap.put("SELECTION", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) cargos.jtableCargos.getModel();
                int row = cargos.jtableCargos.getSelectedRow();
                DefaultTableModel model2 = (DefaultTableModel) jTableCargos.getModel();
                model2.addRow(new Object[]{1, model.getValueAt(row, 1), model.getValueAt(row, 2), model.getValueAt(row, 2)});
            }
        });
        
        cargos.jtableCargos.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) cargos.jtableCargos.getModel();
                    int rowData = cargos.jtableCargos.getSelectedRow();
                    DefaultTableModel model2 = (DefaultTableModel) jTableCargos.getModel();
                    model2.addRow(new Object[]{1, model.getValueAt(rowData, 1), model.getValueAt(rowData, 2), model.getValueAt(rowData, 2)});
                }
            }
        });
        
        cargos.setVisible(true);
    }
    
    @Override
    
    public void dispose() {
        LecturasxZonaxUsuarios.btnAddComprobante.setEnabled(true);
        super.dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        panelGenerales = new javax.swing.JPanel();
        labelFecha = new javax.swing.JLabel();
        labelMedidor = new javax.swing.JLabel();
        comboMedidor = new javax.swing.JComboBox<>();
        labelUsuario = new javax.swing.JLabel();
        campoNumUsuario = new javax.swing.JTextField();
        campoUsuario = new javax.swing.JTextField();
        campoFechaActual = new com.toedter.calendar.JDateChooser();
        labelZona = new javax.swing.JLabel();
        comboZona = new javax.swing.JComboBox<>();
        campoFechaVenc = new com.toedter.calendar.JDateChooser();
        labelFechaVencimiento = new javax.swing.JLabel();
        comboCuenta = new javax.swing.JComboBox<>();
        labelCuenta = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nfactura = new javax.swing.JFormattedTextField();
        panelMedidor = new javax.swing.JPanel();
        labelAnterior = new javax.swing.JLabel();
        campoAnterior = new javax.swing.JTextField();
        labelActual = new javax.swing.JLabel();
        campoActual = new javax.swing.JTextField();
        labelm3Minimo = new javax.swing.JLabel();
        campoM3Minimo = new javax.swing.JTextField();
        campoM3Exc = new javax.swing.JTextField();
        labelM3Excedente = new javax.swing.JLabel();
        labelM3Total = new javax.swing.JLabel();
        campoM3Total = new javax.swing.JTextField();
        panelTotales = new javax.swing.JPanel();
        labelSubtotal = new javax.swing.JLabel();
        campoSubtotal = new javax.swing.JTextField();
        labelIVA10 = new javax.swing.JLabel();
        campoIVA10 = new javax.swing.JTextField();
        campoFAcum = new javax.swing.JTextField();
        labelFAcumulada = new javax.swing.JLabel();
        labelFActual = new javax.swing.JLabel();
        campoFActual = new javax.swing.JTextField();
        campoTotal = new javax.swing.JTextField();
        labelTotal = new javax.swing.JLabel();
        campoERSSAN = new javax.swing.JTextField();
        labelErssan = new javax.swing.JLabel();
        labelUltimaFecha = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCargos = new javax.swing.JTable();
        agregar = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        total_general = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Nueva Lectura");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/y_mini.png"))); // NOI18N

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

        panelGenerales.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Generales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N

        labelFecha.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelFecha.setText("Fecha:");

        labelMedidor.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelMedidor.setText("Nº Medidor:");

        comboMedidor.setEnabled(false);
        comboMedidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMedidorActionPerformed(evt);
            }
        });

        labelUsuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelUsuario.setText("Usuario:");

        campoNumUsuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoNumUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoNumUsuarioKeyPressed(evt);
            }
        });

        campoUsuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoUsuario.setEnabled(false);

        campoFechaActual.setDateFormatString("dd/MM/yyyy");
        campoFechaActual.setMaxSelectableDate(new java.util.Date(32503694508000L));
        campoFechaActual.setMinSelectableDate(new java.util.Date(-2208974960000L));
        campoFechaActual.getDateEditor().getUiComponent().addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if(Validaciones.Letras(evt.getKeyChar()) || Validaciones.Espacio(evt.getKeyChar())) evt.consume();
            }
        });

        labelZona.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelZona.setText("Zona:");

        comboZona.setModel(new javax.swing.DefaultComboBoxModel(dao.Zonas.listaZonas().toArray()));
        comboZona.setEnabled(false);

        campoFechaVenc.setDateFormatString("dd/MM/yyyy");
        campoFechaVenc.setMaxSelectableDate(new java.util.Date(32503694508000L));
        campoFechaVenc.setMinSelectableDate(new java.util.Date(-2208974960000L));
        campoFechaActual.getDateEditor().getUiComponent().addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if(Validaciones.Letras(evt.getKeyChar()) || Validaciones.Espacio(evt.getKeyChar())) evt.consume();
            }
        });

        labelFechaVencimiento.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelFechaVencimiento.setText("Fecha Vencimiento:");

        comboCuenta.setEnabled(false);
        comboCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCuentaActionPerformed(evt);
            }
        });

        labelCuenta.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelCuenta.setText("Cuenta Nº:");

        jLabel1.setText("Factura N°:");

        try {
            nfactura.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        nfactura.setName("campoNfactura"); // NOI18N

        javax.swing.GroupLayout panelGeneralesLayout = new javax.swing.GroupLayout(panelGenerales);
        panelGenerales.setLayout(panelGeneralesLayout);
        panelGeneralesLayout.setHorizontalGroup(
            panelGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMedidor)
                    .addComponent(labelFecha)
                    .addComponent(labelZona)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(panelGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGeneralesLayout.createSequentialGroup()
                        .addGroup(panelGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGeneralesLayout.createSequentialGroup()
                                .addComponent(campoFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
                            .addGroup(panelGeneralesLayout.createSequentialGroup()
                                .addGroup(panelGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboMedidor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboZona, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(32, 32, 32)))
                        .addGroup(panelGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelGeneralesLayout.createSequentialGroup()
                                .addComponent(labelUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoNumUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(labelCuenta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelGeneralesLayout.createSequentialGroup()
                                .addComponent(labelFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(campoFechaVenc, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelGeneralesLayout.createSequentialGroup()
                        .addComponent(nfactura, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelGeneralesLayout.setVerticalGroup(
            panelGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(labelFecha)
                    .addComponent(labelUsuario)
                    .addComponent(campoNumUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCuenta))
                .addGap(19, 19, 19)
                .addGroup(panelGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(labelMedidor)
                    .addComponent(comboMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(panelGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(labelZona)
                    .addComponent(comboZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFechaVencimiento)
                    .addComponent(campoFechaVenc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nfactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelMedidor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Medición", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N

        labelAnterior.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelAnterior.setText("Lectura Anterior:");

        campoAnterior.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoAnterior.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        labelActual.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelActual.setText("Lectura Actual:");

        campoActual.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoActual.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        campoActual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoActualKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoActualKeyTyped(evt);
            }
        });

        labelm3Minimo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelm3Minimo.setText("Mínimo:");

        campoM3Minimo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoM3Minimo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        campoM3Minimo.setEnabled(false);

        campoM3Exc.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoM3Exc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        campoM3Exc.setEnabled(false);

        labelM3Excedente.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelM3Excedente.setText("Excedente:");

        labelM3Total.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelM3Total.setText("Total:");

        campoM3Total.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoM3Total.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        campoM3Total.setEnabled(false);

        javax.swing.GroupLayout panelMedidorLayout = new javax.swing.GroupLayout(panelMedidor);
        panelMedidor.setLayout(panelMedidorLayout);
        panelMedidorLayout.setHorizontalGroup(
            panelMedidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMedidorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelMedidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelAnterior)
                    .addComponent(labelActual)
                    .addComponent(labelm3Minimo)
                    .addComponent(labelM3Excedente)
                    .addComponent(labelM3Total))
                .addGap(18, 18, 18)
                .addGroup(panelMedidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoActual, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoM3Minimo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoM3Exc, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoM3Total, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        panelMedidorLayout.setVerticalGroup(
            panelMedidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMedidorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelMedidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAnterior)
                    .addComponent(campoAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelMedidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelActual)
                    .addComponent(campoActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelMedidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelm3Minimo)
                    .addComponent(campoM3Minimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelMedidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelM3Excedente)
                    .addComponent(campoM3Exc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelMedidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelM3Total)
                    .addComponent(campoM3Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        panelTotales.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Importe a Pagar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N

        labelSubtotal.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelSubtotal.setText("Subtotal:");

        campoSubtotal.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoSubtotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        campoSubtotal.setEnabled(false);

        labelIVA10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelIVA10.setText("I.V.A. 10%:");

        campoIVA10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoIVA10.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        campoIVA10.setEnabled(false);

        campoFAcum.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoFAcum.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        campoFAcum.setEnabled(false);

        labelFAcumulada.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelFAcumulada.setText("Factura Acumulada:");

        labelFActual.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelFActual.setText("Factura Actual:");

        campoFActual.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoFActual.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        campoFActual.setEnabled(false);

        campoTotal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        campoTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        campoTotal.setEnabled(false);

        labelTotal.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelTotal.setText("Total a Pagar:");

        campoERSSAN.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoERSSAN.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        campoERSSAN.setEnabled(false);

        labelErssan.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelErssan.setText("ERSSAN:");

        javax.swing.GroupLayout panelTotalesLayout = new javax.swing.GroupLayout(panelTotales);
        panelTotales.setLayout(panelTotalesLayout);
        panelTotalesLayout.setHorizontalGroup(
            panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTotalesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSubtotal)
                    .addComponent(labelIVA10)
                    .addComponent(labelFAcumulada)
                    .addComponent(labelFActual)
                    .addComponent(labelTotal)
                    .addComponent(labelErssan))
                .addGap(18, 18, 18)
                .addGroup(panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoIVA10, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoFActual, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoFAcum, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoERSSAN, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        panelTotalesLayout.setVerticalGroup(
            panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTotalesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSubtotal)
                    .addComponent(campoSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIVA10)
                    .addComponent(campoIVA10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFActual)
                    .addComponent(campoFActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFAcumulada)
                    .addComponent(campoFAcum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTotal)
                    .addComponent(campoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelErssan)
                    .addComponent(campoERSSAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        labelUltimaFecha.setText("Fecha de Última Lectura: ");
        labelUltimaFecha.setEnabled(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cargos Adicionales"));

        jTableCargos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cantidad", "Concepto", "Monto", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCargos.setFocusable(false);
        jTableCargos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableCargosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCargos);

        agregar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        agregar.setText("Agregar [F10]");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        borrar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        borrar.setText("Borrar [Supr]");
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Total General:");

        total_general.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        total_general.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(agregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(borrar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(total_general)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar)
                    .addComponent(borrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(total_general))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelGenerales, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorLayout.createSequentialGroup()
                        .addComponent(panelMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelTotales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorLayout.createSequentialGroup()
                        .addComponent(labelUltimaFecha)
                        .addGap(101, 101, 101)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addGap(400, 400, 400))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(labelUltimaFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addComponent(panelGenerales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 15, Short.MAX_VALUE)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelMedidor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelTotales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addGap(18, 18, 18))
        );

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

    private void campoActualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoActualKeyTyped
        if (Validaciones.Longitud(campoAnterior, 11)) {
            evt.consume();
        }
        if (!Validaciones.Numeros(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_campoActualKeyTyped

    private void campoActualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoActualKeyPressed
        int total_gral = 0;
        int subtotal_cargos = 0;
        int subtotal_lectura = 0;
        int erssan = 0;
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (Integer.parseInt(campoActual.getText()) < Integer.parseInt(campoAnterior.getText().replace(".", ""))) {
                JOptionPane.showMessageDialog(null, "La lectura ingresada es menor a la lectura anterior.", "Atención", JOptionPane.WARNING_MESSAGE);
                campoActual.requestFocus();
                return;
            } else if (f.compararFechas(campoFechaActual.getDate(), campoFechaVenc.getDate())) {
                JOptionPane.showMessageDialog(null, "La fecha de lectura ingresada es mayor a la fecha de vencimiento.", "Atención", JOptionPane.WARNING_MESSAGE);
                campoFechaVenc.requestFocusInWindow();
                return;
            } else {
                calc = new utilidades.Calculos(Integer.parseInt(campoActual.getText().replace(".", "")), Integer.parseInt(campoAnterior.getText().replace(".", "")));
                campoM3Minimo.setText(f.formatearNumero(calc.getM3Minimo()));
                campoM3Exc.setText(f.formatearNumero(calc.getExcedenteM3()));
                campoM3Total.setText(f.formatearNumero(calc.getTotalM3()));
                campoSubtotal.setText(f.formatearNumero(calc.getTotal()));
                campoIVA10.setText(f.formatearNumero(calc.getIVA()));
                campoFActual.setText(f.formatearNumero(calc.getTotalConIVA()));
                saldo = dao.Comprobante.obtenerSaldo(((modelos.Cuenta) comboCuenta.getSelectedItem()).getIdentificador());
                campoFAcum.setText(f.formatearNumero(saldo));
                campoTotal.setText(f.formatearNumero(calc.getTotalConIVA() + saldo));
                campoERSSAN.setText(f.formatearNumero(calc.getERSSAN()));
                
                if (jTableCargos.getRowCount() != 0) {
                    for (int x = 0; x < jTableCargos.getRowCount(); x++) {
                        subtotal_cargos += (int) jTableCargos.getValueAt(x, 3);
                    }
                }
                if (!campoTotal.getText().equals("")) {
                    subtotal_lectura = campoTotal.getText().contains(".") ? Integer.valueOf(campoTotal.getText().replaceAll("\\.", "")) : Integer.valueOf(campoTotal.getText());
                }
                if (!campoERSSAN.getText().equals("")) {
                    erssan = campoERSSAN.getText().contains(".") ? Integer.valueOf(campoERSSAN.getText().replaceAll("\\.", "")) : Integer.valueOf(campoERSSAN.getText());
                }
                total_gral = subtotal_lectura + subtotal_cargos;
                total_general.setText(f.formatearNumero(total_gral));
            }
        }
    }//GEN-LAST:event_campoActualKeyPressed

    private void comboCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCuentaActionPerformed
        validarCuenta();
    }//GEN-LAST:event_comboCuentaActionPerformed

    private void campoNumUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNumUsuarioKeyPressed
        campoNumUsuario.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, java.util.Collections.EMPTY_SET);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            u = null;
            validarUsuario();
        }
    }//GEN-LAST:event_campoNumUsuarioKeyPressed

    private void comboMedidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMedidorActionPerformed
        if (u != null && comboCuenta.getItemCount() > 0) {
            lant = m.getMedidor(((modelos.Medidor) comboMedidor.getSelectedItem()).getNumeroMedidor());
            campoAnterior.setText(lant.getLectura().toString());
            labelUltimaFecha.setText(String.format("%s %s", "Última Fecha de Lectura:", lant.getFechaLectura() == null ? "DESCONOCIDA" : utilidades.Estaticos.FORMATODMA.format(lant.getFechaLectura())));
            labelUltimaFecha.setVisible(true);
        }
    }//GEN-LAST:event_comboMedidorActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (!f.recorrerYValidar(panelContenedor)) {
            return;
        }
        if (!f.validarDateChooser(campoFechaActual)) {
            campoFechaActual.requestFocusInWindow();
            return;
        }
        if (!f.validarDateChooser(campoFechaVenc)) {
            campoFechaActual.requestFocusInWindow();
            return;
        }
        if (Integer.parseInt(campoActual.getText()) < Integer.parseInt(campoAnterior.getText())) {
            JOptionPane.showMessageDialog(null, "La lectura ingresada es menor a la lectura anterior.", "Atención", JOptionPane.WARNING_MESSAGE);
            campoActual.requestFocus();
            return;
        }
        if (f.compararFechas(lant.getFechaLectura(), campoFechaActual.getDate())) {
            JOptionPane.showMessageDialog(null, "La fecha de lectura ingresada es menor a la fecha de lectura anterior.", "Atención", JOptionPane.WARNING_MESSAGE);
            campoFechaActual.requestFocusInWindow();
            return;
        }
        if (f.compararFechas(campoFechaActual.getDate(), campoFechaVenc.getDate())) {
            JOptionPane.showMessageDialog(null, "La fecha de lectura ingresada es mayor a la fecha de vencimiento.", "Atención", JOptionPane.WARNING_MESSAGE);
            campoFechaVenc.requestFocusInWindow();
            return;
        }
        l = new modelos.Lectura();
        m = new dao.Medidor();
        l.setLectura(Integer.parseInt(campoActual.getText()));
        l.setFechaLectura(campoFechaActual.getDate());
        l.setIdMedidor(((modelos.Medidor) comboMedidor.getSelectedItem()).getIdentificador());
        l.setFechaVencimiento(campoFechaVenc.getDate());
        int idLectura = m.insertarLectura(l);
        if (idLectura > 0) {
            modelos.Comprobante comp = new modelos.Comprobante();
            comp.setFechaActual(campoFechaActual.getDate());
            comp.setFechaAnterior(lant.getFechaLectura() == null ? null : lant.getFechaLectura());
            comp.setFechaVencimiento(l.getFechaVencimiento());
            comp.setIdLectura(idLectura);
            comp.setLecturaAnterior(lant.getLectura() == null ? 0 : lant.getLectura());
            comp.setLecturaActual(Integer.parseInt(campoActual.getText()));
            comp.setM3Minimo(calc.getM3Minimo());
            comp.setM3Excedente(calc.getExcedenteM3());
            comp.setM3Total(calc.getM3Minimo() + calc.getExcedenteM3());
            comp.setImpMinimo(calc.getImporteMinimo());
            comp.setImpExcedente(calc.getExcedente());
            comp.setImpTotal(calc.getTotal());
            comp.setIVA10(calc.getIVA());
            comp.setERSSAN(calc.getERSSAN());
            comp.setIdUsuario(campoNumUsuario.getText());
            comp.setIdLoteFac(idLote);
            comp.setIdZona(((modelos.Zona) comboZona.getSelectedItem()).getIdentificador());
            if (compr.insertarComprobante(comp)) {
                JOptionPane.showMessageDialog(null, "Se registró correctamente.", "Registro con Éxito", JOptionPane.INFORMATION_MESSAGE);
                //                Integer anterior = dao.Comprobante.obtenerSaldoAnteriorALectura(String.valueOf(idLectura));
                //                if (anterior <= 0) {
                //                    Integer afavor = dao.Cuentas.medidorSaldo(l.getIdMedidor());
                //                    if (afavor > 0) {
                dao.Pagos pago = new dao.Pagos();
                String numcomp = compr.obtenerComprobantePorLectura(String.valueOf(idLectura));
                modelos.Pago p = new modelos.Pago();
                p.setFechaPago(campoFechaActual.getDate());
                p.setNumFactura(nfactura.getText());
                Integer elLote = dao.Pagos.getIDLotePago(campoFechaActual.getDate());
                if (elLote == null) {
                    pago.insertarLotePago(new modelos.LotePagos(hoy, "GENERADO AUTOMÁTICAMENTE AL INSERTARSE UN COMPROBANTE INTERNO", "PAGOS CORRESPONDIENTE AL MES",
                            new java.text.SimpleDateFormat("MMMM").format(campoFechaActual.getDate()).toUpperCase(), new java.text.SimpleDateFormat("yyyy").format(campoFechaActual.getDate())));
                    elLote = dao.Pagos.getIDLotePago(campoFechaActual.getDate());
                }
                p.setIdLote(String.valueOf(elLote));
                p.setIdUsuario(campoNumUsuario.getText());
                
                modelos.DetallePago dp = new modelos.DetallePago();
                dp.setCantidad(1);
                dp.setConcepto("CONSUMO DE AGUA");
                dp.setTipoIVA(0);
                dp.setMontoDescuento(0);
                dp.setIdComprobante(numcomp);
                dp.setTipoPago("COMPROBANTES");
                dp.setIdCuenta(((modelos.Cuenta) comboCuenta.getSelectedItem()).getIdentificador());
                dp.setErssan(comp.getERSSAN());
                dp.setSubtotal((comp.getImpTotal() + comp.getIVA10()));
                
                String total_pago = total_general.getText().contains(".") ? total_general.getText().replace(".", "") : total_general.getText();
                p.setTotal(Integer.valueOf(total_pago));
                //                        if (comp.getImpTotal() + comp.getIVA10() <= afavor) {
                //                            dao.Cuentas.actualizarSaldoAFavor(((modelos.Cuenta) comboCuenta.getSelectedItem()).getIdentificador(), (comp.getImpTotal() + comp.getIVA10()), false);
                //                            pago.actualizarComprobante(numcomp, "PENDIENTE");
                //                            dp.setSubtotal((comp.getImpTotal() + comp.getIVA10()));
                //                            p.setTotal((comp.getImpTotal() + comp.getIVA10()));
                //                        } else {
                //                            dao.Cuentas.actualizarSaldoAFavor(((modelos.Cuenta) comboCuenta.getSelectedItem()).getIdentificador(), afavor, false);
                //                            pago.actualizarComprobante(numcomp, "PARCIALMENTE PAGADO");
                //                            dp.setSubtotal(afavor);
                //                            p.setTotal(afavor);
                //                        }
                //                        if (pago.insertarPagoMulti(p, dp)) {
                //                            modelos.ComprobanteInterno ci = new modelos.ComprobanteInterno();
                //                            ci.setNomApe(campoUsuario.getText());
                //                            ci.setNumComprobante(numcomp);
                //                            ci.setEstadoComprobante(dao.Comprobante.obtenerEstado(numcomp));
                //                            ci.setNumMedidor(((modelos.Medidor) comboMedidor.getSelectedItem()).getNumeroMedidor());
                //                            ci.setNumcuenta(((modelos.Cuenta) comboCuenta.getSelectedItem()).getIdentificador().toString());
                //                            ci.setSaldoActual(afavor - (comp.getImpTotal() + comp.getIVA10()) >= 0 ? afavor - (comp.getImpTotal() + comp.getIVA10()) : 0);
                //                            ci.setSaldoAnterior(afavor);
                //
                //                            new reportes.Informes().mostrarComprobanteInterno(ci);
                //                        }
                //                    }
                //                }

                //                String[] options = {"Sí", "Más Tarde"};
                //                int seleccion = javax.swing.JOptionPane.showOptionDialog(
                //                null, "El comprobante ha sido generado. ¿Desea obtener una vista previa?", "Comprobante Generado",
                //                        javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                //                if(seleccion == 0){
                //                    reportes.Comprobante c = new reportes.Comprobante();
                //                    c.abrirComprobante(String.valueOf(idLectura), this);
                //                }
                ArrayList<modelos.DetallePago> cargos = new ArrayList<>();
                for (int x = 0; x < jTableCargos.getRowCount(); x++) {
                    modelos.DetallePago detalle = new modelos.DetallePago();
                    detalle.setCantidad(Integer.valueOf(jTableCargos.getValueAt(x, 0).toString()));
                    detalle.setConcepto(jTableCargos.getValueAt(x, 1).toString());
                    detalle.setSubtotal(Integer.valueOf(jTableCargos.getValueAt(x, 3).toString()));
                    cargos.add(detalle);
                }
                pago.insertarPagoxDetallexCargos(p, dp, cargos);
            }
            
            JOptionPane.showMessageDialog(null, "Se registró correctamente.", "Registro con Éxito", JOptionPane.INFORMATION_MESSAGE);
            f.limpiarCampos(panelContenedor);
            LecturasxZonaxUsuarios.arbolZonas.setModel(new clases.arboles.ArbolComprobantesxZonas().ArbolComprobantesxZonas(idLote));
            
            javax.swing.tree.TreePath pathToLeaf = LecturasxZonaxUsuarios.arbolZonas.getNextMatch(((modelos.Zona) comboZona.getSelectedItem()).getIdentificador().toString(), 0, Position.Bias.Forward);
            LecturasxZonaxUsuarios.arbolZonas.setSelectionPath(pathToLeaf);
            LecturasxZonaxUsuarios.arbolZonas.scrollPathToVisible(pathToLeaf);
            
            ((TablaLecturasXZonas) LecturasxZonaxUsuarios.tablaDetalle.getModel()).setLecturasXZonas(dao.Zonas.listaComprobantesxZona(idLote, ((modelos.Zona) comboZona.getSelectedItem()).getIdentificador()));
            
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "No se ha podido registrar los datos.", "Ocurrió un error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        ListadeCargosAdicionales();
    }//GEN-LAST:event_agregarActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTableCargos.getModel();
        if (jTableCargos.getRowCount() > 0) {
            int row = jTableCargos.getSelectedRow();
            model.removeRow(row);
        } else {
            model.getDataVector().removeAllElements();
        }
    }//GEN-LAST:event_borrarActionPerformed

    private void jTableCargosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableCargosKeyPressed

    }//GEN-LAST:event_jTableCargosKeyPressed
    
    private void validarUsuario() {
        if (campoNumUsuario.getText().isEmpty()) {
            campoUsuario.requestFocus();
        } else {
            u = new dao.Usuarios().obtenerUsuarioPorId(Integer.parseInt(campoNumUsuario.getText()));
            if (u == null) {
                JOptionPane.showMessageDialog(null, "El código de usuario no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                campoUsuario.setText("");
                campoNumUsuario.requestFocus();
                comboMedidor.removeAllItems();
                f.limpiarCampos(panelMedidor);
                f.limpiarCampos(panelTotales);
                comboMedidor.setEnabled(false);
                comboZona.setEnabled(false);
                labelUltimaFecha.setVisible(false);
                return;
            } else {
                f.limpiarCampos(panelMedidor);
                f.limpiarCampos(panelTotales);
                campoUsuario.setText(String.format("%s %s", u.getNombre(), u.getApellido()));
                List<modelos.Cuenta> mod = dao.Cuentas.obtenerCuentasDeUsuario(Integer.parseInt(campoNumUsuario.getText()));
                if (mod.size() < 1) {
                    JOptionPane.showMessageDialog(null, "El usuario no tiene asignada ninguna cuenta.", "Atención", JOptionPane.WARNING_MESSAGE);
                    comboCuenta.removeAllItems();
                    comboMedidor.removeAllItems();
                    comboCuenta.setEnabled(false);
                    comboMedidor.setEnabled(false);
                    comboZona.setEnabled(false);
                    campoUsuario.requestFocus();
                    campoUsuario.setText("");
                    labelUltimaFecha.setVisible(false);
                    return;
                } else {
                    comboCuenta.setModel(new javax.swing.DefaultComboBoxModel(mod.toArray()));
                    comboCuenta.requestFocus();
                    comboCuenta.setEnabled(true);
                    validarCuenta();
                }
            }
        }
    }
    
    private void validarCuenta() {
        if (comboCuenta.getItemCount() > 0) {
            List<modelos.Medidor> mod = dao.Medidor.medidoresAsignados(((modelos.Cuenta) comboCuenta.getSelectedItem()).getIdentificador());
            if (mod.size() < 1) {
                JOptionPane.showMessageDialog(null, "Ningún medidor fue asignado a la cuenta.", "Atención", JOptionPane.WARNING_MESSAGE);
                campoUsuario.requestFocus();
                campoUsuario.setText("");
                labelUltimaFecha.setVisible(false);
                return;
            } else {
                comboMedidor.setModel(new javax.swing.DefaultComboBoxModel(mod.toArray()));
                comboMedidor.requestFocus();
                lant = m.getMedidor(((modelos.Medidor) comboMedidor.getSelectedItem()).getNumeroMedidor());
                campoAnterior.setText(lant.getLectura().toString());
                labelUltimaFecha.setText(String.format("%s %s", "Última Fecha de Lectura:", lant.getFechaLectura() == null ? "DESCONOCIDA" : utilidades.Estaticos.FORMATODMA.format(lant.getFechaLectura())));
                labelUltimaFecha.setVisible(true);
                comboMedidor.setEnabled(true);
                comboZona.setEnabled(true);
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JButton borrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JTextField campoActual;
    private javax.swing.JTextField campoAnterior;
    private javax.swing.JTextField campoERSSAN;
    private javax.swing.JTextField campoFActual;
    private javax.swing.JTextField campoFAcum;
    private com.toedter.calendar.JDateChooser campoFechaActual;
    private com.toedter.calendar.JDateChooser campoFechaVenc;
    private javax.swing.JTextField campoIVA10;
    private javax.swing.JTextField campoM3Exc;
    private javax.swing.JTextField campoM3Minimo;
    private javax.swing.JTextField campoM3Total;
    private javax.swing.JTextField campoNumUsuario;
    private javax.swing.JTextField campoSubtotal;
    private javax.swing.JTextField campoTotal;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JComboBox<modelos.Cuenta> comboCuenta;
    private javax.swing.JComboBox<String> comboMedidor;
    private javax.swing.JComboBox<String> comboZona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCargos;
    private javax.swing.JLabel labelActual;
    private javax.swing.JLabel labelAnterior;
    private javax.swing.JLabel labelCuenta;
    private javax.swing.JLabel labelErssan;
    private javax.swing.JLabel labelFActual;
    private javax.swing.JLabel labelFAcumulada;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelFechaVencimiento;
    private javax.swing.JLabel labelIVA10;
    private javax.swing.JLabel labelM3Excedente;
    private javax.swing.JLabel labelM3Total;
    private javax.swing.JLabel labelMedidor;
    private javax.swing.JLabel labelSubtotal;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelUltimaFecha;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JLabel labelZona;
    private javax.swing.JLabel labelm3Minimo;
    private javax.swing.JFormattedTextField nfactura;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelGenerales;
    private javax.swing.JPanel panelMedidor;
    private javax.swing.JPanel panelTotales;
    private javax.swing.JLabel total_general;
    // End of variables declaration//GEN-END:variables
}
