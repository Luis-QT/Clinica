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
public class AntecedentesFamiliares {
    private String estadop;
    private String hospp;
    private Boolean muertep;
    private String estadom;
    private String hospm;
    private Boolean muertem;

        public String isEstadop() {
            return estadop;
        }

        public void setEstadop(String estadop) {
            this.estadop = estadop;
        }

        public String getHospp() {
            return hospp;
        }

        public void setHospp(String hospp) {
            this.hospp = hospp;
        }

        public Boolean getMuertep() {
            return muertep;
        }

        public void setMuertep(Boolean muertep) {
            this.muertep = muertep;
        }

        public String isEstadom() {
            return estadom;
        }

        public void setEstadom(String estadom) {
            this.estadom = estadom;
        }

        public String getHospm() {
            return hospm;
        }

        public void setHospm(String hospm) {
            this.hospm = hospm;
        }

        public Boolean getMuertem() {
            return muertem;
        }

        public void setMuertem(Boolean muertem) {
            this.muertem = muertem;
        }

        public AntecedentesFamiliares(String hospp, Boolean muertep) {
          
            this.hospp = hospp;
            this.muertep = muertep;
        }

        public AntecedentesFamiliares(String estadop, String hospp, Boolean muertep, String estadom, String hospm, Boolean muertem) {
            this.estadop = estadop;
            this.hospp = hospp;
            this.muertep = muertep;
            this.estadom = estadom;
            this.hospm = hospm;
            this.muertem = muertem;
        }
        
        
        public AntecedentesFamiliares(String estadom, String hospm, Boolean muertem) {
            this.estadom = estadom;
            this.hospm = hospm;
            this.muertem = muertem;
        }
        
        public AntecedentesFamiliares() {
            this.estadop = "";
            this.hospp = "";
            this.muertep = false;
            this.estadom = "";
            this.hospm = "";
            this.muertem = false;
        }
        
        @Override
        public String toString() {
            return "antecedentesFamiliares{" + "hospp=" + hospp + ", muertep=" + muertep + ", hospm=" + hospm + ", muertem=" + muertem + '}';
        }
    
    
    
}
