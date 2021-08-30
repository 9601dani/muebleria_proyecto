/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.muebleria_progra.manejadoresclases;

import com.mycompany.muebleria_progra.clases.Devolucion;
import com.mycompany.muebleria_progra.conexion.Conexion_Sql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author daniel
 */
public class Manejador_Devolucion {
    private final String AÑADIR="INSERT INTO devolucion (costo_perdida, fecha_devolucion, id_factura) VALUES (?,?,?)";
    private final String SELECT="SELECT * FROM devolucion WHERE id_devolucion=?";
    private final String SELECT_ALL="SELECT * FROM devolucion";
    private final String DELETE="DELETE FROM devolucion WHERE id_devolucion=?";
    private final String UPDATE="UPDATE devolucion SET costo_perdida=?, fecha_devolucion=?, id_factura=? WHERE id_devolucion=? ";
    private Connection conexion;

    public Manejador_Devolucion() {
       Conexion_Sql con = new Conexion_Sql();
    }
    
    
    public int añadir(Devolucion devolucion){
        try {
            PreparedStatement query= Conexion_Sql.conexion.prepareStatement(AÑADIR);
            query.setBigDecimal(1, devolucion.getCosto_perdida());
            query.setDate(2,(Date)devolucion.getFecha_devolucion());
            query.setInt(3, devolucion.getId_factura());
            query.executeUpdate();
        } catch(java.sql.SQLIntegrityConstraintViolationException p){
            System.out.println("NO EXISTE NUMERO DE FACTURA");
        } 
        catch (SQLException ex) {
             System.out.println(ex);
        }
        Conexion_Sql con = new Conexion_Sql(1);
        return 0;
    }
    public ResultSet select(int id_devolucion){
        ResultSet datosObtenidos=null;
        
        PreparedStatement query;
        try {
            query = Conexion_Sql.conexion.prepareStatement(SELECT);
            query.setInt(1,id_devolucion);
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
    
    public String delete(String id_devolucion){
        String ms="";
        try {
            PreparedStatement query = Conexion_Sql.conexion.prepareStatement(DELETE);
            query.setString(1, id_devolucion);
            query.executeUpdate();
            ms+="BORRADO EXITOSAMENTE: "+id_devolucion;
        } catch (SQLException ex) {
             ms+="NO SE AH PODIDO BORRAR: "+id_devolucion;
             System.out.println(ex);
        }
         Conexion_Sql con = new Conexion_Sql(1);
       return ms;
    }
    
    public int update(Devolucion devolucion){
        try {
            PreparedStatement query= Conexion_Sql.conexion.prepareStatement(UPDATE);
            query.setBigDecimal(1, devolucion.getCosto_perdida());
            query.setDate(2,(Date)devolucion.getFecha_devolucion());
            query.setInt(3, devolucion.getId_factura());
            query.setInt(4, devolucion.getId_devolucion());
            query.executeUpdate();
        } catch(java.sql.SQLIntegrityConstraintViolationException p){
            System.out.println(p);
        } 
        catch (SQLException ex) {
             System.out.println(ex);
        }
         Conexion_Sql con = new Conexion_Sql(1);
        return 0;
    }
}
