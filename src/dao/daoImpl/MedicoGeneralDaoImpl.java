/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.daoImpl;

import dao.dao.MedicoGeneralDao;
import estructura.ListaDoble;
import factory.ConnectionDb;
import factory.FactoryConnectionDb;
import java.sql.ResultSet;
import java.util.Iterator;
import model.empleado.MedicoGeneral;
import model.Horario;

/**
 *
 * @author LLLL
 */
public class MedicoGeneralDaoImpl implements MedicoGeneralDao{
    
    ConnectionDb conn;

    public MedicoGeneralDaoImpl() {
    }
    
    public ListaDoble<MedicoGeneral> listaMedicos() {
        this.conn = FactoryConnectionDb.open();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM MedicoGeneral WHERE softDelete=0");
        MedicoGeneral medico=null;
        ListaDoble<MedicoGeneral> list = new ListaDoble<MedicoGeneral>();
        try {
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){

                medico= new MedicoGeneral(rs.getString("colegiatura"), rs.getString("codigo"),
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
            list = new ListaDoble<MedicoGeneral>();
        }
        return list;
    }

    @Override
    public void mostrarMedicos() {
        this.conn = FactoryConnectionDb.open();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM MedicoGeneral");
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
        sql.append(" AND tipoEmpleado = 1");
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
    public MedicoGeneral obtenerMedico(int id) {
        this.conn = FactoryConnectionDb.open();
        MedicoGeneral medico=null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM MedicoGeneral WHERE id = ").append(id).append(" AND softDelete = 0");
        try {
            ResultSet rs = this.conn.query(sql.toString());
            //String codigo, String contraseña, int id, String nombre, String apellido, int dni, 
            //int sexo, int edad, int telefonoCasa, int telefonoCelular
            while(rs.next()){
                medico= new MedicoGeneral(rs.getString("colegiatura"), rs.getString("codigo"),
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
    public boolean guardarMedico(MedicoGeneral medicoGeneral) {
        this.conn = FactoryConnectionDb.open();
        boolean save = false;
        
        
        try {
            if(medicoGeneral.getId() ==0){//new
                StringBuilder sql = new StringBuilder();
                sql.append("INSERT INTO MedicoGeneral "
                + "(codigo,nombre,apellido,dni,contraseña,colegiatura,edad,telefonoCasa,telefonoCelular,sexo,email,softDelete) VALUES ('"
                + medicoGeneral.getCodigo()+"','"+medicoGeneral.getNombre()+"','"+medicoGeneral.getApellido()+"',"
                + medicoGeneral.getDni()+",'"+medicoGeneral.getContraseña()+"','"+medicoGeneral.getColegiatura()+"',"
                + medicoGeneral.getEdad()+","+medicoGeneral.getTelefonoCasa()+","+medicoGeneral.getTelefonoCelular()+","
                + medicoGeneral.getSexoEntero()+",'"+medicoGeneral.getEmail()+"',0)");
                
                this.conn.execute2(sql.toString());
            }else{//update
                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE MedicoGeneral SET codigo = '").append(medicoGeneral.getCodigo()).append("'");
                sql.append(",nombre = '"+medicoGeneral.getNombre()+"'").append(",apellido = '"+medicoGeneral.getApellido()+"'");
                sql.append(",dni = "+medicoGeneral.getDni()).append(",contraseña = '"+medicoGeneral.getContraseña()+"'");
                sql.append(",edad = "+medicoGeneral.getEdad()).append(",colegiatura = '"+medicoGeneral.getColegiatura()+"'");
                sql.append(",telefonoCasa = "+medicoGeneral.getTelefonoCasa()).append(",telefonoCelular ="+medicoGeneral.getTelefonoCelular());
                sql.append(",sexo = "+medicoGeneral.getSexoEntero()).append(",email='"+medicoGeneral.getEmail()).append("',softDelete="+medicoGeneral.getSoftDelete());
                sql.append(" WHERE id = "+medicoGeneral.getId());
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
            sql.append("UPDATE MedicoGeneral SET softDelete = 1 WHERE id = "+id);
            this.conn.execute2(sql.toString());
            delete=true;
        } catch (Exception e) {
        }finally{
            this.conn.close();
        }
        return delete;
    }
    
}




























