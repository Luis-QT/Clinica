/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dao;

import estructura.ListaDoble;
import model.Horario;
import model.Sala;

/**
 *
 * @author LLLL
 */
public interface SalaDao {
    public ListaDoble<Sala> listaSalas();
    public void mostrarSalas();
    public Sala obtenerSala(int id);
    public boolean guardarSala(Sala medicoGeneral);
    public boolean eliminarSala(int id);
    public ListaDoble<Horario> obtenerHorarios(int id);
}
