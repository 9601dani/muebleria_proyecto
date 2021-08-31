/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.muebleria_progra.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daniel
 */
@WebServlet(name = "InicioServlet", urlPatterns = {"/InicioServlet"})
public class InicioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String ur="Inicio/inicio_sesion.jsp";
            //ADMINISTRACION
            String nu="Administracion/creacion_usuario.jsp";
            String mu="Administracion/mod_usuario.jsp";
            //VENTAS
            String regresoV="Venta/iventa.jsp";
            String nv="Venta/realizarventa.jsp";
            String nc="Venta/ventasincliente.jsp";
            String rv="Venta/ventacliente.jsp";
            String prueba="Venta/pruebabuscador.jsp";
            String pruebaF="Venta/buscadorfinal.jsp";
            //ELECCION
            String eleccion= request.getParameter("eleccion");
            String destino="";
            if(eleccion.equalsIgnoreCase("inicio")){
                destino=ur;
            }else if(eleccion.equals("nusuario")){
                destino=nu;
            }else if(eleccion.equals("musuario")){
                destino+=mu;
            }else if(eleccion.equals("nventa")){
                destino+=nv;
            }else if(eleccion.equals("ncliente")){
                destino+=nc;
            }else if(eleccion.equals("rventa")){
                destino+=rv;
            }else if(eleccion.equals("rcliente")){
                
            }else if(eleccion.equals("prueba")){
                destino+=prueba;
            }else if(eleccion.equals("regresoV")){
                destino+=regresoV;
            }else if(eleccion.equals("buscadorfinal")){
                destino+=pruebaF;
            }
            
            RequestDispatcher salida= request.getRequestDispatcher(destino);
            salida.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
