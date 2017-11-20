/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.empleado;

import model.paciente.Paciente;
import estructura.ListaDoble;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author LLLL
 */
public class Recepcionista extends EmpleadoUser {

    private ListaDoble<Paciente> listaPaciente;

    public Recepcionista() {
        super("", "", null, 0, "", "", 0, true, 0, 0, 0, "", 0);
        listaPaciente = new ListaDoble<>();
    }

    /**
     *
     * @param listaPaciente
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
    public Recepcionista(String codigo, String contraseña, ListaDoble horarios, int id, String nombre, String apellido, int dni, boolean sexo, int edad, int telefonoCasa, int telefonoCelular, String email, int softDelete) {
        super(codigo, contraseña, horarios, id, nombre, apellido, dni, sexo, edad, telefonoCasa, telefonoCelular, email, softDelete);

        this.listaPaciente = new ListaDoble<>();
    }

    public ListaDoble<Paciente> getListaPaciente() {
        return listaPaciente;
    }

    public void agregarPaciente(Paciente paciente){
        listaPaciente.insertarAlFinal(paciente);
        paciente.setSoftDelete(2);
    }
    public void agregarPaciente(int id, String nombre, String apellido,
            int dni, boolean sexo, int edad, int telefonoCasa, int tefefonoCelular, String email, String tipoSangre, String alergias, String codigoP) {
        Paciente paciente = new Paciente(id, nombre, apellido, dni, sexo, edad, telefonoCasa, tefefonoCelular, email, 3, tipoSangre, alergias);

        listaPaciente.insertarAlFinal(paciente);
        paciente.setSoftDelete(2);
    }

    public void modificaPaciente(Paciente paciente, int posicion){
        
        Paciente p = listaPaciente.getDato(posicion);
        p.setNombre(paciente.getNombre());
        p.setApellido(paciente.getApellido());
        p.setDni(paciente.getDni());
        p.setEdad(paciente.getEdad());
        p.setSexo(paciente.isSexo());
        p.setTelefonoCasa(paciente.getTelefonoCasa());
        p.setTelefonoCelular(paciente.getTelefonoCelular());
        p.setEmail(paciente.getEmail());
    }
    
    public void modificaPaciente(int pos, String nombre, String apellido,
            int dni, boolean sexo, int edad, int telefono, int celular, String correo) {
        Paciente p = listaPaciente.getDato(pos);
        p.setNombre(nombre);
        p.setApellido(apellido);
        p.setDni(dni);
        p.setEdad(edad);
        p.setSexo(sexo);
        p.setTelefonoCasa(telefono);
        p.setTelefonoCelular(celular);
        p.setEmail(correo);

    }

    public void eliminarPaciente(int pos) {
        listaPaciente.eliminarPos(pos);
    }

    public void ordenarPorNombre() {
        Comparator<Paciente> comparadorNombre
                = (p1, p2) -> (p1.getNombre().compareTo(p2.getNombre()));
        ;
        listaPaciente.setComparador(comparadorNombre);
        listaPaciente.ordenarPorBurbuja();
    }

    public void ordenarPorApellido() {
        Comparator<Paciente> comparadorApellido
                = (p1, p2) -> (p1.getApellido().compareTo(p2.getApellido()));
        ;
        listaPaciente.setComparador(comparadorApellido);
        listaPaciente.ordenarPorBurbuja();
    }

    public void ordenarPorEdad() {
        Comparator<Paciente> comparadorEdad
                = (p1, p2) -> (p1.getEdad().compareTo(p2.getEdad()));
        ;
        listaPaciente.setComparador(comparadorEdad);
        listaPaciente.ordenarPorBurbuja();
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
     
     public ListaDoble<Paciente> buscarporDNI (int DNI){
        ListaDoble<Paciente> lista = new ListaDoble<Paciente>();
        
        Iterator<Paciente> it = listaPaciente.getDescendingIterator();
        while(it.hasNext()){
            Paciente paciente = it.next();
            if(paciente.getDni() == DNI ){
                lista.insertarAlFinal(paciente);
            }  
        }
        return lista;        
    }

}
