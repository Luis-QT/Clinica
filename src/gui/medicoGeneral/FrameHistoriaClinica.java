/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.medicoGeneral;

import estructura.ListaDoble;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import model.paciente.Anamnesis;
import model.paciente.AntecedentesFamiliares;
import model.paciente.AntecedentesPersonales;
import model.paciente.DatosMedico;
import model.paciente.DatosPaciente;
import model.paciente.Diagnostico;
import model.paciente.ExamenFisicos;
import model.paciente.HistoriaClinica;
import model.paciente.Paciente;
import model.paciente.Tratamiento;
import model.paciente.TratamientoRea;
import model.paciente.Visita;

/**
 *
 * @author luis
 */
public class FrameHistoriaClinica extends javax.swing.JFrame {

    /**
     * Creates new form historiaClinica2
     */
    public FrameHistoriaClinica() {
        initComponents();
    }
    
    Paciente paciente;
    ListaDoble<Visita> listaVisita ;
    public FrameHistoriaClinica(Paciente paciente ,ListaDoble<Visita> listaVisita) {
        initComponents();
        this.listaVisita = listaVisita;
        this.paciente = paciente;
        llenarDatos();
    }
    
    /**TEMPORAL**/
     public FrameHistoriaClinica(Paciente paciente) {
        initComponents();
         this.paciente = paciente;
         this.listaVisita = paciente.getHistorial().getListaVisitas();
         llenarDatos();
    }
    
    AntecedentesFamiliares antefa = new AntecedentesFamiliares();
    AntecedentesPersonales antepe = new AntecedentesPersonales();
    DatosPaciente datopa = new DatosPaciente();
    
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelDatosPaciente = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jTexApellido = new javax.swing.JTextField();
        jTextNombre = new javax.swing.JTextField();
        jRadioButtonMasculino = new javax.swing.JRadioButton();
        jRadioButtonFeminino = new javax.swing.JRadioButton();
        jLabel35 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTextDNI = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jRadioButtonNoble = new javax.swing.JRadioButton();
        jRadioButton14 = new javax.swing.JRadioButton();
        jLabel36 = new javax.swing.JLabel();
        txtFijo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        txtReligion = new javax.swing.JTextField();
        jButtonIngresarPaciente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTipoSangre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAlergias = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jTextFieldEnfermedadesTratadas = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jTextFieldHospitalizaciones = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jTextFieldInmunizaciones = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jTextFielTipoSangre = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jTextFieldAlergias = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jTextFieldPadreEnfermedades1 = new javax.swing.JTextField();
        jTextFieldPadreHos1 = new javax.swing.JTextField();
        jRadioButtonVivoP1 = new javax.swing.JRadioButton();
        jRadioButtonMuertoP1 = new javax.swing.JRadioButton();
        jTextFieldMadreEnf1 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jRadioButtonMuertoM1 = new javax.swing.JRadioButton();
        jTextFieldMadreHos1 = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jRadioButtonVivoM1 = new javax.swing.JRadioButton();
        jLabel62 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVisitas = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        btnAgregarVisita = new javax.swing.JButton();
        btnVerVisita = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel31.setText("Nombre");

        jLabel34.setText("Apellido");

        jLabel32.setText("Edad");

