
package dao.medicoGeneral;

import dao.medicoGeneral.*;
import estructura.ListaDoble;
import model.paciente.Paciente;

public interface MedicoGeneralDao {
    public ListaDoble<Paciente> listaPacientes();
    public void mostrarPacientes();
    public Paciente obtenerPaciente(int id);
    public boolean guardarPaciente(Paciente paciente);
    public boolean eliminarPaciente(int id);
    public ListaDoble<Paciente> obtenerHorarios(int id);
}
