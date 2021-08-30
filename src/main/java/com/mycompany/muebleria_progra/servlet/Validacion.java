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
                response(response, 6,request);
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
                        response(response, tipo, request);
                    } else {
                        response(response,5, request);
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
            response(response, 5, request);
        } 
        
    }
    private void response(HttpServletResponse resp, int tipo,HttpServletRequest request)
			throws IOException {
        
        String destinoV="Venta/iventa.jsp";
        String destinoA="Administracion/iadministracion.jsp";
        String destinoF="Fabrica/ifabrica.jsp";
        if(tipo==1){
            
            RequestDispatcher salida= request.getRequestDispatcher(destinoA);
            try {
                salida.forward(request, resp);
            } catch (ServletException ex) {
                System.out.println("error");
            }
        }else if(tipo==2){
             RequestDispatcher salida= request.getRequestDispatcher(destinoV);
             try {
                salida.forward(request, resp);
            } catch (ServletException ex) {
                System.out.println("error");
            }
        }else if(tipo==3){
             RequestDispatcher salida= request.getRequestDispatcher(destinoF);
             try {
                salida.forward(request, resp);
            } catch (ServletException ex) {
                System.out.println("error");
            }
        }else if(tipo==4){
             PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<t1>" + "Actualmente tu usuario esta suspendido comunicate con un administrador" + "</t1>");
                out.println("<p>");
                out.println(" <a href=\"CerrarSesion?eleccion=inicio\"> REGRESAR</a>");
                out.println("</body>");
		out.println("</html>");
        }else if(tipo==6){
            
            PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<t1>" + "Datos Vacios" + "</t1>");
                out.println("<p>");
                out.println(" <a href=\"CerrarSesion?eleccion=inicio\"> REGRESAR</a>");
		out.println("</body>");
		out.println("</html>");
        }else{
             PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<t1>" + "Login Incorrecto VERIFICA LOS DATOS INGRESADOS" + "</t1>");
                out.println("<p>");
                out.println(" <a href=\"CerrarSesion?eleccion=inicio\"> REGRESAR</a>");
		out.println("</body>");
		out.println("</html>");
        }
		
	}

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
