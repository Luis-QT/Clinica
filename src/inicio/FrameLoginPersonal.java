/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicio;

import estructura.ListaDoble;
import gui.recepcion.FrameRecepcionPrincipal;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import model.empleado.Cajero;
import model.empleado.MedicoEspecialista;
import model.empleado.MedicoTriaje;
import model.empleado.Recepcionista;
import model.empleado.Servicios;
import model.paciente.Anamnesis;
import model.paciente.DatosMedico;
import model.paciente.Diagnostico;
import model.paciente.ExamenFisicos;
import model.paciente.Paciente;
import model.paciente.TemporadaTratamiento;
import model.paciente.TratamientoRea;
import model.paciente.Visita;

/**
 *
 * @author Luis
 */
public class FrameLoginPersonal extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    Recepcionista recepcionista;
    MedicoEspecialista medicoEspecialista;
    MedicoTriaje medicoTriaje;
    Cajero cajero;

    public FrameLoginPersonal() {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        //Personales
        //de la bd extraigo la orimera persona de la taBLA RECEPCIONISTA 
        //GUARDO EN UN OBJETO RECEPCIONISTA.  recepcionista
        
        
        
        
        recepcionista = new Recepcionista("123", "345", null, 12, "Luis", "Yauri", 98877, true, 35, 234324, 123, "@gamil.com", 1);
       
        
        medicoEspecialista = new MedicoEspecialista("Cardiólogo", "Colegiatura", "1234", "contraseña", null, 21, "Carlos", "Sanchez", 9098, true, 32, 9563212, 6411452, "carlos@gmail.com", 0);
        cajero = new Cajero("1234", "contraseña", null, 21, "Carlos", "Sanchez", 9098, true, 32, 9563212, 6411452, "carlos@gmail.com", 0);
        medicoTriaje = new MedicoTriaje("triaje", "5694", "contraseña",
                null, 13, "Mónica", "Blanco", 77777777, false, 42, 555555,
                999999, "mb@ail.com", 0);
        //Fin personales
         Paciente p1 = new Paciente(0, "Luis", "Luis", 1111, true, 21, 98766, 64564, "", 2, "A", "No hay","");
         Paciente p2 = new Paciente(0, "Yauri", "Yauri", 2222, true, 21, 98766, 64564, "", 2, "A", "No hay","");
           ListaDoble<Visita> listav1 = new ListaDoble<Visita>();
         listav1.insertarAlFinal(new Visita(LocalDate.of(2004, 10,11),854, new Anamnesis("salud12", "curso1", "enferact1"), new DatosMedico("Sanchez","cardiologo"), new ExamenFisicos(), new Diagnostico(), new TemporadaTratamiento(), new TratamientoRea()));
         listav1.insertarAlFinal(new Visita(LocalDate.of(2005, 12,12),854, new Anamnesis("salud12", "curso1", "enferact1"), new DatosMedico("Sanchez","cardiologo"), new ExamenFisicos(), new Diagnostico(), new TemporadaTratamiento(), new TratamientoRea()));
         listav1.insertarAlFinal(new Visita(LocalDate.of(2006, 9,23),854, new Anamnesis("salud13", "curso1", "enferact1"), new DatosMedico("Sanchez","cardiologo"), new ExamenFisicos(), new Diagnostico(), new TemporadaTratamiento(), new TratamientoRea()));
         listav1.insertarAlFinal(new Visita(LocalDate.of(2007, 10,18),854, new Anamnesis("salud14", "curso1", "enferact1"), new DatosMedico("Sanchez","cardiologo"), new ExamenFisicos(), new Diagnostico(), new TemporadaTratamiento(), new TratamientoRea()));
         
         ListaDoble<Visita> listav2 = new ListaDoble<Visita>();
         listav2.insertarAlFinal(new Visita(LocalDate.of(2010, 10,2),854, new Anamnesis("salud12", "curso1", "enferact1"), new DatosMedico("Juan","neurologo"), new ExamenFisicos(), new Diagnostico(), new TemporadaTratamiento(), new TratamientoRea()));
         listav2.insertarAlFinal(new Visita(LocalDate.of(2005, 10,2),235, new Anamnesis("salud12", "curso1", "enferact1"), new DatosMedico("Sanchez","cardiologo"), new ExamenFisicos(), new Diagnostico(), new TemporadaTratamiento(), new TratamientoRea()));
         
         
         
         p1.getHistorial().setListaVisitas(listav1);
         
         p2.getHistorial().setListaVisitas(listav2);
        
        medicoEspecialista.agregarPaciente(p1);
        medicoEspecialista.agregarPaciente(p2);
        
        
        Servicios s1 = new Servicios("sangre", 230F, false);
        Servicios s2 = new Servicios("glusoca", 250F, false);
        cajero.agregarPaciente(p1);
        cajero.agregarPaciente(p2);
        cajero.agregarServicios(s1);
        cajero.agregarServicios(s2);
        
    }

    public Cajero getCajero() {
        return cajero;
    }

    public Recepcionista getRecepcionista() {
        return recepcionista;
    }

    public MedicoEspecialista getMedicoEspecialista() {
        return medicoEspecialista;
    }

    public MedicoTriaje getMedicoTriaje() {
        return medicoTriaje;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jCTextField1 = new app.bolivia.swing.JCTextField();
        jRPasswordField1 = new jpass.JRPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        chxRecepcion = new javax.swing.JCheckBox();
        chxContab = new javax.swing.JCheckBox();
        chxgeneral = new javax.swing.JCheckBox();
        chxtriaje = new javax.swing.JCheckBox();
        chxEspec = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(73, 159, 167));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/principal/inicioname.png"))); // NOI18N
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 30));

        btnCerrar.setBackground(new java.awt.Color(255, 255, 255));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/principal/equis.png"))); // NOI18N
        btnCerrar.setToolTipText("");
        btnCerrar.setBorderPainted(false);
        btnCerrar.setContentAreaFilled(false);
        jPanel4.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 10, 30, 20));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 70));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCTextField1.setBackground(new java.awt.Color(240, 238, 240));
        jCTextField1.setBorder(null);
        jCTextField1.setForeground(new java.awt.Color(153, 153, 153));
        jCTextField1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        jCTextField1.setPlaceholder("Ingrese usuario");
        jPanel5.add(jCTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 310, 30));

        jRPasswordField1.setBackground(new java.awt.Color(240, 238, 240));
        jRPasswordField1.setBorder(null);
        jRPasswordField1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        jRPasswordField1.setPlaceholder("Ingrese contraseña");
        jPanel5.add(jRPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/principal/User Name.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 395, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/principal/Locked 2.png"))); // NOI18N
        jLabel4.setText("jLabel3");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 395, -1));

        btnIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/principal/l1.png"))); // NOI18N
        btnIniciar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/principal/l2.png"))); // NOI18N
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        jPanel5.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 96, 37));

        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("¿Olvidaste tu contraseña?");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        chxRecepcion.setBackground(new java.awt.Color(240, 238, 240));
        buttonGroup1.add(chxRecepcion);
        chxRecepcion.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        chxRecepcion.setForeground(new java.awt.Color(153, 153, 153));
        chxRecepcion.setText("Recepcion");
        chxRecepcion.setToolTipText("");
        chxRecepcion.setBorder(null);
        jPanel5.add(chxRecepcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, -1, -1));

        chxContab.setBackground(new java.awt.Color(240, 238, 240));
        buttonGroup1.add(chxContab);
        chxContab.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        chxContab.setForeground(new java.awt.Color(153, 153, 153));
        chxContab.setText("Contabilidad");
        chxContab.setToolTipText("");
        chxContab.setBorder(null);
        jPanel5.add(chxContab, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, -1, -1));

        chxgeneral.setBackground(new java.awt.Color(240, 238, 240));
        buttonGroup1.add(chxgeneral);
        chxgeneral.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        chxgeneral.setForeground(new java.awt.Color(153, 153, 153));
        chxgeneral.setText("M. General");
        chxgeneral.setToolTipText("");
        chxgeneral.setBorder(null);
        jPanel5.add(chxgeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, -1, -1));

        chxtriaje.setBackground(new java.awt.Color(240, 238, 240));
        buttonGroup1.add(chxtriaje);
        chxtriaje.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        chxtriaje.setForeground(new java.awt.Color(153, 153, 153));
        chxtriaje.setText("Triaje");
        chxtriaje.setToolTipText("");
        chxtriaje.setBorder(null);
        jPanel5.add(chxtriaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, -1, -1));

        chxEspec.setBackground(new java.awt.Color(240, 238, 240));
        buttonGroup1.add(chxEspec);
        chxEspec.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        chxEspec.setForeground(new java.awt.Color(153, 153, 153));
        chxEspec.setText("M. Especial.");
        chxEspec.setToolTipText("");
        chxEspec.setBorder(null);
        jPanel5.add(chxEspec, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, -1, -1));

        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Áreas :");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/principal/Areas.png"))); // NOI18N
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 200, 110));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 440, 330));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 439, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:

        String correo = JOptionPane.showInputDialog(null, "Ingrese su correo : ", "Correo", JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(null, "Contraseña enviado a su correo.", "", JOptionPane.WARNING_MESSAGE, null);


    }//GEN-LAST:event_jLabel5MouseClicked

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        // TODO add your handling code here:
//        if(chxRecepcion.isSelected()){
//            FrameRecepcionPrincipal recepcion = new FrameRecepcionPrincipal(recepcionista);
//            recepcion.setVisible(true);
//            this.setVisible(false);
//        }else if(chxContab.isSelected()){
//            
//        }else if(chxgeneral.isSelected()){
//            
//        }else if(chxtriaje.isSelected()){  
//            
//        }else if(chxEspec.isSelected()){
//            
//        }else{
//            JOptionPane.showMessageDialog(null, "Seleccione una área");
//        }
    }//GEN-LAST:event_btnIniciarActionPerformed

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
            java.util.logging.Logger.getLogger(FrameLoginPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameLoginPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameLoginPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameLoginPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameLoginPersonal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCerrar;
    public javax.swing.JButton btnIniciar;
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JCheckBox chxContab;
    public javax.swing.JCheckBox chxEspec;
    public javax.swing.JCheckBox chxRecepcion;
    public javax.swing.JCheckBox chxgeneral;
    public javax.swing.JCheckBox chxtriaje;
    private app.bolivia.swing.JCTextField jCTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private jpass.JRPasswordField jRPasswordField1;
    // End of variables declaration//GEN-END:variables
}
