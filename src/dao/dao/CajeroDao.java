/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dao;

import estructura.ListaDoble;
import model.Horario;
import model.empleado.Cajero;

/**
 *
 * @author LLLL
 */
public interface CajeroDao {
    public ListaDoble<Cajero> listaCajeros();
    public void mostrarCajeros();
    public Cajero obtenerCajero(int id);
    public boolean guardarCajero(Cajero cajero);
    public boolean eliminarCajero(int id);
    public ListaDoble<Horario> obtenerHorarios(int id);
}
