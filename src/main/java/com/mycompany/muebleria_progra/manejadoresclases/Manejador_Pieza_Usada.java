package com.mycompany.muebleria_progra.manejadoresclases;


import com.mycompany.muebleria_progra.clases.Pieza_Usada;
import com.mycompany.muebleria_progra.conexion.Conexion_Sql;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author daniel
 */
public class Manejador_Pieza_Usada {
    private final String AÑADIR_PIEZA_USADA="INSERT INTO pieza_usada(tipo_pieza, costo, cantidad, id_mueble_ensamblado) VALUES (?,?,?,?);";
    private final String SELECT="SELECT * FROM pieza_usada WHERE tipo_pieza=? AND costo=?";
    private final String SELECT_ALL="SELECT * FROM pieza_usada";
    private final String DELETE="DELETE FROM pieza_usada WHERE tipo_pieza=? AND costo=?";
    private Connection conexion;

    public Manejador_Pieza_Usada() {
        this.conexion= Conexion_Sql.getConnection();
    }
    
     public int añadir(Pieza_Usada pieza)throws SQLException{
         try {
            PreparedStatement query= conexion.prepareStatement(AÑADIR_PIEZA_USADA);
            query.setString(1, pieza.getTipo_pieza());
            query.setBigDecimal(2, pieza.getCosto());
            query.setInt(3, pieza.getCantidad());
            query.setString(4,pieza.getId_mueble_ensamblado());
            query.executeUpdate();
        } 
        catch (SQLException ex) {
            System.out.println(ex);
        }
        return 0;
    }
     
      public ResultSet select(String tipo_pieza,BigDecimal num){
        ResultSet datosObtenidos=null;
        
        PreparedStatement query;
        try {
            query = conexion.prepareStatement(SELECT);
            query.setString(1, tipo_pieza);
            query.setBigDecimal(2, num);
            datosObtenidos=query.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
       return datosObtenidos;
    }
      
      public ResultSet select_all(){
        ResultSet datosObtenidos=null;
        
        PreparedStatement query;
        try {
            query = conexion.prepareStatement(SELECT_ALL);
            datosObtenidos=query.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
       return datosObtenidos;
    }
      
      public void delete(String tipo_pieza,BigDecimal num){
        try {
            PreparedStatement query= conexion.prepareStatement(DELETE);
            query.setString(1, tipo_pieza);
            query.setBigDecimal(2, num);
            query.executeUpdate();
        } catch (SQLException ex) {
             System.out.println(ex);
        }
    }
    
    
}
