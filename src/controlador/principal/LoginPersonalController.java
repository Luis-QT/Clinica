/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.principal;

import controlador.Controller;
import controlador.contabilidad.ContabilidadController;
import controlador.medicoEspecialista.MedicoEspecialistaController;
import controlador.recepcion.RecepcionPrincipalController;
import gui.contabilidad.FrameContabilidad;
import gui.medicoEspecialista.FrameMedicoEspecialista;
import gui.recepcion.FrameRecepcionPrincipal;
import inicio.FrameLoginPersonal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.empleado.Cajero;
import model.empleado.MedicoEspecialista;
import model.empleado.Recepcionista;
import model.paciente.Paciente;

/**
 *
 * @author Luis
 */
public class LoginPersonalController implements Controller, ActionListener {

    private FrameLoginPersonal vista;

    public LoginPersonalController(FrameLoginPersonal vista) {
        this.vista = vista;
        iniciar();
    }

    @Override
    public void iniciar() {
        this.vista.btnIniciar.setActionCommand("Iniciar");
        this.vista.btnIniciar.addActionListener(this);
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
        }
    }

    private void formIniciar() {
        //Personales
        Recepcionista recepcionista = vista.getRecepcionista();
        MedicoEspecialista medicoEspecialista = vista.getMedicoEspecialista();
        Cajero cajero = vista.getCajero();
        //Fin
        if (vista.chxRecepcion.isSelected()) {
            FrameRecepcionPrincipal recepcion = new FrameRecepcionPrincipal(recepcionista);
            recepcion.setVisible(true);
            vista.setVisible(false);
            new RecepcionPrincipalController(recepcion).index();
        } else if (vista.chxContab.isSelected()) {
            FrameContabilidad contabilidad = new FrameContabilidad(cajero);
            contabilidad.setVisible(true);
            vista.setVisible(false);
            new ContabilidadController(contabilidad).index();
            

        } else if (vista.chxgeneral.isSelected()) {

        } else if (vista.chxtriaje.isSelected()) {

        } else if (vista.chxEspec.isSelected()) {
            FrameMedicoEspecialista medEspecia = new FrameMedicoEspecialista(medicoEspecialista);
            medEspecia.setVisible(true);
            vista.setVisible(false);
            new MedicoEspecialistaController(medEspecia).index();

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una área");
        }
    }

}
