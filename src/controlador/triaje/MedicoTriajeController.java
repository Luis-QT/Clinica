
package controlador.triaje;

import controlador.Controller;
import gui.medicoGeneral.FrameHistoriaClinica;
import gui.triaje.FrameTriaje;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.paciente.Paciente;


public class MedicoTriajeController implements Controller,ActionListener {
    private FrameTriaje vista;
    @Override
    public void iniciar() {
        this.vista = vista;
        iniciar();
    }

    @Override
    public void index() {
        this.vista.jButton2.setActionCommand("Ver Historial");
        this.vista.jButton2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String comando = e.getActionCommand();
        if(comando.equals("Ver Historial")){
            formVerHistorial();
        }
    }
    
    public void formVerHistorial(){
         
        int posicion = vista.tablaPacientes.getSelectedRow();
        Paciente paciente = vista.getListaPacientes().getDato(posicion);
        FrameHistoriaClinica historial = new FrameHistoriaClinica(paciente);
        historial.setVisible(true);  
    }
}
