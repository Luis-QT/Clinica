/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.daoImpl;

import dao.dao.PlanTratamientoDao;
import estructura.ListaDoble;
import factory.ConnectionDb;
import factory.FactoryConnectionDb;
import java.sql.ResultSet;
import model.PlanTratamiento;

/**
 *
 * @author LLLL
 */
public class PlanTratamientoDaoImpl implements PlanTratamientoDao{
    
    ConnectionDb conn;

    public PlanTratamientoDaoImpl() {
    }
    
    @Override
    public ListaDoble<PlanTratamiento> listaTratamientos() {
        this.conn = FactoryConnectionDb.open();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM PlanTratamiento");
        PlanTratamiento planTratamiento = null;
        ListaDoble<PlanTratamiento> lista = new ListaDoble<>();
        try {
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
                planTratamiento = new PlanTratamiento(rs.getInt("id"),rs.getString("nombre"), rs.getString("descripcion"), rs.getDouble("precio"));
                lista.insertarAlFinal(planTratamiento);
            }
        } catch (Exception e) {
            
        }finally{
            this.conn.close();
        }
        if(lista==null){
            lista = new ListaDoble<PlanTratamiento>();
        }
        return lista;
    }

    @Override
    public void mostrarTratamientos() {
        
    }

    @Override
    public PlanTratamiento obtenerTratamiento(int id) {
        this.conn = FactoryConnectionDb.open();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM PlanTratamiento WHERE id="+id);
        PlanTratamiento planTratamiento = null;
        try {
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
                planTratamiento = new PlanTratamiento(rs.getInt("id"),rs.getString("nombre"), rs.getString("descripcion"), rs.getDouble("precio"));
            }
        } catch (Exception e) {
            
        }finally{
            this.conn.close();
        }
        return planTratamiento;
    }

    @Override
    public boolean guardarTratamiento(PlanTratamiento planTratamiento) {
        this.conn = FactoryConnectionDb.open();
        boolean save = false;
        try {
            if(planTratamiento.getId() ==0){//new
                StringBuilder sql = new StringBuilder();
                sql.append("INSERT INTO PlanTratamiento "
                + "(nombre,descripcion,precio) VALUES ('"
                        + planTratamiento.getNombre()+"','"
                        + planTratamiento.getDescripcion()+"',"
                        + planTratamiento.getPrecio()
                        + ")");
                this.conn.execute2(sql.toString());
            }else{//update
                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE PlanTratamiento SET nombre = '").append(planTratamiento.getNombre());
                sql.append("',descripcion = '"+planTratamiento.getDescripcion()+"'");
                sql.append(" , precio = "+planTratamiento.getPrecio());
                sql.append(" WHERE id = "+planTratamiento.getId());
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
    public boolean eliminarTratamiento(int id) {
        this.conn = FactoryConnectionDb.open();
        boolean delete = false;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM PlanTratamiento WHERE id = "+id);
            this.conn.execute2(sql.toString());
            delete=true;
        } catch (Exception e) {
        }finally{
            this.conn.close();
        }
        return delete;
    }
    
}
