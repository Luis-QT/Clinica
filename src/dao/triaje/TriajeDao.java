/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.triaje;

import estructura.ListaDoble;
import model.paciente.Paciente;

public interface TriajeDao{
    public ListaDoble<Paciente> listaPaciente();
    public void mostrarPacientes();
    public Paciente obtenerPaciente(int id);
    public boolean guardarPaciente(Paciente paciente);
    public boolean eliminarPaciente(int id);
    
    
}
