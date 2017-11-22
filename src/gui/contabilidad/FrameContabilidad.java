package gui.contabilidad;

import estructura.ListaDoble;
import gui.triaje.FrameTriaje;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.empleado.Cajero;
import model.empleado.MedicoTriaje;
import model.empleado.Monto;
import model.empleado.Servicios;
import model.paciente.Paciente;
//Alisson de mrd
public class FrameContabilidad extends javax.swing.JFrame {

    private ListaDoble<Servicios> listaServicios;
    private ListaDoble<Monto> listaMonto;
    private ListaDoble<Paciente> listaPacientes;

    
    // tabla Seleccion General
    private ListaDoble<Servicios> listaSeleccionGeneral;
    Cajero auxCaja = new Cajero("", "", null, 0, "", "", 0, false, 0, 0, 0, "", 0);
    
    // listas auxiliares de tabla servicios
    private ListaDoble<Servicios> listaConsultaServicios = new ListaDoble<>();
    private ListaDoble<Servicios> listaLaboratorioServicios = new ListaDoble<>();

    private Cajero Caja;

   

    public FrameContabilidad(Cajero Caja) {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        this.Caja = Caja;
        this.listaPacientes = Caja.getListaPaciente();
        this.listaServicios = Caja.getListaServicios();
        this.listaSeleccionGeneral = auxCaja.getListaServicios();
        this.listaMonto = Caja.getListaMonto();

        
    }
    public void setListaPacientes(ListaDoble<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }
    
    public ListaDoble<Paciente> getListaPacientes() {
        return listaPacientes;
    }
    
    public void setListaServicios(ListaDoble<Servicios> listaServicios) {
        this.listaServicios = listaServicios;
    }
    
    public ListaDoble<Servicios> getListaServicios() {
        return listaServicios;
    }
     
    public void setListaMonto(ListaDoble<Monto> listaServicioses) {
        this.listaMonto = listaMonto;
    }
    
    public ListaDoble<Monto> getListaMonto() {
        return listaMonto;
    }
    
     public void setListaSeleccionGeneral(ListaDoble<Servicios> listaSeleccionGeneral) {
        this.listaSeleccionGeneral = listaSeleccionGeneral;
    }
    
    public ListaDoble<Servicios> getListaSeleccionGeneral() {
        return listaSeleccionGeneral;
    }
    
    public void setListaConsultaServicios(ListaDoble<Servicios> listaConsultaServicios) {
        this.listaConsultaServicios = listaConsultaServicios;
    }
    
    public ListaDoble<Servicios> getListaConsultaServicios() {
        return listaConsultaServicios;
    }
    public void setListaLaboratorioServicios(ListaDoble<Servicios> listaLaboratorioServicios) {
        this.listaLaboratorioServicios = listaLaboratorioServicios;
    }
    
    public ListaDoble<Servicios> getListaLaboratorioServicios() {
        return listaLaboratorioServicios;
    }
    
