package model.empleado;

import estructura.ListaDoble;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Optional;


public class Cajero {
    
    private ListaDoble<Servicios> listaServicios;
    private ListaDoble<Recaudado> listaRecaudoDia;
    private ListaDoble<Monto> listaMonto;

    public Cajero(ListaDoble<Servicios> listaServicios,
            ListaDoble<Recaudado> listaRecaudoDia, 
            ListaDoble<Monto> listaMonto) {
        this.listaServicios = listaServicios;
        this.listaRecaudoDia = listaRecaudoDia;
        this.listaMonto = listaMonto;
    }

    public ListaDoble<Servicios> getListaServicios() {
        return listaServicios;
    }


    public ListaDoble<Recaudado> getListaRecaudoDia() {
        return listaRecaudoDia;
    }

    public ListaDoble<Monto> getListaMonto() {
        return listaMonto;
    }

    public void setListaServicios(ListaDoble<Servicios> listaServicios) {
        this.listaServicios = listaServicios;
    }


    public void setListaRecaudoDia(ListaDoble<Recaudado> listaRecaudoDia) {
        this.listaRecaudoDia = listaRecaudoDia;
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
       
        
    Recaudado r = new Recaudado(montoNuevo.getFecha(), montoNuevo.getMonto());
        if(listaRecaudoDia.size == 0){
            listaRecaudoDia.insertarAlFinal(r);
        }else {
            if (montoNuevo.getFecha().equals(listaRecaudoDia.getFin().getDato().getFechaRecauDia())) {
                listaRecaudoDia.getFin().getDato().setMontodelDia(montoNuevo.getMonto() +listaRecaudoDia.getFin().getDato().getMontodelDia() );
            } else {
                listaRecaudoDia.insertarAlFinal(r);
            }
        }   
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


 



    
    
    

