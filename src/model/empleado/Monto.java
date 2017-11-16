
package model.empleado;

import java.time.LocalDate;


public class Monto {
    Float monto;
    Float pago;
    Float vuelto;
    LocalDate fecha;

    public Monto(Float monto, Float pago, Float vuelto, LocalDate fecha) {
        this.monto = monto;
        this.pago = pago;
        this.vuelto = vuelto;
        this.fecha = fecha;
    }

    public Float getMonto() {
        return monto;
    }

    public Float getPago() {
        return pago;
    }

    public Float getVuelto() {
        return vuelto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public void setPago(Float pago) {
        this.pago = pago;
    }

    public void setVuelto(Float vuelto) {
        this.vuelto = vuelto;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    
    
}
