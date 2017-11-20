
package model.paciente;

import estructura.ListaDoble;
import model.empleado.Persona;

public class Paciente extends Persona {
    String tipoSangre; 
    String alergia;
    String codigo;
    String direccion;
    String religion;
    boolean tipoVivienda;
    HistoriaClinica historial;
    
    
    
    
   ///CREO QUE NADIE LO USA
    public Paciente(int id, String nombre, String apellido, int dni, 
            boolean sexo, int edad, int telefonoFijo, int telefonoCelular, 
            String email, int softDelete,String tipoSangre, String alergias,
            String codigo, String direccion, String religion, boolean tipovivienda) {
        
        super(id, nombre, apellido, dni, sexo, edad, telefonoFijo, 
                telefonoCelular, email, softDelete);
        this.tipoSangre = tipoSangre;
        this.alergia = alergias;
        this.codigo = codigo;
        this.direccion =  direccion;
        this.religion = religion;
        historial = new HistoriaClinica(new AntecedentesFamiliares(), 
                    new AntecedentesPersonales(), new DatosMedico());
    }
    
    //CONSTRUCTOR QUE USA RECEPCIÓN
    public Paciente(int id, String nombre, String apellido, int dni, 
            boolean sexo, int edad, int telefonoFijo, int telefonoCelular, 
            String email, int softDelete,String tipoSangre, String alergias,
            String codigo) {
        
        super(id, nombre, apellido, dni, sexo, edad, telefonoFijo, telefonoCelular, email, softDelete);
        this.tipoSangre = tipoSangre;
        this.alergia = alergias;
        this.codigo = codigo;
        this.direccion =  direccion;
        this.religion = religion;
        historial =  new HistoriaClinica(new AntecedentesFamiliares(), 
                    new AntecedentesPersonales(), new DatosMedico());
    }

    
    public String getReligion() {
        return religion;
    }
    
    public String getDireccion() {
        return direccion;
    } 
    
    public String getTipoSangre() {
        return tipoSangre;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public HistoriaClinica getHistorial() {
        return historial;
    }
    
    public Visita obtenerVisita(int pos){
        return this.historial.listaVisitas.getDato(pos);
    }

  
}
