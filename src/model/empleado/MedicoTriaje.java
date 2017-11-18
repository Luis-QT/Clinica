/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.empleado;

import estructura.ListaDoble;
import model.paciente.Paciente;

/**
 *
 * @author LLLL
 */
public class MedicoTriaje extends Medico{
    private ListaDoble<Paciente> listaPaciente;

    public MedicoTriaje(String colegiatura, String codigo, String contraseña, ListaDoble horarios, int id, String nombre, String apellido, int dni, boolean sexo, int edad, int telefonoCasa, int telefonoCelular, String email, int softDelete) {
        super(colegiatura, codigo, contraseña, horarios, id, nombre, apellido, dni, sexo, edad, telefonoCasa, telefonoCelular, email, softDelete);
        this.listaPaciente = new ListaDoble<>();
    }

    public ListaDoble<Paciente> getListaPaciente() {
        return listaPaciente;
    }

    public void setListaPaciente(ListaDoble<Paciente> listaPaciente) {
        this.listaPaciente = listaPaciente;
    }

    
}
