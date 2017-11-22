/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.medicoEspecialista;

import controlador.Controller;
import controlador.historial.HistorialController;
import controlador.principal.LoginPersonalController;
import dao.medicoEspecialista.MedicoEspecialistaDao;
import dao.daoImpl.MedicoEspecialistaDaoImpl;
import dao.medicoEspecialista.MedicoEspecialistaDaoI;
import estructura.ListaDoble;
import factory.MySQLConnectionFactory;
import gui.medicoEspecialista.FrameMedicoEspecialista;
import gui.historiaMedica.FrameHistoriaClinica;
import gui.historiaMedica.VentanaVisita;
import inicio.FrameLoginPersonal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.empleado.MedicoEspecialista;
import model.paciente.Paciente;

public class MedicoEspecialistaController implements Controller,ActionListener{
  private FrameMedicoEspecialista vista;
    private FrameHistoriaClinica frameHistorial;
    private FrameLoginPersonal login;
    private ListaDoble<Paciente> listaPacientes;
    MedicoEspecialistaDao medicoEspDao = new MedicoEspecialistaDaoI();
    
    public MedicoEspecialistaController(FrameMedicoEspecialista vista) {
        this.vista = vista;
        iniciar();
    }
    
    public void iniciar (){
        this.vista.btnActualizar.setActionCommand("Actualizar");
        this.vista.btnActualizar.addActionListener(this);
        
        this.vista.btnEliminarPaciente.setActionCommand("Eliminar");
        this.vista.btnEliminarPaciente.addActionListener(this);
        
        this.vista.btnVerHistorial.setActionCommand("VerHistorial");
        this.vista.btnVerHistorial.addActionListener(this);
        
        this.vista.btnCerrar.setActionCommand("Cerrar");
        this.vista.btnCerrar.addActionListener(this);
        
        
        this.vista.txtBuscar.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent evt){
                formBuscar();
            }
        });
        
        this.vista.jmiCerraSesion.setActionCommand("Salir");
        this.vista.jmiCerraSesion.addActionListener(this);
        
        listaPacientes = medicoEspDao.listaPacientes();
        vista.getMedicoE().setListaPaciente(medicoEspDao.listaPacientes());
        mostrarTabla(listaPacientes);
    }
    
    @Override
    public void index() {
        vista.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if(comando.equals("Actualizar")){
            formActualizar();
        }else if(comando.equals("Eliminar")){
            formEliminar();
        }else if(comando.equals("VerHistorial")){
            formVerHistorial();
        }else if(comando.equals("Salir")){
             MySQLConnectionFactory.shutdown();
        }else if(comando.equals("Cerrar")){
            formCerrar();
        }
    }
    
    public void formActualizar(){
        try{
            MedicoEspecialista medicoE = vista.getMedicoE();
            listaPacientes = medicoEspDao.listaPacientes();
            mostrarTabla(listaPacientes);
            vista.txtBuscar.setText("");
        }catch(Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "1 ERROR DE ESCRITURA\n");
        }
        
    }
    
    private void formEliminar() {
//        try{
//            ListaDoble<Paciente> listaPacientes = vista.getListaPacientes();
//            MedicoEspecialista medicoE = vista.getMedicoE();
//            int pos = vista.tblPaciente.getSelectedRow();
//            if(pos >= 0){
//                medicoE.eliminarPaciente(pos);
//                mostrarTabla(listaPacientes);
//            }
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//                JOptionPane.showMessageDialog(null, "ERROR DE ESCRITURA\n");
//        }
    }
   

    private void formVerHistorial() {
         try{
            MedicoEspecialista medicoE = vista.getMedicoE();
            int pos = vista.tblPaciente.getSelectedRow();
            Paciente paciente = listaPacientes.getDato(pos);
            this.frameHistorial = new FrameHistoriaClinica(paciente);
            this.frameHistorial.setVisible(true);
            new HistorialController( frameHistorial , new VentanaVisita(frameHistorial, true)).index();
            
        }catch(Exception e){
                System.out.println("ERROR  " + e);
                JOptionPane.showMessageDialog(null, "ERROR DE ESCRITURA\n");
        }
    }

    private void formBuscar() {
        try{
            String palabraBuscar = vista.txtBuscar.getText();
//            ListaDoble<Paciente> listaPacientes = vista.getListaPacientes();
            MedicoEspecialista medicoE = vista.getMedicoE();
            if(vista.cbxApellido.isSelected()){
                ListaDoble<Paciente> p = medicoE.buscarporApellido(palabraBuscar);
                System.out.println("lista: " + p.toString());
                listaPacientes = p;
                mostrarTabla(p);
            }else if(vista.cbxCodigo.isSelected()){
                ListaDoble<Paciente> p = medicoE.buscarporCodigo(palabraBuscar);
                listaPacientes = p;
                mostrarTabla(p);
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese un filtro");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "ERROR DE ESCRITURA\n");
        }
        
    }

    private void formCerrar() {
        this.vista.dispose();
        this.login = new FrameLoginPersonal();
        new LoginPersonalController(login).index();
        
    }
    
    public void mostrarTabla(ListaDoble<Paciente> lista) {
        DefaultTableModel dtm = (DefaultTableModel) vista.tblPaciente.getModel();
        dtm.setRowCount(0);
        Iterator<Paciente> iterador = lista.getDescendingIterator();
        while (iterador.hasNext()) {
            Paciente pro = iterador.next();
            dtm.addRow(new Object[]{pro.getApellido(), pro.getId()});
        }
    }
    
}