    public Cajero getCaja() {
        return this.Caja;
    }
    

    
    
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtPago = new javax.swing.JTextField();
        txtVuelto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaServicios = new javax.swing.JTable();
        btnElegir = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnPrecio = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        rbtnConsulta = new javax.swing.JRadioButton();
        rbtnLaboratorio = new javax.swing.JRadioButton();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaSeleccion = new javax.swing.JTable();
        btnDeshacer = new javax.swing.JButton();
        btnGenerarMonto = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaRegistro = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtEntrada = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSalida = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMontoActual = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(75, 187, 197));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/conta/titlec.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 56, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/conta/pack.png"))); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(619, 22, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/principal/equis.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 164));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de Servicios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel5.setForeground(new java.awt.Color(102, 102, 102));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Pago:");

        txtPago.setForeground(new java.awt.Color(102, 102, 102));
        txtPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPagoActionPerformed(evt);
            }
        });
        txtPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPagoKeyReleased(evt);
            }
        });

        txtVuelto.setEditable(false);
        txtVuelto.setBackground(new java.awt.Color(255, 255, 255));
        txtVuelto.setForeground(new java.awt.Color(102, 102, 102));
        txtVuelto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVueltoActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Vuelto: ");

        btnRegistrar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setForeground(new java.awt.Color(102, 102, 102));
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Monto:");

        txtMonto.setEditable(false);
        txtMonto.setBackground(new java.awt.Color(255, 255, 255));
        txtMonto.setForeground(new java.awt.Color(102, 102, 102));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Código: ");

        txtCodigo.setForeground(new java.awt.Color(102, 102, 102));
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel8))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtVuelto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btnRegistrar)))
                .addGap(32, 32, 32))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtVuelto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, -1, 240));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de Servicios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel6.setForeground(new java.awt.Color(102, 102, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TablaServicios.setForeground(new java.awt.Color(102, 102, 102));
        TablaServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Servicio", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaServicios);
        if (TablaServicios.getColumnModel().getColumnCount() > 0) {
            TablaServicios.getColumnModel().getColumn(1).setPreferredWidth(30);
        }

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 300, 180));

        btnElegir.setBackground(new java.awt.Color(255, 255, 255));
        btnElegir.setForeground(new java.awt.Color(102, 102, 102));
        btnElegir.setText("Elegir");
        btnElegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirActionPerformed(evt);
            }
        });
        jPanel6.add(btnElegir, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 90, 30));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 320, 270));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de Servicios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel7.setForeground(new java.awt.Color(102, 102, 102));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBuscar.setForeground(new java.awt.Color(102, 102, 102));
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel7.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 180, -1));

        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Servicio: ");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 320, 60));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de Servicios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel8.setForeground(new java.awt.Color(102, 102, 102));

        btnPrecio.setBackground(new java.awt.Color(255, 255, 255));
        btnPrecio.setForeground(new java.awt.Color(102, 102, 102));
        btnPrecio.setText("Precio");
        btnPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrecioActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Servicio de:");

        rbtnConsulta.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbtnConsulta);
        rbtnConsulta.setForeground(new java.awt.Color(102, 102, 102));
        rbtnConsulta.setText("Consulta");
        rbtnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnConsultaActionPerformed(evt);
            }
        });

        rbtnLaboratorio.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbtnLaboratorio);
        rbtnLaboratorio.setForeground(new java.awt.Color(102, 102, 102));
        rbtnLaboratorio.setText("Laboratorio");
        rbtnLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnLaboratorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnConsulta)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(rbtnLaboratorio)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(btnPrecio)
                .addGap(26, 26, 26))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnConsulta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnLaboratorio))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(btnPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, 240, 100));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de Servicios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel12.setForeground(new java.awt.Color(102, 102, 102));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TablaSeleccion.setForeground(new java.awt.Color(102, 102, 102));
        TablaSeleccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Servicio", "Precio", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(TablaSeleccion);
        if (TablaSeleccion.getColumnModel().getColumnCount() > 0) {
            TablaSeleccion.getColumnModel().getColumn(1).setPreferredWidth(30);
            TablaSeleccion.getColumnModel().getColumn(2).setPreferredWidth(30);
        }

        jPanel12.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 16, 269, 216));

        btnDeshacer.setBackground(new java.awt.Color(255, 255, 255));
        btnDeshacer.setForeground(new java.awt.Color(102, 102, 102));
        btnDeshacer.setText("Deshacer");
        btnDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerActionPerformed(evt);
            }
        });
        jPanel12.add(btnDeshacer, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 243, 97, 33));

        btnGenerarMonto.setBackground(new java.awt.Color(255, 255, 255));
        btnGenerarMonto.setForeground(new java.awt.Color(102, 102, 102));
        btnGenerarMonto.setText("Generar Monto");
        btnGenerarMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarMontoActionPerformed(evt);
            }
        });
        jPanel12.add(btnGenerarMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 243, 113, 33));

        btnNuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo.setForeground(new java.awt.Color(102, 102, 102));
        btnNuevo.setText("Nuevo Cliente");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel12.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 294, -1, 30));

        jPanel3.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 300, 340));

        jTabbedPane2.addTab("Caja", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(102, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Monto Acumulado en el día", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel10.setForeground(new java.awt.Color(102, 102, 102));

        tablaRegistro.setForeground(new java.awt.Color(102, 102, 102));
        tablaRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código", "Monto Recaudado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaRegistro);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 11, -1, 360));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Monto Acumulado en el día", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel9.setForeground(new java.awt.Color(102, 102, 102));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Entrada : ");

        txtEntrada.setEditable(false);
        txtEntrada.setBackground(new java.awt.Color(255, 255, 255));
        txtEntrada.setForeground(new java.awt.Color(102, 102, 102));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Salida : ");

        txtSalida.setEditable(false);
        txtSalida.setBackground(new java.awt.Color(255, 255, 255));
        txtSalida.setForeground(new java.awt.Color(102, 102, 102));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Monto Actual : ");

        txtMontoActual.setEditable(false);
        txtMontoActual.setBackground(new java.awt.Color(255, 255, 255));
        txtMontoActual.setForeground(new java.awt.Color(102, 102, 102));
        txtMontoActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActualActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMontoActual))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMontoActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/conta/ca1t.png"))); // NOI18N
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/conta/asd.png"))); // NOI18N
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, -1, -1));

        jTabbedPane2.addTab("Cuentas", jPanel4);

        jPanel1.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 940, 410));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 596));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtVueltoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVueltoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVueltoActionPerformed

    private void btnElegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirActionPerformed

