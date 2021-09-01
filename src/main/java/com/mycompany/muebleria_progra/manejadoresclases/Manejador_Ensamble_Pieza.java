
package com.mycompany.muebleria_progra.manejadoresclases;

import com.mycompany.muebleria_progra.clases.Ensamble_Pieza;
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
public class Manejador_Ensamble_Pieza {
    private final String INGRESO="INSERT INTO ensamble_pieza (cantidad, nombre_mueble,tipo_pieza,pieza_costo) VALUES(?,?,?,?);";
    private final String SELECT="SELECT * FROM ensamble_pieza WHERE nombre_mueble = ? AND tipo_pieza = ?";
    private final String SELECT_ALL="SELECT * FROM ensamble_pieza";
    private final String DELETE="DELETE FROM ensamble_pieza WHERE nombre_mueble=? AND tipo_pieza=?";
    private final String UPDATE="UPDATE ensamble_pieza SET cantidad=? WHERE nombre_mueble=? AND tipo_pieza=? AND pieza_costo=?";
    private final String SELECT_ESPECIAL="SELECT cantidad,nombre_mueble,tipo_pieza,pieza_costo FROM ensamble_pieza WHERE nombre_mueble=?";
    private Connection conexion;

    public Manejador_Ensamble_Pieza() {
       Conexion_Sql co= new Conexion_Sql();
        
    }
    
    public int añadir(Ensamble_Pieza pieza)throws SQLException{
        try {
            PreparedStatement query= Conexion_Sql.conexion.prepareStatement(INGRESO);
            query.setInt(1, pieza.getCantidad());
            query.setString(2,pieza.getNombre_mueble());
            query.setString(3, pieza.getTipo_pieza());
            query.setBigDecimal(4, pieza.getPieza_costo());
            query.executeUpdate();
        } catch(java.sql.SQLIntegrityConstraintViolationException p){
            System.out.println(p);
            //System.out.println("REVISA LA EXISTENCIA DEL NOMBRE DEL MUEBLE, EL TIPO DE PIEZA, Y EL COSTO DE PIEZA");
        } 
        catch (SQLException ex) {
             System.out.println(ex);
        }
         Conexion_Sql con = new Conexion_Sql(1);
        return 0;
    }
    
    public ResultSet select(String nombre_mueble, String tip_pieza){
        ResultSet datosObtenidos=null;
        PreparedStatement query;
        try {
            query = Conexion_Sql.conexion.prepareStatement(SELECT);
            query.setString(1, nombre_mueble);
            query.setString(2, tip_pieza);
            datosObtenidos=query.executeQuery();
            
        } catch (SQLException ex) {
             System.out.println(ex);
        }
         Conexion_Sql con = new Conexion_Sql(1);
       return datosObtenidos;
    }
    
    public ResultSet select_especial(String nombre_mueble){
        ResultSet datosObtenidos=null;
        PreparedStatement query;
        try {
            query = Conexion_Sql.conexion.prepareStatement(SELECT_ESPECIAL);
            query.setString(1, nombre_mueble);
            datosObtenidos=query.executeQuery();
            
        } catch (SQLException ex) {
             System.out.println(ex);
        }
         Conexion_Sql con = new Conexion_Sql(1);
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
         Conexion_Sql con = new Conexion_Sql(1);
       return datosObtenidos;
    }
    
    public void delete(String nombre_mueble, String tip_pieza){
        try {
            PreparedStatement query = Conexion_Sql.conexion.prepareStatement(DELETE);
            query.setString(1, nombre_mueble);
            query.setString(2, tip_pieza);
            query.executeUpdate();
        } catch (SQLException ex) {
             System.out.println(ex);
        }
         Conexion_Sql con = new Conexion_Sql(1);
        
    }
    
     public int update(Ensamble_Pieza pieza){
        try {
            PreparedStatement query= Conexion_Sql.conexion.prepareStatement(UPDATE);
            query.setInt(1, pieza.getCantidad());
            query.setString(2,pieza.getNombre_mueble());
            query.setString(3, pieza.getTipo_pieza());
            query.setBigDecimal(4, pieza.getPieza_costo());
            query.executeUpdate();
        } catch(java.sql.SQLIntegrityConstraintViolationException p){
            System.out.println(p);
            //System.out.println("REVISA LA EXISTENCIA DEL NOMBRE DEL MUEBLE, EL TIPO DE PIEZA, Y EL COSTO DE PIEZA");
        } 
        catch (SQLException ex) {
             System.out.println(ex);
        }
         Conexion_Sql con = new Conexion_Sql(1);
        return 0;
    }
    
}
