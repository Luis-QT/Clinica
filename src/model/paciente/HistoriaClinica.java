
package model.paciente;

import estructura.ListaDoble;
import java.time.LocalDate;


public class HistoriaClinica {
    AntecedentesFamiliares antecedentesFamiliares;
    AntecedentesPersonales antecedentesPersonales;
    
    DatosPaciente datosPaciente;
    ListaDoble<Visita> listaVisitas;

    public HistoriaClinica(AntecedentesFamiliares antecedentesFamiliares, AntecedentesPersonales antecedentesPersonales, DatosMedico datosMedico, DatosPaciente datosPaciente) {
        this.antecedentesFamiliares = antecedentesFamiliares;
        this.antecedentesPersonales = antecedentesPersonales;
        this.datosPaciente = datosPaciente;
        this.listaVisitas = new ListaDoble<Visita>();
    }

    public AntecedentesFamiliares getAntecedentesFamiliares() {
        return antecedentesFamiliares;
    }

    public void setAntecedentesFamiliares(AntecedentesFamiliares antecedentesFamiliares) {
        this.antecedentesFamiliares = antecedentesFamiliares;
    }

    public AntecedentesPersonales getAntecedentesPersonales() {
        return antecedentesPersonales;
    }

    public void setAntecedentesPersonales(AntecedentesPersonales antecedentesPersonales) {
        this.antecedentesPersonales = antecedentesPersonales;
    }

    public DatosPaciente getDatosPaciente() {
        return datosPaciente;
    }

    public void setDatosPaciente(DatosPaciente datosPaciente) {
        this.datosPaciente = datosPaciente;
    }

    public ListaDoble<Visita> getListaVisitas() {
        return listaVisitas;
    }

    public void setListaVisitas(ListaDoble<Visita> listaVisitas) {
        this.listaVisitas = listaVisitas;
    }
    
   public void nuevaVisita (int codigo,Anamnesis anamnesis, DatosMedico datosmedico,ExamenFisicos examenF, Diagnostico diagnostico,Tratamiento tratamiento,TratamientoRea tratamientorea  ){
    
//       Diagnostico diagnostico = new Diagnostico();
//       Tratamiento tratamiento = new Tratamiento();
//       TratamientoRea tratamientorea = new TratamientoRea();
       Visita v = new Visita(codigo, anamnesis,datosmedico,examenF, diagnostico,tratamiento,tratamientorea);
   }
  

    
    
    
}
