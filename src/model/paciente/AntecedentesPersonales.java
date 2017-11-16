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
public class AntecedentesPersonales {
    private String enferTra;
    private int hospitalizaciones;
    private int inmunizacion;
    private String tipoSangre;
    private String alergias;

        public String getEnferTra() {
            return enferTra;
        }

        public void setEnferTra(String enferTra) {
            this.enferTra = enferTra;
        }

        public int getHospitalizaciones() {
            return hospitalizaciones;
        }

        public void setHospitalizaciones(int hospitalizaciones) {
            this.hospitalizaciones = hospitalizaciones;
        }

        public int getInmunizacion() {
            return inmunizacion;
        }

        public void setInmunizacion(int inmunizacion) {
            this.inmunizacion = inmunizacion;
        }

        public String getTipoSangre() {
            return tipoSangre;
        }

        public void setTipoSangre(String tipoSangre) {
            this.tipoSangre = tipoSangre;
        }

        public String getAlergias() {
            return alergias;
        }

        public void setAlergias(String alergias) {
            this.alergias = alergias;
        }

        public AntecedentesPersonales() {
            this.enferTra = null;
            this.hospitalizaciones = 0;
            this.inmunizacion = 0;
            this.tipoSangre = null;
            this.alergias = null;
        }

        @Override
        public String toString() {
            return "antedentesPersonales{" + "enferTra=" + enferTra + ", hospitalizaciones=" + hospitalizaciones + ", inmunizacion=" + inmunizacion + ", tipoSangre=" + tipoSangre + ", alergias=" + alergias + '}';
        }
    
          
    
    
}
