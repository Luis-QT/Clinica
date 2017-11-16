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
public class Diagnostico {
    private String preDia;
    private String defDia;
    private String pronostico;
    private String solicitud;

    public String getPreDia() {
        return preDia;
    }

    public void setPreDia(String preDia) {
        this.preDia = preDia;
    }

    public String getDefDia() {
        return defDia;
    }

    public void setDefDia(String defDia) {
        this.defDia = defDia;
    }

    public String isPronostico() {
        return pronostico;
    }

    public void setPronostico(String pronostico) {
        this.pronostico = pronostico;
    }

    public String getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(String solicitud) {
        this.solicitud = solicitud;
    }

    public Diagnostico() {
        this.preDia = null;
        this.defDia = null;
        this.pronostico = null;
        this.solicitud = null;
    }

    @Override
    public String toString() {
        return "diagnostico{" + "preDia=" + preDia + ", defDia=" + defDia + '}';
    }
    
    
    
}
