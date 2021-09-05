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
public class ReporteMuebleMas extends HttpServlet {


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

        Conexion_Sql co = new Conexion_Sql();
        Statement smy;
        ResultSet rs;
        try {
            smy = Conexion_Sql.getConnection().createStatement();
            rs = smy.executeQuery("SELECT me.nombre_mueble, COUNT(me.nombre_mueble) AS Cantidad FROM factura as f INNER JOIN mueble_ensamblado as me WHERE me.id_estado_mueble='2'  AND me.id_mueble_ensamblado= f.id_mueble_ensamblado AND f.fecha_compra BETWEEN" + "'" + f1 + "'" + " AND " + "'" + f2 + "'" + " GROUP BY me.nombre_mueble ORDER BY Cantidad DESC LIMIT 1");
            String nom = "";
            String datosObte = "REPORTE DEL MUEBLE MENOS VENDIDO ENTRE "+f1+" / "+f2+"\n\n\n";
            String cant="";

            datosObte += ("Nombre Mueble, Cantidad\n");
            while (rs.next()) {
                datosObte += (rs.getString("nombre_mueble") + "," + rs.getInt("cantidad") + "\n");
                 cant=rs.getString("cantidad");
            }
            Conexion_Sql con = new Conexion_Sql(1);
            Conexion_Sql cm = new Conexion_Sql();
            Statement sm;
            ResultSet r;
            sm = Conexion_Sql.getConnection().createStatement();
            r = sm.executeQuery("SELECT f.fecha_compra, me.id_mueble_ensamblado, me.nombre_mueble, m.precio FROM factura as f INNER JOIN mueble_ensamblado as me INNER JOIN mueble as m WHERE me.id_estado_mueble='2'  AND me.id_mueble_ensamblado= f.id_mueble_ensamblado AND f.fecha_compra BETWEEN" + "'" + f1 + "'" + " AND " + "'" + f2 + "'");
            datosObte += ("Fecha Compra, Codigo Mueble, Nombre, Precio\n");
            
            int contador = 1;
            while (r.next() && contador <= Integer.parseInt(cant)) {
                contador++;
                datosObte += (r.getDate("fecha_compra") + "," + r.getString("id_mueble_ensamblado") + "," + r.getString("nombre_mueble") + "," + r.getBigDecimal("precio") + "\n");
            }
            Conexion_Sql ca= new Conexion_Sql(1);
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
        response.setHeader("Content-Disposition","attatchment; filename=ReporteMuebleMasVendido"+"("+f1+" / "+f2+")"+".csv");
        
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
