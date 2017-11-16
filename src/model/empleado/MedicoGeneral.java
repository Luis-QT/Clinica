/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.empleado;

import estructura.ListaDoble;

/**
 *
 * @author LLLL
 */
public class MedicoGeneral extends Medico{
    
    public MedicoGeneral(String colegiatura, String codigo, String contraseña, ListaDoble horarios, int id, String nombre, String apellido, int dni, boolean sexo, int edad, int telefonoCasa, int telefonoCelular, String email, int softDelete) {
        super(colegiatura, codigo, contraseña, horarios, id, nombre, apellido, dni, sexo, edad, telefonoCasa, telefonoCelular, email, softDelete);
    }
    
}
