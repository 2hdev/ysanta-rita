package interfaces;

import java.awt.Color;
import java.awt.Toolkit;
import utilidades.Funciones;

public class Principal extends javax.swing.JFrame {

    Funciones f;
    boolean maximizado = true;

    static RegUsuario u;
    static ListaMedidores lm;
    static Parametros p;
    static Medidor m;
    static ListaUsuarios lu;
    static interfaces.VistaInformes i;
    static ListaLoteLecturas ll;
    static ListaPagos lp;
    static Zonas z;
    static Archivos arc;
    static ListaCuentas lc;

    Color normal = new Color(149, 196, 240);
    Color claro = new Color(118, 173, 215);

    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
        f = new Funciones();
        f.maximizar(Principal.this);
        maximizado = false;
        btnMaxRest.setText("↗");
    }

    public static void accionar(String quienes) {
        for (javax.swing.JInternalFrame f : panelEscritorio.getAllFrames()) {
            panelEscritorio.getDesktopManager().closeFrame(f);
        }
        switch (quienes) {
            case "inicio":
                Funciones.seleccionar(btnInicio, panelMenu);
                btnZonas.setVisible(true);
                btnCuentas.setVisible(true);
                break;
            case "usuarios":
                btnZonas.setVisible(false);
                btnCuentas.setVisible(false);
                Funciones.seleccionar(btnUsuarios, panelMenu);
                if (Funciones.ventanaCerrada(panelEscritorio, lu)) {
                    if (lu == null) {
                        lu = new ListaUsuarios();
                        Funciones.centrar(lu, panelEscritorio);
                    } else {
                        lu.limpiar();
                        ListaUsuarios.pagina = 1;
                        ListaUsuarios.relistar(null);
                        ListaUsuarios.totalFilas();
                        lu.getBtnAnterior().setEnabled(ListaUsuarios.pagina > 1);
                        lu.getBtnSiguiente().setEnabled(ListaUsuarios.cantidad > ListaUsuarios.pagina);
                        Funciones.centrar(lu, panelEscritorio);
                    }
                }
                break;
            case "medidores":
                btnZonas.setVisible(false);
                btnCuentas.setVisible(false);
                Funciones.seleccionar(btnMedidores, panelMenu);
                if (Funciones.ventanaCerrada(panelEscritorio, lm)) {
                    lm = new ListaMedidores();
                    Funciones.centrar(lm, panelEscritorio);
                }
                break;
            case "lecturas":
                btnZonas.setVisible(false);
                btnCuentas.setVisible(false);
                Funciones.seleccionar(btnLecturas, panelMenu);
                if (Funciones.ventanaCerrada(panelEscritorio, ll)) {
                    ll = new ListaLoteLecturas();
                    Funciones.centrar(ll, panelEscritorio);
                }
                break;
            case "facturas":
                btnZonas.setVisible(false);
                btnCuentas.setVisible(false);
                Funciones.seleccionar(btnPagos, panelMenu);
                if (Funciones.ventanaCerrada(panelEscritorio, lp)) {
                    lp = new ListaPagos();
                    Funciones.centrar(lp, panelEscritorio);
                }
                break;
            case "informes":
                btnZonas.setVisible(false);
                btnCuentas.setVisible(false);
                Funciones.seleccionar(btnInformes, panelMenu);
                if (Funciones.ventanaCerrada(panelEscritorio, i)) {
                    i = new interfaces.VistaInformes();
                    Funciones.maximizar(i, panelEscritorio);
                }
                break;
            case "config":
                btnZonas.setVisible(false);
                btnCuentas.setVisible(false);
                Funciones.seleccionar(btnConfig, panelMenu);
                if (Funciones.ventanaCerrada(panelEscritorio, p)) {
                    p = new Parametros();
                    Funciones.centrar(p, panelEscritorio);
                }
                break;
            case "archivos":
                btnZonas.setVisible(false);
                btnCuentas.setVisible(false);
                Funciones.seleccionar(btnArchivos, panelMenu);
                if (Funciones.ventanaCerrada(panelEscritorio, arc)) {
                    arc = new Archivos();
                    Funciones.centrar(arc, panelEscritorio);
                }
            case "cargos":
                btnZonas.setVisible(false);
                btnCuentas.setVisible(false);
                Funciones.seleccionar(btnCargos, panelMenu);
                if (Funciones.ventanaCerrada(panelEscritorio, arc)) {
                    arc = new Archivos();
                    Funciones.centrar(arc, panelEscritorio);
                }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoMenu = new javax.swing.ButtonGroup();
        panelEscritorio = new javax.swing.JDesktopPane();
        btnMin = new javax.swing.JButton();
        btnMaxRest = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnZonas = new javax.swing.JButton();
        btnInfo = new javax.swing.JButton();
        btnCuentas = new javax.swing.JButton();
        panelMenu = new javax.swing.JPanel();
        lateralFacturas1 = new javax.swing.JPanel();
        lateralInformes1 = new javax.swing.JPanel();
        lateralLecturas1 = new javax.swing.JPanel();
        lateralMedidores1 = new javax.swing.JPanel();
        labelLogo1 = new javax.swing.JLabel();
        btnInicio = new javax.swing.JToggleButton();
        btnUsuarios = new javax.swing.JToggleButton();
        btnMedidores = new javax.swing.JToggleButton();
        btnLecturas = new javax.swing.JToggleButton();
        btnPagos = new javax.swing.JToggleButton();
        btnInformes = new javax.swing.JToggleButton();
        btnConfig = new javax.swing.JToggleButton();
        btnArchivos = new javax.swing.JToggleButton();
        btnCargos = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Y");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(utilidades.Estaticos.ICONO)));
        setUndecorated(true);
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        panelEscritorio.setOpaque(false);

        btnMin.setText("_");
        btnMin.setToolTipText("Minimizar");
        btnMin.setBorderPainted(false);
        btnMin.setContentAreaFilled(false);
        btnMin.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnMin.setMaximumSize(new java.awt.Dimension(30, 30));
        btnMin.setMinimumSize(new java.awt.Dimension(30, 30));
        btnMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinActionPerformed(evt);
            }
        });

        btnMaxRest.setText("↑");
        btnMaxRest.setToolTipText("Restaurar");
        btnMaxRest.setBorderPainted(false);
        btnMaxRest.setContentAreaFilled(false);
        btnMaxRest.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnMaxRest.setMaximumSize(new java.awt.Dimension(30, 30));
        btnMaxRest.setMinimumSize(new java.awt.Dimension(30, 30));
        btnMaxRest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaxRestActionPerformed(evt);
            }
        });

        btnCerrar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 102, 102));
        btnCerrar.setText("X");
        btnCerrar.setToolTipText("Cerrar");
        btnCerrar.setBorderPainted(false);
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnCerrar.setMaximumSize(new java.awt.Dimension(30, 30));
        btnCerrar.setMinimumSize(new java.awt.Dimension(30, 30));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnZonas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnZonas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/barrio.png"))); // NOI18N
        btnZonas.setText("Zonas");
        btnZonas.setContentAreaFilled(false);
        btnZonas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnZonas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnZonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZonasActionPerformed(evt);
            }
        });

        btnInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/info.png"))); // NOI18N
        btnInfo.setToolTipText("Info");
        btnInfo.setBorderPainted(false);
        btnInfo.setContentAreaFilled(false);
        btnInfo.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnInfo.setMaximumSize(new java.awt.Dimension(30, 30));
        btnInfo.setMinimumSize(new java.awt.Dimension(30, 30));
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });

        btnCuentas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCuentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cuenta.png"))); // NOI18N
        btnCuentas.setText("Cuentas");
        btnCuentas.setContentAreaFilled(false);
        btnCuentas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCuentas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuentasActionPerformed(evt);
            }
        });

        panelEscritorio.setLayer(btnMin, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelEscritorio.setLayer(btnMaxRest, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelEscritorio.setLayer(btnCerrar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelEscritorio.setLayer(btnZonas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelEscritorio.setLayer(btnInfo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelEscritorio.setLayer(btnCuentas, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelEscritorioLayout = new javax.swing.GroupLayout(panelEscritorio);
        panelEscritorio.setLayout(panelEscritorioLayout);
        panelEscritorioLayout.setHorizontalGroup(
            panelEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEscritorioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnMin, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnMaxRest, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelEscritorioLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(panelEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnZonas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 477, Short.MAX_VALUE))
        );
        panelEscritorioLayout.setVerticalGroup(
            panelEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEscritorioLayout.createSequentialGroup()
                .addGroup(panelEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMaxRest, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMin, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnZonas, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCuentas)
                .addGap(74, 74, 74))
        );

        panelMenu.setBackground(new java.awt.Color(118, 173, 215));

        lateralFacturas1.setBackground(new java.awt.Color(118, 173, 215));
        lateralFacturas1.setFocusable(false);
        lateralFacturas1.setName("lateral"); // NOI18N
        lateralFacturas1.setPreferredSize(new java.awt.Dimension(3, 50));

        javax.swing.GroupLayout lateralFacturas1Layout = new javax.swing.GroupLayout(lateralFacturas1);
        lateralFacturas1.setLayout(lateralFacturas1Layout);
        lateralFacturas1Layout.setHorizontalGroup(
            lateralFacturas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        lateralFacturas1Layout.setVerticalGroup(
            lateralFacturas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        lateralInformes1.setBackground(new java.awt.Color(118, 173, 215));
        lateralInformes1.setFocusable(false);
        lateralInformes1.setName("lateral"); // NOI18N
        lateralInformes1.setPreferredSize(new java.awt.Dimension(3, 50));

        javax.swing.GroupLayout lateralInformes1Layout = new javax.swing.GroupLayout(lateralInformes1);
        lateralInformes1.setLayout(lateralInformes1Layout);
        lateralInformes1Layout.setHorizontalGroup(
            lateralInformes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        lateralInformes1Layout.setVerticalGroup(
            lateralInformes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        lateralLecturas1.setBackground(new java.awt.Color(118, 173, 215));
        lateralLecturas1.setFocusable(false);
        lateralLecturas1.setName("lateral"); // NOI18N
        lateralLecturas1.setPreferredSize(new java.awt.Dimension(3, 50));

        javax.swing.GroupLayout lateralLecturas1Layout = new javax.swing.GroupLayout(lateralLecturas1);
        lateralLecturas1.setLayout(lateralLecturas1Layout);
        lateralLecturas1Layout.setHorizontalGroup(
            lateralLecturas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        lateralLecturas1Layout.setVerticalGroup(
            lateralLecturas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        lateralMedidores1.setBackground(new java.awt.Color(118, 173, 215));
        lateralMedidores1.setFocusable(false);
        lateralMedidores1.setName("lateral"); // NOI18N
        lateralMedidores1.setPreferredSize(new java.awt.Dimension(3, 50));

        javax.swing.GroupLayout lateralMedidores1Layout = new javax.swing.GroupLayout(lateralMedidores1);
        lateralMedidores1.setLayout(lateralMedidores1Layout);
        lateralMedidores1Layout.setHorizontalGroup(
            lateralMedidores1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        lateralMedidores1Layout.setVerticalGroup(
            lateralMedidores1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        labelLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/y_mini.png"))); // NOI18N

        btnInicio.setBackground(new java.awt.Color(149, 196, 240));
        grupoMenu.add(btnInicio);
        btnInicio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnInicio.setForeground(new java.awt.Color(51, 51, 51));
        btnInicio.setText("Inicio");
        btnInicio.setContentAreaFilled(false);
        btnInicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnInicio.setMargin(new java.awt.Insets(2, 50, 2, 14));
        btnInicio.setOpaque(true);
        btnInicio.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                btnInicioStateChanged(evt);
            }
        });
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        btnUsuarios.setBackground(new java.awt.Color(118, 173, 215));
        grupoMenu.add(btnUsuarios);
        btnUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUsuarios.setForeground(new java.awt.Color(51, 51, 51));
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setContentAreaFilled(false);
        btnUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUsuarios.setMargin(new java.awt.Insets(2, 50, 2, 14));
        btnUsuarios.setOpaque(true);
        btnUsuarios.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                btnUsuariosStateChanged(evt);
            }
        });
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        btnMedidores.setBackground(new java.awt.Color(118, 173, 215));
        grupoMenu.add(btnMedidores);
        btnMedidores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnMedidores.setForeground(new java.awt.Color(51, 51, 51));
        btnMedidores.setText("Medidores");
        btnMedidores.setContentAreaFilled(false);
        btnMedidores.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMedidores.setMargin(new java.awt.Insets(2, 50, 2, 14));
        btnMedidores.setOpaque(true);
        btnMedidores.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                btnMedidoresStateChanged(evt);
            }
        });
        btnMedidores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedidoresActionPerformed(evt);
            }
        });

        btnLecturas.setBackground(new java.awt.Color(118, 173, 215));
        grupoMenu.add(btnLecturas);
        btnLecturas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLecturas.setForeground(new java.awt.Color(51, 51, 51));
        btnLecturas.setText("Lecturas");
        btnLecturas.setContentAreaFilled(false);
        btnLecturas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLecturas.setMargin(new java.awt.Insets(2, 50, 2, 14));
        btnLecturas.setOpaque(true);
        btnLecturas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                btnLecturasStateChanged(evt);
            }
        });
        btnLecturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLecturasActionPerformed(evt);
            }
        });

        btnPagos.setBackground(new java.awt.Color(118, 173, 215));
        grupoMenu.add(btnPagos);
        btnPagos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPagos.setForeground(new java.awt.Color(51, 51, 51));
        btnPagos.setText("Pagos");
        btnPagos.setContentAreaFilled(false);
        btnPagos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPagos.setMargin(new java.awt.Insets(2, 50, 2, 14));
        btnPagos.setOpaque(true);
        btnPagos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                btnPagosStateChanged(evt);
            }
        });
        btnPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagosActionPerformed(evt);
            }
        });

        btnInformes.setBackground(new java.awt.Color(118, 173, 215));
        grupoMenu.add(btnInformes);
        btnInformes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnInformes.setForeground(new java.awt.Color(51, 51, 51));
        btnInformes.setText("Informes");
        btnInformes.setContentAreaFilled(false);
        btnInformes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnInformes.setMargin(new java.awt.Insets(2, 50, 2, 14));
        btnInformes.setOpaque(true);
        btnInformes.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                btnInformesStateChanged(evt);
            }
        });
        btnInformes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformesActionPerformed(evt);
            }
        });

        btnConfig.setBackground(new java.awt.Color(118, 173, 215));
        grupoMenu.add(btnConfig);
        btnConfig.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnConfig.setForeground(new java.awt.Color(51, 51, 51));
        btnConfig.setText("Configuración");
        btnConfig.setContentAreaFilled(false);
        btnConfig.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnConfig.setMargin(new java.awt.Insets(2, 50, 2, 14));
        btnConfig.setOpaque(true);
        btnConfig.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                btnConfigStateChanged(evt);
            }
        });
        btnConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigActionPerformed(evt);
            }
        });

        btnArchivos.setBackground(new java.awt.Color(118, 173, 215));
        grupoMenu.add(btnArchivos);
        btnArchivos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnArchivos.setForeground(new java.awt.Color(51, 51, 51));
        btnArchivos.setText("Archivos");
        btnArchivos.setContentAreaFilled(false);
        btnArchivos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnArchivos.setMargin(new java.awt.Insets(2, 50, 2, 14));
        btnArchivos.setOpaque(true);
        btnArchivos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                btnArchivosStateChanged(evt);
            }
        });
        btnArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivosActionPerformed(evt);
            }
        });

        btnCargos.setBackground(new java.awt.Color(118, 173, 215));
        grupoMenu.add(btnCargos);
        btnCargos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCargos.setForeground(new java.awt.Color(51, 51, 51));
        btnCargos.setText("Cargos");
        btnCargos.setContentAreaFilled(false);
        btnCargos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCargos.setMargin(new java.awt.Insets(2, 50, 2, 14));
        btnCargos.setMaximumSize(new java.awt.Dimension(121, 29));
        btnCargos.setMinimumSize(new java.awt.Dimension(121, 29));
        btnCargos.setOpaque(true);
        btnCargos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                btnCargosStateChanged(evt);
            }
        });
        btnCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMenuLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(labelLogo1))
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMenuLayout.createSequentialGroup()
                                .addComponent(lateralInformes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btnArchivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelMenuLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnInicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnUsuarios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnMedidores, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLecturas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnConfig, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                    .addComponent(btnInformes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnPagos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, 0)
                                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lateralLecturas1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lateralFacturas1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnCargos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, 0)
                        .addComponent(lateralMedidores1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addComponent(labelLogo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnMedidores, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lateralMedidores1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelMenuLayout.createSequentialGroup()
                                .addComponent(btnLecturas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btnPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lateralLecturas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInformes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lateralFacturas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConfig, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lateralInformes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCargos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        btnCargos.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelEscritorio)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEscritorio, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnMaxRestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaxRestActionPerformed
        if (maximizado) {
            f.maximizar(this);
            maximizado = false;
            btnMaxRest.setText("↗");
            btnMaxRest.setToolTipText("Restaurar");
        } else {
            f.restaurar(this);
            maximizado = true;
            btnMaxRest.setText("↙");
            btnMaxRest.setToolTipText("Maximizar");
        }
    }//GEN-LAST:event_btnMaxRestActionPerformed

    private void btnMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinActionPerformed
        f.minimizar(this);
    }//GEN-LAST:event_btnMinActionPerformed

    private void btnZonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZonasActionPerformed
        if (Funciones.ventanaCerrada(panelEscritorio, z)) {
            z = new Zonas();
            Funciones.centrar(z, panelEscritorio);
        }
    }//GEN-LAST:event_btnZonasActionPerformed

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed
        interfaces.dialogos.AcercaDe ad = new interfaces.dialogos.AcercaDe(this, true);
        ad.setLocationRelativeTo(this);
        ad.setVisible(true);
    }//GEN-LAST:event_btnInfoActionPerformed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        int oldState = evt.getOldState();
        int newState = evt.getNewState();

        if ((oldState & javax.swing.JFrame.ICONIFIED) != 0 && (newState & javax.swing.JFrame.ICONIFIED) == 0) {
            if (!maximizado) {
                f.maximizar(this);
                btnMaxRest.setText("↗");
                btnMaxRest.setToolTipText("Restaurar");
            } else {
                f.restaurar(this);
                maximizado = true;
                btnMaxRest.setText("↙");
                btnMaxRest.setToolTipText("Maximizar");
            }
        }
    }//GEN-LAST:event_formWindowStateChanged

    private void btnCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuentasActionPerformed
        if (Funciones.ventanaCerrada(panelEscritorio, lc)) {
            lc = new ListaCuentas();
            Funciones.centrar(lc, panelEscritorio);
        }
    }//GEN-LAST:event_btnCuentasActionPerformed

    private void btnArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivosActionPerformed
        accionar("archivos");
    }//GEN-LAST:event_btnArchivosActionPerformed

    private void btnArchivosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btnArchivosStateChanged
        btnArchivos.setBackground(btnArchivos.isSelected() ? normal : claro);
    }//GEN-LAST:event_btnArchivosStateChanged

    private void btnConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigActionPerformed
        accionar("config");
    }//GEN-LAST:event_btnConfigActionPerformed

    private void btnConfigStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btnConfigStateChanged
        btnConfig.setBackground(btnConfig.isSelected() ? normal : claro);
    }//GEN-LAST:event_btnConfigStateChanged

    private void btnInformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformesActionPerformed
        accionar("informes");
    }//GEN-LAST:event_btnInformesActionPerformed

    private void btnInformesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btnInformesStateChanged
        btnInformes.setBackground(btnInformes.isSelected() ? normal : claro);
    }//GEN-LAST:event_btnInformesStateChanged

    private void btnPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagosActionPerformed
        accionar("facturas");
    }//GEN-LAST:event_btnPagosActionPerformed

    private void btnPagosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btnPagosStateChanged
        btnPagos.setBackground(btnPagos.isSelected() ? normal : claro);
    }//GEN-LAST:event_btnPagosStateChanged

    private void btnLecturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLecturasActionPerformed
        accionar("lecturas");
    }//GEN-LAST:event_btnLecturasActionPerformed

    private void btnLecturasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btnLecturasStateChanged
        btnLecturas.setBackground(btnLecturas.isSelected() ? normal : claro);
    }//GEN-LAST:event_btnLecturasStateChanged

    private void btnMedidoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedidoresActionPerformed
        accionar("medidores");
    }//GEN-LAST:event_btnMedidoresActionPerformed

    private void btnMedidoresStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btnMedidoresStateChanged
        btnMedidores.setBackground(btnMedidores.isSelected() ? normal : claro);
    }//GEN-LAST:event_btnMedidoresStateChanged

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        accionar("usuarios");
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnUsuariosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btnUsuariosStateChanged
        btnUsuarios.setBackground(btnUsuarios.isSelected() ? normal : claro);
    }//GEN-LAST:event_btnUsuariosStateChanged

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        accionar("inicio");
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnInicioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btnInicioStateChanged
        btnInicio.setBackground(btnInicio.isSelected() ? normal : claro);
    }//GEN-LAST:event_btnInicioStateChanged

    private void btnCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargosActionPerformed
        accionar("cargos");
    }//GEN-LAST:event_btnCargosActionPerformed

    private void btnCargosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btnCargosStateChanged
        btnCargos.setBackground(btnCargos.isSelected() ? normal : claro);
    }//GEN-LAST:event_btnCargosStateChanged

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JToggleButton btnArchivos;
    private static javax.swing.JToggleButton btnCargos;
    private javax.swing.JButton btnCerrar;
    private static javax.swing.JToggleButton btnConfig;
    private static javax.swing.JButton btnCuentas;
    private javax.swing.JButton btnInfo;
    private static javax.swing.JToggleButton btnInformes;
    private static javax.swing.JToggleButton btnInicio;
    private static javax.swing.JToggleButton btnLecturas;
    private javax.swing.JButton btnMaxRest;
    private static javax.swing.JToggleButton btnMedidores;
    private javax.swing.JButton btnMin;
    private static javax.swing.JToggleButton btnPagos;
    private static javax.swing.JToggleButton btnUsuarios;
    private static javax.swing.JButton btnZonas;
    private javax.swing.ButtonGroup grupoMenu;
    private javax.swing.JLabel labelLogo1;
    public static javax.swing.JPanel lateralFacturas1;
    public static javax.swing.JPanel lateralInformes1;
    public static javax.swing.JPanel lateralLecturas1;
    public static javax.swing.JPanel lateralMedidores1;
    public static javax.swing.JDesktopPane panelEscritorio;
    private static javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables
}