//        if (rbtnConsulta.isSelected()) {
//            int t = TablaServicios.getSelectedRow();
//            Servicios set = listaConsultaServicios.getDato(t);
//
//            listaSeleccionGeneral.insertarAlFinal(set);
//
//            
//            mostrarTablaSeleccion(listaSeleccionGeneral);
//        } else if (rbtnLaboratorio.isSelected()) {
//
//            int t = TablaServicios.getSelectedRow();
//            Servicios set = listaLaboratorioServicios.getDato(t);
//
//            listaSeleccionGeneral.insertarAlFinal(set);
//
//         
//            mostrarTablaSeleccion(listaSeleccionGeneral);
//
//        } else {
//            int i = TablaServicios.getSelectedRow();
//            Servicios set = listaServicios.getDato(i);
//
//            listaSeleccionGeneral.insertarAlFinal(set);
//
//            
//            mostrarTablaSeleccion(listaSeleccionGeneral);
//
//        }
        

        // TODO add your handling code here:
    }//GEN-LAST:event_btnElegirActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed


    private void rbtnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnConsultaActionPerformed
        //ListaDoble<Servicios>  aux = new ListaDoble<>();
//        if (rbtnConsulta.isSelected()) {
//            listaConsultaServicios = Caja.ordenarporConsultas();
//            mostrarTablaServicios(listaConsultaServicios);
//        }

        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnConsultaActionPerformed

    private void rbtnLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnLaboratorioActionPerformed
        
//        if (rbtnLaboratorio.isSelected()) {
//            listaLaboratorioServicios = Caja.ordenarporLaboratorio();
//            mostrarTablaServicios(listaLaboratorioServicios);
//        }

        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnLaboratorioActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased

//        String palabra = txtBuscar.getText();
//        
//        ListaDoble<Servicios> p = Caja.bucarServicio(palabra);
//        
//           listaServicios = p;  
//               mostrarTablaServicios(listaServicios);
//        
//        //
//        

        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrecioActionPerformed
//
//        listaServicios = Caja.ordenarPrecios();
//        mostrarTablaServicios(listaServicios);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrecioActionPerformed

    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed

//         int i = TablaSeleccion.getSelectedRow();
//        listaSeleccionGeneral.eliminarPos(i);
//        mostrarTablaSeleccion(listaSeleccionGeneral);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeshacerActionPerformed

    private void btnGenerarMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarMontoActionPerformed
   
