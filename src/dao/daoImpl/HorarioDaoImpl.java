/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.daoImpl;

import dao.dao.SalaDao;
import dao.dao.MedicoGeneralDao;
import dao.dao.HorarioDao;
import estructura.ListaDoble;
import factory.ConnectionDb;
import factory.FactoryConnectionDb;
import java.sql.ResultSet;
import model.empleado.Empleado;
import model.Horario;
import model.Sala;

/**
 *
 * @author LLLL
 */
public class HorarioDaoImpl implements HorarioDao{
    
    ConnectionDb conn;
    
    public HorarioDaoImpl(){
        
    }
    
    @Override
    public ListaDoble<Horario> listaHorarios() {
        this.conn = FactoryConnectionDb.open();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Horarios");
        Horario horario=null;
        Empleado empleado = null;
        Sala sala = null;
        ListaDoble<Horario> list = new ListaDoble<Horario>();
        try {
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
                horario= new Horario(rs.getInt("id"),rs.getString("dia"), rs.getString("horaIni")
                        , rs.getString("horaFin"), null, null,rs.getInt("tipoEmpleado")
                        ,rs.getInt("empleadoId"),rs.getInt("salaId"));
                
                horario.setEmpleado(obtenerEmpleado(rs.getInt("id")));
                horario.setSala(obtenerSala(rs.getInt("id")));
                list.insertarAlFinal(horario);
            }
        } catch (Exception e) {
            
        }finally{
            this.conn.close();
        }
        
        return list;
    }
    //parametro id del horario
    @Override
    public Empleado obtenerEmpleado(int id){
        Horario horario = obtenerHorario(id);
        Empleado empleado = null;
        int empleadoId = horario.getEmpleadoId();
        int tipoEmpleado = horario.getTipoEmpleado();
        
        switch(tipoEmpleado){
            case 1: MedicoGeneralDao mgd = new MedicoGeneralDaoImpl();
                    empleado = mgd.obtenerMedico(empleadoId);
                    break;
            case 2: break;
            case 3: break;
            case 4: break;
        }
        return empleado;
    }
    //parametro id del horario
    @Override
    public Sala obtenerSala(int id){
        Horario horario = obtenerHorario(id);
        SalaDao sd = new SalaDaoImpl();
        return sd.obtenerSala(horario.getSalaId());
    }
    
    @Override
    public void mostrarHorarios() {
        this.conn = FactoryConnectionDb.open();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Horarios");
        ListaDoble<Horario> list = new ListaDoble<>();
        try {
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
                
                System.out.println("id : "+rs.getInt("id")+",Dia : "+rs.getString("dia")+",HoraIni :"+rs.getString("horaIni")
                        +",Hora Fin :" +rs.getString("horaFin")+",EmpleadoId :"+rs.getInt("empleadoId")
                        +",salaId :"+rs.getString("salaId")+",tipoEmpleado"+rs.getInt("tipoEmpleado"));   
            }
        } catch (Exception e) {
            
        }finally{
            this.conn.close();
        }
    }
    
    
    @Override
    public Horario obtenerHorario(int id) {
        this.conn = FactoryConnectionDb.open();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Horarios WHERE id="+id);
        Horario horario=null;
        Empleado empleado = null;
        Sala sala = null;
        try {
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
                horario= new Horario(rs.getInt("id"),rs.getString("dia"), rs.getString("horaIni")
                    , rs.getString("horaFin"), null, null,rs.getInt("tipoEmpleado"),
                        rs.getInt("empleadoId"),rs.getInt("salaId"));
            }
        } catch (Exception e) {
        
        }finally{
            this.conn.close();
        }
        return horario;
    }

    @Override
    public boolean guardarHorario(Horario horario) {
        this.conn = FactoryConnectionDb.open();
        boolean save = false;
        try {
            if(horario.getId() ==0){//new
                StringBuilder sql = new StringBuilder();
                sql.append("INSERT INTO Horarios "
                + "(dia,horaIni,horaFin,empleadoId,tipoEmpleado,salaId) VALUES ("
                        +"'"+horario.getDia()+"','"+horario.getHoraEntrada()+"','"
                        +horario.getHoraSalida()+"',"+horario.getEmpleado().getId()+","
                        +horario.getTipoEmpleado()+","+horario.getSala().getId()
                        + ")");
                this.conn.execute2(sql.toString());
            }else{//update
                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE Horarios SET dia = '").append(horario.getDia()).append("'");
                sql.append(",horaIni = '"+horario.getHoraEntrada()+"'").append(",horaFin = '"+horario.getHoraSalida()+"'");
                sql.append(",empleadoId = "+horario.getEmpleado().getId());
                sql.append(",tipoEmpleado = "+horario.getTipoEmpleado());
                sql.append(",salaId = "+horario.getSala().getId());
                this.conn.execute2(sql.toString());
            }
            save = true;
        } catch (Exception e) {
            
        } finally{
            this.conn.close();
        }
        return save;
    }

    @Override
    public boolean eliminarHorario(int id) {
        this.conn = FactoryConnectionDb.open();
        boolean delete = false;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM Horarios WHERE id = "+id);
            this.conn.execute2(sql.toString());
            delete=true;
        } catch (Exception e) {
        }finally{
            this.conn.close();
        }
        return delete;
    }
    
}
