/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.principal;

import controlador.Controller;
import controlador.contabilidad.ContabilidadController;
//import controlador.administrador.MedicoTriajeController;
import controlador.medicoEspecialista.MedicoEspecialistaController;
import controlador.recepcion.RecepcionPrincipalController;
import controlador.triaje.PMedicoTriajeController;
import gui.contabilidad.FrameContabilidad;
import gui.medicoEspecialista.FrameMedicoEspecialista;
import gui.recepcion.FrameRecepcionPrincipal;
import gui.triaje.FrameTriaje;
import inicio.FrameLoginPersonal;
import inicio.FramePrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.empleado.Cajero;
import model.empleado.MedicoEspecialista;
import model.empleado.MedicoTriaje;
import model.empleado.Recepcionista;

/**
 *
 * @author Luis
 */
public class LoginPersonalController implements Controller, ActionListener {

    private FrameLoginPersonal vista;
    private FramePrincipal principal;
    private FrameTriaje triaje;

    public LoginPersonalController(FrameLoginPersonal vista) {
        this.vista = vista;
        iniciar();
    }

    @Override
    public void iniciar() {
        this.vista.btnIniciar.setActionCommand("Iniciar");
        this.vista.btnIniciar.addActionListener(this);
        this.vista.btnCerrar.setActionCommand("Cerrar");
        this.vista.btnCerrar.addActionListener(this);
    }

    @Override
    public void index() {
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals("Iniciar")) {
            formIniciar();
        } else if (comando.equals("Cerrar")) {
            formCerrar();
        }
    }

    private void formIniciar() {
        //Personales
        Recepcionista recepcionista = vista.getRecepcionista();
        MedicoEspecialista medicoEspecialista = vista.getMedicoEspecialista();
        MedicoTriaje medicoTriaje = vista.getMedicoTriaje();
        
        Cajero cajero = vista.getCajero();

        // FrameTriaje triaje = new FrameTriaje(medicoTriaje);
        //Fin
        if (vista.chxRecepcion.isSelected()) {
            FrameRecepcionPrincipal recepcion = new FrameRecepcionPrincipal(recepcionista);
            //recepcion.setVisible(true);
            //vista.setVisible(false);
            new RecepcionPrincipalController(recepcion).index();
        } else if (vista.chxContab.isSelected()) {
            this.triaje = new FrameTriaje(medicoTriaje);
            FrameContabilidad contabilidad = new FrameContabilidad(cajero,this.triaje);
            new ContabilidadController(contabilidad).index();
        } else if (vista.chxgeneral.isSelected()) {

        } else if (vista.chxtriaje.isSelected()) {
             FrameTriaje venTriaje = new FrameTriaje(medicoTriaje);
             new PMedicoTriajeController(venTriaje).index();
        } else if (vista.chxEspec.isSelected()) {
            FrameMedicoEspecialista medEspecia = new FrameMedicoEspecialista(medicoEspecialista);
            new MedicoEspecialistaController(medEspecia).index();

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una área");
        }
    }

    private void formCerrar() {
        this.vista.dispose();
        this.principal = new FramePrincipal();
        new PrincipalController(principal);

    }

}
