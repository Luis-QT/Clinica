
package controlador.historial;

import controlador.Controller;
import factory.MySQLConnectionFactory;
import gui.medicoGeneral.FrameHistoriaClinica;
import gui.medicoGeneral.VentanaVisita;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.paciente.HistoriaClinica;
import model.paciente.Paciente;
import model.paciente.Visita;

public class HistorialController implements Controller,ActionListener {
    private FrameHistoriaClinica vista;
    private VentanaVisita ventanaVisita;

    public HistorialController(FrameHistoriaClinica vista, VentanaVisita frame) {
        this.ventanaVisita = frame;
        this.vista = vista;
        iniciar();
        
    }
    
    public void iniciar() {
        this.vista.btnAgregarVisita.setActionCommand("Agregar Visita");
        vista.btnAgregarVisita.addActionListener(this);
        
        this.vista.btnVerVisita.setActionCommand("Ver Visita");
        vista.btnVerVisita.addActionListener(this);
        
        this.vista.btnIngresarPaciente.setActionCommand("Ingresar Pciente");
        vista.btnIngresarPaciente.addActionListener(this);
        
    }

    @Override
    public void index() {
        vista.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        
        if(comando.equals("Agregar Visita")){
            formAgregarVisita();
        }else if(comando.equals("Ver Visita")){
            formVerVisita();
        }else if(comando.equals("Ingresar Pciente")){
            formRegistrarVisita();
        }
    }
    

    private void formAgregarVisita() {
        Paciente paciente = vista.getPaciente();
        this.ventanaVisita = new VentanaVisita(vista, true, paciente.getHistorial());
        new VisitaController(ventanaVisita).index();
        System.out.println("error1");
    }

    private void formVerVisita() {
          try{
            int posicion = vista.tblVisitas.getSelectedRow();
            Visita visita =vista.getListaVisita().getDato(posicion);
            ventanaVisita = new VentanaVisita(vista, true,visita);
            ventanaVisita.btnRegistrarVisita.setEnabled(false);
//            ventanaVisita.setVisible(true);
            
        }catch(Exception e){
            System.out.println(e);
                    
        }
    }

    private void formRegistrarVisita() {
        HistoriaClinica historia = vista.getHistoriaClinicaa() ;
        ventanaVisita = new VentanaVisita(vista, true, historia);
        ventanaVisita.setVisible(true);
    }

    
    
    
    
    
    
}
