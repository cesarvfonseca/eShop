/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author cvalenciano
 */
public class conexion {
    private String username = "root";
    private String password="";
    private String hostname="localhost";
    private String port="";
    private String database="8080";
    private String classname="com.mysql.jdbcDriver";
    private String url="jdbc:mysql://"+hostname+":"+port+"/"+database;
    private Connection conn;
    
    public conexion(){
        try {
            Class.forName(classname);
            conn = (Connection) DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public Connection getConnection (){
        return this.conn;
    }
    
}
