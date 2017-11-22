/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dao;

import model.empleado.Administrador;

/**
 *
 * @author LLLL
 */
public interface AdministradorDao {
    public void mostrarAdministrador();
    public Administrador obtenerAdministrador();
    public boolean guardarAdministrador(Administrador administrador);
}
