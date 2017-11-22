/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.administrador;

import controlador.Controller;
import dao.recepcion.RecepcionImpl;
import estructura.ListaDoble;
import gui.administrador.paciente.FramePacientes;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import model.paciente.Paciente;

/**
 *
 * @author LLLL
 */
public class PacienteController implements Controller{
    
    FramePacientes vista;
    private ListaDoble<Paciente> listaPaciente;

    public PacienteController(FramePacientes FramePaciente) {
        this.vista = FramePaciente;
        iniciar();
    }
    
    
    @Override
    public void iniciar() {
        RecepcionImpl recepcionDao = new RecepcionImpl();
        listaPaciente = recepcionDao.listaPaciente();
        
        this.vista.btnCerrar.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    vista.setVisible(false);
                }
            });
        
        llenarTabla();
    }
    
    
    
    @Override
    public void index() {
        vista.setVisible(true);
    }
    
    private void llenarTabla(){
        DefaultTableModel dtm = (DefaultTableModel) vista.tabla.getModel();
        dtm.setRowCount(0);
        Iterator<Paciente> iterador = listaPaciente.getDescendingIterator();
        while (iterador.hasNext()) {
            Paciente pro = iterador.next();
            dtm.addRow(new Object[]{pro.getId(), pro.getNombre(), pro.getApellido(), pro.getDni(),
                pro.getEdad(), pro.getTelefonoCasa(), pro.getTelefonoCelular(),
                pro.getEmail()});
        }
    }
    
}
