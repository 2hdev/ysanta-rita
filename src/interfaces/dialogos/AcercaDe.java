package interfaces.dialogos;

import java.awt.Desktop;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AcercaDe extends javax.swing.JDialog {

    public AcercaDe(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        utilidades.Funciones.cerrarConEscape(AcercaDe.this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelDesarrollo = new javax.swing.JLabel();
        panelContacto = new javax.swing.JPanel();
        labelEmail = new javax.swing.JLabel();
        labelEmail1 = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        labelValorTelef = new javax.swing.JLabel();
        labelWeb = new javax.swing.JLabel();
        labelValorWeb = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        panelSistema = new javax.swing.JPanel();
        labelVersion = new javax.swing.JLabel();
        labelValorVersion = new javax.swing.JLabel();
        labelValorTelef1 = new javax.swing.JLabel();
        btnManual = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Acerca de Y");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(utilidades.Estaticos.ICONO)));
        setModal(true);
        setResizable(false);

        labelDesarrollo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelDesarrollo.setText("Desarrollado por");

        panelContacto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos de Contacto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N

        labelEmail.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        labelEmail.setText("Correo Electrónico:");

        labelEmail1.setFont(new java.awt.Font("Segoe UI", 2, 11)); // NOI18N
        labelEmail1.setText("contacto@2hdev.com.py");

        labelTelefono.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        labelTelefono.setText("Teléfono:");

        labelValorTelef.setFont(new java.awt.Font("Segoe UI", 2, 11)); // NOI18N
        labelValorTelef.setText("(0985) 712105");

        labelWeb.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        labelWeb.setText("Página Web:");

        labelValorWeb.setFont(new java.awt.Font("Segoe UI", 2, 11)); // NOI18N
        labelValorWeb.setText("www.2hdev.com.py");

        javax.swing.GroupLayout panelContactoLayout = new javax.swing.GroupLayout(panelContacto);
        panelContacto.setLayout(panelContactoLayout);
        panelContactoLayout.setHorizontalGroup(
            panelContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContactoLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panelContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTelefono, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelWeb, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(panelContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEmail1)
                    .addComponent(labelValorTelef)
                    .addComponent(labelValorWeb))
                .addGap(41, 41, 41))
        );
        panelContactoLayout.setVerticalGroup(
            panelContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContactoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEmail)
                    .addComponent(labelEmail1))
                .addGap(18, 18, 18)
                .addGroup(panelContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefono)
                    .addComponent(labelValorTelef))
                .addGap(18, 18, 18)
                .addGroup(panelContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelWeb)
                    .addComponent(labelValorWeb))
                .addContainerGap())
        );

        labelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2hdev sin fondo ni eslogan.png"))); // NOI18N
        labelLogo.setToolTipText("");

        panelSistema.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos de Sistema", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N

        labelVersion.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        labelVersion.setText("Versión:");

        labelValorVersion.setFont(new java.awt.Font("Segoe UI", 2, 11)); // NOI18N
        labelValorVersion.setText("1.6.4");

        labelValorTelef1.setFont(new java.awt.Font("Segoe UI", 2, 11)); // NOI18N
        labelValorTelef1.setText("Noviembre - 2018");

        javax.swing.GroupLayout panelSistemaLayout = new javax.swing.GroupLayout(panelSistema);
        panelSistema.setLayout(panelSistemaLayout);
        panelSistemaLayout.setHorizontalGroup(
            panelSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSistemaLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(panelSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(labelValorTelef1)
                    .addGroup(panelSistemaLayout.createSequentialGroup()
                        .addComponent(labelVersion)
                        .addGap(41, 41, 41)
                        .addComponent(labelValorVersion)))
                .addGap(100, 100, 100))
        );
        panelSistemaLayout.setVerticalGroup(
            panelSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSistemaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelVersion)
                    .addComponent(labelValorVersion))
                .addGap(18, 18, 18)
                .addComponent(labelValorTelef1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnManual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pdf.png"))); // NOI18N
        btnManual.setToolTipText("Ver Manual de Usuario");
        btnManual.setBorderPainted(false);
        btnManual.setContentAreaFilled(false);
        btnManual.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnManual.setMaximumSize(new java.awt.Dimension(30, 30));
        btnManual.setMinimumSize(new java.awt.Dimension(30, 30));
        btnManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManualActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(labelDesarrollo)
                            .addComponent(panelContacto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelSistema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(btnManual, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(labelDesarrollo)
                .addGap(29, 29, 29)
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(panelContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnManual, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManualActionPerformed
        try {
            File pdfFile = Paths.get(new File(y.Y.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).
                    getParentFile().getParentFile().getPath() + utilidades.Estaticos.MANUAL).toFile();
            System.out.println(pdfFile);
            if (pdfFile.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    JOptionPane.showMessageDialog(null, "La versión de su sistema operativo no soporta este comando.", "Error al intentar abrir el archivo PDF", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encuentra el archivo o no está disponible en este momento.", "Error al intentar abrir el archivo PDF", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | IOException | URISyntaxException ex) {
            Logger.getLogger(AcercaDe.class.getName()).log(Level.SEVERE, "Error al intentar abrir manual: ", ex);
        }
    }//GEN-LAST:event_btnManualActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManual;
    private javax.swing.JLabel labelDesarrollo;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelEmail1;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel labelValorTelef;
    private javax.swing.JLabel labelValorTelef1;
    private javax.swing.JLabel labelValorVersion;
    private javax.swing.JLabel labelValorWeb;
    private javax.swing.JLabel labelVersion;
    private javax.swing.JLabel labelWeb;
    private javax.swing.JPanel panelContacto;
    private javax.swing.JPanel panelSistema;
    // End of variables declaration//GEN-END:variables
}
