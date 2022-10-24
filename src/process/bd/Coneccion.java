/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author fesco
 */
public class Coneccion {
    
    
    private Connection con;
    private DataSource dt;
    
    public Connection getCon() {
        return con;
    }
    
    public Connection getDt() {
        return getData();
    }

    public Coneccion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:8000/process_s.a", "root", "root");
            if (null == con) {
                throw new Exception("Conexion fallida");
            }
            System.out.println("conexion exitosa");
        } catch (Exception e) {
            System.out.println("Error de conexion : " + e.getMessage());
        }
    }
    
    public Connection getData() {
        try {
            dt = InitialContext.doLookup("java:/MySqlDS");
            if(null == dt) {
                throw new Exception("Conexion fallida");
            }
            return dt.getConnection();
        } catch (Exception e) {
            System.out.println("Error de conexion : " + e.getMessage());
        }
        return null;
    }
    
    
}

