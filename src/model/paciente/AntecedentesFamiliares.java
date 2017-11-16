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
    private String muertep;
    private String estadom;
    private String hospm;
    private String muertem;

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

        public String getMuertep() {
            return muertep;
        }

        public void setMuertep(String muertep) {
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

        public String getMuertem() {
            return muertem;
        }

        public void setMuertem(String muertem) {
            this.muertem = muertem;
        }

        public AntecedentesFamiliares(String hospp, String muertep) {
          
            this.hospp = hospp;
            this.muertep = muertep;
        }

        public AntecedentesFamiliares(String estadop, String hospp, String muertep, String estadom, String hospm, String muertem) {
            this.estadop = estadop;
            this.hospp = hospp;
            this.muertep = muertep;
            this.estadom = estadom;
            this.hospm = hospm;
            this.muertem = muertem;
        }
        
        
        public AntecedentesFamiliares(String estadom, String hospm, String muertem) {
            this.estadom = estadom;
            this.hospm = hospm;
            this.muertem = muertem;
        }
        
        public AntecedentesFamiliares() {
            this.estadop = "";
            this.hospp = "";
            this.muertep = "";
            this.estadom = "";
            this.hospm = "";
            this.muertem = "";
        }
        
        @Override
        public String toString() {
            return "antecedentesFamiliares{" + "hospp=" + hospp + ", muertep=" + muertep + ", hospm=" + hospm + ", muertem=" + muertem + '}';
        }
    
    
    
}
