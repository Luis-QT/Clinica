package controlador.recepcion;

import controlador.Controller;
import gui.contabilidad.FrameContabilidad;
import gui.recepcion.RecepcionAgregar;
import gui.recepcion.RecepcionAreaPacientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.empleado.Recepcionista;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Luis
 */
public class AreaPacientesController implements Controller, ActionListener {

    private RecepcionAreaPacientes vista;

    public AreaPacientesController(RecepcionAreaPacientes vista) {
        this.vista = vista;
        iniciar();
    }

    @Override
    public void iniciar() {
        this.vista.btnAgregar.setActionCommand("Agregar");
        this.vista.btnAgregar.addActionListener(this);
    }

    @Override
    public void index() {
         vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if(comando.equals("Agregar")){
            formAgregar();
        }
    }

    private void formAgregar() {
        Recepcionista recepcionista = vista.getRecepcionista();
        RecepcionAgregar agregarVentana = new RecepcionAgregar(new javax.swing.JDialog(), true, recepcionista, vista);
        agregarVentana.setVisible(true);
    }
    
    
    
    

}
