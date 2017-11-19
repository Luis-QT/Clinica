
package controlador.historial;

import controlador.Controller;
import gui.medicoGeneral.VentanaVisita;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VisitaController implements Controller,ActionListener {

    VentanaVisita vista; 
    public VisitaController(VentanaVisita vista) {
        this.vista = vista;
        iniciar ();
    }
    
    
    @Override
    public void iniciar() {
        
    }

    @Override
    public void index() {
       vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
    }
    
}
