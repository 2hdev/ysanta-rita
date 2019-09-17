package interfaces;

import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import modelos.Empresa;
import utilidades.Funciones;
import utilidades.Validaciones;

public class Parametros extends javax.swing.JInternalFrame {

    Funciones f;
    Empresa e;
    modelos.Parametros p;
    dao.Parametros emp;
    String accion = "nuevo";
    String[] datos;

    public Parametros() {
        initComponents();
        emp = new dao.Parametros();
        f = new Funciones();
        if (emp.contarEmpresa()) {
            f.inhabilitarCampos(panelCampos);
            String lista = emp.listarParametros();
            datos = lista.split(",");
            campoEmpresa.setText(datos[0]);
            campoDireccion.setText(datos[1]);
            campoTelefono.setText(datos[2]);
            campoRUC.setText(datos[3].substring(0, datos[3].indexOf("-")));
            campoDV.setText(datos[3].substring(datos[3].indexOf("-") + 1));
            campoPreciom3.setText(datos[4]);
            campoImporteMinimo.setText(datos[5]);
            campoERSSAN.setText(datos[6]);
            campom3minimo.setText(datos[7]);
            campoIVA.setText(datos[8]);
            campoInteres.setText(datos[9]);
            btnGuardar.setEnabled(false);
        }
    }

