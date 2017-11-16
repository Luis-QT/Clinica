/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.empleado;

/**
 *
 * @author Luis
 */
public class Paciente extends Persona {
    String nombre; 
    int codigo;
    
    public Paciente (String nombre, int c){
        this.nombre = nombre; 
        this.codigo = c;
    }
    
    public String getNombre (){
        return nombre;
    }
    public int getCodigo(){
        return codigo;
    }
    public Paciente(int id, String nombre, String apellido, int dni, char sexo, int edad, String telefonoCasa, String telefonoCelular, String email, char softDelete) {
        super(id, nombre, apellido, dni, sexo, edad, telefonoCasa, telefonoCelular, email, softDelete);
    }
    
    public String toString(){
        return "nombre: " + nombre;
    }
}
