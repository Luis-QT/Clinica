
package controlador.recepcion;

import controlador.Controller;
import dao.recepcion.RecepcionImpl;
import estructura.ListaDoble;
import gui.recepcion.FrameRecepcionAgregar;
import gui.recepcion.FrameRecepcionAreaPacientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.paciente.DatosMedico;
import model.paciente.Paciente;
import model.paciente.Visita;

public class RecepcionAgregarController implements Controller, ActionListener {

    private FrameRecepcionAgregar vista;
    private FrameRecepcionAreaPacientes vistAnterior;
    private ListaDoble<Paciente> listaPaciente;
    
    public RecepcionAgregarController(FrameRecepcionAgregar vista, FrameRecepcionAreaPacientes vistAnterior, ListaDoble<Paciente> listaPaciente ) {
        this.vista = vista;
        this.vistAnterior = vistAnterior;
        this.listaPaciente = listaPaciente;
        iniciar();
    }

    @Override
    public void iniciar() {
        this.vista.btnAgregar.setActionCommand("Agregar");
        this.vista.btnAgregar.addActionListener(this);
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
        if (comando.equals("Agregar")) {
            formAgregar();
        } else if (comando.equals("Limpiar")) {
            //formLimpiar();
        }}

    private void formAgregar() {
        RecepcionImpl receDao = new RecepcionImpl();
        //Datos Paciente
        String nombre = vista.txtnombres.getText();
        String apellido = vista.txtApellidos.getText();
        int dni = Integer.parseInt(vista.txtDNI.getText());
        boolean sexo = false;
        if (vista.chkF.isSelected()) {
            sexo = false;
        }
        if (vista.chkM.isSelected()) {
            sexo = true;
        }
        int edad = Integer.parseInt(vista.txtedad.getText());
        int telCasa = Integer.parseInt(vista.txttelefono.getText());
        int telCelular = Integer.parseInt(vista.txtcelular.getText());
        String correo = vista.txtcorreo.getText();
        String codigoP = vista.txtCodigoPaciente.getText();
        //Fin datos paciente
        String servicio = vista.txtTipoServicio.getText();
        DatosMedico datMedico = new DatosMedico(vista.txtNombreDoctor.getText(),
                                        vista.txtEspecialidad.getText());
        Visita visita = new Visita(servicio, datMedico);
        
       // vistAnterior.listaVisita.insertarAlFinal(visita);
//        System.out.println(vistAnterior.listaVisita.toString());
        
        Paciente p = new Paciente(0, nombre, apellido, dni, sexo, edad, telCasa, telCelular, correo, 2, "", "",codigoP);
        listaPaciente.insertarAlFinal(p);
        if(receDao.guardarPaciente(p)){
            JOptionPane.showMessageDialog(null, "Paciente registrado.");
        }else{
            JOptionPane.showMessageDialog(null, "No se puede registrar.");
        }
        System.out.println("Lista : " +  listaPaciente.toString());
        
        vistAnterior.refrescartabla(listaPaciente);
        
        vista.setVisible(false);
        
    }
    
    
}
