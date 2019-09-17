package interfaces.dialogos;

import conexion.Conectar;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import utilidades.Funciones;
import utilidades.Validaciones;

public class ConfigDB extends javax.swing.JDialog {
    
    
    public ConfigDB(javax.swing.JFrame parent, boolean modal) {
        initComponents();
        Funciones.cerrarConEscape(ConfigDB.this);
    }

    public ConfigDB() {
        initComponents();
        Funciones.cerrarConEscape(ConfigDB.this);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        labelIP = new javax.swing.JLabel();
        campoIP = new javax.swing.JTextField();
        labelBD = new javax.swing.JLabel();
        campoBD = new javax.swing.JTextField();
        labelPuerto = new javax.swing.JLabel();
        campoPuerto = new javax.swing.JTextField();
        labelUsuario = new javax.swing.JLabel();
        campoUser = new javax.swing.JTextField();
        labelPass = new javax.swing.JLabel();
        campoPass = new javax.swing.JTextField();
        btnTest = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configurar Conexión");
        setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        setIconImage(new ImageIcon(getClass().getResource(utilidades.Estaticos.ICONO)).getImage());
        setIconImages(null);
        setModal(true);
        setName("ConfigDB"); // NOI18N
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

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

        labelIP.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelIP.setText("IP:");

        campoIP.setBackground(new java.awt.Color(240, 240, 240));
        campoIP.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShadowColor(new java.awt.Color(204, 204, 204));
        dropShadowBorder1.setShowLeftShadow(true);
        campoIP.setBorder(dropShadowBorder1);
        campoIP.setName("zona"); // NOI18N
        campoIP.setPreferredSize(new java.awt.Dimension(5, 30));

        labelBD.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelBD.setText("Base de Datos:");

        campoBD.setBackground(new java.awt.Color(240, 240, 240));
        campoBD.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder2 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder2.setShadowColor(new java.awt.Color(204, 204, 204));
        dropShadowBorder2.setShowLeftShadow(true);
        campoBD.setBorder(dropShadowBorder2);
        campoBD.setName("zona"); // NOI18N
        campoBD.setPreferredSize(new java.awt.Dimension(5, 30));

        labelPuerto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelPuerto.setText("Puerto:");

        campoPuerto.setBackground(new java.awt.Color(240, 240, 240));
        campoPuerto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder3 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder3.setShadowColor(new java.awt.Color(204, 204, 204));
        dropShadowBorder3.setShowLeftShadow(true);
        campoPuerto.setBorder(dropShadowBorder3);
        campoPuerto.setName("zona"); // NOI18N
        campoPuerto.setPreferredSize(new java.awt.Dimension(5, 30));
        campoPuerto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoPuertoKeyTyped(evt);
            }
        });

        labelUsuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelUsuario.setText("Usuario:");

        campoUser.setBackground(new java.awt.Color(240, 240, 240));
        campoUser.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder4 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder4.setShadowColor(new java.awt.Color(204, 204, 204));
        dropShadowBorder4.setShowLeftShadow(true);
        campoUser.setBorder(dropShadowBorder4);
        campoUser.setName("zona"); // NOI18N
        campoUser.setPreferredSize(new java.awt.Dimension(5, 30));

        labelPass.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelPass.setText("Contraseña:");

        campoPass.setBackground(new java.awt.Color(240, 240, 240));
        campoPass.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder5 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder5.setShadowColor(new java.awt.Color(204, 204, 204));
        dropShadowBorder5.setShowLeftShadow(true);
        campoPass.setBorder(dropShadowBorder5);
        campoPass.setName("zona"); // NOI18N
        campoPass.setPreferredSize(new java.awt.Dimension(5, 30));

        btnTest.setText("Probar Conexión");
        btnTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelUsuario)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnTest)
                                            .addComponent(campoUser, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(85, 85, 85)
                                        .addComponent(campoPass, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(labelPass))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelIP)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(campoIP, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(labelPuerto))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(85, 85, 85)
                                        .addComponent(campoPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(campoBD, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(labelBD))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIP)
                    .addComponent(labelPuerto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoIP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(labelBD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoBD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsuario)
                    .addComponent(labelPass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar)
                    .addComponent(btnTest))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(campoIP.getText().isEmpty()){campoIP.requestFocus(); return;}
        if(campoBD.getText().isEmpty()){campoBD.requestFocus(); return;}
        if(campoUser.getText().isEmpty()){campoUser.requestFocus(); return;}
        if(!Validaciones.validarIP(campoIP.getText())){
            JOptionPane.showMessageDialog(null, "Mensaje", "La dirección IP es inválida.", JOptionPane.ERROR_MESSAGE);
            campoIP.requestFocus();
            return;
        }
        Properties props = new Properties();
        props.setProperty("ip", campoIP.getText());
        props.setProperty("port", campoPuerto.getText());
        props.setProperty("db", campoBD.getText());
        props.setProperty("user", campoUser.getText());
        props.setProperty("pass", campoPass.getText());
        
        try {
            java.io.File jarFile = new java.io.File(utilidades.Estaticos.RUTA_APP+"/etc/db.properties");
            if (!jarFile.exists()) 
                jarFile.createNewFile();
            try (FileOutputStream fr = new FileOutputStream(jarFile)) {
                props.store(fr, "Contiene las propiedades de la conexión a la base de datos para el sistema Y.");
            }
            JOptionPane.showMessageDialog(null, "Los datos de conexión se guardaron con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            conexion.Conexiones.obtenerConexiones();
            dispose();
            
        } catch (IOException ex) {
            Logger.getLogger(ConfigDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocurrió un error intentando almacenar los datos de conexión.\nPor favor, inténtelo de nuevo más tarde.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void campoPuertoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPuertoKeyTyped
        if(Validaciones.Longitud(campoPuerto, 5)) evt.consume();
        if(!Validaciones.Numeros(evt.getKeyChar())) evt.consume();
    }//GEN-LAST:event_campoPuertoKeyTyped

    private void btnTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestActionPerformed
        if(!campoIP.getText().isEmpty() && !campoBD.getText().isEmpty() && !campoUser.getText().isEmpty()){
            boolean conecta = Conectar.probarConexion(campoIP.getText(), campoBD.getText(), campoPuerto.getText(), campoUser.getText(), campoPass.getText());
            if(conecta) JOptionPane.showMessageDialog(null, "Conexión Exitosa.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            else JOptionPane.showMessageDialog(null, "Verifique los datos ingresados y vuelva a intentarlo.", "Error - No se pudo conectar a la base de datos", JOptionPane.ERROR_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "<html>Debe completar mínimamente los campos: <br><ul><li>IP,</li><li>Base de Datos,</li><li>Nombre de Usuario de la Base de Datos.</li></ul></html>", "Atención", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnTestActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnTest;
    private javax.swing.JTextField campoBD;
    private javax.swing.JTextField campoIP;
    private javax.swing.JTextField campoPass;
    private javax.swing.JTextField campoPuerto;
    private javax.swing.JTextField campoUser;
    private javax.swing.JLabel labelBD;
    private javax.swing.JLabel labelIP;
    private javax.swing.JLabel labelPass;
    private javax.swing.JLabel labelPuerto;
    private javax.swing.JLabel labelUsuario;
    // End of variables declaration//GEN-END:variables
}
