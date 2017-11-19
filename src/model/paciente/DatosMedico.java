/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.paciente;

/**
 *
 * @author F20LAB303-XXE
 */
public class DatosMedico {

    private String nombreApellido;
    private int especializacion;

    public DatosMedico(String nombre, int especializacion) {
        this.nombreApellido = nombre;
        this.especializacion = especializacion;
    }

    public DatosMedico() {
       this.nombreApellido = "";
        this.especializacion = 0;
    }

    public String getNombre() {
        return nombreApellido;
    }

  

    public int getEspecializacion() {
        return especializacion;
    }

    
    
    @Override
    public String toString() {
        return "datosMedico{" + "nombre=" + nombreApellido + ", apellido=" + especializacion + '}';
    }

}