    @Override
    public void dispose() {
        if (conexion.InicioSesion.getUsuario().contains("admin")) {
            PrincipalAdmin.accionar("inicio");
        } else {
            Principal.accionar("inicio");
        }
        super.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCampos = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        campoEmpresa = new javax.swing.JTextField();
        campoDireccion = new javax.swing.JTextField();
        campoTelefono = new javax.swing.JTextField();
        campoRUC = new javax.swing.JTextField();
        campoDV = new javax.swing.JTextField();
        campoPreciom3 = new javax.swing.JTextField();
        campoImporteMinimo = new javax.swing.JTextField();
        campoERSSAN = new javax.swing.JTextField();
        campom3minimo = new javax.swing.JTextField();
        campoIVA = new javax.swing.JTextField();
        labelEmpresa = new javax.swing.JLabel();
        labelDireccion = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        labelRUC = new javax.swing.JLabel();
        labelPreciom3 = new javax.swing.JLabel();
        labelImporteMinimo = new javax.swing.JLabel();
        labelERRSAN = new javax.swing.JLabel();
        labelpor100 = new javax.swing.JLabel();
        labelm3minimo = new javax.swing.JLabel();
        labelIVA = new javax.swing.JLabel();
        labelpor100_ = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        campoInteres = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Parámetros");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/y_mini.png"))); // NOI18N

        panelCampos.setPreferredSize(new java.awt.Dimension(546, 512));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        btnEditar.setToolTipText("Editar");
        btnEditar.setBorderPainted(false);
        btnEditar.setContentAreaFilled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        campoEmpresa.setName("nombre_emp"); // NOI18N
        campoEmpresa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoEmpresaFocusLost(evt);
            }
        });
        campoEmpresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoEmpresaKeyTyped(evt);
            }
        });

        campoDireccion.setName("direccion_emp"); // NOI18N
        campoDireccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoDireccionFocusLost(evt);
            }
        });
        campoDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoDireccionKeyTyped(evt);
            }
        });

        campoTelefono.setName("telefono_emp"); // NOI18N
        campoTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoTelefonoFocusLost(evt);
            }
        });
        campoTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoTelefonoKeyTyped(evt);
            }
        });

        campoRUC.setName("ruc_emp"); // NOI18N
        campoRUC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoRUCFocusLost(evt);
            }
        });
        campoRUC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoRUCKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoRUCKeyTyped(evt);
            }
        });

        campoDV.setEditable(false);
        campoDV.setName("dv"); // NOI18N

        campoPreciom3.setName("preciom3"); // NOI18N
        campoPreciom3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoPreciom3KeyTyped(evt);
            }
        });

        campoImporteMinimo.setName("importe_min"); // NOI18N
        campoImporteMinimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoImporteMinimoKeyTyped(evt);
            }
        });

        campoERSSAN.setName("erssan"); // NOI18N
        campoERSSAN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoERSSANKeyTyped(evt);
            }
        });

        campom3minimo.setName("m3minimo"); // NOI18N
        campom3minimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campom3minimoKeyTyped(evt);
            }
        });

        campoIVA.setName("iva"); // NOI18N
        campoIVA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoIVAKeyTyped(evt);
            }
        });

        labelEmpresa.setText("Empresa:");

        labelDireccion.setText("Dirección:");

        labelTelefono.setText("Teléfono:");

        labelRUC.setText("R.U.C.:");

        labelPreciom3.setText("Precio m³:");

        labelImporteMinimo.setText("Importe Mínimo:");

        labelERRSAN.setText("ERSSAN:");

        labelpor100.setText("%");

        labelm3minimo.setText("m³ mínimo:");

        labelIVA.setText("I.V.A.:");

        labelpor100_.setText("%");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Interés:");

        campoInteres.setName("interes"); // NOI18N
        campoInteres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoInteresKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelCamposLayout = new javax.swing.GroupLayout(panelCampos);
        panelCampos.setLayout(panelCamposLayout);
        panelCamposLayout.setHorizontalGroup(
            panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCamposLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCamposLayout.createSequentialGroup()
                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelCamposLayout.createSequentialGroup()
                                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelEmpresa)
                                    .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCamposLayout.createSequentialGroup()
                                            .addGap(2, 2, 2)
                                            .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(labelDireccion)
                                                .addComponent(campoDireccion)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCamposLayout.createSequentialGroup()
                                            .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(labelTelefono)
                                                .addComponent(campoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(40, 40, 40)
                                            .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(labelRUC)
                                                .addGroup(panelCamposLayout.createSequentialGroup()
                                                    .addComponent(campoRUC, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(campoDV, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addComponent(campoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCamposLayout.createSequentialGroup()
                                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelCamposLayout.createSequentialGroup()
                                                .addComponent(campoPreciom3, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                                .addGap(23, 23, 23))
                                            .addGroup(panelCamposLayout.createSequentialGroup()
                                                .addComponent(labelPreciom3)
                                                .addGap(143, 143, 143)))
                                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelImporteMinimo)
                                            .addComponent(campoImporteMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panelCamposLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(panelCamposLayout.createSequentialGroup()
                                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(labelERRSAN, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(campoERSSAN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelpor100)
                                        .addGap(28, 28, 28)
                                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelm3minimo)
                                            .addComponent(campom3minimo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelIVA)
                                            .addComponent(campoIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panelCamposLayout.createSequentialGroup()
                                        .addComponent(campoInteres, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(panelCamposLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar)
                                .addGap(7, 7, 7)))
                        .addComponent(labelpor100_)))
                .addGap(30, 30, 30))
        );
        panelCamposLayout.setVerticalGroup(
            panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEditar)
                .addGap(10, 10, 10)
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelCamposLayout.createSequentialGroup()
                        .addComponent(labelEmpresa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(labelDireccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCamposLayout.createSequentialGroup()
                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPreciom3)
                            .addComponent(labelImporteMinimo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoPreciom3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoImporteMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCamposLayout.createSequentialGroup()
                                .addComponent(labelERRSAN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(campoERSSAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelpor100)))
                            .addGroup(panelCamposLayout.createSequentialGroup()
                                .addComponent(labelIVA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(campoIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelpor100_)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCamposLayout.createSequentialGroup()
                                .addComponent(labelm3minimo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campom3minimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(27, 27, 27)
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCamposLayout.createSequentialGroup()
                        .addComponent(labelTelefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCamposLayout.createSequentialGroup()
                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelRUC)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoRUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoInteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCampos, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        f.habilitarCampos(panelCampos);
        btnGuardar.setEnabled(true);
        accion = "editar";
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (!f.recorrerYValidar(panelCampos)) {
            return;
        }
        switch (accion) {
            case "nuevo": {
                e = new Empresa();
                p = new modelos.Parametros();
                e.setNombre(campoEmpresa.getText());
                e.setDireccion(campoDireccion.getText());
                e.setRUC(campoRUC.getText() + "-" + campoDV.getText());
                e.setTelefono(campoTelefono.getText());
                p.setErssan(Integer.parseInt(campoERSSAN.getText()));
                p.setImportemin(Integer.parseInt(campoImporteMinimo.getText()));
                p.setIva(Integer.parseInt(campoIVA.getText()));
                p.setM3minimo(Integer.parseInt(campom3minimo.getText()));
                p.setPreciom3(Integer.parseInt(campoPreciom3.getText()));
                p.setInteres(Double.parseDouble(campoInteres.getText()));
                dao.Parametros par = new dao.Parametros();
                if (par.insertarParametros(e, p)) {
                    JOptionPane.showMessageDialog(null, "Los datos han sido guardados correctamente.");
                    btnGuardar.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error intentando guardar los datos.");
                }
                break;
            }
            case "editar": {

                Map<String, String> cambiosEmpresa = new HashMap();
                Map<String, String> cambiosParametros = new HashMap();
                if (!campoEmpresa.getText().equals(datos[0])) {
                    cambiosEmpresa.put(String.format("%s=?", campoEmpresa.getName()), campoEmpresa.getText());
                }
                if (!campoDireccion.getText().equals(datos[1])) {
                    cambiosEmpresa.put(String.format("%s=?", campoDireccion.getName()), campoDireccion.getText());
                }
                if (!campoTelefono.getText().equals(datos[2])) {
                    cambiosEmpresa.put(String.format("%s=?", campoTelefono.getName()), campoTelefono.getText());
                }
                if (!campoRUC.getText().equals(datos[3].substring(0, datos[3].indexOf("-")))) {
                    cambiosEmpresa.put(String.format("%s=?", campoRUC.getName()), campoRUC.getText() + "-" + campoDV.getText());
                }
                if (!campoPreciom3.getText().equals(datos[4])) {
                    cambiosParametros.put(String.format("%s=?", campoPreciom3.getName()), campoPreciom3.getText());
                }
                if (!campoImporteMinimo.getText().equals(datos[5])) {
                    cambiosParametros.put(String.format("%s=?", campoImporteMinimo.getName()), campoImporteMinimo.getText());
                }
                if (!campoERSSAN.getText().equals(datos[6])) {
                    cambiosParametros.put(String.format("%s=?", campoERSSAN.getName()), campoERSSAN.getText());
                }
                if (!campom3minimo.getText().equals(datos[7])) {
                    cambiosParametros.put(String.format("%s=?", campom3minimo.getName()), campom3minimo.getText());
                }
                if (!campoIVA.getText().equals(datos[8])) {
                    cambiosParametros.put(String.format("%s=?", campoIVA.getName()), campoIVA.getText());
                }
                if (!campoInteres.getText().equals(datos[9])) {
                    cambiosParametros.put(String.format("%s=?", campoInteres.getName()), campoInteres.getText());
                }

                if (cambiosEmpresa.size() + cambiosParametros.size() > 0) {
                    dao.Parametros par = new dao.Parametros();
                    if (par.actualizarParametros(cambiosEmpresa, cambiosParametros)) {
                        JOptionPane.showMessageDialog(null, "Se actualizaron los datos correctamente.");
                        btnGuardar.setEnabled(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Se produjo un error intentando actualizar los datos.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se han producido cambios.");
                    accion = "";
                }
                f.inhabilitarCampos(panelCampos);
            }
            default:
                return;
        }
        f.inhabilitarCampos(panelCampos);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void campoEmpresaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoEmpresaKeyTyped
        f.convertirAMayusculas(evt);
        if (!Validaciones.Coma(evt.getKeyChar())) {
            evt.consume();
        }
        if (Validaciones.Longitud(campoEmpresa, 45)) {
            evt.consume();
        }
    }//GEN-LAST:event_campoEmpresaKeyTyped

    private void campoDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDireccionKeyTyped
        f.convertirAMayusculas(evt);
        if (!Validaciones.Coma(evt.getKeyChar())) {
            evt.consume();
        }
        if (Validaciones.Longitud(campoDireccion, 100)) {
            evt.consume();
        }
    }//GEN-LAST:event_campoDireccionKeyTyped

    private void campoRUCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoRUCKeyTyped
        if (!Validaciones.Numeros(evt.getKeyChar())) {
            evt.consume();
        }
        if (Validaciones.Longitud(campoRUC, 11)) {
            evt.consume();
        }
    }//GEN-LAST:event_campoRUCKeyTyped

    private void campoRUCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoRUCKeyPressed
        campoRUC.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, java.util.Collections.EMPTY_SET);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            if (campoRUC.getText().isEmpty()) {
                campoRUC.requestFocus();
            } else {
                campoPreciom3.requestFocus();
                Integer dv = f.calcularRUC(campoRUC.getText());
                campoDV.setText(dv.toString());
            }
        }
    }//GEN-LAST:event_campoRUCKeyPressed

    private void campoPreciom3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPreciom3KeyTyped
        if (!Validaciones.Numeros(evt.getKeyChar())) {
            evt.consume();
        }
        if (Validaciones.Longitud(campoPreciom3, 11)) {
            evt.consume();
        }
    }//GEN-LAST:event_campoPreciom3KeyTyped

    private void campoImporteMinimoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoImporteMinimoKeyTyped
        if (!Validaciones.Numeros(evt.getKeyChar())) {
            evt.consume();
        }
        if (Validaciones.Longitud(campoImporteMinimo, 11)) {
            evt.consume();
        }
    }//GEN-LAST:event_campoImporteMinimoKeyTyped

    private void campoERSSANKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoERSSANKeyTyped
        if (!Validaciones.Numeros(evt.getKeyChar())) {
            evt.consume();
        }
        if (Validaciones.Longitud(campoERSSAN, 11)) {
            evt.consume();
        }
    }//GEN-LAST:event_campoERSSANKeyTyped

    private void campom3minimoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campom3minimoKeyTyped
        if (!Validaciones.Numeros(evt.getKeyChar())) {
            evt.consume();
        }
        if (Validaciones.Longitud(campom3minimo, 11)) {
            evt.consume();
        }
    }//GEN-LAST:event_campom3minimoKeyTyped

    private void campoIVAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoIVAKeyTyped
        if (!Validaciones.Numeros(evt.getKeyChar())) {
            evt.consume();
        }
        if (Validaciones.Longitud(campoIVA, 11)) {
            evt.consume();
        }
    }//GEN-LAST:event_campoIVAKeyTyped

    private void campoRUCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoRUCFocusLost
        if (campoRUC.getText().isEmpty()) {
            campoRUC.requestFocus();
        } else {
            Integer dv = f.calcularRUC(campoRUC.getText());
            campoDV.setText(dv.toString());
        }
    }//GEN-LAST:event_campoRUCFocusLost

    private void campoTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTelefonoKeyTyped
        if (Validaciones.Letras(evt.getKeyChar())) {
            evt.consume();
        }
        if (Validaciones.Espacio(evt.getKeyChar())) {
            evt.consume();
        }
        if (!Validaciones.Coma(evt.getKeyChar())) {
            evt.consume();
        }
        if (Validaciones.Longitud(campoTelefono, 45)) {
            evt.consume();
        }
    }//GEN-LAST:event_campoTelefonoKeyTyped

    private void campoEmpresaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoEmpresaFocusLost
        campoEmpresa.setText(campoEmpresa.getText().trim());
    }//GEN-LAST:event_campoEmpresaFocusLost

    private void campoDireccionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoDireccionFocusLost
        campoDireccion.setText(campoDireccion.getText().trim());
    }//GEN-LAST:event_campoDireccionFocusLost

    private void campoTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoTelefonoFocusLost
        campoTelefono.setText(campoTelefono.getText().trim());
    }//GEN-LAST:event_campoTelefonoFocusLost

    private void campoInteresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoInteresKeyTyped
        if (!Validaciones.Numeros(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_campoInteresKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JTextField campoDV;
    private javax.swing.JTextField campoDireccion;
    private javax.swing.JTextField campoERSSAN;
    private javax.swing.JTextField campoEmpresa;
    private javax.swing.JTextField campoIVA;
    private javax.swing.JTextField campoImporteMinimo;
    private javax.swing.JTextField campoInteres;
    private javax.swing.JTextField campoPreciom3;
    private javax.swing.JTextField campoRUC;
    private javax.swing.JTextField campoTelefono;
    private javax.swing.JTextField campom3minimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelERRSAN;
    private javax.swing.JLabel labelEmpresa;
    private javax.swing.JLabel labelIVA;
    private javax.swing.JLabel labelImporteMinimo;
    private javax.swing.JLabel labelPreciom3;
    private javax.swing.JLabel labelRUC;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel labelm3minimo;
    private javax.swing.JLabel labelpor100;
    private javax.swing.JLabel labelpor100_;
    private javax.swing.JPanel panelCampos;
    // End of variables declaration//GEN-END:variables
}
