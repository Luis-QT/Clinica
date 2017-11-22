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
        this.conn = FactoryConnectionDb.open();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Paciente");
        Paciente paciente=null;
        
        ListaDoble<Paciente> list = new ListaDoble<Paciente>();
        try {
            ResultSet rs = this.conn.query(sql.toString());
             while(rs.next()){
                paciente = new Paciente(rs.getInt("id"),rs.getString("nombre"),
                        rs.getString("apellido"),rs.getInt("dni"), rs.getBoolean("sexo"),
                        rs.getInt("edad"),rs.getInt("telefonoCasa"),
                        rs.getInt("telefonoCelular"),rs.getString("email"),
                        rs.getInt("softDelete"),
                        rs.getString("tipoSangre"),
                        rs.getString("alergia"), rs.getString("codigoP")) ;
                list.insertarAlFinal(paciente);
            }
        } catch (Exception e) {
            
        }finally{
            this.conn.close();
        }
        if(list == null){
            list = new ListaDoble<Paciente>();
        }
        
        return list;
    }

    @Override
    public void mostrarPacientes() {
            this.conn = FactoryConnectionDb.open();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Paciente");
        try {
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
                System.out.print("Id : "+rs.getString("id"));
                System.out.print(" * Nombre :"+rs.getString("nombre"));
                System.out.print(" * Apellido : "+rs.getString("apellido"));
                System.out.print(" * Dni : "+rs.getInt("dni"));
                System.out.print(" * Sexo : "+rs.getBoolean("sexo"));
                System.out.print(" * edad : "+rs.getInt("edad"));
                System.out.print(" * Telefono : "+rs.getInt("telefonoCasa"));
                System.out.print(" * Celular : "+rs.getInt("telefonoCelular"));
                System.out.print(" * email : "+rs.getString("email"));
                System.out.println(" * softDelete : "+ rs.getInt("softDelete"));
                System.out.print(" * TipoSangre : "+rs.getString("tipoSangre"));
                System.out.print(" * Alergias : "+rs.getString("alergias"));
                System.out.print(" * Codigo Historial : "+rs.getString("codigoHistorial"));
                
            }
        } catch (Exception e) {
            
        }finally{
            this.conn.close();
        }
    }

    @Override
    public Paciente obtenerPaciente(int id) {
        
        
        this.conn = FactoryConnectionDb.open();
        Paciente paciente =null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Paciente WHERE codigoHistorial = ").append(id).append(" AND softDelete = 0");
        try {
            ResultSet rs = this.conn.query(sql.toString());
            //String codigo, String contraseña, int id, String nombre, String apellido, int dni, 
            //int sexo, int edad, int telefonoCasa, int telefonoCelular
            while(rs.next()){
                paciente = new Paciente(rs.getInt("id"), rs.getString("nombre")
                        ,rs.getString("apellido")
                        ,rs.getInt("dni"), rs.getBoolean("sexo"), rs.getInt("edad")
                        ,rs.getInt("telefonoCasa"), rs.getInt("telefonoCelular")
                        ,rs.getString("email"),rs.getInt("softDelete")
                        , rs.getString("tipoSangre"),rs.getString("alergias"),rs.getString("codigo"));
            }
        } catch (Exception e) {
        }finally{
            this.conn.close();
        }
        return paciente;
    }

    @Override
    public boolean guardarPaciente(Paciente paciente) {
        this.conn = FactoryConnectionDb.open();
        boolean save = false;
        
        try {
            if(paciente.getId() == 0){//new
                StringBuilder sql = new StringBuilder();
                /**
                + "(id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), PRIMARY KEY(id), 
                * nombre VARCHAR(20), apellido VARCHAR(20) ,dni INT , "
            + "sexo SMALLINT,edad SMALLINT,telefonoCasa INT,telefonoCelular INT,
            * email VARCHAR(40),softDelete SMALLINT,tipoSangre VARCHAR(40),
            * alergias VARCHAR(40))",          
        
                */
                
                sql.append("INSERT INTO Paciente"
                + "(nombre,apellido,dni,sexo,edad,telefonoCasa,telefonoCelular,email,softDelete,tipoSangre,alergias) VALUES ("
                + paciente.getNombre()+"','"+paciente.getApellido()+"','"
                + paciente.getDni()+"','"+paciente.getSexoEntero()+"','"
                + paciente.getEdad()+"','"+paciente.getTelefonoCasa()+"','"
                + paciente.getTelefonoCelular()+"','"+ paciente.getEmail()+"','"
                + "0" + "','" +paciente.getTipoSangre() + "','" + paciente.getAlergia());
                
                this.conn.execute2(sql.toString());
            }else{//update
                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE Paciente SET codigo = '").append(paciente.getCodigoP()).append("'");
                sql.append(",nombre = '"+paciente.getNombre()+"'").append(",apellido = '"+paciente.getApellido()+"'");
                sql.append(",dni = "+paciente.getDni()).append(",sexo = '"+paciente.getSexoEntero()+"'");
                sql.append(",edad = "+paciente.getEdad());
                sql.append(",telefonoCasa = "+paciente.getTelefonoCasa()).append(",telefonoCelular ="+paciente.getTelefonoCelular());
                sql.append(",email = "+paciente.getEmail()).append(",softDelete='"+paciente.getSoftDelete()).append("',tipoSangre="+paciente.getTipoSangre());
                sql.append(" WHERE id = "+paciente.getId());
                this.conn.execute2(sql.toString());
            }
            save = true;
        } catch (Exception e) {
            System.out.println("Error >:v");
        } finally{
            this.conn.close();
        }
        return save;
    }

    @Override
    public boolean eliminarPaciente(int id) {
        this.conn = FactoryConnectionDb.open();
        boolean delete = false;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE Paciente SET softDelete = 1 WHERE codigoHistorial = "+id);
            this.conn.execute2(sql.toString());
            delete=true;
        } catch (Exception e) {
        }finally{
            this.conn.close();
        }
        return delete;
    }
    
}
