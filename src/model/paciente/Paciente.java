
package model.paciente;

import estructura.ListaDoble;
import model.empleado.Persona;

public class Paciente extends Persona {
    String tipoSangre; 
    String alergia;
    String codigo;
    HistoriaClinica historial;
   
    public Paciente(int id, String nombre, String apellido, int dni, 
            boolean sexo, int edad, int telefonoCasa, int telefonoCelular, 
            String email, int softDelete,String tipoSangre, String alergias,String codigo) {
        
        super(id, nombre, apellido, dni, sexo, edad, telefonoCasa, telefonoCelular, email, softDelete);
        this.tipoSangre = tipoSangre;
        this.alergia = alergias;
        this.codigo = codigo;
        historial = new HistoriaClinica(new AntecedentesFamiliares(), new AntecedentesPersonales(), new DatosMedico(), new DatosPaciente(), null);
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
}
