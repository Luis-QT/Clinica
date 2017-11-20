/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.recepcion;

import estructura.ListaDoble;
import java.awt.event.ItemEvent;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.empleado.MedicoEspecialista;
import model.paciente.Paciente;
import model.empleado.Recepcionista;
import model.paciente.Visita;

/**
 *
 * @author Luis
 */
public class FrameRecepcionAreaPacientes extends javax.swing.JDialog {

    /**
     * Creates new form RecepcionArea
     */
    private Recepcionista recepcionista;
   

    public Recepcionista getRecepcionista() {
        return recepcionista;
    }
    public ListaDoble<Paciente> listaPaciente;
    
    public ListaDoble<Visita> listaVisita = new ListaDoble<>();

    int indice = -1;
    int intemporal = -2;
    public int idcbo = -1;

    
    public FrameRecepcionAreaPacientes(java.awt.Frame parent, boolean modal, Recepcionista recepcionista) {
        super(parent, modal);
        this.setUndecorated(true);
        initComponents();
        setLocationRelativeTo(parent);
        tblPacientes.setEnabled(true);
        this.recepcionista = recepcionista;
        this.listaPaciente = this.recepcionista.getListaPaciente();
        refrescartabla(listaPaciente);

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPacientes = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRefrescar = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        cboOrdenar = new javax.swing.JComboBox<>();
        btnOrdenar = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        chxDni = new javax.swing.JCheckBox();
        chxApellido = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblcerrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pacientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Historial", "Nombre", "Apellidos", "DNI", "Edad", "Casa", "Celular", "Correo"
            }
        ));
        tblPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPacientesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblPacientesMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblPacientes);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 520, 210));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 560, 260));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Paneles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel4.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 80, 50));

        btnGuardar.setText("Guardar");
        jPanel4.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 80, 50));

        btnModificar.setText("Modificar");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel4.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 80, 50));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel4.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 80, 50));

        btnRefrescar.setText("Refrescar");
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });
        jPanel4.add(btnRefrescar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 90, 50));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, 550, 90));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ordenar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cboOrdenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombres", "Apellidos", "Edad" }));
        cboOrdenar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboOrdenarItemStateChanged(evt);
            }
        });
        cboOrdenar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboOrdenarMouseClicked(evt);
            }
        });
        cboOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboOrdenarActionPerformed(evt);
            }
        });
        jPanel8.add(cboOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 160, -1));

        btnOrdenar.setText("Ordenar");
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });
        jPanel8.add(btnOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 200, 100));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel9.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 200, -1));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel9.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        chxDni.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(chxDni);
        chxDni.setForeground(new java.awt.Color(102, 102, 102));
        chxDni.setText("DNI");
        jPanel9.add(chxDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 70, -1));

        chxApellido.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(chxApellido);
        chxApellido.setForeground(new java.awt.Color(102, 102, 102));
        chxApellido.setText("Apellidos ");
        jPanel9.add(chxApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 70, -1));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 350, 100));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 600, 530));

        jPanel5.setBackground(new java.awt.Color(75, 187, 197));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/principal/comp.png"))); // NOI18N
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/principal/titlepacientes.png"))); // NOI18N
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        lblcerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/principal/equis.png"))); // NOI18N
        lblcerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblcerrarMouseClicked(evt);
            }
        });
        jPanel5.add(lblcerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, -1, -1));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 110));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
//        FrameRecepcionAgregar AgregarVentana = new FrameRecepcionAgregar(new javax.swing.JDialog(), true, recepcionista, this);
//        AgregarVentana.setVisible(true);


    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarMouseClicked


    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
//        // TODO add your handling code here:
//        System.out.println(indice);
//        FrameRecepcionModificar AgregarModificar = new FrameRecepcionModificar(new javax.swing.JDialog(), true, recepcionista, this, listaPaciente.getDato(indice), indice);
//        AgregarModificar.setVisible(true);

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
//        // TODO add your handling code here:
//
//        recepcionista.eliminarPaciente(indice);
//        //refrescartabla(listaPaciente);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void cboOrdenarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboOrdenarMouseClicked

    }//GEN-LAST:event_cboOrdenarMouseClicked

    
    private void cboOrdenarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboOrdenarItemStateChanged
        // TODO add your handling code here:
//        idcbo = cboOrdenar.getSelectedIndex();
    }//GEN-LAST:event_cboOrdenarItemStateChanged

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
//        // TODO add your handling code here:
//        switch (idcbo) {
//            case 0:
//                recepcionista.ordenarPorNombre();
//                break;
//            case 1:
//                recepcionista.ordenarPorApellido();
//                break;
//            case 2:
//                recepcionista.ordenarPorEdad();
//                break;
//        }
//       // refrescartabla(listaPaciente);


    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

//        String palabraBuscar = txtBuscar.getText();
//        if (chxApellido.isSelected()) {
//            ListaDoble<Paciente> sp = recepcionista.buscarporApellido(palabraBuscar);
//            listaPaciente = sp;
//            refrescartabla(sp);
//        } else if (chxDni.isSelected()) {
//            ListaDoble<Paciente> sp = recepcionista.buscarporDNI(Integer.parseInt(palabraBuscar));
//            listaPaciente = sp;
//            refrescartabla(sp);
//        } else {
//            JOptionPane.showMessageDialog(null, "Seleccione una opcion");
//        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
//        // TODO add your handling code here:
//        tblPacientes.setEnabled(true);
//        listaPaciente = recepcionista.getListaPaciente();
//        //refrescartabla(listaPaciente);
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void lblcerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcerrarMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_lblcerrarMouseClicked

    private void cboOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboOrdenarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboOrdenarActionPerformed

    private void tblPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPacientesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblPacientesMouseClicked

    private void tblPacientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPacientesMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblPacientesMousePressed

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
            java.util.logging.Logger.getLogger(FrameRecepcionAreaPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameRecepcionAreaPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameRecepcionAreaPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameRecepcionAreaPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Recepcionista recepcionista = new Recepcionista();
                FrameRecepcionAreaPacientes dialog = new FrameRecepcionAreaPacientes(new javax.swing.JFrame(), true, recepcionista);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnOrdenar;
    public javax.swing.JButton btnRefrescar;
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JComboBox<String> cboOrdenar;
    public javax.swing.JCheckBox chxApellido;
    public javax.swing.JCheckBox chxDni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblcerrar;
    public javax.swing.JTable tblPacientes;
    public javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    public void refrescartabla(ListaDoble<Paciente> listaPaciente) {
                DefaultTableModel dtm = (DefaultTableModel) tblPacientes.getModel();
                dtm.setRowCount(0);
                Iterator<Paciente> iterador = listaPaciente.getDescendingIterator();
                while (iterador.hasNext()) {
                    Paciente pro = iterador.next();
                    dtm.addRow(new Object[]{pro.getCodigo(), pro.getNombre(), pro.getApellido(), pro.getDni(),
                        pro.getEdad(), pro.getTelefonoCasa(), pro.getTelefonoCelular(),
                        pro.getEmail()});
                }
    }

    public void setListaPaciente(ListaDoble<Paciente> sp) {
        listaPaciente = sp;
    
    }
}
