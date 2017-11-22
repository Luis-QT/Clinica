
package dao.contabilidad;

import estructura.ListaDoble;
import model.empleado.Servicios;
import model.paciente.Paciente;


public interface  ContabilidadDao {
    public ListaDoble<Servicios> listaServicios();
    public void mostrarServicios();
    public Paciente obtenerServicios(int id);
    public boolean guardarServicios(Paciente paciente);
    public boolean eliminarServicios(int id);
}
