package model.paciente;

import java.time.LocalDate;

public class Visita {

    private static int id;
    private String servicio;
    private DatosMedico datosMedico;
    private LocalDate fecha;
    private Anamnesis anamnecis;
    private ExamenFisicos examenFisico;
    private Diagnostico diagnostico;
    private Tratamiento tratamiento;
    private TratamientoRea tratamientoRea;

    public Visita(String servicio) {
        this.servicio = servicio;
        this.datosMedico = new DatosMedico();
        this.fecha = LocalDate.now();
        this.anamnecis = new Anamnesis();
        this.examenFisico = new ExamenFisicos();
        this.diagnostico = new Diagnostico();
        this.tratamiento = new Tratamiento();
        this.tratamientoRea = new TratamientoRea();
    }

    public Visita(int codigo, Anamnesis anamnecis, DatosMedico datosMedico, ExamenFisicos examenFisico, Diagnostico diagnostico, Tratamiento tratamiento, TratamientoRea tratamientoRea) {
        this.fecha = LocalDate.now();
        this.anamnecis = anamnecis;
        this.datosMedico = datosMedico;
        this.examenFisico = examenFisico;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.tratamientoRea = tratamientoRea;
        this.servicio = "Holaa";
    }

    
    public Visita(LocalDate fecha, int codigo, Anamnesis anamnecis, DatosMedico datosMedico, ExamenFisicos examenFisico, Diagnostico diagnostico, Tratamiento tratamiento, TratamientoRea tratamientoRea) {
        this.fecha = fecha;
        this.id = codigo;
        this.anamnecis = anamnecis;
        this.datosMedico = datosMedico;
        this.examenFisico = examenFisico;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.tratamientoRea = tratamientoRea;
        this.servicio = "Holo";
    }

    public int getCodigo() {
        return id;
    }
    
    public String getServicio() {
        return servicio;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

  
    public String getFecha() {
        return fecha.toString();
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

//    public String toString (){
//        return "codigo: "+id + " fecha: "+ fecha.toString()+"\n";
//    }

    @Override
    public String toString() {
        return "Visita{" + "id=" + id + ", servicio=" + servicio + ", datosMedico=" + datosMedico + ", fecha=" + fecha + ", anamnecis=" + anamnecis + ", examenFisico=" + examenFisico + ", diagnostico=" + diagnostico + ", tratamiento=" + tratamiento + ", tratamientoRea=" + tratamientoRea + '}';
    }
    
    
}
