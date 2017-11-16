/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.paciente;

import java.util.Date;

/**
 *
 * @author F20LAB303-XXE
 */
public class TratamientoRea {
    private Date fecha;
    private String tratamiento;
    private String personal;
    private int codigo;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public TratamientoRea() {
        this.fecha = null;
        this.tratamiento = null;
        this.personal = null;
        this.codigo = 0;
    }

    @Override
    public String toString() {
        return "tratamientoRea{" + "fecha=" + fecha + ", tratamiento=" + tratamiento + ", personal=" + personal + ", codigo=" + codigo + '}';
    }
    
    
    
    
}
