/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.paciente;

import java.time.LocalDate;

/**
 *
 * @author F20LAB303-XXE
 */
public class TemporadaTratamiento {
    private int id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String doctor;
    private String motivo;

    public TemporadaTratamiento() {
        this.id = 0;
        this.fechaInicio = LocalDate.now();
        this.fechaFin = LocalDate.now();
        this.doctor = "";
        this.motivo = "";
    }

    public TemporadaTratamiento(int id, LocalDate fechaInicio, LocalDate fechaFin, String doctor, String motivo) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.doctor = doctor;
        this.motivo = motivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

   
    
}
