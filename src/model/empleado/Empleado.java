/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.empleado;

import estructura.ListaDoble;
import java.util.List;

/**
 *
 * @author LLLL
 */
public abstract class Empleado extends Persona{
    private ListaDoble horarios;

    public Empleado(ListaDoble horarios, int id, String nombre, String apellido, int dni, boolean sexo, int edad, int telefonoCasa, int telefonoCelular, String email, int softDelete) {
        super(id, nombre, apellido, dni, sexo, edad, telefonoCasa, telefonoCelular, email, softDelete);
        this.horarios = horarios;
    }

    public ListaDoble getHorarios() {
        return horarios;
    }

    public void setHorarios(ListaDoble horarios) {
        this.horarios = horarios;
    }

  
    
}
