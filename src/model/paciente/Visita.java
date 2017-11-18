
package model.paciente;

public class Visita {
    Anamnesis anamnecis;
    DatosMedico datosMedico;
    ExamenFisico examenFisico;
    Diagnostico diagnostico;
    Tratamiento tratamiento;
    TratamientoRea tratamientoRea;

    public Visita(Anamnesis anamnecis, DatosMedico datosMedico, ExamenFisico examenFisico, Diagnostico diagnostico, Tratamiento tratamiento, TratamientoRea tratamientoRea) {
        this.anamnecis = anamnecis;
        this.datosMedico = datosMedico;
        this.examenFisico = examenFisico;
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

    public DatosMedico getDatosMedico() {
        return datosMedico;
    }

    public void setDatosMedico(DatosMedico datosMedico) {
        this.datosMedico = datosMedico;
    }

    public ExamenFisico getExamenFisico() {
        return examenFisico;
    }

    public void setExamenFisico(ExamenFisico examenFisico) {
        this.examenFisico = examenFisico;
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
