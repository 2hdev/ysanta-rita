package interfaces.dialogos;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import utilidades.Funciones;
import utilidades.Validaciones;

public class FechasParam extends javax.swing.JDialog {
    
    javax.swing.JButton boton;
    private Integer elId; private String nomape;
    Funciones f = new Funciones();
    
    java.util.Date hoy = new java.util.Date();
    
    public FechasParam(javax.swing.JInternalFrame parent, javax.swing.JButton boton, boolean modal) {
        initComponents();
        this.boton = boton;
        f.agregarPlaceHolder(((javax.swing.JTextField)desde.getDateEditor().getUiComponent()), "Desde: (dd/MM/aaaa)");
        f.agregarPlaceHolder(((javax.swing.JTextField)hasta.getDateEditor().getUiComponent()), "Hasta: (dd/MM/aaaa)");
        desde.setDate(hoy);
        hasta.setDate(hoy);
    }
    
    public FechasParam(javax.swing.JInternalFrame parent, javax.swing.JButton boton, Integer elId, String nomape, boolean modal) {
        initComponents();
        this.boton = boton;
        this.elId = elId;
        this.nomape = nomape;
        f.agregarPlaceHolder(((javax.swing.JTextField)desde.getDateEditor().getUiComponent()), "Desde: (dd/MM/aaaa)");
        f.agregarPlaceHolder(((javax.swing.JTextField)hasta.getDateEditor().getUiComponent()), "Hasta: (dd/MM/aaaa)");
        desde.setDate(hoy);
        hasta.setDate(hoy);
    }
    
    @Override
    public void dispose() {
        boton.setEnabled(true);
        super.dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desde = new com.toedter.calendar.JDateChooser();
        labelDesde = new javax.swing.JLabel();
        labelHasta = new javax.swing.JLabel();
        hasta = new com.toedter.calendar.JDateChooser();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Seleccionar Rango de Fechas");
        setIconImage(new ImageIcon(getClass().getResource(utilidades.Estaticos.ICONO)).getImage());
        setModal(true);

        desde.setDateFormatString("dd/MM/yyyy");
        desde.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        desde.setMaxSelectableDate(new java.util.Date(32503694508000L));
        desde.setMinSelectableDate(new java.util.Date(-2208974960000L));
        desde.getDateEditor().getUiComponent().addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if(Validaciones.Letras(evt.getKeyChar()) || Validaciones.Espacio(evt.getKeyChar())) evt.consume();
            }
        });

        labelDesde.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelDesde.setText("Desde:");

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

        btnAceptar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelDesde)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desde, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelHasta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hasta, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(labelDesde)
                    .addComponent(labelHasta)
                    .addComponent(desde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if(!f.validarDateChooser(desde)) {desde.requestFocusInWindow(); return;}
        if(!f.validarDateChooser(hasta)) {hasta.requestFocusInWindow(); return;}
        if(f.compararFechas(desde.getDate(), hasta.getDate())){
            JOptionPane.showMessageDialog(null, "La fecha de fin es menor a la fecha de inicio.", "Atención", JOptionPane.WARNING_MESSAGE);
            hasta.requestFocusInWindow(); 
            return;
        }
        reportes.Informes inf = new reportes.Informes();
        inf.mostrarHistorialPago(dao.Reportes.obtenerHistorial(elId.toString(), desde.getDate(), hasta.getDate()), nomape, elId, desde.getDate(), hasta.getDate());
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private com.toedter.calendar.JDateChooser desde;
    private com.toedter.calendar.JDateChooser hasta;
    private javax.swing.JLabel labelDesde;
    private javax.swing.JLabel labelHasta;
    // End of variables declaration//GEN-END:variables
}
