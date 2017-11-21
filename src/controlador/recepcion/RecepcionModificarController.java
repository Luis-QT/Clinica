/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.recepcion;

import controlador.Controller;
import gui.recepcion.FrameRecepcionAgregar;
import gui.recepcion.FrameRecepcionAreaPacientes;
import gui.recepcion.FrameRecepcionModificar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.paciente.DatosMedico;
import model.paciente.Paciente;
import model.paciente.Visita;

/**
 *
 * @author Luis
 */
public class RecepcionModificarController implements Controller, ActionListener{
    private FrameRecepcionModificar vista;
    private FrameRecepcionAreaPacientes vistAnterior;
    private Paciente pers;

    public RecepcionModificarController(FrameRecepcionModificar vista, FrameRecepcionAreaPacientes vistAnterior,Paciente pers) {
        this.vista = vista;
        this.vistAnterior = vistAnterior;
        this.pers = pers;
        iniciar();
    }
    
    @Override
    public void iniciar() {
        this.vista.btnModificar.setActionCommand("Modificar");
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnLimpiar.setActionCommand("Limpiar");
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnCancelar.setActionCommand("Cancelar");
        this.vista.btnCancelar.addActionListener(this);
        
    }

    @Override
    public void index() {
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals("Modificar")) {
            formModificar();
        } else if (comando.equals("Limpiar")) {
            //formLimpiar();
        }}

    private void formModificar() {
        
       //Datos Paciente
        String nombre = vista.txtnombres.getText();
        pers.setNombre(nombre);
        String apellido = vista.txtApellidos.getText();
        pers.setApellido(apellido);
        int dni = Integer.parseInt(vista.txtDNI.getText());
        pers.setDni(dni);
        boolean sexo = false;
        if (vista.chkF.isSelected()) {
            sexo = false;
        }
        if (vista.chkM.isSelected()) {
            sexo = true;
        }
        pers.setSexo(sexo);
        int edad = Integer.parseInt(vista.txtedad.getText());
        pers.setEdad(edad);
        int telCasa = Integer.parseInt(vista.txttelefono.getText());
        pers.setTelefonoCasa(telCasa);
        int telCelular = Integer.parseInt(vista.txtcelular.getText());
        pers.setTelefonoCelular(telCelular);
        String correo = vista.txtcorreo.getText();
        pers.setEmail(correo);
        String codigoHistoria = vista.txtCodigoPaciente.getText();
        String codigoP = vista.txtCodigoPaciente.getText();
        //----------------------------
        //Fin datos paciente
        String servicio = vista.txtTipoServicio.getText();
//        pers.getHistorial().getListaVisitas().getFin().getDato().setServicio(servicio);
        DatosMedico datoMedico = new DatosMedico(vista.txtNombreDoctor.getText(), vista.txtEspecialidad.getText());
        Visita visita = new Visita(servicio, datoMedico);
        
        
//        this.pers.getHistorial().getListaVisitas().getFin().getDato().getDatosMedico().getNombre(),
//        System.out.println(vistAnterior.listaVisita.toString());
        
        
        
        
        Paciente p = new Paciente(0, nombre, apellido, dni, sexo, edad, telCasa, telCelular, correo, 1, "", "","");
//        vista.getRecepcionista().modificaPaciente(p,pers);
        vistAnterior.refrescartabla(vista.getRecepcionista().getListaPaciente());
        vista.setVisible(false);
    }
    
}
