/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.daoImpl;

import estructura.ListaDoble;
import factory.ConnectionDb;
import factory.FactoryConnectionDb;
import dao.dao.MedicoTriajeDao;
import java.sql.ResultSet;
import model.empleado.MedicoTriaje;
import model.Horario;

/**
 *
 * @author LLLL
 */
public class MedicoTriajeDaoImpl implements MedicoTriajeDao{
    
    ConnectionDb conn;

    public MedicoTriajeDaoImpl() {
    }
    
    public ListaDoble<MedicoTriaje> listaMedicos() {
        this.conn = FactoryConnectionDb.open();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM MedicoTriaje WHERE softDelete=0");
        MedicoTriaje medico=null;
        ListaDoble<MedicoTriaje> list = new ListaDoble<MedicoTriaje>();
        try {
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
                medico= new MedicoTriaje(rs.getString("colegiatura"), rs.getString("codigo"),
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
            list = new ListaDoble<MedicoTriaje>();
        }
        return list;
    }

    @Override
    public void mostrarMedicos() {
        this.conn = FactoryConnectionDb.open();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM MedicoTriaje");
        try {
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
                System.out.print("Id : "+rs.getString("id"));
                System.out.print(" * Nombre :"+rs.getString("nombre"));
                System.out.print(" * Apellido : "+rs.getString("apellido"));
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
    //parametro id del medico
    @Override
    public ListaDoble<Horario> obtenerHorarios(int id){
        ListaDoble<Horario> listaHorario= new ListaDoble<Horario>();
        this.conn = FactoryConnectionDb.open();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Horarios WHERE empleadoId="+id);
        sql.append(" AND tipoEmpleado = 3");
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
    public MedicoTriaje obtenerMedico(int id) {
        this.conn = FactoryConnectionDb.open();
        MedicoTriaje medico=null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM MedicoTriaje WHERE id = ").append(id).append(" AND softDelete = 0");
        try {
            ResultSet rs = this.conn.query(sql.toString());
            //String codigo, String contraseña, int id, String nombre, String apellido, int dni, 
            //int sexo, int edad, int telefonoCasa, int telefonoCelular
            while(rs.next()){
                medico= new MedicoTriaje(rs.getString("colegiatura"), rs.getString("codigo"),
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
    public boolean guardarMedico(MedicoTriaje medicoTriaje) {
        this.conn = FactoryConnectionDb.open();
        boolean save = false;
        
        
        try {
            if(medicoTriaje.getId() ==0){//new
                StringBuilder sql = new StringBuilder();
                sql.append("INSERT INTO MedicoTriaje "
                + "(codigo,nombre,apellido,dni,contraseña,colegiatura,edad,telefonoCasa,telefonoCelular,sexo,email,softDelete) VALUES ('"
                + medicoTriaje.getCodigo()+"','"+medicoTriaje.getNombre()+"','"+medicoTriaje.getApellido()+"',"
                + medicoTriaje.getDni()+",'"+medicoTriaje.getContraseña()+"','"+medicoTriaje.getColegiatura()+"',"
                + medicoTriaje.getEdad()+","+medicoTriaje.getTelefonoCasa()+","+medicoTriaje.getTelefonoCelular()+","
                + medicoTriaje.getSexoEntero()+",'"+medicoTriaje.getEmail()+"',0)");
                
                this.conn.execute2(sql.toString());
            }else{//update
                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE MedicoTriaje SET codigo = '").append(medicoTriaje.getCodigo()).append("'");
                sql.append(",nombre = '"+medicoTriaje.getNombre()+"'").append(",apellido = '"+medicoTriaje.getApellido()+"'");
                sql.append(",dni = "+medicoTriaje.getDni()).append(",contraseña = '"+medicoTriaje.getContraseña()+"'");
                sql.append(",edad = "+medicoTriaje.getEdad()).append(",colegiatura = '"+medicoTriaje.getColegiatura()+"'");
                sql.append(",telefonoCasa = "+medicoTriaje.getTelefonoCasa()).append(",telefonoCelular ="+medicoTriaje.getTelefonoCelular());
                sql.append(",sexo = "+medicoTriaje.getSexoEntero()).append(",email='"+medicoTriaje.getEmail()).append("',softDelete="+medicoTriaje.getSoftDelete());
                sql.append(" WHERE id = "+medicoTriaje.getId());
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
            sql.append("UPDATE MedicoTriaje SET softDelete = 1 WHERE id = "+id);
            this.conn.execute2(sql.toString());
            delete=true;
        } catch (Exception e) {
        }finally{
            this.conn.close();
        }
        return delete;
    }
    
}
