
package model.empleado;

import model.paciente.Paciente;
import estructura.ListaDoble;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import model.Horario;
import model.paciente.HistoriaClinica;

public class MedicoEspecialista extends Medico{
    private String especialidad;
    private ListaDoble<Paciente> listaPaciente;
/**
 * 
 * @param especialidad
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
    
    //HOLAAAAA 
    public MedicoEspecialista(String especialidad,String colegiatura, String codigo, String contraseña, ListaDoble<Horario> horarios, int id, String nombre, String apellido, int dni, boolean sexo, int edad, int telefonoCasa, int telefonoCelular, String email, int softDelete) {
        super(colegiatura, codigo,contraseña,horarios,id, nombre, apellido, dni, sexo, edad, telefonoCasa, telefonoCelular, email, softDelete);
        this.especialidad = especialidad;
        listaPaciente = new ListaDoble<Paciente>();
    }


    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
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
            if(paciente.getCodigo().toUpperCase().contains(codigo.toUpperCase())){
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
