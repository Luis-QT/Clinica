/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.paciente;

/**
 *
 * @author Luis
 */



public class ExamenFisicos {
    private String cabezaobs;
    private String cabezaaus;
    private String cabezaper;
    private String torzoobs;
    private String torzoaus;
    private String torzoper;
    private String abdomenobs;
    private String abdomenaus;
    private String abdomenper;
    private String espaldaobs;
    private String espaldaaus;
    private String espaldaper;
    private String extreobs;
    private String extreaus;
    private String extreper;

    public ExamenFisicos() {
        this.cabezaobs = "";
        this.cabezaaus = "";
        this.cabezaper = "";
        this.torzoobs = "";
        this.torzoaus = "";
        this.torzoper = "";
        this.abdomenobs = "";
        this.abdomenaus = "";
        this.abdomenper = "";
        this.espaldaobs = "";
        this.espaldaaus = "";
        this.espaldaper = "";
        this.extreobs = "";
        this.extreaus = "";
        this.extreper = "";
    }

    public ExamenFisicos(String cabezaobs, String cabezaaus, String cabezaper, String torzoobs, String torzoaus, String torzoper, String abdomenobs, String abdomenaus, String abdomenper, String espaldaobs, String espaldaaus, String espaldaper, String extreobs, String extreaus, String extreper) {
        this.cabezaobs = cabezaobs;
        this.cabezaaus = cabezaaus;
        this.cabezaper = cabezaper;
        this.torzoobs = torzoobs;
        this.torzoaus = torzoaus;
        this.torzoper = torzoper;
        this.abdomenobs = abdomenobs;
        this.abdomenaus = abdomenaus;
        this.abdomenper = abdomenper;
        this.espaldaobs = espaldaobs;
        this.espaldaaus = espaldaaus;
        this.espaldaper = espaldaper;
        this.extreobs = extreobs;
        this.extreaus = extreaus;
        this.extreper = extreper;
    }
    
    

    public String getCabezaobs() {
        return cabezaobs;
    }

    public void setCabezaobs(String cabezaobs) {
        this.cabezaobs = cabezaobs;
    }

    public String getCabezaaus() {
        return cabezaaus;
    }

    public void setCabezaaus(String cabezaaus) {
        this.cabezaaus = cabezaaus;
    }

    public String getCabezaper() {
        return cabezaper;
    }

    public void setCabezaper(String cabezaper) {
        this.cabezaper = cabezaper;
    }

    public String getTorzoobs() {
        return torzoobs;
    }

    public void setTorzoobs(String torzoobs) {
        this.torzoobs = torzoobs;
    }

    public String getTorzoaus() {
        return torzoaus;
    }

    public void setTorzoaus(String torzoaus) {
        this.torzoaus = torzoaus;
    }

    public String getTorzoper() {
        return torzoper;
    }

    public void setTorzoper(String torzoper) {
        this.torzoper = torzoper;
    }

    public String getAbdomenobs() {
        return abdomenobs;
    }

    public void setAbdomenobs(String abdomenobs) {
        this.abdomenobs = abdomenobs;
    }

    public String getAbdomenaus() {
        return abdomenaus;
    }

    public void setAbdomenaus(String abdomenaus) {
        this.abdomenaus = abdomenaus;
    }

    public String getAbdomenper() {
        return abdomenper;
    }

    public void setAbdomenper(String abdomenper) {
        this.abdomenper = abdomenper;
    }

    public String getEspaldaobs() {
        return espaldaobs;
    }

    public void setEspaldaobs(String espaldaobs) {
        this.espaldaobs = espaldaobs;
    }

    public String getEspaldaaus() {
        return espaldaaus;
    }

    public void setEspaldaaus(String espaldaaus) {
        this.espaldaaus = espaldaaus;
    }

    public String getEspaldaper() {
        return espaldaper;
    }

    public void setEspaldaper(String espaldaper) {
        this.espaldaper = espaldaper;
    }

    public String getExtreobs() {
        return extreobs;
    }

    public void setExtreobs(String extreobs) {
        this.extreobs = extreobs;
    }

    public String getExtreaus() {
        return extreaus;
    }

    public void setExtreaus(String extreaus) {
        this.extreaus = extreaus;
    }

    public String getExtreper() {
        return extreper;
    }

    public void setExtreper(String extreper) {
        this.extreper = extreper;
    }
    
    
}