        buttonGroup1.add(jRadioButtonMasculino);
        jRadioButtonMasculino.setText("Masculino");
        jRadioButtonMasculino.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jRadioButtonMasculinoAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jRadioButtonMasculino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonMasculinoMouseClicked(evt);
            }
        });
        jRadioButtonMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMasculinoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonFeminino);
        jRadioButtonFeminino.setText("Femenino");
        jRadioButtonFeminino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonFemininoMouseClicked(evt);
            }
        });
        jRadioButtonFeminino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonFemininoActionPerformed(evt);
            }
        });

        jLabel35.setText("DNI");

        jLabel33.setText("Sexo");

        jTextDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDNIActionPerformed(evt);
            }
        });

        jLabel38.setText("Direccion");

        jLabel45.setText("Vivienda");

        buttonGroup7.add(jRadioButtonNoble);
        jRadioButtonNoble.setText("Material Noble");
        jRadioButtonNoble.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonNobleMouseClicked(evt);
            }
        });
        jRadioButtonNoble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNobleActionPerformed(evt);
            }
        });

        buttonGroup7.add(jRadioButton14);
        jRadioButton14.setText("Servicios basicos");
        jRadioButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton14MouseClicked(evt);
            }
        });
        jRadioButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton14ActionPerformed(evt);
            }
        });

        jLabel36.setText("Teléfono Fijo");

        txtFijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFijoActionPerformed(evt);
            }
        });

        jLabel2.setText("Teléfono Celular");

        jLabel44.setText("Religion");

        txtReligion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReligionActionPerformed(evt);
            }
        });

        jButtonIngresarPaciente.setText("Ingresar Datos");
        jButtonIngresarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIngresarPacienteActionPerformed(evt);
            }
        });

        jLabel3.setText("Código");

        jLabel4.setText("E - mail");

        jLabel5.setText("Tipo de Sangre");

        jLabel6.setText("Alergias");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(jLabel34)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel35)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jRadioButtonMasculino)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jRadioButtonFeminino))
                                .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTipoSangre, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                .addComponent(jTexApellido))
                            .addComponent(txtAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel45)
                            .addComponent(jLabel36)
                            .addComponent(jLabel2)
                            .addComponent(jLabel44)
                            .addComponent(jLabel38))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jRadioButtonNoble)
                                    .addGap(18, 18, 18)
                                    .addComponent(jRadioButton14)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtReligion, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCelular, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtFijo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)))
                        .addGap(66, 66, 66))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonIngresarPaciente)
                        .addGap(113, 113, 113))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(jTexApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(jRadioButtonMasculino)
                            .addComponent(jRadioButtonFeminino))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTipoSangre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45)
                            .addComponent(jRadioButton14)
                            .addComponent(jRadioButtonNoble))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(txtFijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel38))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel44))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtReligion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel35))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonIngresarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelDatosPacienteLayout = new javax.swing.GroupLayout(jPanelDatosPaciente);
        jPanelDatosPaciente.setLayout(jPanelDatosPacienteLayout);
        jPanelDatosPacienteLayout.setHorizontalGroup(
            jPanelDatosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosPacienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanelDatosPacienteLayout.setVerticalGroup(
            jPanelDatosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosPacienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Datos del Paciente", jPanelDatosPaciente);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Antecedentes Personales"));

        jLabel42.setText("Enfermedades Tratadas");

        jLabel46.setText("Hospitalizaciones");

        jLabel43.setText("Inmunisaciones");

        jLabel48.setText("Tipo de Sangre");

        jLabel47.setText("ALERGIAS");

        jButton2.setText("Ingresar Datos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addComponent(jLabel46)
                            .addComponent(jLabel43)
                            .addComponent(jLabel47)
                            .addComponent(jLabel48))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldEnfermedadesTratadas, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFielTipoSangre, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldInmunizaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldHospitalizaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jTextFieldEnfermedadesTratadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jTextFieldHospitalizaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jTextFieldInmunizaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jTextFielTipoSangre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(jTextFieldAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(jButton2)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Antecedentes Familiares"));

        jLabel54.setText("Padre");

        jLabel55.setText("Hospitalizacion");

        jLabel59.setText("Enfermedades");

        buttonGroup4.add(jRadioButtonVivoP1);
        jRadioButtonVivoP1.setText("Vivo");
        jRadioButtonVivoP1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonVivoP1MouseClicked(evt);
            }
        });
        jRadioButtonVivoP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonVivoP1ActionPerformed(evt);
            }
        });

        buttonGroup4.add(jRadioButtonMuertoP1);
        jRadioButtonMuertoP1.setText("Muerto");
        jRadioButtonMuertoP1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonMuertoP1MouseClicked(evt);
            }
        });

        jLabel60.setText("Hospitalizacion");

        buttonGroup5.add(jRadioButtonMuertoM1);
        jRadioButtonMuertoM1.setText("Muerto");
        jRadioButtonMuertoM1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonMuertoM1MouseClicked(evt);
            }
        });

        jLabel61.setText("Enfermedades");

        buttonGroup5.add(jRadioButtonVivoM1);
        jRadioButtonVivoM1.setText("Vivo");
        jRadioButtonVivoM1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonVivoM1MouseClicked(evt);
            }
        });
        jRadioButtonVivoM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonVivoM1ActionPerformed(evt);
            }
        });

        jLabel62.setText("Madre");

        jButton5.setText("Ingresar Datos");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel60)
                    .addComponent(jButton5)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel54)
                            .addComponent(jLabel59)
                            .addComponent(jLabel55)
                            .addComponent(jLabel62)
                            .addComponent(jLabel61))
                        .addGap(64, 64, 64)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPadreHos1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPadreEnfermedades1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jRadioButtonVivoP1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonMuertoP1))
                            .addComponent(jTextFieldMadreEnf1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jRadioButtonVivoM1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonMuertoM1))
                            .addComponent(jTextFieldMadreHos1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(jRadioButtonVivoP1)
                    .addComponent(jRadioButtonMuertoP1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jTextFieldPadreEnfermedades1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(jTextFieldPadreHos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(jRadioButtonVivoM1)
                    .addComponent(jRadioButtonMuertoM1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(jTextFieldMadreEnf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(jTextFieldMadreHos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jButton5)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Antecedentes ", jPanel9);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabla de Visitas"));

        tblVisitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Fecha", "Visita"
            }
        ));
        jScrollPane1.setViewportView(tblVisitas);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Botones"));

        btnAgregarVisita.setText("Agregar Visita");
        btnAgregarVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarVisitaActionPerformed(evt);
            }
        });

        btnVerVisita.setText("Ver Visita");
        btnVerVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerVisitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVerVisita)
                    .addComponent(btnAgregarVisita))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnAgregarVisita)
                .addGap(18, 18, 18)
                .addComponent(btnVerVisita)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Visitas", jPanel3);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addGap(20, 20, 20))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 810, 450));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setText("Historial Clínico");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(286, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(21, 21, 21))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 810, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIngresarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresarPacienteActionPerformed
        datopa.setNombre(jTextNombre.getText());
        datopa.setApellido(jTexApellido.getText());
        datopa.setEdad(Integer.parseInt(txtEdad.getText()));
        datopa.setDNI(Integer.parseInt(jTextDNI.getText()));
        datopa.setDireccion(txtDireccion.getText());
        datopa.setTelefono(Integer.parseInt(txtFijo.getText()));
        datopa.setReligion(txtReligion.getText());

    }//GEN-LAST:event_jButtonIngresarPacienteActionPerformed

    private void jRadioButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton14ActionPerformed

    private void jRadioButton14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton14MouseClicked
        datopa.setServiciosba(jRadioButton14.getLabel());
    }//GEN-LAST:event_jRadioButton14MouseClicked

    private void jRadioButtonNobleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonNobleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonNobleActionPerformed

    private void jRadioButtonNobleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonNobleMouseClicked
        datopa.setTipovivienda(jRadioButtonNoble.getLabel());

    }//GEN-LAST:event_jRadioButtonNobleMouseClicked

    private void txtReligionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReligionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReligionActionPerformed

    private void txtFijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFijoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFijoActionPerformed

    private void jTextDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDNIActionPerformed

    private void jRadioButtonFemininoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonFemininoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonFemininoActionPerformed

    private void jRadioButtonFemininoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonFemininoMouseClicked
        datopa.setSexo(jRadioButtonFeminino.getLabel());
    }//GEN-LAST:event_jRadioButtonFemininoMouseClicked

    private void jRadioButtonMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMasculinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMasculinoActionPerformed

    private void jRadioButtonMasculinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonMasculinoMouseClicked
        datopa.setSexo(jRadioButtonMasculino.getLabel());
    }//GEN-LAST:event_jRadioButtonMasculinoMouseClicked

    private void jRadioButtonMasculinoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jRadioButtonMasculinoAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMasculinoAncestorAdded

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jRadioButtonVivoM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonVivoM1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonVivoM1ActionPerformed

    private void jRadioButtonVivoM1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonVivoM1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonVivoM1MouseClicked

    private void jRadioButtonMuertoM1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonMuertoM1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMuertoM1MouseClicked

    private void jRadioButtonMuertoP1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonMuertoP1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMuertoP1MouseClicked

    private void jRadioButtonVivoP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonVivoP1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonVivoP1ActionPerformed

    private void jRadioButtonVivoP1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonVivoP1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonVivoP1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        antepe.setEnferTra(jTextFieldEnfermedadesTratadas.getText());
