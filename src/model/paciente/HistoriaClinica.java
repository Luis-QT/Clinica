
package model.paciente;

import estructura.ListaDoble;
import java.time.LocalDate;


public class HistoriaClinica {
    AntecedentesFamiliares antecedentesFamiliares;
    AntecedentesPersonales antecedentesPersonales;
    ListaDoble<Visita> listaVisitas;
    String codigo;

    public HistoriaClinica(AntecedentesFamiliares antecedentesFamiliares, AntecedentesPersonales antecedentesPersonales, DatosMedico datosMedico) {
        this.antecedentesFamiliares = antecedentesFamiliares;
        this.antecedentesPersonales = antecedentesPersonales;
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

//    public DatosPaciente getDatosPaciente() {
//        return datosPaciente;
//    }
//
//    public void setDatosPaciente(DatosPaciente datosPaciente) {
//        this.datosPaciente = datosPaciente;
//    }

    public ListaDoble<Visita> getListaVisitas() {
        return listaVisitas;
    }

    public void setListaVisitas(ListaDoble<Visita> listaVisitas) {
        this.listaVisitas = listaVisitas;
    }
    
    public void nuevaVisita (int codigo,Anamnesis anamnesis, DatosMedico datosmedico,ExamenFisicos examenF, Diagnostico diagnostico,TemporadaTratamiento tratamiento,TratamientoRea tratamientorea  ){
       Visita v = new Visita(codigo, anamnesis,datosmedico,examenF, diagnostico,tratamiento,tratamientorea);
       listaVisitas.insertarAlFinal(v);
    }
    
    public void agregarDatosPaciente(){
        
    }
    
    public void agregarAntecedentes(){
        
    }
      
    
    
}
