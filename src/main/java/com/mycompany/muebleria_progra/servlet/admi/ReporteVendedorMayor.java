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
public class ReporteVendedorMayor extends HttpServlet {


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
        String nom=request.getParameter("datos");
        String f1= request.getParameter("f1");
        String f2= request.getParameter("f2");
        System.out.println(nom);        
        System.out.println(f1);
        System.out.println(f2);
        String datosObte="REPORTE DEL MEJOR VENDEDOR ENTRE "+f1+" / "+f2+"\n\n\n";
        
        Conexion_Sql co = new Conexion_Sql();
        Statement smy;
        ResultSet rs;
        try {
            smy = Conexion_Sql.getConnection().createStatement();
            rs=smy.executeQuery("SELECT usuario_venta, COUNT(usuario_venta) AS Cantidad FROM factura WHERE fecha_compra BETWEEN"+ "'"+f1+"'" +" AND " +"'" +f2+"'"+"GROUP BY usuario_venta ORDER BY Cantidad DESC LIMIT 1"); 
            datosObte+= "Usuario , Cantidad\n";
            
            while(rs.next()){
                datosObte+= ""+rs.getString("usuario_venta")+","+rs.getInt("cantidad")+"\n";
            }

            Conexion_Sql po = new Conexion_Sql();
            Statement sm;
            ResultSet r;
            sm = Conexion_Sql.getConnection().createStatement();
            r = smy.executeQuery("SELECT f.fecha_compra, f.id_mueble_ensamblado, me.nombre_mueble, m.precio FROM factura as f INNER JOIN mueble_ensamblado as me INNER JOIN mueble as m WHERE fecha_compra BETWEEN"+ "'"+f1+"'" +" AND " +"'" +f2+"'"+" AND usuario_venta=" + "'" + nom + "'" + " AND f.id_mueble_ensamblado= me.id_mueble_ensamblado AND me.nombre_mueble=m.nombre_mueble");

            datosObte+= "Fecha Compra, Codigo Mueble, Nombre, Precio\n" ;
            
            while(r.next()){
             datosObte+= r.getDate("fecha_compra")+","+r.getString("id_mueble_ensamblado")+","+r.getString("nombre_mueble")+","+r.getBigDecimal("precio")+"\n";
            }
            Conexion_Sql cm= new Conexion_Sql(1);
            System.out.println("LLEGUE AQUIIIII \n"+ datosObte);
            if(nom==null){
                
            }else{
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
    
    public void reporte(HttpServletResponse response, String reporte, String f1, String f2){
        response.setContentType("text/csv;charset=UTF-8");
        response.setHeader("Content-Disposition","attatchment; filename=ReporteMejorVendedor("+f1+"-"+f2+").csv");
        
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
