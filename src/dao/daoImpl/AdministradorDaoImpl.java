/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.daoImpl;

import dao.dao.AdministradorDao;
import factory.ConnectionDb;
import factory.FactoryConnectionDb;
import java.sql.ResultSet;
import model.empleado.Administrador;

/**
 *
 * @author LLLL
 */
public class AdministradorDaoImpl implements AdministradorDao{
    
    ConnectionDb conn;
    
    public AdministradorDaoImpl() {
    }

    @Override
    public void mostrarAdministrador() {
    }

    @Override
    public Administrador obtenerAdministrador() {
        this.conn = FactoryConnectionDb.open();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Administrador ");
        Administrador administrador = null;
        try {
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
                System.out.println("NOMBRE ADMIN : "+rs.getString("nombre"));
                administrador = new Administrador(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido")
                        , rs.getString("codigo"), rs.getString("contraseña"));
            }
        } catch (Exception e) {
            
        }finally{
            this.conn.close();
        }
        
        return administrador;
    }

    @Override
    public boolean guardarAdministrador(Administrador administrador) {
        this.conn = FactoryConnectionDb.open();
        boolean save = false;
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE Administrador SET codigo = '").append(administrador.getCodigo()).append("'");
            sql.append(",nombre = '"+administrador.getNombre()+"'").append(",apellido = '"+administrador.getApellido()+"'");
            sql.append(",contraseña = '"+administrador.getContraseña());
            sql.append("' WHERE id = 1");
            this.conn.execute2(sql.toString());
            save = true;
        }catch(Exception e){
            
        }
        return save;
    }
    
}
