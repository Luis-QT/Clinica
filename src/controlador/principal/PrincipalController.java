/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.principal;

import controlador.Controller;
import inicio.FrameLoginAdministracion;
import inicio.FrameLoginPersonal;
import inicio.FramePrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Luis
 */
public class PrincipalController implements Controller, ActionListener {

    private FramePrincipal vista;

    public PrincipalController(FramePrincipal vista) {
        this.vista = vista;
        iniciar();
    }

    @Override
    public void iniciar() {
        this.vista.btnAdmi.setActionCommand("LoginAdministrador");
        this.vista.btnAdmi.addActionListener(this);
        this.vista.btnPersonal.setActionCommand("LoginPersonal");
        this.vista.btnPersonal.addActionListener(this);
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
        if (comando.equals("LoginAdministrador")) {
            formLoginAdministrador();
        } else if (comando.equals("LoginPersonal")) {
            formLoginPersonal();
        }else if (comando.equals("Cerrar")) {
            formCerrar();
        }
    }

    private void formLoginAdministrador() {
        //LoginAdministracion logAdmi = new FrameLoginAdministracion();
        vista.setVisible(false);
        //this.FrameLoginAdministrador;
        //logAdmi.setVisible(true);
    }

    private void formLoginPersonal() {
        //FrameLoginPersonal logPer = new FrameLoginPersonal();
        vista.setVisible(false);
        FrameLoginPersonal logPer = new FrameLoginPersonal();
        new LoginPersonalController(logPer).index();
        logPer.setVisible(true);
        System.out.println("mrd");
    }

    private void formCerrar() {
        this.vista.dispose();
    }

}
