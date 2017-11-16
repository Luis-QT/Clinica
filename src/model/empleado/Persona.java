/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.empleado;

/**
 *
 * @author LLLL
 */
public abstract class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int dni;
    private boolean sexo;// 0->female , 1 -> male 
    private Integer edad;
    private int telefonoCasa;
    private int telefonoCelular;
    private String email;
    private int softDelete;
    /**
     * SoftDelete....
     * 0 cuando no esta eliminado en la DB
     * 1 cuando esta eliminado de la DB
     * 2 cuando esta insertado en la lista
     * 3 cuando no esta en ningun lugar
     */

    
    /**
     
     * @param id
     * @param nombre
     * @param apellido
     * @param dni
     * @param sexo
     * @param edad
     * @param telefonoCasa
     * @param telefonoCelular
     * @param email
     * @param softDelete 
     */
    public Persona(int id, String nombre, String apellido, int dni, boolean sexo, int edad, int telefonoCasa, int telefonoCelular, String email, int softDelete) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.sexo = sexo;
        this.edad = edad;
        this.telefonoCasa = telefonoCasa;
        this.telefonoCelular = telefonoCelular;
        this.email = email;
        this.softDelete = softDelete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public boolean isSexo() {
        return sexo;
    }
    
    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefonoCasa() {
        return telefonoCasa;
    }

    public void setTelefonoCasa(int telefonoCasa) {
        this.telefonoCasa = telefonoCasa;
    }

    public int getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(int telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSoftDelete() {
        return softDelete;
    }

    public void setSoftDelete(int softDelete) {
        this.softDelete = softDelete;
    }
    
    public int getSexoEntero(){
        if(sexo)
            return 1;
        else
            return 0;
    }
    
    @Override
    public String toString() {
        return "Persona " + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", sexo=" + sexo + ", edad=" + edad + ", telefonoCasa=" + telefonoCasa + ", telefonoCelular=" + telefonoCelular + ", email=" + email + ", softDelete=" + softDelete + "\n";
    }
    
    
    
}
