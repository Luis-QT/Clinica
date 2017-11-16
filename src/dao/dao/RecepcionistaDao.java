/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dao;

import estructura.ListaDoble;
import model.empleado.Recepcionista;
import model.Horario;

/**
 *
 * @author LLLL
 */
public interface RecepcionistaDao {
    public ListaDoble<Recepcionista> listaRecepcionistas();
    public void mostrarRecepcionistas();
    public Recepcionista obtenerRecepcionista(int id);
    public boolean guardarRecepcionista(Recepcionista recepcionista);
    public boolean eliminarRecepcionista(int id);
    public ListaDoble<Horario> obtenerHorarios(int id);
}
