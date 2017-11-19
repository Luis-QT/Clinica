/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.recepcion;

import controlador.Controller;
import gui.recepcion.FrameRecepcionAreaPacientes;
import gui.recepcion.FrameRecepcionPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.empleado.Recepcionista;

/**
 *
 * @author Luis
 */
public class RecepcionPrincipalController implements Controller, ActionListener {

    private FrameRecepcionPrincipal vista;

    public RecepcionPrincipalController(FrameRecepcionPrincipal vista) {
        this.vista = vista;
        iniciar();
    }

    @Override
    public void iniciar() {
        this.vista.btnPacientes.setActionCommand("Pacientes");
        this.vista.btnPacientes.addActionListener(this);
    }

    @Override
    public void index() {
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
           String comando = e.getActionCommand();
        if(comando.equals("Pacientes")){
            formPacientes();
        }
    }

    private void formPacientes() {
        System.out.println("Luis :v");
        Recepcionista recepcionista = vista.getRecepcionista();    
        new FrameRecepcionAreaPacientes(vista,true, recepcionista).setVisible(true);
        
    }

}
