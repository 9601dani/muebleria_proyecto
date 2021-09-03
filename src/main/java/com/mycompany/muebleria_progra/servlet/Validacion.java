/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.muebleria_progra.servlet;

import com.mycompany.muebleria_progra.clases.Usuario;
import com.mycompany.muebleria_progra.conexion.Conexion_Sql;
import com.mycompany.muebleria_progra.manejadoresclases.Manejador_Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

/**
 *
 * @author daniel
 */
@WebServlet(name = "Validacion", urlPatterns = {"/Validacion"})
public class Validacion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String user = request.getParameter("username");
            String pass = request.getParameter("password");
        try {
            
            
            if(user=="" || pass==""){
                System.out.println(user);
                response(response, 6,request,user);
            } else{
                Manejador_Usuario mu = new Manejador_Usuario();
                ArrayList<Usuario> usuario= new ArrayList<>();
                System.out.println("error1");
                ResultSet datosObtenidos = mu.select(user);
                if (datosObtenidos.getMetaData().getColumnCount() > 0) {
                    String u = datosObtenidos.getString("nombre_usuario");
                    String c = datosObtenidos.getString("contra");
                    int tipo=datosObtenidos.getInt("tipo_usuario");
                    System.out.println(u);
                    System.out.println(c);
                    System.out.println(tipo);

                    System.out.println("null");

                    if (user.equals(u) && pass.equals(c)) {
                        response(response, tipo, request,u);
                    } else {
                        response(response,5, request,user);
                    }
                }else{
                    System.out.println("no hay ndada");
                }
            }
        }catch( NullPointerException e){
            System.out.println("p");
            e.printStackTrace();
        } 
        catch (SQLException ex) {
            response(response, 5, request,user);
        } 
        
    }
    private void response(HttpServletResponse resp, int tipo,HttpServletRequest request,String u)
			throws IOException {
        
        String destinoV="Venta/iventa.jsp";
        String destinoA="Administracion/iadministracion.jsp";
        String destinoF="Fabrica/ifabrica.jsp";
        if(tipo==1){
                resp.sendRedirect(destinoA);
        }else if(tipo==2){
            resp.sendRedirect(destinoV);
        }else if(tipo==3){
            resp.sendRedirect(destinoF);
        }else if(tipo==4){
            PrintWriter out = resp.getWriter();
             out.println("<html>");
            out.println("<head>");
            out.println(" <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<body class=\"text-center\"  style=\"background-color: beige\">");
            out.println("<t1>" + "ACTUALMENTE TU USUARIO ESTA SUSPENDIDO INTENTA COMUNICARTE CON UN ADMINISTRADOR" + "</t1>");
            out.println("<br>");
            out.println("<img class=\"mb-4\" src=\"/Muebleria_Progra/imagen/error.jpg\" alt=\"\" width=\"250\" height=\"150\">");
            out.println("<br>");
            out.println(" <a href=\"/Muebleria_Progra/Venta/iventa.jsp\"> REGRESAR</a>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>\n");
            out.println("</body>");
            out.println("</html>");
        }else if(tipo==6){
            PrintWriter out = resp.getWriter();
             out.println("<html>");
            out.println("<head>");
            out.println(" <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<body class=\"text-center\"  style=\"background-color: beige\">");
            out.println("<t1>" + "HAY CAMPOS VACIOS" + "</t1>");
            out.println("<br>");
            out.println("<img class=\"mb-4\" src=\"/Muebleria_Progra/imagen/error.jpg\" alt=\"\" width=\"250\" height=\"150\">");
            out.println("<br>");
            out.println(" <a href=\"/Muebleria_Progra/Venta/iventa.jsp\"> REGRESAR</a>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>\n");
            out.println("</body>");
            out.println("</html>");
        }else{
            PrintWriter out = resp.getWriter();
             out.println("<html>");
            out.println("<head>");
            out.println(" <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<body class=\"text-center\"  style=\"background-color: beige\">");
            out.println("<t1>" + "ERROR AL INICIO DE SESION VERIFICA EL USUARIO Y CONTRASEÑA" + "</t1>");
            out.println("<br>");
            out.println("<img class=\"mb-4\" src=\"/Muebleria_Progra/imagen/error.jpg\" alt=\"\" width=\"250\" height=\"150\">");
            out.println("<br>");
            out.println(" <a href=\"/Muebleria_Progra/Venta/iventa.jsp\"> REGRESAR</a>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>\n");
            out.println("</body>");
            out.println("</html>");
        }
		
	}

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
