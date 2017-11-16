
package model.empleado;

import java.time.LocalDate;

public class Recaudado {
    
    private  LocalDate fechaRecauDia;
    private Float montodelDia;

    public Recaudado(LocalDate fechaRecauDia, Float montodelDia) {
        this.fechaRecauDia = fechaRecauDia;
        this.montodelDia = montodelDia;
    }

    public LocalDate getFechaRecauDia() {
        return fechaRecauDia;
    }

    public Float getMontodelDia() {
        return montodelDia;
    }

    public void setFechaRecauDia(LocalDate fechaRecauDia) {
        this.fechaRecauDia = fechaRecauDia;
    }

    public void setMontodelDia(Float montodelDia) {
        this.montodelDia = montodelDia;
    }
    
    
}
