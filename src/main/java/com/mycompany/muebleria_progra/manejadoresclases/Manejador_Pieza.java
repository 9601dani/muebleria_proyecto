
package com.mycompany.muebleria_progra.manejadoresclases;

import com.mycompany.muebleria_progra.clases.Pieza;
import com.mycompany.muebleria_progra.conexion.Conexion_Sql;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel
 */
public class Manejador_Pieza {
    private final String AÑADIR_PIEZA="INSERT INTO pieza (tipo_pieza, costo, cantidad)VALUES (?,?,?);";
    private final String SELECT="SELECT * FROM pieza WHERE tipo_pieza=? AND costo=?";
    private final String SELECT_ALL="SELECT * FROM pieza";
    private final String DELETE="DELETE FROM pieza WHERE tipo_pieza=? AND costo=?";
    private final String UPDATEE="UPDATE pieza SET cantidad=?, costo=? WHERE tipo_pieza=? AND costo=?";
    private final String UPDATE="UPDATE pieza SET cantidad=? WHERE tipo_pieza=? AND costo=?";
    private final String SELECT_ESPECIAL="SELECT * FROM pieza WHERE tipo_pieza=?";
    private Connection conexion;

    public Manejador_Pieza() {
       Conexion_Sql co = new Conexion_Sql();
    }
    
    public int añadir(Pieza pieza)throws SQLException{

            PreparedStatement query= Conexion_Sql.conexion.prepareStatement(AÑADIR_PIEZA);
            query.setString(1, pieza.getTipo_pieza());
            query.setBigDecimal(2, pieza.getCosto());
            query.setInt(3, pieza.getCantidad());
            query.executeUpdate();

        Conexion_Sql co = new Conexion_Sql(1);
        return 0;
    }
    
     public ResultSet select_especial(String tipo_pieza){
        ResultSet datosObtenidos=null;
        
        PreparedStatement query=null;
        try {
            query = Conexion_Sql.conexion.prepareStatement(SELECT_ESPECIAL);
            query.setString(1, tipo_pieza);
            datosObtenidos=query.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("aqui quede bien");
        }

       return datosObtenidos;
    }
    
    public ResultSet select(String tipo_pieza,BigDecimal num){
        ResultSet datosObtenidos=null;
        
        PreparedStatement query;
        try {
            query = Conexion_Sql.conexion.prepareStatement(SELECT);
            query.setString(1, tipo_pieza);
            query.setBigDecimal(2, num);
            datosObtenidos=query.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        Conexion_Sql co = new Conexion_Sql(1);
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
        Conexion_Sql co = new Conexion_Sql(1);
       return datosObtenidos;
    }
    
     public void delete(String tipo_pieza,BigDecimal num) throws SQLException{

            PreparedStatement query= Conexion_Sql.conexion.prepareStatement(DELETE);
            query.setString(1, tipo_pieza);
            query.setBigDecimal(2, num);
            query.executeUpdate();

        Conexion_Sql co = new Conexion_Sql(1);
    }
     
    public int update(String tipo,BigDecimal coston, BigDecimal costoa,int cantidad){
        try {
            PreparedStatement query= Conexion_Sql.conexion.prepareStatement(UPDATEE);
            query.setBigDecimal(2, coston);
            query.setString(3, tipo);
            query.setBigDecimal(4, costoa);
            query.setInt(1,cantidad);
            query.executeUpdate();
        } 
        catch (SQLException ex) {
            System.out.println(ex);
        }
        Conexion_Sql co = new Conexion_Sql(1);
        return 0;
    }
        public int update(Pieza pieza){
        try {
            PreparedStatement query= Conexion_Sql.conexion.prepareStatement(UPDATE);
            query.setString(2, pieza.getTipo_pieza());
            query.setBigDecimal(3, pieza.getCosto());
            query.setInt(1,pieza.getCantidad());
            query.executeUpdate();
        } 
        catch (SQLException ex) {
            System.out.println(ex);
        }
        Conexion_Sql co = new Conexion_Sql(1);
        return 0;
    }
     
}
