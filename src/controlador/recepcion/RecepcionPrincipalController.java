/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.recepcion;

import controlador.Controller;
import controlador.principal.LoginPersonalController;
import gui.recepcion.FrameRecepcionAreaPacientes;
import gui.recepcion.FrameRecepcionPrincipal;
import inicio.FrameLoginPersonal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.empleado.Recepcionista;

/**
 *
 * @author Luis
 */
public class RecepcionPrincipalController implements Controller, ActionListener {

    private FrameRecepcionPrincipal vista;
    private FrameRecepcionAreaPacientes areaPacientes;

    public RecepcionPrincipalController(FrameRecepcionPrincipal vista) {
        this.vista = vista;
        iniciar();
    }

    @Override
    public void iniciar() {
        this.vista.btnPacientes.setActionCommand("Pacientes");
        this.vista.btnPacientes.addActionListener(this);
        this.vista.btnSalir.setActionCommand("Salir");
        this.vista.btnSalir.addActionListener(this);
    }

    @Override
    public void index() {
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals("Pacientes")) {
            formPacientes();
        } else if (comando.equals("Salir")) {
            formSalir();
        }
    }

    private void formPacientes() {
        Recepcionista recepcionista = vista.getRecepcionista();
        this.areaPacientes = new FrameRecepcionAreaPacientes(vista, true, recepcionista);
        new RecepcionAreaPacientesController(areaPacientes).index();
    }

    private void formSalir() {
        vista.setVisible(false);
        FrameLoginPersonal logPer = new FrameLoginPersonal();
        logPer.setVisible(true);
        new LoginPersonalController(logPer).index();
    }

}
