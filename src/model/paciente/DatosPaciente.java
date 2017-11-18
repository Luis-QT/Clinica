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

    public DatosPaciente(String nombre, String apellido, int edad, String sexo, int DNI, String direccion, String tipovivienda, String serviciosba, int telefono, String estadoTel, String religion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
        this.DNI = DNI;
        this.direccion = direccion;
        this.tipovivienda = tipovivienda;
        this.serviciosba = serviciosba;
        this.telefono = telefono;
        this.estadoTel = estadoTel;
        this.religion = religion;
    }
    private String apellido;
    private int edad;
    private String sexo;
    private int DNI;   
    private String direccion;
    private String tipovivienda;
    private String serviciosba;
    private int telefono;
    private String estadoTel;
    private String religion;

    public String getServiciosba() {
        return serviciosba;
    }

    public void setServiciosba(String serviciosba) {
        this.serviciosba = serviciosba;
    }

    public String getTipovivienda() {
        return tipovivienda;
    }

    public void setTipovivienda(String tipovivienda) {
        this.tipovivienda = tipovivienda;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String isEstadoTel() {
        return estadoTel;
    }

    public void setEstadoTel(String estadoTel) {
        this.estadoTel = estadoTel;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public DatosPaciente() {
        this.nombre = "";
        this.apellido = "";
        this.edad = 0;
        this.sexo = "";
        this.DNI = 0;
        this.direccion = "";
        this.tipovivienda = "";
        this.serviciosba = "";
        this.telefono = 0;
        this.estadoTel = "";
        this.religion = "";
    }

    @Override
    public String toString() {
        return "datosPaciente{" + "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", sexo=" + sexo + ", DNI=" + DNI + ", direccion=" + direccion + ", telefono=" + telefono + ", religion=" + religion + '}';
    }
    
    
    
}
