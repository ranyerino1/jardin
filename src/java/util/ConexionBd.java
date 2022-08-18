/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sena
 */
public class ConexionBd {
    private String driver, user, password, dataBase,urlBd;
    
   private Connection conexion;
   
   
   public ConexionBd(){
       driver="com.mysql.jdbc.Driver";
       user="root";
       password="";
       dataBase="jardin2";
       urlBd = "jdbc:mysql://localhost:3306/"+dataBase;
               
               try {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(urlBd, user, password);
            System.out.println("Conexion Exitosa");
        } catch (Exception e) {
            System.err.println("Error al conectarse "+e.toString());
        }
        
    }
    public Connection obtenerConexion(){
        return conexion;
    }
    public Connection deneterConexion() throws SQLException{
        conexion.close();
        conexion=null;
        return conexion;
    }
    public static void main(String[] args) {
        new ConexionBd();
        
    }
       
}

