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
public abstract class EmpleadoUser extends Empleado{
    private String codigo; 
    private String contraseña;

    public EmpleadoUser(String codigo, String contraseña, ListaDoble horarios, int id, String nombre, String apellido, int dni, boolean sexo, int edad, int telefonoCasa, int telefonoCelular, String email, int softDelete) {
        super(horarios, id, nombre, apellido, dni, sexo, edad, telefonoCasa, telefonoCelular, email, softDelete);
        this.codigo = codigo;
        this.contraseña = contraseña;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}
