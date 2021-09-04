
package com.mycompany.muebleria_progra.manejadoresclases;

import com.mycompany.muebleria_progra.clases.Factura;
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
public class Manejador_Factura {
    private final String INGRESO_FACTURA="INSERT INTO factura(fecha_compra,cliente_nit,id_mueble_ensamblado,usuario_venta) VALUES(?,?,?,?);";
    private final String SELECT="SELECT * FROM factura WHERE id_factura=?";
    private final String SELECT_ALL="SELECT * FROM factura";
    private final String DELETE="DELETE FROM factura WHERE id_factura=?";
    private Connection conexion;

    public Manejador_Factura() {
        Conexion_Sql co = new Conexion_Sql();
    }
    
    public int añadir(Factura fac){
         try {
            PreparedStatement query= Conexion_Sql.conexion.prepareStatement(INGRESO_FACTURA);
            query.setDate(1, (Date)fac.getFecha_compra());
            query.setString(2,fac.getNit());
            query.setString(3, fac.getId_mueble());
            query.setString(4, fac.getNom_usu());
            query.executeUpdate();
        } catch(java.sql.SQLIntegrityConstraintViolationException p){
            System.out.println("REVISA EL NIT DEL CLIENTE Y EL ID DEL MUEBLE");
        } 
        catch (SQLException ex) {
            System.out.println(ex);
        }
         Conexion_Sql con = new Conexion_Sql(1);
        return 0;
    }
    
    public ResultSet select(int id_factura){
        ResultSet datosObtenidos=null;
        PreparedStatement query=null;
        try {
            query = Conexion_Sql.conexion.prepareStatement(SELECT);
            query.setInt(1, id_factura);
            datosObtenidos=query.executeQuery();
            
            if(datosObtenidos.next() && datosObtenidos!=null){
                datosObtenidos.getInt("id_factura");
            }else{
                System.out.println("vacio jeje");
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
            if(datosObtenidos.next() && datosObtenidos!=null){
                datosObtenidos.getString("nombre_estado");
            }else{
                System.out.println("vacio jeje");
            }
        } catch (SQLException ex) {
             System.out.println(ex);
        }
         Conexion_Sql con = new Conexion_Sql(1);
       return datosObtenidos;
    }
    
    public void delete(int id_factura){
        try {
            PreparedStatement query =Conexion_Sql. conexion.prepareStatement(DELETE);
            query.setInt(1, id_factura);
            query.executeUpdate();
        } catch (SQLException ex) {
             System.out.println(ex);
        }
         Conexion_Sql con = new Conexion_Sql(1);
    }
    
}
