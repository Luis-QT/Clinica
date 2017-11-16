/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dao;

import estructura.ListaDoble;
import model.empleado.MedicoTriaje;
import model.Horario;

/**
 *
 * @author LLLL
 */
public interface MedicoTriajeDao {
    public ListaDoble<MedicoTriaje> listaMedicos();
    public void mostrarMedicos();
    public MedicoTriaje obtenerMedico(int id);
    public boolean guardarMedico(MedicoTriaje medicoTriaje);
    public boolean eliminarMedico(int id);
    public ListaDoble<Horario> obtenerHorarios(int id);
}
