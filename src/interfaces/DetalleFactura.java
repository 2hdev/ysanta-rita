package interfaces;

import clases.tablas.TablaLotePagos;
import clases.tablas.TablaPagos;
import static interfaces.ListaFacturasxLotes.tablaPagosxLote;
import static interfaces.ListaPagos.tablaPagos;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JOptionPane;
import utilidades.Funciones;
import utilidades.Validaciones;

public class DetalleFactura extends javax.swing.JDialog {
    
    Funciones f;
    private String idPago, idLote;
    dao.Pagos dp;
    modelos.Medidor m;
    
    public DetalleFactura(javax.swing.JInternalFrame parent, boolean modal, String idPago, String idLote) {
        f = new Funciones();
        this.idPago = idPago;
        this.idLote = idLote;
        dp = new dao.Pagos();
        initComponents();
        utilidades.Funciones.cerrarConEscape(DetalleFactura.this);
        f.inhabilitarCampos(panelContenedor);
        
        List<String> cabecera = dao.Pagos.listarPago(idPago);
        campoNumFact.setText(cabecera.get(3));
        campoFecha.setText(cabecera.get(0));
        campoNoAp.setText(cabecera.get(2));
        labelImporte.setText(cabecera.get(1));
        
        List<modelos.DetallePago> detalle = dp.listarDetallePago(idPago);
        detalle.forEach((det) -> {
            ((javax.swing.table.DefaultTableModel)tablaConceptos.getModel()).addRow(
                    new String[]{det.getCantidad().toString(),
                        det.getConcepto(),
                        det.getSubtotal().toString(),
                        det.getTipoIVA() == 0?"EXENTA":det.getTipoIVA().toString()+"%"});
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        labelNumFact = new javax.swing.JLabel();
        campoNumFact = new javax.swing.JTextField();
        labelDescripcion = new javax.swing.JLabel();
        campoNoAp = new javax.swing.JTextField();
        btnAnular = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaConceptos = new javax.swing.JTable();
        labelFecha = new javax.swing.JLabel();
        campoFecha = new javax.swing.JTextField();
        labelTotal = new javax.swing.JLabel();
        labelImporte = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelContenedor.setToolTipText("Puede modificar el valor de la última lectura desde \"Lecturas\".");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(utilidades.Estaticos.ICONO)));

        labelNumFact.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelNumFact.setText("Nº Factura:");

        campoNumFact.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoNumFact.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        campoNumFact.setEnabled(false);
        campoNumFact.setName("numero_med"); // NOI18N

        labelDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelDescripcion.setText("Nombre:");

        campoNoAp.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoNoAp.setEnabled(false);
        campoNoAp.setName("descripcion_med"); // NOI18N
        campoNoAp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoNoApFocusLost(evt);
            }
        });
        campoNoAp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNoApKeyTyped(evt);
            }
        });

        btnAnular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dardebaja.png"))); // NOI18N
        btnAnular.setToolTipText("Anular Factura");
        btnAnular.setBorderPainted(false);
        btnAnular.setContentAreaFilled(false);
        btnAnular.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
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
        tablaConceptos.setEnabled(false);
        jScrollPane1.setViewportView(tablaConceptos);

        labelFecha.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelFecha.setText("Fecha:");

        campoFecha.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoFecha.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        campoFecha.setEnabled(false);
        campoFecha.setName("numero_med"); // NOI18N

        labelTotal.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelTotal.setText("Total:");

        labelImporte.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelImporte.setText("0");
        labelImporte.setEnabled(false);
        labelImporte.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorLayout.createSequentialGroup()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelTotal)
                        .addGap(147, 147, 147)
                        .addComponent(labelImporte))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelContenedorLayout.createSequentialGroup()
                                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelDescripcion)
                                    .addComponent(labelNumFact)
                                    .addComponent(labelFecha))
                                .addGap(27, 27, 27)
                                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoNumFact, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoNoAp, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addComponent(btnAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNumFact)
                            .addComponent(campoNumFact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelFecha)
                            .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDescripcion)
                    .addComponent(campoNoAp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTotal)
                    .addComponent(labelImporte))
                .addGap(45, 45, 45))
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

    private void campoNoApFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNoApFocusLost
        campoNoAp.setText(f.removerEspaciosExtra(campoNoAp.getText()));
        campoNoAp.setText(campoNoAp.getText().trim());
    }//GEN-LAST:event_campoNoApFocusLost

    private void campoNoApKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNoApKeyTyped
        f.convertirAMayusculas(evt);
        if(Validaciones.Longitud(campoNoAp, 100)) evt.consume();
    }//GEN-LAST:event_campoNoApKeyTyped

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        String[] options = {"Sí", "No"};
        int seleccion = javax.swing.JOptionPane.showOptionDialog(
            null, "¿Desea realmente anular la factura Nº "+campoNumFact.getText()+" ?", "Anular Factura", 
            javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if(seleccion == 0){
            if(dp.anularFactura(idPago)){
                JOptionPane.showMessageDialog(null, "Se ha anulado la factura correctamente.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                ((TablaPagos)tablaPagosxLote.getModel()).limpiar();
                ((TablaPagos)tablaPagosxLote.getModel()).setPagos(dao.Pagos.listarPagosxLotes(idLote));
                ((TablaLotePagos)tablaPagos.getModel()).limpiar();
                ((TablaLotePagos)tablaPagos.getModel()).setPagos(dao.Pagos.listarLotesPagos());
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Ocurrió un error intentando anular la factura. Por favor, inténtelo de nuevo más tarde.", "Error", JOptionPane.ERROR_MESSAGE);
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnAnularActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnular;
    private javax.swing.JTextField campoFecha;
    private javax.swing.JTextField campoNoAp;
    private javax.swing.JTextField campoNumFact;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelImporte;
    private javax.swing.JLabel labelNumFact;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JTable tablaConceptos;
    // End of variables declaration//GEN-END:variables
}
