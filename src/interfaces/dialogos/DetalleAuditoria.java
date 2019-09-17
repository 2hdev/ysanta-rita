package interfaces.dialogos;

import java.awt.Toolkit;

public class DetalleAuditoria extends javax.swing.JDialog {

    public DetalleAuditoria(javax.swing.JInternalFrame parent, boolean modal, modelos.Auditoria aud) {
        initComponents();
        campoTabla.setText(aud.getTablaAuditada());
        campoAccion.setText(aud.getAccion());
        campoDetalle.setText(aud.getDetalleAuditado());
        campoFH.setText(aud.getFechaHora());
        campoAutor.setText(aud.getAutor());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAceptar = new javax.swing.JButton();
        panelAuditoria = new javax.swing.JPanel();
        labelTabla = new javax.swing.JLabel();
        campoTabla = new javax.swing.JTextField();
        labelAccion = new javax.swing.JLabel();
        campoAccion = new javax.swing.JTextField();
        labelAutor = new javax.swing.JLabel();
        campoAutor = new javax.swing.JTextField();
        labelFH = new javax.swing.JLabel();
        campoFH = new javax.swing.JTextField();
        labelDetalle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoDetalle = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalle de Auditoría");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(utilidades.Estaticos.ICONO)));

        btnAceptar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        labelTabla.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelTabla.setText("Tabla Auditada:");

        campoTabla.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoTabla.setEnabled(false);

        labelAccion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelAccion.setText("Acción:");

        campoAccion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoAccion.setEnabled(false);

        labelAutor.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelAutor.setText("Autor:");

        campoAutor.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoAutor.setEnabled(false);

        labelFH.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelFH.setText("Fecha/Hora:");

        campoFH.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoFH.setEnabled(false);

        labelDetalle.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelDetalle.setText("Detalle:");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setName("observacion_lec"); // NOI18N

        campoDetalle.setColumns(20);
        campoDetalle.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoDetalle.setLineWrap(true);
        campoDetalle.setRows(10);
        campoDetalle.setEnabled(false);
        campoDetalle.setName("obs_med"); // NOI18N
        jScrollPane1.setViewportView(campoDetalle);

        javax.swing.GroupLayout panelAuditoriaLayout = new javax.swing.GroupLayout(panelAuditoria);
        panelAuditoria.setLayout(panelAuditoriaLayout);
        panelAuditoriaLayout.setHorizontalGroup(
            panelAuditoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAuditoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAuditoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTabla, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelAutor, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelDetalle, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(panelAuditoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelAuditoriaLayout.createSequentialGroup()
                        .addGroup(panelAuditoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(panelAuditoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelAccion, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelFH, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(panelAuditoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoFH, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        panelAuditoriaLayout.setVerticalGroup(
            panelAuditoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAuditoriaLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelAuditoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTabla)
                    .addComponent(campoAccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAccion))
                .addGap(18, 18, 18)
                .addGroup(panelAuditoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAutor)
                    .addComponent(campoFH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFH))
                .addGap(18, 18, 18)
                .addGroup(panelAuditoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDetalle)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(panelAuditoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGap(328, 328, 328)
                .addComponent(btnAceptar)
                .addGap(345, 345, 345))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(panelAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAceptar)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JTextField campoAccion;
    private javax.swing.JTextField campoAutor;
    private javax.swing.JTextArea campoDetalle;
    private javax.swing.JTextField campoFH;
    private javax.swing.JTextField campoTabla;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAccion;
    private javax.swing.JLabel labelAutor;
    private javax.swing.JLabel labelDetalle;
    private javax.swing.JLabel labelFH;
    private javax.swing.JLabel labelTabla;
    private javax.swing.JPanel panelAuditoria;
    // End of variables declaration//GEN-END:variables
}
