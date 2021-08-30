package com.mycompany.muebleria_progra.manejadoresclases;

import com.mycompany.muebleria_progra.clases.Cliente;
import com.mycompany.muebleria_progra.conexion.Conexion_Sql;
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
public class Manejador_Cliente {
    private final String AÑADIR_CLIENTE="INSERT INTO cliente (nit, nombre, direccion) VALUES (?,?,?);"; 
    private final String AÑADIR_CLIENTE_EXTENSO="INSERT INTO cliente (nit, nombre, direccion, municipio, departamento) VALUES (?,?,?,?,?);";
    private final String SELECT="SELECT * FROM cliente WHERE nit=?";
    private final String SELECT_ALL="SELECT * FROM cliente";
    private final String DELETE="DELETE FROM cliente WHERE nit=?";
    private final String UPDATE="UPDATE cliente SET nombre=?, direccion=?, municipio=?,departamento=? WHERE nit=?";
    private Connection conexion;
    
    
    public Manejador_Cliente() {
        Conexion_Sql con = new Conexion_Sql();
    }
    
    
    public int añadir(Cliente cliente){
        try {
            PreparedStatement query= Conexion_Sql.conexion.prepareStatement(AÑADIR_CLIENTE);
            query.setString(1, cliente.getNit());
            query.setString(2, cliente.getNombre());
            query.setString(3, cliente.getDireccion());
            query.executeUpdate();
        } catch (SQLException ex) {
             System.out.println(ex);
            return 1;
        }
        Conexion_Sql con = new Conexion_Sql(1);
        return 0;
    }
    public int añadir_extenso(Cliente cliente){
        try {
            PreparedStatement query= Conexion_Sql.conexion.prepareStatement(AÑADIR_CLIENTE_EXTENSO);
            query.setString(1, cliente.getNit());
            query.setString(2, cliente.getNombre());
            query.setString(3, cliente.getDireccion());
            query.setString(4, cliente.getMunicipio());
            query.setString(5, cliente.getDepartamento());
            query.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
            return 1;
        }
        Conexion_Sql con = new Conexion_Sql(1);
        return 0;
    }
    
    public ResultSet select(String nit){
        ResultSet datosObtenidos=null;
        
        PreparedStatement query=null;
        try {
            query = Conexion_Sql.conexion.prepareStatement(SELECT);
            query.setString(1, nit);
            datosObtenidos=query.executeQuery();
            if (datosObtenidos != null && datosObtenidos.next()) {
                System.out.println(datosObtenidos.getString("nit"));
            } else {
                System.out.println("F");
            }
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
    
    public void delete(String nit){
        try {
            PreparedStatement query = Conexion_Sql.conexion.prepareStatement(DELETE);
            query.setString(1, nit);
            query.executeUpdate();
        } catch (SQLException ex) {
             System.out.println(ex);
        }
        Conexion_Sql con = new Conexion_Sql(1);
    }
    
    public int update(Cliente cliente){
        try {
            PreparedStatement query= Conexion_Sql.conexion.prepareStatement(UPDATE);
            query.setString(5, cliente.getNit());
            query.setString(1, cliente.getNombre());
            query.setString(2, cliente.getDireccion());
            query.setString(3, cliente.getMunicipio());
            query.setString(4, cliente.getDepartamento());
            query.executeUpdate();
        } catch (SQLException ex) {
             System.out.println(ex);
            return 1;
        }
        Conexion_Sql con = new Conexion_Sql(1);
        return 0;
    }
}
