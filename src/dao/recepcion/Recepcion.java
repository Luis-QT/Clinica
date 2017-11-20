/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.recepcion;

import estructura.ListaDoble;
import model.PlanTratamiento;
import model.paciente.Paciente;

/**
 *
 * @author Luis
 */
public interface Recepcion {
    public ListaDoble<Paciente> listaPaciente();
    public void mostrarPacientes();
    public Paciente obtenerPaciente(int id);
    public boolean guardarPaciente(Paciente paciente);
    public boolean eliminarPaciente(int id);
}
