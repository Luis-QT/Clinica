
package controlador.historial;

import controlador.Controller;
import factory.MySQLConnectionFactory;
import gui.medicoGeneral.FrameHistoriaClinica;
import gui.medicoGeneral.VentanaVisita;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        
        this.vista.btnIngresarPaciente.setActionCommand("Ingresar Datos");
        vista.btnIngresarPaciente.addActionListener(this);
        
        this.vista.btnIngresarAntecedente.setActionCommand("Ingresar Antecedentes");
        vista.btnIngresarAntecedente.addActionListener(this);
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
        }else if(comando.equals("Ingresar Datos")){
            formIngrerDatoPaciente();
        }else if(comando.equals("Ingresar Antecedentes")){
            forIngresarAntedentes();
        }
    }
    

    private void formAgregarVisita() {
        Paciente paciente = vista.getPaciente();
        this.ventanaVisita = new VentanaVisita(vista, true, paciente.getHistorial());
//        ventanaVisita.setVisible(true);
//        new VisitaController(ventanaVisita).index();
        System.out.println("error1");
    }

    private void formVerVisita() {
          try{
            int posicion = vista.tblVisitas.getSelectedRow();
            Paciente paciente = vista.getPaciente() ;
//            
            Visita visita = paciente.obtenerVisita(posicion);
            
//            VentanaVisita ventanaVisita = new VentanaVisita(vista, true,visita);
            this.ventanaVisita = new VentanaVisita(vista, true, visita);
//            new VisitaController(ventanaVisita).index();
            
        }catch(Exception e){
            System.out.println(e);
        }
    }

    private void formIngrerDatoPaciente() {
        
    }

    private void forIngresarAntedentes() {
        
        
    
    }
    
    
    
    
    
}
