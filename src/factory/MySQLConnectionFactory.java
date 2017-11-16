/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LLLL
 */
public final class MySQLConnectionFactory extends ConnectionDb{

    public MySQLConnectionFactory(String[] params) {
        this.params = params;
        this.create();
    }

    public MySQLConnectionFactory() {
        this.open();
    }
    public MySQLConnectionFactory(int a){
        this.shutdown();
    }
    
    @Override
    public Connection open() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            this.connection = DriverManager.getConnection("jdbc:derby:.\\DB\\Derby.DB");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.connection;
    }

    @Override
    public Connection create() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            this.connection = DriverManager.getConnection("jdbc:derby:.\\DB\\Derby.DB;create=true");
            for(String p : this.params){
                PreparedStatement pstm = this.connection.prepareStatement(p);
                pstm.execute();
                pstm.close();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.connection;
    }

    public static void  shutdown() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
            System.exit(0);
        }    
        
    }
    
}
