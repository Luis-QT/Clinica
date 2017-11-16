/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.daoImpl;

import estructura.ListaDoble;
import factory.ConnectionDb;
import factory.FactoryConnectionDb;
import dao.dao.MedicoLaboratorioDao;
import model.empleado.MedicoLaboratorio;
import java.sql.ResultSet;
import model.Horario;
/**
 *
 * @author LLLL
 */
public class MedicoLaboratorioDaoImpl implements MedicoLaboratorioDao{

    private ConnectionDb conn;

    public MedicoLaboratorioDaoImpl() {
    }

    @Override
    public ListaDoble<MedicoLaboratorio> listaMedicos() {
        this.conn = FactoryConnectionDb.open();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM MedicoLaboratorio WHERE softDelete=0");
        MedicoLaboratorio medico=null;
        ListaDoble<MedicoLaboratorio> list = new ListaDoble<MedicoLaboratorio>();
        try {
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
                medico= new MedicoLaboratorio(rs.getString("colegiatura"), rs.getString("codigo"),
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
            list = new ListaDoble<MedicoLaboratorio>();
        }
        return list;
    }

    @Override
    public void mostrarMedicos() {
        this.conn = FactoryConnectionDb.open();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM MedicoLaboratorio");
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
        sql.append(" AND tipoEmpleado = 4");
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
    public MedicoLaboratorio obtenerMedico(int id) {
        this.conn = FactoryConnectionDb.open();
        MedicoLaboratorio medico=null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM MedicoLaboratorio WHERE id = ").append(id).append(" AND softDelete = 0");
        try {
            ResultSet rs = this.conn.query(sql.toString());
            //String codigo, String contraseña, int id, String nombre, String apellido, int dni, 
            //int sexo, int edad, int telefonoCasa, int telefonoCelular
            while(rs.next()){
                medico= new MedicoLaboratorio(rs.getString("colegiatura"), rs.getString("codigo"),
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
    public boolean guardarMedico(MedicoLaboratorio medicoLaboratorio) {
        this.conn = FactoryConnectionDb.open();
        boolean save = false;
        
        
        try {
            if(medicoLaboratorio.getId() ==0){//new
                StringBuilder sql = new StringBuilder();
                sql.append("INSERT INTO MedicoLaboratorio "
                + "(codigo,nombre,apellido,dni,contraseña,colegiatura,edad,telefonoCasa,telefonoCelular,sexo,email,softDelete) VALUES ('"
                + medicoLaboratorio.getCodigo()+"','"+medicoLaboratorio.getNombre()+"','"+medicoLaboratorio.getApellido()+"',"
                + medicoLaboratorio.getDni()+",'"+medicoLaboratorio.getContraseña()+"','"+medicoLaboratorio.getColegiatura()+"',"
                + medicoLaboratorio.getEdad()+","+medicoLaboratorio.getTelefonoCasa()+","+medicoLaboratorio.getTelefonoCelular()+","
                + medicoLaboratorio.getSexoEntero()+",'"+medicoLaboratorio.getEmail()+"',0)");
                
                this.conn.execute2(sql.toString());
            }else{//update
                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE MedicoLaboratorio SET codigo = '").append(medicoLaboratorio.getCodigo()).append("'");
                sql.append(",nombre = '"+medicoLaboratorio.getNombre()+"'").append(",apellido = '"+medicoLaboratorio.getApellido()+"'");
                sql.append(",dni = "+medicoLaboratorio.getDni()).append(",contraseña = '"+medicoLaboratorio.getContraseña()+"'");
                sql.append(",edad = "+medicoLaboratorio.getEdad()).append(",colegiatura = '"+medicoLaboratorio.getColegiatura()+"'");
                sql.append(",telefonoCasa = "+medicoLaboratorio.getTelefonoCasa()).append(",telefonoCelular ="+medicoLaboratorio.getTelefonoCelular());
                sql.append(",sexo = "+medicoLaboratorio.getSexoEntero()).append(",email='"+medicoLaboratorio.getEmail()).append("',softDelete="+medicoLaboratorio.getSoftDelete());
                sql.append(" WHERE id = "+medicoLaboratorio.getId());
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
    public boolean eliminarMedico(int id) {
        this.conn = FactoryConnectionDb.open();
        boolean delete = false;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE MedicoLaboratorio SET softDelete = 1 WHERE id = "+id);
            this.conn.execute2(sql.toString());
            delete=true;
        } catch (Exception e) {
        }finally{
            this.conn.close();
        }
        return delete;
    }
    
}
