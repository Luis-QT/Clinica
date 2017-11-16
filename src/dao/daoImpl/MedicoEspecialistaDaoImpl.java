/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.daoImpl;

import dao.dao.MedicoEspecialistaDao;
import estructura.ListaDoble;
import factory.ConnectionDb;
import factory.FactoryConnectionDb;
import java.sql.ResultSet;
import model.empleado.MedicoEspecialista;
import model.Horario;

public class MedicoEspecialistaDaoImpl implements MedicoEspecialistaDao{
    
    ConnectionDb conn;

    @Override
    public ListaDoble<MedicoEspecialista> listaMedicos() {
        this.conn = FactoryConnectionDb.open();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM MedicoEspecialista WHERE softDelete=0");
        MedicoEspecialista medico=null;
        ListaDoble<MedicoEspecialista> list = new ListaDoble<MedicoEspecialista>();
        try {
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
                medico= new MedicoEspecialista(rs.getString("especialidad"),rs.getString("colegiatura"), rs.getString("codigo"),
                        rs.getString("contraseña"), null , rs.getInt("id"),rs.getString("nombre"),
                        rs.getString("apellido"), rs.getInt("dni"), rs.getBoolean("sexo"),
                        rs.getInt("edad"), rs.getInt("telefonoCasa"), rs.getInt("telefonoCelular")
                        ,rs.getString("email"), rs.getInt("softDelete"));
                
                medico.setHorarios(obtenerHorarios(rs.getInt("id")));
                list.insertarAlFinal(medico);
            }
        } catch (Exception e) {
            
        }finally{
            this.conn.close();
        }
        if(list==null){
            list = new ListaDoble<MedicoEspecialista>();
        }
        return list;
    }
    
    @Override
    public ListaDoble<Horario> obtenerHorarios(int id){
        ListaDoble<Horario> listaHorario= new ListaDoble<Horario>();
        this.conn = FactoryConnectionDb.open();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Horarios WHERE empleadoId="+id);
        sql.append(" AND tipoEmpleado = 2");
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
    public void mostrarMedicos() {
        this.conn = FactoryConnectionDb.open();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM MedicoEspecialista");
        try {
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
                System.out.print("Id : "+rs.getString("id"));
                System.out.print(" * Nombre :"+rs.getString("nombre"));
                System.out.print(" * Apellido : "+rs.getString("apellido"));
                System.out.print(" * Especialidad : "+rs.getInt("especialidad"));
                System.out.print(" * Dni : "+rs.getInt("dni"));
                System.out.print(" * edad : "+rs.getInt("edad"));
                System.out.print(" * Codigo : "+rs.getString("codigo"));
                System.out.print(" * Colegiatura : "+rs.getString("colegiatura"));
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

    @Override
    public MedicoEspecialista obtenerMedico(int id) {
        this.conn = FactoryConnectionDb.open();
        MedicoEspecialista medico=null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM MedicoEspecialista WHERE id = ").append(id).append(" AND softDelete = 0");
        try {
            ResultSet rs = this.conn.query(sql.toString());
            //String codigo, String contraseña, int id, String nombre, String apellido, int dni, 
            //int sexo, int edad, int telefonoCasa, int telefonoCelular
            while(rs.next()){
                medico= new MedicoEspecialista(rs.getString("especialidad"),rs.getString("colegiatura"), rs.getString("codigo"),
                        rs.getString("contraseña"), null , rs.getInt("id"),rs.getString("nombre"),
                        rs.getString("apellido"), rs.getInt("dni"), rs.getBoolean("sexo"),
                        rs.getInt("edad"), rs.getInt("telefonoCasa"), rs.getInt("telefonoCelular")
                        ,rs.getString("email"), rs.getInt("softDelete"));
            }
        } catch (Exception e) {
        }finally{
            this.conn.close();
        }
        return medico;
    }

    @Override
    public boolean guardarMedico(MedicoEspecialista medicoEspecialista) {
        this.conn = FactoryConnectionDb.open();
        boolean save = false;
        try {
            if(medicoEspecialista.getId() ==0){//new
                StringBuilder sql = new StringBuilder();
                sql.append("INSERT INTO MedicoEspecialista "
                + "(especialidad,codigo,nombre,apellido,dni,contraseña,colegiatura,edad,telefonoCasa,telefonoCelular,sexo,email,softDelete) VALUES ('"
                + medicoEspecialista.getEspecialidad()+"','"
                + medicoEspecialista.getCodigo()+"','"+medicoEspecialista.getNombre()+"','"+medicoEspecialista.getApellido()+"',"
                + medicoEspecialista.getDni()+",'"+medicoEspecialista.getContraseña()+"','"+medicoEspecialista.getColegiatura()+"',"
                + medicoEspecialista.getEdad()+","+medicoEspecialista.getTelefonoCasa()+","+medicoEspecialista.getTelefonoCelular()+","
                + medicoEspecialista.getSexoEntero()+",'"+medicoEspecialista.getEmail()+"',0)");
                
                this.conn.execute2(sql.toString());
            }else{//update
                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE MedicoEspecialista SET codigo = '").append(medicoEspecialista.getCodigo()).append("'");
                sql.append(",especialidad ='"+medicoEspecialista.getEspecialidad()+"'");
                sql.append(",nombre = '"+medicoEspecialista.getNombre()+"'").append(",apellido = '"+medicoEspecialista.getApellido()+"'");
                sql.append(",dni = "+medicoEspecialista.getDni()).append(",contraseña = '"+medicoEspecialista.getContraseña()+"'");
                sql.append(",edad = "+medicoEspecialista.getEdad()).append(",colegiatura = '"+medicoEspecialista.getColegiatura()+"'");
                sql.append(",telefonoCasa = "+medicoEspecialista.getTelefonoCasa()).append(",telefonoCelular ="+medicoEspecialista.getTelefonoCelular());
                sql.append(",sexo = "+medicoEspecialista.getSexoEntero()).append(",email='"+medicoEspecialista.getEmail()).append("',softDelete="+medicoEspecialista.getSoftDelete());
                sql.append(" WHERE id = "+medicoEspecialista.getId());
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
    public boolean eliminarMedico(int id) {
        this.conn = FactoryConnectionDb.open();
        boolean delete = false;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE MedicoEspecialista SET softDelete = 1 WHERE id = "+id);
            this.conn.execute2(sql.toString());
            delete=true;
        } catch (Exception e) {
        }finally{
            this.conn.close();
        }
        return delete;
    }
    
}
