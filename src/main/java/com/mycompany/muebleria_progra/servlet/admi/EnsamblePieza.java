/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.muebleria_progra.servlet.admi;

import com.mycompany.muebleria_progra.clases.Cliente;
import com.mycompany.muebleria_progra.clases.Ensamble_Pieza;
import com.mycompany.muebleria_progra.manejadoresclases.Manejador_Cliente;
import com.mycompany.muebleria_progra.manejadoresclases.Manejador_Ensamble_Pieza;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class EnsamblePieza extends HttpServlet {

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
        String nom = request.getParameter("textnom");
        String pieza = request.getParameter("texttipo");
        String cant = request.getParameter("textcan");
        System.out.println(nom);
        System.out.println(pieza);
        System.out.println(cant);
        if (nom == "" || pieza == "" || cant == "") {
            response(response, "campos vacios", request);
        } else {
            Ensamble_Pieza np = new Ensamble_Pieza(Integer.parseInt(cant), pieza, nom);
            Ensamble_Pieza n = new Ensamble_Pieza();
            try {
                ResultSet datosObtenidos = np.select(nom, pieza);

                if (datosObtenidos.getString("nombre_mueble").equalsIgnoreCase(nom) && datosObtenidos.getString("tipo_pieza").equalsIgnoreCase(pieza) && datosObtenidos != null) {
                    System.out.println("jejeje");
                    response(response, "existe", request);
                } else {
                    System.out.println("jijij");
                    response(response, "cliente no existente", request);
                }
            } catch (SQLException ex) {
                try {
                    System.out.println("error");
                    System.out.println(np.getNombre_mueble());
                    System.out.println(np.getTipo_pieza());
                    System.out.println(np.getCantidad());
                    Manejador_Ensamble_Pieza mc= new Manejador_Ensamble_Pieza();
                    mc.añadir(np);
                    response(response, "exito", request);
                } catch (SQLException ex1) {
                    System.out.println("errrrrrrr");
                }
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
            out.println("<img class=\"mb-4\" src=\"/Muebleria_Progra/imagen/error.jpg\" alt=\"\" width=\"250\" height=\"150\">");
            out.println("<br>");
            out.println(" <a href=\"/Muebleria_Progra/Administracion/iadministracion.jsp\"> Volver</a>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>\n");
            out.println("</body>");
            out.println("</html>");
        } else if (msg.equals("existe")) {
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
            out.println("<t1>" + "Este registro ya esta asignado" + "</t1>");
            out.println("<br>");
            out.println("<img class=\"mb-4\" src=\"/Muebleria_Progra/imagen/error.jpg\" alt=\"\" width=\"250\" height=\"150\">");
            out.println("<br>");
            out.println(" <a href=\"/Muebleria_Progra/Administracion/iadministracion.jsp\"> REGRESAR</a>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>\n");
            out.println("</body>");
            out.println("</html>");
        }else if (msg.equals("exito")) {
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
            out.println("<t1>" + "Se registro correctamente" + "</t1>");
            out.println("<br>");
            out.println("<img class=\"mb-4\" src=\"/Muebleria_Progra/imagen/yes.png\" alt=\"\" width=\"250\" height=\"150\">");
            out.println("<br>");
            out.println(" <a href=\"/Muebleria_Progra/Administracion/iadministracion.jsp\"> REGRESAR</a>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>\n");
            out.println("</body>");
            out.println("</html>");
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