//        antepe.setHospitalizaciones(Integer.parseInt(jTextFieldHospitalizaciones.getText()));
//        antepe.setInmunizacion(Integer.parseInt(jTextFieldInmunizaciones.getText()));
//        antepe.setTipoSangre(jTextFielTipoSangre.getText());
//        antepe.setAlergias(jTextFieldAlergias.getText());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnVerVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerVisitaActionPerformed
        try{
            int posicion;
            posicion = tblVisitas.getSelectedRow();
            System.out.println("lista visita es ta vacía?: " + listaVisita);
            Visita visita = listaVisita.getDato(posicion);
            VentanaVisita ventanaVisita = new VentanaVisita(this, true,paciente.getHistorial(), this);
            ventanaVisita.setVisible(true);
            
        }catch(Exception e){
            System.out.println(e);
                    
        }
    }//GEN-LAST:event_btnVerVisitaActionPerformed

    private void btnAgregarVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarVisitaActionPerformed
        // TODO add your handling code here:
        VentanaVisita ventanaVisita = new VentanaVisita(this, true,paciente.getHistorial(), this);
        ventanaVisita.setVisible(true);
        
    }//GEN-LAST:event_btnAgregarVisitaActionPerformed

    public void mostrarTabla() {
        DefaultTableModel dtm = (DefaultTableModel) tblVisitas.getModel();
        dtm.setRowCount(0);
        Iterator<Visita> iterador = listaVisita.getDescendingIterator();
        while (iterador.hasNext()) {            
            Visita pro = iterador.next();
            dtm.addRow(new Object[]{pro.mostrarFecha(),pro.getCodigo()});    
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
            java.util.logging.Logger.getLogger(FrameHistoriaClinica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameHistoriaClinica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameHistoriaClinica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameHistoriaClinica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameHistoriaClinica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarVisita;
    private javax.swing.JButton btnVerVisita;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonIngresarPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelDatosPaciente;
    private javax.swing.JRadioButton jRadioButton14;
    private javax.swing.JRadioButton jRadioButtonFeminino;
    private javax.swing.JRadioButton jRadioButtonMasculino;
    private javax.swing.JRadioButton jRadioButtonMuertoM1;
    private javax.swing.JRadioButton jRadioButtonMuertoP1;
    private javax.swing.JRadioButton jRadioButtonNoble;
    private javax.swing.JRadioButton jRadioButtonVivoM1;
    private javax.swing.JRadioButton jRadioButtonVivoP1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTextField jTexApellido;
    public javax.swing.JTextField jTextDNI;
    private javax.swing.JTextField jTextFielTipoSangre;
    private javax.swing.JTextField jTextFieldAlergias;
    private javax.swing.JTextField jTextFieldEnfermedadesTratadas;
    private javax.swing.JTextField jTextFieldHospitalizaciones;
    private javax.swing.JTextField jTextFieldInmunizaciones;
    private javax.swing.JTextField jTextFieldMadreEnf1;
    private javax.swing.JTextField jTextFieldMadreHos1;
    private javax.swing.JTextField jTextFieldPadreEnfermedades1;
    private javax.swing.JTextField jTextFieldPadreHos1;
    public javax.swing.JTextField jTextNombre;
    private javax.swing.JTable tblVisitas;
    private javax.swing.JTextField txtAlergias;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCodigo;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtFijo;
    public javax.swing.JTextField txtReligion;
    private javax.swing.JTextField txtTipoSangre;
    // End of variables declaration//GEN-END:variables

    private void llenarDatos() {
        jTextNombre.setText(paciente.getNombre());
        jTexApellido.setText(paciente.getApellido());
        txtEdad.setText(String.valueOf(paciente.getEdad()));
        txtTipoSangre.setText(paciente.getTipoSangre());
        txtAlergias.setText(paciente.getAlergia());
        jTextDNI.setText(String.valueOf(paciente.getDni()));
        txtCodigo.setText(paciente.getCodigo());
        txtEmail.setText(paciente.getEmail());
        txtDireccion.setText(paciente.getDireccion());
        txtFijo.setText(String.valueOf(paciente.getTelefonoCasa()));
        txtCelular.setText(String.valueOf(paciente.getTelefonoCelular()));
        txtReligion.setText(paciente.getReligion());
        
        
    }
}
