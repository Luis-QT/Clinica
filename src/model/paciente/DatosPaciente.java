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
public class DatosPaciente {
    private String nombre;
    private String apellido;
    private int edad;
    private boolean sexo;
    private int DNI;
    private String direccion;
    private boolean tipovivienda;
    private int telefonoFijo;
    private int telefonoCelular;
    private String religion;
    private String tipoSangre;
    private String alergia;
    private String email;
 
    public DatosPaciente( String nombre, String apellido, int edad, boolean sexo, int DNI, String direccion, boolean tipovivienda, int telefonoFijo, int telefonoCelular, String religion, String tipoSangre, String alergia, String email) {
      
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
        this.DNI = DNI;
        this.direccion = direccion;
        this.tipovivienda = tipovivienda;
        this.telefonoFijo = telefonoFijo;
        this.telefonoCelular = telefonoCelular;
        this.religion = religion;
        this.tipoSangre = tipoSangre;
        this.alergia = alergia;
        this.email = email;
    }
    
    public DatosPaciente(String nombre, String apellido, int edad, boolean sexo, int DNI,int telefonoFijo, int telefonoCelular, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
        this.DNI = DNI;
        this.direccion = "";
        this.tipovivienda = false;
        this.telefonoFijo = telefonoFijo;
        this.telefonoCelular = telefonoCelular;
        this.religion = "";
        this.tipoSangre = "";
        this.alergia = "";
        this.email = email;
    }
    
   

    @Override
    public String toString() {
        return "datosPaciente{" + "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", sexo=" + sexo + ", DNI=" + DNI + ", direccion=" + direccion + ", telefono Fijo=" + telefonoFijo + ", religion=" + religion + '}';
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

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isTipovivienda() {
        return tipovivienda;
    }

    public void setTipovivienda(boolean tipovivienda) {
        this.tipovivienda = tipovivienda;
    }

    public int getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(int telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public int getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(int telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

  
    
}
