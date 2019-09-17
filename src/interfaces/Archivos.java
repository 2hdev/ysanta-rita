package interfaces;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;


public class Archivos extends javax.swing.JInternalFrame {

    List<modelos.Archivos> fni = new ArrayList<>();
    List<modelos.Archivos> ci = new ArrayList<>();
    List<modelos.Archivos> otros = new ArrayList<>();
    
    utilidades.VisorReporte visor;
    
    
    public Archivos() {
        initComponents();
        cargarDatos(btnCI.getName(), ci);
    }

    @Override
    public void dispose() {
        if(conexion.InicioSesion.getUsuario().contains("admin")) PrincipalAdmin.accionar("inicio");
        else Principal.accionar("inicio");
        super.dispose();
    }
    
    private void cargarDatos(String cual, List<modelos.Archivos> lista){
        try {
            File[] files = new java.io.File(utilidades.Estaticos.RUTA_APP+"/impresiones/"+cual).listFiles();
            DefaultListModel<modelos.Archivos> modelo = new DefaultListModel<>();
            for(File file : files) {
                if (file.isFile()) {
                    modelos.Archivos arc = new modelos.Archivos();
                    arc.setArchivo(file);
                    arc.setUbicacion(file.getAbsolutePath());
                    lista.add(arc);
                    modelo.addElement(arc);
                }
            }
            listaArchivos.setModel(modelo);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoOpciones = new javax.swing.ButtonGroup();
        btnFNI = new javax.swing.JRadioButton();
        btnCI = new javax.swing.JRadioButton();
        btnOtros = new javax.swing.JRadioButton();
        labelPregunta = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaArchivos = new javax.swing.JList();
        btnAbrir = new javax.swing.JButton();

        setClosable(true);
        setTitle("Archivos a Imprimir");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/y_mini.png"))); // NOI18N

        grupoOpciones.add(btnFNI);
        btnFNI.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnFNI.setText("Facturas no Impresas");
        btnFNI.setName("fni"); // NOI18N
        btnFNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFNIActionPerformed(evt);
            }
        });

        grupoOpciones.add(btnCI);
        btnCI.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnCI.setSelected(true);
        btnCI.setText("Comprobantes Internos");
        btnCI.setName("ci"); // NOI18N
        btnCI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCIActionPerformed(evt);
            }
        });

        grupoOpciones.add(btnOtros);
        btnOtros.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnOtros.setText("Otros");
        btnOtros.setName("otros"); // NOI18N
        btnOtros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtrosActionPerformed(evt);
            }
        });

        labelPregunta.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelPregunta.setText("¿Qué desea visualizar?");

        listaArchivos.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        listaArchivos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaArchivos.setToolTipText("Una lista sin elementos indica que no existen archivos relacionados a la opción seleccionada.");
        jScrollPane1.setViewportView(listaArchivos);

        btnAbrir.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnAbrir.setText("Abrir");
        btnAbrir.setToolTipText("");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOtros)
                    .addComponent(btnCI)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(labelPregunta)
                        .addComponent(btnFNI)))
                .addGap(62, 62, 62)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btnAbrir)
                .addContainerGap(170, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(labelPregunta)
                                .addGap(38, 38, 38)
                                .addComponent(btnFNI)
                                .addGap(18, 18, 18)
                                .addComponent(btnCI)
                                .addGap(19, 19, 19)
                                .addComponent(btnOtros))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(btnAbrir)))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFNIActionPerformed
        cargarDatos(btnFNI.getName(), fni);
    }//GEN-LAST:event_btnFNIActionPerformed

    private void btnCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCIActionPerformed
        cargarDatos(btnCI.getName(), ci);
    }//GEN-LAST:event_btnCIActionPerformed

    private void btnOtrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtrosActionPerformed
        cargarDatos(btnOtros.getName(), otros);
    }//GEN-LAST:event_btnOtrosActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        try {
            if(visor != null && visor.isVisible()) {visor.toFront(); return;}
            if(((modelos.Archivos)listaArchivos.getSelectedValue()).getArchivo().exists()){
                boolean elimina = btnFNI.isSelected()?true:(!btnCI.isSelected());
                visor = new utilidades.VisorReporte(((modelos.Archivos)listaArchivos.getSelectedValue()).getUbicacion(), false, false, true, elimina);
            }
            else{
                JOptionPane.showMessageDialog(null, "El archivo ya no existe actualmente.", "Archivo inexistente", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (JRException ex) {
            ex.getMessage();
        }
        reportes.Archivos.abrirGuardado(visor, ((modelos.Archivos)listaArchivos.getSelectedValue()).getNombre());
    }//GEN-LAST:event_btnAbrirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JRadioButton btnCI;
    private javax.swing.JRadioButton btnFNI;
    private javax.swing.JRadioButton btnOtros;
    private javax.swing.ButtonGroup grupoOpciones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelPregunta;
    private javax.swing.JList listaArchivos;
    // End of variables declaration//GEN-END:variables
}
