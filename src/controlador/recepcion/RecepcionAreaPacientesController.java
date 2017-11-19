
package controlador.recepcion;

import controlador.Controller;
import gui.recepcion.FrameRecepcionAreaPacientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Luis
 */
public class RecepcionAreaPacientesController implements Controller, ActionListener{

    private FrameRecepcionAreaPacientes vista;

    public RecepcionAreaPacientesController(FrameRecepcionAreaPacientes vista) {
        this.vista = vista;
        iniciar();
    }
    
    @Override
    public void iniciar() {
        this.vista.btnBuscar.setActionCommand("Buscar");
        this.vista.btnBuscar.addActionListener(this);
        this.vista.btnOrdenar.setActionCommand("Ordenar");
        this.vista.btnOrdenar.addActionListener(this);
        this.vista.btnAgregar.setActionCommand("Agregar");
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnEliminar.setActionCommand("Elimnar");
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnRefrescar.setActionCommand("Refrescar");
        this.vista.btnRefrescar.addActionListener(this);
        this.vista.btnGuardar.setActionCommand("Guardar");
        this.vista.btnGuardar.addActionListener(this);
    }

    @Override
    public void index() {
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
