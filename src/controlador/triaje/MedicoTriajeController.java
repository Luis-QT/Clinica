
package controlador.triaje;

import controlador.Controller;
import gui.triaje.FrameTriaje;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
        
    }
}
