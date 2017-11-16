/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.empleado;

/**
 *
 * @author LLLL
 */
public class Horario {
    private String dia;
    private String horaEntrada;
    private String horaSalida;
    private Empleado empleado;

    public Horario(String dia, String horaEntrada, String horaSalida, Empleado empleado) {
        this.dia = dia;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.empleado = empleado;
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
    
}
