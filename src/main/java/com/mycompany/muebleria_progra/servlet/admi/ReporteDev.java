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
public class ReporteDev extends HttpServlet {


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
        String datosObte = "REPORTE DE LAS DEVOLUCIONES ENTRE "+f1+" / "+f2 +" \n\n\n";
        if (f1 != "" && f2 != "") {
            Conexion_Sql co = new Conexion_Sql();
            Statement smy;
            ResultSet rs;
            try {
                smy = Conexion_Sql.getConnection().createStatement();
                rs = smy.executeQuery("SELECT d.id_devolucion,d.fecha_devolucion, d.costo_perdida,f.id_factura, f.fecha_compra, m.id_mueble_ensamblado, m.nombre_mueble, f.cliente_nit, c.nombre FROM devolucion as d INNER JOIN factura as f INNER JOIN mueble_ensamblado as m INNER JOIN cliente as c WHERE f.fecha_compra BETWEEN" + "'" + f1 + "'" + " AND " + "'" + f2 + "'" + "AND m.id_mueble_ensamblado=f.id_mueble_ensamblado AND d.id_factura=f.id_factura AND f.cliente_nit=c.nit");
                datosObte += "Codigo Devolucion, Fecha Devolucion, Costo de Perdida, Codigo de Factura, Fecha Compra, Codigo Mueble, Nombre Mueble, Nit, Nombre\n";
                while (rs.next()) {
                    datosObte += (rs.getInt("id_devolucion") + "," + rs.getDate("fecha_devolucion") + "," + rs.getBigDecimal("costo_perdida") + "," + rs.getInt("id_factura") + "," + rs.getDate("fecha_compra") + "," + rs.getString("id_mueble_ensamblado") + "," + rs.getString("nombre_mueble") + "," + rs.getString("cliente_nit") + "," + rs.getString("nombre")+"\n");
                }
                Conexion_Sql con = new Conexion_Sql(1);
                this.reporte(response, datosObte,f1,f2);
            } catch (SQLException ex) {
                System.out.println(ex);
            }
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
        response.setHeader("Content-Disposition","attatchment; filename=ReporteDevoluciones"+"("+f1+" / "+f2+")"+".csv");
        
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
