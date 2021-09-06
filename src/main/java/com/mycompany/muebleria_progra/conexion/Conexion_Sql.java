package com.mycompany.muebleria_progra.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class Conexion_Sql {

   public static Connection conexion = null;
   
    public Conexion_Sql(){
        conectar();
    }
    public Conexion_Sql(int s){
        desconectar();
    }
    public int conectar() {
        try{
            
            if(conexion!=null){
                desconectar();
            }
            if (conexion != null) {
                JOptionPane.showMessageDialog(null, "La conexión previa con la base de datos sigue vigente");
                
            } 
               Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/muebleria_proyecto_final";// AL FINAL VA EL NOMBRE DE LA BASE DE DATOS
                String user = "admin";
                String password = "Admin.123";
                conexion = DriverManager.getConnection(url, user, password);
        }catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Conexion Fallida");
            return 2;
        } catch (ClassNotFoundException ex) {
           Logger.getLogger(Conexion_Sql.class.getName()).log(Level.SEVERE, null, ex);
       }
            
        return 0;
    }
    
    public int desconectar(){
        conexion = null;
        if (conexion!=null) {
            JOptionPane.showMessageDialog(null, "Error al desconectar de base de datos, sigue conectado");
            return 1;
        }
        return 0;
    }
    
    public static Connection getConnection(){//OBTENEMOS DATOS DEL PUENTE
        return conexion;
    }

}
