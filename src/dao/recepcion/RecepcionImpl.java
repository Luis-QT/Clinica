/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.recepcion;

import estructura.ListaDoble;
import factory.ConnectionDb;
import factory.FactoryConnectionDb;
import java.sql.ResultSet;
import model.Horario;
import model.Sala;
import model.empleado.Empleado;
import model.paciente.Paciente;

/**
 *
 * @author Luis
 */
public class RecepcionImpl implements Recepcion {
    
    ConnectionDb conn;

    public RecepcionImpl() {
    }
    
    @Override
    public ListaDoble<Paciente> listaPaciente() {
//        this.conn = FactoryConnectionDb.open();
//        StringBuilder sql = new StringBuilder();
//        sql.append("SELECT * FROM Horarios");
//        Horario horario=null;
//        Empleado empleado = null;
//        Sala sala = null;
//        ListaDoble<Horario> list = new ListaDoble<Horario>();
//        try {
//            ResultSet rs = this.conn.query(sql.toString());
//            while(rs.next()){
//                horario= new Horario(rs.getInt("id"),rs.getString("dia"), rs.getString("horaIni")
//                        , rs.getString("horaFin"), null, null,rs.getInt("tipoEmpleado")
//                        ,rs.getInt("empleadoId"),rs.getInt("salaId"));
//                
//                horario.setEmpleado(obtenerEmpleado(rs.getInt("id")));
//                horario.setSala(obtenerSala(rs.getInt("id")));
//                list.insertarAlFinal(horario);
//            }
//        } catch (Exception e) {
//            
//        }finally{
//            this.conn.close();
//        }
        
        return null;
    }

    @Override
    public void mostrarPacientes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Recepcion obtenerPaciente(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean guardarPaciente(Recepcion recepcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarPaciente(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
