package interfaces;

import java.awt.event.KeyEvent;
import modelos.Usuario;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utilidades.Funciones;
import utilidades.Validaciones;

public class EditarLectura extends javax.swing.JInternalFrame {
    
    Funciones f;
    modelos.Lectura l, lant;
    dao.Medidor m;
    Usuario u;
    utilidades.Calculos calc;
    dao.Comprobante compr;
    Integer saldo = 0;
    ArrayList<String> comprobante;
    modelos.Comprobante cant = new modelos.Comprobante();
    Integer idLote;
    
    java.util.Date hoy = new java.util.Date();
    
    public EditarLectura(modelos.Lectura l){
        this.l = l;
        initComponents();
        f = new Funciones();
        m = new dao.Medidor();
        compr = new dao.Comprobante();
        comprobante = compr.obtenerComprobante(l.getIdentificador().toString());
        f.agregarPlaceHolder(((javax.swing.JTextField)campoFechaActual.getDateEditor().getUiComponent()), "dd/MM/aaaa");
        completarCampos();
    }

    @Override
    public void dispose() {
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
        comboMedidor = new javax.swing.JComboBox();
        labelUsuario = new javax.swing.JLabel();
        campoNumUsuario = new javax.swing.JTextField();
        campoUsuario = new javax.swing.JTextField();
        campoFechaActual = new com.toedter.calendar.JDateChooser();
        labelZona = new javax.swing.JLabel();
        comboZona = new javax.swing.JComboBox();
        campoFechaVenc = new com.toedter.calendar.JDateChooser();
        labelFechaVencimiento = new javax.swing.JLabel();
        labelCuenta = new javax.swing.JLabel();
        comboCuenta = new javax.swing.JComboBox();
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

        setClosable(true);
        setTitle("Editar Lectura");
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

        labelUsuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelUsuario.setText("Usuario:");

        campoNumUsuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoNumUsuario.setEnabled(false);

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

        labelCuenta.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelCuenta.setText("Cuenta Nº:");

        comboCuenta.setEnabled(false);

        javax.swing.GroupLayout panelGeneralesLayout = new javax.swing.GroupLayout(panelGenerales);
        panelGenerales.setLayout(panelGeneralesLayout);
        panelGeneralesLayout.setHorizontalGroup(
            panelGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMedidor)
                    .addComponent(labelFecha)
                    .addComponent(labelZona))
                .addGap(18, 18, 18)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoNumUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(labelCuenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelGeneralesLayout.createSequentialGroup()
                        .addComponent(labelFechaVencimiento)
                        .addGap(18, 18, 18)
                        .addComponent(campoFechaVenc, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap())
        );

        panelMedidor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Medición", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N

        labelAnterior.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelAnterior.setText("Lectura Anterior:");

