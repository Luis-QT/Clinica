/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.daoImpl;

import dao.dao.SalaDao;
import estructura.ListaDoble;
import factory.ConnectionDb;
import factory.FactoryConnectionDb;
import model.Sala;
import java.sql.ResultSet;
import model.Horario;

/**
 *
 * @author LLLL
 */
public class SalaDaoImpl implements SalaDao{
    
    ConnectionDb conn;
    
    public SalaDaoImpl(){
        
    }
    
    @Override
    public ListaDoble<Sala> listaSalas() {
        this.conn = FactoryConnectionDb.open();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Salas");
        Sala sala=null;
        ListaDoble<Sala> list = new ListaDoble<>();
        try {
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
                sala = new Sala(rs.getInt("id"),rs.getString("nombre"), rs.getString("descripcion"), null);
                sala.setHorarios(obtenerHorarios(rs.getInt("id")));
                list.insertarAlFinal(sala);
            }
        } catch (Exception e) {
            
        }finally{
            this.conn.close();
        }
        if(list==null){
            list = new ListaDoble<Sala>();
        }
        return list;
    }

    @Override
    public void mostrarSalas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaDoble<Horario> obtenerHorarios(int id){
        
        ListaDoble<Horario> listaHorario= new ListaDoble<Horario>();
        this.conn = FactoryConnectionDb.open();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Horarios WHERE salaId="+id);
        try {
            ResultSet rs = this.conn.query(sql.toString());
            Horario horario=null;
            while(rs.next()){
                horario= new Horario(rs.getInt("id"),rs.getString("dia"), rs.getString("horaIni")
                        , rs.getString("horaFin"), null, null,rs.getInt("tipoEmpleado")
                        ,rs.getInt("empleadoId"),rs.getInt("salaId"));
                
                listaHorario.insertarAlFinal(horario);
            }
        } catch (Exception e) {
            
        }finally{
            this.conn.close();
        }
        if(listaHorario==null){
            listaHorario = new ListaDoble<Horario>();
        }
        return listaHorario;
    }
    
    @Override
    public Sala obtenerSala(int id) {
        this.conn = FactoryConnectionDb.open();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Salas WHERE id="+id);
        Sala sala=new Sala(0,"nuevo", "nuevo", null);
        try {
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
                System.out.println(rs.getString("id"));
                sala = new Sala(rs.getInt("id"),rs.getString("nombre"), rs.getString("descripcion"), null);
            }
        } catch (Exception e) {
            
        }finally{
            this.conn.close();
        }
        
        return sala;
    }

    @Override
    public boolean guardarSala(Sala sala) {
        this.conn = FactoryConnectionDb.open();
        boolean save = false;
        try {
            if(sala.getId() ==0){//new
                StringBuilder sql = new StringBuilder();
                sql.append("INSERT INTO Salas "
                + "(nombre,descripcion) VALUES ('"
                        + sala.getNombre()+"','"
                        + sala.getDescripcion()
                        + "')");
                this.conn.execute2(sql.toString());
            }else{//update
                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE Salas SET nombre = '").append(sala.getNombre());
                sql.append("',descripcion = '"+sala.getDescripcion()+"'");
                sql.append(" WHERE id = "+sala.getId());
                this.conn.execute2(sql.toString());
            }
            save = true;
        } catch (Exception e) {
            System.out.println(":c");
        } finally{
            this.conn.close();
        }
        return save;
    }

    @Override
    public boolean eliminarSala(int id) {
        this.conn = FactoryConnectionDb.open();
        boolean delete = false;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM Salas WHERE id = "+id);
            this.conn.execute2(sql.toString());
            delete=true;
        } catch (Exception e) {
        }finally{
            this.conn.close();
        }
        return delete;
    }
    
}
