package y;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utilidades.Funciones;

public class Login extends javax.swing.JFrame {

    Funciones f = new Funciones();

    public Login() {
        initComponents();
        barraCarga.setVisible(false);
        f.agregarPlaceHolder(campoPass, "Contraseña");
        f.agregarPlaceHolder(campoUsuario, "Usuario");
        campoUsuario.requestFocusInWindow();
        setLocationRelativeTo(null);

        java.io.File jarFile = new java.io.File(utilidades.Estaticos.RUTA_APP.toString() + "/etc/db.properties");
        if (!jarFile.exists()) {
            btnDB.doClick();
        } else {
            conexion.Conexiones.obtenerConexiones();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        panelFondo1 = new javax.swing.JPanel();
        login = new javax.swing.JPanel();
        campoUsuario = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        labelLogin = new javax.swing.JLabel();
        btnAcceder = new javax.swing.JButton();
        campoPass = new javax.swing.JPasswordField();
        btnCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnDB = new javax.swing.JButton();
        barraCarga = new javax.swing.JProgressBar();
        carga = new javax.swing.JPanel();
        cargando = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar Sesión");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(utilidades.Estaticos.ICONO)));
        setUndecorated(true);

        panelFondo.setBackground(new java.awt.Color(229, 224, 224));
        panelFondo.setPreferredSize(new java.awt.Dimension(430, 400));

        panelFondo1.setBackground(new java.awt.Color(229, 224, 224));
        panelFondo1.setPreferredSize(new java.awt.Dimension(430, 400));
        panelFondo1.setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));
        login.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        login.setPreferredSize(new java.awt.Dimension(430, 400));

        campoUsuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoUsuario.setBorder(null);

        labelLogin.setBackground(new java.awt.Color(153, 153, 153));
        labelLogin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelLogin.setText("Iniciar Sesión");

        btnAcceder.setBackground(new java.awt.Color(238, 255, 255));
        btnAcceder.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnAcceder.setText("Acceder");
        btnAcceder.setBorderPainted(false);
        btnAcceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccederActionPerformed(evt);
            }
        });

        campoPass.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        campoPass.setBorder(null);
        campoPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoPassKeyPressed(evt);
            }
        });

        btnCerrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 102, 102));
        btnCerrar.setText("X");
        btnCerrar.setBorder(null);
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/y_mini.png"))); // NOI18N

        btnDB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDB.setForeground(new java.awt.Color(255, 102, 102));
        btnDB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/config.png"))); // NOI18N
        btnDB.setBorder(null);
        btnDB.setContentAreaFilled(false);
        btnDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDBActionPerformed(evt);
            }
        });

        barraCarga.setString("Conectando...");
        barraCarga.setStringPainted(true);

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(loginLayout.createSequentialGroup()
                        .addComponent(labelLogin)
                        .addGap(103, 103, 103)
                        .addComponent(jLabel1))
                    .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnAcceder, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoPass)
                        .addComponent(jSeparator1)
                        .addComponent(campoUsuario)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(loginLayout.createSequentialGroup()
                .addComponent(btnDB)
                .addGap(193, 193, 193)
                .addComponent(barraCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(loginLayout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(labelLogin))
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(campoPass, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(btnAcceder, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDB)
                    .addComponent(barraCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        panelFondo1.add(login, "card2");

        carga.setBackground(new java.awt.Color(229, 224, 224));
        carga.setPreferredSize(new java.awt.Dimension(430, 400));

        cargando.setText("...");

        javax.swing.GroupLayout cargaLayout = new javax.swing.GroupLayout(carga);
        carga.setLayout(cargaLayout);
        cargaLayout.setHorizontalGroup(
            cargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cargaLayout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(cargando, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        cargaLayout.setVerticalGroup(
            cargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cargaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cargando, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183))
        );

        panelFondo1.add(carga, "card3");

        javax.swing.GroupLayout panelFondoLayout = new javax.swing.GroupLayout(panelFondo);
        panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panelFondoLayout.setVerticalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDBActionPerformed
        interfaces.dialogos.ConfigDB lp = new interfaces.dialogos.ConfigDB(this, true);
        lp.setLocationRelativeTo(this);
        lp.setVisible(true);
    }//GEN-LAST:event_btnDBActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void campoPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPassKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAcceder.doClick();
        }
    }//GEN-LAST:event_campoPassKeyPressed

    private void btnAccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccederActionPerformed
        if (campoUsuario.getText().isEmpty() || campoPass.getText().isEmpty()) {
            if (campoUsuario.getText().isEmpty()) {
                campoUsuario.requestFocus();
                return;
            } else {
                campoPass.requestFocus();
                return;
            }
        }
        java.util.Map<String, String> mapa = new java.util.HashMap();
        mapa.put("usuario", campoUsuario.getText().toLowerCase());
        mapa.put("pass", new String(campoPass.getPassword()));
        workers.WorkerLogin task = new workers.WorkerLogin(barraCarga, btnAcceder, mapa, this);
        task.execute();
        task.addPropertyChangeListener((java.beans.PropertyChangeEvent evento) -> {
            evento.getNewValue();
            if (task.isDone()) {
                if (!task.isCorrecto()) {
                    java.util.logging.Logger.getLogger(Login.class.getName()).log(Level.WARNING, "No se pudo iniciar sesión.");
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos, \no no se pudo conectar a la base de datos.", "Error de Conexión", JOptionPane.OK_OPTION);
                    campoUsuario.setText("");
                    campoPass.setText("");
                    campoUsuario.requestFocus();
                }
            }
        });

    }//GEN-LAST:event_btnAccederActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraCarga;
    private javax.swing.JButton btnAcceder;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnDB;
    private javax.swing.JPasswordField campoPass;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JPanel carga;
    private javax.swing.JLabel cargando;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JPanel login;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JPanel panelFondo1;
    // End of variables declaration//GEN-END:variables
}
