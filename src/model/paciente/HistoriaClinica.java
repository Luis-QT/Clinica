
package model.paciente;


public class HistoriaClinica {
    Anamnesis anamnecis;
    AntecedentesFamiliares antecedentesFamiliares;
    AntecedentesPersonales antecedentesPersonales;
    DatosMedico datosMedico;
    DatosPaciente datosPaciente;
    Diagnostico diagnostico;
    Tratamiento tratamiento;
    TratamientoRea tratamientoRea;

    public HistoriaClinica(Anamnesis anamnecis, AntecedentesFamiliares antecedentesFamiliares, AntecedentesPersonales antecedentesPersonales, DatosMedico datosMedico, DatosPaciente datosPaciente, Diagnostico diagnostico, Tratamiento tratamiento, TratamientoRea tratamientoRea) {
        this.anamnecis = anamnecis;
        this.antecedentesFamiliares = antecedentesFamiliares;
        this.antecedentesPersonales = antecedentesPersonales;
        this.datosMedico = datosMedico;
        this.datosPaciente = datosPaciente;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.tratamientoRea = tratamientoRea;
    }

    public Anamnesis getAnamnecis() {
        return anamnecis;
    }

    public void setAnamnecis(Anamnesis anamnecis) {
        this.anamnecis = anamnecis;
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

    public DatosMedico getDatosMedico() {
        return datosMedico;
    }

    public void setDatosMedico(DatosMedico datosMedico) {
        this.datosMedico = datosMedico;
    }

    public DatosPaciente getDatosPaciente() {
        return datosPaciente;
    }

    public void setDatosPaciente(DatosPaciente datosPaciente) {
        this.datosPaciente = datosPaciente;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    public TratamientoRea getTratamientoRea() {
        return tratamientoRea;
    }

    public void setTratamientoRea(TratamientoRea tratamientoRea) {
        this.tratamientoRea = tratamientoRea;
    }
    
    
    
    
    
}
