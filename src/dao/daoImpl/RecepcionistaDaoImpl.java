/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.daoImpl;

import estructura.ListaDoble;
import factory.ConnectionDb;
import factory.FactoryConnectionDb;
import dao.dao.RecepcionistaDao;
import model.empleado.Recepcionista;
import java.sql.ResultSet;
import model.Horario;
/**
 *
 * @author LLLL
 */
public class RecepcionistaDaoImpl implements RecepcionistaDao{
    
    ConnectionDb conn;

    public RecepcionistaDaoImpl() {
    }
    
    public ListaDoble<Recepcionista> listaRecepcionistas() {
        this.conn = FactoryConnectionDb.open();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Recepcionista WHERE softDelete=0");
        Recepcionista recepcionista=null;
        ListaDoble<Recepcionista> list = new ListaDoble<Recepcionista>();
        try {
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
                recepcionista= new Recepcionista(rs.getString("codigo"), rs.getString("contraseña"), null, rs.getInt("id")
                        , rs.getString("nombre"), rs.getString("apellido"), rs.getInt("dni"), rs.getBoolean("sexo")
                        , rs.getInt("edad"), rs.getInt("telefonoCasa"), rs.getInt("telefonoCelular")
                        , rs.getString("email"), rs.getInt("softDelete"));
                
                recepcionista.setHorarios(obtenerHorarios(rs.getInt("id")));
                list.insertarAlFinal(recepcionista);
            }
        } catch (Exception e) {
            
        }finally{
            this.conn.close();
        }
        if(list==null){
            list = new ListaDoble<Recepcionista>();
        }
        return list;
    }

    @Override
    public void mostrarRecepcionistas() {
        this.conn = FactoryConnectionDb.open();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Recepcionista");
        try {
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
                System.out.print("Id : "+rs.getString("id"));
                System.out.print(" * Nombre :"+rs.getString("nombre"));
                System.out.print(" * Apellido : "+rs.getString("apellido"));
                System.out.print(" * Dni : "+rs.getInt("dni"));
                System.out.print(" * edad : "+rs.getInt("edad"));
                System.out.print(" * Codigo : "+rs.getString("codigo"));
                System.out.print(" * Contraseña : "+rs.getString("contraseña"));
                System.out.print(" * Telefono : "+rs.getInt("telefonoCasa"));
                System.out.print(" * Celular : "+rs.getInt("telefonoCelular"));
                System.out.print(" * Sexo : "+rs.getBoolean("sexo"));
                System.out.print(" * email : "+rs.getString("email"));
                System.out.println(" * softDelete : "+ rs.getInt("softDelete"));
            }
        } catch (Exception e) {
            
        }finally{
            this.conn.close();
        }
    }
    //parametro id del recepcionista
    @Override
    public ListaDoble<Horario> obtenerHorarios(int id){
        ListaDoble<Horario> listaHorario= new ListaDoble<Horario>();
        this.conn = FactoryConnectionDb.open();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Horarios WHERE empleadoId="+id);
        sql.append(" AND tipoEmpleado = 5");
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
        
        return listaHorario;
    }
    
    @Override
    public Recepcionista obtenerRecepcionista(int id) {
        this.conn = FactoryConnectionDb.open();
        Recepcionista recepcionista =null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Recepcionista WHERE id = ").append(id).append(" AND softDelete = 0");
        try {
            ResultSet rs = this.conn.query(sql.toString());
            //String codigo, String contraseña, int id, String nombre, String apellido, int dni, 
            //int sexo, int edad, int telefonoCasa, int telefonoCelular
            while(rs.next()){
                recepcionista= new Recepcionista(rs.getString("codigo"), rs.getString("contraseña"), null, rs.getInt("id")
                        , rs.getString("nombre"), rs.getString("apellido"), rs.getInt("dni"), rs.getBoolean("sexo")
                        , rs.getInt("edad"), rs.getInt("telefonoCasa"), rs.getInt("telefonoCelular")
                        , rs.getString("email"), rs.getInt("softDelete"));
            }
        } catch (Exception e) {
        }finally{
            this.conn.close();
        }
        return recepcionista;
    }

    @Override
    public boolean guardarRecepcionista(Recepcionista recepcionista) {
        this.conn = FactoryConnectionDb.open();
        boolean save = false;
        
        try {
            if(recepcionista.getId() ==0){//new
                StringBuilder sql = new StringBuilder();
                sql.append("INSERT INTO Recepcionista "
                + "(codigo,nombre,apellido,dni,contraseña,edad,telefonoCasa,telefonoCelular,sexo,email,softDelete) VALUES ('"
                + recepcionista.getCodigo()+"','"+recepcionista.getNombre()+"','"+recepcionista.getApellido()+"',"
                + recepcionista.getDni()+",'"+recepcionista.getContraseña()+"',"
                + recepcionista.getEdad()+","+recepcionista.getTelefonoCasa()+","+recepcionista.getTelefonoCelular()+","
                + recepcionista.getSexoEntero()+",'"+recepcionista.getEmail()+"',0)");
                
                this.conn.execute2(sql.toString());
            }else{//update
                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE Recepcionista SET codigo = '").append(recepcionista.getCodigo()).append("'");
                sql.append(",nombre = '"+recepcionista.getNombre()+"'").append(",apellido = '"+recepcionista.getApellido()+"'");
                sql.append(",dni = "+recepcionista.getDni()).append(",contraseña = '"+recepcionista.getContraseña()+"'");
                sql.append(",edad = "+recepcionista.getEdad());
                sql.append(",telefonoCasa = "+recepcionista.getTelefonoCasa()).append(",telefonoCelular ="+recepcionista.getTelefonoCelular());
                sql.append(",sexo = "+recepcionista.getSexoEntero()).append(",email='"+recepcionista.getEmail()).append("',softDelete="+recepcionista.getSoftDelete());
                sql.append(" WHERE id = "+recepcionista.getId());
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
    public boolean eliminarRecepcionista(int id) {
        this.conn = FactoryConnectionDb.open();
        boolean delete = false;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE Recepcionista SET softDelete = 1 WHERE id = "+id);
            this.conn.execute2(sql.toString());
            delete=true;
        } catch (Exception e) {
        }finally{
            this.conn.close();
        }
        return delete;
    }
}
