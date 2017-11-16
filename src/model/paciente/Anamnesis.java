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
public class Anamnesis {
    private String motivo;
    private String curso;
    private String enferActual;

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getEnferActual() {
        return enferActual;
    }

    public void setEnferActual(String enferActual) {
        this.enferActual = enferActual;
    }

    public Anamnesis() {
        this.motivo = "";
        this.curso = "";
        this.enferActual = "";
    }

    @Override
    public String toString() {
        return "Anamnesis{" + "motivo=" + motivo + ", curso=" + curso + ", enferActual=" + enferActual + '}';
    }
    
    
    
}
