/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.empleado;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import model.Horario;
import model.paciente.HistoriaClinica;
import estructura.ListaDoble;
import model.paciente.Paciente;

/**
 *
 * @author LLLL
 */
public class MedicoGeneral extends Medico{

    private ListaDoble<Paciente> listaPaciente;
    
    /**
 * 
 * @param colegiatura
 * @param codigo
 * @param contraseña
 * @param horarios
 * @param id
 * @param nombre
 * @param apellido
 * @param dni
 * @param sexo
 * @param edad
 * @param telefonoCasa
 * @param telefonoCelular
 * @param email
 * @param softDelete 
 */
    
    
    public MedicoGeneral(String colegiatura, String codigo, String contraseña, ListaDoble horarios, int id, String nombre, String apellido, int dni, boolean sexo, int edad, int telefonoCasa, int telefonoCelular, String email, int softDelete) {
        super(colegiatura, codigo, contraseña, horarios, id, nombre, apellido, dni, sexo, edad, telefonoCasa, telefonoCelular, email, softDelete);
        listaPaciente = new ListaDoble<Paciente>();
    }
    public ListaDoble<Paciente> getListaPaciente (){
        return listaPaciente;
    } 
    
    public void agregarPaciente(Paciente paciente){
        listaPaciente.insertarAlFinal(paciente);
    }
    
    public ListaDoble<Paciente> buscarporCodigo (String codigo){
        ListaDoble<Paciente> lista = new ListaDoble<Paciente>();
        
        Iterator<Paciente> it = listaPaciente.getDescendingIterator();
        while(it.hasNext()){
            Paciente paciente = it.next();
            if(String.valueOf(paciente.getId()).contains(codigo)){
                lista.insertarAlFinal(paciente);
            }  
        }
        return lista;        
    }
    
    public ListaDoble<Paciente> buscarporApellido (String apellido){
        ListaDoble<Paciente> lista = new ListaDoble<Paciente>();
        
        Iterator<Paciente> it = listaPaciente.getDescendingIterator();
        while(it.hasNext()){
            Paciente paciente = it.next();
            if(paciente.getApellido().toUpperCase().contains(apellido.toUpperCase())){
                lista.insertarAlFinal(paciente);
            }  
        }      
        return lista;
    }    
    
    public void eliminarPaciente(int posicion){
        listaPaciente.eliminarPos(posicion);
    }
    
    public HistoriaClinica retornarHistoriaclinica (int posicionPaciente){
        Paciente paciente = listaPaciente.getDato(posicionPaciente);
        return paciente.getHistorial();
    }    
    
        
    }
    
