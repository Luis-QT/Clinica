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
public class DatosMedico {
    private String nombre;
    private String apellido;
    private int edad ;
    private String sexo;
    private String direccion;
    private int colegiatura;
    private int especializacion;
    private int telefono;

        public DatosMedico(String nombre, String apellido, int edad, String sexo, String direccion, int colegiatura, int especializacion, int telefono) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.edad = edad;
            this.sexo = sexo;
            this.direccion = direccion;
            this.colegiatura = colegiatura;
            this.especializacion = especializacion;
            this.telefono = telefono;
        }

        public DatosMedico() {
            this.nombre = "";
            this.apellido = "";
            this.edad = 0;
            this.sexo = "";
            this.direccion = "";
            this.colegiatura = 0;
            this.especializacion = 0;
            this.telefono = 0;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        public String isSexo() {
            return sexo;
        }

        public void setSexo(String sexo) {
            this.sexo = sexo;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public int getColegiatura() {
            return colegiatura;
        }

        public void setColegiatura(int colegiatura) {
            this.colegiatura = colegiatura;
        }

        public int getEspecializacion() {
            return especializacion;
        }

        public void setEspecializacion(int especializacion) {
            this.especializacion = especializacion;
        }

        public int getTelefono() {
            return telefono;
        }

        public void setTelefono(int telefono) {
            this.telefono = telefono;
        }

    @Override
    public String toString() {
        return "datosMedico{" + "nombre=" + nombre + ", apellido=" + apellido + '}';
    }

}
