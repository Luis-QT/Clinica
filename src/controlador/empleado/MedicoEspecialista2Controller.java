/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.empleado;

import controlador.Controller;
import estructura.ListaDoble;
import gui.medicoEspecialista.FrameMedicoEspecialista;
import gui.medicoGeneral.FrameHistoriaClinica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import model.empleado.MedicoEspecialista;
import model.paciente.Paciente;

/**
 *
 * @author Pechito
 */
public class MedicoEspecialista2Controller implements Controller,ActionListener{
    private FrameMedicoEspecialista vista;
    private FrameHistoriaClinica frameHistorial;

    public MedicoEspecialista2Controller(FrameMedicoEspecialista vista) {
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
        
//        this.vista.btnBuscar.setActionCommand("Buscar");
//        this.vista.btnBuscar.addActionListener(this);
        
        this.vista.txtBuscar.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent evt){
                formBuscar();
            }
        });
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
        }else if(comando.equals("Buscar")){
            formBuscar();
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
                JOptionPane.showMessageDialog(null, "ERROR DE ESCRITURA\n");
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
            frameHistorial = new FrameHistoriaClinica(paciente);
            frameHistorial.setVisible(true);
            
        }catch(Exception e){
            System.out.println(e.getMessage());
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
                if (p == null) {
                    JOptionPane.showMessageDialog(null, "No se encontró");
                } else {
                    vista.setListaPacientes(p);
                    vista.mostrarTabla(p);
                }
            }else if(vista.cbxCodigo.isSelected()){
                ListaDoble<Paciente> p = medicoE.buscarporCodigo(palabraBuscar);
                if (p == null) {
                    JOptionPane.showMessageDialog(null, "No se encontró");
                } else {
                    vista.setListaPacientes(p);
                    vista.mostrarTabla(p);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese un filtro");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "ERROR DE ESCRITURA\n");
        }
        
    }
    
   

    

    
    
}
