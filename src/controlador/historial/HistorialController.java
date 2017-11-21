
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
        
        this.vista.btnRegistrarDatos.setActionCommand("RegistrarPaciente");
        vista.btnRegistrarDatos.addActionListener(this);
        
    }

    @Override
    public void index() {
        vista.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        
        if(comando.equals("AgregarTempTrata")){
            formAgregarVisita();
        }else if(comando.equals("VerTratamiento")){
            formVerVisita();
        }else if(comando.equals("RegistrarPaciente")){
            formRegistrarPaciente();
        }
    }
    

    private void formAgregarVisita() {
        Paciente paciente = vista.getPaciente();
        String nombreDoctor = vista.txtNomDoctor.getText();
        String especialidad = vista.txtEspecialidad.getText();
        String servicio = vista.txtServicio.getText();
        Visita nuevaVisista= new Visita(servicio, new DatosMedico(nombreDoctor, especialidad));
        //la lista tambien para a la clase paciente ?
//        paciente.getHistorial().getListaVisitas().insertarAlFinal(nuevaVisista);
        vista.getListaVisitas().insertarAlFinal(nuevaVisista);
        vista.mostrarTabla();
    }

    private void formVerVisita() {
          try{
            int posicion = vista.tblVisitas.getSelectedRow();
            Visita visita = vista.getListaVisitas().getDato(posicion);
            ventanaVisita = new VentanaVisita(vista, true,visita);
            new VisitaController(ventanaVisita).index();
            
//            ventanaVisita.setVisible(true);
        }catch(Exception e){
            System.out.println(e);
                    
        }
    }

    private void formRegistrarPaciente() {
        Paciente paciente = vista.getPaciente();
        String enfermTratadas = vista.jTextFieldEnfermedadesTratadas.getText();
        String hosp = vista.jTextFieldHospitalizaciones.getText();
        String inmu = vista.jTextFieldInmunizaciones.getText();
        String tipoS = vista.jTextFielTipoSangre.getText();
        String alergias = vista.jTextFieldAlergias.getText();
        
       
        paciente.getHistorial().getAntecedentesPersonales().setAlergias(alergias);
        paciente.getHistorial().getAntecedentesPersonales().setEnferTra(enfermTratadas);
        paciente.getHistorial().getAntecedentesPersonales().setHospitalizaciones(Integer.parseInt(hosp));
        paciente.getHistorial().getAntecedentesPersonales().setInmunizacion(Integer.parseInt(inmu));
        paciente.getHistorial().getAntecedentesPersonales().setTipoSangre(tipoS);
        
        boolean estadoP = false;
        if(vista.jRadioButtonMuertoP1.isSelected()){
            estadoP = false;
        }else if(vista.jRadioButtonVivoP1.isSelected()){
            estadoP = true;
        }
        
        String enferPadre = vista.jTextFieldPadreEnfermedades1.getText();
        String hospP = vista.jTextFieldPadreHos1.getText();
 
        String enferMadre = vista.jTextFieldMadreEnf1.getText();
        String hospM = vista.jTextFieldMadreHos1.getText();
        
        
         boolean estadoM = false;
        if(vista.jRadioButtonMuertoM1.isSelected()){
            estadoM = false;
        }else if(vista.jRadioButtonVivoM1.isSelected()){
            estadoM = true;
        }
        
        paciente.getHistorial().getAntecedentesFamiliares().setHospm(hospM);
        paciente.getHistorial().getAntecedentesFamiliares().setEstadom(enferMadre);
        paciente.getHistorial().getAntecedentesFamiliares().setMuertem(estadoM);
        
        paciente.getHistorial().getAntecedentesFamiliares().setHospp(hospP);
        paciente.getHistorial().getAntecedentesFamiliares().setEstadop(enferPadre);
        paciente.getHistorial().getAntecedentesFamiliares().setMuertep(estadoP);
        
  
        
        
//        HistoriaClinica historia = vista.getHistoriaClinicaa() ;
//        ventanaVisita = new VentanaVisita(vista, true, historia);
//        ventanaVisita.setVisible(true);
    }

    
    
    
    
    
    
}
