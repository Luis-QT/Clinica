package model.empleado;

import estructura.ListaDoble;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Optional;
import model.paciente.Paciente;

public class Cajero extends EmpleadoUser{
    
    private ListaDoble<Servicios> listaServicios;
    private ListaDoble<Monto> listaMonto;
    private ListaDoble<Paciente> listaPaciente;

    public Cajero(String codigo, String contraseña,
            ListaDoble horarios, int id, String nombre, String apellido, int dni,
            boolean sexo, int edad, int telefonoCasa, int telefonoCelular,
            String email, int softDelete) {
        
        super(codigo, contraseña, horarios, id, nombre, apellido, dni, sexo,
                edad, telefonoCasa, telefonoCelular, email, softDelete);
        
        
        listaServicios = new ListaDoble<Servicios>();
        listaMonto = new ListaDoble<Monto>();
        listaPaciente = new ListaDoble<Paciente>();
        
    }
    public ListaDoble<Paciente> getListaPaciente (){
        return listaPaciente;
    }    
   
    
    public void agregarPaciente(Paciente paciente){
        listaPaciente.insertarAlFinal(paciente);
    }
    
  

    public ListaDoble<Servicios> getListaServicios() {
        return listaServicios;
    }

    public void agregarServicios(Servicios servicio){
        listaServicios.insertarAlFinal(servicio);
    }
    

    public ListaDoble<Monto> getListaMonto() {
        return listaMonto;
    }

    public void setListaServicios(ListaDoble<Servicios> listaServicios) {
        this.listaServicios = listaServicios;
    }


   

    public void setListaMonto(ListaDoble<Monto> listaMonto) {
        this.listaMonto = listaMonto;
    }



    /**
     * GregorianCalendar d = new GregorianCalendar();
        
        int anio = d.get(Calendar.YEAR);
        int mes = d.get(Calendar.MONTH) + 1;
        int dia = d.get(Calendar.DAY_OF_MONTH);
     */
    
    
    
    
    
    /*         
          **********      MÉTODOS      **************
    */
    
    public void montoActualDia(Monto montoNuevo) {
       
        
     
    }


    public ListaDoble<Servicios> bucarServicio(String busca) {
        ListaDoble<Servicios> aux = new ListaDoble<Servicios>();

        listaServicios.stream().filter(n -> n.getNombreServicio().equalsIgnoreCase(busca)).
                forEach(n -> aux.insertarAlFinal(n));
        return aux;

    }

    public ListaDoble<Servicios> ordenarporConsultas() {
        ListaDoble<Servicios> aux = new ListaDoble<Servicios>();

        listaServicios.stream().filter(n -> n.isId() == true).
                forEach(n -> aux.insertarAlFinal(n));
        return aux;
    }

    public ListaDoble<Servicios> ordenarporLaboratorio() {
        ListaDoble<Servicios> aux = new ListaDoble<Servicios>();

        listaServicios.stream().filter(n -> n.isId() == false).
                forEach(n -> aux.insertarAlFinal(n));
        return aux;
    }

    public ListaDoble<Servicios> ordenarPrecios() {
        ListaDoble<Servicios> aux = new ListaDoble<Servicios>();

        listaServicios.stream().sorted((n1, n2) -> n1.getPrecio().compareTo(n2.getPrecio())).
                forEach(n -> aux.insertarAlFinal(n));
        return aux;
    }

}



