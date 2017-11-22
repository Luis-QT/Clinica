
package dao.contabilidad;

import dao.recepcion.Recepcion;
import estructura.ListaDoble;
import factory.ConnectionDb;
import factory.FactoryConnectionDb;
import java.sql.ResultSet;
import model.empleado.Servicios;
import model.paciente.Paciente;

public class ContabilidadDaoImplementado implements ContabilidadDao {
    ConnectionDb conn;

    public ContabilidadDaoImplementado() {
    }
    
    
   
    @Override
    public ListaDoble<Servicios> listaServicios() {
     
        this.conn = FactoryConnectionDb.open();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Paciente");
        Paciente paciente=null;
        
        ListaDoble<Servicios> list = new ListaDoble<Servicios>();
//        try {
//            ResultSet rs = this.conn.query(sql.toString());
//            while(rs.next()){
//                paciente = new Paciente(rs.getInt("id"),rs.getString("nombre"),
//                        rs.getString("apellido"),rs.getInt("dni"), rs.getBoolean("sexo"),
//                        rs.getInt("edad"),rs.getInt("telefonoCasa"),
//                        rs.getInt("telefonoCelular"),rs.getString("email"),
//                        rs.getInt("softDelete"),
//                        rs.getString("tipoSangre"),
//                        rs.getString("alergias"), rs.getString("codigoP")) ;
//                System.out.println("PACIENTE : "+paciente.getId());
//                list.insertarAlFinal(paciente);
//                System.out.println("tamaño : "+list.size);
//            }
//        } catch (Exception e) {
//            
//        }finally{
//            this.conn.close();
//        }
//        if(list==null){
//            System.out.println("vacio");
//            list = new ListaDoble<Paciente>();
//        }
        return list;
        
    }

    @Override
    public void mostrarServicios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Paciente obtenerServicios(int id) {
    this.conn = FactoryConnectionDb.open();
        Paciente paciente =null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Paciente WHERE id = ").append(id).append(" AND softDelete = 0");
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
    public boolean guardarServicios(Paciente paciente) {
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
                + "(nombre,apellido,dni,sexo,edad,telefonoCasa,telefonoCelular,email,softDelete,tipoSangre,alergias,codigoP) VALUES ("
                + paciente.getNombre()+"','"+paciente.getApellido()+"','"
                + paciente.getDni()+"','"+paciente.getSexoEntero()+"','"
                + paciente.getEdad()+"','"+paciente.getTelefonoCasa()+"','"
                + paciente.getTelefonoCelular()+"','"+ paciente.getEmail()+"','"
                + "0" + "','" +paciente.getTipoSangre() + "','" + paciente.getAlergia()+"','" + paciente.getCodigoP());
                
                this.conn.execute2(sql.toString());
            }else{//update
                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE Paciente SET codigo = '").append(paciente.getCodigoP()).append("'");
                sql.append(",nombre = '"+paciente.getNombre()+"'").append(",apellido = '"+paciente.getApellido()+"'");
                sql.append(",dni = "+paciente.getDni()).append(",sexo = '"+paciente.getSexoEntero()+"'");
                sql.append(",edad = "+paciente.getEdad());
                sql.append(",telefonoCasa = "+paciente.getTelefonoCasa()).append(",telefonoCelular ="+paciente.getTelefonoCelular());
                sql.append(",email = "+paciente.getEmail()).append(",softDelete='"+paciente.getSoftDelete()).append("',tipoSangre="+paciente.getTipoSangre());
                sql.append(",alergias = "+paciente.getAlergia()).append(",codigoP='"+paciente.getCodigoP());
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
    public boolean eliminarServicios(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
}
