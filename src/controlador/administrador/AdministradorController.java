/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.administrador;

import controlador.Controller;
import factory.MySQLConnectionFactory;
import gui.administrador.areaMedico.PlanTratamientoV;
import gui.administrador.FramePrincipalAdministrador;
import gui.administrador.mantenimiento.medico.medicoEspecialista.ListaME;
import gui.administrador.mantenimiento.medico.medicoGeneral.ListaMG;
import gui.administrador.mantenimiento.medico.medicoLaboratorio.ListaML;
import gui.administrador.mantenimiento.recepcionista.ListaR;
import gui.administrador.mantenimiento.sala.Salas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author LLLL
 */
public class AdministradorController implements Controller,ActionListener{
    
    private FramePrincipalAdministrador vista;
    private ListaMG FrameListaMG;
    private ListaME FrameListaME;
    private Salas FrameSala;
    private ListaML FrameListaML;
    private ListaR FrameRecepcionista;
    private PlanTratamientoV FrameTratamiento;
    
    public AdministradorController(FramePrincipalAdministrador frame ){
        this.vista = frame;
        iniciar();
    }
    
    public void iniciar(){
        
        
        
        this.vista.btnMantenimientoMedicoGeneral.setActionCommand("MantenimientoMG");
        vista.btnMantenimientoMedicoGeneral.addActionListener(this);
        
        this.vista.btnSalas.setActionCommand("MantenimientoSala");
        vista.btnSalas.addActionListener(this);
        
        this.vista.btnMantenimientoMedicoEspecialista.setActionCommand("MantenimientoME");
        vista.btnMantenimientoMedicoEspecialista.addActionListener(this);
        
        this.vista.btnMantenimientoRecepcionista.setActionCommand("MantenimientoR");
        vista.btnMantenimientoRecepcionista.addActionListener(this);
        
        this.vista.btnPlanTratamiento.setActionCommand("PlanTratamiento");
        vista.btnPlanTratamiento.addActionListener(this);
        
        this.vista.btnCerrarSesion.setActionCommand("Salir");
        vista.btnCerrarSesion.addActionListener(this);
        
        vista.btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MySQLConnectionFactory.shutdown();
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
        
        if(comando.equals("MantenimientoMG")){
            formManteminientoMG();
        }else if (comando.equals("MantenimientoSala")){
            formMantenimientoSala();
        }else if(comando.equals("Salir")){
            MySQLConnectionFactory.shutdown();
        }else if (comando.equals("MantenimientoME")){
            formMantenimientoME();
        }else if(comando.equals("MantenimientoR")){
            formMantenimientoR();
        }else if(comando.equals("PlanTratamiento")){
            formPlanTratamiento();
        }
    }
    
    private void formManteminientoMG(){
        this.FrameListaMG = new ListaMG(vista, true);
        new MedicoGeneralController(this.FrameListaMG).index();
    }
    private void formMantenimientoME(){
        this.FrameListaME = new ListaME(vista, true);
        new MedicoEspecialistaController(this.FrameListaME).index();
    }
    
    private void formMantenimientoSala(){
        this.FrameSala = new Salas(vista, true);
        new SalaController(this.FrameSala).index();
    }
    private void formMantenimientoR(){
        this.FrameRecepcionista = new ListaR(vista, true);
        new RecepcionistaController(this.FrameRecepcionista).index();
    }
    private void formPlanTratamiento(){
        this.FrameTratamiento = new PlanTratamientoV(vista, true);
        new PlanTratamientoController(this.FrameTratamiento).index();
    }
}
