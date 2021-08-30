package com.mycompany.muebleria_progra.manejadoresclases;

import com.mycompany.muebleria_progra.clases.Mueble;
import com.mycompany.muebleria_progra.conexion.Conexion_Sql;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel
 */
public class Manejador_Mueble {
    private final String AÑADIR_MUEBLE="INSERT INTO mueble(nombre_mueble, precio) VALUES (?,?);";
    private final String SELECT="SELECT * FROM mueble WHERE nombre_mueble=?";
    private final String SELECT_ALL="SELECT * FROM mueble";
    private final String DELETE="DELETE FROM mueble WHERE nombre_mueble=?";
    private final String UPDATE ="UPDATE mueble SET precio=? WHERE nombre_mueble=?";
    private Connection conexion;
    
    public Manejador_Mueble() {
      Conexion_Sql co= new Conexion_Sql();
    }
    
    public int añadir(Mueble mueble){
         try {
            PreparedStatement query= Conexion_Sql.conexion.prepareStatement(AÑADIR_MUEBLE);
            query.setString(1, mueble.getNombre_mueble());
            query.setBigDecimal(2, mueble.getPrecio());
            query.executeUpdate();
        } 
        catch (SQLException ex) {
            System.out.println(ex);
        }
         Conexion_Sql co= new Conexion_Sql(1);
        return 0;
    }
    
    public ResultSet select(String nombre_mueble){
        ResultSet datosObtenidos=null;
        
        PreparedStatement query;
        try {
            query = Conexion_Sql.conexion.prepareStatement(SELECT);
            query.setString(1, nombre_mueble);
            datosObtenidos=query.executeQuery();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        Conexion_Sql co= new Conexion_Sql(1);
       return datosObtenidos;
    }
    
    public ResultSet select_all(){
        ResultSet datosObtenidos=null;
        
        PreparedStatement query;
        try {
            query = Conexion_Sql.conexion.prepareStatement(SELECT_ALL);
            datosObtenidos=query.executeQuery();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
       Conexion_Sql co= new Conexion_Sql(1);
       return datosObtenidos;
    }
    
   public void delete(String nombre_mueble){
        try {
            PreparedStatement query = Conexion_Sql.conexion.prepareStatement(DELETE);
            query.setString(1, nombre_mueble);
            query.executeUpdate();
        } catch (SQLException ex) {
             System.out.println(ex);
        }
        Conexion_Sql co= new Conexion_Sql(1);
    }
   
   public int update(Mueble mueble){
         try {
            PreparedStatement query= Conexion_Sql.conexion.prepareStatement(UPDATE);
            query.setString(2, mueble.getNombre_mueble());
            query.setBigDecimal(1, mueble.getPrecio());
            query.executeUpdate();
        } 
        catch (SQLException ex) {
            System.out.println(ex);
        }
         Conexion_Sql co= new Conexion_Sql(1);
        return 0;
    }
    
}
