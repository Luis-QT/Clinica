/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dao;

import estructura.ListaDoble;
import java.util.List;
import model.empleado.MedicoGeneral;
import model.Horario;

/**
 *
 * @author LLLL
 */
public interface MedicoGeneralDao {
    public ListaDoble<MedicoGeneral> listaMedicos();
    public void mostrarMedicos();
    public MedicoGeneral obtenerMedico(int id);
    public boolean guardarMedico(MedicoGeneral medicoGeneral);
    public boolean eliminarMedico(int id);
    public ListaDoble<Horario> obtenerHorarios(int id);
}
