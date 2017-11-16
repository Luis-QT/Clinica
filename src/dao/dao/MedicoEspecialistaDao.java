/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dao;

import estructura.ListaDoble;
import model.empleado.MedicoEspecialista;
import model.Horario;

/**
 *
 * @author LLLL
 */
public interface MedicoEspecialistaDao {
    public ListaDoble<MedicoEspecialista> listaMedicos();
    public void mostrarMedicos();
    public MedicoEspecialista obtenerMedico(int id);
    public boolean guardarMedico(MedicoEspecialista medicoEspecialista);
    public boolean eliminarMedico(int id);
    public ListaDoble<Horario> obtenerHorarios(int id);
}
