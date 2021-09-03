/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.muebleria_progra.servlet.admi;

import com.mycompany.muebleria_progra.manejadoresclases.Manejador_Carga_Datos;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author daniel
 */
 @MultipartConfig(location="/tmp")
public class CargaDatos extends HttpServlet {


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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            Part filePart= request.getPart("myfile");// OBTENEMOS OBJETO
            String filename=filePart.getName();
            System.out.println(filename);
            
            InputStream fileSteam = filePart.getInputStream();
            
            Manejador_Carga_Datos mc= new Manejador_Carga_Datos(fileSteam, "Archivo");
            List<String> errores= mc.leerNuevosArchivos();
            request.setAttribute("errores", errores);
            request.getRequestDispatcher("/Inicio/errorescarga.jsp").forward(request, response);

    }
    public void crearArch(HttpServletRequest request, HttpServletResponse response){
        
        
        
        /*String path = request.getParameter("myfile");
        System.out.println(path);
        File nfile= new File(path);
        System.out.println(nfile.getPath()+"---------");
        System.out.println(nfile.getAbsolutePath());
        
        Manejador_Carga_Datos nm= new Manejador_Carga_Datos(nfile,path);
        try{
            List<String> errores= nm.leerNuevosArchivos();
            request.setAttribute("errores", errores);
            request.getRequestDispatcher("/Inicio/errorescarga.jsp").forward(request, response);
        }catch(IOException p){
            
        } catch (ServletException ex) {
            System.out.println(ex);
        }*/
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
