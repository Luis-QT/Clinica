
package dao.Empleado;

import estructura.ListaDoble;
import factory.ConnectionDb;
import factory.FactoryConnectionDb;
import java.sql.ResultSet;
import model.empleado.MedicoEspecialista;
import model.paciente.Paciente;


public class MedicoEspecialistaDaoI {
    
    ConnectionDb conn;
    
     public ListaDoble<Paciente> list() {
        this.conn = FactoryConnectionDb.open();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Pacientes WHERE softDelete=0");
        Paciente paciente = null;
        ListaDoble<Paciente> listaPaciente = new ListaDoble<Paciente>();
        try{
             ResultSet rs = this.conn.query(sql.toString());
                     /*
             public Paciente(int id, String nombre, String apellido, int dni, 
            boolean sexo, int edad, int telefonoCasa, int telefonoCelular, 
            String email, int softDelete,String tipoSangre, String alergias,String codigo) {
             */
            while(rs.next()){
                paciente = new Paciente(rs.getInt("id"),rs.getString("nombre"),
                        rs.getString("apellido"),rs.getInt("dni"), rs.getBoolean("sexo"),
                        rs.getInt("edad"),rs.getInt("telefonoCasa"),
                        rs.getInt("telefonoCelular"),rs.getString("email"),
                        rs.getInt("softDelete"),
                        rs.getString("tipoSamgre"),
                        rs.getString("alergias"),rs.getString("codigo")) ;
                listaPaciente.insertarAlFinal(paciente);
//                medico.setHorarios(horarios(rs.getInt("id")));
//                list.insertarAlFinal(medico);
            }
            
        }catch(Exception e){
         System.out.println(e);
        }finally{
            this.conn.close();
        }
        
        return listaPaciente;
         
     }
     
     
    public ListaDoble<Paciente> Actualizar (){
        return list();
        
        
    }
    
    
    public boolean save(Paciente paciente) {
        this.conn = FactoryConnectionDb.open();
        boolean save = false;
        try {
            
            /*
             public Paciente(int id, String nombre, String apellido, int dni, 
            boolean sexo, int edad, int telefonoCasa, int telefonoCelular, 
            String email, int softDelete,String tipoSangre, String alergias,String codigo) {
             */
            
            if(paciente.getId() ==0){//new
                StringBuilder sql = new StringBuilder();
                sql.append("INSERT INTO Paciente"
                + "(id,nombre,apellido,dni,sexo, edad, telefonoCasa,telefonoCelular,email,softDelete, tipoSangre, alergias, codigo) VALUES ('"
                + paciente.getId()+"','"
                + paciente.getNombre()+"','"+ paciente.getApellido()+"','"
                + paciente.getDni()+",'"+ paciente.getSexoEntero()+"','"
                + paciente.getEdad()+","+ paciente.getTelefonoCasa()+","
                + paciente.getTelefonoCelular()+","+ paciente.getEmail()+"','"
                + paciente.getTipoSangre()+"','"+ paciente.getAlergia()+",'"
                + paciente.getCodigo()+"',0)");
                
                this.conn.execute2(sql.toString());
            }else{//update
//                StringBuilder sql = new StringBuilder
//                sql.append("UPDATE Paciente SET codigo = '").append(paciente.getCodigo()).append("'");
//                sql.append(",especialidad ='"+paciente.getEspecialidad()+"'");
//                sql.append(",nombre = '"+paciente.getNombre()+"'").append(",apellido = '"+paciente.getApellido()+"'");
//                sql.append(",dni = "+paciente.getDni()).append(",contraseña = '"+paciente.getContraseña()+"'");
//                sql.append(",edad = "+paciente.getEdad()).append(",colegiatura = '"+paciente.getColegiatura()+"'");
//                sql.append(",telefonoCasa = "+paciente.getTelefonoCasa()).append(",telefonoCelular ="+paciente.getTelefonoCelular());
//                sql.append(",sexo = "+paciente.getSexoEntero()).append(",email='"+paciente.getEmail()).append("',softDelete="+paciente.getSoftDelete());
//                sql.append(" WHERE id = "+paciente.getId());
//                this.conn.execute2(sql.toString());
            }
            save = true;
        } catch (Exception e) {
            System.out.println(":c");
        } finally{
            this.conn.close();
        }
        return save;
    }
     
     
     
     
     
     
     
     
     
     
     
}
