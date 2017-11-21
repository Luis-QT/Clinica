
package controlador.historial;

import controlador.Controller;
import factory.MySQLConnectionFactory;
import gui.historiaMedica.FrameHistoriaClinica;
import gui.historiaMedica.VentanaVisita;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import model.paciente.DatosMedico;
import model.paciente.HistoriaClinica;
import model.paciente.Paciente;
import model.paciente.TemporadaTratamiento;
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
        this.vista.btnAgregarTemTrata.setActionCommand("AgregarTempTrata");
        vista.btnAgregarTemTrata.addActionListener(this);
        
        this.vista.btnVerTempTrata.setActionCommand("VerTratamiento");
        vista.btnVerTempTrata.addActionListener(this);
        
        this.vista.btnIngresarPaciente.setActionCommand("IngresarPaciente");
        vista.btnIngresarPaciente.addActionListener(this);
        
    }

    @Override
    public void index() {
        vista.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        
        if(comando.equals("AgregarTempTrata")){
            formAgregarTemporadaTratamiento();
        }else if(comando.equals("VerTratamiento")){
            formVerTemporadaTratamiento();
        }else if(comando.equals("IngresarPaciente")){
            formRegistrarVisita();
        }
    }
    

    private void formAgregarTemporadaTratamiento() {
        Paciente paciente = vista.getPaciente();
//        int dia = Integer.parseInt(vista.txtFechaDia.getText());
//        int mes = Integer.parseInt(vista.txtFechaMes.getText());
//        int anio = Integer.parseInt(vista.txtFechaAnio.getText());
//        LocalDate fecha = LocalDate.of(anio, mes, dia);
        String nombreDoctor = vista.txtNomDoctor.getText();
        String especialidad = vista.txtEspecialidad.getText();
        String servicio = vista.txtServicio.getText();
        Visita nuevaVisista= new Visita(servicio, new DatosMedico(nombreDoctor, especialidad));
        //la lista tambien para a la clase paciente ?
//        paciente.getHistorial().getListaVisitas().insertarAlFinal(nuevaVisista);
        vista.getListaVisitas().insertarAlFinal(nuevaVisista);
        vista.mostrarTabla();
    }

    private void formVerTemporadaTratamiento() {
          try{
            int posicion = vista.tblVisitas.getSelectedRow();
            Visita visista = vista.getListaVisitas().getDato(posicion);
            ventanaVisita = new VentanaVisita(vista, true,visista);
            ventanaVisita.btnRegistrarVisita.setEnabled(false);
            
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
