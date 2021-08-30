package com.mycompany.muebleria_progra.servlet;

import com.mycompany.muebleria_progra.conexion.Conexion_Sql;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daniel
 */
public class CerrarSesion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String ur="Inicio/inicio_sesion.jsp";
            String regreso="Administracion/iadministracion.jsp";
            
            String regresoV="Venta/iventa.jsp";
            String eleccion= request.getParameter("eleccion");
            String destino="";
            if(eleccion.equalsIgnoreCase("inicio")){
                destino+=ur;
                Conexion_Sql co= new Conexion_Sql(1);
            }else if(eleccion.equals("regresar")){
                Conexion_Sql co= new Conexion_Sql(1);
                destino+=regreso;
            }else if(eleccion.equals("regresarV")){
                Conexion_Sql co= new Conexion_Sql(1);
                destino+=regresoV;
            }
            RequestDispatcher salida= request.getRequestDispatcher(destino);
            salida.forward(request, response);
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
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
