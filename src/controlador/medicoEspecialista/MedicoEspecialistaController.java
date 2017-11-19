/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.medicoEspecialista;

import controlador.Controller;
import controlador.historial.HistorialController;
import estructura.ListaDoble;
import factory.MySQLConnectionFactory;
import gui.medicoEspecialista.FrameMedicoEspecialista;
import gui.medicoGeneral.FrameHistoriaClinica;
import gui.medicoGeneral.VentanaVisita;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import model.empleado.MedicoEspecialista;
import model.paciente.Paciente;

public class MedicoEspecialistaController implements Controller,ActionListener{
    private FrameMedicoEspecialista vista;
    private FrameHistoriaClinica frameHistorial;

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
        
        this.vista.txtBuscar.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent evt){
                formBuscar();
            }
        });
        
        this.vista.jmiCerraSesion.setActionCommand("Salir");
        this.vista.jmiCerraSesion.addActionListener(this);
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
        }
    }
    
    public void formActualizar(){
        try{
            MedicoEspecialista medicoE = vista.getMedicoE();
            ListaDoble<Paciente> listaPaciente = medicoE.getListaPaciente();
            vista.setListaPacientes(medicoE.getListaPaciente());
            vista.mostrarTabla(listaPaciente);
            vista.txtBuscar.setText("");
        }catch(Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "1 ERROR DE ESCRITURA\n");
        }
        
    }
    
    private void formEliminar() {
        try{
            ListaDoble<Paciente> listaPacientes = vista.getListaPacientes();
            MedicoEspecialista medicoE = vista.getMedicoE();
            int pos = vista.tblPaciente.getSelectedRow();
            if(pos >= 0){
                medicoE.eliminarPaciente(pos);
                vista.mostrarTabla(listaPacientes);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "ERROR DE ESCRITURA\n");
        }
    }
   

    private void formVerHistorial() {
         try{
            ListaDoble<Paciente> listaPacientes = vista.getListaPacientes();
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
            ListaDoble<Paciente> listaPacientes = vista.getListaPacientes();
            MedicoEspecialista medicoE = vista.getMedicoE();
            if(vista.cbxApellido.isSelected()){
                ListaDoble<Paciente> p = medicoE.buscarporApellido(palabraBuscar);
                vista.setListaPacientes(p);
                vista.mostrarTabla(p);
            }else if(vista.cbxCodigo.isSelected()){
                ListaDoble<Paciente> p = medicoE.buscarporCodigo(palabraBuscar);
                vista.setListaPacientes(p);
                vista.mostrarTabla(p);
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese un filtro");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "ERROR DE ESCRITURA\n");
        }
        
    }
    
    
    
}
