/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.triaje;

import estructura.ListaDoble;
import factory.ConnectionDb;
import factory.FactoryConnectionDb;
import java.sql.ResultSet;
import model.paciente.Paciente;

/**
 *
 * @author Pechito
 */
public class TriajeDaoImp implements TriajeDao{
    ConnectionDb conn;

    public TriajeDaoImp() {}

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

    @Override
    public void mostrarPacientes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Paciente obtenerPaciente(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean guardarPaciente(Paciente paciente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarPaciente(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
