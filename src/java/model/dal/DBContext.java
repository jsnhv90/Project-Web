/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vy dau khac
 * @param <T>
 */
public abstract class DBContext<T> {
    Connection conn;

    public DBContext() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=BookManagement";
        String user = "sa";
        String password = "sa";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            System.out.println("can't found jdbc to get sql server driver");
        }
        try {
            this.conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("can't get conn to database");
        }
    }
    
    
}
