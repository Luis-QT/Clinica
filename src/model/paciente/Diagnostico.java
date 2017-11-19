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
    private Boolean pronostico; //true favorable, false reservado
    private Boolean solicitud;

    public Diagnostico(String preDia, String defDia, Boolean pronostico, Boolean solicitud) {
        this.preDia = preDia;
        this.defDia = defDia;
        this.pronostico = pronostico;
        this.solicitud = solicitud;
    }
    public Diagnostico() {
        this.preDia = "";
        this.defDia = "";
        this.pronostico = false;
        this.solicitud = false;
    }

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

    public Boolean isPronostico() {
        return pronostico;
    }

    public void setPronostico(Boolean pronostico) {
        this.pronostico = pronostico;
    }

    public Boolean getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Boolean solicitud) {
        this.solicitud = solicitud;
    }


    @Override
    public String toString() {
        return "diagnostico{" + "preDia=" + preDia + ", defDia=" + defDia + '}';
    }
    
    
    
}
