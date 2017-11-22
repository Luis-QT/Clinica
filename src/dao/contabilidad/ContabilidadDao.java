
package dao.contabilidad;

import estructura.ListaDoble;
import model.PlanTratamiento;
import model.empleado.Servicios;
import model.paciente.Paciente;


public interface  ContabilidadDao {
    public ListaDoble<PlanTratamiento> listaPlanTratamiento();
    public void mostrarPlanTratamiento();
    public Paciente obtenerPlanTratamiento(int id);
    public boolean guardarPlanTratamiento(Paciente paciente);
    public boolean eliminarPlanTratamiento(int id);
}
