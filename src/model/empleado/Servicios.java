
package model.empleado;


public class Servicios {
    String nombreServicio;
    Float precio;
    Boolean id;// T consulta , F laboratorio

  

    public Servicios(String nombreServicio, Float precio, boolean id) {
        this.nombreServicio = nombreServicio;
        this.precio = precio;
        this.id = id;
    }

    public boolean isId() {
        return id;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Servicios{" + "nombreServicio=" + nombreServicio + ", precio=" + precio + ", id=" + id + '}';
    }
    
    
    
}
