/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dao;

import estructura.ListaDoble;
import model.empleado.MedicoLaboratorio;
import model.Horario;

/**
 *
 * @author LLLL
 */
public interface MedicoLaboratorioDao {
    public ListaDoble<MedicoLaboratorio> listaMedicos();
    public void mostrarMedicos();
    public MedicoLaboratorio obtenerMedico(int id);
    public boolean guardarMedico(MedicoLaboratorio medicoLaboratorio);
    public boolean eliminarMedico(int id);
    public ListaDoble<Horario> obtenerHorarios(int id);
}
