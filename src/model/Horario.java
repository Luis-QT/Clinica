/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.empleado.Empleado;
import model.Sala;

/**
 *
 * @author LLLL
 */
public class Horario {
    private int id;
    private String dia;
    private String horaEntrada;
    private String horaSalida;
    private Empleado empleado;
    private Sala sala;
    private int tipoEmpleado;
    private int empleadoId;
    private int salaId;
    private boolean eliminar;

    public Horario(int id, String dia, String horaEntrada, String horaSalida, Empleado empleado, Sala sala, int tipoEmpleado, int empleadoId, int salaId) {
        this.id = id;
        this.dia = dia;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.empleado = empleado;
        this.sala = sala;
        this.tipoEmpleado = tipoEmpleado;
        this.empleadoId = empleadoId;
        this.salaId = salaId;
        this.eliminar = false;
    }

    public boolean isEliminar() {
        return eliminar;
    }

    public void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
    }

   
    public int getSalaId() {
        return salaId;
    }

    public void setSalaId(int salaId) {
        this.salaId = salaId;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    
    public int getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(int tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

     

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    

    
    
}
