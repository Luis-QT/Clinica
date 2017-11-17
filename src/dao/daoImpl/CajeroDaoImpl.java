/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.daoImpl;

import dao.dao.CajeroDao;
import estructura.ListaDoble;
import factory.ConnectionDb;
import factory.FactoryConnectionDb;
import java.sql.ResultSet;
import model.Horario;
import model.empleado.Cajero;

/**
 *
 * @author LLLL
 */
public class CajeroDaoImpl implements CajeroDao{
    
    ConnectionDb conn;
    
    public CajeroDaoImpl() {
    }
    
    @Override
    public ListaDoble<Cajero> listaCajeros() {
        this.conn = FactoryConnectionDb.open();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Cajero WHERE softDelete=0");
        Cajero cajero=null;
        ListaDoble<Cajero> list = new ListaDoble<Cajero>();
        try {
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
                cajero= new Cajero(rs.getString("codigo"), rs.getString("contraseña"), null, rs.getInt("id")
                        , rs.getString("nombre"), rs.getString("apellido"), rs.getInt("dni"), rs.getBoolean("sexo")
                        , rs.getInt("edad"), rs.getInt("telefonoCasa"), rs.getInt("telefonoCelular")
                        , rs.getString("email"), rs.getInt("softDelete"));
                
                cajero.setHorarios(obtenerHorarios(rs.getInt("id")));
                list.insertarAlFinal(cajero);
            }
        } catch (Exception e) {
            
        }finally{
            this.conn.close();
        }
        if(list==null){
            list = new ListaDoble<Cajero>();
        }
        return list;
    }

    @Override
    public void mostrarCajeros() {
        this.conn = FactoryConnectionDb.open();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Cajero");
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
        sql.append(" AND tipoEmpleado = 6");
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
    public Cajero obtenerCajero(int id) {
        this.conn = FactoryConnectionDb.open();
        Cajero cajero =null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Cajero WHERE id = ").append(id).append(" AND softDelete = 0");
        try {
            ResultSet rs = this.conn.query(sql.toString());
            //String codigo, String contraseña, int id, String nombre, String apellido, int dni, 
            //int sexo, int edad, int telefonoCasa, int telefonoCelular
            while(rs.next()){
                cajero= new Cajero(rs.getString("codigo"), rs.getString("contraseña"), null, rs.getInt("id")
                        , rs.getString("nombre"), rs.getString("apellido"), rs.getInt("dni"), rs.getBoolean("sexo")
                        , rs.getInt("edad"), rs.getInt("telefonoCasa"), rs.getInt("telefonoCelular")
                        , rs.getString("email"), rs.getInt("softDelete"));
            }
        } catch (Exception e) {
        }finally{
            this.conn.close();
        }
        return cajero;
    }

    @Override
    public boolean guardarCajero(Cajero cajero) {
        this.conn = FactoryConnectionDb.open();
        boolean save = false;
        
        try {
            if(cajero.getId() ==0){//new
                StringBuilder sql = new StringBuilder();
                sql.append("INSERT INTO Cajero "
                + "(codigo,nombre,apellido,dni,contraseña,edad,telefonoCasa,telefonoCelular,sexo,email,softDelete) VALUES ('"
                + cajero.getCodigo()+"','"+cajero.getNombre()+"','"+cajero.getApellido()+"',"
                + cajero.getDni()+",'"+cajero.getContraseña()+"',"
                + cajero.getEdad()+","+cajero.getTelefonoCasa()+","+cajero.getTelefonoCelular()+","
                + cajero.getSexoEntero()+",'"+cajero.getEmail()+"',0)");
                
                this.conn.execute2(sql.toString());
            }else{//update
                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE Cajero SET codigo = '").append(cajero.getCodigo()).append("'");
                sql.append(",nombre = '"+cajero.getNombre()+"'").append(",apellido = '"+cajero.getApellido()+"'");
                sql.append(",dni = "+cajero.getDni()).append(",contraseña = '"+cajero.getContraseña()+"'");
                sql.append(",edad = "+cajero.getEdad());
                sql.append(",telefonoCasa = "+cajero.getTelefonoCasa()).append(",telefonoCelular ="+cajero.getTelefonoCelular());
                sql.append(",sexo = "+cajero.getSexoEntero()).append(",email='"+cajero.getEmail()).append("',softDelete="+cajero.getSoftDelete());
                sql.append(" WHERE id = "+cajero.getId());
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
    public boolean eliminarCajero(int id) {
        this.conn = FactoryConnectionDb.open();
        boolean delete = false;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE Cajero SET softDelete = 1 WHERE id = "+id);
            this.conn.execute2(sql.toString());
            delete=true;
        } catch (Exception e) {
        }finally{
            this.conn.close();
        }
        return delete;
    }

}
