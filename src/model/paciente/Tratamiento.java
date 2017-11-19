
package model.paciente;

import java.time.LocalDate;

public class Tratamiento {
    private int id;
    private int planTramientoId;
    private int temporadaId;
    private LocalDate fecha;
    private boolean estadoPagado; // 0 -> no pagado , 1 -> pagado

    public Tratamiento(int id, int planTramientoId, int temporadaId, LocalDate fecha, boolean estadoPagado) {
        this.id = id;
        this.planTramientoId = planTramientoId;
        this.temporadaId = temporadaId;
        this.fecha = fecha;
        this.estadoPagado = estadoPagado;
    }
    
}
