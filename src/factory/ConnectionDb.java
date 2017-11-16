/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author LLLL
 */
public abstract class ConnectionDb {
    protected String[] params;
    protected Connection connection;
    
    abstract Connection open();
    abstract Connection create();
    
    public ResultSet query(String query){
        Statement st;
        ResultSet rs = null;
        try {
            st = connection.createStatement();

            rs = st.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    //se usa para select
    public boolean execute(String query){
        Statement st;
        boolean save = true;
        try {
            st = connection.createStatement();
            st.executeQuery(query);
        } catch (SQLException e) {
            save = false;
            e.printStackTrace();
        }
        return save;
    }
    //Se usa para insert y upadte
    public boolean execute2(String query){
        Statement st;
        boolean save = true;
        try {
            st = connection.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e) {
            save = false;
            e.printStackTrace();
        }
        return save;
    }
    public boolean close(){
        boolean ok = true;
        try {
            connection.close();
        } catch (Exception e) {
            ok = false;
            e.printStackTrace();
        }
        return ok;
    }
}
