/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.paciente;

import estructura.ListaDoble;
import java.time.LocalDate;

/**
 *
 * @author F20LAB303-XXE
 */
public class TemporadaTratamiento {
    private int id;
    private int idTemporada;
    private LocalDate fechaInicio;
    private String motivo;
    private ListaDoble<Visita> listaVisitas;
    
    public TemporadaTratamiento() {
        this.id = 0;
        this.fechaInicio = LocalDate.now();
        this.motivo = "";
        this.listaVisitas = new ListaDoble<>();
    }

    public TemporadaTratamiento(int id, int idTemporada, LocalDate fechaInicio, String motivo) {
        this.idTemporada = idTemporada;
        this.id = id;
        this.fechaInicio = fechaInicio;
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


    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

   
    
}
