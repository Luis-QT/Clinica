
package controlador.historial;

import controlador.Controller;
import gui.historiaMedica.VentanaVisita;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.paciente.Anamnesis;
import model.paciente.DatosMedico;
import model.paciente.Diagnostico;
import model.paciente.ExamenFisicos;
import model.paciente.Visita;


public class VisitaController implements Controller,ActionListener {

    VentanaVisita vista; 
    public VisitaController(VentanaVisita vista) {
        this.vista = vista;
        iniciar ();
    }
    
    
    @Override
    public void iniciar() {
        vista.btnRegistrarVisita.setActionCommand("Registrar Visita");
        vista.btnRegistrarVisita.addActionListener(this);
        
    }

    @Override
    public void index() {
       vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        
        if(comando.equals("Registrar Visita")){
            formRegistrarVisita();
        }
        
    }

    private void formRegistrarVisita() {
        
        Visita visita = vista.getVisita();
        
          /**ANAMNESIS**/
        String motivo = vista.jTextAreaAnamnesis.getText();
        String curso = vista.jTextFieldCursoEnfermedad.getText();
        String enferActual = vista.jTextFieldEnfermedadActual.getText();
        Anamnesis anamnesis = new Anamnesis(motivo, curso, enferActual);
        visita.setAnamnecis(anamnesis);
        
        /*DIAGNOSTICO*/
        String preDia = vista.jTextFieldDiagnosticoPre1.getText();
        String defDia = vista.jTextFieldDiagnosticoDef1.getText();
        boolean pronostico = false;
        if(vista.jRadioButtonFavorable1.isSelected()){
            pronostico = true;
        }else if(vista.jRadioButtonReservado1.isSelected()){
            pronostico = false;
        }
        boolean solicitud = false;
        if(vista.jRadioButton2.isSelected()){
            solicitud = true;
        }
        Diagnostico diagnostico = new Diagnostico(preDia, defDia, pronostico,solicitud);
        visita.setDiagnostico(diagnostico);
        
        /*EXAMEN MÉDICO*/
        String cabezaobs = vista.txtCabezaObs.getText();
        String cabezaaus = vista.txtCabezaAus.getText();
        String cabezaper=  vista.txtCabezaPre.getText();
        String torzoobs= vista.txtTorsoObs.getText();
        String torzoaus= vista.txtTorsoAus.getText();
        String torzoper= vista.txtTorsoPre.getText();
        String abdomenobs= vista.txtAbdomenObs.getText();
        String abdomenaus= vista.txtAbdomemAus.getText();
        String abdomenper= vista.txtAbdomenPre.getText();
        String espaldaobs= vista.txtEspaldaObs.getText();
        String espaldaaus= vista.txtEspaldaAus.getText();
        String espaldaper= vista.txtEspaldaPre.getText();
        String extreobs= vista.txtExtreObs.getText();
        String extreaus= vista.txtExtreAus.getText();
        String extreper= vista.txtExtrePre.getText();
        ExamenFisicos examenF = new ExamenFisicos(cabezaobs, cabezaaus, cabezaper, torzoobs, torzoaus, torzoper, abdomenobs, abdomenaus, abdomenper, espaldaobs, espaldaaus, espaldaper, extreobs, extreaus, extreper);
        visita.setExamenFisico(examenF);
        
        /*DATOS MEDICO*/
        String nombreMedico = vista.txtNombreMedico.getText();
        String especialidad = vista.txtEspecialidad.getText();
        DatosMedico datoMedico= new DatosMedico(motivo, especialidad);
        visita.setDatosMedico(datoMedico);
        
        /*MEDICINA Y RECOMENDACIONES*/
        String medicina = vista.txtMedicina.getText();
        visita.setMedicina(medicina);
        String recomen = vista.txtRecomendaciones.getText();
        visita.setRecomendaciones(recomen);
        vista.dispose();
    }
    
}
