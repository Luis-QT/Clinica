/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.contabilidad;

import estructura.ListaDoble;
import factory.ConnectionDb;
import factory.FactoryConnectionDb;
import java.sql.ResultSet;
import model.paciente.Paciente;

/**
 *
 * @author user
 */
public class ContabilidadDaoImp {
     ConnectionDb conn;

    public ContabilidadDaoImp() {
    }
    
     public ListaDoble<Paciente> listaPacientes() {
         
        this.conn = FactoryConnectionDb.open();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Paciente");
        Paciente paciente=null;
        
        ListaDoble<Paciente> list = new ListaDoble<Paciente>();
        try {
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
                System.out.println("ID BD : "+rs.getInt("id"));
                paciente = new Paciente(rs.getInt("id"),rs.getString("nombre"),
                        rs.getString("apellido"),rs.getInt("dni"), rs.getBoolean("sexo"),
                        rs.getInt("edad"),rs.getInt("telefonoCasa"),
                        rs.getInt("telefonoCelular"),rs.getString("email"),
                        rs.getInt("softDelete"),
                        rs.getString("tipoSangre"),
                        rs.getString("alergias"), rs.getString("codigoP")) ;
                System.out.println("PACIENTE : "+paciente.getId());
                list.insertarAlFinal(paciente);
                System.out.println("tamaño : "+list.size);
            }
        } catch (Exception e) {
            
        }finally{
            this.conn.close();
        }
        if(list==null){
            System.out.println("vacio");
            list = new ListaDoble<Paciente>();
        }
        return list;
        
        
     }
     
     
    public boolean guardarPaciente(Paciente paciente) {
        this.conn = FactoryConnectionDb.open();
        boolean save = false;
        System.out.println(paciente.getNombre());
        System.out.println(paciente.getApellido());
        System.out.println(paciente.getDni());
        System.out.println(paciente.getNombre());
        System.out.println(paciente.getNombre());
        System.out.println(paciente.getNombre());
        System.out.println(paciente.getNombre());

        try {
            if (paciente.getId() == 0) {//new
                StringBuilder sql = new StringBuilder();
                /**
                 * + "(id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH
                 * 1, INCREMENT BY 1), PRIMARY KEY(id), nombre VARCHAR(20),
                 * apellido VARCHAR(20) ,dni INT , " + "sexo SMALLINT,edad
                 * SMALLINT,telefonoCasa INT,telefonoCelular INT, email
                 * VARCHAR(40),softDelete SMALLINT,tipoSangre VARCHAR(40),
                 * alergias VARCHAR(40))",                  *
                 */

                sql.append("INSERT INTO Paciente"
                        + "(nombre,apellido,dni,sexo,edad,telefonoCasa,telefonoCelular,email,softDelete,tipoSangre,alergias,codigoP) VALUES ( '"
                        + paciente.getNombre() + "','" + paciente.getApellido() + "',"
                        + paciente.getDni() + "," + paciente.getSexoEntero() + ","
                        + paciente.getEdad() + "," + paciente.getTelefonoCasa() + ","
                        + paciente.getTelefonoCelular() + ",'" + paciente.getEmail() + "',"
                        + "0" + ",'" + paciente.getTipoSangre() + "','" + paciente.getAlergia()+"','"+paciente.getCodigoP()+"')");

                this.conn.execute2(sql.toString());
            } else {//update
                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE Paciente SET codigo = '").append(paciente.getCodigoP()).append("'");
                sql.append(",nombre = '" + paciente.getNombre() + "'").append(",apellido = '" + paciente.getApellido() + "'");
                sql.append(",dni = " + paciente.getDni()).append(",sexo = " + paciente.getSexoEntero() + "");
                sql.append(",edad = " + paciente.getEdad());
                sql.append(",telefonoCasa = " + paciente.getTelefonoCasa()).append(",telefonoCelular =" + paciente.getTelefonoCelular());
                sql.append(",email = '"+ paciente.getEmail()+ "'").append(",softDelete=" + paciente.getSoftDelete()).append(",tipoSangre= '" + paciente.getTipoSangre()).append("',alergias= '" + paciente.getAlergia());
                sql.append("' WHERE id = " + paciente.getId());
                this.conn.execute2(sql.toString());
            }
            save = true;
        } catch (Exception e) {
            System.out.println("Error >:v");
        } finally {
            this.conn.close();
        }
        return save;
    }
     
     
     
}