//        int cant = TablaSeleccion.getRowCount();
//        int i = 0;
//        Float suma = 0F;
//        while (cant > i) {
//
//            suma = suma + ((Float) TablaSeleccion.getValueAt(i, 1) * (Float) TablaSeleccion.getValueAt(i, 2));
//
//            i++;
//        }

          
//        txtMonto.setText(String.valueOf(suma));
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerarMontoActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtPagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoKeyReleased
//          Float pago = Float.parseFloat(txtPago.getText());
//          Float monto = Float.parseFloat(txtMonto.getText());
//          Float vuelto = pago - monto;
//          
//          txtVuelto.setText(String.valueOf(vuelto));

        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagoKeyReleased

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

//        GregorianCalendar d = new GregorianCalendar();
//
//        int anio = d.get(Calendar.YEAR);
//        int mes = d.get(Calendar.MONTH) + 1;
//        int dia = d.get(Calendar.DAY_OF_MONTH);
//        LocalDate fecha = LocalDate.of(anio, mes, dia);
//        // txt de entrada
//        String codigo = txtCodigo.getText();
//        Float pago = Float.parseFloat(txtPago.getText());
//        Float monto = Float.parseFloat(txtMonto.getText());
//        Float vuelto = Float.parseFloat(txtVuelto.getText());
//        boolean comprobar = false;
//
//        Iterator<Paciente> iterador = listaPacientes.getDescendingIterator();
//
//        while (iterador.hasNext()) {
//            Paciente pro = iterador.next();
//
//            if (pro.getCodigo().equalsIgnoreCase(codigo)) {
//                comprobar = true;
//                thisFrameTriaje.getListaPacientes().insertarAlFinal(pro);
//                //Te envia el codigo ;
//                
//            }
//        }
//
//        if (comprobar) {
//            Monto reg = new Monto(monto, pago, vuelto, fecha);
//
//            Caja.agregarMonto(reg);
//            mostrarTablaRegistro(listaMonto, listaPacientes);
//
//            // para mostar monto de salida
//            Iterator<Monto> it = listaMonto.getDescendingIterator();
//            Float sumaMontoEntrada = 0F;
//            Float sumaMontoSalida = 0F;
//            Float sumaMontoActual = 0F;
//
//            while (it.hasNext()) {
//                Monto pro = it.next();
//                sumaMontoEntrada = sumaMontoEntrada + pro.getPago();
//                sumaMontoSalida = sumaMontoSalida + pro.getVuelto();
//                sumaMontoActual = sumaMontoActual + pro.getMonto();
//            }
//            txtEntrada.setText(String.valueOf(sumaMontoEntrada));
//            txtSalida.setText(String.valueOf(sumaMontoSalida));
//            txtMontoActual.setText(String.valueOf(sumaMontoActual));
            /**COMPROBAR*/
            
//            this.thisFrameTriaje.setVisible(true);
//            this.thisFrameTriaje.mostrarTabla();
            
//        } else {
//            JOptionPane.showMessageDialog(null, "Codigo: " + codigo + " no registrado");
//        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

