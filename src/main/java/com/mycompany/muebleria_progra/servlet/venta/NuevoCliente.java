/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.muebleria_progra.servlet.venta;

import com.mycompany.muebleria_progra.clases.Cliente;
import com.mycompany.muebleria_progra.clases.Usuario;
import com.mycompany.muebleria_progra.manejadoresclases.Manejador_Cliente;
import com.mycompany.muebleria_progra.manejadoresclases.Manejador_Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daniel
 */
public class NuevoCliente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nit = request.getParameter("textnit");
        String nom= request.getParameter("textnombre");
        String direc= request.getParameter("textdireccion");
        String muni= request.getParameter("textmunicipio");
        String depa= request.getParameter("textdepartamento");
        
        if(nit=="" || nom=="" || direc==""){
            response(response, "campos vacios", request);
        }else if(muni=="" && depa==""){
            Cliente nc= new Cliente(nit,nom,direc);
                try {
                    Manejador_Cliente nu = new Manejador_Cliente();
                    ResultSet datosObtenidos=nu.select(nit);
                    
                    if (datosObtenidos.getString("nit").equals(nit) && datosObtenidos!=null) {
                         System.out.println("jejeje");
                         response(response, "cliente existente", request);
                    } else {
                         System.out.println("jijij");
                        response(response,"cliente no existente", request);
                    }
                } catch (SQLException ex) {
                    System.out.println("error");
                    this.registrar(nc,response);
                }
        }else{
            Cliente nc= new Cliente(nit,nom,direc,muni,depa);
            try {
                    Manejador_Cliente nu = new Manejador_Cliente();
                    ResultSet datosObtenidos=nu.select(nit);
                    
                    if (datosObtenidos.getString("nit").equals(nit) && datosObtenidos!=null) {
                         System.out.println("jejeje");
                         response(response, "cliente existente", request);
                    } else {
                         System.out.println("jijij");
                        response(response,"cliente no existente", request);
                    }
                } catch (SQLException ex) {
                    System.out.println("error");
                    this.registrarExtenso(nc,response);
                }
        }
    }
    
      private void response(HttpServletResponse resp, String msg, HttpServletRequest request)
            throws IOException {
        if (msg.equals("campos vacios")) {
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
            out.println("<t1>" + "Hemos detectado campos vacios" + "</t1>");
            out.println("<br>");
            out.println("<img class=\"mb-4\" src=\"imagen/error.jpg\" alt=\"\" width=\"250\" height=\"150\">");
            out.println("<br>");
            out.println(" <a href=\"InicioServlet?eleccion=ncliente\"> Volver</a>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>\n");
            out.println("</body>");
            out.println("</html>");
        } else if (msg.equals("cliente existente")) {
            PrintWriter out = resp.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println(" <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<body class=\"text-center\"  style=\"background-color: beige\" >");
            out.println("<t1>" + "Este cliente ya existe" + "</t1>");
            out.println("<br>");
            out.println("<img class=\"mb-4\" src=\"imagen/yes.png\" alt=\"\" width=\"250\" height=\"150\">");
            out.println("<br>");
            out.println(" <a href=\"CerrarSesion?eleccion=regresarV\"> REGRESAR</a>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>\n");
            out.println("</body>");
            out.println("</html>");
        }
    }
      public void registrar(Cliente cliente,HttpServletResponse resp){
           PrintWriter out;
        try {
            Manejador_Cliente nu= new Manejador_Cliente();
            nu.añadir(cliente);
            out = resp.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println(" <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<body class=\"text-center\"  style=\"background-color: beige\">");
            out.println("<t1>" + "Hemos Guardado el Usuario "+cliente.getNombre()+ "</t1>");
            out.println("<br>");
            out.println("<img class=\"mb-4\" src=\"imagen/yes.png\" alt=\"\" width=\"250\" height=\"150\">");
            out.println("<br>");
            out.println(" <a href=\"CerrarSesion?eleccion=regresarV\"> REGRESAR</a>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>\n");
            out.println("</body>");
            out.println("</html>");
        } catch (IOException ex) {
            System.out.println("error escritura");
        }
      }
      
    public void registrarExtenso(Cliente cliente, HttpServletResponse resp) {
        PrintWriter out;
        try {
            Manejador_Cliente nu = new Manejador_Cliente();
            nu.añadir_extenso(cliente);
            out = resp.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println(" <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<body class=\"text-center\"  style=\"background-color: beige\">");
            out.println("<t1>" + "Hemos Guardado el Usuario " + cliente.getNombre() + "</t1>");
            out.println("<br>");
            out.println("<img class=\"mb-4\" src=\"imagen/yes.png\" alt=\"\" width=\"250\" height=\"150\">");
            out.println("<br>");
            out.println(" <a href=\"CerrarSesion?eleccion=regresarV\"> REGRESAR</a>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>\n");
            out.println("</body>");
            out.println("</html>");
        } catch (IOException ex) {
            System.out.println("error escritura");
        }
    }
      
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
