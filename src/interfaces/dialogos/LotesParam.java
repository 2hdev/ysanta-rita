package interfaces.dialogos;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import utilidades.Funciones;
import utilidades.Validaciones;

public class LotesParam extends javax.swing.JDialog {
    
    javax.swing.JButton boton;
    Funciones f = new Funciones();
    
    public LotesParam(javax.swing.JInternalFrame parent, javax.swing.JButton boton, boolean modal) {
        initComponents();
        this.boton = boton;
        f.agregarPlaceHolder(numLote, "Ingrese un valor numérico mayor a cero.");
    }

    @Override
    public void dispose() {
        boton.setEnabled(true);
        super.dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelDesde = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        numLote = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingrese el Número de Lote");
        setIconImage(new ImageIcon(getClass().getResource(utilidades.Estaticos.ICONO)).getImage());
        setModal(true);

        labelDesde.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelDesde.setText("Lote Nº:");

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

        numLote.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        numLote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                numLoteKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numLoteKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelDesde)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(btnAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(numLote)))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDesde)
                    .addComponent(numLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if(Validaciones.CampoVacio(numLote.getText())) {numLote.requestFocus(); return;}
        modelos.LotePagos lotePago = dao.Pagos.obtenerLotePago(numLote.getText());
        if(lotePago != null){
            reportes.Informes inf = new reportes.Informes();
            inf.mostrarInformePagos(dao.Reportes.obtenerPagosPorLote(numLote.getText(), "TODOS"), numLote.getText(), lotePago);
            dispose();
        }
        else JOptionPane.showMessageDialog(null, "No existe el número de lote ingresado.", "Lote inexistente", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void numLoteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numLoteKeyTyped
        if(!Validaciones.Numeros(evt.getKeyChar())) evt.consume();
    }//GEN-LAST:event_numLoteKeyTyped

    private void numLoteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numLoteKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) btnAceptar.doClick();
    }//GEN-LAST:event_numLoteKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel labelDesde;
    private javax.swing.JTextField numLote;
    // End of variables declaration//GEN-END:variables
}
