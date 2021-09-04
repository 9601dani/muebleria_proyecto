package com.mycompany.muebleria_progra.manejadoresclases;
import com.mycompany.muebleria_progra.clases.Usuario;
import com.mycompany.muebleria_progra.conexion.Conexion_Sql;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel
 */
public class Manejador_Usuario{
    private final String AÑADIR="INSERT INTO usuario (nombre_usuario, contra, tipo_usuario) VALUES (?,?,?);";
    private final String SELECT="SELECT * FROM usuario WHERE nombre_usuario=?"; 
    private final String SELECT_ALL="SELECT * FROM usuario"; 
    private final String DELETE="DELETE FROM usuario WHERE nombre_usuario=?";
    private final String UPDATE="UPDATE usuario SET tipo_usuario=? WHERE nombre_usuario=?";
    private final String SELECT_TIPO="SELECT nombre FROM tipo_usuario WHERE id_tipo_usuario=?";
    Connection conexion;
    String senha;

    

    public Manejador_Usuario() {
        Conexion_Sql con = new Conexion_Sql();
       // conexion= Conexion_Sql.getConnection();
        
    }
    public int añadir(Usuario usuario) throws SQLException{
            PreparedStatement query= Conexion_Sql.conexion.prepareStatement(AÑADIR);
            query.setString(1, usuario.getNombre_usuario());
            query.setString(2, usuario.getPasssword());
            query.setInt(3, usuario.getTipo_usuario());
            query.executeUpdate();

       Conexion_Sql con = new Conexion_Sql(1);
        return 0;
        
    }
    
     public ResultSet select(String nombre_usuario) {
        ResultSet datosObtenidos = null;
        PreparedStatement query = null;
        try {
            query = Conexion_Sql.conexion.prepareStatement(SELECT);
            query.setString(1, nombre_usuario);
            System.out.println("aqui ando");
            datosObtenidos = query.executeQuery();
            if (datosObtenidos != null && datosObtenidos.next()) {
                this.senha = datosObtenidos.getString("contra");
            } else {
                System.out.println("F");
            }
        } catch (SQLException ex) {
            System.out.println("sql");
        }
        Conexion_Sql con = new Conexion_Sql(1);
        return datosObtenidos;

    }
     public ResultSet select_tipo(int id) {
        ResultSet datosObtenidos = null;
        PreparedStatement query = null;
        try {
            query = Conexion_Sql.conexion.prepareStatement(SELECT_TIPO);
            query.setInt(1, id);
            datosObtenidos = query.executeQuery();
        } catch (SQLException ex) {
            System.out.println("sql");
        }
        Conexion_Sql con = new Conexion_Sql(1);
        return datosObtenidos;

    }
     
     public ResultSet select_all(){
        ResultSet datosObtenidos=null;
        PreparedStatement query=null;
        try {
            query =Conexion_Sql.conexion.prepareStatement(SELECT_ALL);
            datosObtenidos=query.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        Conexion_Sql con = new Conexion_Sql(1);
       return datosObtenidos;
    }
    
     public void delete(String nom_usuario){
        PreparedStatement query=null;
         try {
            query =Conexion_Sql.conexion.prepareStatement(DELETE);
            query.setString(1, nom_usuario);
            query.executeUpdate();
        } catch (SQLException ex) {
             System.out.println(ex);
        }
    }
     
    public int update(Usuario usuario){
        PreparedStatement query=null;
       try {
            query= Conexion_Sql.conexion.prepareStatement(UPDATE);
            query.setString(2, usuario.getNombre_usuario());
            query.setInt(1, usuario.getTipo_usuario());
            query.executeUpdate();
        } 
        catch (SQLException ex) {
            System.out.println(ex);
        }
        return 0;
        
    }
    
}
