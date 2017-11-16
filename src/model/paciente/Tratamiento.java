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
public class Tratamiento {
    private String traTipo;
    private String duracion;
    private String cantidad;
    private String tratamiento;

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getTraTipo() {
        return traTipo;
    }

    public void setTraTipo(String traTipo) {
        this.traTipo = traTipo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Tratamiento() {
        this.traTipo = null;
        this.duracion = null;
        this.cantidad = null;
        this.tratamiento = null;
    }

    

    

    @Override
    public String toString() {
        return "Tratamiento{" + "traTipo=" + traTipo + ", duracion=" + duracion + '}';
    }
    
    
}