        campoAnterior.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoAnterior.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        campoAnterior.setEnabled(false);
        campoAnterior.setFocusable(false);

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

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorLayout.createSequentialGroup()
                .addGap(424, 424, 424)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addGap(34, 34, 34))
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelGenerales, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addComponent(panelMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelTotales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(panelGenerales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelMedidor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTotales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addGap(30, 30, 30))
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
            .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(!f.recorrerYValidar(panelContenedor)) return;
        if(!f.validarDateChooser(campoFechaActual)) {campoFechaActual.requestFocusInWindow(); return;}
        if(!f.validarDateChooser(campoFechaVenc)) {campoFechaActual.requestFocusInWindow(); return;}
        if(Integer.parseInt(campoActual.getText())<Integer.parseInt(campoAnterior.getText())){
            JOptionPane.showMessageDialog(null, "La lectura ingresada es menor a la lectura anterior.", "Atención", JOptionPane.WARNING_MESSAGE);
            campoActual.requestFocus();
            return;
        }
        if(f.compararFechas(lant.getFechaLectura(), campoFechaActual.getDate())){
            JOptionPane.showMessageDialog(null, "La fecha de lectura ingresada es menor a la fecha de lectura anterior.", "Atención", JOptionPane.WARNING_MESSAGE);
            campoFechaActual.requestFocusInWindow(); 
            return;
        }
        if(f.compararFechas(campoFechaActual.getDate(), campoFechaVenc.getDate())){
            JOptionPane.showMessageDialog(null, "La fecha de lectura ingresada es mayor a la fecha de vencimiento.", "Atención", JOptionPane.WARNING_MESSAGE);
            campoFechaVenc.requestFocusInWindow(); 
            return;
        }
        m = new dao.Medidor();
        l.setLectura(Integer.parseInt(campoActual.getText()));
        l.setFechaLectura(campoFechaActual.getDate());
        l.setIdMedidor(((modelos.Medidor)comboMedidor.getSelectedItem()).getIdentificador());
        l.setFechaVencimiento(campoFechaVenc.getDate());
        if(m.actualizarLectura(l)){
            modelos.Comprobante comp = new modelos.Comprobante();
            comp.setIdComprobante(Integer.parseInt(comprobante.get(13)));
            comp.setFechaActual(campoFechaActual.getDate());
            comp.setFechaAnterior(lant.getFechaLectura()==null?null:lant.getFechaLectura());
            comp.setFechaVencimiento(l.getFechaVencimiento());
            comp.setIdLectura(l.getIdentificador());
            comp.setLecturaAnterior(lant.getLectura()==null?0:lant.getLectura());
            comp.setLecturaActual(Integer.parseInt(campoActual.getText()));
            comp.setM3Minimo(calc.getM3Minimo());
            comp.setM3Excedente(calc.getExcedenteM3());
            comp.setM3Total(calc.getTotalM3());
            comp.setImpMinimo(calc.getImporteMinimo());
            comp.setImpExcedente(calc.getExcedente());
            comp.setImpTotal(calc.getTotal());
            comp.setIVA10(calc.getIVA());
            comp.setERSSAN(calc.getERSSAN());
            comp.setIdUsuario(campoNumUsuario.getText());
            comp.setIdLoteFac(idLote);
            comp.setIdZona(((modelos.Zona)comboZona.getSelectedItem()).getIdentificador());
            if(compr.actualizarComprobante(cant, comp, comboCuenta.getSelectedItem().toString())){
                dao.Pagos pago = new dao.Pagos();
                String numcomp = comp.getIdComprobante().toString();
                Integer afavor = dao.Cuentas.medidorSaldo(l.getIdMedidor());
                utilidades.Funciones.eliminarArchivo("/impresiones/ci", numcomp);
                if(afavor > 0){
                    modelos.Pago p = new modelos.Pago();
                    p.setFechaPago(campoFechaActual.getDate());
                    p.setNumFactura(dao.Pagos.numeroComprobanteInterno());
                    Integer elLote = dao.Pagos.getIDLotePago(campoFechaActual.getDate());
                    if(elLote == null){
                        pago.insertarLotePago(new modelos.LotePagos(hoy, "GENERADO AUTOMÁTICAMENTE AL INSERTARSE UN COMPROBANTE INTERNO", "PAGOS CORRESPONDIENTE AL MES",
                        new java.text.SimpleDateFormat("MMMM").format(campoFechaActual.getDate()).toUpperCase(),
                                new java.text.SimpleDateFormat("yyyy").format(campoFechaActual.getDate())));
                        elLote = dao.Pagos.getIDLotePago(campoFechaActual.getDate());
                    }
                    p.setIdLote(String.valueOf(elLote));
                    p.setIdUsuario(campoNumUsuario.getText());

                    modelos.DetallePago dp = new modelos.DetallePago();
                    dp.setCantidad(1);
                    dp.setConcepto("PAGO POR CONSUMO - DESCONTADO DEL SALDO A FAVOR DEL USUARIO");
                    dp.setTipoIVA(0);
                    dp.setMontoDescuento(0);
                    dp.setIdComprobante(numcomp);
                    dp.setTipoPago("COMPROBANTES");
                    dp.setIdCuenta(Integer.parseInt(comboCuenta.getSelectedItem().toString()));
                    
                    if(comp.getImpTotal()+comp.getIVA10()<=afavor){
                        dao.Cuentas.actualizarSaldoAFavor(Integer.parseInt(comboCuenta.getSelectedItem().toString()), (comp.getImpTotal()+comp.getIVA10()), false);
                        pago.actualizarComprobante(numcomp, "PAGADO");
                        dp.setSubtotal((comp.getImpTotal()+comp.getIVA10()));
                        p.setTotal((comp.getImpTotal()+comp.getIVA10()));
                    }
                    else{
                        dao.Cuentas.actualizarSaldoAFavor(Integer.parseInt(comboCuenta.getSelectedItem().toString()), afavor, false);
                        pago.actualizarComprobante(numcomp, "PARCIALMENTE PAGADO");
                        dp.setSubtotal(afavor);
                        p.setTotal(afavor);
                    }
                    if(pago.insertarPagoMulti(p, dp)){
                        modelos.ComprobanteInterno ci = new modelos.ComprobanteInterno();
                        ci.setNomApe(campoUsuario.getText());
                        ci.setNumComprobante(numcomp);
                        ci.setEstadoComprobante(dao.Comprobante.obtenerEstado(numcomp));
                        ci.setNumMedidor(((modelos.Medidor)comboMedidor.getSelectedItem()).getNumeroMedidor());
                        ci.setNumcuenta(comboCuenta.getSelectedItem().toString());
                        ci.setSaldoActual(afavor - (comp.getImpTotal()+comp.getIVA10()) >= 0 ? afavor - (comp.getImpTotal()+comp.getIVA10()) : 0);
                        ci.setSaldoAnterior(afavor);
                        new reportes.Informes().mostrarComprobanteInterno(ci);
                    }
                }
                else{
                    pago.actualizarComprobante(numcomp, "PENDIENTE");
                }
                
                String[] options = {"Sí", "Más Tarde"};
                int seleccion = javax.swing.JOptionPane.showOptionDialog(
                null, "El comprobante ha sido actualizado. ¿Desea obtener una vista previa?", "Comprobante Actualizado", 
                        javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if(seleccion == 0){
                    reportes.Comprobante c = new reportes.Comprobante();
                    c.abrirComprobante(String.valueOf(l.getIdentificador()), this);
                }
            }
            
            JOptionPane.showMessageDialog(null, "Se actualizó correctamente.", "Actualización de registro exitosa", JOptionPane.INFORMATION_MESSAGE);
            f.limpiarCampos(panelContenedor);
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "No se ha podido actualizar los datos. Por favor, inténtelo de nuevo más tarde.", "Ocurrió un error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void campoActualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoActualKeyTyped
        if(Validaciones.Longitud(campoAnterior, 11)) evt.consume();
        if(!Validaciones.Numeros(evt.getKeyChar())) evt.consume();
    }//GEN-LAST:event_campoActualKeyTyped

    private void campoActualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoActualKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(Integer.parseInt(campoActual.getText().replace(".", ""))<Integer.parseInt(campoAnterior.getText().replace(".", ""))){
                JOptionPane.showMessageDialog(null, "La lectura ingresada es menor a la lectura anterior.", "Atención", JOptionPane.WARNING_MESSAGE);
                campoActual.requestFocus();
                return;
            }
            else{
                calc = new utilidades.Calculos(Integer.parseInt(campoActual.getText().replace(".", "")), Integer.parseInt(campoAnterior.getText().replace(".", "")));
                campoM3Minimo.setText(f.formatearNumero(calc.getM3Minimo()));
                campoM3Exc.setText(f.formatearNumero(calc.getExcedenteM3()));
                campoM3Total.setText(f.formatearNumero(calc.getTotalM3()));
                campoSubtotal.setText(f.formatearNumero(calc.getTotal()));
                campoIVA10.setText(f.formatearNumero(calc.getIVA()));
                campoFActual.setText(f.formatearNumero(calc.getTotalConIVA()));
                saldo = dao.Comprobante.obtenerSaldoAnteriorALectura(l.getIdentificador().toString());
                campoFAcum.setText(f.formatearNumero(saldo));
                campoTotal.setText(f.formatearNumero(calc.getTotalConIVA() + saldo));
                campoERSSAN.setText(f.formatearNumero(calc.getERSSAN()));
            }
        }
    }//GEN-LAST:event_campoActualKeyPressed
    
    private void completarCampos(){
        campoUsuario.setText(comprobante.get(0));
        campoNumUsuario.setText(comprobante.get(2));
        comboCuenta.setModel(new javax.swing.DefaultComboBoxModel(new String[]{dao.Cuentas.getCuenta(Integer.parseInt(comprobante.get(20)), campoNumUsuario.getText())}));
        comboMedidor.setModel(new javax.swing.DefaultComboBoxModel(dao.Medidor.medidoresAsignados(Integer.parseInt(comboCuenta.getSelectedItem().toString())).toArray()));
        for(int i = 0; i<comboMedidor.getModel().getSize(); i++){
            if(((modelos.Medidor)comboMedidor.getItemAt(i)).getNumeroMedidor().equals(comprobante.get(1))){comboMedidor.setSelectedIndex(i); break;}
        }
        lant = m.getLecturaAnteriorPor(((modelos.Medidor)comboMedidor.getSelectedItem()).getIdentificador().toString(), l.getIdentificador().toString());
        for(int i = 0; i<comboZona.getModel().getSize(); i++){
            if(((modelos.Zona)comboZona.getItemAt(i)).getIdentificador().toString().equals(comprobante.get(18))){comboZona.setSelectedIndex(i); break;}
        }
        ((javax.swing.JTextField)campoFechaActual.getDateEditor().getUiComponent()).setText(comprobante.get(3));
        campoActual.setText(comprobante.get(5));
        campoAnterior.setText(comprobante.get(6));
        campoM3Minimo.setText(comprobante.get(7));
        campoM3Exc.setText(comprobante.get(8));
        campoM3Total.setText(comprobante.get(9));
        campoSubtotal.setText(comprobante.get(12));
        campoFActual.setText(String.valueOf(Integer.parseInt(comprobante.get(12))+Integer.parseInt(comprobante.get(15))));
        campoFAcum.setText(dao.Comprobante.obtenerSaldoAnteriorALectura(l.getIdentificador().toString()).toString());
        ((javax.swing.JTextField)campoFechaVenc.getDateEditor().getUiComponent()).setText(comprobante.get(14));
        campoIVA10.setText(comprobante.get(15));
        campoTotal.setText(String.valueOf(Integer.parseInt(campoFActual.getText())+Integer.parseInt(campoFAcum.getText())));
        campoERSSAN.setText(comprobante.get(16));
        idLote = Integer.parseInt(comprobante.get(19));
        
        cant.setIdComprobante(Integer.parseInt(comprobante.get(13)));
        cant.setERSSAN(Integer.parseInt(campoERSSAN.getText().replace(".", "")));
        cant.setImpTotal(Integer.parseInt(campoSubtotal.getText().replace(".", "")));
        cant.setIVA10(Integer.parseInt(campoIVA10.getText().replace(".", "")));
        try {
            cant.setFechaVencimiento(utilidades.Estaticos.FORMATODMA.parse(comprobante.get(14)));
        } catch (ParseException ex) {
            Logger.getLogger(EditarLectura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JComboBox comboCuenta;
    private javax.swing.JComboBox comboMedidor;
    private javax.swing.JComboBox comboZona;
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
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JLabel labelZona;
    private javax.swing.JLabel labelm3Minimo;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelGenerales;
    private javax.swing.JPanel panelMedidor;
    private javax.swing.JPanel panelTotales;
    // End of variables declaration//GEN-END:variables
}
