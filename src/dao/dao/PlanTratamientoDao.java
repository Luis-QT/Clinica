/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dao;

import estructura.ListaDoble;
import model.PlanTratamiento;

/**
 *
 * @author LLLL
 */
public interface PlanTratamientoDao {
    public ListaDoble<PlanTratamiento> listaTratamientos();
    public void mostrarTratamientos();
    public PlanTratamiento obtenerTratamiento(int id);
    public boolean guardarTratamiento(PlanTratamiento planTratamiento);
    public boolean eliminarTratamiento(int id);
    
}
