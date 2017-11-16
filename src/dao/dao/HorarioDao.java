/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dao;

import estructura.ListaDoble;
import model.empleado.Empleado;
import model.Horario;
import model.Sala;

/**
 *
 * @author LLLL
 */
public interface HorarioDao {
    public ListaDoble<Horario> listaHorarios();
    public void mostrarHorarios();
    public Horario obtenerHorario(int id);
    public boolean guardarHorario(Horario horario);
    public boolean eliminarHorario(int id);
    public Empleado obtenerEmpleado(int id);
    public Sala obtenerSala(int id);
}
