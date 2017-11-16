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
import model.paciente.Paciente;
import model.empleado.Recepcionista;

/**
 *
 * @author Luis
 */
public class RecepcionAreaPacientes extends javax.swing.JDialog {

    /**
     * Creates new form RecepcionArea
     */
    Recepcionista recepcionista;
    ListaDoble<Paciente> listaPaciente;
    int indice = -1;
    int intemporal = -2;

    public RecepcionAreaPacientes(java.awt.Frame parent, boolean modal, Recepcionista recepcionista) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        tblPacientes.setEnabled(true);
        this.recepcionista = recepcionista;
        this.listaPaciente = this.recepcionista.getListaPaciente();
        lblNomRecepcionista.setText(recepcionista.getNombre() + " " + recepcionista.getApellido());
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPacientes = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRefrescar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        cboOrdenar = new javax.swing.JComboBox<>();
        btnOrdenar = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        chxDni = new javax.swing.JCheckBox();
        chxApellido = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        lblNomRecepcionista = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pacientes"));
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
                "Nombres", "Apellidos", "DNI", "Sexo", "Edad", "Telefono", "Celular", "Emaill"
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
        jScrollPane1.setViewportView(tblPacientes);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 520, 210));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 560, 260));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Paneles"));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 80, 50));

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("AREA DE PACIENTES");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, -1));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordenar"));
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
        jPanel8.add(cboOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 160, -1));

        btnOrdenar.setText("Ordenar");
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });
        jPanel8.add(btnOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 200, 100));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar"));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel9.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 200, -1));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel9.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        buttonGroup1.add(chxDni);
        chxDni.setText("DNI");
        jPanel9.add(chxDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 70, -1));

        buttonGroup1.add(chxApellido);
        chxApellido.setText("Apellidos ");
        jPanel9.add(chxApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 70, -1));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 350, 100));

        jLabel2.setText("Bienvenido Recepcionista : ");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        lblNomRecepcionista.setText("AlissonCSV");
        jPanel3.add(lblNomRecepcionista, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, -1, -1));

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        RecepcionAgregar AgregarVentana = new RecepcionAgregar(new javax.swing.JDialog(), true, recepcionista, this);
        AgregarVentana.setVisible(true);


    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarMouseClicked


    private void tblPacientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPacientesMousePressed
        // TODO add your handling code here:
        
//        if(indice == -1){
//            indice = intemporal;
//            System.out.println("temoral : " + indice);
//        }else{
//           indice = tblPacientes.getSelectedRow(); 
//           System.out.println("select : " + indice);
//        }
//        
//        System.out.println("Mois pressede : " + indice);
    }//GEN-LAST:event_tblPacientesMousePressed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        System.out.println(indice);
        RecepcionModificar AgregarModificar = new RecepcionModificar(new javax.swing.JDialog(), true, recepcionista, this, listaPaciente.getDato(indice), indice);
        AgregarModificar.setVisible(true);

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:

        recepcionista.eliminarPaciente(indice);
        refrescartabla(listaPaciente);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void cboOrdenarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboOrdenarMouseClicked

    }//GEN-LAST:event_cboOrdenarMouseClicked

    int idcbo = -1;
    private void cboOrdenarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboOrdenarItemStateChanged
        // TODO add your handling code here:
        idcbo = cboOrdenar.getSelectedIndex();
    }//GEN-LAST:event_cboOrdenarItemStateChanged

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        // TODO add your handling code here:
        switch (idcbo) {
            case 0:
                recepcionista.ordenarPorNombre();
                break;
            case 1:
                recepcionista.ordenarPorApellido();
                break;
            case 2:
                recepcionista.ordenarPorEdad();
                break;
        }
        refrescartabla(listaPaciente);


    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        Paciente p = null ;
//        if(chxApellido.isSelected() ){
//            String apell = txtBuscar.getText();
//            p = recepcionista.buscarPorApellidos(apell);
//        }else if (chxDni.isSelected() ){
//            int DNI = Integer.parseInt(txtBuscar.getText());
//            p = recepcionista.buscarPorDNI(DNI);
//            System.out.println(p.getNombre());
//        }else{
//            JOptionPane.showMessageDialog(null, "Eliga una opcion.");
//        }
//        
        intemporal = indice;
        refrecartablaBuscar(p);
        tblPacientes.setEnabled(false);
        //refrescartabla(listaPaciente);
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        // TODO add your handling code here:
        tblPacientes.setEnabled(true);
        refrescartabla(listaPaciente);
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void tblPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPacientesMouseClicked
        // TODO add your handling code here:
            indice = tblPacientes.getSelectedRow(); 
        
    }//GEN-LAST:event_tblPacientesMouseClicked

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
            java.util.logging.Logger.getLogger(RecepcionAreaPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecepcionAreaPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecepcionAreaPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecepcionAreaPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Recepcionista recepcionista = new Recepcionista();
                RecepcionAreaPacientes dialog = new RecepcionAreaPacientes(new javax.swing.JFrame(), true, recepcionista);
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
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboOrdenar;
    private javax.swing.JCheckBox chxApellido;
    private javax.swing.JCheckBox chxDni;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNomRecepcionista;
    private javax.swing.JTable tblPacientes;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    void refrescartabla(ListaDoble<Paciente> listaPaciente) {
        DefaultTableModel dtm = (DefaultTableModel) tblPacientes.getModel();
        dtm.setRowCount(0);
        Iterator<Paciente> iterador = listaPaciente.getDescendingIterator();
        while (iterador.hasNext()) {
            Paciente pro = iterador.next();
            dtm.addRow(new Object[]{pro.getNombre(), pro.getApellido(), pro.getDni(),
                pro.isSexo(), pro.getEdad(), pro.getTelefonoCasa(), pro.getTelefonoCelular(),
                pro.getEmail()});
        }
    }

//     private void mostrarTabla(ListaDoble<Paciente> lista) {
//        DefaultTableModel dtm = (DefaultTableModel) tblPacientes.getModel();
//        dtm.setRowCount(0);
//        Iterator<Paciente> iterador = lista.getDescendingIterator();
//        while (iterador.hasNext()) {            
//            Paciente pro = iterador.next();
//            dtm.addRow(new Object[]{pro.getNombre(),pro.getId()});    
//        }    
//    }

    private void refrecartablaBuscar(Paciente pro) {
        DefaultTableModel dtm = (DefaultTableModel) tblPacientes.getModel();
        dtm.setRowCount(0);
        dtm.addRow(new Object[]{pro.getNombre(), pro.getApellido(), pro.getDni(),
                pro.isSexo(), pro.getEdad(), pro.getTelefonoCasa(), pro.getTelefonoCelular(),
                pro.getEmail()});
       }
}
