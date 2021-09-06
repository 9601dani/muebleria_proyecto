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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daniel
 */
public class ReporteGeneral extends HttpServlet {


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
        String eleccion = request.getParameter("eleccion");
        Conexion_Sql co = new Conexion_Sql();
        Statement smy;
        ResultSet rs;
        if(eleccion.equalsIgnoreCase("cliente")){
            try {
                String datosObte="ESTE ES EL REPORTE DE TODOS LOS CLIENTES REGISTRADOS\n\n";
                smy = Conexion_Sql.getConnection().createStatement();
                rs = smy.executeQuery("SELECT * FROM cliente");
                datosObte += "NIT, NOMBRE, DIRECCION, MUNICIPIO, DEPARTAMENTO\n";
                while (rs.next()) {
                    if(rs.getString("municipio")==null && rs.getString("departamento")==null){
                       datosObte += (rs.getString("nit")+","+rs.getString("nombre")+","+rs.getString("direccion")+","+" "+","+" "+"\n");
                 
                    }else{
                         datosObte += (rs.getString("nit")+","+rs.getString("nombre")+","+rs.getString("direccion")+","+rs.getString("municipio")+","+rs.getString("departamento")+"\n");
                    }
                   
                }
                Conexion_Sql con = new Conexion_Sql(1);
                this.reporte(response, datosObte,"Clientes");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
        }else if(eleccion.equalsIgnoreCase("usuario")){
            try {
                String datosObte="ESTE ES EL REPORTE DE TODOS LOS USUARIOS\n\n";
                smy = Conexion_Sql.getConnection().createStatement();
                rs = smy.executeQuery("SELECT usuario.nombre_usuario, tipo_usuario.nombre FROM usuario INNER JOIN tipo_usuario WHERE usuario.tipo_usuario=tipo_usuario.id_tipo_usuario");
                datosObte += "NOMBRE DE USUARIO, AREA ASIGNADA\n";
                while (rs.next()) {
                       datosObte += (rs.getString("nombre_usuario")+","+rs.getString("nombre")+"\n");

                }
                Conexion_Sql con = new Conexion_Sql(1);
                this.reporte(response, datosObte,"Usuarios");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }else if(eleccion.equalsIgnoreCase("piezas")){
            try {
                String datosObte="ESTE ES EL REPORTE DE TODAS LAS PIEZAS EN BODEGA\n\n";
                smy = Conexion_Sql.getConnection().createStatement();
                rs = smy.executeQuery("SELECT * FROM pieza");
                datosObte += "TIPO DE PIEZA, COSTO, CANTIDAD\n";
                while (rs.next()) {
                       datosObte += (rs.getString("tipo_pieza")+","+rs.getInt("cantidad")+","+rs.getBigDecimal("costo")+"\n");

                }
                Conexion_Sql con = new Conexion_Sql(1);
                this.reporte(response, datosObte,"Piezas");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }else if(eleccion.equalsIgnoreCase("mueble")){
            try {
                String datosObte="ESTE ES EL REPORTE DE TODOS LOS MUEBLES QUE SE PUEDEN FABRICAR EN BODEGA\n\n";
                smy = Conexion_Sql.getConnection().createStatement();
                rs = smy.executeQuery("SELECT * FROM mueble");
                datosObte += "NOMBRE, COSTO DE VENTA\n";
                while (rs.next()) {
                       datosObte += (rs.getString("nombre_mueble")+","+rs.getBigDecimal("precio")+"\n");

                }
                Conexion_Sql con = new Conexion_Sql(1);
                this.reporte(response, datosObte,"Muebles");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
     public void reporte(HttpServletResponse response, String reporte, String name){
        response.setContentType("text/csv;charset=UTF-8");
        response.setHeader("Content-Disposition","attatchment; filename=ReporteGeneralDe"+name+".csv");
        
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
