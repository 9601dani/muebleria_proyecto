/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.muebleria_progra.servlet.admi;

import com.mycompany.muebleria_progra.conexion.Conexion_Sql;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daniel
 */
public class ReporteVentas extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String f1 = request.getParameter("f1");
        String f2 = request.getParameter("f2");
        String datosObte="REPORTE DE VENTAS ENTRE "+f1+" / "+f2+"\n\n\n";
        Conexion_Sql co = new Conexion_Sql();
        Statement smy;
        ResultSet rs;
        try {
            smy = Conexion_Sql.getConnection().createStatement();
            if(f1!="" && f2!=""){
                rs=smy.executeQuery("SELECT f.fecha_compra, f.cliente_nit, c.nombre, c.direccion, f.id_mueble_ensamblado, me.nombre_mueble, m.precio, f.usuario_venta FROM factura as f INNER JOIN mueble_ensamblado as me INNER JOIN mueble as m INNER JOIN cliente as c WHERE f.fecha_compra BETWEEN"+"'"+f1+"'"+" AND "+"'"+f2+"'"+"AND f.cliente_nit=c.nit AND f.id_mueble_ensamblado=me.id_mueble_ensamblado AND me.nombre_mueble = m.nombre_mueble"); 
                datosObte+=("Fecha Compra, Nit, Nombre, Direccion, Codigo Mueble, Nombre Mueble, Precio, Vendedor\n");
                while(rs.next()){
                    datosObte+=(rs.getDate("fecha_compra")+","+rs.getString("cliente_nit")+","+rs.getString("nombre")+","+rs.getString("direccion")+","+rs.getString("id_mueble_ensamblado")+","+rs.getString("nombre_mueble")+","+rs.getBigDecimal("precio")+","+rs.getString("usuario_venta")+"\n");
                }
                Conexion_Sql con= new Conexion_Sql(1);
                this.reporte(response, datosObte,f1,f2);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    
     public void reporte(HttpServletResponse response, String reporte,String f1, String f2){
        response.setContentType("text/csv;charset=UTF-8");
        response.setHeader("Content-Disposition","attatchment; filename=ReporteVentas"+"("+f1+"-"+f2+")"+".csv");
        
        try(PrintWriter print= response.getWriter()){
            print.write(reporte);
        }catch(Exception e){
            System.out.println("error 3");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
