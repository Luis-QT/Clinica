package model.paciente;

import estructura.ListaDoble;
import java.time.LocalDate;

public class Visita {

    private int id;
    private int idVisita;
    private String servicio;
    private DatosMedico datosMedico;
    private LocalDate fecha;
    private Anamnesis anamnecis;
    private ExamenFisicos examenFisico;
    private Diagnostico diagnostico;
    private String medicina;
    private String recomendaciones;

    
    public Visita(String servicio) {
        this.servicio = servicio;
        this.datosMedico = new DatosMedico();
        this.fecha = LocalDate.now();
        this.anamnecis = new Anamnesis();
        this.examenFisico = new ExamenFisicos();
        this.diagnostico = new Diagnostico();
    }
    
    //Constructor recepcionista
    public Visita(String servicio,DatosMedico medico) {
        this.servicio = servicio;
        this.datosMedico = medico;
        this.fecha = LocalDate.now();
        this.anamnecis = new Anamnesis();
        this.examenFisico = new ExamenFisicos();
        this.diagnostico = new Diagnostico();
        
    }
    

    public Visita(int id, Anamnesis anamnecis, DatosMedico datosMedico, ExamenFisicos examenFisico, Diagnostico diagnostico) {
        this.fecha = LocalDate.now();
        this.id = id;
        this.anamnecis = anamnecis;
        this.datosMedico = datosMedico;
        this.examenFisico = examenFisico;
        this.diagnostico = diagnostico;
        this.servicio = "Holaa";
    }

    
    public Visita(LocalDate fecha, int codigo, Anamnesis anamnecis, DatosMedico datosMedico, ExamenFisicos examenFisico, Diagnostico diagnostico, TemporadaTratamiento tratamiento, TratamientoRea tratamientoRea) {
        this.fecha = fecha;
        this.id = codigo;
        this.anamnecis = anamnecis;
        this.datosMedico = datosMedico;
        this.examenFisico = examenFisico;
        this.diagnostico = diagnostico;
        this.servicio = "Holo";
    }

    
    public String getMedicina() {
        return medicina;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
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

   

    public void setMedicina(String pastilla) {
        this.medicina = pastilla;
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

}
