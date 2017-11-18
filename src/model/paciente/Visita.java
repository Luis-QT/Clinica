package model.paciente;

import java.time.LocalDate;

public class Visita {

    int codigo;
    LocalDate fecha;
    Anamnesis anamnecis;
    DatosMedico datosMedico;
    ExamenFisicos examenFisico;
    Diagnostico diagnostico;
    Tratamiento tratamiento;
    TratamientoRea tratamientoRea;

    public Visita(int codigo, Anamnesis anamnecis, DatosMedico datosMedico, ExamenFisicos examenFisico, Diagnostico diagnostico, Tratamiento tratamiento, TratamientoRea tratamientoRea) {
        this.fecha = LocalDate.now();
        this.anamnecis = anamnecis;
        this.datosMedico = datosMedico;
        this.examenFisico = examenFisico;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.tratamientoRea = tratamientoRea;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public Visita(LocalDate fecha, int codigo, Anamnesis anamnecis, DatosMedico datosMedico, ExamenFisicos examenFisico, Diagnostico diagnostico, Tratamiento tratamiento, TratamientoRea tratamientoRea) {
        this.fecha = fecha;
        this.anamnecis = anamnecis;
        this.datosMedico = datosMedico;
        this.examenFisico = examenFisico;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.tratamientoRea = tratamientoRea;
    }

    public int getCodigo() {
        return codigo;
    }

    public String mostrarFecha() {
        return fecha.getYear() + " / " + fecha.getMonth() + " / " + fecha.getDayOfMonth();
    }

    public LocalDate getFecha() {
        return fecha;
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

    public ExamenFisicos getExamenFisico() {
        return examenFisico;
    }

    public void setExamenFisico(ExamenFisicos examenFisico) {
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

    public String toString (){
        return "codigo: "+codigo + " fecha: "+ fecha.toString()+"\n";
    }
}
