/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import estructura.ListaDoble;

/**
 *
 * @author LLLL
 */
public class Sala {
    private int id;
    private String nombre;
    private String descripcion;
    private ListaDoble<Horario> horarios;
    private boolean delete;

    

    public Sala(int id, String nombre, String descripcion, ListaDoble<Horario> horarios) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.horarios = horarios;
        delete = false;
    }
    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ListaDoble<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(ListaDoble<Horario> horarios) {
        this.horarios = horarios;
    }
}