//        txtMonto.setText("");
//        txtPago.setText("");
//        txtVuelto.setText("");
//        txtCodigo.setText("");
//        listaSeleccionGeneral.limpiarLista();
//        
//        mostrarTablaSeleccion(listaSeleccionGeneral);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtMontoActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoActualActionPerformed

    private void txtPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagoActionPerformed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    public void mostrarTablaServicios(ListaDoble<Servicios> listaServicio) {
        DefaultTableModel dtm = (DefaultTableModel) TablaServicios.getModel();
        dtm.setRowCount(0);
        Iterator<Servicios> iterador = listaServicio.getDescendingIterator();

        while (iterador.hasNext()) {
            Servicios pro = iterador.next();

            dtm.addRow(new Object[]{pro.getNombreServicio(), pro.getPrecio()});
        }
        
    }

    public void mostrarTablaSeleccion(ListaDoble<Servicios> listaServicio) {
        DefaultTableModel dtm = (DefaultTableModel) TablaSeleccion.getModel();
        dtm.setRowCount(0);
        Iterator<Servicios> iterador = listaServicio.getDescendingIterator();

        while (iterador.hasNext()) {
            Servicios pro = iterador.next();
            Float cant = 1.F;
            dtm.addRow(new Object[]{pro.getNombreServicio(), pro.getPrecio(), cant});
        }
     
    }
    
    
    
    public void mostrarTablaRegistro(ListaDoble<Monto> listaMonto, ListaDoble<Paciente> listaPaciente) {
        DefaultTableModel dtm = (DefaultTableModel) tablaRegistro.getModel();
        dtm.setRowCount(0);
        Iterator<Monto> iterador = listaMonto.getDescendingIterator();
        String palabra = txtCodigo.getText();
        
        while (iterador.hasNext()) {
           Monto pro = iterador.next();
          
            dtm.addRow(new Object[]{palabra , pro.getMonto()});
        }
    
   }

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameContabilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameContabilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameContabilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameContabilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        Cajero Caja = new Cajero("5694", "contraseña", null, 13, "Mónica",
                "Blanco", 77777777, false, 42, 555555, 999999, "mb@ail.com", 0);
        /* Create and display the form */
;

    MedicoTriaje triaje = new MedicoTriaje("triaje", "5694", "contraseña", null, 13, "Mónica",
                "Blanco", 77777777, false, 42, 555555, 999999, "mb@ail.com", 0);

        FrameTriaje ft = new FrameTriaje(triaje);

        Caja.agregarServicios(new Servicios("sangre", 230F, false));
        Caja.agregarServicios(new Servicios("glusoca", 250F, false));
        Caja.agregarServicios(new Servicios("cardiologo", 10F, true));
        Caja.agregarServicios(new Servicios("neurologo", 30F, true));
        Caja.agregarServicios(new Servicios("medico general", 5F, true));
//        Caja.agregarPaciente(new Paciente(0, "Luis", "Luis", 1111, true, 21, 98766, 64564, "", 2, "A", "No hay","A04"));
//        Caja.agregarPaciente(new Paciente(0, "Yauri", "Yauri", 2222, true, 21, 98766, 64564, "", 2, "A", "No hay","A05"));
//        Caja.agregarPaciente(new Paciente(0, "Miriam", "Miriam", 3333, true, 21, 98766, 64564, "", 2, "A", "No hay","A06"));
//        Caja.agregarPaciente(new Paciente(0, "Mizu", "Mizu", 4444, true, 21, 98766, 64564, "", 2, "A", "No hay","A07"));
//        Caja.agregarPaciente(new Paciente(0, "LuisJose", "LuisJose", 5555, true, 21, 98766, 64564, "", 2, "A", "No hay","A08"));
//       Caja.agregarPaciente(new Paciente(0, "LuisRoberto", "LuisRoberto", 6666, true, 21, 98766, 64564, "", 2, "A", "No hay","A09"));
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                // ft
                new FrameContabilidad(Caja).setVisible(true);

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TablaSeleccion;
    public javax.swing.JTable TablaServicios;
    public javax.swing.JButton btnDeshacer;
    public javax.swing.JButton btnElegir;
    public javax.swing.JButton btnGenerarMonto;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnPrecio;
    public javax.swing.JButton btnRegistrar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    public javax.swing.JRadioButton rbtnConsulta;
    public javax.swing.JRadioButton rbtnLaboratorio;
    public javax.swing.JTable tablaRegistro;
    public javax.swing.JTextField txtBuscar;
    public javax.swing.JTextField txtCodigo;
    public javax.swing.JTextField txtEntrada;
    public javax.swing.JTextField txtMonto;
    public javax.swing.JTextField txtMontoActual;
    public javax.swing.JTextField txtPago;
    public javax.swing.JTextField txtSalida;
    public javax.swing.JTextField txtVuelto;
    // End of variables declaration//GEN-END:variables
}
