/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
//luis
import controlador.administrador.AdministradorController;
import factory.ConnectionDb;
import factory.FactoryConnectionDb;
import factory.MySQLConnectionFactory;
import gui.administrador.FramePrincipalAdministrador;

/**
 *
 * @author LLLL
 */
public class Administrador {
    public static void main(String[] args) {
       // ConnectionDb conn = FactoryConnectionDb.open();
//        MySQLConnectionFactory.shutdown();
        
        FramePrincipalAdministrador frame = new FramePrincipalAdministrador();
        new AdministradorController(frame).index();
    }
}
