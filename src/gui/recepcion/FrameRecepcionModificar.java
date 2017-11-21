/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.recepcion;

import estructura.ListaDoble;
import java.util.Iterator;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import model.empleado.Persona;
import model.paciente.Paciente;
import model.empleado.Recepcionista;

/**
 *
 * @author Luis
 */
public class FrameRecepcionModificar extends javax.swing.JDialog {

    /**
     * Creates new form RecepcionAgregar1
     */
    Recepcionista recepcionista;
    FrameRecepcionAreaPacientes aThis;
    public int indice;
    
    public FrameRecepcionModificar(javax.swing.JDialog parent, boolean modal, Recepcionista recepcionista, FrameRecepcionAreaPacientes aThis,Paciente pers) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.recepcionista = recepcionista;
        this.aThis = aThis;
        this.indice = indice;
        
        txtnombres.setText(pers.getNombre());
        txtApellidos.setText(pers.getApellido());
        txtDNI.setText(String.valueOf(pers.getDni()));
        txtedad.setText(String.valueOf(pers.getEdad()));
        txttelefono.setText(String.valueOf(pers.getTelefonoCasa()));
        txtcelular.setText(String.valueOf(pers.getTelefonoCelular()));
        txtcorreo.setText(pers.getEmail());
        boolean sexo = pers.isSexo();
        if(sexo == true){
            chkM.setSelected(true);
        }
        if(sexo == false){
            chkF.setSelected(true);
        }
//        txtHistoriaClinica.setText(String.valueOf(pers.getHistorial()));
//        
//        txtTipoServicio.setText(pers.getHistorial().getListaVisitas().getFin().getDato().getServicio());
//        
//        cbxServicio.setSelectedItem("HolaMundo");
    
    }

    public Recepcionista getRecepcionista() {
        return recepcionista;
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
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        txtnombres = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtedad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtcelular = new javax.swing.JTextField();
        chkM = new javax.swing.JCheckBox();
        chkF = new javax.swing.JCheckBox();
        txtcorreo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCodigoPaciente = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtTipoServicio = new javax.swing.JTextField();
        txtNombreDoctor = new javax.swing.JTextField();
        txtEspecialidad = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Apellidos :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));
        jPanel2.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 140, -1));
        jPanel2.add(txtnombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 140, -1));

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Nombres :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        txtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDNIKeyPressed(evt);
            }
        });
        jPanel2.add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 140, -1));

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("DNI :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Sexo :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));
        jPanel2.add(txtedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 140, -1));

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Edad :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));
        jPanel2.add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 140, -1));

        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Telefono :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Celular :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));
        jPanel2.add(txtcelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 140, -1));

        chkM.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(chkM);
        chkM.setForeground(new java.awt.Color(102, 102, 102));
        chkM.setText("M");
        jPanel2.add(chkM, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        chkF.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(chkF);
        chkF.setForeground(new java.awt.Color(102, 102, 102));
        chkF.setText("F");
        jPanel2.add(chkF, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));
        jPanel2.add(txtcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 140, -1));

        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Correo :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Código Paciente");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        txtCodigoPaciente.setEditable(false);
        jPanel2.add(txtCodigoPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 140, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 320, 310));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Elegir", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Servicio :");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel12.setText("Doctor :");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel13.setText("Especialidad : ");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));
        jPanel4.add(txtTipoServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 130, -1));
        jPanel4.add(txtNombreDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 130, -1));
        jPanel4.add(txtEspecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 130, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 260, 200));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar.setForeground(new java.awt.Color(102, 102, 102));
        btnCancelar.setText("Cancelar");
        jPanel5.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, 50));

        btnLimpiar.setForeground(new java.awt.Color(102, 102, 102));
        btnLimpiar.setText("Limpiar");
        jPanel5.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, 50));

        btnModificar.setForeground(new java.awt.Color(102, 102, 102));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel5.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 50));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 260, 100));

        jPanel3.setBackground(new java.awt.Color(75, 187, 197));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/principal/PANEL PACIENTE.png"))); // NOI18N

        btnCerrar.setBackground(new java.awt.Color(255, 255, 255));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/principal/equis.png"))); // NOI18N
        btnCerrar.setToolTipText("");
        btnCerrar.setBorderPainted(false);
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(264, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 120));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1AncestorAdded

    private void txtDNIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyPressed
        // TODO add your handling code here:

        txtCodigoPaciente.setText("H0" + txtDNI.getText());

    }//GEN-LAST:event_txtDNIKeyPressed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:

        //Datos Paciente
//        String nombre = txtnombres.getText();
//        String apellido = txtApellidos.getText();
//        int dni = Integer.parseInt(txtDNI.getText());
//        boolean sexo = false;
//        if (chkF.isSelected()) {
//            sexo = false;
//        }
//        if (chkM.isSelected()) {
//            sexo = true;
//        }
//        int edad = Integer.parseInt(txtedad.getText());
//        int telCasa = Integer.parseInt(txttelefono.getText());
//        int telCelular = Integer.parseInt(txtcelular.getText());
//        String correo = txtcorreo.getText();
//        String codigoHistoria = txtHistoriaClinica.getText();
//        //Fin datos paciente
//
//        switch (cbxServicio.getSelectedIndex()) {
//            case 0:
//                break;
//            case 1:
//                break;
//            case 2:
//                break;
//            case 3:
//                break;
//        }
//
//        Paciente p = new Paciente(0, nombre, apellido, dni, sexo, edad, telCasa, telCelular, correo, 1, "", "", codigoHistoria);
//
//        recepcionista.agregarPaciente(p);
        
        

        //recepcionista.agregarPaciente(0, nombre, apellido, dni, sexo, edad, telCasa, telCelular, correo, "", "", codigoHistoria);
        //aThis.refrescartabla(recepcionista.getListaPaciente());
        //System.out.println(recepcionista.toString());
        //this.setVisible(false);


    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCerrarActionPerformed

  
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
            java.util.logging.Logger.getLogger(FrameRecepcionModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameRecepcionModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameRecepcionModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameRecepcionModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                
                FrameRecepcionModificar dialog = new FrameRecepcionModificar(new javax.swing.JDialog(), true, recepcionista, null, null);
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
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnCerrar;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnModificar;
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JCheckBox chkF;
    public javax.swing.JCheckBox chkM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    public javax.swing.JTextField txtApellidos;
    public javax.swing.JTextField txtCodigoPaciente;
    public javax.swing.JTextField txtDNI;
    public javax.swing.JTextField txtEspecialidad;
    public javax.swing.JTextField txtNombreDoctor;
    public javax.swing.JTextField txtTipoServicio;
    public javax.swing.JTextField txtcelular;
    public javax.swing.JTextField txtcorreo;
    public javax.swing.JTextField txtedad;
    public javax.swing.JTextField txtnombres;
    public javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
