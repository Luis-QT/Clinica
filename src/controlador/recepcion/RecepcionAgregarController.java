
package controlador.recepcion;

import controlador.Controller;
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

    public RecepcionAgregarController(FrameRecepcionAgregar vista, FrameRecepcionAreaPacientes vistAnterior) {
        this.vista = vista;
        this.vistAnterior = vistAnterior;
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
        String codigoHistoria = vista.txtHistoriaClinica.getText();
        //Fin datos paciente
        String servicio = null;
        switch (vista.cbxServicio.getSelectedIndex()) {
            case 0:
                servicio = (String) vista.cbxServicio.getSelectedItem();
                break;
            case 1:
                servicio = (String) vista.cbxServicio.getSelectedItem();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Escoga una opción");
        }
        
        
        DatosMedico datMedico = new DatosMedico();
        switch (vista.cbxDoctor.getSelectedIndex()) {
            case 0:
                datMedico.setNombreApellido((String) vista.cbxDoctor.getSelectedItem());
                break;
            case 1:
                datMedico.setNombreApellido((String) vista.cbxDoctor.getSelectedItem());
                break;
            default:
                JOptionPane.showMessageDialog(null, "Escoga una opción");
        }
        
        switch (vista.cbxEspecialidad.getSelectedIndex()) {
            case 0:
                datMedico.setEspecializacion((String) vista.cbxEspecialidad.getSelectedItem());
                break;
            case 1:
                datMedico.setEspecializacion((String) vista.cbxEspecialidad.getSelectedItem());
                break;
            default:
                JOptionPane.showMessageDialog(null, "Escoga una opción");
        }
        
        Visita visita = new Visita(servicio, datMedico);
        vistAnterior.listaVisita.insertarAlFinal(visita);
        System.out.println(vistAnterior.listaVisita.toString());
        Paciente p = new Paciente(0, nombre, apellido, dni, sexo, edad, telCasa, telCelular, correo, 1, "", "", codigoHistoria);
        vista.getRecepcionista().agregarPaciente(p);
        vistAnterior.refrescartabla(vista.getRecepcionista().getListaPaciente());
        vista.setVisible(false);
        
    }
    
    
}
