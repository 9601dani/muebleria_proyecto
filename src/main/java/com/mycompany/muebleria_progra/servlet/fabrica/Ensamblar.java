/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.muebleria_progra.servlet.fabrica;

import com.mycompany.muebleria_progra.clases.Mueble;
import com.mycompany.muebleria_progra.clases.Mueble_Ensamblado;
import com.mycompany.muebleria_progra.manejadoresclases.Manejador_Mueble_Ensamblado;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daniel
 */
public class Ensamblar extends HttpServlet {

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
        String nomm= request.getParameter("textmueble");
        String us= request.getParameter("textnom");
        System.out.println(nomm);
        System.out.println(us);
        if (nomm == "" || us == "") {
            response(response, "campos vacios", request);
        } else {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = simpleDateFormat.format(date);
            java.sql.Date date1 = java.sql.Date.valueOf(formattedDate);
            Mueble_Ensamblado mueble = new Mueble_Ensamblado(date1, us, nomm);
            Mueble_Ensamblado me;
            Manejador_Mueble_Ensamblado mme = new Manejador_Mueble_Ensamblado();
            System.out.println("-------");
            try {
                String re=mme.verificacion(mueble);
                if(re.equalsIgnoreCase("SE GUARDO")){
                        response(response,"guardado ok", request);
                }else{
                     response(response,"error", request);
                }
            } catch (SQLException e) {
                response(response, "error", request);
                System.out.println(e);
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
            out.println(" <a href=\"/Muebleria_Progra/Fabrica/ifabrica.jsp\"> REGRESAR</a>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>\n");
            out.println("</body>");
            out.println("</html>");
        } else if (msg.equals("error")) {
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
            out.println("<t1>" + "Actualmente no hay piezas disponibles para el ensamble"+"</t1>");
            out.println("<br>");
            out.println("<img class=\"mb-4\" src=\"/Muebleria_Progra/imagen/error.jpg\" alt=\"\" width=\"250\" height=\"150\">");
            out.println("<br>");
            out.println(" <a href=\"/Muebleria_Progra/Fabrica/ifabrica.jsp\"> REGRESAR</a>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>\n");
            out.println("</body>");
            out.println("</html>");
        }
        else if (msg.equals("guardado ok")) {
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
            out.println("<t1>" + "Hemos registrado el mueble"+"</t1>");
            out.println("<br>");
            out.println("<img class=\"mb-4\" src=\"/Muebleria_Progra/imagen/yes.png\" alt=\"\" width=\"250\" height=\"150\">");
            out.println("<br>");
            out.println(" <a href=\"/Muebleria_Progra/Fabrica/ifabrica.jsp\"> REGRESAR</a>");
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
