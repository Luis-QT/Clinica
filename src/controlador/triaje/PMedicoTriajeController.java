
package controlador.triaje;

import controlador.Controller;
import dao.triaje.TriajeDao;
import dao.triaje.TriajeDaoImp;
import estructura.ListaDoble;
import gui.historiaMedica.FrameHistoriaClinica;
import gui.triaje.FrameTriaje;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import model.paciente.Paciente;


public class PMedicoTriajeController implements Controller,ActionListener {
    private FrameTriaje vista;
    private ListaDoble<Paciente> listaPacientes;
    public PMedicoTriajeController(FrameTriaje vista) {
        System.out.println("ENTRO 1");
        this.vista = vista;
        iniciar();
        
    }
    
    @Override
    public void iniciar() {
         this.vista.jButton2.setActionCommand("Ver Historial");
        this.vista.jButton2.addActionListener(this);
        System.out.println("ENTRO 2");
        TriajeDao triajeDao = new TriajeDaoImp();
        
        listaPacientes = triajeDao.listaPaciente();
        System.out.println("ENTRO 3");
        
        System.out.println("Lista:" + listaPacientes.toString());
        mostrarTabla();
    }

    @Override
    public void index() {
        vista.setVisible(true);
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
        Paciente paciente = listaPacientes.getDato(posicion);
        FrameHistoriaClinica historial = new FrameHistoriaClinica(paciente);
        historial.setVisible(true);  
    }
    
    public void mostrarTabla() {
        DefaultTableModel dtm = (DefaultTableModel) vista.tablaPacientes.getModel();
        dtm.setRowCount(0);
        Iterator<Paciente> iterador = listaPacientes.getDescendingIterator();
        while (iterador.hasNext()) {
            Paciente pro = iterador.next();
            dtm.addRow(new Object[]{pro.getNombre(), pro.getApellido(),
                pro.getAlergia(), pro.getDni()});
        }
    }
    
    
    
}
