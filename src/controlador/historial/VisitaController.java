
package controlador.historial;

import controlador.Controller;
import gui.medicoGeneral.VentanaVisita;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        
         //NOMBRE MEDICO
        vista.txtNombreMedico.setText(visita.getDatosMedico().getNombre());
        vista.txtEspecialidad.setText(visita.getDatosMedico().getEspecializacion());
        //ANAMNSESIS
        vista.jTextAreaAnamnesis.setText(visita.getAnamnecis().getMotivo());
        vista.jTextFieldCursoEnfermedad.setText(visita.getAnamnecis().getCurso());
        vista.jTextFieldEnfermedadActual.setText(visita.getAnamnecis().getEnferActual());
        
        vista.txtCabezaObs.setText(visita.getExamenFisico().getCabezaobs());
        vista.txtCabezaAus.setText(visita.getExamenFisico().getCabezaaus());
        vista.txtCabezaPre.setText(visita.getExamenFisico().getCabezaper());
        
        vista.txtAbdomenObs.setText(visita.getExamenFisico().getAbdomenobs());
        vista.txtAbdomemAus.setText(visita.getExamenFisico().getAbdomenaus());
        vista.txtAbdomenPre.setText(visita.getExamenFisico().getAbdomenper());
        
        vista.txtEspaldaObs.setText(visita.getExamenFisico().getAbdomenobs());
        vista.txtEspaldaAus.setText(visita.getExamenFisico().getAbdomenaus());
        vista.txtEspaldaPre.setText(visita.getExamenFisico().getAbdomenper());
        
        vista.txtExtreObs.setText(visita.getExamenFisico().getExtreobs());
        vista.txtExtreAus.setText(visita.getExamenFisico().getExtreaus());
        vista.txtExtrePre.setText(visita.getExamenFisico().getExtreper());

        vista.txtTorsoObs.setText(visita.getExamenFisico().getTorzoobs());
        vista.txtTorsoAus.setText(visita.getExamenFisico().getTorzoaus());
        vista.txtTorsoPre.setText(visita.getExamenFisico().getTorzoper());
        
        
        vista.jTextFieldDiagnosticoPre1.setText(visita.getDiagnostico().getPreDia());
        vista.jTextFieldDiagnosticoDef1.setText(visita.getDiagnostico().getDefDia());
        if(visita.getDiagnostico().getSolicitud()){
            vista.jRadioButton2.setSelected(true);
        }
        
        if(visita.getDiagnostico().isPronostico()){
            vista.jRadioButtonFavorable1.setSelected(true);
        }else if(!visita.getDiagnostico().isPronostico()){
            vista.jRadioButtonReservado1.setSelected(true);
        }

    }
    
}
